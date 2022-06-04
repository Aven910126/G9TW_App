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
                .baseUrl("https://fa31-2001-b011-b800-30e7-1495-6130-b40d-1faf.ngrok.io/api/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserSevice getService(){
        UserSevice userSevice = getRetrofit().create(UserSevice.class);
        return userSevice;
    }











}
