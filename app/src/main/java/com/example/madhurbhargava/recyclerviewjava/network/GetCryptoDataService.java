package com.example.madhurbhargava.recyclerviewjava.network;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetCryptoDataService {

    @GET("ticker")
    Call<List<Cryptocurrency>> getAllCryptos();
}
