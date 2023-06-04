package com.example.magisc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.magisc.R;
import com.example.magisc.ads.AdmobAdsModel;
import com.example.magisc.util.myprefrence;

public class Latest_NewCricketBtnActivity extends Activity {
    private RelativeLayout addcontain;
    private RelativeLayout bannerContainer;
    private LinearLayout bannerNative;
    private FrameLayout nativeDetail;
    private TextView title;
    private RelativeLayout top;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_main3);
        //Fullimgeviewadsauto();
//        if (myprefrence.getAutoopenLink().equals("1")) {
//            myprefrence.openChromeCustomTabUrl(Latest_NewCricketBtnActivity.this);
//        }
    }

    private void initView() {
      //  this.top = (RelativeLayout) findViewById(R.id.top);
        this.title = (TextView) findViewById(R.id.title);
        this.addcontain = (RelativeLayout) findViewById(R.id.addcontain);
        this.bannerNative = (LinearLayout) findViewById(R.id.banner_native);
        this.nativeDetail = (FrameLayout) findViewById(R.id.native_detail);
        this.bannerContainer = (RelativeLayout) findViewById(R.id.banner_container);
        this.title.setText(Latest_NewMainActivity2.sports_name);
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

    public void one_day_cricket(View view) {
        myprefrence.sports_name_btn = "One Day Matches";
        next_activity();
    }

    public void Twenty_Matches(View view) {
        myprefrence.sports_name_btn = "20-Twenty Matches";
        next_activity();
    }

    public void T10_Matches(View view) {
        myprefrence.sports_name_btn = "T10 Matches ";
        next_activity();
    }

    private void next_activity() {
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewFootBallBtnActivity.class), "Next");
    }

    /* access modifiers changed from: private */
    public void Fullimgeviewadsauto() {
        if (myprefrence.getenable_appnext_id().equals("1")) {
         //   Glide.with((Activity) this).load(myprefrence.full.get(myprefrence.rendum(0, 11).intValue())).into((ImageView) findViewById(R.id.full_img));
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Latest_NewCricketBtnActivity.this.findViewById(R.id.bottofullads).setVisibility(View.VISIBLE);
                    Latest_NewCricketBtnActivity.this.findViewById(R.id.close_img).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Latest_NewCricketBtnActivity.this.findViewById(R.id.bottofullads).setVisibility(View.GONE);
                           // Latest_NewCricketBtnActivity.this.Fullimgeviewadsauto();
                        }
                    });
                }
            }, 2000);
            findViewById(R.id.bottofullads).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myprefrence.openChromeCustomTabUrl(Latest_NewCricketBtnActivity.this);
                }
            });
        }
    }
}
