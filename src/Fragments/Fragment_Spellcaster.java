package Fragments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Logik.dawn.of.ages.Equipment;
import com.Logik.dawn.of.ages.Inventory;
import com.Logik.dawn.of.ages.R;
import com.Logik.dawn.of.ages.R.id;
import com.Logik.dawn.of.ages.R.layout;

import Databases.DBAdapter;
import Databases.DBAdapter_Gold;
import ItemInfo.MeleeItemInfo;
import ItemInfo.SpellcasterItemInfo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Spellcaster extends ListFragment {

	private DBAdapter_Gold dbGold;
	private DBAdapter db;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		/*-------------------------------------------------------------------------------*
		 ********************************* View Inflater *********************************
		 *-------------------------------------------------------------------------------*/

		View rootView = inflater.inflate(R.layout.fragment_spellcaster, container, false);
		setHasOptionsMenu(true);
		/*-------------------------------------------------------------------------------*
		 ****************************** Variable Declaration *****************************
		 *-------------------------------------------------------------------------------*/
		final SpellcasterItemInfo itemInfo = new SpellcasterItemInfo();
		final String info = null;

		final TextView goldSpellcasterFragment = (TextView) rootView.findViewById(R.id.goldSpellcasterFragment);
		final ListView SpellcasterArmourList = (ListView) rootView.findViewById(R.id.spellcasterArmourList);
		final ListView SpellcasterWeaponsList = (ListView) rootView.findViewById(R.id.spellcasterWeaponsList);
		final RadioButton rdoSpellcasterArmour = (RadioButton) rootView.findViewById(R.id.radioSpellcasterArmour);
		final RadioButton rdoSpellcasterWeapons = (RadioButton) rootView.findViewById(R.id.radioSpellcasterWeapons);

		spellcasterListCheck(rdoSpellcasterArmour, rdoSpellcasterWeapons, SpellcasterArmourList, SpellcasterWeaponsList);

		dbGold = new DBAdapter_Gold(getActivity());
		db = new DBAdapter(getActivity());

		dbGold.open();

		try {
			String destPath = "/data/data/" + getActivity().getPackageName() + "/databases/GoldDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getActivity().getBaseContext().getAssets().open("GoldDB"), new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dbGold.open();
			Cursor c = DBAdapter_Gold.getAllRecords();
			if (c.moveToFirst()) {
				do {
					goldSpellcasterFragment.setText(c.getString(1).toString());
				} while (c.moveToNext());
			}
			dbGold.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		String SpellcasterArmour;
		List<HashMap<String, String>> SpellcasterArmourData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Spellcaster Armour ---");
			temp.put("Requirements", "Class: Cleric, Druid, Mage, Monk, Sorcerer, Warlock");
			SpellcasterArmourData.add(temp);
			HashMap<String, String> temp47 = new HashMap<String, String>();
			temp47.put("Item", "(375G) Novice Robe Set");
			temp47.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp47);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(50G) Novice Hood");
			temp1.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(150G) Novice Robe Top");
			temp2.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp2);
			HashMap<String, String> temp38 = new HashMap<String, String>();
			temp38.put("Item", "(75G) Novice Gloves");
			temp38.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp38);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(100G) Novice Robe Bottom");
			temp3.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(75G) Novice Boots");
			temp4.put("Requirements", "Req. Level: 10");
			SpellcasterArmourData.add(temp4);
			HashMap<String, String> temp48 = new HashMap<String, String>();
			temp48.put("Item", "(6.7K) Apprentice Robe Set");
			temp48.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp48);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(2K) Apprentice Hood");
			temp5.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(2.3K) Apprentice Robe Top");
			temp6.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp6);
			HashMap<String, String> temp39 = new HashMap<String, String>();
			temp39.put("Item", "(2K) Apprentice Gloves");
			temp39.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp39);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(2.2K) Apprentice Robe Bottom");
			temp7.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(2K) Apprentice Boots");
			temp8.put("Requirements", "Req. Level: 75");
			SpellcasterArmourData.add(temp8);
			HashMap<String, String> temp49 = new HashMap<String, String>();
			temp49.put("Item", "(42.5K) Journeyman Robe Set");
			temp49.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp49);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(10K) Journeyman Hood");
			temp9.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(12K) Journeyman Robe Top");
			temp10.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp10);
			HashMap<String, String> temp40 = new HashMap<String, String>();
			temp40.put("Item", "(10K) Journeyman Gloves");
			temp40.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp40);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "(10.5K) Journeyman Robe Bottom");
			temp11.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp11);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(10K) Journeyman Boots");
			temp12.put("Requirements", "Req. Level: 125");
			SpellcasterArmourData.add(temp12);
			HashMap<String, String> temp50 = new HashMap<String, String>();
			temp50.put("Item", "(104K) Expert Robe Set");
			temp50.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp50);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(25K) Expert Hood");
			temp13.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(28K) Expert Robe Top");
			temp14.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp14);
			HashMap<String, String> temp41 = new HashMap<String, String>();
			temp41.put("Item", "(23K) Expert Gloves");
			temp41.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp41);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(26K) Expert Robe Bottom");
			temp15.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "(23K) Expert Boots");
			temp16.put("Requirements", "Req. Level: 250");
			SpellcasterArmourData.add(temp16);
			HashMap<String, String> temp51 = new HashMap<String, String>();
			temp51.put("Item", "(470K) Master Robe Set");
			temp51.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp51);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(100K) Master Hood");
			temp17.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(150K) Master Robe Top");
			temp18.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp18);
			HashMap<String, String> temp42 = new HashMap<String, String>();
			temp42.put("Item", "(100K) Master Gloves");
			temp42.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp42);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(120K) Master Robe Bottom");
			temp19.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(100K) Master Boots");
			temp20.put("Requirements", "Req. Level: 500");
			SpellcasterArmourData.add(temp20);
			HashMap<String, String> temp21 = new HashMap<String, String>();
			temp21.put("Item", "-~- Specialty Spellcaster Armour -~-");
			SpellcasterArmourData.add(temp21);
			HashMap<String, String> temp52 = new HashMap<String, String>();
			temp52.put("Item", "(6.75M) Criistik's Robe Set");
			temp52.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp52);
			HashMap<String, String> temp22 = new HashMap<String, String>();
			temp22.put("Item", "(1M) Criistik's Hood");
			temp22.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp22);
			HashMap<String, String> temp23 = new HashMap<String, String>();
			temp23.put("Item", "(2.5M) Criistik's Robe Top");
			temp23.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp23);
			HashMap<String, String> temp43 = new HashMap<String, String>();
			temp43.put("Item", "(1.5M) Criistik's Gloves");
			temp43.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp43);
			HashMap<String, String> temp24 = new HashMap<String, String>();
			temp24.put("Item", "(1.75M) Criistik's Robe Bottom");
			temp24.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp24);
			HashMap<String, String> temp25 = new HashMap<String, String>();
			temp25.put("Item", "(1.5M) Criistik's Boots");
			temp25.put("Requirements", "Req. Level: 1,000");
			SpellcasterArmourData.add(temp25);
			HashMap<String, String> temp53 = new HashMap<String, String>();
			temp53.put("Item", "(56M) Xekith's Robe Set");
			temp53.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp53);
			HashMap<String, String> temp26 = new HashMap<String, String>();
			temp26.put("Item", "(13M) Xekith's Hood");
			temp26.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp26);
			HashMap<String, String> temp27 = new HashMap<String, String>();
			temp27.put("Item", "(17M) Xekith's Robe Top");
			temp27.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp27);
			HashMap<String, String> temp44 = new HashMap<String, String>();
			temp44.put("Item", "(12M) Xekith's Gloves");
			temp44.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp44);
			HashMap<String, String> temp28 = new HashMap<String, String>();
			temp28.put("Item", "(14M) Xekith's Robe Bottom");
			temp28.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp28);
			HashMap<String, String> temp29 = new HashMap<String, String>();
			temp29.put("Item", "(12M) Xekith's Boots");
			temp29.put("Requirements", "Req. Level: 2,500");
			SpellcasterArmourData.add(temp29);
			HashMap<String, String> temp54 = new HashMap<String, String>();
			temp54.put("Item", "(102.5M) Auxatia's Robe Set");
			temp54.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp54);
			HashMap<String, String> temp30 = new HashMap<String, String>();
			temp30.put("Item", "(25M) Auxatia's Hood");
			temp30.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp30);
			HashMap<String, String> temp31 = new HashMap<String, String>();
			temp31.put("Item", "(28M) Auxatia's Robe Top");
			temp31.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp31);
			HashMap<String, String> temp45 = new HashMap<String, String>();
			temp45.put("Item", "(23M) Auxatia's Gloves");
			temp45.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp45);
			HashMap<String, String> temp32 = new HashMap<String, String>();
			temp32.put("Item", "(26.5M) Auxatia's Robe Bottom");
			temp32.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp32);
			HashMap<String, String> temp33 = new HashMap<String, String>();
			temp33.put("Item", "(23M) Auxatia's Boots");
			temp33.put("Requirements", "Req. Level: 5,000");
			SpellcasterArmourData.add(temp33);
			HashMap<String, String> temp55 = new HashMap<String, String>();
			temp55.put("Item", "(250M) Zamarik's Robe Set");
			temp55.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp55);
			HashMap<String, String> temp34 = new HashMap<String, String>();
			temp34.put("Item", "(50M) Zamarik's Hood");
			temp34.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp34);
			HashMap<String, String> temp35 = new HashMap<String, String>();
			temp35.put("Item", "(75M) Zamarik's Robe Top");
			temp35.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp35);
			HashMap<String, String> temp46 = new HashMap<String, String>();
			temp46.put("Item", "(50M) Zamarik's Gloves");
			temp46.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp46);
			HashMap<String, String> temp36 = new HashMap<String, String>();
			temp36.put("Item", "(65M) Zamarik's Robe Bottom");
			temp36.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp36);
			HashMap<String, String> temp37 = new HashMap<String, String>();
			temp37.put("Item", "(50M) Zamarik's Boots");
			temp37.put("Requirements", "Req. Level: 10,000");
			SpellcasterArmourData.add(temp37);
		}

		SimpleAdapter SpellcasterArmourAdapter = new SimpleAdapter(getActivity(), SpellcasterArmourData, R.layout.custom_row_view, new String[] {
				"Item", "Requirements" }, new int[] { R.id.text1, R.id.text2 });

		SpellcasterArmourList.setAdapter(SpellcasterArmourAdapter);

		SpellcasterArmourList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
				TextView itemText = (TextView) v.findViewById(R.id.text1);
				String title = itemText.getText().toString();
				
				switch (position) {
				case 1:
					dlgAlert.setMessage(itemInfo.NoviceRobeSet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 375) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 375;
								goldSpellcasterFragment.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Novice Hood added to inventory \n"
										+ "-Novice Robe Top added to inventory\n" + "-Novice Gloves added to inventory\n"
										+ "-Novice Robe Bottom added to inventory\n" + "-Novice Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Hood");
								db.insertRecord("Novice Robe Top");
								db.insertRecord("Novice Gloves");
								db.insertRecord("Novice Robe Bottom");
								db.insertRecord("Novice Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 2:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +7 \n" + "Magic Bonus: +14 \n" + "Wield: Head");
					dlgAlert.setTitle("Novice Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 50;
								goldSpellcasterFragment.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Novice Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 3:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +9 \n" + "Magic Bonus: +12 \n" + "Wield: Chest");
					dlgAlert.setTitle("Novice Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 150) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 150;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								
								Toast msg = Toast.makeText(getActivity(), "Novice Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 4:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +8 \n" + "Magic Bonus: +10 \n" + "Wield: Hands");
					dlgAlert.setTitle("Novice Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 75) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 75;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								
								Toast msg = Toast.makeText(getActivity(), "Novice Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 5:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +12 \n" + "Magic Bonus: +16 \n" + "Wield: Legs");
					dlgAlert.setTitle("Novice Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Novice Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 6:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5 \n" + "Magic Bonus: +11 \n" + "Wield: Feet");
					dlgAlert.setTitle("Novice Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 75) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 75;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Novice Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 7:
					dlgAlert.setMessage("Apprentice Hood: \n" + "Type: Spellcaster \n" + "Defense: +68 \n" + "Magic Bonus: +73 \n" + "Wield: Head \n"
							+ "\n" + "Apprentice Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +75 \n" + "Magic Bonus: +79 \n"
							+ "Wield: Chest \n" + "\n" + "Apprentice Gloves: \n" + "Type: Spellcaster \n" + "Defense: +71 \n" + "Magic Bonus: +74 \n"
							+ "Wield: Hands \n" + "\n" + "Apprentice Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +74 \n"
							+ "Magic Bonus: +78 \n" + "Wield: Legs \n" + "\n" + "Apprentice Boots: \n" + "Type: Spellcaster \n" + "Defense: +72 \n"
							+ "Magic Bonus: +75 \n" + "Wield: Feet \n" + "\n");
					dlgAlert.setTitle("Apprentice Robe Set");
					dlgAlert.setPositiveButton("Buy (8.5K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 8500) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 8500;
								goldSpellcasterFragment.setText(String.valueOf(gold1));

								Toast msg = Toast
										.makeText(getActivity(), "-Apprentice Hood added to inventory \n"
												+ "-Apprentice Robe Top added to inventory\n" + "-Apprentice Gloves added to inventory\n"
												+ "-Apprentice Robe Bottom added to inventory\n" + "-Apprentice Boots added to inventory",
												Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Hood");
								db.insertRecord("Apprentice Robe Top");
								db.insertRecord("Apprentice Gloves");
								db.insertRecord("Apprentice Robe Bottom");
								db.insertRecord("Apprentice Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 8:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +68 \n" + "Magic Bonus: +73 \n" + "Wield: Head");
					dlgAlert.setTitle("Apprentice Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Apprentice Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 9:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +75 \n" + "Magic Bonus: +79 \n" + "Wield: Chest");
					dlgAlert.setTitle("Apprentice Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2300) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2300;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Apprentice Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 10:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +71 \n" + "Magic Bonus: +74 \n" + "Wield: Legs");
					dlgAlert.setTitle("Apprentice Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Apprentice Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 11:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +74 \n" + "Magic Bonus: +78 \n" + "Wield: Legs");
					dlgAlert.setTitle("Apprentice Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2200) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2200;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Apprentice Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 12:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +72 \n" + "Magic Bonus: +75 \n" + "Wield: Feet");
					dlgAlert.setTitle("Apprentice Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Apprentice Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 13:
					dlgAlert.setMessage("Journeyman Hood: \n" + "Type: Spellcaster \n" + "Defense: +117 \n" + "Magic Bonus: +121 \n"
							+ "Wield: Head \n" + "\n" + "Journeyman Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +125 \n"
							+ "Magic Bonus: +128 \n" + "Wield: Chest \n" + "\n" + "Journeyman Gloves: \n" + "Type: Spellcaster \n"
							+ "Defense: +120 \n" + "Magic Bonus: +124 \n" + "Wield: Hands \n" + "\n" + "Journeyman Robe Bottom: \n"
							+ "Type: Spellcaster \n" + "Defense: +122 \n" + "Magic Bonus: +126 \n" + "Wield: Legs \n" + "\n" + "Journeyman Boots: \n"
							+ "Type: Spellcaster \n" + "Defense: +119 \n" + "Magic Bonus: +123 \n" + "Wield: Feet \n" + "\n");
					dlgAlert.setTitle("Journeyman Robe Set");
					dlgAlert.setPositiveButton("Buy (42.5K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 42500) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 42500;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast
										.makeText(getActivity(), "-Journeyman Hood added to inventory \n"
												+ "-Journeyman Robe Top added to inventory\n" + "-Journeyman Gloves added to inventory\n"
												+ "-Journeyman Robe Bottom added to inventory\n" + "-Journeyman Boots added to inventory",
												Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Hood");
								db.insertRecord("Journeyman Robe Top");
								db.insertRecord("Journeyman Gloves");
								db.insertRecord("Journeyman Robe Bottom");
								db.insertRecord("Journeyman Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 14:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +117 \n" + "Magic Bonus: +121 \n" + "Wield: Head");
					dlgAlert.setTitle("Journeyman Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Journeyman Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 15:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +125 \n" + "Magic Bonus: +128 \n" + "Wield: Chest");
					dlgAlert.setTitle("Journeyman Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 12000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 12000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Journeyman Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 16:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +120 \n" + "Magic Bonus: +124 \n" + "Wield: Legs");
					dlgAlert.setTitle("Journeyman Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Journeyman Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 17:
					AlertDialog.Builder dlgAlert1 = new AlertDialog.Builder(getActivity());

					dlgAlert1.setMessage("Type: Spellcaster \n" + "Defense: +122 \n" + "Magic Bonus: +126 \n" + "Wield: Legs");
					dlgAlert1.setTitle("Journeyman Robe Bottom");
					dlgAlert1.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10500) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10500;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Journeyman Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert1.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert1.setCancelable(false);
					dlgAlert1.create().show();

					break;
				case 18:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +119 \n" + "Magic Bonus: +123 \n" + "Wield: Feet");
					dlgAlert.setTitle("Journeyman Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Journeyman Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 19:
					dlgAlert.setMessage("Expert Hood: \n" + "Type: Spellcaster \n" + "Defense: +247 \n" + "Magic Bonus: +251 \n" + "Wield: Head \n"
							+ "\n" + "Expert Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +257 \n" + "Magic Bonus: +262 \n" + "Wield: Chest \n"
							+ "\n" + "Expert Gloves: \n" + "Type: Spellcaster \n" + "Defense: +250 \n" + "Magic Bonus: +254 \n" + "Wield: Hands \n"
							+ "\n" + "Expert Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +254 \n" + "Magic Bonus: +260 \n"
							+ "Wield: Legs \n" + "\n" + "Expert Boots: \n" + "Type: Spellcaster \n" + "Defense: +251 \n" + "Magic Bonus: +255 \n"
							+ "Wield: Feet \n" + "\n");
					dlgAlert.setTitle("Expert Robe Set");
					dlgAlert.setPositiveButton("Buy (102K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 102000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 102000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "-Expert Hood added to inventory \n"
										+ "-Expert Robe Top added to inventory\n" + "-Expert Gloves added to inventory\n"
										+ "-Expert Robe Bottom added to inventory\n" + "-Expert Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Hood");
								db.insertRecord("Expert Robe Top");
								db.insertRecord("Expert Gloves");
								db.insertRecord("Expert Robe Bottom");
								db.insertRecord("Expert Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 20:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +247 \n" + "Magic Bonus: +251 \n" + "Wield: Head");
					dlgAlert.setTitle("Expert Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Expert Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 21:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +257 \n" + "Magic Bonus: +262 \n" + "Wield: Chest");
					dlgAlert.setTitle("Expert Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 28000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 28000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Expert Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 22:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +250 \n" + "Magic Bonus: +254 \n" + "Wield: Legs");
					dlgAlert.setTitle("Expert Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Expert Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 23:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +254 \n" + "Magic Bonus: +260 \n" + "Wield: Legs");
					dlgAlert.setTitle("Expert Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 26000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 26000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Expert Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 24:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +251 \n" + "Magic Bonus: +255 \n" + "Wield: Feet");
					dlgAlert.setTitle("Expert Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 23000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 23000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Expert Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 25:
					dlgAlert.setMessage("Master Hood: \n" + "Type: Spellcaster \n" + "Defense: +507 \n" + "Magic Bonus: +513 \n" + "Wield: Head \n"
							+ "\n" + "Master Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +514 \n" + "Magic Bonus: +521 \n" + "Wield: Chest \n"
							+ "\n" + "Master Gloves: \n" + "Type: Spellcaster \n" + "Defense: +505 \n" + "Magic Bonus: +511 \n" + "Wield: Hands \n"
							+ "\n" + "Master Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +510 \n" + "Magic Bonus: +519 \n"
							+ "Wield: Legs \n" + "\n" + "Master Boots: \n" + "Type: Spellcaster \n" + "Defense: +509 \n" + "Magic Bonus: +515 \n"
							+ "Wield: Feet \n" + "\n");
					dlgAlert.setTitle("Master Robe Set");
					dlgAlert.setPositiveButton("Buy (470K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 470000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 470000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "-Master Hood added to inventory \n"
										+ "-Master Robe Top added to inventory\n" + "-Master Gloves added to inventory\n"
										+ "-Master Robe Bottom added to inventory\n" + "-Master Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Hood");
								db.insertRecord("Master Robe Top");
								db.insertRecord("Master Gloves");
								db.insertRecord("Master Robe Bottom");
								db.insertRecord("Master Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 26:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +507 \n" + "Magic Bonus: +513 \n" + "Wield: Head");
					dlgAlert.setTitle("Master Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 27:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +514 \n" + "Magic Bonus: +521 \n" + "Wield: Chest");
					dlgAlert.setTitle("Master Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 150000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 150000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 28:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +505 \n" + "Magic Bonus: +511 \n" + "Wield: Legs");
					dlgAlert.setTitle("Master Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 29:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +510 \n" + "Magic Bonus: +519 \n" + "Wield: Legs");
					dlgAlert.setTitle("Master Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 120000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 120000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 30:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +509 \n" + "Magic Bonus: +515 \n" + "Wield: Feet");
					dlgAlert.setTitle("Master Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 32:
					AlertDialog.Builder dlgAlert0 = new AlertDialog.Builder(getActivity());
					dlgAlert0.setMessage("Criistik's Hood: \n" + "Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n"
							+ "Wield: Head \n" + "\n" +

							"Criistik's Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Chest \n"
							+ "\n" +

							"Criistik's Gloves: \n" + "Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Hands \n"
							+ "\n" +

							"Criistik's Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n"
							+ "Wield: Legs \n" + "\n" +

							"Criistik's Boots: \n" + "Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Feet \n"
							+ "\n");
					dlgAlert0.setTitle("Criistik's Robe Set");
					dlgAlert0.setPositiveButton("Buy (6.75M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 6750000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 6750000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast
										.makeText(getActivity(), "-Criistik's Hood added to inventory \n"
												+ "-Criistik's Robe Top added to inventory\n" + "-Criistik's Gloves added to inventory\n"
												+ "-Criistik's Robe Bottom added to inventory\n" + "-Criistik's Boots added to inventory",
												Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Hood");
								db.insertRecord("Criistik's Robe Top");
								db.insertRecord("Criistik's Gloves");
								db.insertRecord("Criistik's Robe Bottom");
								db.insertRecord("Criistik's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert0.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert0.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert0.setCancelable(false);
					dlgAlert0.create().show();

					break;
				case 33:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Head");
					dlgAlert.setTitle("Criistik's Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Criistik's Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 34:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Chest");
					dlgAlert.setTitle("Criistik's Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 2500000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 2500000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Criistik's Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 35:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Criistik's Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1500000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1500000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Criistik's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 36:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Criistik's Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1750000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1750000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Criistik's Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 37:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +1,000 \n" + "Magic Bonus: +1,000 \n" + "Wield: Feet");
					dlgAlert.setTitle("Criistik's Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1500000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1500000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Criistik's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 38:
					dlgAlert.setMessage("Xekith's Hood: \n" + "Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n"
							+ "Wield: Head \n" + "\n" +

							"Xekith's Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Chest \n"
							+ "\n" +

							"Xekith's Gloves: \n" + "Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Hands \n"
							+ "\n" +

							"Xekith's Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Legs \n"
							+ "\n" +

							"Xekith's Boots: \n" + "Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Feet \n" + "\n");
					dlgAlert.setTitle("Xekith's Robe Set");
					dlgAlert.setPositiveButton("Buy (56M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 56000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 56000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "-Xekith's Hood added to inventory \n"
										+ "-Xekith's Robe Top added to inventory\n" + "-Xekith's Gloves added to inventory\n"
										+ "-Xekith's Robe Bottom added to inventory\n" + "-Xekith's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Hood");
								db.insertRecord("Xekith's Robe Top");
								db.insertRecord("Xekith's Gloves");
								db.insertRecord("Xekith's Robe Bottom");
								db.insertRecord("Xekith's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 39:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Head");
					dlgAlert.setTitle("Xekith's Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 13000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 13000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Xekith's Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 40:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Chest");
					dlgAlert.setTitle("Xekith's Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 17000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 17000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Xekith's Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 41:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Legs");
					dlgAlert.setTitle("Xekith's Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 12000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 12000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Xekith's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 42:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Legs");
					dlgAlert.setTitle("Xekith's Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 14000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 14000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Xekith's Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 43:
					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +2,500 \n" + "Magic Bonus: +2,500 \n" + "Wield: Feet");
					dlgAlert.setTitle("Xekith's Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 12000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 12000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Xekith's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 44:
					dlgAlert.setMessage("Auxatia's Hood: \n" + "Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n"
							+ "Wield: Head \n" + "\n" +

							"Auxatia's Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Chest \n"
							+ "\n" +

							"Auxatia's Gloves: \n" + "Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Hands \n"
							+ "\n" +

							"Auxatia's Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Legs \n"
							+ "\n" +

							"Auxatia's Boots: \n" + "Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Feet \n"
							+ "\n");
					dlgAlert.setTitle("Auxatia's Robe Set");
					dlgAlert.setPositiveButton("Buy (101.5M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 101500000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 101500000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "-Auxatia's Hood added to inventory \n"
										+ "-Auxatia's Robe Top added to inventory\n" + "-Auxatia's Gloves added to inventory\n"
										+ "-Auxatia's Robe Bottom added to inventory\n" + "-Auxatia's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Hood");
								db.insertRecord("Auxatia's Robe Top");
								db.insertRecord("Auxatia's Gloves");
								db.insertRecord("Auxatia's Robe Bottom");
								db.insertRecord("Auxatia's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 45:
					// (25M) Auxatia's Hood

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Head");
					dlgAlert.setTitle("Auxatia's Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 25000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 46:
					// (28M) Auxatia's Robe Top

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Chest");
					dlgAlert.setTitle("Auxatia's Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 28000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 28000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 28000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auatia's Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 47:
					// (950G) Apprentice Robe Bottom

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Auxatia's Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 23000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 23000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 23000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 48:
					// (26.5M) Auxatia's Robe Bottom

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Auxatia's Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 26500000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 26500000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 26500000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 49:
					// (23M) Auxatia's Boots

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +5,000 \n" + "Magic Bonus: +5,000 \n" + "Wield: Feet");
					dlgAlert.setTitle("Auxatia's Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 23000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 23000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 23000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 50:
					// (100G) Bronze Helmet

					dlgAlert.setMessage("Zamarik's Hood: \n" + "Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n"
							+ "Wield: Head \n" + "\n" +

							"Zamarik's Robe Top: \n" + "Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Chest \n"
							+ "\n" +

							"Zamarik's Gloves: \n" + "Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Hands \n"
							+ "\n" +

							"Zamarik's Robe Bottom: \n" + "Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n"
							+ "Wield: Legs \n" + "\n" +

							"Zamarik's Boots: \n" + "Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Feet \n"
							+ "\n");
					dlgAlert.setTitle("Zamarik's Robe Set");
					dlgAlert.setPositiveButton("Buy (240M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 240000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 240000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 240000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "-Zamarik's Hood added to inventory \n"
										+ "-Zamarik's Robe Top added to inventory\n" + "-Zamarik's Gloves added to inventory\n"
										+ "-Zamarik's Robe Bottom added to inventory\n" + "-Zamarik's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Hood");
								db.insertRecord("Zamarik's Robe Top");
								db.insertRecord("Zamarik's Gloves");
								db.insertRecord("Zamarik's Robe Bottom");
								db.insertRecord("Zamarik's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 51:
					// (50M) Zamarik's Hood

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Head");
					dlgAlert.setTitle("Zamarik's Hood");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 50000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 50000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Hood added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Hood");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 52:
					// (75M) Zamarik's Robe Top

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Chest");
					dlgAlert.setTitle("Zamarik's Robe Top");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 75000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 75000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 75000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Robe Top added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Robe Top");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 53:
					// (950G) Apprentice Robe Bottom

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Zamarik's Gloves");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 50000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 50000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 54:
					// (65M) Zamarik's Robe Bottom

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Legs");
					dlgAlert.setTitle("Zamarik's Robe Bottom");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 65000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 65000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 65000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Robe Bottom added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Robe Bottom");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 55:
					// (65M) Zamarik's Boots

					dlgAlert.setMessage("Type: Spellcaster \n" + "Defense: +10,000 \n" + "Magic Bonus: +10,000 \n" + "Wield: Feet");
					dlgAlert.setTitle("Zamarik's Boots");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 65000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 65000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// //int = Integer.parseInt(//Shop
								// Purchased.getText().toString()) + 65000000;
								// Shop Purchased.setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;

				}
			}
		});

		String SpellcasterWeapons;
		List<HashMap<String, String>> SpellcasterWeaponsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Spellcaster Weapons & Spells ---");
			temp.put("Requirements", "Class: Cleric, Druid, Mage, Monk, Sorcerer, Warlock");
			SpellcasterWeaponsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(150G) Novice Staff");
			temp1.put("Requirements", "Req. Level: 10");
			SpellcasterWeaponsData.add(temp1);
			HashMap<String, String> temp100 = new HashMap<String, String>();
			temp100.put("Item", "(50M) Spell Book: Novice Spell Book");
			temp100.put("Requirements", "Req. Level: 12");
			SpellcasterWeaponsData.add(temp100);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(150G) Spell Tome: Air Strike");
			temp2.put("Requirements", "Req. Level: 14");
			SpellcasterWeaponsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(300G) Spell Tome: Bind");
			temp3.put("Requirements", "Req. Level: 18");
			SpellcasterWeaponsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(400G) Spell Tome: Earth Strike");
			temp4.put("Requirements", "Req. Level: 22");
			SpellcasterWeaponsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(525G) Spell Tome: Water Strike");
			temp5.put("Requirements", "Req. Level: 28");
			SpellcasterWeaponsData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(700G) Spell Tome: Weaken");
			temp6.put("Requirements", "Req. Level: 37");
			SpellcasterWeaponsData.add(temp6);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(1.5K) Spell Tome: Fire Strike");
			temp7.put("Requirements", "Req. Level: 50");
			SpellcasterWeaponsData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(3K) Spell Tome: Minor Ward");
			temp8.put("Requirements", "Req. Level: 67");
			SpellcasterWeaponsData.add(temp8);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(7K) Apprentice Staff");
			temp9.put("Requirements", "Req. Level: 75");
			SpellcasterWeaponsData.add(temp9);
			HashMap<String, String> temp101 = new HashMap<String, String>();
			temp101.put("Item", "(50M) Spell Book: Apprentice Spell Book");
			temp101.put("Requirements", "Req. Level: 77");
			SpellcasterWeaponsData.add(temp101);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(8.7K) Spell Tome: Life Siphon");
			temp10.put("Requirements", "Req. Level: 79");
			SpellcasterWeaponsData.add(temp10);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "(10K) Spell Tome: Piercing Gaze");
			temp11.put("Requirements", "Req. Level: 86");
			SpellcasterWeaponsData.add(temp11);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(13K) Spell Tome: Air Bolt");
			temp12.put("Requirements", "Req. Level: 97");
			SpellcasterWeaponsData.add(temp12);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(20K) Spell Tome: Earth Bolt");
			temp13.put("Requirements", "Req. Level: 110");
			SpellcasterWeaponsData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(25K) Decayed Crozier");
			temp14.put("Requirements", "Req. Level: 125");
			SpellcasterWeaponsData.add(temp14);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(36K) Spell Tome: Water Bolt");
			temp15.put("Requirements", "Req. Level: 142");
			SpellcasterWeaponsData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "(48K) Journeyman Staff");
			temp16.put("Requirements", "Req. Level: 150");
			SpellcasterWeaponsData.add(temp16);
			HashMap<String, String> temp67 = new HashMap<String, String>();
			temp67.put("Item", "(50M) Spell Book: Journeyman Spell Book");
			temp67.put("Requirements", "Req. Level: 153");
			SpellcasterWeaponsData.add(temp67);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(53.5K) Spell Tome: Fire Bolt");
			temp17.put("Requirements", "Req. Level: 155");
			SpellcasterWeaponsData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(100K) Spell Tome: Conjure Eye-Soar");
			temp18.put("Requirements", "Req. Level: 163");
			SpellcasterWeaponsData.add(temp18);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(100K) Spell Tome: Major Ward");
			temp19.put("Requirements", "Req. Level: 184");
			SpellcasterWeaponsData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(100K) Spell Tome: Cause Fear");
			temp20.put("Requirements", "Req. Level: 204");
			SpellcasterWeaponsData.add(temp20);
			HashMap<String, String> temp21 = new HashMap<String, String>();
			temp21.put("Item", "(123K) Spell Tome: Shocking Grasp");
			temp21.put("Requirements", "Req. Level: 237");
			SpellcasterWeaponsData.add(temp21);
			HashMap<String, String> temp22 = new HashMap<String, String>();
			temp22.put("Item", "(1M) Expert Staff");
			temp22.put("Requirements", "Req. Level: 250");
			SpellcasterWeaponsData.add(temp22);
			HashMap<String, String> temp102 = new HashMap<String, String>();
			temp102.put("Item", "(50M) Spell Book: Expert Spell Book");
			temp102.put("Requirements", "Req. Level: 254");
			SpellcasterWeaponsData.add(temp102);
			HashMap<String, String> temp23 = new HashMap<String, String>();
			temp23.put("Item", "(10M) Spell Tome: Obscurring Mist");
			temp23.put("Requirements", "Req. Level: 259");
			SpellcasterWeaponsData.add(temp23);
			HashMap<String, String> temp24 = new HashMap<String, String>();
			temp24.put("Item", "(25M) Spell Tome: Air Blast");
			temp24.put("Requirements", "Req. Level: 271");
			SpellcasterWeaponsData.add(temp24);
			HashMap<String, String> temp25 = new HashMap<String, String>();
			temp25.put("Item", "(50M) Spell Tome: Daze");
			temp25.put("Requirements", "Req. Level: 277");
			SpellcasterWeaponsData.add(temp25);
			HashMap<String, String> temp26 = new HashMap<String, String>();
			temp26.put("Item", "(50M) Spell Tome: Earth Blast");
			temp26.put("Requirements", "Req. Level: 284");
			SpellcasterWeaponsData.add(temp26);
			HashMap<String, String> temp27 = new HashMap<String, String>();
			temp27.put("Item", "(50M) Spell Tome: Conjure Lightning Elemental");
			temp27.put("Requirements", "Req. Level: 292");
			SpellcasterWeaponsData.add(temp27);
			HashMap<String, String> temp28 = new HashMap<String, String>();
			temp28.put("Item", "(50M) Spell Tome: Water Blast");
			temp28.put("Requirements", "Req. Level: 303");
			SpellcasterWeaponsData.add(temp28);
			HashMap<String, String> temp29 = new HashMap<String, String>();
			temp29.put("Item", "(50M) Spell Tome: Fire Blast");
			temp29.put("Requirements", "Req. Level: 318");
			SpellcasterWeaponsData.add(temp29);
			HashMap<String, String> temp30 = new HashMap<String, String>();
			temp30.put("Item", "(50M) Spell Tome: Spectral Shield");
			temp30.put("Requirements", "Req. Level: 340");
			SpellcasterWeaponsData.add(temp30);
			HashMap<String, String> temp31 = new HashMap<String, String>();
			temp31.put("Item", "(50M) Spell Tome: Blood Blaze");
			temp31.put("Requirements", "Req. Level: 358");
			SpellcasterWeaponsData.add(temp31);
			HashMap<String, String> temp32 = new HashMap<String, String>();
			temp32.put("Item", "(50M) Spell Tome: Poison Mist");
			temp32.put("Requirements", "Req. Level: 374");
			SpellcasterWeaponsData.add(temp32);
			HashMap<String, String> temp33 = new HashMap<String, String>();
			temp33.put("Item", "(50M) Soul Spire Staff");
			temp33.put("Requirements", "Req. Level: 390");
			SpellcasterWeaponsData.add(temp33);
			HashMap<String, String> temp34 = new HashMap<String, String>();
			temp34.put("Item", "(50M) Spell Tome: Safe Haven");
			temp34.put("Requirements", "Req. Level: 407");
			SpellcasterWeaponsData.add(temp34);
			HashMap<String, String> temp35 = new HashMap<String, String>();
			temp35.put("Item", "(50M) Glyph: Frost");
			temp35.put("Requirements", "Req. Level: 432");
			SpellcasterWeaponsData.add(temp35);
			HashMap<String, String> temp36 = new HashMap<String, String>();
			temp36.put("Item", "(50M) Spell Tome: Conjure Lesser Minion");
			temp36.put("Requirements", "Req. Level: 479");
			SpellcasterWeaponsData.add(temp36);
			HashMap<String, String> temp37 = new HashMap<String, String>();
			temp37.put("Item", "(50M) Master Staff");
			temp37.put("Requirements", "Req. Level: 500");
			SpellcasterWeaponsData.add(temp37);
			HashMap<String, String> temp103 = new HashMap<String, String>();
			temp103.put("Item", "(50M) Spell Book: Master Spell Book 1st Edtion");
			temp103.put("Requirements", "Req. Level: 521");
			SpellcasterWeaponsData.add(temp103);
			HashMap<String, String> temp38 = new HashMap<String, String>();
			temp38.put("Item", "(50M) Spell Tome: Air Wave");
			temp38.put("Requirements", "Req. Level: 536");
			SpellcasterWeaponsData.add(temp38);
			HashMap<String, String> temp39 = new HashMap<String, String>();
			temp39.put("Item", "(50M) Spell Tome: Earth Wave");
			temp39.put("Requirements", "Req. Level: 547");
			SpellcasterWeaponsData.add(temp39);
			HashMap<String, String> temp40 = new HashMap<String, String>();
			temp40.put("Item", "(50M) Spell Tome: Cure Disease");
			temp40.put("Requirements", "Req. Level: 567");
			SpellcasterWeaponsData.add(temp40);
			HashMap<String, String> temp41 = new HashMap<String, String>();
			temp41.put("Item", "(50M) Spell Tome: Entangle");
			temp41.put("Requirements", "Req. Level: 581");
			SpellcasterWeaponsData.add(temp41);
			HashMap<String, String> temp42 = new HashMap<String, String>();
			temp42.put("Item", "(50M) Spell Tome: Water Wave");
			temp42.put("Requirements", "Req. Level: 595");
			SpellcasterWeaponsData.add(temp42);
			HashMap<String, String> temp43 = new HashMap<String, String>();
			temp43.put("Item", "(50M) Spell Tome: Electric Storm");
			temp43.put("Requirements", "Req. Level: 602");
			SpellcasterWeaponsData.add(temp43);
			HashMap<String, String> temp44 = new HashMap<String, String>();
			temp44.put("Item", "(50M) Spell Tome: Fire Wave");
			temp44.put("Requirements", "Req. Level: 629");
			SpellcasterWeaponsData.add(temp44);
			HashMap<String, String> temp45 = new HashMap<String, String>();
			temp45.put("Item", "(50M) Necrotic Scepter");
			temp45.put("Requirements", "Req. Level: 670");
			SpellcasterWeaponsData.add(temp45);
			HashMap<String, String> temp46 = new HashMap<String, String>();
			temp46.put("Item", "(50M) Glyph: Death Grip");
			temp46.put("Requirements", "Req. Level: 693");
			SpellcasterWeaponsData.add(temp46);
			HashMap<String, String> temp47 = new HashMap<String, String>();
			temp47.put("Item", "(50M) Spell Tome: Chimera's Claw");
			temp47.put("Requirements", "Req. Level: 717");
			SpellcasterWeaponsData.add(temp47);
			HashMap<String, String> temp48 = new HashMap<String, String>();
			temp48.put("Item", "(50M) Spell Tome: Stone Flesh");
			temp48.put("Requirements", "Req. Level: 753");
			SpellcasterWeaponsData.add(temp48);
			HashMap<String, String> temp49 = new HashMap<String, String>();
			temp49.put("Item", "(50M) Glyph: Fire Storm");
			temp49.put("Requirements", "Req. Level: 786");
			SpellcasterWeaponsData.add(temp49);
			HashMap<String, String> temp50 = new HashMap<String, String>();
			temp50.put("Item", "(50M) Spell Tome: Frost Nova");
			temp50.put("Requirements", "Req. Level: 802");
			SpellcasterWeaponsData.add(temp50);
			HashMap<String, String> temp51 = new HashMap<String, String>();
			temp51.put("Item", "(50M) Spell Tome: Renewing Mist");
			temp51.put("Requirements", "Req. Level: 836");
			SpellcasterWeaponsData.add(temp51);
			HashMap<String, String> temp52 = new HashMap<String, String>();
			temp52.put("Item", "(50M) Glyph: Paralysis");
			temp52.put("Requirements", "Req. Level: 877");
			SpellcasterWeaponsData.add(temp52);
			HashMap<String, String> temp53 = new HashMap<String, String>();
			temp53.put("Item", "(50M) Cursed Wand");
			temp53.put("Requirements", "Req. Level: 894");
			SpellcasterWeaponsData.add(temp53);
			HashMap<String, String> temp104 = new HashMap<String, String>();
			temp104.put("Item", "(50M) Spell Book: Master Spell Book 2nd Edition");
			temp104.put("Requirements", "Req. Level: 10,000");
			SpellcasterWeaponsData.add(temp104);
			HashMap<String, String> temp54 = new HashMap<String, String>();
			temp54.put("Item", "(50M) Spell Tome: Air Burst");
			temp54.put("Requirements", "Req. Level: 901");
			SpellcasterWeaponsData.add(temp54);
			HashMap<String, String> temp55 = new HashMap<String, String>();
			temp55.put("Item", "(50M) Spell Tome: Earth Burst");
			temp55.put("Requirements", "Req. Level: 917");
			SpellcasterWeaponsData.add(temp55);
			HashMap<String, String> temp56 = new HashMap<String, String>();
			temp56.put("Item", "(50M) Spell Tome: Seal of Blood");
			temp56.put("Requirements", "Req. Level: 934");
			SpellcasterWeaponsData.add(temp56);
			HashMap<String, String> temp57 = new HashMap<String, String>();
			temp57.put("Item", "(50M) Spell Tome: Divine Protection");
			temp57.put("Requirements", "Req. Level: 951");
			SpellcasterWeaponsData.add(temp57);
			HashMap<String, String> temp58 = new HashMap<String, String>();
			temp58.put("Item", "(50M) Spell Tome: Water Burst");
			temp58.put("Requirements", "Req. Level: 962");
			SpellcasterWeaponsData.add(temp58);
			HashMap<String, String> temp59 = new HashMap<String, String>();
			temp59.put("Item", "(50M) Spell Tome: Focused Wrath");
			temp59.put("Requirements", "Req. Level: 967");
			SpellcasterWeaponsData.add(temp59);
			HashMap<String, String> temp60 = new HashMap<String, String>();
			temp60.put("Item", "(50M) Spell Tome: Fire Burst");
			temp60.put("Requirements", "Req. Level: 974");
			SpellcasterWeaponsData.add(temp60);
			HashMap<String, String> temp61 = new HashMap<String, String>();
			temp61.put("Item", "(50M) Glyph: Blood Boil");
			temp61.put("Requirements", "Req. Level: 998");
			SpellcasterWeaponsData.add(temp61);
			HashMap<String, String> temp87 = new HashMap<String, String>();
			temp87.put("Item", "-~- Specialty Spellcaster Weapons & Spells-~-");
			SpellcasterWeaponsData.add(temp87);
			HashMap<String, String> temp62 = new HashMap<String, String>();
			temp62.put("Item", "(50M) Criistik's Staff");
			temp62.put("Requirements", "Req. Level: 1,000");
			SpellcasterWeaponsData.add(temp62);
			HashMap<String, String> temp66 = new HashMap<String, String>();
			temp66.put("Item", "(50M) Spell Book: Criistik's Spell Book");
			temp66.put("Requirements", "Req. Level: 1,250");
			SpellcasterWeaponsData.add(temp66);
			HashMap<String, String> temp63 = new HashMap<String, String>();
			temp63.put("Item", "(50M) Xekith's Wand");
			temp63.put("Requirements", "Req. Level: 2,500");
			SpellcasterWeaponsData.add(temp63);
			HashMap<String, String> temp68 = new HashMap<String, String>();
			temp68.put("Item", "(50M) Spell Book: Xekith's Spell Book");
			temp68.put("Requirements", "Req. Level: 2,650");
			SpellcasterWeaponsData.add(temp68);
			HashMap<String, String> temp64 = new HashMap<String, String>();
			temp64.put("Item", "(50M) Auxatia's Scepter");
			temp64.put("Requirements", "Req. Level: 5,000");
			SpellcasterWeaponsData.add(temp64);
			HashMap<String, String> temp69 = new HashMap<String, String>();
			temp69.put("Item", "(50M) Spell Book: Auxatia's Spell Book");
			temp69.put("Requirements", "Req. Level: 5,300");
			SpellcasterWeaponsData.add(temp69);
			HashMap<String, String> temp65 = new HashMap<String, String>();
			temp65.put("Item", "(50M) Zamarik's Bane");
			temp65.put("Requirements", "Req. Level: 10,000");
			SpellcasterWeaponsData.add(temp65);
			HashMap<String, String> temp671 = new HashMap<String, String>();
			temp671.put("Item", "(50M) Spell Book: Zamarik's Spell book");
			temp671.put("Requirements", "Req. Level: 10,000");
			SpellcasterWeaponsData.add(temp671);

		}

		SimpleAdapter SpellcasterWeaponsAdapter = new SimpleAdapter(getActivity(), SpellcasterWeaponsData, R.layout.custom_row_view, new String[] {
				"Item", "Requirements" }, new int[] { R.id.text1, R.id.text2 });

		SpellcasterWeaponsList.setAdapter(SpellcasterWeaponsAdapter);

		SpellcasterWeaponsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

				switch (position) {
				case 1:
					dlgAlert.setMessage("Type: Spellcaster \n Attack: +8 \n Magic Bonus: +12 \n Wield: Primary & Secondary Hand");
					dlgAlert.setTitle("Novice Staff");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 150) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 150;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 150;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Novice Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 2:
					dlgAlert.setMessage("Spell Tome: Air Strike \n" + Html.fromHtml("<i>\"Strike enemies with the element of air.</i>\"") + "\n"
							+ "Mana Cost: 12 \n" + "Damage: 18 \n\n" + "" + "Spell Tome: Bind \n"
							+ Html.fromHtml("<i>\"Bind target movement for 10 seconds.\"") + "\n" + "Mana Cost: 17 \n\n" + ""
							+ "Spell Tome: Earth Strike \n" + Html.fromHtml("<i>\"Strike enemies with the element of earth.</i>\"") + "\n"
							+ "Mana Cost: 21 \n" + "Damage: 24 \n\n" + "" + "Spell Tome: Water Strike \n"
							+ Html.fromHtml("<i>\"Strike enemies with the element of water.<i>\"") + "\n" + "Mana Cost: 25 \n" + "Damage: 30 \n\n"
							+ "" + "Spell Tome: Weaken \n" + Html.fromHtml("<i>\"Reduce target attack points by 5%.</i>\"") + "\n"
							+ "Mana Cost: 28 \n\n" + "" + "Spell Tome: Fire Strike \n"
							+ Html.fromHtml("<i>\"Strike enemies with the element of fire.</i>\"") + "\n" + "Mana Cost: 33 \n" + "Damage: 39 \n\n"
							+ "" + "Spell Tome: Minor Ward \n" + "Protect yourself from damage for 10 seconds." + "\n" + "Mana Cost: 37 \n\n");
					dlgAlert.setTitle("Spell Book: Novice Spell Book");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 150) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 150;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 150;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Novice Earth Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Earth Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 3:
					dlgAlert.setMessage("Info: Strike enemies with the element of air. \n" + "Mana Cost: 12 \n" + "Damage: 18 \n");
					dlgAlert.setTitle("Spell Tome: Air Strike \n");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 50;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Air Strike added to Spellbook", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Fire Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 4:
					dlgAlert.setMessage("Purchase Novice Water Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 150) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 150;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 150;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Novice Water Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Novice Water Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 5:
					dlgAlert.setMessage("Purchase Apprentice Air Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 1000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Apprentice Air Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Air Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 6:
					dlgAlert.setMessage("Purchase Apprentice Earth Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 1000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Apprentice Earth Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Earth Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 7:

					dlgAlert.setMessage("Purchase Apprentice Fire Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 1000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Apprentice Fire Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Fire Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 8:

					dlgAlert.setMessage("Purchase Apprentice Water Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 1000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Apprentice Water Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Apprentice Water Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 9:

					dlgAlert.setMessage("Purchase Journeyman Air Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Journeyman Air Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Air Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 10:

					dlgAlert.setMessage("Purchase Journeyman Earth Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Journeyman Earth Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Earth Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 11:
					AlertDialog.Builder dlgAlert1 = new AlertDialog.Builder(getActivity());
					dlgAlert1.setMessage("Purchase Journeyman Fire Staff?");
					dlgAlert1.setTitle("Shop");
					dlgAlert1.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Journeyman Fire Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Fire Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert1.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert1.setCancelable(false);
					dlgAlert1.create().show();

					break;
				case 12:

					dlgAlert.setMessage("Purchase Journeyman Water Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Journeyman Water Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Journeyman Water Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 13:

					dlgAlert.setMessage("Purchase Expert Air Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 25000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Expert Air Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Air Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 14:

					dlgAlert.setMessage("Purchase Expert Earth Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 25000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Expert Earth Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Earth Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 15:

					dlgAlert.setMessage("Purchase Expert Fire Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 25000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Expert Fire Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Fire Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 16:

					dlgAlert.setMessage("Purchase Expert Water Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 25000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Expert Water Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Expert Water Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 17:

					dlgAlert.setMessage("Purchase Master Air Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 100000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Master Air Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Air Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 18:

					dlgAlert.setMessage("Purchase Master Earth Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 100000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Master Earth Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Earth Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 19:

					dlgAlert.setMessage("Purchase Master Fire Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Master Fire Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Fire Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 20:

					dlgAlert.setMessage("Purchase Master Water Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 100000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 100000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Master Water Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Master Water Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 22:

					dlgAlert.setMessage("Purchase Criistik's Staff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 1000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 1000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 1000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Criistik's Staff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Criistik's Staff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 23:

					dlgAlert.setMessage("Purchase Xekith's Wand?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 10000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 10000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 10000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Xekith's Wand added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Xekith's Wand");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 24:

					dlgAlert.setMessage("Purchase Auxatia's Battlestaff?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 25000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 25000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 25000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Auxatia's Battlestaff added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Auxatia's Battlestaff");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				case 25:

					dlgAlert.setMessage("Purchase Zamarik's Scepter?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldSpellcasterFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldSpellcasterFragment.getText().toString()) - 50000000;
								goldSpellcasterFragment.setText(String.valueOf(gold1));
								// int =
								// Integer.parseInt(//.getText().toString()) +
								// 50000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zamarik's Scepter added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zamarik's Scepter");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldSpellcasterFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();

					break;
				}
			}
		});
		return rootView;
	}

	private void spellcasterListCheck(final RadioButton rdoSpellcasterArmour, final RadioButton rdoSpellcasterWeapons,
			final ListView SpellcasterArmourList, final ListView SpellcasterWeaponsList) {

		rdoSpellcasterArmour.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoSpellcasterArmour.isChecked() == true) {
					rdoSpellcasterWeapons.setChecked(false);

					SpellcasterArmourList.setVisibility(View.VISIBLE);
					SpellcasterWeaponsList.setVisibility(View.INVISIBLE);
				}
			}
		});

		rdoSpellcasterWeapons.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoSpellcasterWeapons.isChecked() == true) {
					rdoSpellcasterArmour.setChecked(false);

					SpellcasterArmourList.setVisibility(View.INVISIBLE);
					SpellcasterWeaponsList.setVisibility(View.VISIBLE);
				}
			}
		});

	}

	public void removeInt() {

	}

	public void replaceInt() {

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

	@Override
	public void setHasOptionsMenu(boolean hasMenu) {
		hasMenu = true;
		super.setHasOptionsMenu(hasMenu);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.shop_screen, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Inventory:
			Intent Equipment = new Intent(this.getActivity(), Inventory.class);
			this.startActivity(Equipment);

			return true;
		case R.id.Equipment:
			Intent Shop = new Intent(this.getActivity(), Equipment.class);
			this.startActivity(Shop);

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
