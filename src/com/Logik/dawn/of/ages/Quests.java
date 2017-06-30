package com.Logik.dawn.of.ages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Quests extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quests);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);

		TextView textView1 = (TextView) findViewById(R.id.textQuest);
		Typeface type = Typeface.createFromAsset(getAssets(), "vineritc.ttf");
		textView1.setTypeface(type);

		final ListView Quests = (ListView) findViewById(R.id.listViewQuests1);

		List<HashMap<String, String>> QuestsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "Test Quest");
			temp.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "Test Quest");
			temp1.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "Test Quest");
			temp2.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "Test Quest");
			temp3.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "Test Quest");
			temp4.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "Test Quest");
			temp5.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "Test Quest");
			temp6.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp6);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "Test Quest");
			temp7.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "Test Quest");
			temp8.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp8);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "Test Quest");
			temp9.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "Test Quest");
			temp10.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp10);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "Test Quest");
			temp11.put("Requirements", "Req. Level: ?");
			QuestsData.add(temp11);

		}

		SimpleAdapter QuestsAdapter = new SimpleAdapter(this, QuestsData, R.layout.custom_row_view, new String[] { "Item", "Requirements" },
				new int[] { R.id.text1, R.id.text2 });

		Quests.setAdapter(QuestsAdapter);

		Quests.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Quests.this);
				switch (arg2) {
				case 0:
					dlgAlert.setMessage("Start quest?");
					dlgAlert.setTitle("Test Quest #1");
					dlgAlert.setPositiveButton("Start", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Intent TestQuest = new Intent(getApplicationContext(), TestQuest.class);
							startActivity(TestQuest);
							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				}

			}

		});
	}

}
