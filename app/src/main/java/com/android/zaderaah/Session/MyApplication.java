package com.android.zaderaah.Session;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.zaderaah.Objects.DuaObj;

import java.util.List;

public class MyApplication extends Application {


    String Options = "Hajj";
    String Language = "Eng";
    DuaObj Current;
    List<DuaObj> List;
    String First;

    public java.util.List<DuaObj> getList() {
        return List;
    }

    public void setList(java.util.List<DuaObj> list) {
        List = list;
    }

    int position=0;
    @Override
    public void onCreate() {
        super.onCreate();

    }


    public Boolean getFirst() {
        SharedPreferences prefs = getSharedPreferences("MainOne", MODE_PRIVATE);
        return prefs.getBoolean("one", false);

    }

    public void setFirst(Boolean first) {
        SharedPreferences.Editor editor = getSharedPreferences("MainOne", MODE_PRIVATE).edit();
        editor.putBoolean("one", first);
        editor.apply();
        editor.commit();
    }



    public int getFornt() {
        SharedPreferences prefs = getSharedPreferences("MainOne", MODE_PRIVATE);
        return prefs.getInt("Font", 30);

    }

    public void setFont(int first) {
        SharedPreferences.Editor editor = getSharedPreferences("MainOne", MODE_PRIVATE).edit();
        editor.putInt("Font", first);
        editor.apply();
        editor.commit();
    }

    public DuaObj getCurrent() {
        return Current;
    }

    public void setCurrent(DuaObj current) {
        Current = current;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getOptions() {
        return Options;
    }

    public void setOptions(String options) {
        Options = options;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

