package com.Logik.dawn.of.ages;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class StoryScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.story_screen);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent MainScreen = new Intent(getApplicationContext(),
				MainScreen.class);
		startActivity(MainScreen);
		finish();
	}
	
	

}
