package com.example.madhurbhargava.recyclerviewjava;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.model.DataError;
import com.example.madhurbhargava.recyclerviewjava.view.MainActivity;
import com.example.madhurbhargava.recyclerviewjava.view.MainPresenter;
import com.example.madhurbhargava.recyclerviewjava.view.MainPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTests {

    @Mock
    MainPresenter.MainView view;

    MainPresenter.DataUpdater presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenterImpl(view);
    }

    @Test
    public void testDataReceiptSuccess() {

        ArrayList<Cryptocurrency> list = new ArrayList<>();
        list.add(new Cryptocurrency("btc", "bitcoin", 23.45, "btc"));

        //when
        presenter.onDataReceived(list);

        //then
        Mockito.verify(view, Mockito.times(1)).showData(list);
    }

    @Test
    public void testDataReceiptFailure() {
        DataError error = new DataError("Error");

        //when
        presenter.onDataFetchFailed(error);

        //then
        Mockito.verify(view, Mockito.times(1)).showError(error);
    }

}
