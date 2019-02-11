package com.android.zaderaah;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Database.DBManager1;
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
    TextView Counter;

    DBManager dbManager;
    int counterplay;

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
        Counter=findViewById(R.id.Counter);

        mPlayMedia = findViewById(R.id.play);
        mPauseMedia = findViewById(R.id.pause);
        mMediaSeekBar = (SeekBar) findViewById(R.id.media_seekbar);
        mRunTime = (TextView) findViewById(R.id.run_time);
        mTotalTime = (TextView) findViewById(R.id.total_time);
        counterplay=Integer.parseInt(myApplication.getCurrent().getCounter());


        dbManager=new DBManager(getApplicationContext());
        dbManager.open();
        dbManager.His(Long.valueOf(myApplication.getCurrent().getID()),true);
        dbManager.close();
        loaddata();
        findViewById(R.id.Back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myApplication.getPosition()!=0)
                {
                    myApplication.setPosition(myApplication.getPosition()-1);
                    myApplication.setCurrent(myApplication.getList().get(myApplication.getPosition()));
                }else {
                    Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
                }
                loaddata();

            }
        });
        findViewById(R.id.Next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (myApplication.getPosition()!=myApplication.getList().size()-1)
                {
                    myApplication.setPosition(myApplication.getPosition()+1);
                    myApplication.setCurrent(myApplication.getList().get(myApplication.getPosition()));
                }else {
                    Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
                }
                loaddata();

            }
        });


        mPlayMedia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {

                    if (myApplication.getCurrent().getAudiopath().equals(""))
                    {
                        AudioWife.getInstance()
                                .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                                .setPlayView(mPlayMedia)
                                .setPauseView(mPauseMedia)
                                .setSeekBar(mMediaSeekBar)
                                .setRuntimeView(mRunTime)
                                .setTotalTimeView(mTotalTime);
                    }else {
                        AudioWife.getInstance()
                                .init(getApplication(), Uri.parse(myApplication.getCurrent().getAudiopath()))
                                .setPlayView(mPlayMedia)
                                .setPauseView(mPauseMedia)
                                .setSeekBar(mMediaSeekBar)
                                .setRuntimeView(mRunTime)
                                .setTotalTimeView(mTotalTime);
                    }

                    AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            counterplay=counterplay-1;
                            if (counterplay!=0)
                            {
                                if (myApplication.getCurrent().getAudiopath().equals(""))
                                {
                                    AudioWife.getInstance()
                                            .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                                            .setPlayView(mPlayMedia)
                                            .setPauseView(mPauseMedia)
                                            .setSeekBar(mMediaSeekBar)
                                            .setRuntimeView(mRunTime)
                                            .setTotalTimeView(mTotalTime).play();
                                }else {
                                    AudioWife.getInstance()
                                            .init(getApplication(), Uri.parse(myApplication.getCurrent().getAudiopath()))
                                            .setPlayView(mPlayMedia)
                                            .setPauseView(mPauseMedia)
                                            .setSeekBar(mMediaSeekBar)
                                            .setRuntimeView(mRunTime)
                                            .setTotalTimeView(mTotalTime).play();
                                }
                            }else {
                                counterplay=Integer.parseInt(myApplication.getCurrent().getCounter());
                            }
                            Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT).show();
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

    public void loaddata()
    {
        ArabicDua.setText(myApplication.getCurrent().getDuaInArabic());
        if (myApplication.getLanguage().equals("Eng")) {
            getSupportActionBar().setTitle(myApplication.getCurrent().getEngTittle());
            Translation.setText(myApplication.getCurrent().getEngTrans());
            Counter.setText("Number of time to read : "+myApplication.getCurrent().getCounter());

        } else {
            getSupportActionBar().setTitle(myApplication.getCurrent().getUrduTittle());
            Translation.setText(myApplication.getCurrent().getUrduTrans());
            Counter.setText( "پڑھنے کے لئے وقت کی تعداد"+" : "+myApplication.getCurrent().getCounter() );
        }
        Roman.setText(myApplication.getCurrent().getRoman());



        try {

            if (myApplication.getCurrent().getAudiopath().equals(""))
            {
                AudioWife.getInstance()
                        .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                        .setPlayView(mPlayMedia)
                        .setPauseView(mPauseMedia)
                        .setSeekBar(mMediaSeekBar)
                        .setRuntimeView(mRunTime)
                        .setTotalTimeView(mTotalTime);
            }else {
                AudioWife.getInstance()
                        .init(getApplication(), Uri.parse(myApplication.getCurrent().getAudiopath()))
                        .setPlayView(mPlayMedia)
                        .setPauseView(mPauseMedia)
                        .setSeekBar(mMediaSeekBar)
                        .setRuntimeView(mRunTime)
                        .setTotalTimeView(mTotalTime);
            }


            AudioWife.getInstance().addOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {

                    // do you stuff.
                }
            });

            AudioWife.getInstance().addOnPlayClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // get-set-go. Lets dance.
                }
            });

            AudioWife.getInstance().addOnPauseClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // Your on audio pause stuff.
                }
            });
        } catch (Exception e) {

        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // show menu when menu button is pressed
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort, menu);
        return true;
    }

    DBManager DBManager;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // display a message when a button was pressed


        DBManager=new DBManager(getApplicationContext());
        DBManager.open();

        if (item.getItemId()==R.id.Update)
        {
            startActivity(new Intent(getApplicationContext(),Update.class));
            finish();
        }

        if (item.getItemId()==R.id.Delete)
        {
            DBManager.delete(Long.valueOf(myApplication.getCurrent().getID()));
            DBManager.close();
            finish();
        }


        return true;
    }


}
