package com.electricity.costcalculator;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdsManager
{


    public  static com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    public static void  loadInterstatial()
    {
        mInterstitialAd=null;
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(App.context,"ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded (@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;

            }

            @Override
            public void onAdFailedToLoad (@NonNull LoadAdError loadAdError) {
                // Handle the error

                mInterstitialAd = null;
            }
        });

    }
    public  static  InterstitialAd  getInterstatial()
    {
        return mInterstitialAd;
    }
    public  static  void loadBanner (Activity activity)
    {
        AdView mAdView = activity.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
