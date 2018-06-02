package com.example.madhurbhargava.recyclerviewjava.network;

import android.util.Log;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.view.MainPresenter;

import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface CryptoFetcher {
    void fetchCryptoData(int start, int limit);
}

public class CryptoRepository implements CryptoFetcher {

    private static final Object LOCK = new Object();

    private static CryptoRepository sRepository;

    private final MainPresenter.DataUpdater updater;

    private CryptoRepository(MainPresenter.DataUpdater updater) {
        this.updater = updater;
    }

    public synchronized static CryptoRepository getInstance(MainPresenter.DataUpdater updater) {
        if(sRepository == null) {
            synchronized (LOCK) {
                if(sRepository == null) {
                    sRepository = new CryptoRepository(updater);
                }
            }
        }
        return sRepository;
    }

    @Override
    public void fetchCryptoData(int start, int limit) {
        GetCryptoDataService service = RetrofitClientInstance.getInstance().create(GetCryptoDataService.class);
        Call<List<Cryptocurrency>> call = service.getAllCryptos(start, limit);
        call.enqueue(new Callback<List<Cryptocurrency>>() {
            @Override
            public void onResponse(Call<List<Cryptocurrency>> call, Response<List<Cryptocurrency>> response) {
                updater.onDataReceived(response.body());
            }

            @Override
            public void onFailure(Call<List<Cryptocurrency>> call, Throwable t) {
                updater.onDataFetchFailed(new DataError(t.getMessage()));
            }
        });
    }
}
