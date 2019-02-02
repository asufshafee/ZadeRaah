package com.android.zaderaah;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.zaderaah.Adapters.ListAdapter;
import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class Fav extends AppCompatActivity {

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
    }

    DBManager dbManager;

    public void GetDataFromDatabase() {

        dbManager = new DBManager(getApplicationContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        cursor.moveToFirst();

        getSupportActionBar().setTitle("Favourite");
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
        String Check = cursor.getString(8);
        String Type = cursor.getString(9);

        DuaObj duaObj = new DuaObj();
        duaObj.setID(ID);
        duaObj.setEngTittle(EnglishTittle);
        duaObj.setDuaInArabic(ArabicDua);
        duaObj.setEngRef(EnglishRef);
        duaObj.setEngTrans(EnglishTranslate);
        duaObj.setUrduTittle(UrduTittle);
        duaObj.setFav(Check);
        duaObj.setAudiopath(Audio);
        duaObj.setUrduTrans(UrduTranslate);
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
            Check = cursor.getString(8);

            duaObj = new DuaObj();
            duaObj.setID(ID);
            duaObj.setEngTittle(EnglishTittle);
            duaObj.setDuaInArabic(ArabicDua);
            duaObj.setEngRef(EnglishRef);
            duaObj.setEngTrans(EnglishTranslate);
            duaObj.setUrduTittle(UrduTittle);
            duaObj.setUrduTrans(UrduTranslate);
            duaObj.setFav(Check);
            if (Check.equals("true"))
                if (myApplication.getOptions().equals(Type))
                    praylist.add(duaObj);

        }

        ShowList();
    }

    public void ShowList() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ListAdapter(praylist, Fav.this, dbManager);
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
}
