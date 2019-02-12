package com.android.zaderaah;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Database.DBManager1;
import com.android.zaderaah.Session.MyApplication;

import nl.changer.audiowife.AudioWife;

public class Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


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


//        ArabicDua.setTextSize(getResources().getDimension(myApplication.getFornt()));
//        Translation.setTextSize(getResources().getDimension(myApplication.getFornt()));
//        Roman.setTextSize(getResources().getDimension(myApplication.getFornt()));
//        Counter.setTextSize(getResources().getDimension(myApplication.getFornt()));
//        mRunTime.setTextSize(getResources().getDimension(myApplication.getFornt()));
//        mTotalTime.setTextSize(getResources().getDimension(myApplication.getFornt()));



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



        ChangeFont();
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

                          try
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
                          }catch ( Exception Ex)
                          {
                              AudioWife.getInstance()
                                      .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                                      .setPlayView(mPlayMedia)
                                      .setPauseView(mPauseMedia)
                                      .setSeekBar(mMediaSeekBar)
                                      .setRuntimeView(mRunTime)
                                      .setTotalTimeView(mTotalTime).play();
                          }



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
                AudioWife.getInstance()
                        .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                        .setPlayView(mPlayMedia)
                        .setPauseView(mPauseMedia)
                        .setSeekBar(mMediaSeekBar)
                        .setRuntimeView(mRunTime)
                        .setTotalTimeView(mTotalTime).play();
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
            AudioWife.getInstance()
                    .init(getApplication(), Uri.parse("android.resource://"+getPackageName()+"/raw/dua"+myApplication.getCurrent().getID()))
                    .setPlayView(mPlayMedia)
                    .setPauseView(mPauseMedia)
                    .setSeekBar(mMediaSeekBar)
                    .setRuntimeView(mRunTime)
                    .setTotalTimeView(mTotalTime);
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

    public void ChangeFont()
    {
        ArabicDua.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        Translation.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        Roman.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        Counter.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        mRunTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());
        mTotalTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, myApplication.getFornt());




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
        ChangeFont();



    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onDestroy() {
        try
        {
            AudioWife.getInstance().pause();
        }catch (Exception Ex)
        {

        }

        super.onDestroy();
    }
}
