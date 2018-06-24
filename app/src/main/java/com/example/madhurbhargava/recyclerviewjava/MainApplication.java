package com.example.madhurbhargava.recyclerviewjava;

import android.app.Application;

import com.example.madhurbhargava.recyclerviewjava.components.DaggerMainPresenterComponent;
import com.example.madhurbhargava.recyclerviewjava.components.MainPresenterComponent;
import com.example.madhurbhargava.recyclerviewjava.modules.MainPresenterModule;
import com.example.madhurbhargava.recyclerviewjava.view.MainPresenterImpl;


public class MainApplication extends Application {

    MainPresenterComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //component = DaggerMainPresenterComponent.builder().;
        component = DaggerMainPresenterComponent.builder().mainPresenterModule(new MainPresenterModule()).build();


    }

    public MainPresenterComponent getMainPresenterComponent() {
        return component;
    }
}
