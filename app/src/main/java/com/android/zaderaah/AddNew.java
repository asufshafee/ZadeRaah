package com.android.zaderaah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Session.MyApplication;

import br.com.safety.audio_recorder.AudioListener;
import br.com.safety.audio_recorder.AudioRecordButton;
import br.com.safety.audio_recorder.AudioRecording;
import br.com.safety.audio_recorder.RecordingItem;

public class AddNew extends AppCompatActivity {


    EditText EnglishTittle, DuaInArabic, EnglishRef, EnglishTranslate, UrduTittle, UrduTranslate,Roman,Counter;
    MyApplication myApplication;
    private AudioRecordButton audioRecordButton;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setTitle("Add New " + myApplication.getOptions() + " Prayer");
        audioRecordButton = (AudioRecordButton) findViewById(R.id.audio_record_button);


        EnglishTittle = findViewById(R.id.EnglishTittle);
        DuaInArabic = findViewById(R.id.DuaInArabic);
        EnglishRef = findViewById(R.id.EnglishRef);
        EnglishTranslate = findViewById(R.id.EnglishTranslate);
        UrduTittle = findViewById(R.id.UrduTittle);
        UrduTranslate = findViewById(R.id.UrduTranslate);
        Roman=findViewById(R.id.Roman);
        Counter=findViewById(R.id.Counter);

        findViewById(R.id.Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (EnglishTittle.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter English Tittle", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (DuaInArabic.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Dua in Arabic", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (EnglishRef.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter English Ref", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (EnglishTranslate.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter English Translate", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (UrduTittle.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Urdu Tittle", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (UrduTranslate.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Urdu Translate", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Roman.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Roman Translate", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Counter.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Couunter", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (path == null || path.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Record Audio", Toast.LENGTH_SHORT).show();
                    return;
                }


                DBManager dbManager = new DBManager(getApplicationContext());
                dbManager.open();
                dbManager.insert(EnglishTittle.getText().toString(), DuaInArabic.getText().toString(), EnglishRef.getText().toString()
                        , EnglishTranslate.getText().toString(), UrduTittle.getText().toString(),
                        UrduTranslate.getText().toString(), myApplication.getOptions(), false, path,Roman.getText().toString(),Counter.getText().toString(),"");

                Toast.makeText(getApplicationContext(), "Pray Saved", Toast.LENGTH_SHORT).show();
                dbManager.close();
                finish();

            }
        });

        audioRecordButton.setOnAudioListener(new AudioListener() {
            @Override
            public void onStop(RecordingItem recordingItem) {
                path = recordingItem.getFilePath();
                Toast.makeText(getBaseContext(), "Audio Recorded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
