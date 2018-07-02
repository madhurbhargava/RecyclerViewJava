package com.example.madhurbhargava.recyclerviewjava;

import android.app.Application;

import com.example.madhurbhargava.recyclerviewjava.components.DaggerMainPresenterComponent;
import com.example.madhurbhargava.recyclerviewjava.components.MainPresenterComponent;
import com.example.madhurbhargava.recyclerviewjava.modules.MainPresenterModule;


public class MainApplication extends Application {

    MainPresenterComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainPresenterComponent.builder().mainPresenterModule(new MainPresenterModule()).build();
    }

    public MainPresenterComponent getMainPresenterComponent() {
        return mainComponent;
    }
}
