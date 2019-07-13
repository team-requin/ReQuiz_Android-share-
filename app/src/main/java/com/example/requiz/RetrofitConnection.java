package com.example.requiz;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    String URL = "http://api.teamrequin.kro.kr";

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    JsonLoginApi sever = retrofit.create(JsonLoginApi.class);

    JsonLoginApi jsonPlaceHolderApi = retrofit.create(JsonLoginApi.class);
//    Call<List<LoginPost>> call = jsonPlaceHolderApi.getPost();

//                    call.enqueue(new Callback<List<LoginPost>>() {
//        @Override
//        public void onResponse(Call<List<LoginPost>> call, Response<List<LoginPost>> response) {
//
//            if (response.body().equals(201)) {
//                Intent intent= new Intent(Login.this, Sign_up.class);
//                startActivity(intent);
//            }
//        }
//
//        @Override
//        public void onFailure(Call<List<LoginPost>> call, Throwable t) {
//            Intent intent= new Intent(Login.this, Sign_up.class);
//            startActivity(intent);
//        }
//    });
}
