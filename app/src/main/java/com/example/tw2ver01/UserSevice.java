package com.example.tw2ver01;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSevice {
    @POST("authenticate/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("create/")
    Call<RegisterResponse> registerUser(@Body JSONObject registerRequset);
}
