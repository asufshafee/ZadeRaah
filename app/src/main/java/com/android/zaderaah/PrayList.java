package com.android.zaderaah;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.zaderaah.Adapters.ListAdapter;
import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Database.DBManager1;
import com.android.zaderaah.Database.DataBaseHelper1;
import com.android.zaderaah.Database.DatabaseHelper;
import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.MyApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrayList extends AppCompatActivity {


    private List<DuaObj> praylist = new ArrayList<>();

    private List<DuaObj> praylistFinal = new ArrayList<>();

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    MyApplication myApplication;
    DataBaseHelper1 dataBaseHelper1;

    DBManager1 dbManager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        myApplication = (MyApplication) getApplicationContext();
        dataBaseHelper1 = new DataBaseHelper1(this);
        try {
            dataBaseHelper1.createDatabase();
            dataBaseHelper1.openDatabase();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error in Database", Toast.LENGTH_LONG).show();
        }
        getSupportActionBar().setTitle(myApplication.getOptions() + " Prayer's");

        GetDataFromDatabase();

    }


    DBManager dbManager;

    public void GetDataFromDatabase() {


        dbManager = new DBManager(getApplicationContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        cursor.moveToFirst();
        String ID = "";
        praylist = new ArrayList<>();
        try {
            ID = cursor.getString(0);

            String EnglishTittle = cursor.getString(1);
            String ArabicDua = cursor.getString(2);
            String EnglishRef = cursor.getString(3);
            String EnglishTranslate = cursor.getString(4);
            String UrduTittle = cursor.getString(5);
            String UrduTranslate = cursor.getString(6);
            String Check = cursor.getString(8);
            String Audio = cursor.getString(7);
            String Type = cursor.getString(9);
            String Roman = cursor.getString(10);


            DuaObj duaObj = new DuaObj();
            duaObj.setID(ID);
            duaObj.setEngTittle(EnglishTittle);
            duaObj.setDuaInArabic(ArabicDua);
            duaObj.setEngRef(EnglishRef);
            duaObj.setEngTrans(EnglishTranslate);
            duaObj.setUrduTittle(UrduTittle);
            duaObj.setFav(Check);
            duaObj.setAudiopath(Audio);
            duaObj.setRoman(Roman);
            duaObj.setUrduTrans(UrduTranslate);
            if (myApplication.getOptions().equals(Type))
                if (!ID.equals(""))
                    praylist.add(duaObj);
//

            while (cursor.moveToNext()) {
                ID = cursor.getString(0);
                EnglishTittle = cursor.getString(1);
                ArabicDua = cursor.getString(2);
                EnglishRef = cursor.getString(3);
                EnglishTranslate = cursor.getString(4);
                UrduTittle = cursor.getString(5);
                UrduTranslate = cursor.getString(6);
                Check = cursor.getString(8);
                Audio = cursor.getString(7);
                Type = cursor.getString(9);
                Roman = cursor.getString(10);

                duaObj = new DuaObj();
                duaObj.setID(ID);
                duaObj.setEngTittle(EnglishTittle);
                duaObj.setDuaInArabic(ArabicDua);
                duaObj.setEngRef(EnglishRef);
                duaObj.setEngTrans(EnglishTranslate);
                duaObj.setUrduTittle(UrduTittle);
                duaObj.setUrduTrans(UrduTranslate);
                duaObj.setFav(Check);
                duaObj.setRoman(Roman);
                duaObj.setAudiopath(Audio);
                if (myApplication.getOptions().equals(Type))
                    praylist.add(duaObj);

            }
        } catch (Exception e) {

        }

        if (praylist.size() == 0) {
            CopyDatabase();
        }

        ShowList();
    }


    public void ShowList() {


        praylistFinal=new ArrayList<>();
        for (DuaObj  duaObj:praylist)
        {
            if (checkExist(duaObj))
            {
                praylistFinal.add(duaObj);
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ListAdapter(praylistFinal, PrayList.this, dbManager);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }


    public void CopyDatabase() {

        dbManager1 = new DBManager1(getApplicationContext());

        dbManager1.open();

        Cursor cursor = dbManager1.fetch();
        Cursor cursor1 = dbManager1.fetch1();

        cursor.moveToFirst();
        cursor1.moveToFirst();


        String ID, urduT, EngT;
        praylist = new ArrayList<>();
        try {
            ID = cursor.getString(0);
            urduT = cursor.getString(2);
            EngT = cursor.getString(1);


            String Arabic, EngTran, urduTran, TimeForAayateEng, TimeForAyaatUrdu, Roman;

//
            while (cursor1.moveToNext()) {
                Arabic = cursor1.getString(4);
                EngTran = cursor1.getString(5);
                urduTran = cursor1.getString(6);
                TimeForAayateEng = cursor1.getString(7);
                TimeForAyaatUrdu = cursor1.getString(9);
                Roman = cursor1.getString(11);

                if (ID.equals(cursor1.getString(1))) {
                    if (!CheckIfExist(EngT, "Hajj"))
                        dbManager.insert(EngT, Arabic, TimeForAayateEng
                                , EngTran, urduT,
                                urduTran, "Hajj", false, "",Roman);
                    if (!CheckIfExist(EngT, "Umrah"))
                        dbManager.insert(EngT, Arabic, TimeForAayateEng
                                , EngTran, urduT,
                                urduTran, "Umrah", false, "",Roman);
                }

            }
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                cursor1.moveToFirst();
                ID = cursor.getString(0);
                urduT = cursor.getString(2);
                EngT = cursor.getString(1);


                while (cursor1.moveToNext()) {
                    Arabic = cursor1.getString(4);
                    EngTran = cursor1.getString(5);
                    urduTran = cursor1.getString(6);
                    TimeForAayateEng = cursor1.getString(7);
                    TimeForAyaatUrdu = cursor1.getString(9);
                    Roman = cursor1.getString(11);


                    if (ID.equals(cursor1.getString(1))) {
                        if (!CheckIfExist(EngT, "Hajj"))
                            dbManager.insert(EngT, Arabic, TimeForAayateEng
                                    , EngTran, urduT,
                                    urduTran, "Hajj", false, "",Roman);
                        if (!CheckIfExist(EngT, "Umrah"))
                            dbManager.insert(EngT, Arabic, TimeForAayateEng
                                    , EngTran, urduT,
                                    urduTran, "Umrah", false, "",Roman);
                    }


                }


            }


        } catch (Exception e) {
//            return;
        }
        GetDataFromDatabase();
    }


    public Boolean CheckIfExist(String Tittle, String Option) {

        Boolean CheckBoolean = false;


        dbManager = new DBManager(getApplicationContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        cursor.moveToFirst();
        String ID = "";
        praylist = new ArrayList<>();
        try {
            ID = cursor.getString(0);
        } catch (Exception e) {

        }
        if (ID.equals("")) {
            return false;
        }
        String EnglishTittle = cursor.getString(5);
        String ArabicDua = cursor.getString(2);
        String EnglishRef = cursor.getString(3);
        String EnglishTranslate = cursor.getString(4);
        String UrduTittle = cursor.getString(1);
        String UrduTranslate = cursor.getString(6);
        String Check = cursor.getString(8);
        String Audio = cursor.getString(7);
        String Type = cursor.getString(9);


        DuaObj duaObj = new DuaObj();
        duaObj.setType(Type);
        duaObj.setID(ID);
        duaObj.setEngTittle(EnglishTittle);
        duaObj.setDuaInArabic(ArabicDua);
        duaObj.setEngRef(EnglishRef);
        duaObj.setEngTrans(EnglishTranslate);
        duaObj.setUrduTittle(UrduTittle);
        duaObj.setFav(Check);
        duaObj.setAudiopath(Audio);
        duaObj.setUrduTrans(UrduTranslate);
            praylist.add(duaObj);


        while (cursor.moveToNext()) {
            ID = cursor.getString(0);
            EnglishTittle = cursor.getString(5);
            ArabicDua = cursor.getString(2);
            EnglishRef = cursor.getString(3);
            EnglishTranslate = cursor.getString(4);
            UrduTittle = cursor.getString(1);
            UrduTranslate = cursor.getString(6);
            Check = cursor.getString(8);
            Audio = cursor.getString(7);
            Type = cursor.getString(9);

            duaObj = new DuaObj();
            duaObj.setID(ID);
            duaObj.setType(Type);
            duaObj.setEngTittle(EnglishTittle);
            duaObj.setDuaInArabic(ArabicDua);
            duaObj.setEngRef(EnglishRef);
            duaObj.setEngTrans(EnglishTranslate);
            duaObj.setUrduTittle(UrduTittle);
            duaObj.setUrduTrans(UrduTranslate);
            duaObj.setFav(Check);
            duaObj.setAudiopath(Audio);
                praylist.add(duaObj);

        }


        for (DuaObj duaObj1 : praylist) {
            if (duaObj1.getEngTittle().toLowerCase().trim().equals(Tittle.toLowerCase().trim()) && Type.equals(Option)) {
                CheckBoolean = true;
            } else {
                CheckBoolean = false;
            }
        }


        return CheckBoolean;
    }



    public Boolean checkExist(DuaObj duaObjcheck)
    {
        Boolean Check=true;

        for (DuaObj duaObj:praylistFinal)
        {
            if (duaObj.getEngTittle().trim().toLowerCase().equals(duaObjcheck.getEngTittle().trim().toLowerCase()))
            {
                Check=false;
            }
        }
        return Check;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // show menu when menu button is pressed
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // display a message when a button was pressed

        if (item.getItemId() == R.id.add) {
          startActivity(new Intent(getApplicationContext(),AddNew.class));
        }



        return true;
    }











}