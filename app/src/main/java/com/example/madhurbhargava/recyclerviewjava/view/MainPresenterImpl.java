package com.example.madhurbhargava.recyclerviewjava.view;

import android.arch.lifecycle.LiveData;
import android.arch.paging.ItemKeyedDataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.view.View;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.network.CryptoRepository;
import com.example.madhurbhargava.recyclerviewjava.paging.CryptocurrencyDataSourceFactory;
import com.example.madhurbhargava.recyclerviewjava.paging.ItemKeyedCryptoDataSource;

import java.util.List;
import java.util.concurrent.Executor;

public class MainPresenterImpl {

    public LiveData<PagedList<Cryptocurrency>> userList;

    public MainPresenterImpl() {

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();

        CryptocurrencyDataSourceFactory dataSourceFactory = new CryptocurrencyDataSourceFactory();
        userList = (new LivePagedListBuilder(dataSourceFactory, pagedListConfig))
                .build();

    }
}
