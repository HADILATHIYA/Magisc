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

public class Latest_NewFootBallBtnActivity extends Activity {
    public static String football_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_foot_ball_btn);
       // Fullimgeviewadsauto();
//        if (myprefrence.getAutoopenLink().equals("1")) {
//            myprefrence.openChromeCustomTabUrl(Latest_NewFootBallBtnActivity.this);
//        }
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

    public void Futsal(View view) {
        next_activity("Futsal");
    }

    public void Beach_Soccer(View view) {
        next_activity("Beach Soccer");
    }

    public void Street_Football(View view) {
        next_activity("Street Football");
    }

    public void Indoor_Football(View view) {
        next_activity("Indoor Football");
    }

    public void Swamp_Football(View view) {
        next_activity("Swamp Football");
    }

    private void next_activity(String name) {
        myprefrence.sports_name_btn = name;
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewCricketIntroActivity.class), "Next");
    }

    /* access modifiers changed from: private */
    public void Fullimgeviewadsauto() {
        if (myprefrence.getenable_appnext_id().equals("1")) {
          //  Glide.with((Activity) this).load(myprefrence.full.get(myprefrence.rendum(0, 11).intValue())).into((ImageView) findViewById(R.id.full_img));
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Latest_NewFootBallBtnActivity.this.findViewById(R.id.bottofullads).setVisibility(View.VISIBLE);
                    Latest_NewFootBallBtnActivity.this.findViewById(R.id.close_img).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Latest_NewFootBallBtnActivity.this.findViewById(R.id.bottofullads).setVisibility(View.GONE);
                           // Latest_NewFootBallBtnActivity.this.Fullimgeviewadsauto();
                        }
                    });
                }
            }, 2000);
            findViewById(R.id.bottofullads).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myprefrence.openChromeCustomTabUrl(Latest_NewFootBallBtnActivity.this);
                }
            });
        }
    }
}
