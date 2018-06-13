package com.example.madhurbhargava.recyclerviewjava.paging;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.network.CryptoRepository;
import com.example.madhurbhargava.recyclerviewjava.network.GetCryptoDataService;
import com.example.madhurbhargava.recyclerviewjava.view.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemKeyedCryptoDataSource extends ItemKeyedDataSource<Integer, Cryptocurrency> {

    GetCryptoDataService service;

    public ItemKeyedCryptoDataSource(MainPresenter.DataUpdater updater) {
        service = CryptoRepository.getInstance(updater).createCryptoDataService();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Cryptocurrency> callback) {
        service.getAllCryptos(1, params.requestedLoadSize).
                enqueue(new Callback<List<Cryptocurrency>>() {

                    @Override
                    public void onResponse(Call<List<Cryptocurrency>> call, Response<List<Cryptocurrency>> response) {


                    }


                    @Override
                    public void onFailure(Call<List<Cryptocurrency>> call, Throwable t) {


                    }

                });
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