package com.example.magisc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.example.magisc.R;
import com.example.magisc.ads.AdmobAdsModel;
import com.example.magisc.util.myprefrence;

public class Latest_NewMainActivity2 extends Activity {
    public static String sports_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_main2);
       // Fullimgeviewadsauto();
//        if (myprefrence.getAutoopenLink().equals("1")) {
//            myprefrence.openChromeCustomTabUrl(Latest_NewMainActivity2.this);
//        }

    }

    public void Cricket(View view) {
        sports_name = "Cricket";
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewCricketBtnActivity.class), "Next");
    }

    public void Basketball(View view) {
        sports_name = "Basketball";
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewBasketballBtnActivity.class), "Next");
    }

    public void Football(View view) {
        sports_name = "Football";
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewFootBallBtnActivity.class), "Next");
    }

    public void Hockey(View view) {
        sports_name = "Hockey";
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewHockeyBtnActivity.class), "Next");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        AdmobAdsModel.interstitialAdLoad(this);
        super.onResume();
        AdmobAdsModel.smallnative(this, (RelativeLayout) findViewById(R.id.banner_container), findViewById(R.id.banner_ads_main));
        AdmobAdsModel.LoadBig_NativeAdsID1(this, (ViewGroup) findViewById(R.id.native_detail), (LinearLayout) findViewById(R.id.banner_native), (RelativeLayout) findViewById(R.id.addcontain), "Play Now");
        AdmobAdsModel.Poster(this, (ImageView) findViewById(R.id.poster1).findViewById(R.id.posters));
        AdmobAdsModel.Poster(this, (ImageView) findViewById(R.id.poster2).findViewById(R.id.posters));
    }

    public void onBackPressed() {
        AdmobAdsModel.Interstitial(this, (Intent) null, "backs");
    }

    public void Fullimgeviewadsauto() {
        if (myprefrence.getenable_appnext_id().equals("1")) {
          //  Glide.with((Activity) this).load(myprefrence.full.get(myprefrence.rendum(0, 11).intValue())).into((ImageView) findViewById(R.id.full_img));
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Latest_NewMainActivity2.this.findViewById(R.id.bottofullads).setVisibility(View.VISIBLE);
                    Latest_NewMainActivity2.this.findViewById(R.id.close_img).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Latest_NewMainActivity2.this.findViewById(R.id.bottofullads).setVisibility(View.GONE);
                            //Latest_NewMainActivity2.this.Fullimgeviewadsauto();
                        }
                    });
                }
            }, 2000);
            findViewById(R.id.bottofullads).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myprefrence.openChromeCustomTabUrl(Latest_NewMainActivity2.this);
                }
            });
        }
    }
}
