package com.example.magisc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.example.magisc.R;

public class Latest_NewThankYouActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_thank_you4);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Latest_NewThankYouActivity.this.finishAffinity();
            }
        }, 1000);
    }
}
