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
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.fetchCryptoData();
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
