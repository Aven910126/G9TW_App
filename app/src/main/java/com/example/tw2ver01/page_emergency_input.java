package com.example.tw2ver01;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
//import okhttp3.MediaType;

public class page_emergency_input extends AppCompatActivity {
    public Button btnConfirm;
    public boolean check = false;
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_page_emergency_input);
        btnConfirm = findViewById(R.id.button);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //創建JSON物件
                JSONObject jsonObject = new JSONObject();
                Bundle bundle = new Bundle();
                EditText name = (EditText) findViewById(R.id.name);
                EditText re = (EditText) findViewById(R.id.call);
                EditText phone = (EditText) findViewById(R.id.phone);
                String devicecode = "0122";

                try{
                    //把資料存到JSON
                    jsonObject.put("contactNo", phone.getText().toString());
                    jsonObject.put("contactPerson", name.getText().toString());
                    jsonObject.put("deviceCode", "0122");
                    jsonObject.put("relationship", re.getText().toString());
                    System.out.println(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(jsonObject.toString(),mediaType);
                Request request = new Request.Builder()
                        //API網址
                        .url("https://f29a-2001-b011-b800-d081-d8b0-f30d-ecb6-1d0e.jp.ngrok.io/api/EmergencyContact/create")
                        //使用的方法
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .build();
                Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            // 連線成功
                            String result = response.body().string();
                            Log.d("OkHttp result", result);
                            System.out.println(result.getClass());
                            System.out.println(result);
                            if(response.code() == 200){
                                check = true;
                            }
                            else{
                                check = false;
                            }
                        }
                        @Override
                        public void onFailure(Call call, IOException e) {
                            // 連線失敗
                            System.out.println(request);
                        }
                    });
                String result1;
                if(check){
                    result1 = "創建成功";
                } else{
                    result1 = "創建失敗，資料重複";
                }
                bundle.putString("result1",result1);
                Intent intent = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
