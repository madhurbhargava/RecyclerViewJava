package com.example.madhurbhargava.recyclerviewjava.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.example.madhurbhargava.recyclerviewjava.view.MainPresenter;

public class CryptocurrencyDataSourceFactory extends DataSource.Factory {

    MutableLiveData<ItemKeyedCryptoDataSource> mutableLiveData;
    ItemKeyedCryptoDataSource itemKeyedCryptoDataSource;
    MainPresenter.DataUpdater updater;


    public MutableLiveData<ItemKeyedCryptoDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

    public CryptocurrencyDataSourceFactory(MainPresenter.DataUpdater updater) {
        mutableLiveData = new MutableLiveData<ItemKeyedCryptoDataSource>();
        this.updater = updater;

    }

    @Override
    public DataSource create() {
        itemKeyedCryptoDataSource = new ItemKeyedCryptoDataSource(updater);
        mutableLiveData.postValue(itemKeyedCryptoDataSource);
        return itemKeyedCryptoDataSource;
    }
}
