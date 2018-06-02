package com.example.madhurbhargava.recyclerviewjava;

import com.example.madhurbhargava.recyclerviewjava.model.DataError;

import org.junit.Test;

public class DataErrorMessageTests {

    @Test
    public void testErrorMessage() {
        DataError msg = new DataError("Error");
        assert (msg.getErrorMessage()).equals("Error");
        msg.setErrorMessage("SomeError");
        assert (msg.getErrorMessage()).equals("SomeError");
    }
}
