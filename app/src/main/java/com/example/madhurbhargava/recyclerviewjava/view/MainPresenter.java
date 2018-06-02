package com.example.madhurbhargava.recyclerviewjava.view;

import com.example.madhurbhargava.recyclerviewjava.network.CryptoRepository;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

import java.util.List;

public interface MainPresenter {
    interface View {
        void showData(List<Cryptocurrency> currencies);
        void showError(DataError error);
    }
    void fetchCryptoData(int start, int limit);
    interface DataUpdater {
        void onDataReceived(List<Cryptocurrency> currencies);
        void onDataFetchFailed(DataError error);
    }
}
