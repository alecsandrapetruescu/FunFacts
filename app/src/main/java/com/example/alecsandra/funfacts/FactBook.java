package com.example.alecsandra.funfacts;

import android.content.res.Resources;
import android.util.Log;

import java.util.Random;

public class FactBook {

    // Fields(Member Variables) - Properties about the object
    protected String mFact;

    // Methods - Actions the object can take
    public void setFact(String[] mFacts){
        //Randomly select a fact
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);
        mFact = mFacts[randomNumber];
    }

    public String getFact(){
        return mFact;
    }

    public static String getFirstFact(String[] mFacts){
        Log.d("this is the first fact" , mFacts[0]);
        return mFacts[0];
    }


}
