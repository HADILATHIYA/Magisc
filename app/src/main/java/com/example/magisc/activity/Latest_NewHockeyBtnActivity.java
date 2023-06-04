package com.example.magisc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.magisc.R;
import com.example.magisc.ads.AdmobAdsModel;
import com.example.magisc.util.myprefrence;

public class Latest_NewHockeyBtnActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_hockey_btn);
        ((TextView) findViewById(R.id.title)).setText(Latest_NewMainActivity2.sports_name);
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

    public void FieldHockey(View view) {
        next_activity("Field Hockey");
    }

    public void IceHockey(View view) {
        next_activity("Ice Hockey");
    }

    public void SledgeHockey(View view) {
        next_activity("Sledge Hockey");
    }

    public void RollerHockey(View view) {
        next_activity("Roller Hockey");
    }

    public void Bandy(View view) {
        next_activity("Bandy");
    }

    private void next_activity(String name) {
        myprefrence.sports_name_btn = name;
        AdmobAdsModel.Interstitial(this, new Intent(this, Latest_NewCricketIntroActivity.class), "Next");
    }
}
