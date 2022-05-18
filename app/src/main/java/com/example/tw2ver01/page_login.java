package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                //
            }
        });
    }
}