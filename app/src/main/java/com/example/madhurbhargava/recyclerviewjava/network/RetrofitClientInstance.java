package com.example.madhurbhargava.recyclerviewjava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit sInstance;
    public static String BASE_URL = "https://api.coinmarketcap.com/v1/";

    private static Object LOCK = new Object();

    public static Retrofit getInstance() {
        if(sInstance == null) {
            synchronized (LOCK) {
                if(sInstance == null) {
                    sInstance = new retrofit2.Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return sInstance;
    }
}
