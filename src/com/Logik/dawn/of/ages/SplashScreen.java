package com.Logik.dawn.of.ages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		getActionBar().hide();
		
		Thread splashTimer = new Thread() {
			public void run() {
				try { 
					sleep(3000);
					Intent mainScreen = new Intent(getApplicationContext(), MainScreen.class);
					startActivity(mainScreen);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					finish();
				}
			}
		};
		splashTimer.start();
	}
	

}
