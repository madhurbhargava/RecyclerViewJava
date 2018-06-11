package com.example.madhurbhargava.recyclerviewjava.paging;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

public class CryptoCurrencyDataSource extends ItemKeyedDataSource<Long, Cryptocurrency> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Cryptocurrency> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Cryptocurrency> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Cryptocurrency> callback) {

    }

    @NonNull
    @Override
    public Long getKey(@NonNull Cryptocurrency item) {
        return null;
    }
}
