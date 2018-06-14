package com.example.madhurbhargava.recyclerviewjava.view;

import android.arch.paging.PagedListAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.R;
import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private MainPresenterImpl presenter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final PagedListAdapter adapter = new CryptoAdapter();

        presenter.userList.observe(this, pagedList -> {
            adapter.submitList(pagedList);
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
