package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class page_heartbeat extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    TextView heartoutcome;

    String jsonText,heartbeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_heartbeat);
        heartoutcome = findViewById(R.id.heartoutcome);



        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create( "",mediaType);
        Request request = new Request.Builder()
                .url("https://20a8-2001-b011-b800-d98b-159a-1c02-67ee-c6bd.ngrok.io/api/HeartBeat/now/1")
//                .method("GET", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 連線成功
                String result = response.body().string();
//                heartoutcome.setText(result);
                System.out.println(result);
//                Log.d("OkHttp result", result);

                    try {
                        //建立一個JSONObject並帶入JSON格式文字，getString(String key)取出欄位的數值 heartBeatValue
                        JSONObject jsonObject = new JSONObject(jsonText);
                        heartbeat = jsonObject.getString("heartBeatValue");
                        System.out.println(heartbeat);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

            }
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(request);
            }
        });


    }
}