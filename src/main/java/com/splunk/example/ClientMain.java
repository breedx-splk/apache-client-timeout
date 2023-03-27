package com.splunk.example;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.http.client.config.RequestConfig.custom;

public class ClientMain {

    public static void main(String[] args) throws Exception {
        while(true) {
            try {
                doRequest();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void doRequest() throws IOException {
        RequestConfig config = custom().setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .build();

        HttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        context.setRequestConfig(config);

        HttpGet httpGet = new HttpGet("http://localhost:8666");
        httpClient.execute(httpGet, response -> {
            System.out.println(response);
            return "wat";
        }, context);
    }
}
