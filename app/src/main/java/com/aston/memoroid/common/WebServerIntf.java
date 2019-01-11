package com.aston.memoroid.common;

import com.aston.memoroid.model.Exemple;
import com.aston.memoroid.model.UserJava;
import com.aston.memoroid.model.UserKt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServerIntf {

    @GET("5c2542a7300000540067f4ec")
    Call<Exemple> getMyExample();

    @GET("5c3860083100006900a98f9f")
    Call<UserKt> getUser();
}
