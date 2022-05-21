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
import android.widget.EditText;
import android.widget.Toast;
//import com.example.tw2ver01.dao.UserDao;
public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.e("Tag","=====>"+loginResponse.getEmail());
        }

    }

    public void gotoemergencyinput  (View v){
        Intent it = new Intent(this,page_emergency_input.class);
        startActivity(it);
    }
    public void gotoheartbeat  (View v){
        Intent ia = new Intent(this,page_heartbeat.class);
        startActivity(ia);
    }
    public void gotoGPS  (View v){
        Intent ib = new Intent(this,page_Gps.class);
        startActivity(ib);
    }
    public void gotoLiveimage  (View v){
        Intent ic = new Intent(this,page_Liveimage.class);
        startActivity(ic);
    }
    public void  gotoemergencyoutcome(View v){
        Intent ie = new Intent(this,page_emergency_outcome.class);
        startActivity(ie);
    }
    public void gotologin  (View v){
        Intent ik = new Intent(this,page_login.class);
        startActivity(ik);
    }
    public void gotoregister  (View v){
        Intent ih = new Intent(this,page_register.class);
        startActivity(ih);
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

