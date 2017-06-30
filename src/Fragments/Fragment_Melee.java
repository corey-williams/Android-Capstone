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

import com.Logik.dawn.of.ages.BeforeYouBegin;
import com.Logik.dawn.of.ages.Equipment;
import com.Logik.dawn.of.ages.Inventory;
import com.Logik.dawn.of.ages.PlayScreen;
import com.Logik.dawn.of.ages.R;
import com.Logik.dawn.of.ages.Shop;
import com.Logik.dawn.of.ages.R.id;
import com.Logik.dawn.of.ages.R.layout;

import Databases.DBAdapter;
import Databases.DBAdapter_Gold;
import ItemInfo.MeleeItemInfo;
import android.annotation.SuppressLint;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Melee extends ListFragment {

	private DBAdapter_Gold dbGold;
	private DBAdapter db;

	@SuppressWarnings("unused")
	@SuppressLint("SdCardPath")
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		/*-------------------------------------------------------------------------------*
		 ********************************* View Inflator *********************************
		 *-------------------------------------------------------------------------------*/

		final View rootView = inflater.inflate(R.layout.fragment_melee, container, false);
		setHasOptionsMenu(true);

		/*-------------------------------------------------------------------------------*
		 ****************************** Variable Declaration *****************************
		 *-------------------------------------------------------------------------------*/

		final MeleeItemInfo itemInfo = new MeleeItemInfo();
		final String info = null;
		
        final TextView textViewShopGoldValue1 = (TextView) rootView.findViewById(R.id.shopGoldValue1);
		final ListView MeleeArmourList = (ListView) rootView.findViewById(R.id.meleeArmourList);
		final ListView MeleeWeaponsList = (ListView) rootView.findViewById(R.id.meleeWeaponsList);
		final RadioButton rdoMeleeArmour = (RadioButton) rootView.findViewById(R.id.radioMeleeArmour);
		final RadioButton rdoMeleeWeapons = (RadioButton) rootView.findViewById(R.id.radioMeleeWeapons);

		meleeListCheck(rdoMeleeArmour, rdoMeleeWeapons, MeleeArmourList, MeleeWeaponsList);

		// format the gold database HERE

		/*-------------------------------------------------------------------------------*
		 ****************************** Database Procedure *******************************
		 *-------------------------------------------------------------------------------*/

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
					textViewShopGoldValue1.setText(c.getString(1).toString());
				} while (c.moveToNext());
			}
			dbGold.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}

		/*-------------------------------------------------------------------------------*
		 *************************** Melee Armour List Procedure *************************
		 *-------------------------------------------------------------------------------*/

		String MeleeArmour;
		List<HashMap<String, String>> MeleeArmourData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Melee Armour ---");
			temp.put("Requirements", "Class: Cleric, Paladin, Warrior");
			MeleeArmourData.add(temp);
			HashMap<String, String> temp54 = new HashMap<String, String>();
			temp54.put("Item", "(725G) Bronze Armour Set");
			temp54.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp54);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(100G) Bronze Helmet");
			temp1.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(250G) Bronze Chestplate");
			temp2.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp2);
			HashMap<String, String> temp222 = new HashMap<String, String>();
			temp222.put("Item", "(150G) Bronze Gauntlets");
			temp222.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp222);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(125G) Bronze Platelegs");
			temp3.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(100G) Bronze Boots");
			temp4.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp4);
			HashMap<String, String> temp67 = new HashMap<String, String>();
			temp67.put("Item", "(150G) Bronze Shield");
			temp67.put("Requirements", "Req. Level: 10");
			MeleeArmourData.add(temp67);
			HashMap<String, String> temp55 = new HashMap<String, String>();
			temp55.put("Item", "(~1.5K) Iron Armour Set");
			temp55.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp55);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(250G) Iron Helmet");
			temp5.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(450G) Iron Chestplate");
			temp6.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp6);
			HashMap<String, String> temp223 = new HashMap<String, String>();
			temp223.put("Item", "(325G) Iron Gauntlets");
			temp223.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp223);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(275G) Iron Platelegs");
			temp7.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(250G) Iron Boots");
			temp8.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp8);
			HashMap<String, String> temp68 = new HashMap<String, String>();
			temp68.put("Item", "(300G) Iron Shield");
			temp68.put("Requirements", "Req. Level: 25");
			MeleeArmourData.add(temp68);
			HashMap<String, String> temp56 = new HashMap<String, String>();
			temp56.put("Item", "(~3K) Steel Armour Set");
			temp56.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp56);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(600G) Steel Helmet");
			temp9.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(750G) Steel Chestplate");
			temp10.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp10);
			HashMap<String, String> temp224 = new HashMap<String, String>();
			temp224.put("Item", "(675G) Steel Gauntlets");
			temp224.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp224);
			HashMap<String, String> temp11 = new HashMap<String, String>();
			temp11.put("Item", "(575G) Steel Platelegs");
			temp11.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp11);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(550G) Steel Boots");
			temp12.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp12);
			HashMap<String, String> temp69 = new HashMap<String, String>();
			temp69.put("Item", "(600G) Steel Shield");
			temp69.put("Requirements", "Req. Level: 45");
			MeleeArmourData.add(temp69);
			HashMap<String, String> temp57 = new HashMap<String, String>();
			temp57.put("Item", "(6.8K) Dwarven Armour Set");
			temp57.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp57);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(1.5K) Dwarven Helmet");
			temp13.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(1.75K) Dwarven Chestplate");
			temp14.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp14);
			HashMap<String, String> temp225 = new HashMap<String, String>();
			temp225.put("Item", "(1.6K) Dwarven Gauntlets");
			temp225.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp225);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(1.3K) Dwarven Platelegs");
			temp15.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "(1K) Dwarven Boots");
			temp16.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp16);
			HashMap<String, String> temp70 = new HashMap<String, String>();
			temp70.put("Item", "(1.25K) Dwarven Shield");
			temp70.put("Requirements", "Req. Level: 75");
			MeleeArmourData.add(temp70);
			HashMap<String, String> temp58 = new HashMap<String, String>();
			temp58.put("Item", "(~29K) Elven Armour Set");
			temp58.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp58);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(5K) Elven Helmet");
			temp17.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(7.5K) Elven Chestplate");
			temp18.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp18);
			HashMap<String, String> temp226 = new HashMap<String, String>();
			temp226.put("Item", "(6.3K) Elven Gauntlets");
			temp226.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp226);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(6K) Elven Platelegs");
			temp19.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(5.5K) Elven Boots");
			temp20.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp20);
			HashMap<String, String> temp71 = new HashMap<String, String>();
			temp71.put("Item", "(5.2K) Elven Shield");
			temp71.put("Requirements", "Req. Level: 100");
			MeleeArmourData.add(temp71);
			HashMap<String, String> temp59 = new HashMap<String, String>();
			temp59.put("Item", "(55.5K) Orcish Armour Set");
			temp59.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp59);
			HashMap<String, String> temp21 = new HashMap<String, String>();
			temp21.put("Item", "(10K) Orcish Helmet");
			temp21.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp21);
			HashMap<String, String> temp22 = new HashMap<String, String>();
			temp22.put("Item", "(12K) Orcish Chestplate");
			temp22.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp22);
			HashMap<String, String> temp227 = new HashMap<String, String>();
			temp227.put("Item", "(11K) Orcish Gauntlets");
			temp227.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp227);
			HashMap<String, String> temp23 = new HashMap<String, String>();
			temp23.put("Item", "(11.5K) Orcish Platelegs");
			temp23.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp23);
			HashMap<String, String> temp24 = new HashMap<String, String>();
			temp24.put("Item", "(10K) Orcish Boots");
			temp24.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp24);
			HashMap<String, String> temp72 = new HashMap<String, String>();
			temp72.put("Item", "(12K) Orcish Shield");
			temp72.put("Requirements", "Req. Level: 125");
			MeleeArmourData.add(temp72);
			HashMap<String, String> temp60 = new HashMap<String, String>();
			temp60.put("Item", "(106K) Runic Armour Set");
			temp60.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp60);
			HashMap<String, String> temp25 = new HashMap<String, String>();
			temp25.put("Item", "(20K) Runic Helmet");
			temp25.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp25);
			HashMap<String, String> temp26 = new HashMap<String, String>();
			temp26.put("Item", "(22.5K) Runic Chestplate");
			temp26.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp26);
			HashMap<String, String> temp228 = new HashMap<String, String>();
			temp228.put("Item", "(21.5K) Runic Gauntlets");
			temp228.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp228);
			HashMap<String, String> temp27 = new HashMap<String, String>();
			temp27.put("Item", "(21K) Runic Platelegs");
			temp27.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp27);
			HashMap<String, String> temp28 = new HashMap<String, String>();
			temp28.put("Item", "(20K) Runic Boots");
			temp28.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp28);
			HashMap<String, String> temp73 = new HashMap<String, String>();
			temp73.put("Item", "(22.5K) Runic Shield");
			temp73.put("Requirements", "Req. Level: 175");
			MeleeArmourData.add(temp73);
			HashMap<String, String> temp61 = new HashMap<String, String>();
			temp61.put("Item", "(~260K) Guardian Armour Set");
			temp61.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp61);
			HashMap<String, String> temp29 = new HashMap<String, String>();
			temp29.put("Item", "(50K) Guardian Helmet");
			temp29.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp29);
			HashMap<String, String> temp30 = new HashMap<String, String>();
			temp30.put("Item", "(55K) Guardian Chestplate");
			temp30.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp30);
			HashMap<String, String> temp229 = new HashMap<String, String>();
			temp229.put("Item", "(53K) Guardian Gauntlets");
			temp229.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp229);
			HashMap<String, String> temp31 = new HashMap<String, String>();
			temp31.put("Item", "(52.5K) Guardian Platelegs");
			temp31.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp31);
			HashMap<String, String> temp32 = new HashMap<String, String>();
			temp32.put("Item", "(50K) Guardian Boots");
			temp32.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp32);
			HashMap<String, String> temp74 = new HashMap<String, String>();
			temp74.put("Item", "(52.5K) Guardian Shield");
			temp74.put("Requirements", "Req. Level: 250");
			MeleeArmourData.add(temp74);
			HashMap<String, String> temp62 = new HashMap<String, String>();
			temp62.put("Item", "(~485K) Ancient Armour Set");
			temp62.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp62);
			HashMap<String, String> temp33 = new HashMap<String, String>();
			temp33.put("Item", "(95K) Ancient Helmet");
			temp33.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp33);
			HashMap<String, String> temp34 = new HashMap<String, String>();
			temp34.put("Item", "(100K) Ancient Chestplate");
			temp34.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp34);
			HashMap<String, String> temp230 = new HashMap<String, String>();
			temp230.put("Item", "(98K) Ancient Gauntlets");
			temp230.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp230);
			HashMap<String, String> temp35 = new HashMap<String, String>();
			temp35.put("Item", "(97K) Ancient Platelegs");
			temp35.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp35);
			HashMap<String, String> temp36 = new HashMap<String, String>();
			temp36.put("Item", "(95K) Ancient Boots");
			temp36.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp36);
			HashMap<String, String> temp75 = new HashMap<String, String>();
			temp75.put("Item", "(97.25K) Ancient Shield");
			temp75.put("Requirements", "Req. Level: 375");
			MeleeArmourData.add(temp75);
			HashMap<String, String> temp63 = new HashMap<String, String>();
			temp63.put("Item", "(~1.6M) Dragon Armour Set");
			temp63.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp63);
			HashMap<String, String> temp37 = new HashMap<String, String>();
			temp37.put("Item", "(300K) Dragon Helmet");
			temp37.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp37);
			HashMap<String, String> temp38 = new HashMap<String, String>();
			temp38.put("Item", "(350K) Dragon Chestplate");
			temp38.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp38);
			HashMap<String, String> temp231 = new HashMap<String, String>();
			temp231.put("Item", "(325K) Dragon Gauntlets");
			temp231.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp231);
			HashMap<String, String> temp39 = new HashMap<String, String>();
			temp39.put("Item", "(320K) Dragon Platelegs");
			temp39.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp39);
			HashMap<String, String> temp40 = new HashMap<String, String>();
			temp40.put("Item", "(300K) Dragon Boots");
			temp40.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp40);
			HashMap<String, String> temp76 = new HashMap<String, String>();
			temp76.put("Item", "(325K) Dragon Shield");
			temp76.put("Requirements", "Req. Level: 500");
			MeleeArmourData.add(temp76);
			HashMap<String, String> temp41 = new HashMap<String, String>();
			temp41.put("Item", "-~- Specialty Melee Armour -~-");
			MeleeArmourData.add(temp41);
			HashMap<String, String> temp64 = new HashMap<String, String>();
			temp64.put("Item", "(7.5M) Forlorn Armour Set");
			temp64.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp64);
			HashMap<String, String> temp42 = new HashMap<String, String>();
			temp42.put("Item", "(1M) Forlorn Helmet");
			temp42.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp42);
			HashMap<String, String> temp43 = new HashMap<String, String>();
			temp43.put("Item", "(2.5M) Forlorn Chestplate");
			temp43.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp43);
			HashMap<String, String> temp232 = new HashMap<String, String>();
			temp232.put("Item", "(2M) Forlorn Gauntlets");
			temp232.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp232);
			HashMap<String, String> temp44 = new HashMap<String, String>();
			temp44.put("Item", "(1.7M) Forlorn Platelegs");
			temp44.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp44);
			HashMap<String, String> temp45 = new HashMap<String, String>();
			temp45.put("Item", "(1.5M) Forlorn Boots");
			temp45.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp45);
			HashMap<String, String> temp77 = new HashMap<String, String>();
			temp77.put("Item", "(1.5M) Forlorn Shield");
			temp77.put("Requirements", "Req. Level: 1,000");
			MeleeArmourData.add(temp77);
			HashMap<String, String> temp65 = new HashMap<String, String>();
			temp65.put("Item", "(~80M) Legendary Armour Set");
			temp65.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp65);
			HashMap<String, String> temp46 = new HashMap<String, String>();
			temp46.put("Item", "(15M) Legendary Helmet");
			temp46.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp46);
			HashMap<String, String> temp47 = new HashMap<String, String>();
			temp47.put("Item", "(18M) Legendary Chestplate");
			temp47.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp47);
			HashMap<String, String> temp233 = new HashMap<String, String>();
			temp233.put("Item", "(17M) Legendary Gauntlets");
			temp233.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp233);
			HashMap<String, String> temp48 = new HashMap<String, String>();
			temp48.put("Item", "(16.5M) Legendary Platelegs");
			temp48.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp48);
			HashMap<String, String> temp49 = new HashMap<String, String>();
			temp49.put("Item", "(14M) Legendary Boots");
			temp49.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp49);
			HashMap<String, String> temp78 = new HashMap<String, String>();
			temp78.put("Item", "(15.5M) Legendary Shield");
			temp78.put("Requirements", "Req. Level: 5,000");
			MeleeArmourData.add(temp78);
			HashMap<String, String> temp66 = new HashMap<String, String>();
			temp66.put("Item", "(250M) God Armour Set");
			temp66.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp66);
			HashMap<String, String> temp50 = new HashMap<String, String>();
			temp50.put("Item", "(50M) Helmet of the Gods");
			temp50.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp50);
			HashMap<String, String> temp51 = new HashMap<String, String>();
			temp51.put("Item", "(75M) Chestplate of the Gods");
			temp51.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp51);
			HashMap<String, String> temp234 = new HashMap<String, String>();
			temp234.put("Item", "(70M) Gauntlets of the Gods");
			temp234.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp234);
			HashMap<String, String> temp52 = new HashMap<String, String>();
			temp52.put("Item", "(65M) Platelegs of the Gods");
			temp52.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp52);
			HashMap<String, String> temp53 = new HashMap<String, String>();
			temp53.put("Item", "(50M) Boots of the Gods");
			temp53.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp53);
			HashMap<String, String> temp79 = new HashMap<String, String>();
			temp79.put("Item", "(55M) Shield of the Gods");
			temp79.put("Requirements", "Req. Level: 10,000");
			MeleeArmourData.add(temp79);
		}

		/*-------------------------------------------------------------------------------*
		 **************************** Melee Armour List Adapter***************************
		 *-------------------------------------------------------------------------------*/

		SimpleAdapter MeleeArmourAdapter = new SimpleAdapter(getActivity(), MeleeArmourData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		MeleeArmourList.setAdapter(MeleeArmourAdapter);

		/*-------------------------------------------------------------------------------*
		 **************************** Melee Armour List Handler **************************
		 *-------------------------------------------------------------------------------*/

		MeleeArmourList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				final TextView textViewShopGoldValue1 = (TextView) getActivity().findViewById(R.id.shopGoldValue1);
				final DBAdapter db = new DBAdapter(getActivity());
				final DBAdapter_Gold dbGold = new DBAdapter_Gold(getActivity());
				TextView itemText = (TextView) arg1.findViewById(R.id.text1);
				String title = itemText.getText().toString();
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

				switch (arg2) {

				case 1:
					dlgAlert.setMessage(itemInfo.BronzeArmourSet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 725) {

								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 725;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Bronze Armour Set added to inventory \n" + "-Bronze Helmet \n"
										+ "-Bronze Chestplate\n" + "-Bronze Gauntlets\n" + "-Bronze Platelegs \n" + "-Bronze Boots\n"
										+ "-Bronze Shield", Toast.LENGTH_SHORT);
								msg.show();

								db.open();
								db.insertRecord("Bronze Helmet");
								db.insertRecord("Bronze Chestplate");
								db.insertRecord("Bronze Gauntlets");
								db.insertRecord("Bronze Platelegs");
								db.insertRecord("Bronze Boots");
								db.insertRecord("Bronze Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 2:
					dlgAlert.setMessage(itemInfo.BronzeHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 100) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 3:

					dlgAlert.setMessage(itemInfo.BronzeChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 4:

					dlgAlert.setMessage(itemInfo.BronzeGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 150) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 150;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 5:

					dlgAlert.setMessage(itemInfo.BronzePlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 125) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 125;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 6:

					dlgAlert.setMessage(itemInfo.BronzeBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 100) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 7:

					dlgAlert.setMessage(itemInfo.BronzeShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 150) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 150;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 8:

					dlgAlert.setMessage(itemInfo.IronArmourSet(info));
					dlgAlert.setTitle("(1,525G) Iron Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1525) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1525;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Armour Set added to inventory \n" + "-Iron Helmet \n"
										+ "-Iron Chestplate\n" + "-Iron Gauntlets\n" + "-Iron Platelegs\n" + "-Iron Boots\n" + "-Iron Shield",
										Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Helmet");
								db.insertRecord("Iron Chestplate");
								db.insertRecord("Iron Gauntlets");
								db.insertRecord("Iron Platelegs");
								db.insertRecord("Iron Boots");
								db.insertRecord("Iron Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 9:

					dlgAlert.setMessage(itemInfo.IronHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 10:

					dlgAlert.setMessage(itemInfo.IronChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 450) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 450;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 11:

					dlgAlert.setMessage(itemInfo.IronGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 325) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 325;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 12:

					dlgAlert.setMessage(itemInfo.IronPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 275) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 275;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 13:

					dlgAlert.setMessage(itemInfo.IronBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 14:

					dlgAlert.setMessage(itemInfo.IronShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 300) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 300;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 15:

					dlgAlert.setMessage(itemInfo.SteelArmourSet(info));
					dlgAlert.setTitle("(3,075G) Steel Armour Set");
					dlgAlert.setPositiveButton("Buy (3075G)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 3075) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 3075;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Steel Armour Set added to inventory \n" + "-Steel Helmet\n"
										+ "-Steel Chestplate\n" + "-Steel Gauntlets\n" + "-Steel Platelegs\n" + "-Steel Boots\n" + "-Steel Shield",
										Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Helmet");
								db.insertRecord("Steel Chestplate");
								db.insertRecord("Steel Gauntlets");
								db.insertRecord("Steel Platelegs");
								db.insertRecord("Steel Boots");
								db.insertRecord("Steel Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 16:

					dlgAlert.setMessage(itemInfo.SteelHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 600) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 600;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 17:

					dlgAlert.setMessage(itemInfo.SteelChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 750) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 750;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 18:

					dlgAlert.setMessage(itemInfo.SteelGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 675) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 675;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 19:

					dlgAlert.setMessage(itemInfo.SteelPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 575) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 575;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 20:

					dlgAlert.setMessage(itemInfo.SteelBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 550) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 550;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 21:

					dlgAlert.setMessage(itemInfo.SteelShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 600) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 600;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 22:

					dlgAlert.setMessage(itemInfo.DwarvenArmourSet(info));
					dlgAlert.setTitle("(6.8K) Dwarven Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6800) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6800;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Dwarven Armour Set add to inventory \n" + "-Dwarven Helmet\n"
										+ "-Dwarven Chestplate\n" + "-Dwarven Gauntlets\n" + "-Dwarven Platelegs\n" + "-Dwarven Boots\n"
										+ "-Dwarven Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Helmet");
								db.insertRecord("Dwarven Chestplate");
								db.insertRecord("Dwarven Gauntlets");
								db.insertRecord("Dwarven Platelegs");
								db.insertRecord("Dwarven Boots");
								db.insertRecord("Dwarven Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 23:

					dlgAlert.setMessage(itemInfo.DwarvenHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 24:

					dlgAlert.setMessage(itemInfo.DwarvenChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1750) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1750;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 25:

					dlgAlert.setMessage(itemInfo.DwarvenGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1600) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1600;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 26:

					dlgAlert.setMessage(itemInfo.DwarvenPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1300) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1300;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 27:

					dlgAlert.setMessage(itemInfo.DwarvenBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 28:

					dlgAlert.setMessage(itemInfo.DwarvenShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 29:

					dlgAlert.setMessage(itemInfo.ElvenArmourSet(info));
					dlgAlert.setTitle("(29.2K) Elven Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 29200) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 29200;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Elven Armour Set added to inventory \n" + "-Elven Helmet\n"
										+ "-Elven Chestplate\n" + "-Elven Gauntlets\n" + "-Elven Platelegs\n" + "-Elven Boots\n" + "-Elven Shield",
										Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Helmet");
								db.insertRecord("Elven Chestplate");
								db.insertRecord("Elven Gauntlets");
								db.insertRecord("Elven Platelegs");
								db.insertRecord("Elven Boots");
								db.insertRecord("Elven Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 30:

					dlgAlert.setMessage(itemInfo.ElvenHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 5000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 5000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 31:

					dlgAlert.setMessage(itemInfo.ElvenChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 7500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 7500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 32:

					dlgAlert.setMessage(itemInfo.ElvenGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6300) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6300;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 33:

					dlgAlert.setMessage(itemInfo.ElvenPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 34:

					dlgAlert.setMessage(itemInfo.ElvenBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 5500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 5500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 35:

					dlgAlert.setMessage(itemInfo.ElvenShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 5200) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 5200;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 36:

					dlgAlert.setMessage(itemInfo.OrcishArmourSet(info));
					dlgAlert.setTitle("(55.5K) Orcish Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 55500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 55500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Orcish Armour Set added to inventory \n" + "-Orcish Helmet\n"
										+ "-Orcish Chestplate\n" + "-Orcish Gauntlets\n" + "-Orcish Platelegs\n" + "-Orcish Boots\n"
										+ "-Orcish Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Helmet");
								db.insertRecord("Orcish Chestplate");
								db.insertRecord("Orcish Gauntlets");
								db.insertRecord("Orcish Platelegs");
								db.insertRecord("Orcish Boots");
								db.insertRecord("Orcish Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 37:

					dlgAlert.setMessage(itemInfo.OrcishHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 10000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 10000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 38:

					dlgAlert.setMessage(itemInfo.OrcishChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 12000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 12000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 39:

					dlgAlert.setMessage(itemInfo.OrcishGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 11000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 11000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 40:

					dlgAlert.setMessage(itemInfo.OrcishPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 11500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 11500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 41:

					dlgAlert.setMessage(itemInfo.OrcishBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 10000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 10000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 42:

					dlgAlert.setMessage(itemInfo.OrcishShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 12000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 12000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 43:

					dlgAlert.setMessage(itemInfo.RunicArmourSet(info));
					dlgAlert.setTitle("(106K) Runic Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 106000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 106000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Armour Set added to inventory \n" + "-Runic Helmet\n"
										+ "-Runic Chestplate\n" + "-Runic Gauntlets\n" + "-Runic Platelegs\n" + "-Runic Boots\n" + "-Runic Shield",
										Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Helmet");
								db.insertRecord("Runic Chestplate");
								db.insertRecord("Runic Gauntlets");
								db.insertRecord("Runic Platelegs");
								db.insertRecord("Runic Boots");
								db.insertRecord("Runic Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 44:

					dlgAlert.setMessage(itemInfo.RunicHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 20000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 20000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 45:

					dlgAlert.setMessage(itemInfo.RunicChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 22500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 22500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 46:

					dlgAlert.setMessage(itemInfo.RunicGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 21500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 21500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 47:

					dlgAlert.setMessage(itemInfo.RunicPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 21000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 21000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 48:

					dlgAlert.setMessage(itemInfo.RunicBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 20000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 20000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 49:

					dlgAlert.setMessage("Type: Melee \n" + "Defense: +171 \n" + "Life Bonus: +175 \n" + "Wield: Secondary Hand");
					dlgAlert.setTitle("Runic Shield");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 22500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 22500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 50:

					dlgAlert.setMessage(itemInfo.GuardianArmourSet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy (260K)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 260000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 260000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Guardian Armour Set added to inventory\n" + "-Guardian Chestplate\n"
										+ "-Guardian Gauntlets\n" + "-Guardian Platelegs\n" + "-Guardian Boots\n" + "-Guardian Shield",
										Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Helmet");
								db.insertRecord("Guardian Chestplate");
								db.insertRecord("Guardian Gauntlets");
								db.insertRecord("Guardian Platelegs");
								db.insertRecord("Guardian Boots");
								db.insertRecord("Guardian Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 51:

					dlgAlert.setMessage(itemInfo.GuardianHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 50000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 52:

					dlgAlert.setMessage(itemInfo.GuardianChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 55000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 55000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 53:

					dlgAlert.setMessage(itemInfo.GuardianGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 53000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 53000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 54:

					dlgAlert.setMessage(itemInfo.GuardianPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 52500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 52500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 55:

					dlgAlert.setMessage(itemInfo.GuardianBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 50000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 56:

					dlgAlert.setMessage(itemInfo.GuardianShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 52500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 52500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 57:

					dlgAlert.setMessage(itemInfo.AncientArmourSet(info));
					dlgAlert.setTitle("(484.25K) Ancient Armour Set");
					dlgAlert.setPositiveButton("Buy (484,250G)", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 484250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 484250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Armour Set added to inventory \n" + "-Ancient Helmet \n"
										+ "-Ancient Chestplate\n" + "-Ancient Gauntlets\n" + "-Ancient Platelegs\n" + "-Ancient Boots\n"
										+ "-Ancient Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Helmet");
								db.insertRecord("Ancient Chestplate");
								db.insertRecord("Ancient Gauntlets");
								db.insertRecord("Ancient Platelegs");
								db.insertRecord("Ancient Boots");
								db.insertRecord("Ancient Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 58:

					dlgAlert.setMessage(itemInfo.AncientHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 95000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 95000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 59:

					dlgAlert.setMessage(itemInfo.AncientChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 100000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 60:

					dlgAlert.setMessage(itemInfo.AncientGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 98000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 98000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 61:

					dlgAlert.setMessage(itemInfo.AncientPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 97000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 97000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 62:

					dlgAlert.setMessage(itemInfo.AncientBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 95000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 95000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 63:

					dlgAlert.setMessage(itemInfo.AncientShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 97250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 97250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 64:

					dlgAlert.setMessage(itemInfo.DragonArmourSet(info));
					dlgAlert.setTitle("(1,595K) Dragon Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1595000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1595000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Armour Set added to inventory\n" + "-Dragon Helmet\n"
										+ "-Dragon Chestplate\n" + "-Dragon Gauntlets\n" + "-Dragon Platelegs\n" + "-Dragon Boots\n"
										+ "-Dragon Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Helmet");
								db.insertRecord("Dragon Chestplate");
								db.insertRecord("Dragon Gauntlets");
								db.insertRecord("Dragon Platelegs");
								db.insertRecord("Dragon Boots");
								db.insertRecord("Dragon Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 65:

					dlgAlert.setMessage(itemInfo.DragonHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 300000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 300000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 66:

					dlgAlert.setMessage(itemInfo.DragonChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 350000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 350000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 67:

					dlgAlert.setMessage(itemInfo.DragonGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 325000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 325000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 68:

					dlgAlert.setMessage(itemInfo.DragonPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 320000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 320000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 69:

					dlgAlert.setMessage(itemInfo.DragonBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 300000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 300000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 70:

					dlgAlert.setMessage(itemInfo.DragonShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 325000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 325000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 72:

					dlgAlert.setMessage(itemInfo.ForlornArmourSet(info));
					dlgAlert.setTitle("(7.5M) Forlorn Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 7500000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 7500000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Forlorn Armour Set added to inventory \n" + "-Forlorn Helmet\n"
										+ "-Forlorn Chestplate\n" + "-Forlorn Gauntlets\n" + "-Forlorn Platelegs\n" + "-Forlorn Boots\n"
										+ "-Forlorn Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Helmet");
								db.insertRecord("Forlorn Chestplate");
								db.insertRecord("Forlorn Gauntlets");
								db.insertRecord("Forlorn Platelegs");
								db.insertRecord("Forlorn Boots");
								db.insertRecord("Forlorn Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 73:

					dlgAlert.setMessage(itemInfo.ForlornHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 74:

					dlgAlert.setMessage(itemInfo.ForlornChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 2500000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 2500000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 75:

					dlgAlert.setMessage(itemInfo.ForlornGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 2000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 2000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 76:

					dlgAlert.setMessage(itemInfo.ForlornPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1700000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1700000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 77:

					dlgAlert.setMessage(itemInfo.ForlornBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 900000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 900000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 78:

					dlgAlert.setMessage(itemInfo.ForlornShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1500000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1500000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Forlorn Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 79:

					dlgAlert.setMessage(itemInfo.LegendaryArmourSet(info));
					dlgAlert.setTitle("(79M) Legendary Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 79000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 79000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "-Legendary Armour Set added to inventory \n" + "-Legendary Helmet\n"
										+ "-Legendary Chestplate\n" + "-Legendary Gauntlets\n" + "-Legendary Platelegs\n" + "-Legendary Boots\n"
										+ "-Legendary Shield", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Helmet");
								db.insertRecord("Legendary Chestplate");
								db.insertRecord("Legendary Gauntlets");
								db.insertRecord("Legendary Platelegs");
								db.insertRecord("Legendary Boots");
								db.insertRecord("Legendary Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 80:

					dlgAlert.setMessage(itemInfo.LegendaryHelmet(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 15000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 15000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Helmet added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Helmet");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 81:

					dlgAlert.setMessage(itemInfo.LegendaryChestplate(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 18000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 18000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Chestplate added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Chestplate");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 82:

					dlgAlert.setMessage(itemInfo.LegendaryGauntlets(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 17000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 17000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Gauntlets added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Gauntlets");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 83:

					dlgAlert.setMessage(itemInfo.LegendaryPlatelegs(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 16500000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 16500000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Platelegs added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Platelegs");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 84:

					dlgAlert.setMessage(itemInfo.LegendaryBoots(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 14000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 14000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Boots added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Boots");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 85:

					dlgAlert.setMessage(itemInfo.LegendaryShield(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 15500000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 15500000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Legendary Shield added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Shield");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 86:

					dlgAlert.setMessage(itemInfo.GodArmourSet(info));
					dlgAlert.setTitle("(250M) God Armour Set");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "God Armour Set added to inventory\n" + "-Helmet of the Gods\n"
										+ "-Chestplate of the Gods\n" + "-Gauntlets of the Gods\n" + "-Platelegs of the Gods\n"
										+ "-Boots of the Gods\n" + "-Shield of the Gods\n", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Helmet of the Gods");
								db.insertRecord("Chestplate of the Gods");
								db.insertRecord("Gauntlets of the Gods");
								db.insertRecord("Platelegs of the Gods");
								db.insertRecord("Boots of the Gods");
								db.insertRecord("Shield of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 87:

					dlgAlert.setMessage(itemInfo.HelmetOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 50000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Helmet of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Helmet of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 88:

					dlgAlert.setMessage(itemInfo.ChestplateOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 75000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 75000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Chestplate of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Chestplate of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 89:

					dlgAlert.setMessage(itemInfo.GauntletsOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 70000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 70000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Gauntlets of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Gauntlets of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 90:

					dlgAlert.setMessage(itemInfo.PlatelegsOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 65000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 65000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Platelegs of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Platelegs of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 91:

					dlgAlert.setMessage(itemInfo.BootsOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 50000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Boots of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Boots of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				case 92:

					dlgAlert.setMessage(itemInfo.ShieldOfTheGods(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 55000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 55000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Shield of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Shield of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
								dbGold.close();

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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					break;
				}
				dbGold.open();
				dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
				dbGold.close();
			}
		});

		/*-------------------------------------------------------------------------------*
		 *************************** Melee Weapons List Procedure*************************
		 *-------------------------------------------------------------------------------*/

		String MeleeWeapons;
		List<HashMap<String, String>> MeleeWeaponsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> t11 = new HashMap<String, String>();
			t11.put("Item", "--- Melee Weapons ---");
			t11.put("Requirements", "Class: Bard, Cleric, Paladin, Rouge, Warrior");
			MeleeWeaponsData.add(t11);
			HashMap<String, String> temp54 = new HashMap<String, String>();
			temp54.put("Item", "(100G) Bronze Dagger");
			temp54.put("Requirements", "Req. Level: 10");
			MeleeWeaponsData.add(temp54);
			HashMap<String, String> temp111 = new HashMap<String, String>();
			temp111.put("Item", "(250G) Bronze Sword");
			temp111.put("Requirements", "Req. Level: 10");
			MeleeWeaponsData.add(temp111);
			HashMap<String, String> temp21 = new HashMap<String, String>();
			temp21.put("Item", "(150G) Bronze Axe");
			temp21.put("Requirements", "Req. Level: 10");
			MeleeWeaponsData.add(temp21);
			HashMap<String, String> temp31 = new HashMap<String, String>();
			temp31.put("Item", "(150G) Bronze Mace");
			temp31.put("Requirements", "Req. Level: 10");
			MeleeWeaponsData.add(temp31);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(300G) Bronze Greatsword");
			temp4.put("Requirements", "Req. Level: 10");
			MeleeWeaponsData.add(temp4);
			HashMap<String, String> temp67 = new HashMap<String, String>();
			temp67.put("Item", "(250G) Iron Dagger");
			temp67.put("Requirements", "Req. Level: 25");
			MeleeWeaponsData.add(temp67);
			HashMap<String, String> temp55 = new HashMap<String, String>();
			temp55.put("Item", "(400G) Iron Sword");
			temp55.put("Requirements", "Req. Level: 25");
			MeleeWeaponsData.add(temp55);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(350G) Iron Axe");
			temp5.put("Requirements", "Req. Level: 25");
			MeleeWeaponsData.add(temp5);
			HashMap<String, String> temp6 = new HashMap<String, String>();
			temp6.put("Item", "(350G) Iron Mace");
			temp6.put("Requirements", "Req. Level: 25");
			MeleeWeaponsData.add(temp6);
			HashMap<String, String> temp7 = new HashMap<String, String>();
			temp7.put("Item", "(650G) Iron Greatsword");
			temp7.put("Requirements", "Req. Level: 25");
			MeleeWeaponsData.add(temp7);
			HashMap<String, String> temp8 = new HashMap<String, String>();
			temp8.put("Item", "(400G) Steel Dagger");
			temp8.put("Requirements", "Req. Level: 45");
			MeleeWeaponsData.add(temp8);
			HashMap<String, String> temp68 = new HashMap<String, String>();
			temp68.put("Item", "(550G) Steel Sword");
			temp68.put("Requirements", "Req. Level: 45");
			MeleeWeaponsData.add(temp68);
			HashMap<String, String> temp56 = new HashMap<String, String>();
			temp56.put("Item", "(450G) Steel Axe");
			temp56.put("Requirements", "Req. Level: 45");
			MeleeWeaponsData.add(temp56);
			HashMap<String, String> temp9 = new HashMap<String, String>();
			temp9.put("Item", "(450G) Steel Mace");
			temp9.put("Requirements", "Req. Level: 45");
			MeleeWeaponsData.add(temp9);
			HashMap<String, String> temp10 = new HashMap<String, String>();
			temp10.put("Item", "(550G) Steel Greatsword");
			temp10.put("Requirements", "Req. Level: 45");
			MeleeWeaponsData.add(temp10);
			HashMap<String, String> temp1111 = new HashMap<String, String>();
			temp1111.put("Item", "(1K) Dwarven Dagger");
			temp1111.put("Requirements", "Req. Level: 75");
			MeleeWeaponsData.add(temp1111);
			HashMap<String, String> temp12 = new HashMap<String, String>();
			temp12.put("Item", "(2.5K) Dwarven Sword");
			temp12.put("Requirements", "Req. Level: 75");
			MeleeWeaponsData.add(temp12);
			HashMap<String, String> temp69 = new HashMap<String, String>();
			temp69.put("Item", "(2K) Dwarven War Axe");
			temp69.put("Requirements", "Req. Level: 75");
			MeleeWeaponsData.add(temp69);
			HashMap<String, String> temp57 = new HashMap<String, String>();
			temp57.put("Item", "(2K) Dwarven Mace");
			temp57.put("Requirements", "Req. Level: 75");
			MeleeWeaponsData.add(temp57);
			HashMap<String, String> temp13 = new HashMap<String, String>();
			temp13.put("Item", "(3K) Dwarven Greatsword");
			temp13.put("Requirements", "Req. Level: 75");
			MeleeWeaponsData.add(temp13);
			HashMap<String, String> temp14 = new HashMap<String, String>();
			temp14.put("Item", "(5K) Elven Dagger");
			temp14.put("Requirements", "Req. Level: 100");
			MeleeWeaponsData.add(temp14);
			HashMap<String, String> temp15 = new HashMap<String, String>();
			temp15.put("Item", "(6.5K) Elven Sword");
			temp15.put("Requirements", "Req. Level: 100");
			MeleeWeaponsData.add(temp15);
			HashMap<String, String> temp16 = new HashMap<String, String>();
			temp16.put("Item", "(6K) Elven Axe");
			temp16.put("Requirements", "Req. Level: 100");
			MeleeWeaponsData.add(temp16);
			HashMap<String, String> temp70 = new HashMap<String, String>();
			temp70.put("Item", "(6K) Elven Mace");
			temp70.put("Requirements", "Req. Level: 100");
			MeleeWeaponsData.add(temp70);
			HashMap<String, String> temp58 = new HashMap<String, String>();
			temp58.put("Item", "(7K) Elven Greatsword");
			temp58.put("Requirements", "Req. Level: 100");
			MeleeWeaponsData.add(temp58);
			HashMap<String, String> temp17 = new HashMap<String, String>();
			temp17.put("Item", "(10K) Orcish Dagger");
			temp17.put("Requirements", "Req. Level: 125");
			MeleeWeaponsData.add(temp17);
			HashMap<String, String> temp18 = new HashMap<String, String>();
			temp18.put("Item", "(12.5K) Orcish Sword");
			temp18.put("Requirements", "Req. Level: 125");
			MeleeWeaponsData.add(temp18);
			HashMap<String, String> temp19 = new HashMap<String, String>();
			temp19.put("Item", "(12K) Orcish Axe");
			temp19.put("Requirements", "Req. Level: 125");
			MeleeWeaponsData.add(temp19);
			HashMap<String, String> temp20 = new HashMap<String, String>();
			temp20.put("Item", "(12K) Orcish Mace");
			temp20.put("Requirements", "Req. Level: 125");
			MeleeWeaponsData.add(temp20);
			HashMap<String, String> temp71 = new HashMap<String, String>();
			temp71.put("Item", "(15K) Orcish Greatsword");
			temp71.put("Requirements", "Req. Level: 125");
			MeleeWeaponsData.add(temp71);
			HashMap<String, String> temp59 = new HashMap<String, String>();
			temp59.put("Item", "(20K) Runic Dagger");
			temp59.put("Requirements", "Req. Level: 175");
			MeleeWeaponsData.add(temp59);
			HashMap<String, String> temp211 = new HashMap<String, String>();
			temp211.put("Item", "(22.5K) Runic Sword");
			temp211.put("Requirements", "Req. Level: 175");
			MeleeWeaponsData.add(temp211);
			HashMap<String, String> temp22 = new HashMap<String, String>();
			temp22.put("Item", "(22K) Runic Axe");
			temp22.put("Requirements", "Req. Level: 175");
			MeleeWeaponsData.add(temp22);
			HashMap<String, String> temp23 = new HashMap<String, String>();
			temp23.put("Item", "(22K) Runic Mace");
			temp23.put("Requirements", "Req. Level: 175");
			MeleeWeaponsData.add(temp23);
			HashMap<String, String> temp24 = new HashMap<String, String>();
			temp24.put("Item", "(25K) Runic Greatsword");
			temp24.put("Requirements", "Req. Level: 175");
			MeleeWeaponsData.add(temp24);
			HashMap<String, String> temp72 = new HashMap<String, String>();
			temp72.put("Item", "(50K) Guardian Dagger");
			temp72.put("Requirements", "Req. Level: 250");
			MeleeWeaponsData.add(temp72);
			HashMap<String, String> temp60 = new HashMap<String, String>();
			temp60.put("Item", "(52.5K) Guardian Sword");
			temp60.put("Requirements", "Req. Level: 250");
			MeleeWeaponsData.add(temp60);
			HashMap<String, String> temp25 = new HashMap<String, String>();
			temp25.put("Item", "(52K) Guardian Axe");
			temp25.put("Requirements", "Req. Level: 250");
			MeleeWeaponsData.add(temp25);
			HashMap<String, String> temp26 = new HashMap<String, String>();
			temp26.put("Item", "(52K) Guardian Mace");
			temp26.put("Requirements", "Req. Level: 250");
			MeleeWeaponsData.add(temp26);
			HashMap<String, String> temp27 = new HashMap<String, String>();
			temp27.put("Item", "(55K) Guardian Greatsword");
			temp27.put("Requirements", "Req. Level: 250");
			MeleeWeaponsData.add(temp27);
			HashMap<String, String> temp28 = new HashMap<String, String>();
			temp28.put("Item", "(100K) Ancient Dagger");
			temp28.put("Requirements", "Req. Level: 375");
			MeleeWeaponsData.add(temp28);
			HashMap<String, String> temp73 = new HashMap<String, String>();
			temp73.put("Item", "(105K) Ancient Sword");
			temp73.put("Requirements", "Req. Level: 375");
			MeleeWeaponsData.add(temp73);
			HashMap<String, String> temp61 = new HashMap<String, String>();
			temp61.put("Item", "(102.5K) Ancient Axe");
			temp61.put("Requirements", "Req. Level: 375");
			MeleeWeaponsData.add(temp61);
			HashMap<String, String> temp29 = new HashMap<String, String>();
			temp29.put("Item", "(102.5K) Ancient Mace");
			temp29.put("Requirements", "Req. Level: 375");
			MeleeWeaponsData.add(temp29);
			HashMap<String, String> temp30 = new HashMap<String, String>();
			temp30.put("Item", "(120K) Ancient Greatsword");
			temp30.put("Requirements", "Req. Level: 375");
			MeleeWeaponsData.add(temp30);
			HashMap<String, String> temp311 = new HashMap<String, String>();
			temp311.put("Item", "(300K) Dragon Dagger");
			temp311.put("Requirements", "Req. Level: 500");
			MeleeWeaponsData.add(temp311);
			HashMap<String, String> temp32 = new HashMap<String, String>();
			temp32.put("Item", "(305K) Dragon Sword");
			temp32.put("Requirements", "Req. Level: 500");
			MeleeWeaponsData.add(temp32);
			HashMap<String, String> temp74 = new HashMap<String, String>();
			temp74.put("Item", "(302.5K) Dragon Axe");
			temp74.put("Requirements", "Req. Level: 500");
			MeleeWeaponsData.add(temp74);
			HashMap<String, String> temp62 = new HashMap<String, String>();
			temp62.put("Item", "(302.5K) Dragon Mace");
			temp62.put("Requirements", "Req. Level: 500");
			MeleeWeaponsData.add(temp62);
			HashMap<String, String> temp33 = new HashMap<String, String>();
			temp33.put("Item", "(320K) Dragon Greatsword");
			temp33.put("Requirements", "Req. Level: 500");
			MeleeWeaponsData.add(temp33);
			HashMap<String, String> temp34 = new HashMap<String, String>();
			temp34.put("Item", "-~- Specialty Melee Weapons -~-");
			MeleeWeaponsData.add(temp34);
			HashMap<String, String> temp35 = new HashMap<String, String>();
			temp35.put("Item", "(1M) Forlorn Hope");
			temp35.put("Requirements", "Req. Level: 1,000");
			MeleeWeaponsData.add(temp35);
			HashMap<String, String> temp36 = new HashMap<String, String>();
			temp36.put("Item", "(25M) Legendary Blade");
			temp36.put("Requirements", "Req. Level: 5,000");
			MeleeWeaponsData.add(temp36);
			HashMap<String, String> temp75 = new HashMap<String, String>();
			temp75.put("Item", "(50M) Sword of the Gods");
			temp75.put("Requirements", "Req. Level: 10,000");
			MeleeWeaponsData.add(temp75);
		}

		/*-------------------------------------------------------------------------------*
		 **************************** Melee Weapons List Adapter **************************
		 *-------------------------------------------------------------------------------*/

		SimpleAdapter MeleeWeaponsAdapter = new SimpleAdapter(getActivity(), MeleeWeaponsData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		MeleeWeaponsList.setAdapter(MeleeWeaponsAdapter);

		/*-------------------------------------------------------------------------------*
		 **************************** Melee Weapons List Handler *************************
		 *-------------------------------------------------------------------------------*/

		MeleeWeaponsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				TextView itemText = (TextView) v.findViewById(R.id.text1);
				String title = itemText.getText().toString();
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

				switch (position) {
				case 1:
					dlgAlert.setMessage(itemInfo.BronzeDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 100) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 2:

					dlgAlert.setMessage(itemInfo.BronzeSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 3:

					dlgAlert.setMessage(itemInfo.BronzeAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 150) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 150;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 4:

					dlgAlert.setMessage(itemInfo.BronzeMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 150) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 150;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 5:

					dlgAlert.setMessage(itemInfo.BronzeGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 300) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 300;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Bronze Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Bronze Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 6:

					dlgAlert.setMessage(itemInfo.IronDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 7:

					dlgAlert.setMessage(itemInfo.IronSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 400) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 400;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 8:

					dlgAlert.setMessage(itemInfo.IronAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 350) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 350;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 9:

					dlgAlert.setMessage(itemInfo.IronMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 350) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 350;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 10:

					dlgAlert.setMessage(itemInfo.IronGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 650) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 650;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Iron Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Iron Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 11:

					dlgAlert.setMessage(itemInfo.SteelDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 400) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 400;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 12:

					dlgAlert.setMessage(itemInfo.SteelSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 550) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 550;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 13:

					dlgAlert.setMessage(itemInfo.SteelAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 450) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 450;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 14:

					dlgAlert.setMessage(itemInfo.SteelMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 450) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 450;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 15:

					dlgAlert.setMessage(itemInfo.SteelGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 550) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 550;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Steel Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Steel Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 16:

					dlgAlert.setMessage(itemInfo.DwarvenDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 17:

					dlgAlert.setMessage(itemInfo.DwarvenSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 2500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 2500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 18:

					dlgAlert.setMessage(itemInfo.DwarvenWarAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 2000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 2000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven War Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven War Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 19:

					dlgAlert.setMessage(itemInfo.DwarvenMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 2000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 2000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 20:

					dlgAlert.setMessage(itemInfo.DwarvenGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 3000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 3000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dwarven Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dwarven Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 21:

					dlgAlert.setMessage(itemInfo.ElvenDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 5000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 5000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 22:

					dlgAlert.setMessage(itemInfo.ElvenSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 23:

					dlgAlert.setMessage(itemInfo.ElvenAxe(info));
					dlgAlert.setTitle("Elven Axe");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 24:

					dlgAlert.setMessage(itemInfo.ElvenMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 6000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 6000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 25:

					dlgAlert.setMessage(itemInfo.ElvenGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 7000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 7000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Elven Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Elven Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 26:

					dlgAlert.setMessage(itemInfo.OrcishDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 10000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 10000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 27:

					dlgAlert.setMessage(itemInfo.OrcishSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 12500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 12500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 28:

					dlgAlert.setMessage(itemInfo.OrcishAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 12000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 12000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 29:

					dlgAlert.setMessage(itemInfo.OrcishMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 12000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 12000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 30:

					dlgAlert.setMessage(itemInfo.OrcishGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 15000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 15000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Orcish Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Orcish Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 31:

					dlgAlert.setMessage(itemInfo.RunicDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 20000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 20000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 32:

					dlgAlert.setMessage(itemInfo.RunicSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 22500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 22500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 33:

					dlgAlert.setMessage(itemInfo.RunicAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 22500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 22500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 34:

					dlgAlert.setMessage(itemInfo.RunicMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 22000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 22000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 35:

					dlgAlert.setMessage(itemInfo.RunicGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 25000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 25000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Runic Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Runic Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 36:

					dlgAlert.setMessage(itemInfo.GuardianDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 50000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 37:

					dlgAlert.setMessage(itemInfo.GuardianSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 52500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 52500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 38:

					dlgAlert.setMessage(itemInfo.GuardianAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 52000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 52000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 39:

					dlgAlert.setMessage(itemInfo.GuardianMace(info));
					dlgAlert.setTitle("Guardian Mace");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 52000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 52000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 40:

					dlgAlert.setMessage(itemInfo.GuardianGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 55000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 55000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Guardian Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Guardian Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 41:

					dlgAlert.setMessage(itemInfo.AncientDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 100000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 42:

					dlgAlert.setMessage(itemInfo.AncientSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 105000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 105000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 43:

					dlgAlert.setMessage(itemInfo.AncientAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 102500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 102500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 44:

					dlgAlert.setMessage(itemInfo.AncientMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 102500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 102500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 45:

					dlgAlert.setMessage(itemInfo.AncientGreatsword(info));
					dlgAlert.setTitle("Ancient Greatsword");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 120000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 120000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Ancient Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Ancient Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 46:

					dlgAlert.setMessage(itemInfo.DragonDagger(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 300000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 300000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Dagger added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Dagger");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 47:

					dlgAlert.setMessage(itemInfo.DragonSword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 305000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 305000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Sword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Sword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 48:

					dlgAlert.setMessage(itemInfo.DragonAxe(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 302500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 302500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Axe added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Axe");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 49:

					dlgAlert.setMessage(itemInfo.DragonMace(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 302500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 302500;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Mace added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Mace");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 50:

					dlgAlert.setMessage(itemInfo.DragonGreatsword(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 320000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 320000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));

								Toast msg = Toast.makeText(getActivity(), "Dragon Greatsword added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Dragon Greatsword");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 52:

					dlgAlert.setMessage(itemInfo.ForlornHope(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 1000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 1000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Forlorn Hope added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Forlorn Hope");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 53:

					dlgAlert.setMessage(itemInfo.LegendaryBlade(info));
					dlgAlert.setTitle(title);
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 15000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 15000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Legendary Blade added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Legendary Blade");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				case 54:

					dlgAlert.setMessage(itemInfo.SwordOfTheGods(info));
					dlgAlert.setTitle("Sword of the Gods");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) > 55000000) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 55000000;
								textViewShopGoldValue1.setText(String.valueOf(gold1));
								Toast msg = Toast.makeText(getActivity(), "Sword of the Gods added to inventory", Toast.LENGTH_SHORT);
								msg.show();
								db.open();
								db.insertRecord("Sword of the Gods");
								db.close();
								dbGold.open();
								dbGold.insertRecord(textViewShopGoldValue1.getText().toString());
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
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();

					break;
				}
			}
		});
		return rootView;
	}

	private void meleeListCheck(final RadioButton rdoMeleeArmour, final RadioButton rdoMeleeWeapons, final ListView MeleeArmourList,
			final ListView MeleeWeaponsList) {

		rdoMeleeArmour.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoMeleeArmour.isChecked() == true) {
					rdoMeleeWeapons.setChecked(false);

					MeleeArmourList.setVisibility(View.VISIBLE);
					MeleeWeaponsList.setVisibility(View.INVISIBLE);
				}
			}
		});

		rdoMeleeWeapons.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoMeleeWeapons.isChecked() == true) {
					rdoMeleeArmour.setChecked(false);

					MeleeArmourList.setVisibility(View.INVISIBLE);
					MeleeWeaponsList.setVisibility(View.VISIBLE);
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
			this.getActivity().finish();
			return true;
		case R.id.Equipment:
			Intent Shop = new Intent(this.getActivity(), Equipment.class);
			this.startActivity(Shop);
			this.getActivity().finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}