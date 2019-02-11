package com.android.zaderaah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.zaderaah.Session.MyApplication;

public class Settings extends AppCompatActivity {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setTitle("Settings");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.English).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApplication.setLanguage("Eng");
                finish();
            }
        });
        findViewById(R.id.Urdu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApplication.setLanguage("Urdu");
                finish();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
