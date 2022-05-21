package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_register extends AppCompatActivity {

    Button rbtn;
    EditText rusername,riptmail,riptpwd,rcpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_register);

        rbtn = findViewById(R.id.rbtn);
        rusername = findViewById(R.id.rusername);
        riptmail = findViewById(R.id.riptmail);
        riptpwd = findViewById(R.id.riptpwd);
        rcpwd = findViewById(R.id.rcpwd);

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RegisterRequest registerRequest = new RegisterRequest();
//                registerRequest.setEmail(riptmail.getText().toString());
//                registerRequest.setPassword(riptpwd.getText().toString());
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("contactNo", rusername.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonObject.put("contactPerson", riptmail.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonObject.put("deviceCode", "0122");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonObject.put("relationship", riptpwd.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                registerUser(jsonObject);
            }
        });

    }
    public void registerUser(JSONObject registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClinent.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if(response.isSuccessful()){

                    String message = "Successful ..";
                    Toast.makeText(page_register.this,message,Toast.LENGTH_LONG).show();;

                    startActivity(new Intent(page_register.this,page_login.class));
                    finish();

                }else{
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(page_register.this,message,Toast.LENGTH_LONG).show();;
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(page_register.this,message,Toast.LENGTH_LONG).show();;

            }
        });


    }
}
