package com.revolutiontech.flaborfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String EXERCISE_WEIGHTS = "Weight lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout weightBtn = (RelativeLayout)findViewById(R.id.weightBtn);
        RelativeLayout yogaBtn = (RelativeLayout)findViewById(R.id.yogaBtn);
        RelativeLayout cardioBtn = (RelativeLayout)findViewById(R.id.cardioBtn);

        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_WEIGHTS);
            }
        });

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_YOGA);
            }
        });

        cardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_CARDIO);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBackgroundForNightMode();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        // Handle settings option
        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return true;
    }

    private void updateBackgroundForNightMode() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nightMode = sharedPref.getBoolean(SettingsActivity.KEY_PREF_NIGHT_MODE, false);

        int color;
        if (nightMode) {
            color = Color.parseColor("#444444");
        } else {
            color = Color.parseColor("#FFFFFF");
        }

        LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main);
        layout.setBackgroundColor(color);
    }

    private void loadDetailActivity(String exerciseTitle) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exerciseTitle);
        startActivity(intent);
    }
}
