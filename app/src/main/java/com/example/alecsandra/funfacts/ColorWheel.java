package com.example.alecsandra.funfacts;

import android.content.res.TypedArray;

import java.util.Random;

public class ColorWheel {

    // Fields(Member Variables) - Properties about the object
    private int mColor;

    // Methods - Actions the object can take
    public void setColor(TypedArray mColorWheel) {
        //Randomly select a color
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColorWheel.length());
        mColor = mColorWheel.getColor(randomNumber, 0);
    }

    public int getColor(){
        return mColor;
    }

    public static int getFirstColor(TypedArray colors) {
        return  colors.getColor(3, 0);
    }
}