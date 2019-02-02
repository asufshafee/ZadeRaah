package com.android.zaderaah;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zaderaah.R;
import com.android.zaderaah.Session.Constrains;
import com.android.zaderaah.Session.MyApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class WajibAndFarz extends Fragment {


    public WajibAndFarz() {
        // Required empty public constructor
    }

    WebView webView;

    MyApplication  myApplication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_wajib_and_farz, container, false);



        myApplication=(MyApplication)getActivity().getApplicationContext();
        webView=view.findViewById(R.id.des);

        if (myApplication.getOptions().equals("Hajj"))
        {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL("", Constrains.HajjFardAndWajib, "text/html", "UTF-8", "");

        }
        else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL("", Constrains.UmrahFardAndWajib, "text/html", "UTF-8", "");

        }


        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return view;
    }

}
