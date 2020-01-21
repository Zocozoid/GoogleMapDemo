package com.example.googlemapdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.googlemapdemo.SecondView;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    Button button;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.listClients);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSecondView();
            }
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    public void openSecondView(){
        Intent intent = new Intent(MainActivity.this, SecondView.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng Skopje = new LatLng(41.99646, 21.43141);
        map.addMarker(new MarkerOptions().position(Skopje).title("Skopje"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Skopje));
        map.setMinZoomPreference(10.0f);
    }

}

