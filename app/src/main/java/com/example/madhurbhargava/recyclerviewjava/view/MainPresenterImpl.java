package com.example.madhurbhargava.recyclerviewjava.view;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.view.View;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.network.CryptoRepository;

import java.util.List;

public class MainPresenterImpl implements MainPresenter, MainPresenter.DataUpdater {

    public LiveData<PagedList<Cryptocurrency>> userList;
    private MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void fetchCryptoData(int start, int limit) {
        CryptoRepository.getInstance(this).fetchCryptoData(start, limit);
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
