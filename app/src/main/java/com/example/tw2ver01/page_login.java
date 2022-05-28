package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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


public class page_login extends AppCompatActivity {
    Button btnlogin;
    EditText inputemail,inputpwd;
    TextView createAcc;
    OkHttpClient client = new OkHttpClient().newBuilder().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_login);

        btnlogin = findViewById(R.id.btnlogin);
        inputemail = findViewById(R.id.inputemail);
        inputpwd = findViewById(R.id.inputpwd);
        createAcc = findViewById(R.id.createAcc);

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(page_login.this,page_register.class));

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            private String pwd;
            private String email;
            private String value;

            @Override
            public void onClick(View v) {

                class login extends AsyncTask<Void, Void,String> {
                    OkHttpClient client = new OkHttpClient();
                    @Override
                    protected String doInBackground(Void... voids) {
                        String result = null;
                        JSONObject jsonObject = new JSONObject();
                        EditText inputemail = (EditText)findViewById(R.id.inputemail);
                        EditText inputpwd = (EditText)findViewById(R.id.inputpwd);
                        try {

                            jsonObject.put("email", inputemail.getText().toString());
                            jsonObject.put("password", inputpwd.getText().toString());
                            System.out.println(jsonObject);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                     MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                     RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);
                     Request request = new Request.Builder()
                            .url("https://d2ee-2001-b011-b800-5984-b1d2-a7b1-8432-d029.ngrok.io/api/EmergencyContact/login")
                            .method("POST", body)
                            .build();

                     Call call = client.newCall(request);

                        try (Response response = client.newCall(request).execute()) {
                            if (response.code() == 200) {

                                result = response.body().string();
                                 jsonObject = new JSONObject(result);
                                JSONObject data = jsonObject.getJSONObject("deviceCode");
                                long devicecode = data.getLong("deviceCode");
                                boolean bind = data.getBoolean("bind");
                                if(bind ==false) {

                                    OkHttpClient client = new OkHttpClient();
                                    jsonObject = new JSONObject();
                                    try {
                                        jsonObject.put("bind", true);
                                        jsonObject.put("deviceCode", devicecode);
                                        System.out.println(jsonObject);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    MediaType a = MediaType.parse("application/json; charset=utf-8");
                                    RequestBody b = RequestBody.create(jsonObject.toString(), a);
                                    Request re = new Request.Builder()
                                            .url("https://d2ee-2001-b011-b800-5984-b1d2-a7b1-8432-d029.ngrok.io/api/Device/create/1")
                                            .method("PATCH", b)
                                            .build();
                                    try (Response rp = client.newCall(re).execute()) {
                                        if (rp.code() == 200) {

                                            String result1 = rp.body().string();
                                            jsonObject = new JSONObject(result1);
                                            System.out.println(result1);
                                        }
                                    } catch (IOException | JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                System.out.println("fail");
                            }
                            }
                         catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                        return result;
                    }

                    protected void onPostExecute(String result) {
                        System.out.println(result);
                        if (result != null){
                            startActivity(new Intent(page_login.this,MainActivity.class));
                        }
                        else{
                            String message = "密碼錯誤";
                            Toast.makeText(page_login.this,message,Toast.LENGTH_LONG).show();
                        }
                    }
                    }
                new login().execute();
                }




//
//                JSONObject jsonObject = new JSONObject();
//                Bundle bundle = new Bundle();
//                EditText inputemail = findViewById(R.id.inputemail);
//                EditText inputpwd = findViewById(R.id.inputpwd);
//                String mail = inputemail.getText().toString();
//                String pwd = inputpwd.getText().toString();
//
//
//                bundle.putString("email", mail);
//                bundle.putString("password", pwd);
//
//                try {
//
//                    jsonObject.put("email", inputemail.getText().toString());
//                    jsonObject.put("password", inputpwd.getText().toString());
//                    System.out.println(jsonObject);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
//                RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);
//                Request request = new Request.Builder()
//                        .url("https://d2ee-2001-b011-b800-5984-b1d2-a7b1-8432-d029.ngrok.io/api/EmergencyContact/login")
//                        .method("POST", body)
//                        .addHeader("Content-Type", "application/json")
//                        .build();
//
//                okhttp3.Call call = client.newCall(request);
//
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onResponse(okhttp3.Call call, Response response) throws IOException {
//                        // 連線成功
//                        String result = response.body().string();
//                        Log.d("OkHttp result", result);
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        System.out.println(request);
//                    }
//                });



        });
    }

}













































