package com.example.tw2ver01;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClinent {
    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://9107-2001-b011-b800-5984-59c9-83e5-53aa-a6ff.ngrok.io/api/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserSevice getService(){
        UserSevice userSevice = getRetrofit().create(UserSevice.class);
        return userSevice;
    }











}
