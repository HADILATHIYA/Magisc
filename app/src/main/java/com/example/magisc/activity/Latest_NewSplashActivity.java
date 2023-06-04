package com.example.magisc.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;

import com.example.magisc.R;
import com.example.magisc.util.myprefrence;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.BuildConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;


public class Latest_NewSplashActivity extends Activity {
    public static int Fisttime = 0;
    private String enable_chartboost_id = "";
    private String chartboost_id_1 = "";
    private String enable_applovin_id = "";
    private String facebook_native_id = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_splash_activity);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.app_color));

        FirebaseApp.initializeApp(Latest_NewSplashActivity.this);
        List<String> testDeviceIds = Arrays.asList("5AEBF0D7271F929CA26799AC4CC52193");
        RequestConfiguration configuration = new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        if (myprefrence.isInternetConnected(this)) {

            Admobload();
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LoadAdsandNext();
                }
            }, 4000);

        } else {
            startActivity(new Intent(this, Latest_NewNoInternet.class));
        }
    }

    @SuppressLint("VisibleForTests")
    public void Admobload() {
        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
//        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                if (task.isSuccessful()) {
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_google_admob_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("google_admob_banner_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("google_admob_interstitial_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("google_admob_native_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("google_admob_rewarded_video_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_quereka_link"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("quereka_link"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_ad_colony_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_startapp_id"));

                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_appnext_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("startapp_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_chartboost_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("enable_applovin_id"));
                    Log.e("loadAdsData: ", "----------+-" + mFirebaseRemoteConfig.getString("facebook_native_id"));


                    Log.e("onSuccess", "onSuccess: ");
                    myprefrence.setGoogle(mFirebaseRemoteConfig.getString("enable_google_admob_id"));
                    myprefrence.setGoogleBanner(mFirebaseRemoteConfig.getString("google_admob_banner_id"));
                    myprefrence.SetGoogleInter(mFirebaseRemoteConfig.getString("google_admob_interstitial_id"));
                    myprefrence.SetGoogleNativ(mFirebaseRemoteConfig.getString("google_admob_native_id"));
                    myprefrence.setfull_scree_ad_load(mFirebaseRemoteConfig.getString("google_admob_rewarded_video_id"));
                    myprefrence.setEnbleQurega(mFirebaseRemoteConfig.getString("enable_quereka_link"));
                    myprefrence.setquereka_link(mFirebaseRemoteConfig.getString("quereka_link"));
                    myprefrence.setad_ICON(mFirebaseRemoteConfig.getString("enable_ad_colony_id"));
                    myprefrence.setAutoopenLink(mFirebaseRemoteConfig.getString("enable_startapp_id"));
                    myprefrence.setenable_appnext_id(mFirebaseRemoteConfig.getString("enable_appnext_id"));
                    myprefrence.setfull_startapp_id(mFirebaseRemoteConfig.getString("startapp_id"));
                    myprefrence.setgoogleopenAds(mFirebaseRemoteConfig.getString("googleopenAds"));
                }
            }
        });

    }

    private void LoadAdsandNext() {
        try {
            try {
                if (myprefrence.getfull_startapp_id().equals("") || myprefrence.getfull_startapp_id().isEmpty()) {
                    myprefrence.setAutoopenLink_numer(ExifInterface.GPS_MEASUREMENT_3D);
                } else {
                    myprefrence.setAutoopenLink_numer(myprefrence.getfull_startapp_id());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            myprefrence.setall_ads_start_enable_chartboost_id(enable_chartboost_id);
            try {
                if (chartboost_id_1.equals("") || chartboost_id_1.isEmpty()) {
                    myprefrence.SetBackbuttonCount(5000);
                } else {
                    myprefrence.SetBackbuttonCount(Integer.valueOf(chartboost_id_1));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (facebook_native_id.equals("") || facebook_native_id.isEmpty()) {
                    myprefrence.setauto_skip_ads(5000);
                } else {
                    myprefrence.setauto_skip_ads(Integer.valueOf(facebook_native_id));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            myprefrence.setGandQAds(enable_applovin_id);
            try {
                if (myprefrence.getGoogle().equals("1")) {
                    try {
                        AppOpenAd.load((Context) Latest_NewSplashActivity.this, myprefrence.getgoogleopenAds(), new AdRequest.Builder().build(), 1, new AppOpenAd.AppOpenAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                                super.onAdLoaded(appOpenAd);
                                appOpenAd.show(Latest_NewSplashActivity.this);
                                appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        super.onAdShowedFullScreenContent();
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Latest_NewSplashActivity.this.Next();
                                        super.onAdDismissedFullScreenContent();
                                    }

                                    @Override
                                    public void onAdImpression() {
                                        super.onAdImpression();
                                    }

                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
                                    }
                                });
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                super.onAdFailedToLoad(loadAdError);
                                myprefrence.AdsOpenIntrestial = false;
                                myprefrence.OpenAllData = true;
                                Latest_NewSplashActivity.this.Next();
                            }
                        });

                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return;
                } else {
                    Latest_NewSplashActivity.this.Next();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void Next() {
        startActivity(new Intent(this, Latest_NewMainActivity.class));
        finish();
    }
}
