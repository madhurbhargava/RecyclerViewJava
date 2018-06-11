package com.example.madhurbhargava.recyclerviewjava.paging;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

public class CryptoCurrencyDataSource extends ItemKeyedDataSource<Integer, Cryptocurrency> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Cryptocurrency> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Cryptocurrency> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Cryptocurrency> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Cryptocurrency item) {
        return item.getRank();
    }
}
