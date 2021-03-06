package com.android.zaderaah;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zaderaah.Session.MyApplication;

import nl.changer.audiowife.AudioWife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DuaDetailsF extends Fragment  implements AdapterView.OnItemSelectedListener{


    TextView ArabicDua, TranslationU,TranslationE,tittle;
    MyApplication myApplication;

    private View mPlayMedia;
    private View mPauseMedia;
    private SeekBar mMediaSeekBar;
    private TextView mRunTime;
    private TextView mTotalTime;
    MediaPlayer mp;
    private TextView mPlaybackTime;


    public DuaDetailsF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dua_details, container, false);


        ArabicDua = view.findViewById(R.id.ArabicDua);
        TranslationU = view.findViewById(R.id.TranslationU);
        TranslationE = view.findViewById(R.id.TranslationE);
        myApplication = (MyApplication) getActivity().getApplicationContext();



        mPlayMedia = view.findViewById(R.id.play);
        mPauseMedia = view.findViewById(R.id.pause);
        mMediaSeekBar = (SeekBar) view.findViewById(R.id.media_seekbar);
        mRunTime = (TextView) view.findViewById(R.id.run_time);
        mTotalTime = (TextView) view.findViewById(R.id.total_time);
        tittle=view.findViewById(R.id.tittle);





        Spinner spinner = (Spinner)view. findViewById(R.id.Font);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
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


        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        view.findViewById(R.id.questionmark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame1,new HajjDetailsF()).addToBackStack("").commit();
            }
        });




        view.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(getActivity(),R.raw.hajj);// the song is a filename which i have pasted inside a folder **raw** created under the **res** folder.//
                mp.start();
            }
        });


        ArabicDua.setText(myApplication.getCurrent().getDuaInArabic());
        if (myApplication.getLanguage().equals("Eng")) {
            TranslationE.setText(myApplication.getCurrent().getEngTrans());
            TranslationU.setText(myApplication.getCurrent().getUrduTrans());


        } else {
            TranslationE.setText(myApplication.getCurrent().getEngTrans());
            TranslationU.setText(myApplication.getCurrent().getUrduTrans());

        }


        tittle.setText(myApplication.getCurrent().getEngTittle());


        AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getActivity(), "Completed", Toast.LENGTH_SHORT)
                        .show();
                // do you stuff
            }
        });

        AudioWife.getInstance().addOnPlayClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Play", Toast.LENGTH_SHORT)
                        .show();
                // Lights-Camera-Action. Lets dance.
            }
        });

        AudioWife.getInstance().addOnPauseClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pause", Toast.LENGTH_SHORT)
                        .show();
                // Your on audio pause stuff.
            }
        });


        return view;
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
        tittle.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        TranslationU.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        ArabicDua.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        TranslationE.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());



    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

}
