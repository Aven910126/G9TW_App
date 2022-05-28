package com.example.tw2ver01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SoS extends AppCompatActivity {
    private Handler handler=null;
    private boolean info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();

        new Thread(new Runnable() {
            @Override

            public void run() {

                while (true) {
                    // write code

                    class sostrg extends AsyncTask<Void, Void, Boolean> {
                        OkHttpClient client = new OkHttpClient();

                        @Override
                        protected Boolean doInBackground(Void... voids) {
                            Request request = new Request.Builder()
                                    .url("https://d2ee-2001-b011-b800-5984-b1d2-a7b1-8432-d029.ngrok.io/api/Gps/sostrigger/1")
                                    .build();

                            try (Response response = client.newCall(request).execute()) {
                                if (response.code() == 200) {
                                    String result = response.body().string();
                                    JSONObject jsonObject = new JSONObject(result);
                                    info = jsonObject.getBoolean("sosInfo");
                                    System.out.println(info);
                                    return info;
                                }
                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }
                            return info;
                        }

                        protected void onPostExecute(String result) {

                        }
                    }


                new sostrg().execute();

                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }
            }
            }

        }).start();
    }
}
