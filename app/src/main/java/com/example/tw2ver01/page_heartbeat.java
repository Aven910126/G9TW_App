package com.example.tw2ver01;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_heartbeat);
        TextView heartoutcome = findViewById(R.id.heartoutcome);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        Bundle bundle0311 =this.getIntent().getExtras();
//                heartbeat = bundle0311.getString("heartbeat");
                System.out.println(heartbeat);
                //顯示發送的字串
                heartoutcome.setText(heartbeat);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class registTrashcanTask extends AsyncTask<Void, Void,Boolean> {
                    int i=18;
                    private String value;
                    private Button btnUpdate,btnAccount,btnLocation,btnMoney,btnSetting;
                    OkHttpClient client = new OkHttpClient();

                    @Override
                    protected Boolean doInBackground(Void... voids) {

                            Request request = new Request.Builder()
                                    .url("https://20a8-2001-b011-b800-d98b-159a-1c02-67ee-c6bd.ngrok.io/api/HeartBeat/now/1")
                                    .build();

                            try (Response response = client.newCall(request).execute()) {
                                if (response.code() == 200) {
                                    String result = response.body().string();
                                    JSONObject jsonObject = new JSONObject(result);
                                    value = jsonObject.toString();
                                    System.out.println(value);
                                    onPostExecute();
                                }

                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }

                            return null;
                    }

                    protected void onPostExecute() {
                        heartoutcome.setText(value);
                    }
                }
                new registTrashcanTask().execute();
            }
        });
    }
}


