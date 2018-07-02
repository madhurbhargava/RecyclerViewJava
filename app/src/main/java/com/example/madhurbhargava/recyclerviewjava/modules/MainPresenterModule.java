package com.example.madhurbhargava.recyclerviewjava.modules;

import com.example.madhurbhargava.recyclerviewjava.view.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {

    @Provides
    static MainPresenterImpl provideMainPresenter() {
        return new MainPresenterImpl();
    }
}
