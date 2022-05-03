package com.codewith3b.randomQuotes;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.codewith3b.randomQuotes.NetworkChecks.NetworkChangeListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements OnUserEarnedRewardListener {

    public static int clickCount = 0;
    TextView nextButton;
    TextView quote, writer;
    LinearLayout mainLayout;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
    QuotesList quotesList = new QuotesList();
    BackgroundsForQuotes backgrounds = new BackgroundsForQuotes();
    ImageView shareButton;
    private AdView mAdViewDown;
    private InterstitialAd mInterstitialAd;
    private RewardedInterstitialAd rewardedInterstitialAd;
    private String TAG = "MainActivity";

    @Override
    protected void onStart() {

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, intentFilter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);

        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            nextButton = findViewById(R.id.next);
            quote = findViewById(R.id.quote);
            writer = findViewById(R.id.writer);

            mainLayout = findViewById(R.id.mainLayout);

            setFrames();
        } catch (Exception e) {
            e.printStackTrace();
        }


        shareButton = findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApp();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (clickCount == 5) {

                    AdRequest adRequest = new AdRequest.Builder().build();
                    mAdViewDown.loadAd(adRequest);


                    Log.e("Error", "LOADED" + clickCount);

                    InterstitialAd.load(getApplicationContext(), "ca-app-pub-7381714812897072/1779579431",//ca-app-pub-3940256099942544/1033173712 test ad
                            adRequest,
                            new InterstitialAdLoadCallback() {
                                @Override
                                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                    // The mInterstitialAd reference will be null until
                                    // an ad is loaded.
                                    mInterstitialAd = interstitialAd;
                                    Log.i("TAG", "onAdLoaded");
                                    Log.e("Error", "LOADED" + clickCount);

                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            // Called when fullscreen content is dismissed.
                                            Log.d("TAG", "The ad was dismissed.");

                                            Log.e("Error", "closed LOADED" + clickCount);
                                            setFrames();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                                            // Called when fullscreen content failed to show.
                                            Log.d("TAG", "The ad failed to show.");
                                            Log.e("Error", "NOT LOADED" + clickCount);
                                            setFrames();
                                        }

                                        @Override
                                        public void onAdShowedFullScreenContent() {
                                            // Called when fullscreen content is shown.
                                            // Make sure to set your reference to null so you don't
                                            // show it a second time.
                                            mInterstitialAd = null;
                                            Log.d("TAG", "The ad was shown.");
                                        }
                                    });

                                }

                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    // Handle the error
                                    Log.i("TAG", loadAdError.getMessage());
                                    mInterstitialAd = null;
                                }
                            });


                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    }
                }

                if (clickCount == 9) {


                    Log.e("Error", "LOADED" + clickCount);

                    RewardedInterstitialAd.load(MainActivity.this, "ca-app-pub-7381714812897072/9669484220",//ca-app-pub-3940256099942544/5354046379 testAds
                            new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                                @Override
                                public void onAdLoaded(RewardedInterstitialAd ad) {
                                    rewardedInterstitialAd = ad;
                                    Log.e(TAG, "onAdLoaded");

                                    rewardedInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        /** Called when the ad failed to show full screen content. */
                                        @Override
                                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                                            Log.i(TAG, "onAdFailedToShowFullScreenContent");
                                            setFrames();
                                        }

                                        /** Called when ad showed the full screen content. */
                                        @Override
                                        public void onAdShowedFullScreenContent() {
                                            Log.i(TAG, "onAdShowedFullScreenContent");

                                        }

                                        /** Called when full screen content is dismissed. */
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            Log.i(TAG, "onAdDismissedFullScreenContent");
                                            setFrames();
                                        }
                                    });
                                }

                                @Override
                                public void onAdFailedToLoad(LoadAdError loadAdError) {
                                    Log.e(TAG, "onAdFailedToLoad");
                                }
                            });

                    if (rewardedInterstitialAd != null)
                        rewardedInterstitialAd.show(/* Activity */ MainActivity.this,/*
                                    OnUserEarnedRewardListener */  MainActivity.this);
                    else {
                        Log.d("TAG", "The Reward interstitial ad wasn't ready yet.");
                    }
                    clickCount = 0;
                }

                Log.e("Click Count", "" + clickCount);

                setFrames();
                clickCount++;

            }


        });


        //ads part
        try {
            mAdViewDown = findViewById(R.id.adViewDown);
            MobileAds.initialize(this, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void shareApp() {


        View savedImage = findViewById(R.id.quoteLayout).getRootView();

        Bitmap returnedBitmap = Bitmap.createBitmap(savedImage.getWidth(), savedImage.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = savedImage.getBackground();
        if (bgDrawable != null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else {  //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
            Log.d("Share", "setting white");
        }
        // draw the view on the canvas
        savedImage.draw(canvas);
        //return the bitmap


        Uri uri = getImageToShare(returnedBitmap, getApplicationContext());
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        String shareText = "**\n\n" + "QuoteApp\n" + "https://bit.ly/3qMjJan";
        intent.putExtra(Intent.EXTRA_TEXT, shareText);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quotes App");
        intent.setType("image/jpeg");
        startActivity(Intent.createChooser(intent, "Share Via"));

    }


    // Retrieving the url to share
    private Uri getImageToShare(Bitmap bitmap, Context context) {
        File imagefolder = new File(context.getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "sharedQuote.jpeg");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(context, ".provider", file);
        } catch (Exception e) {
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }


    public void setFrames() {
        try {
            int quoteNo = getRandomNumber(0, quotesList.quotes.length);

            quote.setText(quotesList.quotes[quoteNo][0]);
            writer.setText("- " + quotesList.quotes[quoteNo][1]);

            mainLayout.setBackground(backgrounds.getRandomBackground(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
        Log.i(TAG, "onUserEarnedReward");
        // TODO: Reward the user!
    }
}