package com.android.zaderaah.Session;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.zaderaah.Objects.DuaObj;

public class MyApplication extends Application {


    String Options = "";
    String Language = "eng";
    DuaObj Current;
    String First;

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
}

