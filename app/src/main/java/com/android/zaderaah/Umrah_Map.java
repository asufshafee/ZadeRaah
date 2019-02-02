package com.android.zaderaah;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.Constrains;
import com.android.zaderaah.Session.MyApplication;

public class Umrah_Map extends AppCompatActivity {




    DuaObj duaObj;
    MyApplication myApplication;
    Animation animBlink;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_umrah__map);




        myApplication = (MyApplication) getApplicationContext();

        duaObj = new DuaObj();
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        view = findViewById(R.id.click1);



        findViewById(R.id.click1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj=new DuaObj();
                duaObj.setHtmlText(Constrains.IHRAM);
                duaObj.setEngTittle("IHRAM");
                duaObj.setUrduTittle("IHRAM");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();
            }
        });
        findViewById(R.id.click2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj=new DuaObj();
                duaObj.setHtmlText(Constrains.TAWAF_E_FAREWELL);
                duaObj.setEngTittle("KABA");
                duaObj.setUrduTittle("KABA");
                duaObj.setDuaInArabic("اللهُ أَكْبَرُ\n");
                duaObj.setUrduTrans("اللہ سب سے بڑا ہے.");
                duaObj.setEngTrans("Allah is the greatest.");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();
            }
        });
        findViewById(R.id.click3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                duaObj=new DuaObj();

                duaObj.setEngTittle("TAWAF & SA'EY");
                duaObj.setUrduTittle("TAWAF & SA'EY");
                duaObj.setHtmlText(Constrains.TAWAF_AND_SAEY);
                duaObj.setDuaInArabic("وَحَدَّثَنَا أَبُو بَكْرِ بْنُ أَبِي شَيْبَةَ، حَدَّثَنَا أَبُو خَالِدٍ الأَحْمَرُ، وَابْنُ، إِدْرِيسَ عَنِ ابْنِ، جُرَيْجٍ عَنْ أَبِي الزُّبَيْرِ، عَنْ جَابِرٍ، قَالَ رَمَى رَسُولُ اللَّهِ صلى الله عليه وسلم الْجَمْرَةَ يَوْمَ النَّحْرِ ضُحًى وَأَمَّا بَعْدُ فَإِذَا زَالَتِ الشَّمْسُ" +
                        "\n");
                duaObj.setUrduTrans("جابر رضي اللہ عنه نے اطلاع دی ہے کہ رسول اللہ صلی اللہ علیہ وسلم نے سورۂ جہنم کے بعد نہر کے دن جمر میں پگھلے ہوئے چشمے اور اس کے بعد (یعنی 11 بجے، دھول حج کے 12 ویں اور 13 ویں جب سورج سے محروم ہوجائے.)");
                duaObj.setEngTrans("Jabir رضي الله عنه reported that Allah’s Messenger ﷺ flung pebbles at Jamarat on the Day of Nahr after sunrise and after that (i.e. on the 11th, 12th and 13th of Dhul Hijjah when the sun had declined.)");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();

            }
        });
        findViewById(R.id.click4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                duaObj=new DuaObj();

                duaObj.setEngTittle("HAIR CUT");
                duaObj.setUrduTittle("HAIR CUT");
                duaObj.setHtmlText(Constrains.HAIRCUT);
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();

            }
        });


    }

}
