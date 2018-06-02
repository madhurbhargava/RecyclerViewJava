package com.example.madhurbhargava.recyclerviewjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.R;
import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter presenter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //Earlier We would have rely on the following variables to introduce paging but now we have a Paging Library as a part of Jetpack
                Log.i("MainActivity", "onScrolled::getChildCount"+mRecyclerView.getLayoutManager().getChildCount());//number of visible items
                Log.i("MainActivity", "onScrolled::getItemCount"+mRecyclerView.getLayoutManager().getItemCount());//number of total items
                Log.i("MainActivity", "onScrolled::firstVisibleItemPosition"+((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition());
                Log.i("MainActivity", "onScrolled::lastVisibleItemPosition"+((LinearLayoutManager)mRecyclerView.getLayoutManager()).findLastVisibleItemPosition());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.fetchCryptoData(0, 50);
    }

    @Override
    public void showData(List<Cryptocurrency> currencies) {
        RecyclerView.Adapter adapter = new CryptoAdapter(currencies);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(DataError error) {
        Log.i(MainActivity.class.toString(), error.getErrorMessage());
    }
}
