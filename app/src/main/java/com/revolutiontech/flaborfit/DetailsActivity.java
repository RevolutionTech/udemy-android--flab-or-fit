package com.revolutiontech.flaborfit;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends FlabOrFitActivity {

    protected int defaultBackgroundColor = Color.parseColor("#FFFFFF");

    @Override
    protected int getActivityLayout() {
        return R.id.mainBG;
    }

    @Override
    protected int getDefaultBackgroundColor() {
        return defaultBackgroundColor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseText = (TextView)findViewById(R.id.exerciseTitle);
        ImageView exerciseImg = (ImageView)findViewById(R.id.exerciseImage);
        LinearLayout mainBG = (LinearLayout)findViewById(R.id.mainBG);

        String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);
        exerciseText.setText(exerciseTitle);

        if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHTS)) {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
            defaultBackgroundColor = Color.parseColor("#2CA5F5");
        } else if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)) {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
            defaultBackgroundColor = Color.parseColor("#916BCD");
        } else {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
            defaultBackgroundColor = Color.parseColor("#52AD56");
        }
    }
}
