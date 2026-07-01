package com.mockito.basics;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        // Business logic wrapper calling the external dependency
        String data = externalApi.getData();
        return "Processed: " + data;
    }
}