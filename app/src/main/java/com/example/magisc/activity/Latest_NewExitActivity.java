package com.example.magisc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import com.example.magisc.R;
import com.example.magisc.ads.AdmobAdsModel;

public class Latest_NewExitActivity extends Activity {
    private AppCompatButton btnexit;
    private AppCompatButton btnrate;

    /* access modifiers changed from: protected */
    public void onResume() {
        AdmobAdsModel.interstitialAdLoad(this);
        super.onResume();
        AdmobAdsModel.smallnative(this, (RelativeLayout) findViewById(R.id.banner_container), findViewById(R.id.banner_ads_main));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_new_activity_exit);
        initView();
    }

    private void initView() {
        this.btnexit = (AppCompatButton) findViewById(R.id.btnexit);
        AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.btnrate);
        this.btnrate = appCompatButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Latest_NewExitActivity.this.startActivity(new Intent(Latest_NewExitActivity.this, Latest_NewMainActivity.class));
                Latest_NewExitActivity.this.finish();
            }
        });
        this.btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Latest_NewExitActivity.this.startActivity(new Intent(Latest_NewExitActivity.this, Latest_NewThankYouActivity.class));
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, Latest_NewMainActivity.class));
        finish();
    }
}
