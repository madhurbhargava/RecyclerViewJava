package com.example.madhurbhargava.recyclerviewjava.components;

import com.example.madhurbhargava.recyclerviewjava.modules.MainPresenterModule;
import com.example.madhurbhargava.recyclerviewjava.view.MainActivity;

import dagger.Component;

@Component(modules = MainPresenterModule.class)
public interface MainPresenterComponent {

    void inject(MainActivity activity);
}
