package com.android.zaderaah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.zaderaah.Session.MyApplication;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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


        Spinner spinner = (Spinner) findViewById(R.id.Font);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.font, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);





        if (myApplication.getFornt()==20)
        {
            spinner.setSelection(0);
        }
        if (myApplication.getFornt()==25)
        {
            spinner.setSelection(1);
        }
        if (myApplication.getFornt()==30)
        {
            spinner.setSelection(2);
        }
        if (myApplication.getFornt()==35)
        {
            spinner.setSelection(3);
        }
        if (myApplication.getFornt()==45)
        {
            spinner.setSelection(4);
        }
        if (myApplication.getFornt()==55)
        {
            spinner.setSelection(5);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {


        if (pos==0)
        {
            myApplication.setFont(20);
        }
        if (pos==1)
        {
            myApplication.setFont(25);
        }
        if (pos==2)
        {
            myApplication.setFont(30);
        }
        if (pos==3)
        {
            myApplication.setFont(35);
        }
        if (pos==4)
        {
            myApplication.setFont(45);
        }
        if (pos==5)
        {
            myApplication.setFont(55);
        }



    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}
