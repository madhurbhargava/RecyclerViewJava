package com.example.madhurbhargava.recyclerviewjava.modules;

import com.example.madhurbhargava.recyclerviewjava.view.CryptoAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class CryptoAdapterModule {

    @Provides
    static CryptoAdapter provideCryptoAdapter() {
        return new CryptoAdapter();
    }
}
