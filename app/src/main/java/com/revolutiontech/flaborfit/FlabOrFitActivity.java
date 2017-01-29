package com.revolutiontech.flaborfit;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * Created by lucas on 1/28/17.
 */

public abstract class FlabOrFitActivity extends AppCompatActivity {

    protected abstract int getActivityLayout();

    protected int getDefaultBackgroundColor() {
        return Color.parseColor("#FFFFFF");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBackgroundForNightMode();
    }

    private void updateBackgroundForNightMode() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nightMode = sharedPref.getBoolean(SettingsActivity.KEY_PREF_NIGHT_MODE, false);

        int color;
        if (nightMode) {
            color = Color.parseColor("#444444");
        } else {
            color = getDefaultBackgroundColor();
        }

        LinearLayout layout = (LinearLayout)findViewById(getActivityLayout());
        layout.setBackgroundColor(color);
    }
}
