package com.codewith3b.randomQuotes;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class BackgroundsForQuotes {

    Drawable drawable ;


    public Drawable getRandomBackground(Context context)
    {

        int no = getRandomNumber(1,50);

        switch (no)
        {

            case 1:
                drawable = ContextCompat.getDrawable(context,R.drawable._1);
                break;

            case 2:
                drawable = ContextCompat.getDrawable(context,R.drawable._2);
                break;

            case 3:
                drawable = ContextCompat.getDrawable(context,R.drawable._3);
                break;

            case 4:
                drawable = ContextCompat.getDrawable(context,R.drawable._4);
                break;

            case 5:
                drawable = ContextCompat.getDrawable(context,R.drawable._5);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(context,R.drawable._6);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(context,R.drawable._7);
                break;

            case 8:
                drawable = ContextCompat.getDrawable(context,R.drawable._8);
                break;

            case 9:
                drawable = ContextCompat.getDrawable(context,R.drawable._9);
                break;

            case 10:
                drawable = ContextCompat.getDrawable(context,R.drawable._10);
                break;

            case 11:
                drawable = ContextCompat.getDrawable(context,R.drawable._11);
                break;

            case 12:
                drawable = ContextCompat.getDrawable(context,R.drawable._12);
                break;

            case 13:
                drawable = ContextCompat.getDrawable(context,R.drawable._13);
                break;

            case 14:
                drawable = ContextCompat.getDrawable(context,R.drawable._14);
                break;

            case 15:
                drawable = ContextCompat.getDrawable(context,R.drawable._15);
                break;
            case 16:
                drawable = ContextCompat.getDrawable(context,R.drawable._16);
                break;
            case 17:
                drawable = ContextCompat.getDrawable(context,R.drawable._17);
                break;
            case 18:
                drawable = ContextCompat.getDrawable(context,R.drawable._18);
                break;
            case 19:
                drawable = ContextCompat.getDrawable(context,R.drawable._19);
                break;
            case 20:
                drawable = ContextCompat.getDrawable(context,R.drawable._20);
                break;
            case 21:
                drawable = ContextCompat.getDrawable(context,R.drawable._21);
                break;
            case 22:
                drawable = ContextCompat.getDrawable(context,R.drawable._22);
                break;
            case 23:
                drawable = ContextCompat.getDrawable(context,R.drawable._23);
                break;
            case 24:
                drawable = ContextCompat.getDrawable(context,R.drawable._24);
                break;
            case 25:
                drawable = ContextCompat.getDrawable(context,R.drawable._25);
                break;
            case 26:
                drawable = ContextCompat.getDrawable(context,R.drawable._26);
                break;
            case 27:
                drawable = ContextCompat.getDrawable(context,R.drawable._27);
                break;
            case 28:
                drawable = ContextCompat.getDrawable(context,R.drawable._28);
                break;
            case 29:
                drawable = ContextCompat.getDrawable(context,R.drawable._29);
                break;
            case 30:
                drawable = ContextCompat.getDrawable(context,R.drawable._30);
                break;
            case 31:
                drawable = ContextCompat.getDrawable(context,R.drawable._31);
                break;
            case 32:
                drawable = ContextCompat.getDrawable(context,R.drawable._32);
                break;
            case 33:
                drawable = ContextCompat.getDrawable(context,R.drawable._33);
                break;
            case 34:
                drawable = ContextCompat.getDrawable(context,R.drawable._34);
                break;
            case 35:
                drawable = ContextCompat.getDrawable(context,R.drawable._35);
                break;
            case 36:
                drawable = ContextCompat.getDrawable(context,R.drawable._36);
                break;
            case 37:
                drawable = ContextCompat.getDrawable(context,R.drawable._37);
                break;
            case 38:
                drawable = ContextCompat.getDrawable(context,R.drawable._38);
                break;
            case 39:
                drawable = ContextCompat.getDrawable(context,R.drawable._39);
                break;
            case 40:
                drawable = ContextCompat.getDrawable(context,R.drawable._40);
                break;
            case 41:
                drawable = ContextCompat.getDrawable(context,R.drawable._41);
                break;
            case 42:
                drawable = ContextCompat.getDrawable(context,R.drawable._42);
                break;
            case 43:
                drawable = ContextCompat.getDrawable(context,R.drawable._43);
                break;
            case 44:
                drawable = ContextCompat.getDrawable(context,R.drawable._44);
                break;
            case 45:
                drawable = ContextCompat.getDrawable(context,R.drawable._45);
                break;
            case 46:
                drawable = ContextCompat.getDrawable(context,R.drawable._46);
                break;
            case 47:
                drawable = ContextCompat.getDrawable(context,R.drawable._47);
                break;
            case 48:
                drawable = ContextCompat.getDrawable(context,R.drawable._48);
                break;
            case 49:
                drawable = ContextCompat.getDrawable(context,R.drawable._49);
                break;
            case 50:
                drawable = ContextCompat.getDrawable(context,R.drawable._50);
                break;

            default:
                drawable = ContextCompat.getDrawable(context,R.drawable._10);
                break;

        }

        return drawable;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
