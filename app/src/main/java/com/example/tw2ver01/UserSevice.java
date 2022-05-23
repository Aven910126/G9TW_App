package com.example.tw2ver01;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSevice {
    @POST("account/login/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("account/create/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequset);


}
