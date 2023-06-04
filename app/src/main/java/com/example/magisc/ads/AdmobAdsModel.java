package com.example.magisc.ads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.example.magisc.R;
import com.example.magisc.activity.Latest_NewSplashActivity;
import com.example.magisc.util.myprefrence;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import java.util.Objects;

public class AdmobAdsModel {
    public static NativeAd GoogleNativeBig = null;
    public static NativeAd GoogleNativeSmall;
    public static int Qureka_show = 1;
    public static String TAG = "nativeads";
    public static AdLoader adLoaderNativeSmall;
    public static TextView ad_call_to_action = null;
    public static int auto_notshow_ads = 0;
    public static int back_auto_ads = 0;
    static InterstitialAd mInterstitialAd;
    public static int qurega_auto_open_link = 0;
    Context context;
    String mTag = "AdmobAdsModel";

    public interface GetBackPointer {
        void returnAction();
    }

    public AdmobAdsModel(Context context2) {
        this.context = context2;
    }

    public static void smallnative(Context context2, RelativeLayout banner_container, View main_banner_layout) {
        if (myprefrence.getGoogle().equals("1")) {
            View adView = LayoutInflater.from(context2).inflate(R.layout.latest_new_google_native_small_banner, (ViewGroup) null);
            LinearLayout linear_ads_shows = (LinearLayout) adView.findViewById(R.id.linear_ads_shows_small_banner);
            linear_ads_shows.setVisibility(View.GONE);
            main_banner_layout.setVisibility(View.VISIBLE);
            AdLoader build = new AdLoader.Builder(context2, myprefrence.getGoogleNativ()).forNativeAd(new AdmobAdsModel$$ExternalSyntheticLambda3(linear_ads_shows, banner_container, (NativeAdView) adView.findViewById(R.id.ad_view_small_banner), adView, context2)).build();
            adLoaderNativeSmall = build;
            build.loadAd(new AdRequest.Builder().build());
        }
    }

    static /* synthetic */ void lambda$smallnative$0(LinearLayout linear_ads_shows, RelativeLayout banner_container, NativeAdView adView1, View adView, Context context2, NativeAd nativeAds) {
        GoogleNativeSmall = nativeAds;
        linear_ads_shows.setVisibility(View.VISIBLE);
        banner_container.setVisibility(View.VISIBLE);
        NativeAd nativeAd = GoogleNativeSmall;
        if (nativeAd != null) {
            populateNativeAdViewSmallBanner(nativeAd, adView1);
        }
        banner_container.removeAllViews();
        banner_container.addView(adView);
        SmallNativeload(context2);
    }

    public static void SmallNativeload(Context context2) {
        AdLoader build = new AdLoader.Builder(context2, myprefrence.getGoogleNativ()).forNativeAd(new AdmobAdsModel$$ExternalSyntheticLambda2()).withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError adError) {
            }

            public void onAdClicked() {
                super.onAdClicked();
            }

            public void onAdLoaded() {
                super.onAdLoaded();
            }

            public void onAdImpression() {
                super.onAdImpression();
            }

