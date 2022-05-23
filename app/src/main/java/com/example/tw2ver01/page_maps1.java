package com.example.tw2ver01;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tw2ver01.databinding.ActivityPageMaps1Binding;

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

public class page_maps1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityPageMaps1Binding binding;
    private String data;
    private Double longitude;
    private Double latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityPageMaps1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle0311 =this.getIntent().getExtras();
//        double longitude = bundle0311.getDouble("longitude");
//        double latitude = bundle0311.getDouble("latitude");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        // Add a marker in Sydney and move the camera
        LatLng Yuntech = new LatLng(23, 123);
        //這是雲科經緯度
        mMap.addMarker(new MarkerOptions().position(Yuntech).title("我在這"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Yuntech));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));




    }
}