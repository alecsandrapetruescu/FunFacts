package com.example.alecsandra.funfacts;

import java.util.Random;

public class FactBook {

    // Fields(Member Variables) - Properties about the object
    private String mFact;

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
}
