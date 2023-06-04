package com.example.magisc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.magisc.R;
import com.example.magisc.util.myprefrence;

public class Latest_NewNoInternet extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_no_internet);
    }

    public void onClick(View view) {
        if (myprefrence.isInternetConnected(this)) {
            startActivity(new Intent(this, Latest_NewSplashActivity.class));
            finish();
        }
    }

    public void onBackPressed() {
    }
}
