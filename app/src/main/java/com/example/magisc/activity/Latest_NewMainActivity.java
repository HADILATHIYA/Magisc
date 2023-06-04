package com.example.magisc.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.example.magisc.R;
import com.example.magisc.ads.AdmobAdsModel;
import com.example.magisc.util.myprefrence;


public class Latest_NewMainActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_main);
       // Fullimgeviewadsauto();
        if (myprefrence.getAutoopenLink().equals("1")) {
            myprefrence.openChromeCustomTabUrl(Latest_NewMainActivity.this);
        }
    }

    public void share(View view) {
        try {
            Intent shareIntent = new Intent("android.intent.action.SEND");
            shareIntent.setType("text/plain");
            shareIntent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
            shareIntent.putExtra("android.intent.extra.TEXT", ("\nCheckout " + getResources().getString(R.string.app_name) + " App at: \n\n") + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName() + "\n\n");
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
        }
    }

    public void rate(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    public void next(View view) {
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewMainActivity2.class), "Next");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        AdmobAdsModel.interstitialAdLoad(this);
        super.onResume();
        AdmobAdsModel.smallnative(this, (RelativeLayout) findViewById(R.id.banner_container), findViewById(R.id.banner_ads_main));
        AdmobAdsModel.LoadBig_NativeAdsID1(this,(FrameLayout) findViewById(R.id.native_detail), (LinearLayout) findViewById(R.id.banner_native), findViewById(R.id.addcontain), "Play Now");
    }

    public void onBackPressed() {
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewExitActivity.class), "Next");
    }

    /* access modifiers changed from: private */
    public void Fullimgeviewadsauto() {
        if (myprefrence.getenable_appnext_id().equals("1")) {
         //   Glide.with((Activity) this).load(myprefrence.full.get(myprefrence.rendum(0, 11).intValue())).into((ImageView) findViewById(R.id.full_img));
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Latest_NewMainActivity.this.findViewById(R.id.bottofullads).setVisibility(View.VISIBLE);
                    Latest_NewMainActivity.this.findViewById(R.id.close_img).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Latest_NewMainActivity.this.findViewById(R.id.bottofullads).setVisibility(View.GONE);
                          //  Latest_NewMainActivity.this.Fullimgeviewadsauto();
                        }
                    });
                }
            }, 1000);
            findViewById(R.id.bottofullads).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myprefrence.openChromeCustomTabUrl(Latest_NewMainActivity.this);
                }
            });
        }
    }
}
