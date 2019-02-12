package com.android.zaderaah;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.zaderaah.Adapters.ListAdapter;
import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private List<DuaObj> praylist = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pray_list);
        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        GetDataFromDatabase();

        myApplication.setCheck(true);



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

    DBManager dbManager;

    public void GetDataFromDatabase() {

        dbManager = new DBManager(getApplicationContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        cursor.moveToFirst();

        getSupportActionBar().setTitle("History");
        praylist = new ArrayList<>();
        String ID;
        try {
            ID = cursor.getString(0);
        } catch (Exception e) {
            return;
        }
        String EnglishTittle = cursor.getString(1);
        String ArabicDua = cursor.getString(2);
        String EnglishRef = cursor.getString(3);
        String EnglishTranslate = cursor.getString(4);
        String UrduTittle = cursor.getString(5);
        String UrduTranslate = cursor.getString(6);
        String Audio = cursor.getString(7);
        String Check = cursor.getString(12);
        String Type = cursor.getString(9);
        String Type1 = cursor.getString(10);
        String Counter = cursor.getString(11);
        String His = cursor.getString(12);

        DuaObj duaObj = new DuaObj();
        duaObj.setID(ID);
        duaObj.setEngTittle(EnglishTittle);
        duaObj.setDuaInArabic(ArabicDua);
        duaObj.setEngRef(EnglishRef);
        duaObj.setEngTrans(EnglishTranslate);
        duaObj.setUrduTittle(UrduTittle);
        duaObj.setFav(Check);
        duaObj.setAudiopath(Audio);
        duaObj.setRoman(Type1);
        duaObj.setUrduTrans(UrduTranslate);
        duaObj.setHis(His);
        duaObj.setCounter(Counter);
        if (Check.equals("true"))
            if (myApplication.getOptions().equals(Type))
                praylist.add(duaObj);


        while (cursor.moveToNext()) {
            ID = cursor.getString(0);
            EnglishTittle = cursor.getString(1);
            ArabicDua = cursor.getString(2);
            EnglishRef = cursor.getString(3);
            EnglishTranslate = cursor.getString(4);
            UrduTittle = cursor.getString(5);
            UrduTranslate = cursor.getString(6);

            Counter = cursor.getString(11);
            Check = cursor.getString(12);
            His = cursor.getString(12);
            Type1 = cursor.getString(10);

            duaObj = new DuaObj();
            duaObj.setID(ID);
            duaObj.setEngTittle(EnglishTittle);
            duaObj.setRoman(Type1);
            duaObj.setDuaInArabic(ArabicDua);
            duaObj.setEngRef(EnglishRef);
            duaObj.setEngTrans(EnglishTranslate);
            duaObj.setUrduTittle(UrduTittle);
            duaObj.setUrduTrans(UrduTranslate);
            duaObj.setFav(Check);
            duaObj.setHis(His);
            duaObj.setCounter(Counter);
            if (Check.equals("true"))
                if (myApplication.getOptions().equals(Type))
                    praylist.add(duaObj);

        }

        ShowList();
    }

    public void ShowList() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ListAdapter(praylist, History.this, dbManager);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        myApplication.setCheck(false);
        super.onDestroy();
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



        ShowList();




    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}
