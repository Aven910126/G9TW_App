package com.example.tw2ver01;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page_Gps extends AppCompatActivity {

    private TextView sc7;
    private Button button5;
    private LocationManager locationManager;
    private String commadStr;
    public static final int MY_PERMISSION_ACCESS_COARSE_LOCATION;

    static {
        MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;
    }

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_gps);
        commadStr = LocationManager.GPS_PROVIDER;
        Button button = (Button) findViewById(R.id.button5);
        sc7 = (TextView) findViewById(R.id.sc7);
        commadStr=LocationManager.GPS_PROVIDER;
        button.setOnClickListener(ss);
    }

    private Object LocationListener;
    private View.OnClickListener ss = new View.OnClickListener() {
        private Context sa;

        @SuppressLint("MissingPermission")
        @Override
        public void onClick(View v) {
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(
                    this.sa, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this.sa, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                //here to request the = null missing permissions, and then overriding
                //public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults)to handle the case where the user grants the Manifest.permission. See the documentation for ActivityCompat#requestPermissions for more details.;
                ActivityCompat.requestPermissions((Activity) this.sa, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_ACCESS_COARSE_LOCATION);
                return;
            }

            locationManager.requestLocationUpdates(commadStr, 1000, 0, (PendingIntent) LocationListener);
            Location location = locationManager.getLastKnownLocation(commadStr);

            if(location != null){
                sc7.setText("經度" + location.getLongitude()+"\n緯度" + location.getLatitude());

            }
            else{
                sc7.setText("定位中");
            }
        }
    };

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            sc7.setText("經度" + location.getLongitude()+"\n緯度" + location.getLatitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

}