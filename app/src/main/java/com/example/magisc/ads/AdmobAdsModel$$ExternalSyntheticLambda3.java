package com.example.magisc.ads;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdmobAdsModel$$ExternalSyntheticLambda3 implements NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ LinearLayout f$0;
    public final /* synthetic */ RelativeLayout f$1;
    public final /* synthetic */ NativeAdView f$2;
    public final /* synthetic */ View f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ AdmobAdsModel$$ExternalSyntheticLambda3(LinearLayout linearLayout, RelativeLayout relativeLayout, NativeAdView nativeAdView, View view, Context context) {
        this.f$0 = linearLayout;
        this.f$1 = relativeLayout;
        this.f$2 = nativeAdView;
        this.f$3 = view;
        this.f$4 = context;
    }

    public final void onNativeAdLoaded(NativeAd nativeAd) {
        AdmobAdsModel.lambda$smallnative$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, nativeAd);
    }
}
