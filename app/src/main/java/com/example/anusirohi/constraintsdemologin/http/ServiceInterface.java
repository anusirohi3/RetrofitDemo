package com.example.anusirohi.constraintsdemologin.http;

import com.example.anusirohi.constraintsdemologin.model.register.RegisterRequest;
import com.example.anusirohi.constraintsdemologin.model.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceInterface {

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);
}
