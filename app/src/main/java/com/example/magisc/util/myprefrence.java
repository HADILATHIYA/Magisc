package com.example.magisc.util;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.exifinterface.media.ExifInterface;

import com.example.magisc.AppOpenManager;
import com.example.magisc.R;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.Random;

public class myprefrence extends Application {
    public static boolean AdsOpenIntrestial = false;
    public static int HomeFragment_entry;
    public static boolean OpenAllData = false;
    public static myprefrence app;
    public static SharedPreferences.Editor editor;
    public static String enter_img_activity;
    public static Intent enter_img_activity_intent;
    public static ArrayList<Integer> full = new ArrayList<>();
    private static myprefrence mInstance;
    public static String match_name;
    public static ArrayList<Integer> poster = new ArrayList<>();
    public static String score1;
    public static String score2;
    public static SharedPreferences sharedPreferences;
    public static String sports_name_btn;
    public static String team1;
    public static String team2;
    public static String teamname;
    public AppOpenManager appOpenManager;

    public void onCreate() {
        super.onCreate();
        app = this;
        mInstance = this;
        new AppOpenManager(mInstance, true);
        poster.add(Integer.valueOf(R.drawable.latest_newp1));
        poster.add(Integer.valueOf(R.drawable.latest_newp2));
        poster.add(Integer.valueOf(R.drawable.latest_newp3));
        poster.add(Integer.valueOf(R.drawable.latest_newp4));
        poster.add(Integer.valueOf(R.drawable.vnewp5));
        poster.add(Integer.valueOf(R.drawable.latest_newp7));
        poster.add(Integer.valueOf(R.drawable.latest_newp8));
        poster.add(Integer.valueOf(R.drawable.latest_newp9));
        poster.add(Integer.valueOf(R.drawable.latest_newp10));
        poster.add(Integer.valueOf(R.drawable.latest_newp11));
        poster.add(Integer.valueOf(R.drawable.latest_newp12));
//        full.add(Integer.valueOf(R.drawable.latest_f_one));
//        full.add(Integer.valueOf(R.drawable.latest_f_two));
//        full.add(Integer.valueOf(R.drawable.latest_f_three));
//        full.add(Integer.valueOf(R.drawable.latest_f_four));
//        full.add(Integer.valueOf(R.drawable.latest_f_five));
//        full.add(Integer.valueOf(R.drawable.latest_f_seven));
//        full.add(Integer.valueOf(R.drawable.latest_f_six));
//        full.add(Integer.valueOf(R.drawable.latest_f_eghit));
//        full.add(Integer.valueOf(R.drawable.latest_f_nine));
//        full.add(Integer.valueOf(R.drawable.latest_f_ten));
//        full.add(Integer.valueOf(R.drawable.latest_f_eleone));
//        full.add(Integer.valueOf(R.drawable.latest_f_twel));
        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        SharedPreferences sharedPreferences2 = getSharedPreferences("my", 0);
        sharedPreferences = sharedPreferences2;
        editor = sharedPreferences2.edit();
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumber1(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumber2(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static boolean isAppInstalled(String packageName, Context context) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void openChromeCustomTabUrl(Context context) {
        try {
            if (isAppInstalled("com.android.chrome", context)) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(Color.parseColor("#448AFF"));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(getquereka_link()));
                return;
            }
            CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
            builder2.setToolbarColor(Color.parseColor("#448AFF"));
            CustomTabsIntent customTabsIntent2 = builder2.build();
            customTabsIntent2.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent2.launchUrl(context, Uri.parse(getquereka_link()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void openChromeCustomTabPrediction(Context context) {
        try {
            if (isAppInstalled("com.android.chrome", context)) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(Color.parseColor("#03549A"));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(getquereka_link()));
                return;
            }
            CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
            builder2.setToolbarColor(Color.parseColor("#03549A"));
            CustomTabsIntent customTabsIntent2 = builder2.build();
            customTabsIntent2.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent2.launchUrl(context, Uri.parse(getquereka_link()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class MyBounceInterpolator implements Interpolator {
        private double mAmplitude = 1.0d;
        private double mFrequency = 10.0d;

        public MyBounceInterpolator(double amplitude, double frequency) {
            this.mAmplitude = amplitude;
            this.mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) ((Math.pow(2.718281828459045d, ((double) (-time)) / this.mAmplitude) * -1.0d * Math.cos(this.mFrequency * ((double) time))) + 1.0d);
        }
    }

    public static void setquereka_link(String quereka_link) {
        editor.putString("quereka_link", quereka_link).commit();
    }

    public static String getquereka_link() {
        return sharedPreferences.getString("quereka_link", "12");
    }

    public static void setfirst_entry(String first_entry) {
        editor.putString("first_entry", first_entry).commit();
    }

    public static String getfirst_entry() {
        return sharedPreferences.getString("first_entry", "12");
    }

    public static void setGoogleBanner(String text) {
        editor.putString("goobanner", text).commit();
    }

    public static String getGoogleBanner() {
        return sharedPreferences.getString("goobanner", (String) null);
    }

    public static void SetGoogleInter(String text) {
        editor.putString("ginter", text).commit();
    }

    public static String getGoogleInter() {
        return sharedPreferences.getString("ginter", (String) null);
    }

    public static void setEnbleQurega(String EnbleQurega) {
        editor.putString("EnbleQurega", EnbleQurega).commit();
    }

    public static String getEnbleQurega() {
        return sharedPreferences.getString("EnbleQurega", (String) null);
    }

    public static void setad_ICON(String text) {
        editor.putString("setad_ICON", text).commit();
    }

    public static String getad_ICON() {
        return sharedPreferences.getString("setad_ICON", (String) null);
    }

    public static void setAutoopenLink(String AutoopenLink) {
        editor.putString("AutoopenLink", AutoopenLink).commit();
    }

    public static String getAutoopenLink() {
        return sharedPreferences.getString("AutoopenLink", (String) null);
    }

    public static void setAutoopenLink_numer(String AutoopenLink_numer) {
        editor.putString("AutoopenLink_numer", AutoopenLink_numer).commit();
    }

    public static String getAutoopenLink_numer() {
        return sharedPreferences.getString("AutoopenLink_numer", ExifInterface.GPS_MEASUREMENT_3D);
    }

    public static void SetBackbuttonCount(Integer BackbuttonCount) {
        editor.putInt("BackbuttonCount", BackbuttonCount.intValue()).commit();
    }

    public static Integer getBackbuttonCount() {
        return Integer.valueOf(sharedPreferences.getInt("BackbuttonCount", 50000));
    }

    public static void setauto_skip_ads(Integer auto_skip_ads) {
        editor.putInt("auto_skip_ads", auto_skip_ads.intValue()).commit();
    }

    public static Integer getauto_skip_ads() {
        return Integer.valueOf(sharedPreferences.getInt("auto_skip_ads", 5000));
    }

    public static void SetGoogleNativ(String text) {
        editor.putString("gnativ", text).commit();
    }

    public static String getGoogleNativ() {
        return sharedPreferences.getString("gnativ", (String) null);
    }

    public static void setGandQAds(String GandQAds) {
        editor.putString("GandQAds", GandQAds).commit();
    }

    public static String getGandQAds() {
        return sharedPreferences.getString("GandQAds", (String) null);
    }

    public static void setGoogle(String text) {
        editor.putString("google", text).commit();
    }

    public static String getGoogle() {
        return sharedPreferences.getString("google", (String) null);
    }

    public static void setName(String name) {
        editor.putString("ram", name).commit();
    }

    public static String getName() {
        return sharedPreferences.getString("ram", (String) null);
    }

    public static void setImage(String image) {
        editor.putString("sita", image).commit();
    }

    public static String getImage() {
        return sharedPreferences.getString("sita", (String) null);
    }

    public static void setenable_appnext_id(String setenable_appnext_id) {
        editor.putString("enable_appnext_id", setenable_appnext_id).commit();
    }

    public static String getenable_appnext_id() {
        return sharedPreferences.getString("enable_appnext_id", (String) "");
    }

    public static Dialog startLoader(Context context) {
        Dialog d = new Dialog(context);
        d.requestWindowFeature(1);
        d.getWindow().setSoftInputMode(3);
        d.setContentView(R.layout.latest_new_progressbar);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        d.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(d.getWindow().getAttributes());
        lp.width = -2;
        lp.height = -2;
        d.show();
        d.getWindow().setAttributes(lp);
        return d;
    }

    public static void stopLoader(Dialog d) {
        if (d != null && d.isShowing()) {
            d.cancel();
        }
    }

    public static boolean isInternetConnected(Context mContext) {
        try {
            ConnectivityManager connect = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connect != null) {
                NetworkInfo resultMobile = connect.getNetworkInfo(0);
                NetworkInfo resultWifi = connect.getNetworkInfo(1);
                if ((resultMobile == null || !resultMobile.isConnectedOrConnecting()) && (resultWifi == null || !resultWifi.isConnectedOrConnecting())) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Integer rendum(int min, int max) {
        return Integer.valueOf(new Random().nextInt((max - min) + 1) + min);
    }

    public static Integer rendumQureka(int min, int max) {
        return Integer.valueOf(new Random().nextInt((max - min) + 1) + min);
    }

    public static void setall_ads_start_enable_chartboost_id(String all_ads_start_enable_chartboost_id) {
        editor.putString("all_ads_start_enable_chartboost_id", all_ads_start_enable_chartboost_id).commit();
    }

    public static String getall_ads_start_enable_chartboost_id() {
        return sharedPreferences.getString("all_ads_start_enable_chartboost_id", (String) null);
    }

    public static void setall_ads_enable_ad_colony_id(String all_ads_enable_ad_colony_id) {
        editor.putString("all_ads_enable_ad_colony_id", all_ads_enable_ad_colony_id).commit();
    }

    public static String getall_ads_enable_ad_colony_id() {
        return sharedPreferences.getString("all_ads_enable_ad_colony_id", (String) null);
    }

    public static void setdialog_first(String dialog_first) {
        editor.putString("dialog_first", dialog_first).commit();
    }

    public static String getdialog_first() {
        return sharedPreferences.getString("dialog_first", "first");
    }

    public static void setenable_applovin_id(String enable_applovin_id) {
        editor.putString("enable_applovin_id", enable_applovin_id).commit();
    }

    public static String getenable_applovin_id() {
        return sharedPreferences.getString("enable_applovin_id", "12");
    }

    public static void setfull_scree_ad_load(String text) {
        editor.putString("setfull_scree_ad_load", text).commit();
    }

    public static String getfull_scree_ad_load() {
        return sharedPreferences.getString("setfull_scree_ad_load", (String) null);
    }


    public static void setgoogleopenAds(String text) {
        editor.putString("googleopenAds", text).commit();
    }

    public static String getgoogleopenAds() {
        return sharedPreferences.getString("googleopenAds", (String) null);
    }

    public static void setfull_startapp_id(String text) {
        editor.putString("startapp_id", text).commit();
    }

    public static String getfull_startapp_id() {
        return sharedPreferences.getString("startapp_id", (String) null);
    }
}
