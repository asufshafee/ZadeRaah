package com.android.zaderaah;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.zaderaah.Session.MyApplication;

public class Home extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 29;

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setTitle("Home");


//        findViewById(R.id.MapImage).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), New_hajjMap_WithAnimation.class));
//
//            }
//        });

        findViewById(R.id.History).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), History.class));
            }
        });
        findViewById(R.id.Map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GoogleMap.class));

            }
        });
        findViewById(R.id.Pray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), PrayList.class));
            }
        });
        findViewById(R.id.Favourite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Fav.class));
            }
        });
        findViewById(R.id.Settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Settings.class));

            }
        });

        findViewById(R.id.Hajj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Map1.class));
            }
        });

        findViewById(R.id.KMMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KMhajjmap.class));
            }
        });
        findViewById(R.id.AddNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Umrah_Map.class));

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("Home", "Permission Granted");
                    startActivity(new Intent(getApplicationContext(), AddNew.class));
                } else {
                    Log.d("Home", "Permission Failed");
                    Toast.makeText(getApplicationContext(), "You must allow permission record audio to your mobile device.", Toast.LENGTH_SHORT).show();
                }
            }
            // Add additional cases for other permissions you may have asked for
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
