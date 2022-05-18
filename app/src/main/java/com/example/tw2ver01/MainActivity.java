package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//    public void reg(View view){
//
//        startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
//
//    }


//    public void login(View view){
//
//        EditText EditTextname = (EditText)findViewById(R.id.name);
//        EditText EditTextpassword = (EditText)findViewById(R.id.password);
//
//        new Thread(){
//            @Override
//            public void run() {
//
//                UserDao userDao = new UserDao();
//
//                boolean aa = userDao.login(EditTextname.getText().toString(),EditTextpassword.getText().toString());
//                int msg = 0;
//                if(aa){
//                    msg = 1;
//                }
//
//                hand1.sendEmptyMessage(msg);
//
//
//            }
//        }.start();
//
//
//    }
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

