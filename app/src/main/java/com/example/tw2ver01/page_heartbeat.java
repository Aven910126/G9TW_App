package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import com.google.firebase.database.Transaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.Http2Reader;

public class page_heartbeat extends AppCompatActivity {
    String heartbeat;
    private String value;
    private Handler handler=null;
    private TextView heartoutcome = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_heartbeat);
        handler = new Handler();
        heartoutcome = (TextView)findViewById(R.id.heartoutcome);

        new Thread(new Runnable() {

            @Override

            public void run() {

                while (true) {
                    // write code

                    class heartvalueget extends AsyncTask<Void, Void,String> {
                        OkHttpClient client = new OkHttpClient();
                        @Override
                        protected String doInBackground(Void... voids) {
                            Request request = new Request.Builder()
                                    .url("https://3e5c-2001-b011-b800-d98b-7dbb-b09e-c89a-cc10.ngrok.io/api/HeartBeat/now/1")
                                    .build();
                            try (Response response = client.newCall(request).execute()) {
                                if (response.code() == 200) {
                                    String result = response.body().string();
                                    JSONObject jsonObject = new JSONObject(result);
                                    value = jsonObject.getString("heartBeatValue");
                                    return value;
                                }

                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        protected void onPostExecute(String result) {
                            if (result != null){
                                heartoutcome.setText(result);
                            }
                        }
                    }
                    new heartvalueget().execute();

                    try { Thread.sleep(1000);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }
            }
        }).start();
    }
}