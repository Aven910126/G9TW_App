//package com.example.tw2ver01;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.tw2ver01.dao.UserDao;
//import com.example.tw2ver01.entity.User;
//
////public class RegisterActivity extends AppCompatActivity {
////    EditText name = null;
////    EditText username = null;
////    EditText password = null;
////    EditText phone = null;
////    EditText age = null;
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_register);
////
////        name = findViewById(R.id.name);
////        username = findViewById(R.id.username);
////        password = findViewById(R.id.password);
////        phone = findViewById(R.id.phone);
////        age = findViewById(R.id.age);
////    }
////
////
////    public void register(View view){
////
////
////
////        String cname = name.getText().toString();
////        String cusername = username.getText().toString();
////        String cpassword = password.getText().toString();
////
////        System.out.println(phone.getText().toString());
////
////        String cphone = phone.getText().toString();
////        int cgae = Integer.parseInt(age.getText().toString());
////
////        if(cname.length() < 2 || cusername.length() < 2 || cpassword.length() < 2 ){
////            Toast.makeText(getApplicationContext(),"輸入資訊不符合要求請重新輸入",Toast.LENGTH_LONG).show();
////            return;
////
////        }
////
////
////        User user = new User();
////
////        user.setName(cname);
////        user.setUsername(cusername);
////        user.setPassword(cpassword);
////        user.setAge(cgae);
////        user.setPhone(cphone);
////
////        new Thread(){
////            @Override
////            public void run() {
////
////                int msg = 0;
////
////                UserDao userDao = new UserDao();
////
////                User uu = userDao.findUser(user.getName());
////
////                if(uu != null){
////                    msg = 1;
////                }
////
////                boolean flag = userDao.register(user);
////                if(flag){
////                    msg = 2;
////                }
////                hand.sendEmptyMessage(msg);
////
////            }
////        }.start();
////
////
////    }
////    final Handler hand = new Handler()
////    {
////        @Override
////        public void handleMessage(Message msg) {
////            if(msg.what == 0)
////            {
////                Toast.makeText(getApplicationContext(),"註冊失敗",Toast.LENGTH_LONG).show();
////
////            }
////            if(msg.what == 1)
////            {
////                Toast.makeText(getApplicationContext(),"該賬號已經存在，請換一個賬號",Toast.LENGTH_LONG).show();
////
////            }
////            if(msg.what == 2)
////            {
////                //startActivity(new Intent(getApplication(),MainActivity.class));
////
////                Intent intent = new Intent();
////                //將想要傳遞的資料用putExtra封裝在intent中
////                intent.putExtra("a","註冊");
////                setResult(RESULT_CANCELED,intent);
////                finish();
////            }
////
////        }
////    };
//}