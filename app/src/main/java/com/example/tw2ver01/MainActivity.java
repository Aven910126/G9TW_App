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
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,page_maps1.class));
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