            public void onAdOpened() {
                super.onAdOpened();
            }
        }).build();
        adLoaderNativeSmall = build;
        build.loadAd(new AdRequest.Builder().build());
    }

    public static void populateNativeAdViewSmallBanner(NativeAd nativeAd, NativeAdView adView) {
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline_small_banner));
        adView.setBodyView(adView.findViewById(R.id.ad_body_small_banner));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action_small_banner));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon_small_banner));
        ((TextView) Objects.requireNonNull(adView.getHeadlineView())).setText(nativeAd.getHeadline());
        ((TextView) Objects.requireNonNull(adView.getBodyView())).setText(nativeAd.getBody());
        ((TextView) Objects.requireNonNull(adView.getCallToActionView())).setText(nativeAd.getCallToAction());
        if (nativeAd.getIcon() == null) {
            ((View) Objects.requireNonNull(adView.getIconView())).setVisibility(View.GONE);
        } else {
            ((ImageView) Objects.requireNonNull(adView.getIconView())).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

    public void bannerAds(Context context2, LinearLayout frameLayout) {
        AdView adView = new AdView(context2);
        adView.setAdUnitId(myprefrence.getGoogleBanner());
        adView.setAdSize(getAdSize((Activity) context2));
        frameLayout.addView(adView);
        adView.loadAd(new AdRequest.Builder().build());
        adView.setAdListener(new AdListener() {
            public void onAdClosed() {
                super.onAdClosed();
                Log.e(AdmobAdsModel.this.mTag, "onAdClosed: ");
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.d(AdmobAdsModel.this.mTag, "onAdFailedToLoad: Banner Ads " + loadAdError.getMessage());
            }

            public void onAdOpened() {
                super.onAdOpened();
                Log.e(AdmobAdsModel.this.mTag, "onAdOpened: ");
            }

            public void onAdLoaded() {
                super.onAdLoaded();
                Log.e(AdmobAdsModel.this.mTag, "onAdLoaded: ");
            }

            public void onAdClicked() {
                super.onAdClicked();
                Log.e(AdmobAdsModel.this.mTag, "onAdClicked: ");
            }

            public void onAdImpression() {
                super.onAdImpression();
                Log.e(AdmobAdsModel.this.mTag, "onAdImpression: ");
            }
        });
    }

    private static AdSize getAdSize(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    public static void interstitialAdLoad(Context context2) {
        if (myprefrence.getGoogle().equals("1")) {
            InterstitialAd.load(context2, myprefrence.getGoogleInter(), new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                public void onAdLoaded(InterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    AdmobAdsModel.mInterstitialAd = interstitialAd;
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                }
            });
        }
    }

    public static void interstitialAdShow(final Activity context2, final GetBackPointer getBackPointer) {
        InterstitialAd interstitialAd = mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.show(context2);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                }

                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                }

                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    AdmobAdsModel.interstitialAdLoad(context2);
                    if (getBackPointer != null) {
                        getBackPointer.returnAction();
                    }
                }
            });
        } else if (getBackPointer != null) {
            getBackPointer.returnAction();
        }
    }

    public static void Interstitial(Activity context2, Intent intent, String next) {
        if (next.equals("backs")) {
            if (myprefrence.getBackbuttonCount().intValue() != 5000) {
                back_auto_ads++;
                if (myprefrence.getBackbuttonCount().intValue() == back_auto_ads) {
                    context2.finish();
                    back_auto_ads = 0;
                    return;
                }
            }
            if (!myprefrence.getall_ads_start_enable_chartboost_id().equals("1")) {
                context2.finish();
            } else if (myprefrence.getGoogle().equals("1")) {
                interstitialAdShow(context2, new AdmobAdsModel$$ExternalSyntheticLambda0(myprefrence.startLoader(context2), context2));
            } else {
                context2.finish();
                AutoQuregaLinkOpen(context2);
            }
        } else {
            if (myprefrence.getauto_skip_ads().intValue() != 5000) {
                auto_notshow_ads++;
                if (Latest_NewSplashActivity.Fisttime == 0) {
                    Latest_NewSplashActivity.Fisttime = 1;
                } else if (myprefrence.getauto_skip_ads().intValue() > auto_notshow_ads) {
                    context2.startActivity(intent);
                    return;
                }
            }
            auto_notshow_ads = 0;
            if (myprefrence.getGoogle().equals("1")) {
                interstitialAdShow(context2, new AdmobAdsModel$$ExternalSyntheticLambda1(myprefrence.startLoader(context2), context2, intent));
                return;
            }
            context2.startActivity(intent);
            AutoQuregaLinkOpen(context2);
        }
    }

    static /* synthetic */ void lambda$Interstitial$2(Dialog dialog, Activity context2) {
        myprefrence.stopLoader(dialog);
        context2.finish();
        AutoQuregaLinkOpen(context2);
    }

    static /* synthetic */ void lambda$Interstitial$3(Dialog dialog, Activity context2, Intent intent) {
        myprefrence.stopLoader(dialog);
        context2.startActivity(intent);
        AutoQuregaLinkOpen(context2);
    }

    public static void LoadBig_NativeAdsID1(final Activity activity, final ViewGroup viewGroup, LinearLayout linearLayout, final RelativeLayout addcontain, final String ButtonName) {
        if (!myprefrence.getGoogle().equals("1")) {
            return;
        }
        if (GoogleNativeBig == null) {
            AdLoader.Builder builder2 = new AdLoader.Builder((Context) activity, myprefrence.getGoogleNativ());
            builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                public void onNativeAdLoaded(NativeAd nativeAd) {
//                    ViewGroup viewGroup = null;
                    AdmobAdsModel.GoogleNativeBig = nativeAd;
                    AdmobAdsModel.populateUnifiedNativeAdView(AdmobAdsModel.GoogleNativeBig, (NativeAdView) activity.getLayoutInflater().inflate(R.layout.latest_new_google_big_native, (ViewGroup) null), activity, viewGroup, addcontain, ButtonName);
                }
            });
            builder2.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(false).build()).build());
            final Activity activity2 = activity;
            final ViewGroup viewGroup2 = viewGroup;
            final LinearLayout linearLayout2 = linearLayout;
            final RelativeLayout relativeLayout = addcontain;
            final String str = ButtonName;
            builder2.withAdListener(new AdListener() {
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    AdmobAdsModel.GoogleNativeBig = null;
                    AdmobAdsModel.LoadBig_NativeAdsID2(activity2, viewGroup2, linearLayout2, relativeLayout, str);
                }

                public void onAdClicked() {
                    super.onAdClicked();
                    AdmobAdsModel.GoogleNativeBig = null;
                    AdmobAdsModel.LoadBig_NativeAdsID1(activity2, viewGroup2, linearLayout2, relativeLayout, str);
                }
            }).build().loadAd(new AdRequest.Builder().build());
            return;
        }
        ViewGroup viewGroup3 = null;
        NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.latest_new_google_big_native, (ViewGroup) null);
        NativeAdView nativeAdView2 = (NativeAdView) nativeAdView.findViewById(R.id.ad_view);
        populateUnifiedNativeAdView(GoogleNativeBig, nativeAdView, activity, viewGroup, addcontain, ButtonName);
    }

    public static void LoadBig_NativeAdsID2(final Activity activity, final ViewGroup viewGroup, LinearLayout linearLayout, final RelativeLayout addcontain, final String ButtonName) {
        if (GoogleNativeBig == null) {
            AdLoader.Builder builder2 = new AdLoader.Builder((Context) activity, myprefrence.getGoogleNativ());
            builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    Log.e(AdmobAdsModel.TAG, "NativeAdsID2 Loading: ");
                    ViewGroup viewGroup = null;
                    AdmobAdsModel.GoogleNativeBig = nativeAd;
                    AdmobAdsModel.populateUnifiedNativeAdView(AdmobAdsModel.GoogleNativeBig, (NativeAdView) activity.getLayoutInflater().inflate(R.layout.latest_new_google_big_native, (ViewGroup) null), activity, viewGroup, addcontain, ButtonName);
                }
            });
            builder2.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(false).build()).build());
            final Activity activity2 = activity;
            final LinearLayout linearLayout2 = linearLayout;
            final ViewGroup viewGroup2 = viewGroup;
            final RelativeLayout relativeLayout = addcontain;
            final String str = ButtonName;
            builder2.withAdListener(new AdListener() {
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    AdmobAdsModel.GoogleNativeBig = null;
                    AdmobAdsModel.BigBanner_ID1(activity2, linearLayout2);
                }

                public void onAdClicked() {
                    super.onAdClicked();
                    AdmobAdsModel.GoogleNativeBig = null;
                    AdmobAdsModel.LoadBig_NativeAdsID2(activity2, viewGroup2, linearLayout2, relativeLayout, str);
                }
            }).build().loadAd(new AdRequest.Builder().build());
            return;
        }
        ViewGroup viewGroup3 = null;
        NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.latest_new_google_big_native, (ViewGroup) null);
        NativeAdView nativeAdView2 = (NativeAdView) nativeAdView.findViewById(R.id.ad_view);
        populateUnifiedNativeAdView(GoogleNativeBig, nativeAdView, activity, viewGroup, addcontain, ButtonName);
    }

    public static void populateUnifiedNativeAdView(NativeAd nativeAd, NativeAdView nativeAdView, Activity activity, ViewGroup viewGroup, RelativeLayout addcontain, String ButtonName) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        ((MediaView) nativeAdView.findViewById(R.id.ad_media)).setImageScaleType(ImageView.ScaleType.CENTER_INSIDE);
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.getMediaView().setMediaContent(GoogleNativeBig.getMediaContent());
        nativeAdView.findViewById(R.id.ad_call_to_action).setBackground(ContextCompat.getDrawable(activity, R.drawable.box));
        addcontain.setVisibility(View.VISIBLE);
        try {
            ((TextView) nativeAdView.getHeadlineView()).setText(GoogleNativeBig.getHeadline());
            if (GoogleNativeBig.getBody() == null) {
                nativeAdView.getBodyView().setVisibility(View.INVISIBLE);
            } else {
                nativeAdView.getBodyView().setVisibility(View.VISIBLE);
                ((TextView) nativeAdView.getBodyView()).setText(GoogleNativeBig.getBody());
            }
            if (GoogleNativeBig.getCallToAction() == null) {
                nativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
            } else {
                nativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
                ((Button) nativeAdView.getCallToActionView()).setText("install");
            }
            if (GoogleNativeBig.getIcon() == null) {
                nativeAdView.getIconView().setVisibility(View.GONE);
            } else {
                ((ImageView) nativeAdView.getIconView()).setImageDrawable(GoogleNativeBig.getIcon().getDrawable());
                nativeAdView.getIconView().setVisibility(View.VISIBLE);
            }
            nativeAdView.setNativeAd(GoogleNativeBig);
            VideoController videoController = nativeAd.getMediaContent().getVideoController();
            if (videoController.hasVideoContent()) {
                videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                    public void onVideoEnd() {
                        super.onVideoEnd();
                    }
                });
            }
        } catch (Exception e) {
        }
        viewGroup.removeAllViews();
        viewGroup.addView(nativeAdView);
        GoogleNativeBig = null;
    }

    public static void BigBanner_ID1(final Activity activity, final LinearLayout linearLayout) {
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
        adView.setAdUnitId(myprefrence.getGoogleBanner());
        adView.loadAd(new AdRequest.Builder().build());
        linearLayout.addView(adView);
        adView.setAdListener(new AdListener() {
            public void onAdClicked() {
            }

            public void onAdClosed() {
            }

            public void onAdOpened() {
            }

            public void onAdLoaded() {
                Log.d(AdmobAdsModel.TAG, "BigBanner_ID1 onAdLoaded: ");
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.d(AdmobAdsModel.TAG, "BigBanner_ID1 onAdFailedToLoad: " + loadAdError.getCode());
                AdmobAdsModel.BigBanner_ID2(activity, linearLayout);
            }
        });
    }

    public static void BigBanner_ID2(Activity activity, LinearLayout linearLayout) {
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
        adView.setAdUnitId(myprefrence.getGoogleBanner());
        adView.loadAd(new AdRequest.Builder().build());
        linearLayout.addView(adView);
        adView.setAdListener(new AdListener() {
            public void onAdClicked() {
            }

            public void onAdClosed() {
            }

            public void onAdOpened() {
            }

            public void onAdLoaded() {
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
            }
        });
    }

    public static void AutoQuregaLinkOpen(Activity activity) {
        if (myprefrence.getAutoopenLink().equals("1")) {
            qurega_auto_open_link++;
            if (Integer.parseInt(myprefrence.getAutoopenLink_numer()) == qurega_auto_open_link) {
                myprefrence.openChromeCustomTabUrl(activity);
                qurega_auto_open_link = 0;
            }
        }
    }

    public static void Poster(final Activity activity, ImageView imageView) {
        if (myprefrence.getEnbleQurega().equals("1")) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myprefrence.openChromeCustomTabPrediction(activity);
                }
            });
            Glide.with(activity).load(myprefrence.poster.get(myprefrence.getRandomNumber(0, myprefrence.poster.size() - 1))).into(imageView);
        }
    }
}
