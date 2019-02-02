package com.android.zaderaah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.Session.MyApplication;

public class Map extends AppCompatActivity {


    DuaObj duaObj;
    MyApplication myApplication;
    Animation animBlink;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_map1);

        myApplication = (MyApplication) getApplicationContext();

        duaObj = new DuaObj();
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        view = findViewById(R.id.click1);


        findViewById(R.id.click1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTittle("POINT OF ENTERY");
                duaObj.setUrduTittle("POINT OF ENTERY");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));
            }
        });
        findViewById(R.id.click2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                duaObj.setEngTrans("Arfat");
                duaObj.setUrduTittle("Arfat");
                duaObj.setDuaInArabic("لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٍ . اللَّهُمَّ اجْعَلْ فِي قَلْبِي نُورَاً وَفِي سَمْعِي نُورَاً وَفِي بَصَرِي نُورَاً اللَّهُمَّ اشْرَحْ لِي صَدْرِي وَيَسِّرْ لِي أَمْرِي وَأَعُوذُ بِكَ مِنْ وَسَاوِسِ الصُّدُورِ وَشَتَاتِ الْأَمْرِ وَفِتْنَةِ الْقَبْرِ اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ مَا يَلِجُ فِي اللَّيْلِ وَشَرِّ مَا يَلِجُ فِي النَّهَارِ وَشَرِّ مَا تَهِبُّ بِهِ الرِّيَاحُ");
                duaObj.setUrduTrans("اللہ کے علاوہ عبادت کے قابل کوئی بھی قابل نہیں ہے، وہ سب خود ہی ہے، اس کا کوئی شریک نہیں ہے، اس کی بادشاہی ہے، کیونکہ اس کی سارا تعریف ہے، اس کی ہر چیز پر قادر ہے. اے اللہ، نور میرے دل میں، میرے کانوں میں نور اور میری آنکھوں میں نور. اے اللہ میرے سینے کو کھلانا، اپنے کاموں کو آسان بناؤں اور میں سینے کے جوسوں سے کام کرنے اور قبر کی سزا سے غیر منظم کرنے سے پناہ مانگوں. اے اللہ، میں آپ کو ان برائیوں سے پناہ مانگتا ہوں جو ہوا کے ساتھ آتی ہے");
                duaObj.setEngTrans("There is none worthy of worship besides Allah, He is all by Himself, He has no partner, His is the Kingdom, for Him is all praise, He has power over all things. O Allah, make Nur in my heart, in my ears Nur and in my eyes Nur. O Allah open my chest (bossom), make my tasks easy and I seek refuge in You from the whispers of the chest, from disorganisation in working and from the punishment of the grave. O Allah, I seek refuge in You from the evils that come with the wind.");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));
            }
        });
        findViewById(R.id.click3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Stay in Muzadalifah");
                duaObj.setUrduTittle("Stay in Muzadalifah");
                duaObj.setDuaInArabic("فَإِذَا أَفَضْتُم مِّنْ عَرَفَاتٍ فَاذْكُرُوا اللَّهَ عِندَ الْمَشْعَرِ الْحَرَامِ ۖ وَاذْكُرُوهُ كَمَا هَدَاكُمْ وَإِن كُنتُم مِّن قَبْلِهِ لَمِنَ الضَّالِّينَ\n" +
                        "\n");
                duaObj.setUrduTrans("لیکن جب آپ عرفات سے دور رہیں تو اللہ تعالی الارام الحرم میں یاد رکھیں. اور اس کو یاد کرو جیسا کہ اس نے تمہیں ہدایت دی ہے، بیشک تم اس سے پہلے گمراہ ہو.");
                duaObj.setEngTrans("But when you depart from Arafat, remember Allah at al-Mashar al-Haram. And remember Him, as He has guided you, for indeed, you were before that among those astray.");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("throwing stones at jamarat");
                duaObj.setUrduTittle("throwing stones at jamarat");
                duaObj.setDuaInArabic("وَحَدَّثَنَا أَبُو بَكْرِ بْنُ أَبِي شَيْبَةَ، حَدَّثَنَا أَبُو خَالِدٍ الأَحْمَرُ، وَابْنُ، إِدْرِيسَ عَنِ ابْنِ، جُرَيْجٍ عَنْ أَبِي الزُّبَيْرِ، عَنْ جَابِرٍ، قَالَ رَمَى رَسُولُ اللَّهِ صلى الله عليه وسلم الْجَمْرَةَ يَوْمَ النَّحْرِ ضُحًى وَأَمَّا بَعْدُ فَإِذَا زَالَتِ الشَّمْسُ" +
                        "\n");
                duaObj.setUrduTrans("جابر رضي اللہ عنه نے اطلاع دی ہے کہ رسول اللہ صلی اللہ علیہ وسلم نے سورۂ جہنم کے بعد نہر کے دن جمر میں پگھلے ہوئے چشمے اور اس کے بعد (یعنی 11 بجے، دھول حج کے 12 ویں اور 13 ویں جب سورج سے محروم ہوجائے.)");
                duaObj.setEngTrans("Jabir رضي الله عنه reported that Allah’s Messenger ﷺ flung pebbles at Jamarat on the Day of Nahr after sunrise and after that (i.e. on the 11th, 12th and 13th of Dhul Hijjah when the sun had declined.)");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Slaughtering/Sacrificing an Animal");
                duaObj.setUrduTittle("ذبح کرنا / قربانی جانوروں کو");
                duaObj.setDuaInArabic("بِسْمِ اللهِ واللهُ أَكْبَرُ اللَّهُمَّ مِنْكَ ولَكَ اللَّهُمَّ تَقَبَّلْ مِنِّي\n" +
                        "\n");
                duaObj.setUrduTrans("اللہ کے نام سے، اللہ سب سے بڑا ہے\n" +
                        "[اے اللہ، تم سے اور تم سے.] اے اللہ، یہ مجھ سے قبول کرو.");
                duaObj.setEngTrans("With the Name of Allah, Allah is the Most Great!\n" +
                        "[O Allah, from You and to You.] O Allah, accept it from me.");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Halaq or Qasar");
                duaObj.setUrduTittle("ہالق یا قصر");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Tawaf-e-Ifadah");
                duaObj.setUrduTittle("DEVIL STONING IN MINA");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("throwing pebbles");
                duaObj.setUrduTittle("throwing pebbles");
                duaObj.setDuaInArabic("وَحَدَّثَنَا أَبُو بَكْرِ بْنُ أَبِي شَيْبَةَ، حَدَّثَنَا أَبُو خَالِدٍ الأَحْمَرُ، وَابْنُ، إِدْرِيسَ عَنِ ابْنِ، جُرَيْجٍ عَنْ أَبِي الزُّبَيْرِ، عَنْ جَابِرٍ، قَالَ رَمَى رَسُولُ اللَّهِ صلى الله عليه وسلم الْجَمْرَةَ يَوْمَ النَّحْرِ ضُحًى وَأَمَّا بَعْدُ فَإِذَا زَالَتِ الشَّمْسُ" +
                        "\n");
                duaObj.setUrduTrans("جابر رضي اللہ عنه نے اطلاع دی ہے کہ رسول اللہ صلی اللہ علیہ وسلم نے سورۂ جہنم کے بعد نہر کے دن جمر میں پگھلے ہوئے چشمے اور اس کے بعد (یعنی 11 بجے، دھول حج کے 12 ویں اور 13 ویں جب سورج سے محروم ہوجائے.)");
                duaObj.setEngTrans("Jabir رضي الله عنه reported that Allah’s Messenger ﷺ flung pebbles at Jamarat on the Day of Nahr after sunrise and after that (i.e. on the 11th, 12th and 13th of Dhul Hijjah when the sun had declined.)");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("HAIR TRIM AND REMOVE PILGRIM'S IHRAM");
                duaObj.setUrduTittle("HAIR TRIM AND REMOVE PILGRIM'S IHRAM");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
        findViewById(R.id.click10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Rami of Jamarah");
                duaObj.setUrduTittle("Rami of Jamarah");
                duaObj.setDuaInArabic("اللهُ أَكْبَرُ\n");
                duaObj.setUrduTrans("اللہ سب سے بڑا ہے.");
                duaObj.setEngTrans("Allah is the greatest.");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));


            }
        });
        findViewById(R.id.click11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duaObj.setEngTrans("Tawaf-e-Widda");
                duaObj.setUrduTittle("\"Tawaf-e-Widda\"");
                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
                myApplication.setCurrent(duaObj);
                startActivity(new Intent(getApplicationContext(), Details.class));

            }
        });
//        findViewById(R.id.click12).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                duaObj.setEngTrans("FAREWELL TAWAF");
//                duaObj.setUrduTittle("FAREWELL TAWAF");
//                duaObj.setDuaInArabic("لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ\n");
//                duaObj.setUrduTrans("میں حاضر ہوں، اے اللہ، میں حاضر ہوں، آپ کے لئے کوئی شریک نہیں ہے. میں حاضر ہوں یقینا تعریف اور جلال آپ (آپ کے لئے) ہے. برطانیہ بھی آپ کا ہے. آپ کے لئے کوئی پارٹنر نہیں ہے");
//                duaObj.setEngTrans("I am present, O Allah, I am present, there is no partner unto You. I am present. Definitely praise and glory is yours (for You). The Kingdom is also Yours. There is no partner for You");
//                myApplication.setCurrent(duaObj);
//                startActivity(new Intent(getApplicationContext(), Details.class));
//
//            }
//        });


    }
}
