package com.example.tw2ver01;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSevice {
    @POST("authenticate/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("user/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequset);
}
