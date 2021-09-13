package com.example.bejamonuments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AppService {

    @GET("monuments/{id}")
    Call<Monument> getMonument(@Path("id") long id);

    @GET("monuments")
    Call<List<Monument>> getMonumentList();

    @GET("interestpoints/{id}")
    Call<InterestPoint> getInterestPoint(@Path("id") long id);

    @GET("interestPointsByMonumentId")
    Call<List<InterestPoint>> getInterestPointsByMonumentId(@Query("monumentId") long id);

}
