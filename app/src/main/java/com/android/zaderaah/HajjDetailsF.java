package com.android.zaderaah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zaderaah.Session.MyApplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class HajjDetailsF extends Fragment {


    public HajjDetailsF() {
        // Required empty public constructor
    }



    WebView webView;
    TextView Title;
    ImageView Image;

    MyApplication  myApplication;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_hajj_details, container, false);



        myApplication=(MyApplication)getActivity().getApplicationContext();
        webView=view.findViewById(R.id.des);
        Title=view.findViewById(R.id.Tittle);
        Image=view.findViewById(R.id.Image);

        view.findViewById(R.id.WajibAndFarz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame1,new WajibAndFarz()).addToBackStack("").commit();

            }
        });

        Title.setText(myApplication.getCurrent().getEngTittle());

        if (myApplication.getCurrent().getEngTittle().equals("IHRAM"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "ihram1", "drawable", getActivity().getApplicationInfo().packageName));
        }



        if (myApplication.getCurrent().getEngTittle().equals("MINA"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "mina1", "drawable", getActivity().getApplicationInfo().packageName));
        }


        if (myApplication.getCurrent().getEngTittle().equals("MUZDALFA"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "muzad1", "drawable", getActivity().getApplicationInfo().packageName));
        }


        if (myApplication.getCurrent().getEngTittle().equals("RAMI IN MINA"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "ramyandmina1", "drawable", getActivity().getApplicationInfo().packageName));
        }


        if (myApplication.getCurrent().getEngTittle().equals("RAMI IN MINA"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "ramyandmina1", "drawable", getActivity().getApplicationInfo().packageName));
        }
        if (myApplication.getCurrent().getEngTittle().equals("ARFAT & WAQUF"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "arfat1", "drawable", getActivity().getApplicationInfo().packageName));
        }



        if (myApplication.getCurrent().getEngTittle().equals("SACRIFICE"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "sacri", "drawable", getActivity().getApplicationInfo().packageName));
        }

        if (myApplication.getCurrent().getEngTittle().equals("HAIR CUT"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "haircut1", "drawable", getActivity().getApplicationInfo().packageName));
        }





        if (myApplication.getCurrent().getEngTittle().equals("TAWAF & SA'EY"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "repeatramy", "drawable", getActivity().getApplicationInfo().packageName));
        }

        if (myApplication.getCurrent().getEngTittle().equals("REPEAT RAMY"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "tawafandsaey", "drawable", getActivity().getApplicationInfo().packageName));
        }
        if (myApplication.getCurrent().getEngTittle().equals("TAWAF-FAREWELL"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "tawafefarewel", "drawable", getActivity().getApplicationInfo().packageName));
        }
        if (myApplication.getCurrent().getEngTittle().equals("KABA"))
        {
            Image.setImageResource(getResources().getIdentifier(
                    "tawafefarewel", "drawable", getActivity().getApplicationInfo().packageName));
        }



        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("", myApplication.getCurrent().getHtmlText(), "text/html", "UTF-8", "");

        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return view;
    }

}
