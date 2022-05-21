package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_login extends AppCompatActivity {
    Button btnlogin;
    EditText inputemail,inputpwd;
    TextView createAcc;

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
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputemail.getText().toString())||TextUtils.isEmpty(inputpwd.getText().toString())) {
                    String message = "All input required";
                    Toast.makeText(page_login.this,message,Toast.LENGTH_LONG).show();

                }else{
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(inputemail.getText().toString());
                    loginRequest.setPassword(inputpwd.getText().toString());


                    loginUser(loginRequest);
                }
            }
        });

    }
        public void loginUser(LoginRequest loginRequset){
            Call<LoginResponse> loginResponseCall=ApiClinent.getService().loginUser(loginRequset);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful()){
                       LoginResponse loginResponse = response.body();
                       startActivity(new Intent(page_login.this,MainActivity.class).putExtra("data",loginResponse));
                       finish();
                    }else{

                        String message = "An error occurred please try again later ...";
                        Toast.makeText(page_login.this,message,Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    String message = t.getLocalizedMessage();
                    Toast.makeText(page_login.this,message,Toast.LENGTH_LONG).show();;
                }
            });
        }

}