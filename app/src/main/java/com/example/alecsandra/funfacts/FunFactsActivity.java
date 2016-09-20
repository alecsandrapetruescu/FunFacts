package com.example.alecsandra.funfacts;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    // Declare our View variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private String mFact; // = "Ants stretch when they wake up in the morning.";
    private int mColor;// = Color.parseColor("#3F51B5");

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mFact == null){
            mFact = FactBook.getFirstFact(getResources().getStringArray(R.array.FactBook));
        }

        if (mColor == 0){
            mColor = ColorWheel.getFirstColor(getResources().obtainTypedArray(R.array.colorWheel));
        }

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        // Update the screen with our dynamic fact
        mFactTextView.setText(mFact);
        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variable
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] factBook = getResources().getStringArray(R.array.FactBook);
                mFactBook.setFact(factBook);
                mFact = mFactBook.getFact();

                TypedArray colors = getResources().obtainTypedArray(R.array.colorWheel);
                mColorWheel.setColor(colors);
                mColor = mColorWheel.getColor();

                // Update the screen with our dynamic fact
                mFactTextView.setText(mFact);
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);
            }
        };
        mShowFactButton.setOnClickListener(listener);
        // Toast provides information in a small popup
        Toast.makeText(FunFactsActivity.this,"Yey random facts",Toast.LENGTH_LONG).show();
        Log.d(TAG, "We are loggin form the onCreate() method");

    }
}
