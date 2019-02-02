package com.android.zaderaah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.MyApplication;

public class New_hajjMap_WithAnimation extends AppCompatActivity {


    DuaObj duaObj;
    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_hajj_map__with_animation);

        Start = findViewById(R.id.startmap);
        OneToTow = findViewById(R.id.onetotow);

        TowToThere1 = findViewById(R.id.towtothree1);
        TowToThere2 = findViewById(R.id.towtothere2);
        TowToThere3 = findViewById(R.id.towtothere3);


        ThereToFour1 = findViewById(R.id.theretofour1);
        ThereToFour2 = findViewById(R.id.theretofour2);
        ThereToFour3 = findViewById(R.id.theretofour3);

        FourToFive = findViewById(R.id.fourtofive);

        FiveToStart = findViewById(R.id.fivetostart);

        ClearAll();
        MakeAnimation(Start);
        Start.setVisibility(View.VISIBLE);

        myApplication = (MyApplication) getApplicationContext();


        findViewById(R.id.click1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findViewById(R.id.Bridge).setVisibility(View.VISIBLE);
                ClearAll();
                OneToTow.setVisibility(View.VISIBLE);
                MakeAnimation(OneToTow);


                duaObj = new DuaObj();
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("رُبَّ أَوْ ز عَنِّي أَنْ أَشْكُرَ نِعْمَتَكِ الَّتِي أَنْمَتْ عَلَيَّ وَ عَلَيَّ وَالدِّيَةُ وَ أَنَّ أَ عَمَلٌ صَالِحًتَرْضَهُ وَ أَصْلُحُ لِي فِي ذُرِّيَّتَيْ ط أَنَّي تُبْتُ إِلَيْكَ وَ أَنَّي مِنْ المُسْلِمِينَ\n");
                duaObj.setUrduTrans("میرا مالک آپ کو آپ کے احسان کے لئے شکر گزار کرنے کے قابل بناتا ہے جس نے تم کو عطا کیا ہے اور میرے والدین پر نیک عملوں کو ختم کرنے کا خاتمہ کرتے ہیں جو آپ کو قبول کرتے ہیں اور میرے نزدیک میرے لئے نیک عمل کرتے ہیں .میں، میں تم سے اور توبہ کرتا ہوں. میں مسلمان ہوں");
                duaObj.setEngTrans("My lord enable me to be grateful for your favour which you have bestowed upon me and upon my parents end to do the righteous deeds which you approve of and make my offsprings righteous for me .Indeed, I repent to you and indeed, i . am of the Muslims");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame2, new DuaDetailsF()).addToBackStack("").commit();

            }
        });


        findViewById(R.id.click2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findViewById(R.id.Bridge).setVisibility(View.VISIBLE);

                ClearAll();
                TowToThere1.setVisibility(View.VISIBLE);
                TowToThere2.setVisibility(View.VISIBLE);
                TowToThere3.setVisibility(View.VISIBLE);

                MakeAnimation(TowToThere1);
                MakeAnimation(TowToThere2);
                MakeAnimation(TowToThere3);


                duaObj = new DuaObj();
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("اللّهُ أَكْبَر");
                duaObj.setUrduTrans("اللہ سب سے بڑا ہے");
                duaObj.setEngTrans("Allah is greatest.");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();


            }
        });

        findViewById(R.id.click3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClearAll();
                ThereToFour1.setVisibility(View.VISIBLE);
                ThereToFour2.setVisibility(View.VISIBLE);
                ThereToFour3.setVisibility(View.VISIBLE);
                findViewById(R.id.Bridge).setVisibility(View.VISIBLE);

                MakeAnimation(ThereToFour1);
                MakeAnimation(ThereToFour2);
                MakeAnimation(ThereToFour3);


                duaObj = new DuaObj();
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("اللہ کے سوا کوئی نہیں، ایک اور صرف، اس کا کوئی شریک نہیں ہے. اس کے لئے تمام سلطنت ہے اور اس کے لئے سب کی تعریف ہے اور وہ ہر چیز پر طاقتور ہے.");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعنہیں ہے");
                duaObj.setEngTrans("There is no one except Allah , the One and Only,there is no partner of Him. For Him is the all kingdom and for Him is the all praise and he is Powerful upon everything.");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();


            }
        });

        findViewById(R.id.click4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearAll();
                FourToFive.setVisibility(View.VISIBLE);
                findViewById(R.id.Bridge).setVisibility(View.VISIBLE);

                MakeAnimation(FourToFive);


                duaObj = new DuaObj();
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame1, new DuaDetailsF()).addToBackStack("").commit();

            }
        });


        findViewById(R.id.click5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClearAll();
                FiveToStart.setVisibility(View.VISIBLE);
                MakeAnimation(FiveToStart);
                findViewById(R.id.Bridge).setVisibility(View.VISIBLE);


                duaObj = new DuaObj();
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("حَدَّثَنَا آدَمُ، حَدَّثَنَا ابْنُ أَبِي ذِئْبٍ، عَنِ الزُّهْرِيِّ، عَنْ سَالِمِ بْنِ عَبْدِ اللَّهِ، عَنِ ابْنِ عُمَرَ ـ رضى الله عنهما ـ قَالَ جَمَعَ النَّبِيُّ ﷺ بَيْنَ الْمَغْرِبِ وَالْعِشَاءِ بِجَمْعٍ، كُلُّ وَاحِدَةٍ مِنْهُمَا بِإِقَامَةٍ، وَلَمْ يُسَبِّحْ بَيْنَهُمَا وَلاَ عَلَى إِثْرِ كُلِّ وَاحِدَةٍ مِنْهُمَا\u200F.\u200F");
                duaObj.setUrduTrans("ابن عمر نے روایت کی ہے: نبی صلی اللہ علیہ وسلم نے ان کے ساتھ ایک علیحدہ اقبال کے ساتھ جامعہ (الجمعفا) میں مکہ اور اسحاق کی نماز کی پیشکش کی اور ان میں سے ہر ایک کے بعد یا کسی اختتامی نماز کی پیشکش نہیں کی.");
                duaObj.setEngTrans("Ibn Umar narrated: The Prophet ﷺ offered the Maghrib and Isha prayers together at Jam (i.e. al-Muzdalifa) with a separate Iqama for each of them and did not offer any optional prayer in between them or after each of them.");
                myApplication.setCurrent(duaObj);
                getSupportFragmentManager().beginTransaction().add(R.id.frame2, new DuaDetailsF()).addToBackStack("").commit();


            }
        });


        findViewById(R.id.Bridge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.Bridge).setVisibility(View.GONE);
                getSupportFragmentManager().popBackStack();
                ClearAll();
            }
        });
    }


    ImageView Start, OneToTow, TowToThere1, TowToThere2, TowToThere3, ThereToFour1, ThereToFour2,
            ThereToFour3, FourToFive, FiveToStart;

    public void ClearAll() {


        Start.clearAnimation();
        Start.setVisibility(View.GONE);

        OneToTow.clearAnimation();
        OneToTow.setVisibility(View.GONE);


        TowToThere1.clearAnimation();
        TowToThere2.clearAnimation();
        TowToThere3.clearAnimation();
        TowToThere1.setVisibility(View.GONE);
        TowToThere2.setVisibility(View.GONE);
        TowToThere3.setVisibility(View.GONE);


        ThereToFour1.clearAnimation();
        ThereToFour2.clearAnimation();
        ThereToFour3.clearAnimation();
        ThereToFour1.setVisibility(View.GONE);
        ThereToFour2.setVisibility(View.GONE);
        ThereToFour3.setVisibility(View.GONE);

        FourToFive.clearAnimation();
        FourToFive.setVisibility(View.GONE);

        FiveToStart.clearAnimation();
        FiveToStart.setVisibility(View.GONE);
    }


    public void MakeAnimation(ImageView image) {
        image.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));

    }


    @Override
    public void onBackPressed() {
        findViewById(R.id.Bridge).setVisibility(View.GONE);

        super.onBackPressed();
    }
}
