package com.example.madhurbhargava.recyclerviewjava;

import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;
import com.example.madhurbhargava.recyclerviewjava.network.CryptoRepository;
import com.example.madhurbhargava.recyclerviewjava.network.RetrofitClientInstance;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static junit.framework.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CryptoRepositoryTests {

    private CryptoRepository repository;
    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        repository = CryptoRepository.getInstance();
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("[\n" +
                "  {\n" +
                "    \"id\": \"bitcoin\",\n" +
                "    \"name\": \"Bitcoin\",\n" +
                "    \"symbol\": \"BTC\",\n" +
                "    \"rank\": \"1\",\n" +
                "    \"price_usd\": \"7370.55\",\n" +
                "    \"price_btc\": \"1.0\",\n" +
                "    \"24h_volume_usd\": \"4873180000.0\",\n" +
                "    \"market_cap_usd\": \"125777234350\",\n" +
                "    \"available_supply\": \"17064837.0\",\n" +
                "    \"total_supply\": \"17064837.0\",\n" +
                "    \"max_supply\": \"21000000.0\",\n" +
                "    \"percent_change_1h\": \"0.13\",\n" +
                "    \"percent_change_24h\": \"-1.5\",\n" +
                "    \"percent_change_7d\": \"-3.14\",\n" +
                "    \"last_updated\": \"1527721172\"\n" +
                "  }\n" +
                "]"));
    }

    @Test
    public void testServerRequests() throws Exception {
        RetrofitClientInstance.BASE_URL = mockWebServer.url("/").toString();
        RecordedRequest request = this.mockWebServer.takeRequest();
        assertTrue(request.getMethod().equals("GET"));
        assertTrue(request.getPath().contains("ticker"));
    }

    @Test
    public void testOnResponseReceived() throws Exception {

    }

    @Test
    public void testOnFailure() {

    }
}


