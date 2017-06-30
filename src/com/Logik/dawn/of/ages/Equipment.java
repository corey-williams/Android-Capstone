package com.Logik.dawn.of.ages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.Logik.dawn.of.ages.R.drawable;

import Databases.DBAdapter;
import Databases.DBAdapter_Class;
import Databases.DBAdapter_Equipment_Chest;
import Databases.DBAdapter_Equipment_Feet;
import Databases.DBAdapter_Equipment_Hands;
import Databases.DBAdapter_Equipment_Head;
import Databases.DBAdapter_Equipment_Legs;
import Databases.DBAdapter_Equipment_PH;
import Databases.DBAdapter_Equipment_SH;
import Databases.DBAdapter_Equipment_Spells;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Equipment extends Activity {

	DBAdapter db = new DBAdapter(this);
	DBAdapter_Equipment_Head dbHead = new DBAdapter_Equipment_Head(this);
	DBAdapter_Equipment_Chest dbChest = new DBAdapter_Equipment_Chest(this);
	DBAdapter_Equipment_Hands dbHands = new DBAdapter_Equipment_Hands(this);
	DBAdapter_Equipment_Legs dbLegs = new DBAdapter_Equipment_Legs(this);
	DBAdapter_Equipment_Feet dbFeet = new DBAdapter_Equipment_Feet(this);
	DBAdapter_Equipment_PH dbPH = new DBAdapter_Equipment_PH(this);
	DBAdapter_Equipment_SH dbSH = new DBAdapter_Equipment_SH(this);
	DBAdapter_Equipment_Spells dbSpells = new DBAdapter_Equipment_Spells(this);
	DBAdapter_Class dbClass = new DBAdapter_Class(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.equipment_screen);

		TextView txtStat1 = (TextView) findViewById(R.id.textView17);
		TextView txtStat2 = (TextView) findViewById(R.id.textView18);
		TextView txtStat3 = (TextView) findViewById(R.id.textView19);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
		bar.setLogo(drawable.equipment_logo);

		databaseOpen();

		Button btnUnequip = (Button) findViewById(R.id.btnUnequip);
		btnUnequip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final CharSequence[] items = { "Head", "Chest", "Hands", "Legs", "Feet", "Primary Hand", "Secondary Hand" };
				final boolean[] states = { false, false, false, false, false, false, false };

				AlertDialog.Builder builder = new AlertDialog.Builder(Equipment.this);
				builder.setTitle("What would you like to unequip?");
				builder.setMultiChoiceItems(items, states, new DialogInterface.OnMultiChoiceClickListener() {
					public void onClick(DialogInterface dialogInterface, int item, boolean state) {
					}
				});
				builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						SparseBooleanArray CheCked = ((AlertDialog) dialog).getListView().getCheckedItemPositions();
						if (CheCked.get(0)) {
							TextView textViewHead = (TextView) findViewById(R.id.textView9);
							dbHead.open();
							Cursor cHead = DBAdapter_Equipment_Head.getAllRecords();
							cHead.moveToFirst();
							if (!(textViewHead.getText().toString().equals("Head: "))) {
								db.open();
								db.insertRecord(textViewHead.getText().toString().replace("Head: ", ""));
								db.close();
								dbHead.insertRecord("");
								textViewHead.setText("Head: ");
								dbHead.close();
							}
						}
						if (CheCked.get(1)) {
							TextView textViewChest = (TextView) findViewById(R.id.textView3);
							dbChest.open();
							Cursor cChest = DBAdapter_Equipment_Chest.getAllRecords();
							cChest.moveToFirst();
							if (!(textViewChest.getText().toString().equals("Chest: "))) {
								db.open();
								db.insertRecord(textViewChest.getText().toString().replace("Chest: ", ""));
								db.close();
								dbChest.insertRecord("");
								textViewChest.setText("Chest: ");
								dbChest.close();
							}
						}
						if (CheCked.get(2)) {
							TextView textViewHands = (TextView) findViewById(R.id.textView4);
							dbHands.open();
							Cursor cHands = DBAdapter_Equipment_Hands.getAllRecords();
							cHands.moveToFirst();
							if (!(textViewHands.getText().toString().equals("Hands: "))) {
								db.open();
								db.insertRecord(textViewHands.getText().toString().replace("Hands: ", ""));
								db.close();
								dbHands.insertRecord("");
								textViewHands.setText("Hands: ");
								dbHands.close();
							}
						}
						if (CheCked.get(3)) {
							TextView textViewLegs = (TextView) findViewById(R.id.textView5);
							dbLegs.open();
							Cursor cLegs = DBAdapter_Equipment_Legs.getAllRecords();
							cLegs.moveToFirst();
							if (!(textViewLegs.getText().toString().equals("Legs: "))) {
								db.open();
								db.insertRecord(textViewLegs.getText().toString().replace("Legs: ", ""));
								db.close();
								dbLegs.insertRecord("");
								textViewLegs.setText("Legs: ");
								dbLegs.close();
							}
						}
						if (CheCked.get(4)) {
							TextView textViewFeet = (TextView) findViewById(R.id.textView6);
							dbFeet.open();
							Cursor cFeet = DBAdapter_Equipment_Feet.getAllRecords();
							cFeet.moveToFirst();
							if (!(textViewFeet.getText().toString().equals("Feet: "))) {
								db.open();
								db.insertRecord(textViewFeet.getText().toString().replace("Feet: ", ""));
								db.close();
								dbFeet.insertRecord("");
								textViewFeet.setText("Feet: ");
								dbFeet.close();
							}
						}
						if (CheCked.get(5)) {
							TextView textViewPH = (TextView) findViewById(R.id.textView7);
							dbPH.open();
							Cursor cPH = DBAdapter_Equipment_PH.getAllRecords();
							cPH.moveToFirst();
							if (!(textViewPH.getText().toString().equals("Primary Hand: "))) {
								db.open();
								db.insertRecord(textViewPH.getText().toString().replace("Primary Hand: ", ""));
								db.close();
								dbPH.insertRecord("");
								textViewPH.setText("Primary Hand: ");
								dbPH.close();
							}
						}
						if (CheCked.get(6)) {
							TextView textViewSH = (TextView) findViewById(R.id.textView8);
							dbSH.open();
							Cursor cSH = DBAdapter_Equipment_SH.getAllRecords();
							cSH.moveToFirst();
							if (!(textViewSH.getText().toString().equals("Secondary Hand: "))) {
								db.open();
								db.insertRecord(textViewSH.getText().toString().replace("Secondary Hand: ", ""));
								db.close();
								dbSH.insertRecord("");
								textViewSH.setText("Secondary Hand: ");
								dbSH.close();
							}
						}
					}
				});
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				builder.create().show();
			}
		});
	}

	private void databaseOpen() {
		dbHead.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/HeadDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("HeadDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_Head dbHead = new DBAdapter_Equipment_Head(this);

		try {
			dbHead.open();
			Cursor cHead = DBAdapter_Equipment_Head.getAllRecords();
			if (cHead.moveToFirst()) {
				do {
					DisplayRecordHead(cHead);
				} while (cHead.moveToNext());
			}
			dbHead.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbChest.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/ChestDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("ChestDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_Chest dbChest = new DBAdapter_Equipment_Chest(this);

		try {
			dbChest.open();
			Cursor cChest = DBAdapter_Equipment_Chest.getAllRecords();
			if (cChest.moveToFirst()) {
				do {
					DisplayRecordChest(cChest);
				} while (cChest.moveToNext());
			}
			dbChest.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbHands.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/HandsDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("HandsDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_Hands dbHands = new DBAdapter_Equipment_Hands(this);

		try {
			dbHands.open();
			Cursor cHands = DBAdapter_Equipment_Hands.getAllRecords();
			if (cHands.moveToFirst()) {
				do {
					DisplayRecordHands(cHands);
				} while (cHands.moveToNext());
			}
			dbHands.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbLegs.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/LegsDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("LegsDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_Legs dbLegs = new DBAdapter_Equipment_Legs(this);

		try {
			dbLegs.open();
			Cursor cLegs = DBAdapter_Equipment_Legs.getAllRecords();
			if (cLegs.moveToFirst()) {
				do {
					DisplayRecordLegs(cLegs);
				} while (cLegs.moveToNext());
			}
			dbHead.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbFeet.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/FeetDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("FeetDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_Feet dbFeet = new DBAdapter_Equipment_Feet(this);

		try {
			dbFeet.open();
			Cursor cFeet = DBAdapter_Equipment_Feet.getAllRecords();
			if (cFeet.moveToFirst()) {
				do {
					DisplayRecordFeet(cFeet);
				} while (cFeet.moveToNext());
			}
			dbFeet.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbPH.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/PHDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("PHDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_PH dbPH = new DBAdapter_Equipment_PH(this);

		try {
			dbPH.open();
			Cursor cPH = DBAdapter_Equipment_PH.getAllRecords();
			if (cPH.moveToFirst()) {
				do {
					DisplayRecordPH(cPH);
				} while (cPH.moveToNext());
			}
			dbPH.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbSH.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/SHDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("SHDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final DBAdapter_Equipment_SH dbSH = new DBAdapter_Equipment_SH(this);

		try {
			dbSH.open();
			Cursor cSH = DBAdapter_Equipment_SH.getAllRecords();
			if (cSH.moveToFirst()) {
				do {
					DisplayRecordSH(cSH);
				} while (cSH.moveToNext());
			}
			dbSH.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		dbSpells.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/SpellsDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("SpellsDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbClass.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/ClassDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("ClassDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBAdapter_Class dbClass = new DBAdapter_Class(this);

		try {
			dbClass.open();
			Cursor cClass = DBAdapter_Class.getAllRecords();
			if (cClass.moveToFirst()) {
				do {
					DisplayRecordClass(cClass);
				} while (cClass.moveToNext());
			}
			dbClass.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

	}

	public void CopyDB(InputStream inputStream, OutputStream outputStream) throws IOException {
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

	public void DisplayRecordHead(final Cursor cHead) {
		TextView textViewHead = (TextView) findViewById(R.id.textView9);
		textViewHead.setText("Head: " + cHead.getString(1));
	}

	public void DisplayRecordChest(final Cursor cChest) {
		TextView textViewChest = (TextView) findViewById(R.id.textView3);
		textViewChest.setText("Chest: " + cChest.getString(1));
	}

	public void DisplayRecordHands(final Cursor cHands) {
		TextView textViewHands = (TextView) findViewById(R.id.textView4);
		textViewHands.setText("Hands: " + cHands.getString(1));
	}

	public void DisplayRecordLegs(final Cursor cLegs) {
		TextView textViewLegs = (TextView) findViewById(R.id.textView5);
		textViewLegs.setText("Legs: " + cLegs.getString(1));
	}

	public void DisplayRecordFeet(final Cursor cFeet) {
		TextView textViewFeet = (TextView) findViewById(R.id.textView6);
		textViewFeet.setText("Feet: " + cFeet.getString(1));
	}

	public void DisplayRecordPH(final Cursor cPH) {
		TextView textViewPH = (TextView) findViewById(R.id.textView7);
		textViewPH.setText("Primary Hand: " + cPH.getString(1));
	}

	public void DisplayRecordSH(final Cursor cSH) {
		TextView textViewSH = (TextView) findViewById(R.id.textView8);
		textViewSH.setText("Secondary Hand: " + cSH.getString(1));
	}

	public void DisplayRecordClass(final Cursor c) {
		TextView textViewClass = (TextView) findViewById(R.id.textView21);
		textViewClass.setText(c.getString(1) + "");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sendto_inventory, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Inventory:
			Intent Inventory = new Intent(this, Inventory.class);
			this.startActivity(Inventory);
			finish();
			return true;
		case R.id.Shop:
			Intent Shop = new Intent(this, Shop.class);
			this.startActivity(Shop);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent PlayScreen = new Intent(getApplicationContext(), PlayScreen.class);
		startActivity(PlayScreen);
		finish();
	}
}
