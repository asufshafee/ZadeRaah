package com.android.zaderaah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMap extends AppCompatActivity implements OnMapReadyCallback {


    com.google.android.gms.maps.GoogleMap mMap;

    TextView Number, Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Name = findViewById(R.id.Name);
        Number = findViewById(R.id.Number);
        Name.setText("     Re-assueme ihram and declare your itention  to perform Hajj");

        findViewById(R.id.Previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Number.getText().equals("1")) {
                    getlatlng(Integer.parseInt(Number.getText().toString()) - 1);

                }
            }
        });
        findViewById(R.id.Next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Number.getText().toString().equals("12"))
                    getlatlng(Integer.parseInt(Number.getText().toString()) + 1);
            }
        });
    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        mMap = googleMap;
        MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.pointofentery));
        mMap.addMarker(markerOptions
                .position(new LatLng(21.421235, 39.827185)));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                new LatLng(21.421235, 39.827185), 18);
        mMap.animateCamera(location);


    }

    public void getlatlng(int num) {


        mMap.clear();
        LatLng latLngl = new LatLng(0, 0);
        if (num == 1) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.421235, 39.827185);
            Name.setText("Re-assueme ihram and declare your itention  to perform Hajj");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.pointofentery));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }

        if (num == 2) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.422515, 39.826201);
            Name.setText("Head to Mina");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.kaba));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;


        }
        if (num == 3) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.4327167, 39.8178864);
            Name.setText("Head to Arfat and Perform Waquf");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.tawaf));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;


        }
        if (num == 4) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.404491, 21.404491);
            Name.setText("Pray in Muzdalifah");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.muzdalfia));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }
        if (num == 5) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.417476, 39.881873);
            Name.setText("perform Ramy in Mina");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.mina));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }
        if (num == 6) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.413241, 39.9017);
            Name.setText("Offer a sacrifice");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.sacrifies));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }
        if (num == 7) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.417476, 39.881873);
            Name.setText("Get your hair cut or shaved");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.hircut));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }

        if (num == 8) {
            Number.setText(String.valueOf(num));
            latLngl = new LatLng(21.421235, 39.827185);
            Name.setText("Perform the Tawaf and Sa'ey");
            MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.returntoseay));
            mMap.addMarker(markerOptions
                    .position(latLngl));
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    latLngl, 18);
            mMap.animateCamera(location);
            return;

        }

        Toast.makeText(getApplicationContext(), "Completed", Toast.LENGTH_LONG).show();
    }
}
