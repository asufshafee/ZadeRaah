package com.android.zaderaah;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zaderaah.Session.MyApplication;

import nl.changer.audiowife.AudioWife;

public class Details extends AppCompatActivity {


    TextView ArabicDua, Roman,Translation;
    MyApplication myApplication;

    private View mPlayMedia;
    private View mPauseMedia;
    private SeekBar mMediaSeekBar;
    private TextView mRunTime;
    private TextView mTotalTime;
    private TextView mPlaybackTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ArabicDua = findViewById(R.id.ArabicDua);
        Translation = findViewById(R.id.Translation);
        myApplication = (MyApplication) getApplicationContext();
        Roman=findViewById(R.id.Roman);

        mPlayMedia = findViewById(R.id.play);
        mPauseMedia = findViewById(R.id.pause);
        mMediaSeekBar = (SeekBar) findViewById(R.id.media_seekbar);
        mRunTime = (TextView) findViewById(R.id.run_time);
        mTotalTime = (TextView) findViewById(R.id.total_time);

        try {
            AudioWife.getInstance()
                    .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                    .setPlayView(mPlayMedia)
                    .setPauseView(mPauseMedia)
                    .setSeekBar(mMediaSeekBar)
                    .setRuntimeView(mRunTime)
                    .setTotalTimeView(mTotalTime);

            AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT).show();
                    // do you stuff.
                }
            });

            AudioWife.getInstance().addOnPlayClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Play", Toast.LENGTH_SHORT).show();
                    // get-set-go. Lets dance.
                }
            });

            AudioWife.getInstance().addOnPauseClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Pause", Toast.LENGTH_SHORT).show();
                    // Your on audio pause stuff.
                }
            });
        } catch (Exception e) {

        }

        mPlayMedia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    AudioWife.getInstance()
                            .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                                .setPlayView(mPlayMedia)
                            .setPauseView(mPauseMedia)
                            .setSeekBar(mMediaSeekBar)
                            .setRuntimeView(mRunTime)
                            .setTotalTimeView(mTotalTime);

                    AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT).show();
                            // do you stuff.
                        }
                    });

                    AudioWife.getInstance().addOnPlayClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getBaseContext(), "Play", Toast.LENGTH_SHORT).show();
                            // get-set-go. Lets dance.
                        }
                    });

                    AudioWife.getInstance().addOnPauseClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getBaseContext(), "Pause", Toast.LENGTH_SHORT).show();
                            // Your on audio pause stuff.
                        }
                    });
                } catch (Exception e) {

                }

            }
        });

        ArabicDua.setText(myApplication.getCurrent().getDuaInArabic());
        if (myApplication.getLanguage().equals("Eng")) {
            getSupportActionBar().setTitle(myApplication.getCurrent().getEngTittle());
            Translation.setText(myApplication.getCurrent().getEngTrans());

        } else {
            getSupportActionBar().setTitle(myApplication.getCurrent().getUrduTittle());
            Translation.setText(myApplication.getCurrent().getUrduTrans());
        }
        Roman.setText(myApplication.getCurrent().getRoman());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT)
                        .show();
                // do you stuff
            }
        });

        AudioWife.getInstance().addOnPlayClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Play", Toast.LENGTH_SHORT)
                        .show();
                // Lights-Camera-Action. Lets dance.
            }
        });

        AudioWife.getInstance().addOnPauseClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Pause", Toast.LENGTH_SHORT)
                        .show();
                // Your on audio pause stuff.
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
