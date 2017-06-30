package com.Logik.dawn.of.ages;

import Databases.DBAdapter;
import Databases.DBAdapter_Alliance;
import Databases.DBAdapter_Class;
import Databases.DBAdapter_Equipment_Chest;
import Databases.DBAdapter_Equipment_Feet;
import Databases.DBAdapter_Equipment_Hands;
import Databases.DBAdapter_Equipment_Head;
import Databases.DBAdapter_Equipment_Legs;
import Databases.DBAdapter_Equipment_PH;
import Databases.DBAdapter_Equipment_SH;
import Databases.DBAdapter_Gold;
import Databases.DBAdapter_HP;
import Databases.DBAdapter_Level;
import Databases.DBAdapter_MP;
import Databases.DBAdapter_Name;
import Databases.DBAdapter_Race;
import Databases.DBAdapter_XP;
import Databases.DBAdapter_XPLimit;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class CreateNew extends Activity {

	/*---------------------------------------------------------------------------
	 ************************** Initialize Databases ****************************
	 ---------------------------------------------------------------------------*/

	DBAdapter db = new DBAdapter(this);
	DBAdapter_Equipment_Head dbHead = new DBAdapter_Equipment_Head(this);
	DBAdapter_Equipment_Chest dbChest = new DBAdapter_Equipment_Chest(this);
	DBAdapter_Equipment_Hands dbHands = new DBAdapter_Equipment_Hands(this);
	DBAdapter_Equipment_Legs dbLegs = new DBAdapter_Equipment_Legs(this);
	DBAdapter_Equipment_Feet dbFeet = new DBAdapter_Equipment_Feet(this);
	DBAdapter_Equipment_PH dbPH = new DBAdapter_Equipment_PH(this);
	DBAdapter_Equipment_SH dbSH = new DBAdapter_Equipment_SH(this);
	DBAdapter_Name dbName = new DBAdapter_Name(this);
	DBAdapter_Race dbRace = new DBAdapter_Race(this);
	DBAdapter_Class dbClass = new DBAdapter_Class(this);
	DBAdapter_Alliance dbAlliance = new DBAdapter_Alliance(this);
	DBAdapter_HP dbHp = new DBAdapter_HP(this);
	DBAdapter_MP dbMp = new DBAdapter_MP(this);
	DBAdapter_Level dbLevel = new DBAdapter_Level(this);
	DBAdapter_XP dbXp = new DBAdapter_XP(this);
	DBAdapter_XPLimit dbXpLimit = new DBAdapter_XPLimit(this);
	DBAdapter_Gold dbGold = new DBAdapter_Gold(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_new);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);

		Button btnCreate = (Button) findViewById(R.id.btnCreate);
		btnCreate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				checkName();
			}

            private void checkName() {

                /*---------------------------------------------------------------------------
				 *************************** Declare Variables ******************************
				 ---------------------------------------------------------------------------*/

                final EditText editText1 = (EditText) findViewById(R.id.editText1);
                String nameTxt = editText1.getText().toString();

                /*---------------------------------------------------------------------------
				 ********************** Check if a name is entered **************************
				 ---------------------------------------------------------------------------*/

                if (nameTxt.matches("")) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(CreateNew.this);

                    dlgAlert.setMessage("Please enter a character name.");
                    dlgAlert.setTitle("Attention");
                    dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
                    dlgAlert.setCancelable(false);
                    dlgAlert.create().show();
                } else if (nameTxt.trim().length() == 0) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(CreateNew.this);

                    dlgAlert.setMessage("Please enter a character name.");
                    dlgAlert.setTitle("Attention");
                    dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            editText1.setText("");
                            dialog.dismiss();
                        }
                    });
                    dlgAlert.setCancelable(false);
                    dlgAlert.create().show();
                } else {
                    checkGender();
                }
            }

            private void checkGender() {

                /*---------------------------------------------------------------------------
				 *************************** Declare Variables ******************************
				 ---------------------------------------------------------------------------*/

                RadioButton radioMale = (RadioButton) findViewById(R.id.radioMale);
                RadioButton radioFemale = (RadioButton) findViewById(R.id.radioFemale);

                /*---------------------------------------------------------------------------
				 ******************* Check if gender has been selected **********************
				 ---------------------------------------------------------------------------*/

                if (radioMale.isChecked() == false && radioFemale.isChecked() == false) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(CreateNew.this);

                    dlgAlert.setMessage("Please select a gender.");
                    dlgAlert.setTitle("Attention");
                    dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
                    dlgAlert.setCancelable(false);
                    dlgAlert.create().show();
                } else
                    startNew();
            }

			private void checkClass() {
				Spinner spinnerClass = (Spinner) findViewById(R.id.spinnerWeapons);

				switch (spinnerClass.getSelectedItemPosition()) {
                /********** Warrior **********/
				case 0:
					dbPH.open();
					dbPH.insertRecord("Starter Sword");
					dbPH.close();
					break;
                /********** Cleric **********/
				case 1:
					dbPH.open();
					dbPH.insertRecord("Starter Staff");
					dbPH.close();
					break;
                /********** Druid **********/
				case 2:
					dbPH.open();
					dbPH.insertRecord("Starter Bow");
					dbPH.close();
					break;
                /********** Sorcerer **********/
				case 3:
					dbPH.open();
					dbPH.insertRecord("Starter Staff");
					dbPH.close();
					break;
                /********** Monk **********/
				case 4:
					dbPH.open();
					dbPH.insertRecord("Starter Wand");
					dbPH.close();
					break;
                /********** Paladin **********/
				case 5:
					dbPH.open();
					dbPH.insertRecord("Starter Sword");
					dbPH.close();
					break;
                /********** Ranger **********/
				case 6:
					dbPH.open();
					dbPH.insertRecord("Starter Bow");
					dbPH.close();
					break;
                /********** Rouge **********/
				case 7:
					dbPH.open();
					dbPH.insertRecord("Starter Dagger");
					dbPH.close();
					break;
                /********** Warlock **********/
				case 8:
					dbPH.open();
					dbPH.insertRecord("Starter Staff");
					dbPH.close();
					break;
                /********** Bard **********/
				case 9:
					dbPH.open();
					dbPH.insertRecord("Starter Wand");
					dbPH.close();
					break;
				}

				Intent PlayScreen = new Intent(getApplicationContext(), PlayScreen.class);
				startActivityForResult(PlayScreen, 0);
				finish();
			}

			private void startNew() {

				/*---------------------------------------------------------------------------
				 *************************** Declare Variables ******************************
				 ---------------------------------------------------------------------------*/

				EditText editText1 = (EditText) findViewById(R.id.editText1);
				Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerArmour);
				Spinner spinnerClass = (Spinner) findViewById(R.id.spinnerWeapons);
				Spinner spinnerAlliance = (Spinner) findViewById(R.id.spinnerPotions);

                String strNewName = editText1.getText().toString();
                String strNewRace = spinnerRace.getSelectedItem().toString();
                String strNewClass = spinnerClass.getSelectedItem().toString();
                String strNewAlliance = spinnerAlliance.getSelectedItem().toString();

                int intNewHP = 10;
                int intNewMP = 10;
                int intNewLevel = 1;
                int intNewXP = 0;
                int intNewXPLimit = 100;
                int intNewGold = 0;


				/*---------------------------------------------------------------------------
				 ****************** Deletes all data & creates new character ****************
				 ---------------------------------------------------------------------------*/

				db.open();
				db.deleteAll();
				db.close();

				dbHead.open();
				dbHead.deleteAll();
				dbHead.close();

				dbChest.open();
				dbChest.deleteAll();
				dbChest.close();

				dbHands.open();
				dbHands.deleteAll();
				dbHands.close();

				dbLegs.open();
				dbLegs.deleteAll();
				dbLegs.close();

				dbFeet.open();
				dbFeet.deleteAll();
				dbFeet.close();

				dbPH.open();
				dbPH.deleteAll();
				dbPH.close();

				dbSH.open();
				dbSH.deleteAll();
				dbSH.close();

				dbName.open();
				dbName.insertRecord(strNewName);
				dbName.close();

				dbRace.open();
				dbRace.insertRecord(strNewRace);
				dbRace.close();

				dbClass.open();
				dbClass.insertRecord(strNewClass);
				dbClass.close();

				dbAlliance.open();
				dbAlliance.insertRecord(strNewAlliance);
				dbAlliance.close();

				dbHp.open();
				dbHp.insertRecord(Integer.toString(intNewHP));
				dbHp.close();

				dbMp.open();
				dbMp.insertRecord(Integer.toString(intNewMP));
				dbMp.close();

				dbLevel.open();
				dbLevel.insertRecord(Integer.toString(intNewLevel));
				dbLevel.close();

				dbXp.open();
				dbXp.insertRecord(Integer.toString(intNewXP));
				dbXp.close();

				dbXpLimit.open();
				dbXpLimit.insertRecord(Integer.toString(intNewXPLimit));
				dbXpLimit.close();

				dbGold.open();
				dbGold.insertRecord(Integer.toString(intNewGold));
				dbGold.close();

				checkClass();
			}

		});

		Button btnMoreInfo = (Button) findViewById(R.id.btnMoreInfo);
		btnMoreInfo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent MoreInfo = new Intent(v.getContext(), MoreInfo.class);
				startActivity(MoreInfo);
			}
		});
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent BeforeYouBegin = new Intent(getApplicationContext(), BeforeYouBegin.class);
		startActivity(BeforeYouBegin);
		finish();
	}
}
