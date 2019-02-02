package com.android.zaderaah;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Session.MyApplication;

public class Splash extends AppCompatActivity {


    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        myApplication = (MyApplication) getApplicationContext();
        if (!myApplication.getFirst()) {
            myApplication.setFirst(true);

//            DBManager dbManager = new DBManager(getApplicationContext());
//            dbManager.open();
//            dbManager.insert("Dua When Sighting The Moon", "أَعُوذُ بِاللَّهِ مِنْ شَرِّ هَذَا لغاسِق", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Azzawajal from the badness of this that darkness.", "جب بھی چاند پر نظر پڑھے کی دعا",
//                    "میں اللہ عزوجل کی پناہ طلب کرتا ہوں اس تاریک ہوجانے والے کی برائی سے۔","Hajj", false,"");
//
//
//            dbManager.insert("Dua When Hearing Someone Sneeze", "يَرْحَمُكَ اللَّهُ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "May Allah Almighty Have Mercy on you.", "چھینک آنے پر الحمد للہ کہنے والے کے لئے دعا",
//                    "اللہ عزوجل تجھ پر رحم کرے۔", "Hajj", false,"");
//
//
//            dbManager.insert("Dua When You Become Angry", "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Almighty from the rejected Shetan.", "غصہ آنے کے وقت کی دعا",
//                    "میں شیطان مردود سے اللہ عزوجل کی پناہ چاہتا ہوں۔","Hajj", false,"");
//
//
//            dbManager.insert("Dua Upon Sneezing", "الْحَمْدُ لِلَّهِ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "All praise onto Allah Almighty.", "چھینک آنے کے وقت کی دعا",
//                    "تمام تعریفیں اللہ عزوجل کےلئے ہیں۔", "Hajj", false,"");
//
//
//            dbManager.insert("Dua When Meeting Another Muslim", "أَعُوذُ بِاللَّهِ مِنْ شَرِّ هَذَا لغاسِق", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Azzawajal from the badness of this that darkness.", "جب بھی چاند پر نظر پڑھے کی دعا",
//                    "میں اللہ عزوجل کی پناہ طلب کرتا ہوں اس تاریک ہوجانے والے کی برائی سے۔", "Hajj", false,"");
//
//
//            dbManager.insert("Dua When Sighting The Moon", "أالسَّلَامُ عَلَيْكُمُ - وَعَلَيْكُمُ السَّلَامُ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Peace be upon you And peace be upon you too.", "مومن سے مومن کی ملاقات کے وقت کی دعا",
//                    "تم پر سلامتی ہو۔ اور تم پر بھی سلامتی ہو۔", "Hajj", false,"");
//
//
//            dbManager.insert("Dua At The Time Of Seeing A Muslim Smiling ", "أَضْحَكَ اللَّهُ سِنَّكَ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "May Allah Almighty Keep you smiling.", "کسی مسلمان کو ہنستا دیکھ کر پڑھنے کی دعا",
//                    "اللہ عزوجل تجھے ہنستا رکھے۔","Hajj", false,"");
//
//            dbManager.insert("Dua When Hearing A Donkey Or A Dog ", "اَعُوْذُ بِاللّٰہِ مِنَ الشَّیْطٰنِ الرَّجِیْمِ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek refuge with Allah from the accursed shaitan", "گدھے یا کتے کی آواز سنے یا غصہ اور برے وسوسے آئیں تو یہ پڑھے",
//                    "شیطان مردود سے اللہ تعالیٰ کی پناہ مانگتا ہوں۔۔", "Hajj", false,"");
//
//
//
//            dbManager.insert("Dua For Bride & Groom After Marriage/Nikah  ", "بَارَکَ اللّٰہُ لَکَ وَبَارَکَ عَلَیْکَ وَجَمَعَ بَیْنَکُمَا فِیْ خَیْرٍ ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Allah Azzwajal bless you and shower (send) blessing on you and place, goodness between both of you.", "نکاح کے بعد دولہا اور دلہن کے لئے دعا",
//                    "اللہ تعالیٰ آ پ دونوں (زوجین)پر برکتیں نازل فرمائیں اور دونوں کو حسن معاشرت عطافرمائیں۔۔","Hajj", false,"");
//
//
//
//            dbManager.insert("Dua When Entering Graveyard ", "اَلسَّلَامُ عَلَیْکُمْ اَھْلَ الدِّیَارِ مِنَ الْمُؤْمِنِیْنَ وَالْمُسْلِمِیْنَ ،وَاِنَّااِنْ شَآئَ اللّٰہُ بِکُمْ لَلاَحِقُوْنَ أَسْأَلُ اللّٰہَ لَنَا وَلَکُمُ الْعَافِیَةَ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Peace be upon you O inhabitants of the abodes, believers and Muslims, we will join you if Allah wills, we ask Allah for our and your well being.", "قبرستان میں داخل ہوتے وقت کی دعا",
//                    "اے مؤمنو !تم پر سلام ہو ،ہم آپ کے پاس جلد آنے والے ہیں ، اپنے لئے اور آپ کے لئے اللہ تعالیٰ سے عافیت وخیریت مانگتے ہیں۔۔", "Hajj", false,"");
//
//
//
//            dbManager.insert("Dua When Seeing Favourite Things ", "اَلْحَمْدُ لِلّٰہِ الَّذِیْ بِنِعْمَتِہ تَتِمُّ الصَّالِحَاتُ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Praise to Allah by whose grace good deeds are completed.", "پسندیدہ چیز دیکھتے وقت کی دعا",
//                    "شکر ہے اللہ کا جس کے انعام سے اچھی چیزیں کمال کو پہنچتی ہیں ۔۔", "Hajj", false,"");
//
//
//
//
//
//
//
//
//            dbManager.insert("Dua When Sighting The Moon", "أَعُوذُ بِاللَّهِ مِنْ شَرِّ هَذَا لغاسِق", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Azzawajal from the badness of this that darkness.", "جب بھی چاند پر نظر پڑھے کی دعا",
//                    "میں اللہ عزوجل کی پناہ طلب کرتا ہوں اس تاریک ہوجانے والے کی برائی سے۔","Umrah", false,"");
//
//
//            dbManager.insert("Dua When Hearing Someone Sneeze", "يَرْحَمُكَ اللَّهُ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "May Allah Almighty Have Mercy on you.", "چھینک آنے پر الحمد للہ کہنے والے کے لئے دعا",
//                    "اللہ عزوجل تجھ پر رحم کرے۔", "Umrah", false,"");
//
//
//            dbManager.insert("Dua When You Become Angry", "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Almighty from the rejected Shetan.", "غصہ آنے کے وقت کی دعا",
//                    "میں شیطان مردود سے اللہ عزوجل کی پناہ چاہتا ہوں۔","Umrah", false,"");
//
//
//            dbManager.insert("Dua Upon Sneezing", "الْحَمْدُ لِلَّهِ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "All praise onto Allah Almighty.", "چھینک آنے کے وقت کی دعا",
//                    "تمام تعریفیں اللہ عزوجل کےلئے ہیں۔", "Umrah", false,"");
//
//
//            dbManager.insert("Dua When Meeting Another Muslim", "أَعُوذُ بِاللَّهِ مِنْ شَرِّ هَذَا لغاسِق", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek the refuge of Allah Azzawajal from the badness of this that darkness.", "جب بھی چاند پر نظر پڑھے کی دعا",
//                    "میں اللہ عزوجل کی پناہ طلب کرتا ہوں اس تاریک ہوجانے والے کی برائی سے۔", "Umrah", false,"");
//
//
//            dbManager.insert("Dua When Sighting The Moon", "أالسَّلَامُ عَلَيْكُمُ - وَعَلَيْكُمُ السَّلَامُ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Peace be upon you And peace be upon you too.", "مومن سے مومن کی ملاقات کے وقت کی دعا",
//                    "تم پر سلامتی ہو۔ اور تم پر بھی سلامتی ہو۔", "Umrah", false,"");
//
//
//            dbManager.insert("Dua At The Time Of Seeing A Muslim Smiling ", "أَضْحَكَ اللَّهُ سِنَّكَ", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "May Allah Almighty Keep you smiling.", "کسی مسلمان کو ہنستا دیکھ کر پڑھنے کی دعا",
//                    "اللہ عزوجل تجھے ہنستا رکھے۔","Umrah", false,"");
//
//            dbManager.insert("Dua When Hearing A Donkey Or A Dog ", "اَعُوْذُ بِاللّٰہِ مِنَ الشَّیْطٰنِ الرَّجِیْمِ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "I seek refuge with Allah from the accursed shaitan", "گدھے یا کتے کی آواز سنے یا غصہ اور برے وسوسے آئیں تو یہ پڑھے",
//                    "شیطان مردود سے اللہ تعالیٰ کی پناہ مانگتا ہوں۔۔", "Umrah", false,"");
//
//
//
//            dbManager.insert("Dua For Bride & Groom After Marriage/Nikah  ", "بَارَکَ اللّٰہُ لَکَ وَبَارَکَ عَلَیْکَ وَجَمَعَ بَیْنَکُمَا فِیْ خَیْرٍ ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Allah Azzwajal bless you and shower (send) blessing on you and place, goodness between both of you.", "نکاح کے بعد دولہا اور دلہن کے لئے دعا",
//                    "اللہ تعالیٰ آ پ دونوں (زوجین)پر برکتیں نازل فرمائیں اور دونوں کو حسن معاشرت عطافرمائیں۔۔","Umrah", false,"");
//
//
//
//            dbManager.insert("Dua When Entering Graveyard ", "اَلسَّلَامُ عَلَیْکُمْ اَھْلَ الدِّیَارِ مِنَ الْمُؤْمِنِیْنَ وَالْمُسْلِمِیْنَ ،وَاِنَّااِنْ شَآئَ اللّٰہُ بِکُمْ لَلاَحِقُوْنَ أَسْأَلُ اللّٰہَ لَنَا وَلَکُمُ الْعَافِیَةَ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Peace be upon you O inhabitants of the abodes, believers and Muslims, we will join you if Allah wills, we ask Allah for our and your well being.", "قبرستان میں داخل ہوتے وقت کی دعا",
//                    "اے مؤمنو !تم پر سلام ہو ،ہم آپ کے پاس جلد آنے والے ہیں ، اپنے لئے اور آپ کے لئے اللہ تعالیٰ سے عافیت وخیریت مانگتے ہیں۔۔", "Umrah", false,"");
//
//
//
//            dbManager.insert("Dua When Seeing Favourite Things ", "اَلْحَمْدُ لِلّٰہِ الَّذِیْ بِنِعْمَتِہ تَتِمُّ الصَّالِحَاتُ۔", "https://www.urdupoint.com/islam/masnoon-dua/dua-when-sighting-the-moon-62.html"
//                    , "Praise to Allah by whose grace good deeds are completed.", "پسندیدہ چیز دیکھتے وقت کی دعا",
//                    "شکر ہے اللہ کا جس کے انعام سے اچھی چیزیں کمال کو پہنچتی ہیں ۔۔", "Umrah", false,"");
//
//
//
//
//
//            dbManager.close();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Options.class));
                finish();
            }
        }, 2000);
    }
}
