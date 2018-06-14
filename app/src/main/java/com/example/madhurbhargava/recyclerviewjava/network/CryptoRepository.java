package com.example.madhurbhargava.recyclerviewjava.network;

import android.util.Log;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;

import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CryptoRepository {

    private static final Object LOCK = new Object();

    private static CryptoRepository sRepository;

    private CryptoRepository() {

    }

    public synchronized static CryptoRepository getInstance() {
        if(sRepository == null) {
            synchronized (LOCK) {
                if(sRepository == null) {
                    sRepository = new CryptoRepository();
                }
            }
        }
        return sRepository;
    }

    public GetCryptoDataService createCryptoDataService(){
        return RetrofitClientInstance.getInstance().create(GetCryptoDataService.class);
    }
}
