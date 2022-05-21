package com.example.tw2ver01;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
//import okhttp3.MediaType;




public class page_emergency_input extends AppCompatActivity {
    public Button btnConfirm,btnBackmain;
    public static final String EXTRA_MESSAGE="com.example.tw2ver01.MESSAGE";
    public static final String EXTRA_MESSAGE1="com.example.tw2ver01.MESSAGE";
    public static final String EXTRA_MESSAGE2="com.example.tw2ver01.MESSAGE";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_page_emergency_input);

    }
    public  void gotoemergencyoutcome(View view){

        Intent intent = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
        Intent intent1 = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
        Intent intent2 = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
        Bundle bundle = new Bundle();
        EditText name = findViewById(R.id.name);//取得聯絡人姓名
        EditText call = findViewById(R.id.call);//取得聯絡人稱謂
        EditText phone =findViewById(R.id.phone);//取得聯絡人電話
        String name1 = name.getText().toString();
        String call1 = call.getText().toString();
        String phone1 = phone.getText().toString();
        bundle.putString("name",name1);
        bundle.putString("call", call1);
        bundle.putString("phone",phone1);
        intent.putExtras(bundle);
        startActivity(intent);
    }
//      btnConfirm.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick(View view){
//        class loginTask extends AsyncTask<Void, Void, Boolean> {
//            @Override
//            protected Boolean doInBackground(Void... voids) {
//                JSONObject jsonObject = new JSONObject();
//                EditText name = (EditText) findViewById(R.id.name);//取得聯絡人姓名
//                EditText call = (EditText) findViewById(R.id.call);//取得聯絡人稱謂
//                EditText phone = (EditText) findViewById(R.id.phone);//取得聯絡人電話
//                try {
//                    jsonObject.put("name", name.getText().toString());
//                    jsonObject.put("call", call.getText().toString());
//                    jsonObject.put("phone", phone.getText().toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                MediaType mediaType = MediaType.get("application/json; charset=utf-8");
//                RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);
//                Request request = new Request.Builder()
//                        .url("http://140.125.207.230:8080/api/login")
//                        .post(body)
//                        .build();
//
//                try (Response response = client.newCall(request).execute()) {
//                    if (response.code() == 200) {
//                        return true;
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return false;
//            }
//
//            protected void onPostExecute(Boolean result) {
//                System.out.println(result);
//                if (result) {
//                    Intent intent = new Intent(LoginActivity.this, RegistTrashcan.class);
//                    startActivity(intent);
//                }
//            }
//        }
//        new loginTask().execute();
//    }
//        public void goback (View v){
//        finish();
//        }
    }
