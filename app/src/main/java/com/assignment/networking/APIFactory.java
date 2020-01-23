package com.assignment.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIFactory {

    public APIs getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hn.algolia.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIs.class);
    }
}
