package com.example.tw2ver01;


        import static android.provider.AlarmClock.EXTRA_MESSAGE;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import androidx.appcompat.app.AppCompatActivity;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.view.View;

        import org.json.JSONException;
        import org.json.JSONObject;

        import okhttp3.Call;
        import okhttp3.Callback;
        import okhttp3.MediaType;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;
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

    OkHttpClient client = new OkHttpClient().newBuilder().build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_page_emergency_input);
        btnConfirm = findViewById(R.id.button);
//        btnBackmain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
//                startActivity(intent);
//            }
//        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                Bundle bundle = new Bundle();
                EditText name = findViewById(R.id.name);
                EditText re =  findViewById(R.id.call);
                EditText phone =  findViewById(R.id.phone);
                String devicecode = "0122";
                String name1 = name.getText().toString();
                String call1 = re.getText().toString();
                String phone1 = phone.getText().toString();
                bundle.putString("name",name1);
                bundle.putString("call", call1);
                bundle.putString("phone",phone1);
                try{
                    jsonObject.put("contactNo", phone.getText().toString());
                    jsonObject.put("contactPerson", name.getText().toString());
                    jsonObject.put("deviceCode", "0122");
                    jsonObject.put("relationship", re.getText().toString());
                    System.out.println(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(jsonObject.toString(),mediaType);
                Request request = new Request.Builder()
                        .url("https://7943-2001-b011-b800-d081-eda0-db8a-6027-74aa.jp.ngrok.io/api/EmergencyContact/create")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // 連線成功
                        String result = response.body().string();
                        Log.d("OkHttp result", result);
                    }
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println(request);
                    }
                });
//
//                try{
//                    Response response = client.newCall(request).execute();
//                    if(response.isSuccessful()){
//                        System.out.println(response);
//                    }
//                } catch (IOException e) {
//                    System.out.println(request);
//                }
                Intent intent = new  Intent(page_emergency_input.this, page_emergency_outcome.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
