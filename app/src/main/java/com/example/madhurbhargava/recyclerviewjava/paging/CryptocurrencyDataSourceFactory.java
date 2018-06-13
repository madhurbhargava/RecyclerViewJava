package com.example.madhurbhargava.recyclerviewjava.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

public class CryptocurrencyDataSourceFactory extends DataSource.Factory {

    MutableLiveData<ItemKeyedCryptoDataSource> mutableLiveData;
    ItemKeyedCryptoDataSource itemKeyedCryptoDataSource;


    public CryptocurrencyDataSourceFactory() {
        mutableLiveData = new MutableLiveData<ItemKeyedCryptoDataSource>();
    }

    @Override
    public DataSource create() {
        itemKeyedCryptoDataSource = new ItemKeyedCryptoDataSource();
        mutableLiveData.postValue(itemKeyedCryptoDataSource);
        return itemKeyedCryptoDataSource;
    }
}
