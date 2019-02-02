package com.android.zaderaah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.zaderaah.Session.MyApplication;

public class Options extends AppCompatActivity {


    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setTitle("Options");

        findViewById(R.id.hajj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myApplication.setOptions("Hajj");
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });
        findViewById(R.id.umera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myApplication.setOptions("Umrah");
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });
    }
}
