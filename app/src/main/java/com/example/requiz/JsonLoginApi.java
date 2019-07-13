package com.example.requiz;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonLoginApi {

    @POST("/auth/login")
    @Headers("Accept: application/json")
    Call<Token> login(@Body JsonObject jsonObject);

    @POST("/auth/register")
    @Headers("Accept: application/json")
    Call<Void> register(@Body JsonObject jsonObject);

    @POST("/auth/check-same-name")
    @Headers("Accept: application/json")
    Call<Void> checkSameName(@Body JsonObject jsonObject);

    @POST("/auth/sameaccount")
    @Headers("Accept: application/json")
    Call<Void> checkSameId(@Body JsonObject jsonObject);

}