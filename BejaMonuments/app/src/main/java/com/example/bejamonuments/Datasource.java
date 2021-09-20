package com.example.bejamonuments;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datasource {

    private static final String ENDPOINT = "https://my-json-server.typicode.com/D-s15/Estagio/";

    private static final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();

    private static AppService appService;

    public static AppService getAppService(){
        if (appService == null) appService = retrofit.create(AppService.class);

        return appService;
    }
}
