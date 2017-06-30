package com.Logik.dawn.of.ages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

import Databases.DBAdapter_Alliance;
import Databases.DBAdapter_Class;
import Databases.DBAdapter_Gold;
import Databases.DBAdapter_HP;
import Databases.DBAdapter_Level;
import Databases.DBAdapter_MP;
import Databases.DBAdapter_Name;
import Databases.DBAdapter_Race;
import Databases.DBAdapter_XP;
import Databases.DBAdapter_XPLimit;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("SdCardPath")
public class PlayScreen extends Activity {
	DBAdapter_Name dbName = new DBAdapter_Name(this);
	DBAdapter_Race dbRace = new DBAdapter_Race(this);
	DBAdapter_Class dbClass = new DBAdapter_Class(this);
	DBAdapter_Alliance dbAlliance = new DBAdapter_Alliance(this);
	DBAdapter_HP dbHp = new DBAdapter_HP(this);
	DBAdapter_MP dbMp = new DBAdapter_MP(this);
	DBAdapter_Gold dbGold = new DBAdapter_Gold(this);
	DBAdapter_Level dbLevel = new DBAdapter_Level(this);
	DBAdapter_XP dbXp = new DBAdapter_XP(this);
	DBAdapter_XPLimit dbXpLimit = new DBAdapter_XPLimit(this);

