package com.example.magisc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.example.magisc.util.myprefrence;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import java.util.Date;

public class AppOpenManager implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private static final String LOG_TAG = "Ankita---";
    public static boolean RefreshData = false;
    public static boolean isShowingAd = false;

    /* renamed from: aa */
    CountDownTimer f0aa = new CountDownTimer(900000000, 10) {
        public void onTick(long l) {
            if (myprefrence.OpenAllData) {
                AppOpenManager.this.showAdIfAvailable();
                AppOpenManager.this.f0aa.cancel();
            }
        }

        public void onFinish() {
        }
    };
    public AppOpenAd appOpenAd = null;
    private Activity currentActivity;
    public AppOpenAd.AppOpenAdLoadCallback loadCallback;
    /* access modifiers changed from: private */
    public long loadTime = 0;
    boolean manager = false;
    private final myprefrence myApplication;

    public AppOpenManager(myprefrence myApplication2, boolean manager2) {
        Log.e(LOG_TAG, "AppOpenManager: ");
        this.myApplication = myApplication2;
        this.manager = manager2;
        myApplication2.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void fetchAd() {
        if (!isAdAvailable()) {
            this.loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    AppOpenManager.this.appOpenAd = appOpenAd;
                    long unused = AppOpenManager.this.loadTime = new Date().getTime();
                }
            };
            AppOpenAd.load((Context) this.myApplication, myprefrence.getfull_scree_ad_load(), getAdRequest(), 1, this.loadCallback);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    public boolean isAdAvailable() {
        return this.appOpenAd != null;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    public void onActivityStarted(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityResumed(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityDestroyed(Activity activity) {
        this.currentActivity = null;
    }

    public void showAdIfAvailable() {
        RefreshData = true;
        if (isShowingAd || !isAdAvailable()) {
            RefreshData = false;
            Log.e(LOG_TAG, "Can not show ad.");
            fetchAd();
        } else if (!myprefrence.AdsOpenIntrestial) {
            this.appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                public void onAdDismissedFullScreenContent() {
                    AppOpenManager.RefreshData = false;
                    AppOpenManager.this.appOpenAd = null;
                    AppOpenManager.isShowingAd = false;
                    AppOpenManager.this.fetchAd();
                }

                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    AppOpenManager.RefreshData = false;
                }

                public void onAdShowedFullScreenContent() {
                    AppOpenManager.RefreshData = true;
                    AppOpenManager.isShowingAd = true;
                }
            });
            this.appOpenAd.show(this.currentActivity);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f0aa.start();
        Log.e("App_onstart", "onStart");
    }
}
