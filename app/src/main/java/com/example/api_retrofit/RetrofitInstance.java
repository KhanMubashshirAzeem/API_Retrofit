package com.example.api_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance instance;
    private API_interface apiInterface;

    private RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") // Corrected base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(API_interface.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

    public API_interface getApiInterface() {
        return apiInterface;
    }
}
