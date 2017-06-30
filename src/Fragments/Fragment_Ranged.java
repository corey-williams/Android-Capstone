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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Fragment_Ranged extends ListFragment {

	private DBAdapter_Gold dbGold;
	private DBAdapter db;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_ranged, container, false);
		setHasOptionsMenu(true);
		final TextView goldRangedFragment = (TextView) rootView.findViewById(R.id.goldRangedFragment);
		final ListView RangedArmourList = (ListView) rootView.findViewById(R.id.rangedArmourList);
		final ListView RangedWeaponsList = (ListView) rootView.findViewById(R.id.rangedWeaponsList);
		final RadioButton rdoRangedArmour = (RadioButton) rootView.findViewById(R.id.radioRangedArmour);
		final RadioButton rdoRangedWeapons = (RadioButton) rootView.findViewById(R.id.radioRangedWeapons);

		rangedListCheck(rdoRangedArmour, rdoRangedWeapons, RangedArmourList, RangedWeaponsList);

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
					goldRangedFragment.setText(c.getString(1).toString());
				} while (c.moveToNext());
			}
			dbGold.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		String RangerArmour;
		List<HashMap<String, String>> RangerArmourData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Ranger Armour ---");
			temp.put("Requirements", "Class: Bard, Cleric, Druid, Ranger, Rouge");
			RangerArmourData.add(temp);
			HashMap<String, String> temp47 = new HashMap<String, String>();
			temp47.put("Item", "(350G) Leather Armour Set");
			temp47.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp47);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(50G) Leather Cowl");
			temp1.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(150G) Leather Cuirass");
			temp2.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp2);
			HashMap<String, String> temp38 = new HashMap<String, String>();
			temp38.put("Item", "(50G) Leather Gloves");
			temp38.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp38);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(100G) Leather Chaps");
			temp3.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(50G) Leather Boots");
			temp4.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp4);
			HashMap<String, String> temp48 = new HashMap<String, String>();
			temp48.put("Item", "(6.55K) Studded Leather Armour Set");
			temp48.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp48);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(1.5K) Studded Leather Cowl");
			temp5.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(1.8K) Studded Leather Cuirass");
			temp6.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp6);
			HashMap<String, String> temp39 = new HashMap<String, String>();
			temp39.put("Item", "(1.5K) Studded Leather Gloves");
			temp39.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp39);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(1.75K) Studded Leather Chaps");
			temp7.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(1.5K) Studded Leather Boots");
			temp8.put("Requirements", "Req. Level: 75");
			RangerArmourData.add(temp8);
			HashMap<String, String> temp49 = new HashMap<String, String>();
			temp49.put("Item", "(105.5K) Corrupted Armour Set");
			temp49.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp49);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(25K) Corrupted Cowl");
			temp9.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(28K) Corrupted Cuirass");
			temp10.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp10);
			HashMap<String, String> temp40 = new HashMap<String, String>();
			temp40.put("Item", "(25K) Corrupted Gloves");
			temp40.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp40);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "(27.5K) Corrupted Chaps");
			temp11.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp11);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(25K) Corrupted Boots");
			temp12.put("Requirements", "Req. Level: 150");
			RangerArmourData.add(temp12);
			HashMap<String, String> temp50 = new HashMap<String, String>();
			temp50.put("Item", "(305K) Demonhide Armour Set");
			temp50.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp50);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(75K) Demonhide Cowl");
			temp13.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(78K) Demonhide Cuirass");
			temp14.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp14);
			HashMap<String, String> temp41 = new HashMap<String, String>();
			temp41.put("Item", "(75K) Demonhide Gloves");
			temp41.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp41);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(77K) Demonhide Chaps");
			temp15.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "(75K) Demonhide Boots");
			temp16.put("Requirements", "Req. Level: 300");
			RangerArmourData.add(temp16);
			HashMap<String, String> temp51 = new HashMap<String, String>();
			temp51.put("Item", "(470K) Darkspawn Armour Set");
			temp51.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp51);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(100K) Darkspawn Cowl");
			temp17.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(150K) Darkspawn Cuirass");
			temp18.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp18);
			HashMap<String, String> temp42 = new HashMap<String, String>();
			temp42.put("Item", "(100K) Darkspawn Gloves");
			temp42.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp42);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(120K) Darkspawn Chaps");
			temp19.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(100K) Darkspawn Boots");
			temp20.put("Requirements", "Req. Level: 650");
			RangerArmourData.add(temp20);
			HashMap<String, String> temp21 = new HashMap<String, String>();
			temp21.put("Item", "-~- Specialty Ranger Armour -~-");
			RangerArmourData.add(temp21);
			HashMap<String, String> temp52 = new HashMap<String, String>();
			temp52.put("Item", "(6.75M) Black Dragon Armour Set");
			temp52.put("Requirements", "Req. Level: 10");
			RangerArmourData.add(temp52);
			HashMap<String, String> temp22 = new HashMap<String, String>();
			temp22.put("Item", "(1M) Black Dragon Cowl");
			temp22.put("Requirements", "Req. Level: 1,000");
			RangerArmourData.add(temp22);
			HashMap<String, String> temp23 = new HashMap<String, String>();
			temp23.put("Item", "(2.5M) Black Dragon Cuirass");
			temp23.put("Requirements", "Req. Level: 1,000");
			RangerArmourData.add(temp23);
			HashMap<String, String> temp43 = new HashMap<String, String>();
			temp43.put("Item", "(1.5M) Black Dragon Gloves");
			temp43.put("Requirements", "Req. Level: 1,000");
			RangerArmourData.add(temp43);
			HashMap<String, String> temp24 = new HashMap<String, String>();
			temp24.put("Item", "(1.75M) Black Dragon Chaps");
			temp24.put("Requirements", "Req. Level: 1,000");
			RangerArmourData.add(temp24);
			HashMap<String, String> temp25 = new HashMap<String, String>();
			temp25.put("Item", "(1.5M) Black Dragon Boots");
			temp25.put("Requirements", "Req. Level: 1,000");
			RangerArmourData.add(temp25);
			HashMap<String, String> temp53 = new HashMap<String, String>();
			temp53.put("Item", "(56M) Mystic Armour Set");
			temp53.put("Requirements", "Req. Level: 3,000");
			RangerArmourData.add(temp53);
			HashMap<String, String> temp26 = new HashMap<String, String>();
			temp26.put("Item", "(13M) Mystic Cowl");
			temp26.put("Requirements", "Req. Level: 3,500");
			RangerArmourData.add(temp26);
			HashMap<String, String> temp27 = new HashMap<String, String>();
			temp27.put("Item", "(17M) Mystic Cuirass");
			temp27.put("Requirements", "Req. Level: 3,500");
			RangerArmourData.add(temp27);
			HashMap<String, String> temp44 = new HashMap<String, String>();
			temp44.put("Item", "(12M) Mystic Gloves");
			temp44.put("Requirements", "Req. Level: 3,500");
			RangerArmourData.add(temp44);
			HashMap<String, String> temp28 = new HashMap<String, String>();
			temp28.put("Item", "(14M) Mystic Chaps");
			temp28.put("Requirements", "Req. Level: 3,500");
			RangerArmourData.add(temp28);
			HashMap<String, String> temp29 = new HashMap<String, String>();
			temp29.put("Item", "(12M) Mystic Boots");
			temp29.put("Requirements", "Req. Level: 3,500");
			RangerArmourData.add(temp29);
			HashMap<String, String> temp54 = new HashMap<String, String>();
			temp54.put("Item", "(102.5M) Zanthiir's Armour Set");
			temp54.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp54);
			HashMap<String, String> temp30 = new HashMap<String, String>();
			temp30.put("Item", "(25M) Zanthiir's Cowl");
			temp30.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp30);
			HashMap<String, String> temp31 = new HashMap<String, String>();
			temp31.put("Item", "(28M) Zanthiir's Cuirass");
			temp31.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp31);
			HashMap<String, String> temp45 = new HashMap<String, String>();
			temp45.put("Item", "(23M) Zanthiir's Gloves");
			temp45.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp45);
			HashMap<String, String> temp32 = new HashMap<String, String>();
			temp32.put("Item", "(26.5M) Zanthiir's Chaps");
			temp32.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp32);
			HashMap<String, String> temp33 = new HashMap<String, String>();
			temp33.put("Item", "(23M) Zanthiir's Boots");
			temp33.put("Requirements", "Req. Level: 7,000");
			RangerArmourData.add(temp33);
			HashMap<String, String> temp55 = new HashMap<String, String>();
			temp55.put("Item", "(240M) Hērō's Armour Set");
			temp55.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp55);
			HashMap<String, String> temp34 = new HashMap<String, String>();
			temp34.put("Item", "(50M) Hērō's Cowl");
			temp34.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp34);
			HashMap<String, String> temp35 = new HashMap<String, String>();
			temp35.put("Item", "(75M) Hērō's Cuirass");
			temp35.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp35);
			HashMap<String, String> temp46 = new HashMap<String, String>();
			temp46.put("Item", "(50M) Hērō's Gloves");
			temp46.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp46);
			HashMap<String, String> temp36 = new HashMap<String, String>();
			temp36.put("Item", "(65M) Hērō's Chaps");
			temp36.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp36);
			HashMap<String, String> temp37 = new HashMap<String, String>();
			temp37.put("Item", "(50M) Hērō's Boots");
			temp37.put("Requirements", "Req. Level: 10,000");
			RangerArmourData.add(temp37);

		}

		SimpleAdapter RangerArmourAdapter = new SimpleAdapter(getActivity(), RangerArmourData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		RangedArmourList.setAdapter(RangerArmourAdapter);

		RangedArmourList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert91 = new AlertDialog.Builder(getActivity());
					dlgAlert91.setMessage("Leather Cowl: \n" + "Type: Ranger \n" + "Defense: +4 \n" + "Ranged Bonus: +8 \n" + "Wield: Head \n" + "\n"
							+

							"Leather Cuirass: \n" + "Type: Ranger \n" + "Defense: +14 \n" + "Ranged Bonus: +17 \n" + "Wield: Chest \n" + "\n" +

							"Leather Gloves: \n" + "Type: Ranger \n" + "Defense: +7 \n" + "Ranged Bonus: +10 \n" + "Wield: Hands \n" + "\n" +

							"Leather Chaps: \n" + "Type: Ranger \n" + "Defense: +11 \n" + "Ranged Bonus: +15 \n" + "Wield: Legs \n" + "\n" +

							"Leather Boots: \n" + "Type: Ranger \n" + "Defense: +7 \n" + "Ranged Bonus: +5 \n" + "Wield: Feet \n" + "\n");
					dlgAlert91.setTitle("Leather Armour Set");
					dlgAlert91.setPositiveButton("Buy (375G)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 375) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 375;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 375;
								// .setText("" + purchased);
								Toast msg = Toast
										.makeText(getActivity(), "Leather Armour Set added to Inventory\n" + "✦ Leather Cowl\n"
												+ "✦ Leather Cuirass\n" + "✦ Leather Gloves\n" + "✦ Leather Chaps\n" + "✦ Leather Boots\n",
												Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Leather Cowl");
								db.insertRecord("Leather Cuirass");
								db.insertRecord("Leather Gloves");
								db.insertRecord("Leather Chaps");
								db.insertRecord("Leather Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert91.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert91.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert91.setCancelable(false);
					dlgAlert91.create().show();

					break;
				case 2:
					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
					dlgAlert.setMessage("Type: Ranger \n" + "Defense: +4 \n" + "Ranged Bonus: +8 \n" + "Wield: Head");
					dlgAlert.setTitle("Leather Cowl");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
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
					// (100G) Leather Cuirass

					AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(getActivity());
					dlgAlert2.setMessage("Type: Ranger \n" + "Defense: +14 \n" + "Ranged Bonus: +17 \n" + "Wield: Chest");
					dlgAlert2.setTitle("Leather Cuirass");
					dlgAlert2.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 100) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 100;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 100;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert2.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert2.setCancelable(false);
					dlgAlert2.create().show();

					break;
				case 4:
					AlertDialog.Builder dlgAlert37 = new AlertDialog.Builder(getActivity());
					dlgAlert37.setMessage("Type: Ranger \n" + "Defense: +7 \n" + "Ranged Bonus: +10 \n" + "Wield: Hands");
					dlgAlert37.setTitle("Leather Gloves");
					dlgAlert37.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert37.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert37.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert37.setCancelable(false);
					dlgAlert37.create().show();

					break;
				case 5:
					// (75G) Leather Chaps

					AlertDialog.Builder dlgAlert3 = new AlertDialog.Builder(getActivity());
					dlgAlert3.setMessage("Type: Ranger \n" + "Defense: +11 \n" + "Ranged Bonus: +13 \n" + "Wield: Legs");
					dlgAlert3.setTitle("Leather Chaps");
					dlgAlert3.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 75) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 75;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 75;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert3.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert3.setCancelable(false);
					dlgAlert3.create().show();

					break;
				case 6:
					// (50G) Leather Boots

					AlertDialog.Builder dlgAlert4 = new AlertDialog.Builder(getActivity());
					dlgAlert4.setMessage("Type: Ranger \n" + "Defense: +7 \n" + "Ranged Bonus: +5 \n" + "Wield: Feet");
					dlgAlert4.setTitle("Leather Boots");
					dlgAlert4.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert4.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert4.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert4.setCancelable(false);
					dlgAlert4.create().show();

					break;
				case 7:
					AlertDialog.Builder dlgAlert92 = new AlertDialog.Builder(getActivity());
					dlgAlert92.setMessage("Studded Leather Cowl: \n" + "Type: Ranger \n" + "Defense: +84 \n" + "Ranged Bonus: +89 \n"
							+ "Wield: Head \n" + "\n" +

							"Studded Leather Cuirass: \n" + "Type: Ranger \n" + "Defense: +97 \n" + "Ranged Bonus: +104 \n" + "Wield: Chest \n"
							+ "\n" +

							"Studded Leather Gloves: \n" + "Type: Ranger \n" + "Defense: +86 \n" + "Ranged Bonus: +91 \n" + "Wield: Hands \n" + "\n" +

							"Studded Leather Chaps: \n" + "Type: Ranger \n" + "Defense: +88 \n" + "Ranged Bonus: +93 \n" + "Wield: Legs \n" + "\n" +

							"Studded Leather Boots: \n" + "Type: Ranger \n" + "Defense: +81 \n" + "Ranged Bonus: +76 \n" + "Wield: Feet \n" + "\n");
					dlgAlert92.setTitle("Studded Leather Armour Set");
					dlgAlert92.setPositiveButton("Buy (375G)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 375) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 375;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 375;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Armour Set added to Inventory" + "- Studded Leather Cowl"
										+ "- Studded Leather Cuirass" + "- Studded Leather Gloves" + "- Studded Leather Chaps"
										+ "- Studded Leather Boots", Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Cowl");
								db.insertRecord("Studded Leather Cuirass");
								db.insertRecord("Studded Leather Gloves");
								db.insertRecord("Studded Leather Chaps");
								db.insertRecord("Studded Leather Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert92.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert92.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert92.setCancelable(false);
					dlgAlert92.create().show();

					break;
				case 8:
					// (450G) Bronze Helmet

					AlertDialog.Builder dlgAlert5 = new AlertDialog.Builder(getActivity());
					dlgAlert5.setMessage("Type: Ranger \n" + "Defense: +84 \n" + "Ranged Bonus: +89 \n" + "Wield: Head");
					dlgAlert5.setTitle("Studded Leather Cowl");
					dlgAlert5.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 450) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 450;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 450;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert5.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert5.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert5.setCancelable(false);
					dlgAlert5.create().show();

					break;
				case 9:
					// (550G) Studded Cuirass

					AlertDialog.Builder dlgAlert6 = new AlertDialog.Builder(getActivity());
					dlgAlert6.setMessage("Type: Ranger \n" + "Defense: +97 \n" + "Ranged Bonus: +104 \n" + "Wield: Chest");
					dlgAlert6.setTitle("Studded Leather Cuirass");
					dlgAlert6.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 550) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 550;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 550;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert6.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert6.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert6.setCancelable(false);
					dlgAlert6.create().show();

					break;
				case 10:
					AlertDialog.Builder dlgAlert99 = new AlertDialog.Builder(getActivity());
					dlgAlert99.setMessage("Type: Ranger \n" + "Defense: +86 \n" + "Ranged Bonus: +91 \n" + "Wield: Hands");
					dlgAlert99.setTitle("Studded Leather Gloves");
					dlgAlert99.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert99.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert99.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert99.setCancelable(false);
					dlgAlert99.create().show();

					break;
				case 11:
					// (475G) Studded Chaps

					AlertDialog.Builder dlgAlert7 = new AlertDialog.Builder(getActivity());
					dlgAlert7.setMessage("Type: Ranger \n" + "Defense: +88 \n" + "Ranged Bonus: +93 \n" + "Wield: Legs");
					dlgAlert7.setTitle("Studded Leather Chaps");
					dlgAlert7.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 475) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 475;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 475;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert7.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert7.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert7.setCancelable(false);
					dlgAlert7.create().show();

					break;
				case 12:
					// (450G) Studded Boots

					AlertDialog.Builder dlgAlert8 = new AlertDialog.Builder(getActivity());
					dlgAlert8.setMessage("Type: Ranger \n" + "Defense: +81 \n" + "Ranged Bonus: +76 \n" + "Wield: Feet");
					dlgAlert8.setTitle("Studded Leather Boots");
					dlgAlert8.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 450) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 450;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 450;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Studded Leather Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Studded Leather Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert8.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert8.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert8.setCancelable(false);
					dlgAlert8.create().show();

					break;
				case 13:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert93 = new AlertDialog.Builder(getActivity());
					dlgAlert93.setMessage("Corrupted Cowl: \n" + "Type: Ranger \n" + "Defense: +148 \n" + "Ranged Bonus: +156 \n" + "Wield: Head \n"
							+ "\n" +

							"Corrupted Cuirass: \n" + "Type: Ranger \n" + "Defense: +159 \n" + "Ranged Bonus: +164 \n" + "Wield: Chest \n" + "\n" +

							"Corrupted Gloves: \n" + "Type: Ranger \n" + "Defense: +150 \n" + "Ranged Bonus: +156 \n" + "Wield: Hands \n" + "\n" +

							"Corrupted Chaps: \n" + "Type: Ranger \n" + "Defense: +152 \n" + "Ranged Bonus: +158 \n" + "Wield: Legs \n" + "\n" +

							"Corrupted Boots: \n" + "Type: Ranger \n" + "Defense: +146 \n" + "Ranged Bonus: +139 \n" + "Wield: Feet \n" + "\n");
					dlgAlert93.setTitle("Corrupted Armour Set");
					dlgAlert93.setPositiveButton("Buy (6.5K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 6500) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 6500;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 6500;
								// .setText("" + purchased);
								Toast msg = Toast
										.makeText(getActivity(), "Corrupted Armour Set added to Inventory" + "- Corrupted Cowl"
												+ "- Corrupted Cuirass" + "- Corrupted Gloves" + "- Corrupted Chaps" + "- Corrupted Boots",
												Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Corrupted Cowl");
								db.insertRecord("Corrupted Cuirass");
								db.insertRecord("Corrupted Gloves");
								db.insertRecord("Corrupted Chaps");
								db.insertRecord("Corrupted Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert93.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert93.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert93.setCancelable(false);
					dlgAlert93.create().show();

					break;
				case 14:
					// (1.5K) Corrupted Cowl

					AlertDialog.Builder dlgAlert9 = new AlertDialog.Builder(getActivity());
					dlgAlert9.setMessage("Type: Ranger \n" + "Defense: +148 \n" + "Ranged Bonus: +156 \n" + "Wield: Head");
					dlgAlert9.setTitle("Corrupted Cowl");
					dlgAlert9.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1500) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1500;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1500;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Corrupted Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Corrupted Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert9.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert9.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert9.setCancelable(false);
					dlgAlert9.create().show();

					break;
				case 15:
					// (1.75K) Corrupted Cuirass

					AlertDialog.Builder dlgAlert10 = new AlertDialog.Builder(getActivity());
					dlgAlert10.setMessage("Type: Ranger \n" + "Defense: +159 \n" + "Ranged Bonus: +164 \n" + "Wield: Chest");
					dlgAlert10.setTitle("Corrupted Cuirass");
					dlgAlert10.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1750) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1750;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1750;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Corrupted Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Corrupted Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert10.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert10.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert10.setCancelable(false);
					dlgAlert10.create().show();

					break;
				case 16:
					AlertDialog.Builder dlgAlert100 = new AlertDialog.Builder(getActivity());
					dlgAlert100.setMessage("Type: Ranger \n" + "Defense: +150 \n" + "Ranged Bonus: +156 \n" + "Wield: Hands");
					dlgAlert100.setTitle("Corrupted Gloves");
					dlgAlert100.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Corrupted Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert100.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert100.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert100.setCancelable(false);
					dlgAlert100.create().show();

					break;
				case 17:
					// (1.6K) Corrupted Chaps

					AlertDialog.Builder dlgAlert11 = new AlertDialog.Builder(getActivity());
					dlgAlert11.setMessage("Type: Ranger \n" + "Defense: +152 \n" + "Ranged Bonus: +158 \n" + "Wield: Legs");
					dlgAlert11.setTitle("Corrupted Chaps");
					dlgAlert11.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1600) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1600;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1600;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Corrupted Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Corrupted Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert11.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert11.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert11.setCancelable(false);
					dlgAlert11.create().show();

					break;
				case 18:
					// (1.5K) Corrupted Boots

					AlertDialog.Builder dlgAlert12 = new AlertDialog.Builder(getActivity());
					dlgAlert12.setMessage("Type: Ranger \n" + "Defense: +146 \n" + "Ranged Bonus: +139 \n" + "Wield: Feet");
					dlgAlert12.setTitle("Corrupted Boots");
					dlgAlert12.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1500) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1500;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1500;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Corrupted Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Corrupted Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert12.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert12.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert12.setCancelable(false);
					dlgAlert12.create().show();

					break;
				case 19:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert94 = new AlertDialog.Builder(getActivity());
					dlgAlert94.setMessage("Demonhide Cowl: \n" + "Type: Ranger \n" + "Defense: +322 \n" + "Ranged Bonus: +329 \n" + "Wield: Head \n"
							+ "\n" +

							"Demonhide Cuirass: \n" + "Type: Ranger \n" + "Defense: +347 \n" + "Ranged Bonus: +356 \n" + "Wield: Chest \n" + "\n" +

							"Demonhide Gloves: \n" + "Type: Ranger \n" + "Defense: +324 \n" + "Ranged Bonus: +330 \n" + "Wield: Hands \n" + "\n" +

							"Demonhide Chaps: \n" + "Type: Ranger \n" + "Defense: +341 \n" + "Ranged Bonus: +348 \n" + "Wield: Legs \n" + "\n" +

							"Demonhide Boots: \n" + "Type: Ranger \n" + "Defense: +318 \n" + "Ranged Bonus: +312 \n" + "Wield: Feet \n" + "\n");
					dlgAlert94.setTitle("Demonhide Armour Set");
					dlgAlert94.setPositiveButton("Buy (44K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 44000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 44000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 44000;
								// .setText("" + purchased);
								Toast msg = Toast
										.makeText(getActivity(), "Demonhide Armour Set added to Inventory" + "- Demonhide Cowl"
												+ "- Demonhide Cuirass" + "- Demonhide Gloves" + "- Demonhide Chaps" + "- Demonhide Boots",
												Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Cowl");
								db.insertRecord("Demonhide Cuirass");
								db.insertRecord("Demonhide Gloves");
								db.insertRecord("Demonhide Chaps");
								db.insertRecord("Demonhide Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert94.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert94.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert94.setCancelable(false);
					dlgAlert94.create().show();

					break;
				case 20:
					// (10K) Demonhide Cowl

					AlertDialog.Builder dlgAlert13 = new AlertDialog.Builder(getActivity());
					dlgAlert13.setMessage("Type: Ranger \n" + "Defense: +322 \n" + "Ranged Bonus: +329 \n" + "Wield: Head");
					dlgAlert13.setTitle("Demonhide Cowl");
					dlgAlert13.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 10000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Demonhide Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert13.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert13.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert13.setCancelable(false);
					dlgAlert13.create().show();

					break;
				case 21:
					// (13K) Demonhide Cuirass

					AlertDialog.Builder dlgAlert14 = new AlertDialog.Builder(getActivity());
					dlgAlert14.setMessage("Type: Ranger \n" + "Defense: +347 \n" + "Ranged Bonus: +356 \n" + "Wield: Chest");
					dlgAlert14.setTitle("Demonhide Cuirass");
					dlgAlert14.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 13000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 13000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 13000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Demonhide Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert14.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert14.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert14.setCancelable(false);
					dlgAlert14.create().show();

					break;
				case 22:
					AlertDialog.Builder dlgAlert101 = new AlertDialog.Builder(getActivity());
					dlgAlert101.setMessage("Type: Ranger \n" + "Defense: +324 \n" + "Ranged Bonus: +330 \n" + "Wield: Hands");
					dlgAlert101.setTitle("Demonhide Gloves");
					dlgAlert101.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Demonhide Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert101.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert101.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert101.setCancelable(false);
					dlgAlert101.create().show();

					break;
				case 23:
					// (10.5K) Demonhide Chaps

					AlertDialog.Builder dlgAlert15 = new AlertDialog.Builder(getActivity());
					dlgAlert15.setMessage("Type: Ranger \n" + "Defense: +341 \n" + "Ranged Bonus: +348 \n" + "Wield: Legs");
					dlgAlert15.setTitle("Demonhide Chaps");
					dlgAlert15.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 10500) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 10500;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 10500;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Demonhide Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert15.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert15.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert15.setCancelable(false);
					dlgAlert15.create().show();

					break;
				case 24:
					// (10K) Demonhide Boots

					AlertDialog.Builder dlgAlert16 = new AlertDialog.Builder(getActivity());
					dlgAlert16.setMessage("Type: Ranger \n" + "Defense: +318 \n" + "Ranged Bonus: +312 \n" + "Wield: Feet");
					dlgAlert16.setTitle("Demonhide Boots");
					dlgAlert16.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 10000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Demonhide Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Demonhide Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert16.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert16.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert16.setCancelable(false);
					dlgAlert16.create().show();

					break;
				case 25:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert95 = new AlertDialog.Builder(getActivity());
					dlgAlert95.setMessage("Darkspawn Cowl: \n" + "Type: Ranger \n" + "Defense:632 + \n" + "Ranged Bonus: +640 \n" + "Wield: Head \n"
							+ "\n" +

							"Darkspawn Cuirass: \n" + "Type: Ranger \n" + "Defense: +658 \n" + "Ranged Bonus: +664 \n" + "Wield: Chest \n" + "\n" +

							"Darkspawn Gloves: \n" + "Type: Ranger \n" + "Defense: +637 \n" + "Ranged Bonus: +642 \n" + "Wield: Hands \n" + "\n" +

							"Darkspawn Chaps: \n" + "Type: Ranger \n" + "Defense: +643 \n" + "Ranged Bonus: +650 \n" + "Wield: Legs \n" + "\n" +

							"Darkspawn Boots: \n" + "Type: Ranger \n" + "Defense: +621 \n" + "Ranged Bonus: +614 \n" + "Wield: Feet \n" + "\n");
					dlgAlert95.setTitle("Darkspawn Armour Set");
					dlgAlert95.setPositiveButton("Buy (370K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 370000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 370000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 370000;
								// .setText("" + purchased);
								Toast msg = Toast
										.makeText(getActivity(), "Darkspawn Armour Set added to Inventory" + "- Darkspawn Cowl"
												+ "- Darkspawn Cuirass" + "- Darkspawn Gloves" + "- Darkspawn Chaps" + "- Darkspawn Boots",
												Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Cowl");
								db.insertRecord("Darkspawn Cuirass");
								db.insertRecord("Darkspawn Gloves");
								db.insertRecord("Darkspawn Chaps");
								db.insertRecord("Darkspawn Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert95.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert95.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert95.setCancelable(false);
					dlgAlert95.create().show();

					break;
				case 26:
					// (100K) Darkspawn Cowl

					AlertDialog.Builder dlgAlert17 = new AlertDialog.Builder(getActivity());
					dlgAlert17.setMessage("Type: Ranger \n" + "Defense: +632 \n" + "Ranged Bonus: +640 \n" + "Wield: Head");
					dlgAlert17.setTitle("Darkspawn Cowl");
					dlgAlert17.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 100000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 100000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Darkspawn Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert17.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert17.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert17.setCancelable(false);
					dlgAlert17.create().show();

					break;
				case 27:
					// (150K) Darkspawn Cuirass

					AlertDialog.Builder dlgAlert18 = new AlertDialog.Builder(getActivity());
					dlgAlert18.setMessage("Type: Ranger \n" + "Defense: +658 \n" + "Ranged Bonus: +664 \n" + "Wield: Chest");
					dlgAlert18.setTitle("Darkspawn Cuirass");
					dlgAlert18.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 150000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 150000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 150000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Darkspawn Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert18.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert18.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert18.setCancelable(false);
					dlgAlert18.create().show();

					break;
				case 28:
					AlertDialog.Builder dlgAlert102 = new AlertDialog.Builder(getActivity());
					dlgAlert102.setMessage("Type: Ranger \n" + "Defense: +637 \n" + "Ranged Bonus: +642 \n" + "Wield: Head");
					dlgAlert102.setTitle("Darkspawn Gloves");
					dlgAlert102.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Darkspawn Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert102.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert102.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert102.setCancelable(false);
					dlgAlert102.create().show();

					break;
				case 29:
					// (120K) Darkspawn Chaps

					AlertDialog.Builder dlgAlert19 = new AlertDialog.Builder(getActivity());
					dlgAlert19.setMessage("Type: Ranger \n" + "Defense: +643 \n" + "Ranged Bonus: +650 \n" + "Wield: Legs");
					dlgAlert19.setTitle("Darkspawn Chaps");
					dlgAlert19.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 120000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 120000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 120000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Darkspawn Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert19.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert19.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert19.setCancelable(false);
					dlgAlert19.create().show();

					break;
				case 30:
					// (100K) Darkspawn Boots

					AlertDialog.Builder dlgAlert20 = new AlertDialog.Builder(getActivity());
					dlgAlert20.setMessage("Type: Ranger \n" + "Defense: +621 \n" + "Ranged Bonus: +614 \n" + "Wield: Feet");
					dlgAlert20.setTitle("Darkspawn Boots");
					dlgAlert20.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 100000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 100000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 100000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Darkspawn Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Darkspawn Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert20.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert20.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert20.setCancelable(false);
					dlgAlert20.create().show();

					break;
				case 32:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert96 = new AlertDialog.Builder(getActivity());
					dlgAlert96
							.setMessage("Black Dragon Cowl: \n" + "Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n"
									+ "Wield: Head \n" + "\n" +

									"Black Dragon Cuirass: \n" + "Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n"
									+ "Wield: Chest \n" + "\n" +

									"Black Dragon Gloves: \n" + "Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n"
									+ "Wield: Hands \n" + "\n" +

									"Black Dragon Chaps: \n" + "Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n"
									+ "Wield: Legs \n" + "\n" +

									"Black Dragon Boots: \n" + "Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n"
									+ "Wield: Feet \n" + "\n");
					dlgAlert96.setTitle("Black Dragon Armour Set");
					dlgAlert96.setPositiveButton("Buy (7M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 7000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 7000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 7000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Black Dragon Armour Set added to Inventory" + "- Black Dragon Cowl"
										+ "- Black Dragon Cuirass" + "- Black Dragon Gloves" + "- Black Dragon Chaps" + "- Black Dragon Boots",
										Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Black Dragon Cowl");
								db.insertRecord("Black Dragon Cuirass");
								db.insertRecord("Black Dragon Gloves");
								db.insertRecord("Black Dragon Chaps");
								db.insertRecord("Black Dragon Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert96.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert96.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert96.setCancelable(false);
					dlgAlert96.create().show();

					break;
				case 33:
					// (1M) Black Dragon Cowl

					AlertDialog.Builder dlgAlert22 = new AlertDialog.Builder(getActivity());
					dlgAlert22.setMessage("Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n" + "Wield: Head");
					dlgAlert22.setTitle("Black Dragon Cowl");
					dlgAlert22.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Black Dragon Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Black Dragon Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert22.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert22.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert22.setCancelable(false);
					dlgAlert22.create().show();

					break;
				case 34:
					// (2.5M) Black Dragon Cuirass

					AlertDialog.Builder dlgAlert23 = new AlertDialog.Builder(getActivity());
					dlgAlert23.setMessage("Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n" + "Wield: Chest");
					dlgAlert23.setTitle("Black Dragon Cuirass");
					dlgAlert23.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 2500000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 2500000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 2500000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Black Dragon Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Black Dragon Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert23.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert23.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert23.setCancelable(false);
					dlgAlert23.create().show();

					break;
				case 35:
					AlertDialog.Builder dlgAlert103 = new AlertDialog.Builder(getActivity());
					dlgAlert103.setMessage("Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n" + "Wield: Head");
					dlgAlert103.setTitle("Black Dragon Gloves");
					dlgAlert103.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert103.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert103.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert103.setCancelable(false);
					dlgAlert103.create().show();

					break;
				case 36:
					// (1.75M) Black Dragon Chaps

					AlertDialog.Builder dlgAlert24 = new AlertDialog.Builder(getActivity());
					dlgAlert24.setMessage("Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n" + "Wield: Legs");
					dlgAlert24.setTitle("Black Dragon Chaps");
					dlgAlert24.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1750000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1750000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1750000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Black Dragon Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Black Dragon Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert24.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert24.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert24.setCancelable(false);
					dlgAlert24.create().show();

					break;
				case 37:
					// (1.5M) Black Dragon Boots

					AlertDialog.Builder dlgAlert25 = new AlertDialog.Builder(getActivity());
					dlgAlert25.setMessage("Type: Ranger \n" + "Defense: +1,000 \n" + "Ranged Bonus: +1,000 \n" + "Wield: Feet");
					dlgAlert25.setTitle("Black Dragon Boots");
					dlgAlert25.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1500000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1500000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1500000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Black Dragon Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Black Dragon Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert25.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert25.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert25.setCancelable(false);
					dlgAlert25.create().show();

					break;
				case 38:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert97 = new AlertDialog.Builder(getActivity());
					dlgAlert97.setMessage("Mystic Cowl: \n" + "Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Head \n"
							+ "\n" +

							"Mystic Cuirass: \n" + "Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Chest \n" + "\n" +

							"Mystic Gloves: \n" + "Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Hands \n" + "\n" +

							"Mystic Chaps: \n" + "Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Legs \n" + "\n" +

							"Mystic Boots: \n" + "Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Feet \n" + "\n");
					dlgAlert97.setTitle("Mystic Armour Set");
					dlgAlert97.setPositiveButton("Buy (60M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 60000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 60000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 60000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Armour Set added to Inventory" + "- Mystic Cowl"
										+ "- Mystic Cuirass" + "- Mystic Gloves" + "- Mystic Chaps" + "- Mystic Boots", Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Mystic Cowl");
								db.insertRecord("Mystic Cuirass");
								db.insertRecord("Mystic Gloves");
								db.insertRecord("Mystic Chaps");
								db.insertRecord("Mystic Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert97.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert97.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert97.setCancelable(false);
					dlgAlert97.create().show();

					break;
				case 39:
					// (13M) Mystic Cowl

					AlertDialog.Builder dlgAlert26 = new AlertDialog.Builder(getActivity());
					dlgAlert26.setMessage("Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Head");
					dlgAlert26.setTitle("Mystic Cowl");
					dlgAlert26.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 13000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 13000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 13000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Mystic Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert26.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert26.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert26.setCancelable(false);
					dlgAlert26.create().show();

					break;
				case 40:
					// (17M) Mystic Cuirass

					AlertDialog.Builder dlgAlert27 = new AlertDialog.Builder(getActivity());
					dlgAlert27.setMessage("Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Chest");
					dlgAlert27.setTitle("Mystic Cuirass");
					dlgAlert27.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 17000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 17000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 17000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Mystic Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert27.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert27.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert27.setCancelable(false);
					dlgAlert27.create().show();

					break;
				case 41:
					AlertDialog.Builder dlgAlert104 = new AlertDialog.Builder(getActivity());
					dlgAlert104.setMessage("Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Head");
					dlgAlert104.setTitle("Mystic Gloves");
					dlgAlert104.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Leather Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Leather Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert104.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert104.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert104.setCancelable(false);
					dlgAlert104.create().show();

					break;
				case 42:
					// (14M) Mystic Chaps

					AlertDialog.Builder dlgAlert28 = new AlertDialog.Builder(getActivity());
					dlgAlert28.setMessage("Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Legs");
					dlgAlert28.setTitle("Mystic Chaps");
					dlgAlert28.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 14000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 14000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 14000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Mystic Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert28.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert28.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert28.setCancelable(false);
					dlgAlert28.create().show();

					break;
				case 43:
					// (12M) Mystic Boots

					AlertDialog.Builder dlgAlert29 = new AlertDialog.Builder(getActivity());
					dlgAlert29.setMessage("Type: Ranger \n" + "Defense: +3,500 \n" + "Ranged Bonus: +3,500 \n" + "Wield: Feet");
					dlgAlert29.setTitle("Mystic Boots");
					dlgAlert29.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 12000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 12000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 12000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Mystic Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert29.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert29.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert29.setCancelable(false);
					dlgAlert29.create().show();

					break;
				case 44:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert98 = new AlertDialog.Builder(getActivity());
					dlgAlert98.setMessage("Zanthiir's Cowl: \n" + "Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n"
							+ "Wield: Head \n" + "\n" +

							"Zanthiir's Cuirass: \n" + "Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Chest \n"
							+ "\n" +

							"Zanthiir's Gloves: \n" + "Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Hands \n" + "\n"
							+

							"Zanthiir's Chaps: \n" + "Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Legs \n" + "\n" +

							"Zanthiir's Boots: \n" + "Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Feet \n" + "\n");
					dlgAlert98.setTitle("Zanthiir's Armour Set");
					dlgAlert98.setPositiveButton("Buy (110M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 110000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 110000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 110000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Armour Set added to Inventory" + "- Zanthiir's Cowl"
										+ "- Zanthiir's Cuirass" + "- Zanthiir's Gloves" + "- Zanthiir's Chaps" + "- Zanthiir's Boots",
										Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Cowl");
								db.insertRecord("Zanthiir's Cuirass");
								db.insertRecord("Zanthiir's Gloves");
								db.insertRecord("Zanthiir's Chaps");
								db.insertRecord("Zanthiir's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert98.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert98.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert98.setCancelable(false);
					dlgAlert98.create().show();

					break;
				case 45:
					// (25M) Zanthiir's Cowl

					AlertDialog.Builder dlgAlert30 = new AlertDialog.Builder(getActivity());
					dlgAlert30.setMessage("Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Head");
					dlgAlert30.setTitle("Zanthiir's Cowl");
					dlgAlert30.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 25000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 25000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 25000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert30.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert30.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert30.setCancelable(false);
					dlgAlert30.create().show();

					break;
				case 46:
					// (28M) Zanthiir's Cuirass

					AlertDialog.Builder dlgAlert31 = new AlertDialog.Builder(getActivity());
					dlgAlert31.setMessage("Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Chest");
					dlgAlert31.setTitle("Zanthiir's Cuirass");
					dlgAlert31.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 28000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 28000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 28000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert31.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert31.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert31.setCancelable(false);
					dlgAlert31.create().show();

					break;
				case 47:
					AlertDialog.Builder dlgAlert105 = new AlertDialog.Builder(getActivity());
					dlgAlert105.setMessage("Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Head");
					dlgAlert105.setTitle("Zanthiir's Gloves");
					dlgAlert105.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert105.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert105.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert105.setCancelable(false);
					dlgAlert105.create().show();

					break;
				case 48:
					// (26.5M) Zanthiir's Chaps

					AlertDialog.Builder dlgAlert32 = new AlertDialog.Builder(getActivity());
					dlgAlert32.setMessage("Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Legs");
					dlgAlert32.setTitle("Zanthiir's Chaps");
					dlgAlert32.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 26500000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 26500000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 26500000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert32.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert32.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert32.setCancelable(false);
					dlgAlert32.create().show();

					break;
				case 49:
					// (23M) Zanthiir's Boots

					AlertDialog.Builder dlgAlert33 = new AlertDialog.Builder(getActivity());
					dlgAlert33.setMessage("Type: Ranger \n" + "Defense: +7,000 \n" + "Ranged Bonus: +7,000 \n" + "Wield: Feet");
					dlgAlert33.setTitle("Zanthiir's Boots");
					dlgAlert33.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 23000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 23000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 23000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert33.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert33.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert33.setCancelable(false);
					dlgAlert33.create().show();

					break;
				case 50:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert106 = new AlertDialog.Builder(getActivity());
					dlgAlert106.setMessage("Hērō's Cowl: \n" + "Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n"
							+ "Wield: Head \n" + "\n" +

							"Hērō's Cuirass: \n" + "Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Chest \n" + "\n" +

							"Hērō's Gloves: \n" + "Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Hands \n" + "\n" +

							"Hērō's Chaps: \n" + "Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Legs \n" + "\n" +

							"Hērō's Boots: \n" + "Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Feet \n" + "\n");
					dlgAlert106.setTitle("Hērō's Armour Set");
					dlgAlert106.setPositiveButton("Buy (110M)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 110000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 110000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 110000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Armour Set added to Inventory" + "- Hērō's Cowl"
										+ "- Hērō's Cuirass" + "- Hērō's Gloves" + "- Hērō's Chaps" + "- Hērō's Boots", Toast.LENGTH_LONG);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Cowl");
								db.insertRecord("Hērō's Cuirass");
								db.insertRecord("Hērō's Gloves");
								db.insertRecord("Hērō's Chaps");
								db.insertRecord("Hērō's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();

							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert106.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert106.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert106.setCancelable(false);
					dlgAlert106.create().show();

					break;
				case 51:
					// (50M) Hērō's Cowl

					AlertDialog.Builder dlgAlert34 = new AlertDialog.Builder(getActivity());
					dlgAlert34.setMessage("Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Head");
					dlgAlert34.setTitle("Hērō's Cowl");
					dlgAlert34.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Cowl added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Cowl");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert34.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert34.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert34.setCancelable(false);
					dlgAlert34.create().show();

					break;
				case 52:
					// (75M) Hērō's Cuirass

					AlertDialog.Builder dlgAlert35 = new AlertDialog.Builder(getActivity());
					dlgAlert35.setMessage("Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Chest");
					dlgAlert35.setTitle("Hērō's Cuirass");
					dlgAlert35.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 75000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 75000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 75000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Cuirass added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Cuirass");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert35.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert35.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert35.setCancelable(false);
					dlgAlert35.create().show();

					break;
				case 53:
					AlertDialog.Builder dlgAlert107 = new AlertDialog.Builder(getActivity());
					dlgAlert107.setMessage("Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Hands");
					dlgAlert107.setTitle("Hērō's Gloves");
					dlgAlert107.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Gloves added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Gloves");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert107.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert107.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert107.setCancelable(false);
					dlgAlert107.create().show();

					break;
				case 54:
					// (65M) Hērō's Chaps

					AlertDialog.Builder dlgAlert36 = new AlertDialog.Builder(getActivity());
					dlgAlert36.setMessage("Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Legs");
					dlgAlert36.setTitle("Hērō's Chaps");
					dlgAlert36.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 65000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 65000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 65000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Chaps added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Chaps");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert36.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert36.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert36.setCancelable(false);
					dlgAlert36.create().show();

					break;
				case 55:
					// (49M) Hērō's Boots

					AlertDialog.Builder dlgAlert200 = new AlertDialog.Builder(getActivity());
					dlgAlert200.setMessage("Type: Ranger \n" + "Defense: +10,000 \n" + "Ranged Bonus: +10,000 \n" + "Wield: Feet");
					dlgAlert200.setTitle("Hērō's Boots");
					dlgAlert200.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert200.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert200.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert200.setCancelable(false);
					dlgAlert200.create().show();

					break;
				}

			}
		});

		String RangerWeapons;
		List<HashMap<String, String>> RangerWeaponsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Ranger Weapons ---");
			temp.put("Requirements", "Class: Cleric, Ranger, Rouge");
			RangerWeaponsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(1K) Shortbow");
			temp1.put("Requirements", "Req. Level: 10");
			RangerWeaponsData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(2K) Longbow");
			temp2.put("Requirements", "Req. Level: 10");
			RangerWeaponsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(4K) Crossbow");
			temp3.put("Requirements", "Req. Level: 10");
			RangerWeaponsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(10K) Oak Shortbow");
			temp4.put("Requirements", "Req. Level: 75");
			RangerWeaponsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(13K) Oak Longbow");
			temp5.put("Requirements", "Req. Level: 75");
			RangerWeaponsData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(18K) Oak Crossbow");
			temp6.put("Requirements", "Req. Level: 75");
			RangerWeaponsData.add(temp6);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(25K) Maple Shortbow");
			temp7.put("Requirements", "Req. Level: 150");
			RangerWeaponsData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(28K) Maple Longbow");
			temp8.put("Requirements", "Req. Level: 150");
			RangerWeaponsData.add(temp8);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(33K) Maple Crossbow");
			temp9.put("Requirements", "Req. Level: 150");
			RangerWeaponsData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(60K) Ash Shortbow");
			temp10.put("Requirements", "Req. Level: 300");
			RangerWeaponsData.add(temp10);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "(63K) Ash Longbow");
			temp11.put("Requirements", "Req. Level: 300");
			RangerWeaponsData.add(temp11);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(65K) Ash Crossbow");
			temp12.put("Requirements", "Req. Level: 300");
			RangerWeaponsData.add(temp12);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(150K) Ebony Shortbow");
			temp13.put("Requirements", "Req. Level: 750");
			RangerWeaponsData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(155K) Ebony Longbow");
			temp14.put("Requirements", "Req. Level: 750");
			RangerWeaponsData.add(temp14);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(162K) Ebony Crossbow");
			temp15.put("Requirements", "Req. Level: 750");
			RangerWeaponsData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "-~- Specialty Ranger Weapons -~-");
			RangerWeaponsData.add(temp16);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(1M) Dragon Bow");
			temp17.put("Requirements", "Req. Level: 1000");
			RangerWeaponsData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(15M) Mystic Bow");
			temp18.put("Requirements", "Req. Level: 3500");
			RangerWeaponsData.add(temp18);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(33M) Zanthiir's Composite Bow");
			temp19.put("Requirements", "Req. Level: 7500");
			RangerWeaponsData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(50M) Hērō's Bow");
			temp20.put("Requirements", "Req. Level: 10000");
			RangerWeaponsData.add(temp20);
		}

		SimpleAdapter RangerWeaponsAdapter = new SimpleAdapter(getActivity(), RangerWeaponsData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		RangedWeaponsList.setAdapter(RangerWeaponsAdapter);

		RangedWeaponsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

					dlgAlert.setMessage("Type: Ranged \n" + "Attack: +14 \n" + "Accuracy: +16 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert.setTitle("Shortbow");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Shortbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Shortbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
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
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(getActivity());

					dlgAlert2.setMessage("Type: Ranged \n" + "Attack: +17 \n" + "Accuracy: +19 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert2.setTitle("Longbow");
					dlgAlert2.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 2000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 2000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 2000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Longbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Longbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert2.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert2.setCancelable(false);
					dlgAlert2.create().show();

					break;
				case 3:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert3 = new AlertDialog.Builder(getActivity());

					dlgAlert3.setMessage("Type: Ranged \n" + "Attack: +21 \n" + "Accuracy: +24 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert3.setTitle("Crossbow");
					dlgAlert3.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 4000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 4000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 4000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Crossbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Crossbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert3.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert3.setCancelable(false);
					dlgAlert3.create().show();

					break;
				case 4:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert4 = new AlertDialog.Builder(getActivity());

					dlgAlert4.setMessage("Type: Ranged \n" + "Attack: +77 \n" + "Accuracy: +79 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert4.setTitle("Oak Shortbow");
					dlgAlert4.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 10000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 10000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 10000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Oak Shortbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Oak Shortbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert4.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert4.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert4.setCancelable(false);
					dlgAlert4.create().show();

					break;
				case 5:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert5 = new AlertDialog.Builder(getActivity());

					dlgAlert5.setMessage("Type: Ranged \n" + "Attack: +82 \n" + "Accuracy: +87 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert5.setTitle("Oak Longbow");
					dlgAlert5.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 13000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 13000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 13000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Oak Longbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Oak Longbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert5.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert5.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert5.setCancelable(false);
					dlgAlert5.create().show();

					break;
				case 6:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert6 = new AlertDialog.Builder(getActivity());

					dlgAlert6.setMessage("Type: Ranged \n" + "Attack: +85 \n" + "Accuracy: +91 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert6.setTitle("Oak Crossbow");
					dlgAlert6.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 18000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 18000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 18000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Oak Crossbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Oak Crossbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert6.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert6.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert6.setCancelable(false);
					dlgAlert6.create().show();

					break;
				case 7:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert7 = new AlertDialog.Builder(getActivity());

					dlgAlert7.setMessage("Type: Ranged \n" + "Attack: +147 \n" + "Accuracy: +152 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert7.setTitle("Maple Shortbow");
					dlgAlert7.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 25000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 25000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 25000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Maple Shortbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Maple Shortbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert7.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert7.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert7.setCancelable(false);
					dlgAlert7.create().show();

					break;
				case 8:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert8 = new AlertDialog.Builder(getActivity());

					dlgAlert8.setMessage("Type: Ranged \n" + "Attack: +153 \n" + "Accuracy: +159 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert8.setTitle("Maple Longbow");
					dlgAlert8.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 28000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 28000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 28000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Maple Longbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Maple Longbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert8.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert8.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert8.setCancelable(false);
					dlgAlert8.create().show();

					break;
				case 9:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert9 = new AlertDialog.Builder(getActivity());

					dlgAlert9.setMessage("Type: Ranged \n" + "Attack: +160 \n" + "Accuracy: +167 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert9.setTitle("Maple Crossbow");
					dlgAlert9.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 33000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 33000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 33000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Maple Crossbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Maple Crossbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert9.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert9.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert9.setCancelable(false);
					dlgAlert9.create().show();

					break;
				case 10:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert10 = new AlertDialog.Builder(getActivity());

					dlgAlert10.setMessage("Type: Ranged \n" + "Attack: +290 \n" + "Accuracy: +297 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert10.setTitle("Ash Shortbow");
					dlgAlert10.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 60000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 60000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 60000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ash Shortbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ash Shortbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert10.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert10.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert10.setCancelable(false);
					dlgAlert10.create().show();

					break;
				case 11:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert11 = new AlertDialog.Builder(getActivity());

					dlgAlert11.setMessage("Type: Ranged \n" + "Attack: +304 \n" + "Accuracy: +310 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert11.setTitle("Ash Longbow");
					dlgAlert11.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 63000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 63000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 63000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ash Longbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ash Longbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert11.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert11.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert11.setCancelable(false);
					dlgAlert11.create().show();

					break;
				case 12:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert12 = new AlertDialog.Builder(getActivity());

					dlgAlert12.setMessage("Type: Ranged \n" + "Attack: +311 \n" + "Accuracy: +317 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert12.setTitle("Ash Crossbow");
					dlgAlert12.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 65000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 65000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 65000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ash Crossbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ash Crossbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert12.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert12.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert12.setCancelable(false);
					dlgAlert12.create().show();

					break;
				case 13:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert13 = new AlertDialog.Builder(getActivity());

					dlgAlert13.setMessage("Type: Ranged \n" + "Attack: +732 \n" + "Accuracy: +747 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert13.setTitle("Ebony Shortbow");
					dlgAlert13.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 150000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 150000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 150000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ebony Shortbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ebony Shortbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert13.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert13.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert13.setCancelable(false);
					dlgAlert13.create().show();

					break;
				case 14:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert14 = new AlertDialog.Builder(getActivity());

					dlgAlert14.setMessage("Type: Ranged \n" + "Attack: +755 \n" + "Accuracy: +762 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert14.setTitle("Ebony Longbow");
					dlgAlert14.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 155000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 155000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 155000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ebony Longbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ebony Longbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert14.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert14.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert14.setCancelable(false);
					dlgAlert14.create().show();

					break;
				case 15:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert15 = new AlertDialog.Builder(getActivity());

					dlgAlert15.setMessage("Type: Ranged \n" + "Attack: +764 \n" + "Accuracy: +779 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert15.setTitle("Ebony Crossbow");
					dlgAlert15.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 163000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 163000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 163000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Ebony Crossbow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ebony Crossbow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert15.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert15.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert15.setCancelable(false);
					dlgAlert15.create().show();

					break;
				case 17:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert17 = new AlertDialog.Builder(getActivity());

					dlgAlert17.setMessage("Type: Ranged \n" + "Attack: +1,000 \n" + "Accuracy: +1,000 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert17.setTitle("Dragon Bow");
					dlgAlert17.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 1000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 1000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 1000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Dragon Bow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Bow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert17.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert17.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert17.setCancelable(false);
					dlgAlert17.create().show();

					break;
				case 18:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert18 = new AlertDialog.Builder(getActivity());

					dlgAlert18.setMessage("Type: Ranged \n" + "Attack: +3,500 \n" + "Accuracy: +3,500 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert18.setTitle("Mystic bow");
					dlgAlert18.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 15000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 15000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 15000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Mystic Bow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Mystic Bow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert18.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert18.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert18.setCancelable(false);
					dlgAlert18.create().show();

					break;
				case 19:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert19 = new AlertDialog.Builder(getActivity());

					dlgAlert19.setMessage("Type: Ranged \n" + "Attack: +7,500 \n" + "Accuracy: +7,500 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert19.setTitle("Zanthiir's Composite Bow");
					dlgAlert19.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 33000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 33000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 33000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Zanthiir's Composite Bow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Zanthiir's Composite Bow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert19.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert19.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert19.setCancelable(false);
					dlgAlert19.create().show();

					break;
				case 20:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert20 = new AlertDialog.Builder(getActivity());

					dlgAlert20.setMessage("Type: Ranged \n" + "Attack: +10,000 \n" + "Accuracy: +10,000 \n" + "Wield: Primary & Secondary Hand");
					dlgAlert20.setTitle("Hērō's Bow");
					dlgAlert20.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(goldRangedFragment.getText().toString()) >= 50000000) {
								int gold1 = Integer.parseInt(goldRangedFragment.getText().toString()) - 50000000;
								goldRangedFragment.setText("" + gold1);
								// = Integer.parseInt(//.getText().toString()) +
								// 50000000;
								// .setText("" + purchased);
								Toast msg = Toast.makeText(getActivity(), "Hērō's Bow added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Hērō's Bow");
								db.close();
								dbGold.open();
								dbGold.insertRecord(goldRangedFragment.getText().toString());
								dbGold.close();
								replaceInt();
							} else {
								Toast msg = Toast.makeText(getActivity(), "You don't have enough gold!", Toast.LENGTH_SHORT);
								msg.show();
							}
							dialog.dismiss();
						}
					});
					dlgAlert20.setNeutralButton("View info", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert20.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							dialog.dismiss();
						}
					});
					dlgAlert20.setCancelable(false);
					dlgAlert20.create().show();

					break;
				}
			}
		});
		return rootView;
	}

	private void rangedListCheck(final RadioButton rdoRangedArmour, final RadioButton rdoRangedWeapons, final ListView RangedArmourList,
			final ListView RangedWeaponsList) {

		rdoRangedArmour.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoRangedArmour.isChecked() == true) {
					rdoRangedWeapons.setChecked(false);

					RangedArmourList.setVisibility(View.VISIBLE);
					RangedWeaponsList.setVisibility(View.INVISIBLE);
				}
			}
		});

		rdoRangedWeapons.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoRangedWeapons.isChecked() == true) {
					rdoRangedArmour.setChecked(false);

					RangedArmourList.setVisibility(View.INVISIBLE);
					RangedWeaponsList.setVisibility(View.VISIBLE);
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
