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

public class MainPresenterImpl implements MainPresenter, MainPresenter.DataUpdater {

    public LiveData<PagedList<Cryptocurrency>> userList;
    private MainView view;
    LiveData<ItemKeyedCryptoDataSource> dataSource;
    Executor executor;

    public MainPresenterImpl(MainView view) {
        this.view = view;

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();

        CryptocurrencyDataSourceFactory dataSourceFactory = new CryptocurrencyDataSourceFactory(this);
        dataSource = dataSourceFactory.getMutableLiveData();
        userList = (new LivePagedListBuilder(dataSourceFactory, pagedListConfig))
                .build();

    }

    @Override
    public void fetchCryptoData(int start, int limit) {
        //CryptoRepository.getInstance(this).fetchCryptoData(start, limit);
    }

    @Override
    public void onDataReceived(List<Cryptocurrency> currencies) {
        view.showData(currencies);
    }

    @Override
    public void onDataFetchFailed(DataError error) {
        view.showError(error);
    }
}