	Spinner spinnerMonsters;
	Button btnBattle;
	TextView textViewBattleResults;
	TextView textViewLevelGained;
	TextView textViewXPValue;
	TextView textViewXpNextLevel;
	TextView textViewLevelValue;
	TextView textViewGoldValue;
	TextView textview5;
	TextView textViewStrRace;
	TextView textViewStrClass;
	TextView textViewStrAlliance;

	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_screen);
		final TextView textViewGoldValue = (TextView) findViewById(R.id.textViewGoldValue);
		TextView textViewStrName = (TextView) findViewById(R.id.textViewStrName);
		final TextView textViewLevelValue = (TextView) findViewById(R.id.textViewLevelValue);
		final Button ContinueBattle = (Button) findViewById(R.id.ContinueBattle);
		ContinueBattle.setVisibility(View.INVISIBLE);
		final Button btnBattle = (Button) findViewById(R.id.btnBattle);
		final TextView textViewBattleResults = (TextView) findViewById(R.id.textViewBattleResults);

		// ------------------------------------------------------------------------------------------------------------------------------------------

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);

		double number = Double.parseDouble(textViewGoldValue.getText().toString());
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		textViewGoldValue.setText(formatter.format(number));

		dbName.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/NameDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("NameDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbRace.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/RaceDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("RaceDB"), new FileOutputStream(destPath));
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

		dbAlliance.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/AllianceDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("AllianceDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbHp.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/HPDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("HPDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbMp.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/MPDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("MPDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbGold.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/GoldDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("GoldDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbLevel.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/LevelDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("LevelDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbXp.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/XPDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("XPDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dbXpLimit.open();

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/XPLimitDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("XPLimitDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBAdapter_Name dbName = new DBAdapter_Name(this);

		try {
			dbName.open();
			Cursor c = DBAdapter_Name.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordName(c);
				} while (c.moveToNext());
			}
			dbName.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_Race dbRace = new DBAdapter_Race(this);

		try {
			dbRace.open();
			Cursor c = DBAdapter_Race.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordRace(c);
				} while (c.moveToNext());
			}
			dbRace.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_Class dbClass = new DBAdapter_Class(this);

		try {
			dbClass.open();
			Cursor c = DBAdapter_Class.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordClass(c);
				} while (c.moveToNext());
			}
			dbClass.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_Alliance dbAlliance = new DBAdapter_Alliance(this);

		try {
			dbAlliance.open();
			Cursor c = DBAdapter_Alliance.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordAlliance(c);
				} while (c.moveToNext());
			}
			dbAlliance.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_HP dbHp = new DBAdapter_HP(this);

		try {
			dbHp.open();
			Cursor c = DBAdapter_HP.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordHP(c);
				} while (c.moveToNext());
			}
			dbHp.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_MP dbMp = new DBAdapter_MP(this);

		try {
			dbMp.open();
			Cursor c = DBAdapter_MP.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordMP(c);
				} while (c.moveToNext());
			}
			dbMp.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		final DBAdapter_Gold dbGold = new DBAdapter_Gold(this);

		try {
			dbGold.open();
			Cursor c = DBAdapter_Gold.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordGold(c);
				} while (c.moveToNext());
			}
			dbGold.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		final DBAdapter_Level dbLevel = new DBAdapter_Level(this);

		try {
			dbLevel.open();
			Cursor c = DBAdapter_Level.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordLevel(c);
				} while (c.moveToNext());
			}
			dbLevel.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_XP dbXp = new DBAdapter_XP(this);

		try {
			dbXp.open();
			Cursor c = DBAdapter_XP.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordXP(c);
				} while (c.moveToNext());
			}
			dbXp.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		DBAdapter_XPLimit dbXpLimit = new DBAdapter_XPLimit(this);

		try {
			dbXpLimit.open();
			Cursor c = DBAdapter_XPLimit.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordXPLimit(c);
				} while (c.moveToNext());
			}
			dbXpLimit.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		/*-------------------------------------------------------------------------
		 **************************  Button Methods  *****************************
		-------------------------------------------------------------------------*/

		Button btnInventory = (Button) findViewById(R.id.btnInventory);
		btnInventory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent Inventory = new Intent(v.getContext(), Inventory.class);
				startActivity(Inventory);
				finish();
			}
		});

		Button btnStats = (Button) findViewById(R.id.btnStats);
		btnStats.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * Intent Stats = new Intent(v.getContext(), Statistics.class);
				 * startActivity(Stats);
				 */

				Toast msg = Toast.makeText(PlayScreen.this, "This feature is currently unavailable.", Toast.LENGTH_SHORT);
				msg.show();
			}
		});

		Button btnShop = (Button) findViewById(R.id.btnShop);
		btnShop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent Shop = new Intent(v.getContext(), Shop.class);
				startActivity(Shop);
				finish();
			}
		});

		Button btnClassTraining = (Button) findViewById(R.id.btnCrafting);
		btnClassTraining.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * Intent ClassTraining = new Intent(v.getContext(),
				 * ClassTraining.class); startActivity(ClassTraining);
				 */

				Toast msg = Toast.makeText(PlayScreen.this, "This feature is currently unavailable.", Toast.LENGTH_SHORT);
				msg.show();
			}
		});

		Button btnEquipment = (Button) findViewById(R.id.btnEquipment);
		btnEquipment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent Equipment = new Intent(v.getContext(), Equipment.class);
				startActivity(Equipment);
				finish();
			}
		});

		Button btnAchievements = (Button) findViewById(R.id.btnAchievements);
		btnAchievements.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * Intent Achievements = new Intent(v.getContext(),
				 * Achievments.class); startActivity(Achievements);
				 */

				Toast msg = Toast.makeText(PlayScreen.this, "This feature is currently unavailable.", Toast.LENGTH_SHORT);
				msg.show();
			}
		});

		Button btnStoryMode = (Button) findViewById(R.id.btnStoryMode);
		btnStoryMode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent StoryMode = new Intent(v.getContext(), StoryMode.class);
				startActivity(StoryMode);
				finish();
			}
		});

		btnStoryMode.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				int gold = Integer.parseInt(textViewGoldValue.getText().toString().replaceAll(",", "")) + 50000000;
				textViewGoldValue.setText(String.valueOf(gold));

				double number = Double.parseDouble(textViewGoldValue.getText().toString());
				DecimalFormat formatter = new DecimalFormat("###,###,###");
				textViewGoldValue.setText(formatter.format(number));

				int level1 = Integer.parseInt(textViewLevelValue.getText().toString()) + 1000;
				textViewLevelValue.setText(String.valueOf(level1));
				dbLevel.open();
				dbLevel.insertRecord(String.valueOf(level1));
				dbLevel.close();
				return false;
			}
		});

		Button btnQuests = (Button) findViewById(R.id.btnQuests);
		btnQuests.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent Quests = new Intent(v.getContext(), Quests.class);
				startActivity(Quests);
			}
		});

		ContinueBattle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				btnBattle.setVisibility(View.VISIBLE);
				ContinueBattle.setVisibility(View.INVISIBLE);
				textViewBattleResults.setVisibility(View.INVISIBLE);
			}
		});

		/*----------------------------------------------------------------
		 *********** Checks if character has been created ***************
		 ---------------------------------------------------------------*/

		if (textViewStrName.getText().toString().equals(" ")) {
			AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

			dlgAlert.setMessage("Character data doesn't exist. Please create a new character");
			dlgAlert.setTitle("Attention");
			dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent CreateNew = new Intent(getApplicationContext(), CreateNew.class);
					startActivityForResult(CreateNew, 0);
					dialog.dismiss();
				}
			});
			dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent MainScreen = new Intent(getApplicationContext(), MainScreen.class);
					startActivityForResult(MainScreen, 0);
					dialog.dismiss();
				}
			});
			dlgAlert.setCancelable(false);
			dlgAlert.create().show();
		}
		// -------------------------------------------------------------------------------------------------------------

		btnBattle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final TextView textViewXPValue = (TextView) findViewById(R.id.textViewXPValue);
				final TextView textViewXpNextLevel = (TextView) findViewById(R.id.textViewXpNextLevel);
				final TextView textViewLevelValue = (TextView) findViewById(R.id.textViewLevelValue);
				final TextView textViewHP = (TextView) findViewById(R.id.textViewHP);
				final TextView textViewMP = (TextView) findViewById(R.id.textViewMP);
				TextView textViewGoldValue = (TextView) findViewById(R.id.textViewGoldValue);
				// ------------------------------------------------------------------------------------------------------
				int level2 = Integer.parseInt(textViewLevelValue.getText().toString().replaceAll(",", ""));
				textViewLevelValue.setText(String.valueOf(level2));

				int hp2 = Integer.parseInt(textViewHP.getText().toString().replaceAll(",", ""));
				textViewHP.setText(String.valueOf(hp2));

				int mp2 = Integer.parseInt(textViewMP.getText().toString().replaceAll(",", ""));
				textViewMP.setText(String.valueOf(mp2));

				int xp2 = Integer.parseInt(textViewXPValue.getText().toString().replaceAll(",", ""));
				textViewXPValue.setText(String.valueOf(xp2));

				int xpCap2 = Integer.parseInt(textViewXpNextLevel.getText().toString().replaceAll(",", ""));
				textViewXpNextLevel.setText(String.valueOf(xpCap2));

				int gold2 = Integer.parseInt(textViewGoldValue.getText().toString().replaceAll(",", ""));
				textViewGoldValue.setText(String.valueOf(gold2));

				if (Integer.parseInt(textViewGoldValue.getText().toString()) >= 999999999)
					textViewGoldValue.setText("999999999");
				
				MonsterBattles();
				BattleTimer();
				LevelTimer();

				double level22 = Double.parseDouble(textViewLevelValue.getText().toString());
				DecimalFormat formatter = new DecimalFormat("###,###,###");
				textViewLevelValue.setText(formatter.format(level22));

				double hp22 = Double.parseDouble(textViewHP.getText().toString());
				textViewHP.setText(formatter.format(hp22));

				double mp22 = Double.parseDouble(textViewMP.getText().toString());
				textViewMP.setText(formatter.format(mp22));

				double xp22 = Double.parseDouble(textViewXPValue.getText().toString());
				textViewXPValue.setText(formatter.format(xp22));

				double xpCap22 = Double.parseDouble(textViewXpNextLevel.getText().toString());
				textViewXpNextLevel.setText(formatter.format(xpCap22));

				double gold22 = Double.parseDouble(textViewGoldValue.getText().toString());
				textViewGoldValue.setText(formatter.format(gold22));
			}
		});
	}

	public void MonsterBattles() {
		Spinner spinnerMonsters = (Spinner) findViewById(R.id.spinnerMonsters);
		final TextView textViewBattleResults = (TextView) findViewById(R.id.textViewBattleResults);
		final TextView textViewXPValue = (TextView) findViewById(R.id.textViewXPValue);
		final TextView textViewLevelValue = (TextView) findViewById(R.id.textViewLevelValue);
		final TextView textViewGoldValue = (TextView) findViewById(R.id.textViewGoldValue);
		int level = Integer.parseInt(textViewLevelValue.getText().toString());

		int goldFormatter = Integer.parseInt(textViewGoldValue.getText().toString().replaceAll(",", ""));
		textViewGoldValue.setText(String.valueOf(goldFormatter));

		// -------------------
		// Monster sequences |
		// -------------------

		switch (spinnerMonsters.getSelectedItemPosition()) {
		case 0: // Training Dummy
			textViewBattleResults.setText("You have killed Training Dummy! | XP: +10 | Gold: 0 | Loot: none");
			int xpTrainingDummy = Integer.parseInt(textViewXPValue.getText().toString()) + 100;
			textViewXPValue.setText(String.valueOf(xpTrainingDummy));
			dbXp.open();
			dbXp.insertRecord(textViewXPValue.getText().toString());
			dbXp.close();
			break;
		case 1: // Cockroach
			if (level >= 2) {
				textViewBattleResults.setText("You have killed a Cockroach! | XP: +17 | Gold: +3 | Loot: none");
				int goldCockroach = Integer.parseInt(textViewGoldValue.getText().toString()) + 3;
				textViewGoldValue.setText(String.valueOf(goldCockroach));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				int xpCockroach = Integer.parseInt(textViewXPValue.getText().toString()) + 17;
				textViewXPValue.setText(String.valueOf(xpCockroach));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Cockroach!");
			}
			break;
		case 2: // Diseased Rat
			if (level >= 3) {
				textViewBattleResults.setText("You have killed a Diseased Rat! | XP: +21 | Gold: +5 | Loot: none");
				int goldDiseasedRat = Integer.parseInt(textViewGoldValue.getText().toString()) + 5;
				textViewGoldValue.setText(String.valueOf(goldDiseasedRat));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				int xpDiseasedRat = Integer.parseInt(textViewXPValue.getText().toString()) + 21;
				textViewXPValue.setText(String.valueOf(xpDiseasedRat));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Diseased Rat!");
			}
			break;
		case 3: // Black Widdow
			if (level >= 5) {
				textViewBattleResults.setText("You have killed a Black Widdow! | XP: +33 | Gold: +7 | Loot: none");
				int xpBlackWiddow = Integer.parseInt(textViewXPValue.getText().toString()) + 33;
				int goldBlackWiddow = Integer.parseInt(textViewGoldValue.getText().toString()) + 7;
				textViewGoldValue.setText(String.valueOf(goldBlackWiddow));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpBlackWiddow));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Black Widdow!");
			}
			break;
		case 4: // Goblin
			if (level >= 7) {
				textViewBattleResults.setText("You have killed a Goblin! || XP: +42 || Gold: +11 || Loot: none");
				int xpGoblin = Integer.parseInt(textViewXPValue.getText().toString()) + 42;
				int goldGoblin = Integer.parseInt(textViewGoldValue.getText().toString()) + 11;
				textViewGoldValue.setText(String.valueOf(goldGoblin));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpGoblin));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Goblin!");
			}
			break;
		case 5: // Undead Troll
			if (level >= 9) {
				textViewBattleResults.setText("You have killed an Undead Troll! || XP: +53 || Gold: +16 || Loot: none");
				int xpUndeadTroll = Integer.parseInt(textViewXPValue.getText().toString()) + 53;
				int goldUndeadTroll = Integer.parseInt(textViewGoldValue.getText().toString()) + 16;
				textViewGoldValue.setText(String.valueOf(goldUndeadTroll));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpUndeadTroll));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by an Undead Troll!");
			}
			break;
		case 6: // Giant
			if (level > 13) {
				textViewBattleResults.setText("You have killed a Giant! || XP: +61 || Gold: +22 || Loot: none");
				int xpGiant = Integer.parseInt(textViewXPValue.getText().toString()) + 61;
				int goldGiant = Integer.parseInt(textViewGoldValue.getText().toString()) + 22;
				textViewGoldValue.setText(String.valueOf(goldGiant));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpGiant));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have defeated by a Giant!");
			}
			break;
		case 7: // Young Blue Drake
			if (level > 17) {
				textViewBattleResults.setText("You have killed a Young Blue Drake! || XP: +74 || Gold: +29 || Loot: none");
				int xpYoungBlueDrake = Integer.parseInt(textViewXPValue.getText().toString()) + 74;
				int goldYoungBlueDrake = Integer.parseInt(textViewGoldValue.getText().toString()) + 29;
				textViewGoldValue.setText(String.valueOf(goldYoungBlueDrake));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpYoungBlueDrake));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Young Blue Drake!");
			}
			break;
		case 8: // Hobgoblin
			if (level > 21) {
				textViewBattleResults.setText("You have killed a Hobgoblin! || XP: +82 || Gold: +37 || Loot: none");
				int xpHobgoblin = Integer.parseInt(textViewXPValue.getText().toString()) + 82;
				int goldHobgoblin = Integer.parseInt(textViewGoldValue.getText().toString()) + 37;
				textViewGoldValue.setText(String.valueOf(goldHobgoblin));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpHobgoblin));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Hobgoblin!");
			}
			break;
		case 9: // Skeleton
			if (level > 23) {
				textViewBattleResults.setText("You have killed a Skeleton! || XP: +93 || Gold: +46 || Loot: none");
				int xpSkeleton = Integer.parseInt(textViewXPValue.getText().toString()) + 93;
				int goldSkeleton = Integer.parseInt(textViewGoldValue.getText().toString()) + 46;
				textViewGoldValue.setText(String.valueOf(goldSkeleton));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpSkeleton));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Skeleton!");
			}
			break;
		case 10: // Seer
			if (level > 26) {
				textViewBattleResults.setText("You have killed a Seer! || XP: +107 || Gold: +51 || Loot: none");
				int xpSeer = Integer.parseInt(textViewXPValue.getText().toString()) + 107;
				int goldSeer = Integer.parseInt(textViewGoldValue.getText().toString()) + 51;
				textViewGoldValue.setText(String.valueOf(goldSeer));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpSeer));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Seer");
			}
			break;
		case 11: // Homonculus
			if (level > 30) {
				textViewBattleResults.setText("You have killed a Homunculus! || XP: +118 || Gold: +71 || Loot: none");
				int xpHomonculus = Integer.parseInt(textViewXPValue.getText().toString()) + 118;
				int goldHomonculus = Integer.parseInt(textViewGoldValue.getText().toString()) + 71;
				textViewGoldValue.setText(String.valueOf(goldHomonculus));
				dbGold.open();
				dbGold.insertRecord(textViewGoldValue.getText().toString());
				dbGold.close();
				textViewXPValue.setText(String.valueOf(xpHomonculus));
				dbXp.open();
				dbXp.insertRecord(textViewXPValue.getText().toString());
				dbXp.close();
			} else {
				textViewBattleResults.setText("You have been defeated by a Homunculus!");
			}
		}
	}

	public void BattleTimer() {
		final Button btnBattle = (Button) findViewById(R.id.btnBattle);
		final TextView textViewBattleResults = (TextView) findViewById(R.id.textViewBattleResults);
		final TextView textViewTimer = (TextView) findViewById(R.id.textViewTimer);
		final Button ContinueBattle = (Button) findViewById(R.id.ContinueBattle);

		new CountDownTimer(1500, 1) {

			public void onTick(long millisUntilFinished) {
				TextView textViewTimer = (TextView) findViewById(R.id.textViewTimer);
				btnBattle.setVisibility(View.INVISIBLE);
				ContinueBattle.setVisibility(View.VISIBLE);
				ContinueBattle.setText("" + millisUntilFinished / 1000 + "." + millisUntilFinished / 100);
				textViewTimer.setVisibility(View.INVISIBLE);
				textViewBattleResults.setVisibility(View.VISIBLE);
			}

			public void onFinish() {
				ContinueBattle.setText("Continue fighting");
				textViewTimer.setVisibility(View.INVISIBLE);
			}
		}.start();
	}

	public void LevelTimer() {

		new CountDownTimer(2000, 1000) {

			public void onTick(long millisUntilFinished) {
				TextView textViewLevelTimer = (TextView) findViewById(R.id.textViewLevelTimer);
				final TextView textViewXPValue = (TextView) findViewById(R.id.textViewXPValue);
				final TextView textViewXpNextLevel = (TextView) findViewById(R.id.textViewXpNextLevel);
				final TextView textViewLevelValue = (TextView) findViewById(R.id.textViewLevelValue);
				final TextView textViewHP = (TextView) findViewById(R.id.textViewHP);
				final TextView textViewMP = (TextView) findViewById(R.id.textViewMP);
				// -----------------------------------------------------------------------------------------------------
				int XP = Integer.parseInt(textViewXPValue.getText().toString().replaceAll(",", ""));
				int XPNEXT = Integer.parseInt(textViewXpNextLevel.getText().toString().replaceAll(",", ""));
				textViewLevelTimer.setText("" + millisUntilFinished / 1000 + "." + millisUntilFinished / 100);
				if (textViewXPValue.getText().toString().equals(textViewXpNextLevel.getText().toString())) {
					int newLimit = Integer.parseInt(textViewXpNextLevel.getText().toString().replaceAll(",", "")) + 100;
					textViewXpNextLevel.setText(newLimit + "");
					dbXpLimit.open();
					dbXpLimit.insertRecord(textViewXpNextLevel.getText().toString());
					dbXpLimit.close();
					Toast msg = Toast.makeText(PlayScreen.this, "You have gained a level!", Toast.LENGTH_LONG);
					msg.show();
					textViewXPValue.setText("0");
					dbXp.open();
					dbXp.insertRecord(textViewXPValue.getText().toString());
					dbXp.close();
					// --------------------------------------------------------------------------------------------------
					int level1 = Integer.parseInt(textViewLevelValue.getText().toString().replaceAll(",", "")) + 1;
					textViewLevelValue.setText(level1 + "");
					dbLevel.open();
					dbLevel.insertRecord(textViewLevelValue.getText().toString());
					dbLevel.close();
					// --------------------------------------------------------------------------------------------------
					/*
					 * int nextLevel = Integer.parseInt(textViewNextLevel
					 * .getText().toString()) + 1;
					 * textViewNextLevel.setText(nextLevel + "");
					 */
					// --------------------------------------------------------------------------------------------------
					int hp = Integer.parseInt(textViewHP.getText().toString().replaceAll(",", "")) + 10;
					textViewHP.setText(hp + "");
					dbHp.open();
					dbHp.insertRecord(textViewHP.getText().toString());
					dbHp.close();
					// --------------------------------------------------------------------------------------------------
					int mp = Integer.parseInt(textViewMP.getText().toString().replaceAll(",", "")) + 10;
					textViewMP.setText(mp + "");
					dbMp.open();
					dbMp.insertRecord(textViewMP.getText().toString());
					dbMp.close();
					// --------------------------------------------------------------------------------------------------
					double level22 = Double.parseDouble(textViewLevelValue.getText().toString());
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					textViewLevelValue.setText(formatter.format(level22));

					double hp22 = Double.parseDouble(textViewHP.getText().toString());
					textViewHP.setText(formatter.format(hp22));

					double mp22 = Double.parseDouble(textViewMP.getText().toString());
					textViewMP.setText(formatter.format(mp22));

					double xp22 = Double.parseDouble(textViewXPValue.getText().toString());
					textViewXPValue.setText(formatter.format(xp22));

					double xpCap22 = Double.parseDouble(textViewXpNextLevel.getText().toString());
					textViewXpNextLevel.setText(formatter.format(xpCap22));

				} else if (XP >= XPNEXT) {
					int newLimit = Integer.parseInt(textViewXpNextLevel.getText().toString().replaceAll(",", "")) + 100;
					textViewXpNextLevel.setText(newLimit + "");
					dbXpLimit.open();
					dbXpLimit.insertRecord(textViewXpNextLevel.getText().toString());
					dbXpLimit.close();
					Toast msg = Toast.makeText(PlayScreen.this, "You have gained a level!", Toast.LENGTH_SHORT);
					msg.show();
					textViewXPValue.setText("0");
					dbXp.open();
					dbXp.insertRecord(textViewXPValue.getText().toString());
					dbXp.close();
					// --------------------------------------------------------------------------------------------------
					int level1 = Integer.parseInt(textViewLevelValue.getText().toString().replaceAll(",", "")) + 1;
					textViewLevelValue.setText(level1 + "");
					dbLevel.open();
					dbLevel.insertRecord(textViewLevelValue.getText().toString());
					dbLevel.close();
					// --------------------------------------------------------------------------------------------------
					/*
					 * int nextLevel = Integer.parseInt(textViewNextLevel
					 * .getText().toString()) + 1;
					 * textViewNextLevel.setText(nextLevel + "");
					 */
					// --------------------------------------------------------------------------------------------------
					int hp = Integer.parseInt(textViewHP.getText().toString().replaceAll(",", "")) + 10;
					textViewHP.setText(hp + "");
					dbHp.open();
					dbHp.insertRecord(textViewHP.getText().toString());
					dbHp.close();
					// --------------------------------------------------------------------------------------------------
					int mp = Integer.parseInt(textViewMP.getText().toString().replaceAll(",", "")) + 10;
					textViewMP.setText(mp + "");
					dbMp.open();
					dbMp.insertRecord(textViewHP.getText().toString());
					dbMp.close();
					// --------------------------------------------------------------------------------------------------
					double level22 = Double.parseDouble(textViewLevelValue.getText().toString());
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					textViewLevelValue.setText(formatter.format(level22));

					double hp22 = Double.parseDouble(textViewHP.getText().toString());
					textViewHP.setText(formatter.format(hp22));

					double mp22 = Double.parseDouble(textViewMP.getText().toString());
					textViewMP.setText(formatter.format(mp22));

					double xp22 = Double.parseDouble(textViewXPValue.getText().toString());
					textViewXPValue.setText(formatter.format(xp22));

					double xpCap22 = Double.parseDouble(textViewXpNextLevel.getText().toString());
					textViewXpNextLevel.setText(formatter.format(xpCap22));
				}
			}
			public void onFinish() {
			}
		}.start();
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

	public void DisplayRecordName(Cursor c) {
		TextView textViewStrName = (TextView) findViewById(R.id.textViewStrName);
		textViewStrName.setText(" " + c.getString(1));
		textViewStrName.setTextColor(Color.CYAN);
	}

	public void DisplayRecordRace(Cursor c) {
		TextView textViewStrRace = (TextView) findViewById(R.id.textViewStrRace);
		textViewStrRace.setText(c.getString(1).toString());
	}

	public void DisplayRecordClass(Cursor c) {
		TextView textViewStrClass = (TextView) findViewById(R.id.TextViewStrClass);
		textViewStrClass.setText(c.getString(1).toString());
	}

	public void DisplayRecordAlliance(Cursor c) {
		TextView textViewStrAlliance = (TextView) findViewById(R.id.textViewStrAlliance);
		textViewStrAlliance.setText(" " + c.getString(1).toString());
	}

	public void DisplayRecordHP(Cursor c) {
		TextView textViewHP = (TextView) findViewById(R.id.textViewHP);
		textViewHP.setText(c.getString(1).toString());
	}

	public void DisplayRecordMP(Cursor c) {
		TextView textViewMP = (TextView) findViewById(R.id.textViewMP);
		textViewMP.setText(c.getString(1).toString());
	}

	public void DisplayRecordGold(Cursor c) {
		TextView textViewGoldValue = (TextView) findViewById(R.id.textViewGoldValue);
		textViewGoldValue.setText(c.getString(1).toString());
		double number = Double.parseDouble(textViewGoldValue.getText().toString());
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		textViewGoldValue.setText(formatter.format(number));
	}

	public void DisplayRecordLevel(Cursor c) {
		TextView textViewLevelValue = (TextView) findViewById(R.id.textViewLevelValue);
		textViewLevelValue.setText(c.getString(1).toString());
	}

	public void DisplayRecordXP(Cursor c) {
		TextView textViewXPValue = (TextView) findViewById(R.id.textViewXPValue);
		textViewXPValue.setText(c.getString(1).toString());
	}

	public void DisplayRecordXPLimit(Cursor c) {
		TextView textViewXpNextLevel = (TextView) findViewById(R.id.textViewXpNextLevel);
		textViewXpNextLevel.setText(c.getString(1).toString());
	}

	@Override
	protected void onResume() {
		final DBAdapter_Gold dbGold = new DBAdapter_Gold(this);

		try {
			dbGold.open();
			Cursor c = DBAdapter_Gold.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecordGold(c);
				} while (c.moveToNext());
			}
			dbGold.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), BeforeYouBegin.class);
		startActivityForResult(intent, 0);
		finish();
		super.onBackPressed();
	}
}