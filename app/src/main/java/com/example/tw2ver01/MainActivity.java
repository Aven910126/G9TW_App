package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
//import com.example.tw2ver01.dao.UserDao;




public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    Button reg,login,live,btngps,emycbtn,hebtbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg = findViewById(R.id.reg);
        login = findViewById(R.id.login);
        live = findViewById(R.id.live);
        btngps = findViewById(R.id.btngps);
        emycbtn = findViewById(R.id.emycbtn);
        hebtbtn = findViewById(R.id.hebtbtn);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_register.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_login.class));
            }
        });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_Liveimage.class));
            }
        });

        btngps.setOnClickListener(new View.OnClickListener() {
            private String data;
            private Double longitude1;
            private Double latitude1;
            Bundle bundle = new Bundle();

            public void find(){
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create( "",mediaType);
                Request request = new Request.Builder()
                        .url("https://8b8d-2001-b011-b800-d98b-84a4-361a-da0a-d6ed.ngrok.io/api/Gps/now/1")
                        .addHeader("Content-Type", "application/json")
                        .build();
                Response response;

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // 連線成功
                        String result = response.body().string();
                        Log.d("OkHttp result", result);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        data = jsonObject.toString();
                        try {
                            longitude1 = Double.parseDouble(jsonObject.getString("longitude"));
                            latitude1 = Double.parseDouble(jsonObject.getString("latitude"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        System.out.println(longitude1);
                        System.out.println(latitude1);
                        System.out.println(data);
                    }
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println(request);
                    }
                });

            }
            @Override
            public void onClick(View view) {
                find();
//                bundle.putDouble("longitude",longitude1);
//                bundle.putDouble("latitude",latitude1);
                Intent intent = new  Intent(MainActivity.this,page_maps1.class);
//                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        emycbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_emergency_input.class));
            }
        });

        hebtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_heartbeat.class));
            }
        });


        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.e("Tag","=====>"+loginResponse.getEmail());
        }
    }



    final Handler hand1 = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                Toast.makeText(getApplicationContext(),"登入成功",Toast.LENGTH_LONG).show();

            }
            else
            {
                Toast.makeText(getApplicationContext(),"登入失敗",Toast.LENGTH_LONG).show();
            }
        }
    };
}

