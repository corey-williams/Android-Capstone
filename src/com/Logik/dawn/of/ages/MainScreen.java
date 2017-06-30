package com.Logik.dawn.of.ages;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);

		TextView textView1 = (TextView) findViewById(R.id.textQuest);
		Typeface type = Typeface.createFromAsset(getAssets(), "vineritc.ttf");
		textView1.setTypeface(type);

		Button PlayScreen = (Button) findViewById(R.id.PlayScreen);
		PlayScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(v.getContext(), BeforeYouBegin.class);
				startActivityForResult(intent, 0);
				finish();
			}
		});

		Button StoryScreen = (Button) findViewById(R.id.StoryScreen);
		StoryScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(v.getContext(), StoryScreen.class);
				startActivityForResult(intent, 0);
			}
		});

		Button HTPScreen = (Button) findViewById(R.id.HTPScreen);
		HTPScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(v.getContext(), HTPScreen.class);
				startActivityForResult(intent, 0);
			}
		});

		Button CreditsScreen = (Button) findViewById(R.id.CreditsScreen);
		CreditsScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(v.getContext(), CreditsScreen.class);
				startActivityForResult(intent, 0);
			}
		});
	}

	@Override
	public void onBackPressed() {
		this.finish();
		return;
	}
}