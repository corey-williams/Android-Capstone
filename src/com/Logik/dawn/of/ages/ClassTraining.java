package com.Logik.dawn.of.ages;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class ClassTraining extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_training_screen);
        
        ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
       
    }

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent PlayScreen = new Intent(getApplicationContext(),
				PlayScreen.class);
		startActivity(PlayScreen);
		finish();
	}
    
}
        
    