package com.Logik.dawn.of.ages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Databases.DBAdapter;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopSell extends ListActivity {
	
	DBAdapter db = new DBAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_sell);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
		
		TextView textView1 = (TextView) findViewById(R.id.textQuest);
		Typeface type = Typeface.createFromAsset(getAssets(),"vineritc.ttf"); 
		textView1.setTypeface(type);

		try {
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/InventoryDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("InventoryDB"),
						new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBAdapter db = new DBAdapter(this);

		try {
			db.open();
			Cursor c = DBAdapter.getAllRecords();
			if (c.moveToFirst()) {
				do {
					DisplayRecord(c);
				} while (c.moveToNext());
			}
			db.close();
		} catch (Exception e) {
			Log.e("ERROR", "ERROR IN CODE:" + e.toString());
			e.printStackTrace();
		}
	}

	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

	@SuppressWarnings("deprecation")
	public void DisplayRecord(Cursor c) {
		final Cursor c1 = DBAdapter.getAllRecords();
		startManagingCursor(c1);

		String[] from = new String[] { DBAdapter.KEY_ITEM };
		int[] to = new int[] { R.id.text1 };

		SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.row,
				c1, from, to);
		setListAdapter(notes);
	}

	@Override
	public void onListItemClick(ListView l, View view, int position, long id) {
		TextView tv = (TextView) view.findViewById(R.id.text1);
		switch (position) {
		case 0:
			CompareItems(l, view, position, id);
			break;
		case 1:
			CompareItems(l, view, position, id);
			break;
		case 2:
			CompareItems(l, view, position, id);
			break;
		case 3:
			CompareItems(l, view, position, id);
			break;
		case 4:
			CompareItems(l, view, position, id);
			break;
		case 5:
			CompareItems(l, view, position, id);
			break;
		case 6:
			CompareItems(l, view, position, id);
			break;
		case 7:
			CompareItems(l, view, position, id);
			break;
		case 8:
			CompareItems(l, view, position, id);
			break;
		case 9:
			CompareItems(l, view, position, id);
			break;
		case 10:
			CompareItems(l, view, position, id);
			break;
		case 11:
			CompareItems(l, view, position, id);
			break;
		case 12:
			CompareItems(l, view, position, id);
			break;
		case 13:
			CompareItems(l, view, position, id);
			break;
		case 14:
			CompareItems(l, view, position, id);
			break;
		case 15:
			CompareItems(l, view, position, id);
			break;
		case 16:
			CompareItems(l, view, position, id);
			break;
		case 17:
			CompareItems(l, view, position, id);
			break;
		case 18:
			CompareItems(l, view, position, id);
			break;
		case 19:
			CompareItems(l, view, position, id);
			break;
		case 20:
			CompareItems(l, view, position, id);
			break;
		case 21:
			CompareItems(l, view, position, id);
			break;
		case 22:
			CompareItems(l, view, position, id);
			break;
		case 23:
			CompareItems(l, view, position, id);
			break;
		case 24:
			CompareItems(l, view, position, id);
			break;
		case 25:
			CompareItems(l, view, position, id);
			break;
		case 26:
			CompareItems(l, view, position, id);
			break;
		case 27:
			CompareItems(l, view, position, id);
			break;
		case 28:
			CompareItems(l, view, position, id);
			break;
		case 29:
			CompareItems(l, view, position, id);
			break;
		case 30:
			CompareItems(l, view, position, id);
			break;
		case 31:
			CompareItems(l, view, position, id);
			break;
		case 32:
			CompareItems(l, view, position, id);
			break;
		case 33:
			CompareItems(l, view, position, id);
			break;
		case 34:
			CompareItems(l, view, position, id);
			break;
		case 35:
			CompareItems(l, view, position, id);
			break;
		case 36:
			CompareItems(l, view, position, id);
			break;
		case 37:
			CompareItems(l, view, position, id);
			break;
		case 38:
			CompareItems(l, view, position, id);
			break;
		case 39:
			CompareItems(l, view, position, id);
			break;
		case 40:
			CompareItems(l, view, position, id);
			break;
		case 41:
			CompareItems(l, view, position, id);
			break;
		case 42:
			CompareItems(l, view, position, id);
			break;
		case 43:
			CompareItems(l, view, position, id);
			break;
		case 44:
			CompareItems(l, view, position, id);
			break;
		case 45:
			CompareItems(l, view, position, id);
			break;
		case 46:
			CompareItems(l, view, position, id);
			break;
		case 47:
			CompareItems(l, view, position, id);
			break;
		case 48:
			CompareItems(l, view, position, id);
			break;
		case 49:
			CompareItems(l, view, position, id);
			break;
		case 50:
			CompareItems(l, view, position, id);
			break;
		case 51:
			CompareItems(l, view, position, id);
			break;
		case 52:
			CompareItems(l, view, position, id);
			break;
		case 53:
			CompareItems(l, view, position, id);
			break;
		case 54:
			CompareItems(l, view, position, id);
			break;
		case 55:
			CompareItems(l, view, position, id);
			break;
		case 56:
			CompareItems(l, view, position, id);
			break;
		case 57:
			CompareItems(l, view, position, id);
			break;
		case 58:
			CompareItems(l, view, position, id);
			break;
		case 59:
			CompareItems(l, view, position, id);
			break;
		case 60:
			CompareItems(l, view, position, id);
			break;
		case 61:
			CompareItems(l, view, position, id);
			break;
		case 62:
			CompareItems(l, view, position, id);
			break;
		case 63:
			CompareItems(l, view, position, id);
			break;
		case 64:
			CompareItems(l, view, position, id);
			break;
		case 65:
			CompareItems(l, view, position, id);
			break;
		case 66:
			CompareItems(l, view, position, id);
			break;
		case 67:
			CompareItems(l, view, position, id);
			break;
		case 68:
			CompareItems(l, view, position, id);
			break;
		case 69:
			CompareItems(l, view, position, id);
			break;
		case 70:
			CompareItems(l, view, position, id);
			break;
		case 71:
			CompareItems(l, view, position, id);
			break;
		case 72:
			CompareItems(l, view, position, id);
			break;
		case 73:
			CompareItems(l, view, position, id);
			break;
		case 74:
			CompareItems(l, view, position, id);
			break;
		case 75:
			CompareItems(l, view, position, id);
			break;
		case 76:
			CompareItems(l, view, position, id);
			break;
		case 77:
			CompareItems(l, view, position, id);
			break;
		case 78:
			CompareItems(l, view, position, id);
			break;
		case 79:
			CompareItems(l, view, position, id);
			break;
		case 80:
			CompareItems(l, view, position, id);
			break;
		case 81:
			CompareItems(l, view, position, id);
			break;
		case 82:
			CompareItems(l, view, position, id);
			break;
		case 83:
			CompareItems(l, view, position, id);
			break;
		case 84:
			CompareItems(l, view, position, id);
			break;
		case 85:
			CompareItems(l, view, position, id);
			break;
		case 86:
			CompareItems(l, view, position, id);
			break;
		case 87:
			CompareItems(l, view, position, id);
			break;
		case 88:
			CompareItems(l, view, position, id);
			break;
		case 89:
			CompareItems(l, view, position, id);
			break;
		case 90:
			CompareItems(l, view, position, id);
			break;
		case 91:
			CompareItems(l, view, position, id);
			break;
		case 92:
			CompareItems(l, view, position, id);
			break;
		case 93:
			CompareItems(l, view, position, id);
			break;
		case 94:
			CompareItems(l, view, position, id);
			break;
		case 95:
			CompareItems(l, view, position, id);
			break;
		case 96:
			CompareItems(l, view, position, id);
			break;
		case 97:
			CompareItems(l, view, position, id);
			break;
		case 98:
			CompareItems(l, view, position, id);
			break;
		case 99:
			CompareItems(l, view, position, id);
			break;
		}
	}

	private void CompareItems(ListView l, View view, int position, long id) {
		TextView tv = (TextView) view.findViewById(R.id.text1);
		// Weapons
		if (tv.getText().toString().equals("Starter Sword")) {
			StarterSword();
		} else if (tv.getText().toString().equals("Starter Staff")) {
			StarterStaff();
		} else if (tv.getText().toString().equals("Starter Bow")) {
			StarterBow();
		} else if (tv.getText().toString().equals("Bronze Dagger")) {
			BronzeDagger();
		} else if (tv.getText().toString().equals("Bronze Sword")) {
			BronzeSword();
		} else if (tv.getText().toString().equals("Bronze Axe")) {
			BronzeAxe();
		} else if (tv.getText().toString().equals("Bronze Mace")) {
			BronzeMace();
		} else if (tv.getText().toString().equals("Bronze Greatsword")) {
			BronzeGreatsword();
		} else if (tv.getText().toString().equals("Iron Dagger")) {
			IronDagger();
		} else if (tv.getText().toString().equals("Iron Sword")) {
			IronSword();
		} else if (tv.getText().toString().equals("Iron Axe")) {
			IronAxe();
		} else if (tv.getText().toString().equals("Iron Mace")) {
			IronMace();
		} else if (tv.getText().toString().equals("Iron Greatsword")) {
			IronGreatsword();
		} else if (tv.getText().toString().equals("Steel Dagger")) {
			SteelDagger();
		} else if (tv.getText().toString().equals("Steel Sword")) {
			SteelSword();
		} else if (tv.getText().toString().equals("Steel Axe")) {
			SteelAxe();
		} else if (tv.getText().toString().equals("Steel Mace")) {
			SteelMace();
		} else if (tv.getText().toString().equals("Steel Greatsword")) {
			SteelGreatsword();
		} else if (tv.getText().toString().equals("Dwarven Dagger")) {
			DwarvenDagger();
		} else if (tv.getText().toString().equals("Dwarven Sword")) {
			DwarvenSword();
		} else if (tv.getText().toString().equals("Dwarven Axe")) {
			DwarvenAxe();
		} else if (tv.getText().toString().equals("Dwarven Mace")) {
			DwarvenMace();
		} else if (tv.getText().toString().equals("Dwarven Greatsword")) {
			DwarvenGreatsword();
		} else if (tv.getText().toString().equals("Elven Dagger")) {
			ElvenDagger();
		} else if (tv.getText().toString().equals("Elven Sword")) {
			ElvenSword();
		} else if (tv.getText().toString().equals("Elven Axe")) {
			ElvenAxe();
		} else if (tv.getText().toString().equals("Elven Mace")) {
			ElvenMace();
		} else if (tv.getText().toString().equals("Elven Greatsword")) {
			ElvenGreatsword();
		} else if (tv.getText().toString().equals("Orcish Dagger")) {
			OrcishDagger();
		} else if (tv.getText().toString().equals("Orcish Sword")) {
			OrcishSword();
		} else if (tv.getText().toString().equals("Orcish Axe")) {
			OrcishAxe();
		} else if (tv.getText().toString().equals("Orcish Mace")) {
			OrcishMace();
		} else if (tv.getText().toString().equals("Orcish Greatsword")) {
			OrcishGreatsword();
		} else if (tv.getText().toString().equals("Runic Dagger")) {
			RunicDagger();
		} else if (tv.getText().toString().equals("Runic Sword")) {
			RunicSword();
		} else if (tv.getText().toString().equals("Runic Axe")) {
			RunicAxe();
		} else if (tv.getText().toString().equals("Runic Mace")) {
			RunicMace();
		} else if (tv.getText().toString().equals("Runic Greatsword")) {
			RunicGreatsword();
		} else if (tv.getText().toString().equals("Guardian Dagger")) {
			GuardianDagger();
		} else if (tv.getText().toString().equals("Guardian Sword")) {
			GuardianSword();
		} else if (tv.getText().toString().equals("Guardian Axe")) {
			GuardianAxe();
		} else if (tv.getText().toString().equals("Guardian Mace")) {
			GuardianMace();
		} else if (tv.getText().toString().equals("Guardian Greatsword")) {
			GuardianGreatsword();
		} else if (tv.getText().toString().equals("Ancient Dagger")) {
			AncientDagger();
		} else if (tv.getText().toString().equals("Ancient Sword")) {
			AncientSword();
		} else if (tv.getText().toString().equals("Ancient Axe")) {
			AncientAxe();
		} else if (tv.getText().toString().equals("Ancient Mace")) {
			AncientMace();
		} else if (tv.getText().toString().equals("Ancient Greatsword")) {
			AncientGreatsword();
		} else if (tv.getText().toString().equals("Dragon Dagger")) {
			DragonDagger();
		} else if (tv.getText().toString().equals("Dragon Sword")) {
			DragonSword();
		} else if (tv.getText().toString().equals("Dragon Axe")) {
			DragonAxe();
		} else if (tv.getText().toString().equals("Dragon Mace")) {
			DragonMace();
		} else if (tv.getText().toString().equals("Dragon Greatsword")) {
			DragonGreatsword();
		} else if (tv.getText().toString().equals("Forlorn Hope")) {
			ForlornHope();
		} else if (tv.getText().toString().equals("Legendary Blade")) {
			LegendaryBlade();
		} else if (tv.getText().toString().equals("Sword of the Gods")) {
			SwordoftheGods();
		} else if (tv.getText().toString().equals("Novice Air Staff")) {
			NoviceAirStaff();
		} else if (tv.getText().toString().equals("Novice Earth Staff")) {
			NoviceEarthStaff();
		} else if (tv.getText().toString().equals("Novice Fire Staff")) {
			NoviceFireStaff();
		} else if (tv.getText().toString().equals("Novice Water Staff")) {
			NoviceWaterStaff();
		} else if (tv.getText().toString().equals("Apprentice Air Staff")) {
			ApprenticeAirStaff();
		} else if (tv.getText().toString().equals("Apprentice Earth Staff")) {
			ApprenticeEarthStaff();
		} else if (tv.getText().toString().equals("Apprentice Fire Staff")) {
			ApprenticeFireStaff();
		} else if (tv.getText().toString().equals("Apprentice Water Staff")) {
			ApprenticeWaterStaff();
		} else if (tv.getText().toString().equals("Journeyman Air Staff")) {
			JourneymanAirStaff();
		} else if (tv.getText().toString().equals("Journeyman Earth Staff")) {
			JourneymanEarthStaff();
		} else if (tv.getText().toString().equals("Journeyman Fire Staff")) {
			JourneymanFireStaff();
		} else if (tv.getText().toString().equals("Journeyman Water Staff")) {
			JourneymanWaterStaff();
		} else if (tv.getText().toString().equals("Expert Air Staff")) {
			ExpertAirStaff();
		} else if (tv.getText().toString().equals("Expert Earth Staff")) {
			ExpertEarthStaff();
		} else if (tv.getText().toString().equals("Expert Fire Staff")) {
			ExpertFireStaff();
		} else if (tv.getText().toString().equals("Expert Water Staff")) {
			ExpertWaterStaff();
		} else if (tv.getText().toString().equals("Master Air Staff")) {
			MasterAirStaff();
		} else if (tv.getText().toString().equals("Master Earth Staff")) {
			MasterEarthStaff();
		} else if (tv.getText().toString().equals("Master Fire Staff")) {
			MasterFireStaff();
		} else if (tv.getText().toString().equals("Master Water Staff")) {
			MasterWaterStaff();
		} else if (tv.getText().toString().equals("Criistik's Staff")) {
			CriistiksStaff();
		} else if (tv.getText().toString().equals("Xekith's Wand")) {
			XekithsWand();
		} else if (tv.getText().toString().equals("Auxatia's Battlestaff")) {
			AuxatiasBattlestaff();
		} else if (tv.getText().toString().equals("Zamarik's Scepter")) {
			ZamariksScepter();
		} else if (tv.getText().toString().equals("Shortbow")) {
			Shortbow();
		} else if (tv.getText().toString().equals("Longbow")) {
			Longbow();
		} else if (tv.getText().toString().equals("Crossbow")) {
			Crossbow();
		} else if (tv.getText().toString().equals("Oak Shortbow")) {
			OakShortbow();
		} else if (tv.getText().toString().equals("Oak Longbow")) {
			OakLongbow();
		} else if (tv.getText().toString().equals("Oak Crossbow")) {
			OakCrossbow();
		} else if (tv.getText().toString().equals("Maple Shortbow")) {
			MapleShortbow();
		} else if (tv.getText().toString().equals("Maple Longbow")) {
			MapleLongbow();
		} else if (tv.getText().toString().equals("Maple Crossbow")) {
			MapleCrossbow();
		} else if (tv.getText().toString().equals("Ash Shortbow")) {
			AshShortbow();
		} else if (tv.getText().toString().equals("Ash Longbow")) {
			AshLongbow();
		} else if (tv.getText().toString().equals("Ash Crossbow")) {
			AshCrossbow();
		} else if (tv.getText().toString().equals("Ebony Shortbow")) {
			EbonyShortbow();
		} else if (tv.getText().toString().equals("Ebony Longbow")) {
			EbonyLongbow();
		} else if (tv.getText().toString().equals("Ebony Crossbow")) {
			EbonyCrossbow();
		} else if (tv.getText().toString().equals("Dragon Bow")) {
			DragonBow();
		} else if (tv.getText().toString().equals("Mystic Bow")) {
			MysticBow();
		} else if (tv.getText().toString().equals("Zanthiir's Composite Bow")) {
			ZanthiirsCompositeBow();
		} else if (tv.getText().toString().equals("Hērō's Bow")) {
			HerosBow();

			// Armour
		} else if (tv.getText().toString().equals("Bronze Helmet")) {
			BronzeHelmet();
		} else if (tv.getText().toString().equals("Bronze Chestplate")) {
			BronzeChestplate();
		} else if (tv.getText().toString().equals("Bronze Platelegs")) {
			BronzePlatelegs();
		} else if (tv.getText().toString().equals("Bronze Boots")) {
			BronzeBoots();
		} else if (tv.getText().toString().equals("Bronze Shield")) {
			BronzeShield();
		} else if (tv.getText().toString().equals("Iron Helmet")) {
			IronHelmet();
		} else if (tv.getText().toString().equals("Iron Chestplate")) {
			IronChestplate();
		} else if (tv.getText().toString().equals("Iron Platelegs")) {
			IronPlatelegs();
		} else if (tv.getText().toString().equals("Iron Boots")) {
			IronBoots();
		} else if (tv.getText().toString().equals("Iron Shield")) {
			IronShield();
		} else if (tv.getText().toString().equals("Steel Helmet")) {
			SteelHelmet();
		} else if (tv.getText().toString().equals("Steel Chestplate")) {
			SteelChestplate();
		} else if (tv.getText().toString().equals("Steel Platelegs")) {
			SteelPlatelegs();
		} else if (tv.getText().toString().equals("Steel Boots")) {
			SteelBoots();
		} else if (tv.getText().toString().equals("Steel Shield")) {
			SteelShield();
		} else if (tv.getText().toString().equals("Dwarven Helmet")) {
			DwarvenHelmet();
		} else if (tv.getText().toString().equals("Dwarven Chestplate")) {
			DwarvenChestplate();
		} else if (tv.getText().toString().equals("Dwarven Platelegs")) {
			DwarvenPlatelegs();
		} else if (tv.getText().toString().equals("Dwarven Boots")) {
			DwarvenBoots();
		} else if (tv.getText().toString().equals("Dwarven Shield")) {
			DwarvenShield();
		} else if (tv.getText().toString().equals("Elven Helmet")) {
			ElvenHelmet();
		} else if (tv.getText().toString().equals("Elven Chestplate")) {
			ElvenChesplate();
		} else if (tv.getText().toString().equals("Elven Platelegs")) {
			ElvenPlatelegs();
		} else if (tv.getText().toString().equals("Elven Boots")) {
			ElvenBoots();
		} else if (tv.getText().toString().equals("Elven Shield")) {
			ElvenShield();
		} else if (tv.getText().toString().equals("Orcish Helmet")) {
			OrcishHelmet();
		} else if (tv.getText().toString().equals("Orcish Chestplate")) {
			OrcishChestplate();
		} else if (tv.getText().toString().equals("Orcish Platelegs")) {
			OrcishPlatelegs();
		} else if (tv.getText().toString().equals("Orcish Boots")) {
			OrcishBoots();
		} else if (tv.getText().toString().equals("Orcish Shield")) {
			OrcishShield();
		} else if (tv.getText().toString().equals("Runic Helmet")) {
			RunicHelmet();
		} else if (tv.getText().toString().equals("Runic Chestplate")) {
			RunicChestplate();
		} else if (tv.getText().toString().equals("Runic Platelegs")) {
			RunicPlatelegs();
		} else if (tv.getText().toString().equals("Runic Boots")) {
			RunicBoots();
		} else if (tv.getText().toString().equals("Runic Shield")) {
			RunicShield();
		} else if (tv.getText().toString().equals("Guardian Helmet")) {
			GuardianHelmet();
		} else if (tv.getText().toString().equals("Guardian Chestplate")) {
			GuardianChestplate();
		} else if (tv.getText().toString().equals("Guardian Platelegs")) {
			GuardianPlatelegs();
		} else if (tv.getText().toString().equals("Guardian Boots")) {
			GuardianBoots();
		} else if (tv.getText().toString().equals("Guardian Shield")) {
			GuardianShield();
		} else if (tv.getText().toString().equals("Ancient Helmet")) {
			AncientHelmet();
		} else if (tv.getText().toString().equals("Ancient Chestplate")) {
			AncientChestplate();
		} else if (tv.getText().toString().equals("Ancient Platelegs")) {
			AncientPlatelegs();
		} else if (tv.getText().toString().equals("Ancient Boots")) {
			AncientBoots();
		} else if (tv.getText().toString().equals("Ancient Shield")) {
			AncientShield();
		} else if (tv.getText().toString().equals("Dragon Helmet")) {
			DragonHelmet();
		} else if (tv.getText().toString().equals("Dragon Chestplate")) {
			DragonChestplate();
		} else if (tv.getText().toString().equals("Dragon Platelegs")) {
			DragonPlatelegs();
		} else if (tv.getText().toString().equals("Dragon Boots")) {
			DragonBoots();
		} else if (tv.getText().toString().equals("Dragon Shield")) {
			DragonShield();
		} else if (tv.getText().toString().equals("Forlorn Helmet")) {
			ForlornHelmet();
		} else if (tv.getText().toString().equals("Forlorn Chestplate")) {
			ForlornChestplate();
		} else if (tv.getText().toString().equals("Forlorn Platelegs")) {
			ForlornPlatelegs();
		} else if (tv.getText().toString().equals("Forlorn Boots")) {
			ForlornBoots();
		} else if (tv.getText().toString().equals("Forlorn Shield")) {
			ForlornShield();
		} else if (tv.getText().toString().equals("Legendary Helmet")) {
			LegendaryHelmet();
		} else if (tv.getText().toString().equals("Legendary Chestplate")) {
			LegendaryChestplate();
		} else if (tv.getText().toString().equals("Legendary Platelegs")) {
			LegendaryPlatelegs();
		} else if (tv.getText().toString().equals("Legendary Boots")) {
			LegendaryBoots();
		} else if (tv.getText().toString().equals("Legendary Shield")) {
			LegendaryShield();
		} else if (tv.getText().toString().equals("Helmet of the Gods")) {
			HelmetoftheGods();
		} else if (tv.getText().toString().equals("Chestplate of the Gods")) {
			ChestplateoftheGods();
		} else if (tv.getText().toString().equals("Platelegs of the Gods")) {
			PlatelegsoftheGods();
		} else if (tv.getText().toString().equals("Boots of the Gods")) {
			BootsoftheGods();
		} else if (tv.getText().toString().equals("Shield of the Gods")) {
			ShieldoftheGods();
		} else if (tv.getText().toString().equals("Novice Hood")) {
			NoviceHood();
		} else if (tv.getText().toString().equals("Novice Robe Top")) {
			NoviceRobeTop();
		} else if (tv.getText().toString().equals("Novice Robe Bottom")) {
			NoviceRobeBottom();
		} else if (tv.getText().toString().equals("Novice Boots")) {
			NoviceBoots();
		} else if (tv.getText().toString().equals("Apprentice Hood")) {
			ApprenticeHood();
		} else if (tv.getText().toString().equals("Apprentice Robe Top")) {
			ApprenticeRobeTop();
		} else if (tv.getText().toString().equals("Apprentice Robe Bottom")) {
			ApprenticeRobeBottom();
		} else if (tv.getText().toString().equals("Apprentice Boots")) {
			ApprenticeBoots();
		} else if (tv.getText().toString().equals("Journeyman Hood")) {
			JourneymanHood();
		} else if (tv.getText().toString().equals("Journeyman Robe Top")) {
			JourneymanRobeTop();
		} else if (tv.getText().toString().equals("Journeyman Robe Bottom")) {
			JourneymanRobeBottom();
		} else if (tv.getText().toString().equals("Journeyman Boots")) {
			JourneymanBoots();
		} else if (tv.getText().toString().equals("Expert Hood")) {
			ExpertHood();
		} else if (tv.getText().toString().equals("Expert Robe Top")) {
			ExpertRobeTop();
		} else if (tv.getText().toString().equals("Expert Robe Bottom")) {
			ExpertRobeBottom();
		} else if (tv.getText().toString().equals("Expert Boots")) {
			ExpertBoots();
		} else if (tv.getText().toString().equals("Master Hood")) {
			MasterHood();
		} else if (tv.getText().toString().equals("Master Robe Top")) {
			MasterRobeTop();
		} else if (tv.getText().toString().equals("Master Robe Bottom")) {
			MasterRobeBottom();
		} else if (tv.getText().toString().equals("Master Boots")) {
			MasterBoots();
		} else if (tv.getText().toString().equals("Criistik's Hood")) {
			CriistiksHood();
		} else if (tv.getText().toString().equals("Criistik's Robe Top")) {
			CriistiksRobeTop();
		} else if (tv.getText().toString().equals("Criistik's Robe Bottom")) {
			CriistiksRobeBottom();
		} else if (tv.getText().toString().equals("Criistik's Boots")) {
			CriistiksBoots();
		} else if (tv.getText().toString().equals("Xekith's Hood")) {
			XekithsHood();
		} else if (tv.getText().toString().equals("Xekith's Robe Top")) {
			XekithsRobeTop();
		} else if (tv.getText().toString().equals("Xekith's Robe Bottom")) {
			XekithsRobeBottom();
		} else if (tv.getText().toString().equals("Xekith's Boots")) {
			XekithsBoots();
		} else if (tv.getText().toString().equals("Auxatia's Hood")) {
			AuxatiasHood();
		} else if (tv.getText().toString().equals("Auxatia's Robe Top")) {
			AuxatiasRobeTop();
		} else if (tv.getText().toString().equals("Auxatia's Robe Bottom")) {
			AuxatiasRobeBottom();
		} else if (tv.getText().toString().equals("Auxatia's Boots")) {
			AuxatiasBoots();
		} else if (tv.getText().toString().equals("Zamirik's Hood")) {
			ZamariksHood();
		} else if (tv.getText().toString().equals("Zamarik's Robe Top")) {
			ZamariksRobeTop();
		} else if (tv.getText().toString().equals("Zamarik's Robe Bottom")) {
			ZamariksRobeBottom();
		} else if (tv.getText().toString().equals("Zamarik's Boots")) {
			ZamariksBoots();
		} else if (tv.getText().toString().equals("Leather Cowl")) {
			LeatherCowl();
		} else if (tv.getText().toString().equals("Leather Cuirass")) {
			LeatherCuirass();
		} else if (tv.getText().toString().equals("Leather Chaps")) {
			LeatherChaps();
		} else if (tv.getText().toString().equals("Leather Boots")) {
			LeatherBoots();
		} else if (tv.getText().toString().equals("Studded Cowl")) {
			StuddedCowl();
		} else if (tv.getText().toString().equals("Studded Cuirass")) {
			StuddedCuirass();
		} else if (tv.getText().toString().equals("Studded Chaps")) {
			StuddedShaps();
		} else if (tv.getText().toString().equals("Studded Boots")) {
			StuddedBoots();
		} else if (tv.getText().toString().equals("Corrupted Cowl")) {
			CorruptedCowl();
		} else if (tv.getText().toString().equals("Corrupted Cuirass")) {
			CorruptedCuirass();
		} else if (tv.getText().toString().equals("Corrupted Chaps")) {
			CorruptedChaps();
		} else if (tv.getText().toString().equals("Corrupted Boots")) {
			CorruptedBoots();
		} else if (tv.getText().toString().equals("Demonhide Cowl")) {
			DemonhideCowl();
		} else if (tv.getText().toString().equals("Demonhide Cuirass")) {
			DemonhideCuirass();
		} else if (tv.getText().toString().equals("Demonhide Chaps")) {
			DemonhideChaps();
		} else if (tv.getText().toString().equals("Demonhide Boots")) {
			DemonhideBoots();
		} else if (tv.getText().toString().equals("Darkspawn Cowl")) {
			DarkspawnCowl();
		} else if (tv.getText().toString().equals("Darkspawn Cuirass")) {
			DarkspawnCuirass();
		} else if (tv.getText().toString().equals("Darkspawn Chaps")) {
			DarkspawnChaps();
		} else if (tv.getText().toString().equals("Darkspawn Boots")) {
			DarkspawnBoots();
		} else if (tv.getText().toString().equals("Black Dragon Cowl")) {
			BlackDragonCowl();
		} else if (tv.getText().toString().equals("Black Dragon Cuirass")) {
			BlackDragonCuirass();
		} else if (tv.getText().toString().equals("Black Dragon Chaps")) {
			BlackDragonChaps();
		} else if (tv.getText().toString().equals("Black Dragon Boots")) {
			BlackDragonBoots();
		} else if (tv.getText().toString().equals("Mystic Cowl")) {
			MysticCowl();
		} else if (tv.getText().toString().equals("Mystic Cuirass")) {
			MysticCuirass();
		} else if (tv.getText().toString().equals("Mystic Chaps")) {
			MysticChaps();
		} else if (tv.getText().toString().equals("Mystic Boots")) {
			MysticBoots();
		} else if (tv.getText().toString().equals("Zanthiir's Cowl")) {
			ZanthiirsCowl();
		} else if (tv.getText().toString().equals("Zanthiir's Cuirass")) {
			ZanthiirsCuirass();
		} else if (tv.getText().toString().equals("Zanthiir's Chaps")) {
			ZanthiirsChaps();
		} else if (tv.getText().toString().equals("Zanthiir's Boots")) {
			ZanthiirsBoots();
		} else if (tv.getText().toString().equals("Hērō's Cowl")) {
			HerosCowl();
		} else if (tv.getText().toString().equals("Hērō's Cuirass")) {
			HerosCuirass();
		} else if (tv.getText().toString().equals("Hērō's Chaps")) {
			HerosChaps();
		} else if (tv.getText().toString().equals("Hērō's Boots")) {
			HerosBoots();

			// Potions
		} else if (tv.getText().toString().equals("Minor Health Potion")) {
			MinorHealthPotion();
		} else if (tv.getText().toString().equals("Major Health Potion")) {
			MajorHealthPotion();
		} else if (tv.getText().toString().equals("Fortify Health Potion")) {
			FortifyHealthPotion();
		} else if (tv.getText().toString().equals("Extreme Health Potion")) {
			ExtremeHealthPotion();
		} else if (tv.getText().toString().equals("Ultimate Health Potion")) {
			UltimateHealthPotion();
		} else if (tv.getText().toString().equals("Minor Mana Potion")) {
			MinorManaPotion();
		} else if (tv.getText().toString().equals("Major Mana Potion")) {
			MajorManaPotion();
		} else if (tv.getText().toString().equals("Fortify Mana Potion")) {
			FortifyManaPotion();
		} else if (tv.getText().toString().equals("Extreme Mana Potion")) {
			ExtremeManaPotion();
		} else if (tv.getText().toString().equals("Ultimate Mana Potion")) {
			UltimateManaPotion();
		}
	}

	private void HerosBow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Hērō's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Hērō's Bow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ZanthiirsCompositeBow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zanthiir's Composite Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast
								.makeText(
										ShopSell.this,
										"Zanthiir's Composite Bow equipped to Primary Hand",
										Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MysticBow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Mystic Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Mystic Bow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DragonBow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Dragon Bow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyCrossbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ebony Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ebony Crossbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyLongbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ebony Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ebony Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyShortbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ebony Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ebony Shortbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshCrossbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ash Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ash Crossbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshLongbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ash Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ash Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshShortbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ash Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Ash Shortbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleCrossbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Maple Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Maple Crossbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleLongbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Maple Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Maple Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleShortbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Maple Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Maple Shortbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakCrossbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Oak Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Oak Crossbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakLongbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Oak Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Oak Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakShortbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Oak Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Oak Shortbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Crossbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Crossbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Longbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Shortbow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void UltimateManaPotion() {

	}

	private void ExtremeManaPotion() {

	}

	private void FortifyManaPotion() {

	}

	private void MajorManaPotion() {

	}

	private void MinorManaPotion() {

	}

	private void UltimateHealthPotion() {

	}

	private void ExtremeHealthPotion() {

	}

	private void FortifyHealthPotion() {

	}

	private void MajorHealthPotion() {

	}

	private void MinorHealthPotion() {

	}

	private void HerosBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Hērō's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void HerosChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Hērō's Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HerosCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Hērō's Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HerosCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Hērō's Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zanthiir's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zanthiir's Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zanthiir's Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zanthiir's Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Mystic Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Mystic Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Mystic Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Mystic Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Black Dragon Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Black Dragon Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Black Dragon Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Black Dragon Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Darkspawn Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Darkspawn Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Darkspawn Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Darkspawn Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Demonhide Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Demonhide Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Demonhide Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Demonhide Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Corrupted Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Corrupted Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Corrupted Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Corrupted Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Studded Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedShaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Studded Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Studded Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Studded Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Leather Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherChaps() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Leather Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherCuirass() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Leather Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherCowl() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Leather Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zamarik's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zamarik's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zamarik's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zamarik's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Auxatia's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Auxatia's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Auxatia's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Auxatia's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Xekith's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Xekith's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Xekith's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Xekith's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Criistik's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Criistik's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Criistik's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Criistik's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceRobeBottom() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceRobeTop() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceHood() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ShieldoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Shield of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BootsoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Boots of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void PlatelegsoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Platelegs of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ChestplateoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Chestplate of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HelmetoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Helmet of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AncientChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void RunicChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OrcishBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenChesplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronPlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeShield() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeBoots() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzePlatelegs() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void BronzeChestplate() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeHelmet() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksScepter() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Zamarik's Scepter");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasBattlestaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Auxatia's Battlestaff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void XekithsWand() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Xekith's Wand");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Criistik's Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterWaterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Water Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterFireStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Fire Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterEarthStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Earth Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterAirStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Master Air Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertWaterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Water Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertFireStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Fire Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertEarthStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Earth Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ExpertAirStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Expert Air Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanWaterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Water Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanFireStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Fire Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanEarthStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Earth Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanAirStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Journeyman Air Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeWaterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Water Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeFireStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Fire Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeEarthStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Earth Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeAirStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Apprentice Air Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceWaterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Water Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceFireStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Fire Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceEarthStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Earth Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceAirStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Novice Air Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SwordoftheGods() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Sword of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryBlade() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Legendary Blade");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornHope() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Forlorn Hope");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dragon Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Ancient Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Guardian Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Runic Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Orcish Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Elven Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Dwarven Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Steel Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Iron Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeGreatsword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeMace() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeAxe() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeDagger() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Bronze Dagger");
		dlgAlert.setMessage("Type: Melee \n" +
				"Damage: 3 \n" +
				"Accuracy: 5 \n" +
				"Wield: Primary/Secondary \n\n" +
				"Value: 75G");
		dlgAlert.setPositiveButton("Sell",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Longbow equipped to Primary Hand",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterBow() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Starter Bow");
		dlgAlert.setMessage("You cannot sell this item.");
		dlgAlert.setPositiveButton("Destroy",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Starter Bow destroyed",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterStaff() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Starter Staff");
		dlgAlert.setMessage("You cannot sell this item.");
		dlgAlert.setPositiveButton("Destroy",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						Toast msg = Toast.makeText(ShopSell.this,
								"Starter Staff destroyed",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterSword() {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ShopSell.this);
		dlgAlert.setTitle("Starter Sword");
		dlgAlert.setMessage("You cannot sell this item.");
		dlgAlert.setPositiveButton("Destroy",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						//deletes the record...
						
						Toast msg = Toast.makeText(ShopSell.this,
								"Starter Sword destroyed",
								Toast.LENGTH_SHORT);
						msg.show();
						dialog.dismiss();
					}
				});
		dlgAlert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shop_sell, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Inventory:
                Intent Inventory = new Intent(this,
                        Inventory.class);
                this.startActivity(Inventory);

                return true;
            case R.id.Equipment:
                Intent Equipment = new Intent(this,
                        Equipment.class);
                this.startActivity(Equipment);

                return true;
            case R.id.Shop:
                Intent Shop = new Intent(this,
                        Shop.class);
                this.startActivity(Shop);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent Shop = new Intent(getApplicationContext(), Shop.class);
		startActivity(Shop);
		finish();
	}
}
