package com.Logik.dawn.of.ages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.Logik.dawn.of.ages.R.drawable;

import Databases.DBAdapter;
import Databases.DBAdapter_Equipment_Chest;
import Databases.DBAdapter_Equipment_Feet;
import Databases.DBAdapter_Equipment_Hands;
import Databases.DBAdapter_Equipment_Head;
import Databases.DBAdapter_Equipment_Legs;
import Databases.DBAdapter_Equipment_PH;
import Databases.DBAdapter_Equipment_SH;
import Databases.DBAdapter_Equipment_Spells;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Inventory extends ListActivity {

	DBAdapter db = new DBAdapter(this);
	DBAdapter_Equipment_Head dbHead = new DBAdapter_Equipment_Head(this);
	DBAdapter_Equipment_Chest dbChest = new DBAdapter_Equipment_Chest(this);
	DBAdapter_Equipment_Hands dbHands = new DBAdapter_Equipment_Hands(this);
	DBAdapter_Equipment_Legs dbLegs = new DBAdapter_Equipment_Legs(this);
	DBAdapter_Equipment_Feet dbFeet = new DBAdapter_Equipment_Feet(this);
	DBAdapter_Equipment_PH dbPH = new DBAdapter_Equipment_PH(this);
	DBAdapter_Equipment_SH dbSH = new DBAdapter_Equipment_SH(this);
	DBAdapter_Equipment_Spells dbSpells = new DBAdapter_Equipment_Spells(this);

	@SuppressLint("SdCardPath")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_screen);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
		bar.setLogo(drawable.inventory_logo);

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases/InventoryDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("InventoryDB"), new FileOutputStream(destPath));
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

	@SuppressWarnings("deprecation")
	public void DisplayRecord(Cursor c) {
		final Cursor c1 = DBAdapter.getAllRecords();
		startManagingCursor(c1);

		String[] from = new String[] { DBAdapter.KEY_ITEM };
		int[] to = new int[] { R.id.text1 };

		SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.row, c1, from, to);
		setListAdapter(notes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sendto_equipment, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Equipment:
			Intent Equipment = new Intent(this, Equipment.class);
			this.startActivity(Equipment);
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
	public void onListItemClick(ListView l, View view, int position, long id) {
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

	@SuppressWarnings("deprecation")
	public void Requery() {
		db.open();
		final Cursor c1 = DBAdapter.getAllRecords();
		startManagingCursor(c1);

		String[] from = new String[] { DBAdapter.KEY_ITEM };
		int[] to = new int[] { R.id.text1 };

		final SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.row, c1, from, to);
		setListAdapter(notes);
		notes.notifyDataSetChanged();
		db.close();
	}

	private void CompareItems(ListView l, View view, int position, long id) {
		TextView tv = (TextView) view.findViewById(R.id.text1);
		// Melee Weapons
		if (tv.getText().toString().equals("Starter Sword")) {
			StarterSword(position);
		} else if (tv.getText().toString().equals("Bronze Dagger")) {
			BronzeDagger(position);
		} else if (tv.getText().toString().equals("Bronze Sword")) {
			BronzeSword(position);
		} else if (tv.getText().toString().equals("Bronze Axe")) {
			BronzeAxe(position);
		} else if (tv.getText().toString().equals("Bronze Mace")) {
			BronzeMace(position);
		} else if (tv.getText().toString().equals("Bronze Greatsword")) {
			BronzeGreatsword(position);
		} else if (tv.getText().toString().equals("Iron Dagger")) {
			IronDagger(position);
		} else if (tv.getText().toString().equals("Iron Sword")) {
			IronSword(position);
		} else if (tv.getText().toString().equals("Iron Axe")) {
			IronAxe(position);
		} else if (tv.getText().toString().equals("Iron Mace")) {
			IronMace(position);
		} else if (tv.getText().toString().equals("Iron Greatsword")) {
			IronGreatsword(position);
		} else if (tv.getText().toString().equals("Steel Dagger")) {
			SteelDagger(position);
		} else if (tv.getText().toString().equals("Steel Sword")) {
			SteelSword(position);
		} else if (tv.getText().toString().equals("Steel Axe")) {
			SteelAxe(position);
		} else if (tv.getText().toString().equals("Steel Mace")) {
			SteelMace(position);
		} else if (tv.getText().toString().equals("Steel Greatsword")) {
			SteelGreatsword(position);
		} else if (tv.getText().toString().equals("Dwarven Dagger")) {
			DwarvenDagger(position);
		} else if (tv.getText().toString().equals("Dwarven Sword")) {
			DwarvenSword(position);
		} else if (tv.getText().toString().equals("Dwarven Axe")) {
			DwarvenAxe(position);
		} else if (tv.getText().toString().equals("Dwarven Mace")) {
			DwarvenMace(position);
		} else if (tv.getText().toString().equals("Dwarven Greatsword")) {
			DwarvenGreatsword(position);
		} else if (tv.getText().toString().equals("Elven Dagger")) {
			ElvenDagger(position);
		} else if (tv.getText().toString().equals("Elven Sword")) {
			ElvenSword(position);
		} else if (tv.getText().toString().equals("Elven Axe")) {
			ElvenAxe(position);
		} else if (tv.getText().toString().equals("Elven Mace")) {
			ElvenMace(position);
		} else if (tv.getText().toString().equals("Elven Greatsword")) {
			ElvenGreatsword(position);
		} else if (tv.getText().toString().equals("Orcish Dagger")) {
			OrcishDagger(position);
		} else if (tv.getText().toString().equals("Orcish Sword")) {
			OrcishSword(position);
		} else if (tv.getText().toString().equals("Orcish Axe")) {
			OrcishAxe(position);
		} else if (tv.getText().toString().equals("Orcish Mace")) {
			OrcishMace(position);
		} else if (tv.getText().toString().equals("Orcish Greatsword")) {
			OrcishGreatsword(position);
		} else if (tv.getText().toString().equals("Runic Dagger")) {
			RunicDagger(position);
		} else if (tv.getText().toString().equals("Runic Sword")) {
			RunicSword(position);
		} else if (tv.getText().toString().equals("Runic Axe")) {
			RunicAxe(position);
		} else if (tv.getText().toString().equals("Runic Mace")) {
			RunicMace(position);
		} else if (tv.getText().toString().equals("Runic Greatsword")) {
			RunicGreatsword(position);
		} else if (tv.getText().toString().equals("Guardian Dagger")) {
			GuardianDagger(position);
		} else if (tv.getText().toString().equals("Guardian Sword")) {
			GuardianSword(position);
		} else if (tv.getText().toString().equals("Guardian Axe")) {
			GuardianAxe(position);
		} else if (tv.getText().toString().equals("Guardian Mace")) {
			GuardianMace(position);
		} else if (tv.getText().toString().equals("Guardian Greatsword")) {
			GuardianGreatsword(position);
		} else if (tv.getText().toString().equals("Ancient Dagger")) {
			AncientDagger(position);
		} else if (tv.getText().toString().equals("Ancient Sword")) {
			AncientSword(position);
		} else if (tv.getText().toString().equals("Ancient Axe")) {
			AncientAxe(position);
		} else if (tv.getText().toString().equals("Ancient Mace")) {
			AncientMace(position);
		} else if (tv.getText().toString().equals("Ancient Greatsword")) {
			AncientGreatsword(position);
		} else if (tv.getText().toString().equals("Dragon Dagger")) {
			DragonDagger(position);
		} else if (tv.getText().toString().equals("Dragon Sword")) {
			DragonSword(position);
		} else if (tv.getText().toString().equals("Dragon Axe")) {
			DragonAxe(position);
		} else if (tv.getText().toString().equals("Dragon Mace")) {
			DragonMace(position);
		} else if (tv.getText().toString().equals("Dragon Greatsword")) {
			DragonGreatsword(position);
		} else if (tv.getText().toString().equals("Forlorn Hope")) {
			ForlornHope(position);
		} else if (tv.getText().toString().equals("Legendary Blade")) {
			LegendaryBlade(position);
		} else if (tv.getText().toString().equals("Sword of the Gods")) {
			SwordoftheGods(position);

			// Spellcaster Weapons
		} else if (tv.getText().toString().equals("Starter Staff")) {
			StarterStaff(position);
		} else if (tv.getText().toString().equals("Criistik's Staff")) {
			CriistiksStaff(position);
		} else if (tv.getText().toString().equals("Xekith's Wand")) {
			XekithsWand(position);
		} else if (tv.getText().toString().equals("Auxatia's Battlestaff")) {
			AuxatiasBattlestaff(position);
		} else if (tv.getText().toString().equals("Zamarik's Scepter")) {
			ZamariksScepter(position);

			// Spellcaster Spells
		} else if (tv.getText().toString().equals("SPELLS START HERE")) {
			// METHOD(position);

			// Ranger Weapons
		} else if (tv.getText().toString().equals("Starter Bow")) {
			StarterBow(position);
		} else if (tv.getText().toString().equals("Shortbow")) {
			Shortbow(position);
		} else if (tv.getText().toString().equals("Longbow")) {
			Longbow(position);
		} else if (tv.getText().toString().equals("Crossbow")) {
			Crossbow(position);
		} else if (tv.getText().toString().equals("Oak Shortbow")) {
			OakShortbow(position);
		} else if (tv.getText().toString().equals("Oak Longbow")) {
			OakLongbow(position);
		} else if (tv.getText().toString().equals("Oak Crossbow")) {
			OakCrossbow(position);
		} else if (tv.getText().toString().equals("Maple Shortbow")) {
			MapleShortbow(position);
		} else if (tv.getText().toString().equals("Maple Longbow")) {
			MapleLongbow(position);
		} else if (tv.getText().toString().equals("Maple Crossbow")) {
			MapleCrossbow(position);
		} else if (tv.getText().toString().equals("Ash Shortbow")) {
			AshShortbow(position);
		} else if (tv.getText().toString().equals("Ash Longbow")) {
			AshLongbow(position);
		} else if (tv.getText().toString().equals("Ash Crossbow")) {
			AshCrossbow(position);
		} else if (tv.getText().toString().equals("Ebony Shortbow")) {
			EbonyShortbow(position);
		} else if (tv.getText().toString().equals("Ebony Longbow")) {
			EbonyLongbow(position);
		} else if (tv.getText().toString().equals("Ebony Crossbow")) {
			EbonyCrossbow(position);
		} else if (tv.getText().toString().equals("Dragon Bow")) {
			DragonBow(position);
		} else if (tv.getText().toString().equals("Mystic Bow")) {
			MysticBow(position);
		} else if (tv.getText().toString().equals("Zanthiir's Composite Bow")) {
			ZanthiirsCompositeBow(position);
		} else if (tv.getText().toString().equals("Hērō's Bow")) {
			HerosBow(position);

			// Melee Armour
		} else if (tv.getText().toString().equals("Bronze Helmet")) {
			BronzeHelmet(position);
		} else if (tv.getText().toString().equals("Bronze Chestplate")) {
			BronzeChestplate(position);
		} else if (tv.getText().toString().equals("Bronze Gauntlets")) {
			BronzeGauntlets(position);
		} else if (tv.getText().toString().equals("Bronze Platelegs")) {
			BronzePlatelegs(position);
		} else if (tv.getText().toString().equals("Bronze Boots")) {
			BronzeBoots(position);
		} else if (tv.getText().toString().equals("Bronze Shield")) {
			BronzeShield(position);
		} else if (tv.getText().toString().equals("Iron Helmet")) {
			IronHelmet(position);
		} else if (tv.getText().toString().equals("Iron Chestplate")) {
			IronChestplate(position);
		} else if (tv.getText().toString().equals("Iron Gauntlets")) {
			IronGauntlets(position);
		} else if (tv.getText().toString().equals("Iron Platelegs")) {
			IronPlatelegs(position);
		} else if (tv.getText().toString().equals("Iron Boots")) {
			IronBoots(position);
		} else if (tv.getText().toString().equals("Iron Shield")) {
			IronShield(position);
		} else if (tv.getText().toString().equals("Steel Helmet")) {
			SteelHelmet(position);
		} else if (tv.getText().toString().equals("Steel Chestplate")) {
			SteelChestplate(position);
		} else if (tv.getText().toString().equals("Steel Gauntlets")) {
			SteelGauntlets(position);
		} else if (tv.getText().toString().equals("Steel Platelegs")) {
			SteelPlatelegs(position);
		} else if (tv.getText().toString().equals("Steel Boots")) {
			SteelBoots(position);
		} else if (tv.getText().toString().equals("Steel Shield")) {
			SteelShield(position);
		} else if (tv.getText().toString().equals("Dwarven Helmet")) {
			DwarvenHelmet(position);
		} else if (tv.getText().toString().equals("Dwarven Chestplate")) {
			DwarvenChestplate(position);
		} else if (tv.getText().toString().equals("Dwarven Gauntlets")) {
			DwarvenGauntlets(position);
		} else if (tv.getText().toString().equals("Dwarven Platelegs")) {
			DwarvenPlatelegs(position);
		} else if (tv.getText().toString().equals("Dwarven Boots")) {
			DwarvenBoots(position);
		} else if (tv.getText().toString().equals("Dwarven Shield")) {
			DwarvenShield(position);
		} else if (tv.getText().toString().equals("Elven Helmet")) {
			ElvenHelmet(position);
		} else if (tv.getText().toString().equals("Elven Chestplate")) {
			ElvenChesplate(position);
		} else if (tv.getText().toString().equals("Elven Gauntlets")) {
			ElvenGauntlets(position);
		} else if (tv.getText().toString().equals("Elven Platelegs")) {
			ElvenPlatelegs(position);
		} else if (tv.getText().toString().equals("Elven Boots")) {
			ElvenBoots(position);
		} else if (tv.getText().toString().equals("Elven Shield")) {
			ElvenShield(position);
		} else if (tv.getText().toString().equals("Orcish Helmet")) {
			OrcishHelmet(position);
		} else if (tv.getText().toString().equals("Orcish Chestplate")) {
			OrcishChestplate(position);
		} else if (tv.getText().toString().equals("Orcish Gauntlets")) {
			OrcishGauntlets(position);
		} else if (tv.getText().toString().equals("Orcish Platelegs")) {
			OrcishPlatelegs(position);
		} else if (tv.getText().toString().equals("Orcish Boots")) {
			OrcishBoots(position);
		} else if (tv.getText().toString().equals("Orcish Shield")) {
			OrcishShield(position);
		} else if (tv.getText().toString().equals("Runic Helmet")) {
			RunicHelmet(position);
		} else if (tv.getText().toString().equals("Runic Chestplate")) {
			RunicChestplate(position);
		} else if (tv.getText().toString().equals("Runic Gauntlets")) {
			RunicGauntlets(position);
		} else if (tv.getText().toString().equals("Runic Platelegs")) {
			RunicPlatelegs(position);
		} else if (tv.getText().toString().equals("Runic Boots")) {
			RunicBoots(position);
		} else if (tv.getText().toString().equals("Runic Shield")) {
			RunicShield(position);
		} else if (tv.getText().toString().equals("Guardian Helmet")) {
			GuardianHelmet(position);
		} else if (tv.getText().toString().equals("Guardian Chestplate")) {
			GuardianChestplate(position);
		} else if (tv.getText().toString().equals("Guardian Gauntlets")) {
			GuardianGauntlets(position);
		} else if (tv.getText().toString().equals("Guardian Platelegs")) {
			GuardianPlatelegs(position);
		} else if (tv.getText().toString().equals("Guardian Boots")) {
			GuardianBoots(position);
		} else if (tv.getText().toString().equals("Guardian Shield")) {
			GuardianShield(position);
		} else if (tv.getText().toString().equals("Ancient Helmet")) {
			AncientHelmet(position);
		} else if (tv.getText().toString().equals("Ancient Chestplate")) {
			AncientChestplate(position);
		} else if (tv.getText().toString().equals("Ancient Gauntlets")) {
			AncientGauntlets(position);
		} else if (tv.getText().toString().equals("Ancient Platelegs")) {
			AncientPlatelegs(position);
		} else if (tv.getText().toString().equals("Ancient Boots")) {
			AncientBoots(position);
		} else if (tv.getText().toString().equals("Ancient Shield")) {
			AncientShield(position);
		} else if (tv.getText().toString().equals("Dragon Helmet")) {
			DragonHelmet(position);
		} else if (tv.getText().toString().equals("Dragon Chestplate")) {
			DragonChestplate(position);
		} else if (tv.getText().toString().equals("Dragon Gauntlets")) {
			DragonGauntlets(position);
		} else if (tv.getText().toString().equals("Dragon Platelegs")) {
			DragonPlatelegs(position);
		} else if (tv.getText().toString().equals("Dragon Boots")) {
			DragonBoots(position);
		} else if (tv.getText().toString().equals("Dragon Shield")) {
			DragonShield(position);
		} else if (tv.getText().toString().equals("Forlorn Helmet")) {
			ForlornHelmet(position);
		} else if (tv.getText().toString().equals("Forlorn Chestplate")) {
			ForlornChestplate(position);
		} else if (tv.getText().toString().equals("Forlorn Gauntlets")) {
			ForlornGauntlets(position);
		} else if (tv.getText().toString().equals("Forlorn Platelegs")) {
			ForlornPlatelegs(position);
		} else if (tv.getText().toString().equals("Forlorn Boots")) {
			ForlornBoots(position);
		} else if (tv.getText().toString().equals("Forlorn Shield")) {
			ForlornShield(position);
		} else if (tv.getText().toString().equals("Legendary Helmet")) {
			LegendaryHelmet(position);
		} else if (tv.getText().toString().equals("Legendary Chestplate")) {
			LegendaryChestplate(position);
		} else if (tv.getText().toString().equals("Legendary Gauntlets")) {
			LegendaryGauntlets(position);
		} else if (tv.getText().toString().equals("Legendary Platelegs")) {
			LegendaryPlatelegs(position);
		} else if (tv.getText().toString().equals("Legendary Boots")) {
			LegendaryBoots(position);
		} else if (tv.getText().toString().equals("Legendary Shield")) {
			LegendaryShield(position);
		} else if (tv.getText().toString().equals("Helmet of the Gods")) {
			HelmetoftheGods(position);
		} else if (tv.getText().toString().equals("Chestplate of the Gods")) {
			ChestplateoftheGods(position);
		} else if (tv.getText().toString().equals("Gauntlets of the Gods")) {
			GauntletsoftheGods(position);
		} else if (tv.getText().toString().equals("Platelegs of the Gods")) {
			PlatelegsoftheGods(position);
		} else if (tv.getText().toString().equals("Boots of the Gods")) {
			BootsoftheGods(position);
		} else if (tv.getText().toString().equals("Shield of the Gods")) {
			ShieldoftheGods(position);

			// Spellcaster Armour
		} else if (tv.getText().toString().equals("Novice Hood")) {
			NoviceHood(position);
		} else if (tv.getText().toString().equals("Novice Robe Top")) {
			NoviceRobeTop(position);
		} else if (tv.getText().toString().equals("Novice Gloves")) {
			NoviceGloves(position);
		} else if (tv.getText().toString().equals("Novice Robe Bottom")) {
			NoviceRobeBottom(position);
		} else if (tv.getText().toString().equals("Novice Boots")) {
			NoviceBoots(position);
		} else if (tv.getText().toString().equals("Apprentice Hood")) {
			ApprenticeHood(position);
		} else if (tv.getText().toString().equals("Apprentice Robe Top")) {
			ApprenticeRobeTop(position);
		} else if (tv.getText().toString().equals("Apprentice Gloves")) {
			ApprenticeGloves(position);
		} else if (tv.getText().toString().equals("Apprentice Robe Bottom")) {
			ApprenticeRobeBottom(position);
		} else if (tv.getText().toString().equals("Apprentice Boots")) {
			ApprenticeBoots(position);
		} else if (tv.getText().toString().equals("Journeyman Hood")) {
			JourneymanHood(position);
		} else if (tv.getText().toString().equals("Journeyman Robe Top")) {
			JourneymanRobeTop(position);
		} else if (tv.getText().toString().equals("Journeyman Gloves")) {
			JourneymanGloves(position);
		} else if (tv.getText().toString().equals("Journeyman Robe Bottom")) {
			JourneymanRobeBottom(position);
		} else if (tv.getText().toString().equals("Journeyman Boots")) {
			JourneymanBoots(position);
		} else if (tv.getText().toString().equals("Expert Hood")) {
			ExpertHood(position);
		} else if (tv.getText().toString().equals("Expert Robe Top")) {
			ExpertRobeTop(position);
		} else if (tv.getText().toString().equals("Expert Gloves")) {
			ExpertGloves(position);
		} else if (tv.getText().toString().equals("Expert Robe Bottom")) {
			ExpertRobeBottom(position);
		} else if (tv.getText().toString().equals("Expert Boots")) {
			ExpertBoots(position);
		} else if (tv.getText().toString().equals("Master Hood")) {
			MasterHood(position);
		} else if (tv.getText().toString().equals("Master Robe Top")) {
			MasterRobeTop(position);
		} else if (tv.getText().toString().equals("Master Gloves")) {
			MasterGloves(position);
		} else if (tv.getText().toString().equals("Master Robe Bottom")) {
			MasterRobeBottom(position);
		} else if (tv.getText().toString().equals("Master Boots")) {
			MasterBoots(position);
		} else if (tv.getText().toString().equals("Criistik's Hood")) {
			CriistiksHood(position);
		} else if (tv.getText().toString().equals("Criistik's Robe Top")) {
			CriistiksRobeTop(position);
		} else if (tv.getText().toString().equals("Criistik's Gloves")) {
			CriistiksGloves(position);
		} else if (tv.getText().toString().equals("Criistik's Robe Bottom")) {
			CriistiksRobeBottom(position);
		} else if (tv.getText().toString().equals("Criistik's Boots")) {
			CriistiksBoots(position);
		} else if (tv.getText().toString().equals("Xekith's Hood")) {
			XekithsHood(position);
		} else if (tv.getText().toString().equals("Xekith's Robe Top")) {
			XekithsRobeTop(position);
		} else if (tv.getText().toString().equals("Xekith's Gloves")) {
			XekithsGloves(position);
		} else if (tv.getText().toString().equals("Xekith's Robe Bottom")) {
			XekithsRobeBottom(position);
		} else if (tv.getText().toString().equals("Xekith's Boots")) {
			XekithsBoots(position);
		} else if (tv.getText().toString().equals("Auxatia's Hood")) {
			AuxatiasHood(position);
		} else if (tv.getText().toString().equals("Auxatia's Robe Top")) {
			AuxatiasRobeTop(position);
		} else if (tv.getText().toString().equals("Auxatia's Gloves")) {
			AuxatiasGloves(position);
		} else if (tv.getText().toString().equals("Auxatia's Robe Bottom")) {
			AuxatiasRobeBottom(position);
		} else if (tv.getText().toString().equals("Auxatia's Boots")) {
			AuxatiasBoots(position);
		} else if (tv.getText().toString().equals("Zamirik's Hood")) {
			ZamariksHood(position);
		} else if (tv.getText().toString().equals("Zamarik's Robe Top")) {
			ZamariksRobeTop(position);
		} else if (tv.getText().toString().equals("Zamarik's Gloves")) {
			ZamariksGloves(position);
		} else if (tv.getText().toString().equals("Zamarik's Robe Bottom")) {
			ZamariksRobeBottom(position);
		} else if (tv.getText().toString().equals("Zamarik's Boots")) {
			ZamariksBoots(position);

			// Ranger Armour
		} else if (tv.getText().toString().equals("Leather Cowl")) {
			LeatherCowl(position);
		} else if (tv.getText().toString().equals("Leather Cuirass")) {
			LeatherCuirass(position);
		} else if (tv.getText().toString().equals("Leather Gloves")) {
			LeatherGloves(position);
		} else if (tv.getText().toString().equals("Leather Chaps")) {
			LeatherChaps(position);
		} else if (tv.getText().toString().equals("Leather Boots")) {
			LeatherBoots(position);
		} else if (tv.getText().toString().equals("Studded Leather Cowl")) {
			StuddedCowl(position);
		} else if (tv.getText().toString().equals("Studded Leather Cuirass")) {
			StuddedCuirass(position);
		} else if (tv.getText().toString().equals("Studded Leather Gloves")) {
			StuddedGloves(position);
		} else if (tv.getText().toString().equals("Studded Leather Chaps")) {
			StuddedShaps(position);
		} else if (tv.getText().toString().equals("Studded Leather Boots")) {
			StuddedBoots(position);
		} else if (tv.getText().toString().equals("Corrupted Cowl")) {
			CorruptedCowl(position);
		} else if (tv.getText().toString().equals("Corrupted Cuirass")) {
			CorruptedCuirass(position);
		} else if (tv.getText().toString().equals("Corrupted Gloves")) {
			CorruptedGloves(position);
		} else if (tv.getText().toString().equals("Corrupted Chaps")) {
			CorruptedChaps(position);
		} else if (tv.getText().toString().equals("Corrupted Boots")) {
			CorruptedBoots(position);
		} else if (tv.getText().toString().equals("Demonhide Cowl")) {
			DemonhideCowl(position);
		} else if (tv.getText().toString().equals("Demonhide Cuirass")) {
			DemonhideCuirass(position);
		} else if (tv.getText().toString().equals("Demonhide Gloves")) {
			DemonhideGloves(position);
		} else if (tv.getText().toString().equals("Demonhide Chaps")) {
			DemonhideChaps(position);
		} else if (tv.getText().toString().equals("Demonhide Boots")) {
			DemonhideBoots(position);
		} else if (tv.getText().toString().equals("Darkspawn Cowl")) {
			DarkspawnCowl(position);
		} else if (tv.getText().toString().equals("Darkspawn Cuirass")) {
			DarkspawnCuirass(position);
		} else if (tv.getText().toString().equals("Darkspawn Gloves")) {
			DarkspawnGloves(position);
		} else if (tv.getText().toString().equals("Darkspawn Chaps")) {
			DarkspawnChaps(position);
		} else if (tv.getText().toString().equals("Darkspawn Boots")) {
			DarkspawnBoots(position);
		} else if (tv.getText().toString().equals("Black Dragon Cowl")) {
			BlackDragonCowl(position);
		} else if (tv.getText().toString().equals("Black Dragon Cuirass")) {
			BlackDragonCuirass(position);
		} else if (tv.getText().toString().equals("Black Dragon Gloves")) {
			BlackDragonGloves(position);
		} else if (tv.getText().toString().equals("Black Dragon Chaps")) {
			BlackDragonChaps(position);
		} else if (tv.getText().toString().equals("Black Dragon Boots")) {
			BlackDragonBoots(position);
		} else if (tv.getText().toString().equals("Mystic Cowl")) {
			MysticCowl(position);
		} else if (tv.getText().toString().equals("Mystic Cuirass")) {
			MysticCuirass(position);
		} else if (tv.getText().toString().equals("Mystic Gloves")) {
			MysticGloves(position);
		} else if (tv.getText().toString().equals("Mystic Chaps")) {
			MysticChaps(position);
		} else if (tv.getText().toString().equals("Mystic Boots")) {
			MysticBoots(position);
		} else if (tv.getText().toString().equals("Zanthiir's Cowl")) {
			ZanthiirsCowl(position);
		} else if (tv.getText().toString().equals("Zanthiir's Cuirass")) {
			ZanthiirsCuirass(position);
		} else if (tv.getText().toString().equals("Zanthiir's Gloves")) {
			ZanthiirsGloves(position);
		} else if (tv.getText().toString().equals("Zanthiir's Chaps")) {
			ZanthiirsChaps(position);
		} else if (tv.getText().toString().equals("Zanthiir's Boots")) {
			ZanthiirsBoots(position);
		} else if (tv.getText().toString().equals("Hērō's Cowl")) {
			HerosCowl(position);
		} else if (tv.getText().toString().equals("Hērō's Cuirass")) {
			HerosCuirass(position);
		} else if (tv.getText().toString().equals("Hērō's Gloves")) {
			HerosGloves(position);
		} else if (tv.getText().toString().equals("Hērō's Chaps")) {
			HerosChaps(position);
		} else if (tv.getText().toString().equals("Hērō's Boots")) {
			HerosBoots(position);

			// Potions
		} else if (tv.getText().toString().equals("Minor Health Potion")) {
			MinorHealthPotion(position);
		} else if (tv.getText().toString().equals("Major Health Potion")) {
			MajorHealthPotion(position);
		} else if (tv.getText().toString().equals("Fortify Health Potion")) {
			FortifyHealthPotion(position);
		} else if (tv.getText().toString().equals("Extreme Health Potion")) {
			ExtremeHealthPotion(position);
		} else if (tv.getText().toString().equals("Ultimate Health Potion")) {
			UltimateHealthPotion(position);
		} else if (tv.getText().toString().equals("Minor Mana Potion")) {
			MinorManaPotion(position);
		} else if (tv.getText().toString().equals("Major Mana Potion")) {
			MajorManaPotion(position);
		} else if (tv.getText().toString().equals("Fortify Mana Potion")) {
			FortifyManaPotion(position);
		} else if (tv.getText().toString().equals("Extreme Mana Potion")) {
			ExtremeManaPotion(position);
		} else if (tv.getText().toString().equals("Ultimate Mana Potion")) {
			UltimateManaPotion(position);
		}
	}

	private void HerosGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Hērō's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ZanthiirsGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Zanthiir's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MysticGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Mystic Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void BlackDragonGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Black Dragon Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Black Dragon Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Black Dragon Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DarkspawnGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Darkspawn Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Darkspawn Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Darkspawn Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DemonhideGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Demonhide Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Demonhide Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Demonhide Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void CorruptedGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Corrupted Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Corrupted Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Corrupted Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void StuddedGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Studded Leather Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Studded Leather Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Studded Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void LeatherGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Leather Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Leather Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Leather Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ZamariksGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Zamarik's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AuxatiasGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Auxatia's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void XekithsGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Xekith's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void CriistiksGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Criistik's Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MasterGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Master Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Master Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Master Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ExpertGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Expert Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Expert Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Expert Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void JourneymanGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Journeyman Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Journeyman Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Journeyman Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ApprenticeGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Apprentice Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Apprentice Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Apprentice Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void NoviceGloves(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Novice Gloves");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Novice Gloves");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Novice Gloves equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void GauntletsoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Gauntlets of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Gauntlets of the Gods");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Gauntlets of the Gods equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void LegendaryGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Legendary Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ForlornGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Forlorn Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DragonGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Dragon Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AncientGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Ancient Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void GuardianGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Guardian Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void RunicGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Runic Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OrcishGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Orcish Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ElvenGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Elven Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DwarvenGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Dwarven Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void SteelGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Steel Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void IronGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				dbHands.insertRecord("Iron Gauntlets");
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void BronzeGauntlets(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Gauntlets");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHands.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHands.insertRecord("Bronze Gauntlets");
				dbHands.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Gauntlets equipped to Hands", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void HerosBow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Hērō's Bow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Bow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void ZanthiirsCompositeBow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Composite Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Zanthiir's Composite Bow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Composite Bow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MysticBow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Mystic Bow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Bow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void DragonBow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Bow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Bow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyCrossbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ebony Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ebony Crossbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ebony Crossbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyLongbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ebony Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ebony Longbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ebony Longbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void EbonyShortbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ebony Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ebony Shortbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ebony Shortbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshCrossbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ash Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ash Crossbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ash Crossbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshLongbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ash Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ash Longbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ash Longbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void AshShortbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ash Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ash Shortbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ash Shortbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleCrossbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Maple Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Maple Crossbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Maple Crossbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleLongbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Maple Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Maple Longbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Maple Longbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void MapleShortbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Maple Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Maple Shortbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Maple Shortbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakCrossbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Oak Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Oak Crossbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Oak Crossbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakLongbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Oak Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Oak Longbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Oak Longbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void OakShortbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Oak Shortbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Oak Shortbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Oak Shortbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Crossbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Crossbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Crossbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Crossbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Longbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Longbow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Longbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Longbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void Shortbow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hero's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Shortbow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Shortbow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void UltimateManaPotion(final int position) {

	}

	private void ExtremeManaPotion(final int position) {

	}

	private void FortifyManaPotion(final int position) {

	}

	private void MajorManaPotion(final int position) {

	}

	private void MinorManaPotion(final int position) {

	}

	private void UltimateHealthPotion(final int position) {

	}

	private void ExtremeHealthPotion(final int position) {

	}

	private void FortifyHealthPotion(final int position) {

	}

	private void MajorHealthPotion(final int position) {

	}

	private void MinorHealthPotion(final int position) {

	}

	private void HerosBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Hērō's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	private void HerosChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Hērō's Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HerosCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Hērō's Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HerosCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Hērō's Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Hērō's Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Hērō's Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Zanthiir's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Zanthiir's Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Zanthiir's Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zanthiir's Cuirass");
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZanthiirsCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zanthiir's Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Zanthiir's Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zanthiir's Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zanthiir's Cowl");
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Mystic Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Mystic Boots");
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Mystic Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Mystic Chaps");
				db.close();
				Requery();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Mystic Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Mystic Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MysticCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Mystic Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Mystic Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Mystic Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Mystic Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Black Dragon Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Black Dragon Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Black Dragon Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Black Dragon Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Black Dragon Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Black Dragon Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Black Dragon Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Black Dragon Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Black Dragon Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Black Dragon Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Black Dragon Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Black Dragon Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BlackDragonCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Black Dragon Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Black Dragon Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Black Dragon Cowl Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Black Dragon Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Darkspawn Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Darkspawn Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Darkspawn Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Darkspawn Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Darkspawn Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Darkspawn Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Darkspawn Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Darkspawn Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Darkspawn Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Darkspawn Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Darkspawn Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Darkspawn Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DarkspawnCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Darkspawn Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Darkspawn Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Darkspawn Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Darkspawn Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Demonhide Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Demonhide Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Demonhide Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Demonhide Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Demonhide Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Demonhide Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Demonhide Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Demonhide Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Demonhide Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Demonhide Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Demonhide Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Demonhide Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DemonhideCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Demonhide Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Demonhide Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Demonhide Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Demonhide Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Corrupted Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Corrupted Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Corrupted Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Corrupted Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Corrupted Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Corrupted Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Corrupted Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Corrupted Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Corrupted Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Corrupted Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Corrupted Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Corrupted Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CorruptedCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Corrupted Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Corrupted Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Corrupted Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Corrupted Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Studded Leather Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Studded Leather Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Studded Leather Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Studded Leather Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedShaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Studded Leather Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Studded Leather Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Studded Leather Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Studded Leather Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Studded Leather Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Studded Leather Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Studded Leather Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Studded Leather Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StuddedCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Studded Leather Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Studded Leather Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Studded Leather Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Studded Leather Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Leather Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Leather Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Leather Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Leather Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherChaps(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Leather Chaps");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Leather Chaps");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Leather Chaps equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Leather Chaps");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherCuirass(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Leather Cuirass");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Leather Cuirass");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Leather Cuirass equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Leather Cuirass");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LeatherCowl(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Leather Cowl");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Leather Cowl");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Leather Cowl equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Leather Cowl");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Zamarik's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zamarik's Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Zamarik's Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zamarik's Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Zamarik's Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zamarik's Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Zamarik's Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zamarik's Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Auxatia's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Auxatia's Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Auxatia's Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Auxatia's Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Auxatia's Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Auxatia's Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Auxatia's Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Xekith's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Xekith's Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Xekith's Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Xekith's Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Xekith's Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Xekith's Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Xekith's Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Xekith's Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Criistik's Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Criistik's Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Criistik's Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Criistik's Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Criistik's Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Criistik's Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Criistik's Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Criistik's Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Master Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Master Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Master Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Master Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Master Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Master Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Master Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Master Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Master Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Master Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Master Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Master Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void MasterHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Master Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Master Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Master Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Master Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Expert Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Expert Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Expert Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Expert Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Expert Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Expert Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Expert Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Expert Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Expert Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Expert Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Expert Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Expert Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ExpertHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Expert Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Expert Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Expert Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Expert Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Journeyman Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Journeyman Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Journeyman Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Journeyman Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Journeyman Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Journeyman Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Journeyman Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Journeyman Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Journeyman Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Journeyman Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Journeyman Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Journeyman Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void JourneymanHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Journeyman Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Journeyman Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Journeyman Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Journeyman Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Apprentice Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Apprentice Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Apprentice Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Apprentice Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Apprentice Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Apprentice Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Apprentice Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Apprentice Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Apprentice Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Apprentice Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Apprentice Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Apprentice Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ApprenticeHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Apprentice Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Apprentice Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Apprentice Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Apprentice Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Novice Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Novice Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Novice Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Novice Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceRobeBottom(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Novice Robe Bottom");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Novice Robe Bottom");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Novice Robe Bottom equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Novice Robe Bottom");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceRobeTop(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Novice Robe Top");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Novice Robe Top");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Novice Robe Top equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Novice Robe Top");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void NoviceHood(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Novice Hood");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Novice Hood");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Novice Hood equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Novice Hood");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ShieldoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Shield of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Shield of the Gods");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Shield of the Gods equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Shield of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BootsoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Boots of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Boots of the Gods");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Boots of the Gods equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Boots of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void PlatelegsoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Platelegs of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Platelegs of the Gods");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Platelegs of the Gods equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Platelegs of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ChestplateoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Chestplate of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Chestplate of the Gods");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Chestplate of the Gods equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Chestplate of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void HelmetoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Helmet of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Helmet of the Gods");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Helmet of the Gods equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Helmet of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Legendary Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Legendary Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Legendary Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Legendary Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Legendary Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Forlorn Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Forlorn Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Forlorn Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Forlorn Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Forlorn Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Dragon Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Dragon Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Dragon Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Dragon Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Dragon Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Ancient Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Ancient Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Ancient Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Ancient Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Ancient Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Guardian Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Guardian Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Guardian Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Guardian Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Guardian Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Runic Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Runic Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Runic Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Runic Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Runic Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Orcish Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Orcish Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Orcish Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Orcish Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Orcish Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Elven Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Elven Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Elven Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenChesplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Elven Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Elven Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Dwarven Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Dwarven Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Dwarven Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Dwarven Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Dwarven Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Steel Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Steel Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Boots equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Steel Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Platelegs equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Steel Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Steel Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Iron Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Iron Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronPlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Iron Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Iron Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Iron Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeShield(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Shield");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbSH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbSH.insertRecord("Bronze Shield");
				dbSH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Shield equipped to Secondary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Shield");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeBoots(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Boots");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbFeet.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbFeet.insertRecord("Bronze Boots");
				dbFeet.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Boots equipped to Feet", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Boots");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzePlatelegs(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Platelegs");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbLegs.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbLegs.insertRecord("Bronze Platelegs");
				dbLegs.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Platelegs equipped to Legs", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Platelegs");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeChestplate(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Chestplate");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbChest.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbChest.insertRecord("Bronze Chestplate");
				dbChest.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Chestplate equipped to Chest", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Chestplate");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeHelmet(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Helmet");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbHead.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbHead.insertRecord("Bronze Helmet");
				dbHead.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Helmet equipped to Head", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Helmet");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ZamariksScepter(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Zamarik's Scepter");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Zamarik's Scepter");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Zamarik's Scepter equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Zamarik's Scepter");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AuxatiasBattlestaff(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Auxatia's Battlestaff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Auxatia's Battlestaff");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Auxatia's Battlestaff equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Auxatia's Battlestaff");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void XekithsWand(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Xekith's Wand");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Xekith's Wand");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Xekith's Wand equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Xekith's Wand");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void CriistiksStaff(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Criistik's Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Criistik's Staff");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Criistik's Staff equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Criistik's Staff");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SwordoftheGods(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Sword of the Gods");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Sword of the Gods");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Sword of the Gods equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Sword of the Gods");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void LegendaryBlade(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Legendary Blade");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Legendary Blade");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Legendary Blade equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Legendary Blade");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ForlornHope(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Forlorn Hope");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Forlorn Hope");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Forlorn Hope equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Forlorn Hope");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DragonDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dragon Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dragon Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dragon Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dragon Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ancient Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ancient Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ancient Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ancient Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void AncientDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Ancient Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Ancient Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Ancient Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Ancient Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Guardian Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Guardian Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Guardian Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Guardian Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void GuardianDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Guardian Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Guardian Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Guardian Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Guardian Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Runic Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Runic Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Runic Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Runic Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void RunicDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Runic Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Runic Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Runic Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Runic Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Orcish Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Orcish Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Orcish Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Orcish Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void OrcishDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Orcish Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Orcish Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Orcish Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Orcish Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Elven Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Elven Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Elven Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Elven Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void ElvenDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Elven Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Elven Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Elven Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Elven Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dwarven Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dwarven Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dwarven Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dwarven Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void DwarvenDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Dwarven Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Dwarven Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Dwarven Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Dwarven Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Steel Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Steel Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Steel Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Steel Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void SteelDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Steel Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Steel Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Steel Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Steel Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Iron Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Iron Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Iron Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Iron Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void IronDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Iron Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Iron Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Iron Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Iron Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeGreatsword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Greatsword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Bronze Greatsword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Greatsword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Greatsword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeMace(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Mace");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Bronze Mace");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Mace equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Mace");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeAxe(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Axe");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Bronze Axe");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Axe equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Axe");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Bronze Sword");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Sword");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void BronzeDagger(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Bronze Dagger");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Bronze Dagger");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Bronze Dagger equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Bronze Dagger");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterBow(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Starter Bow");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Starter Bow");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Starter Bow equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Starter Bow");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterStaff(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Starter Staff");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Starter Staff");
				dbPH.close();
				Requery();
				Toast msg = Toast.makeText(Inventory.this, "Starter Staff equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ListAdapter adapter = getListAdapter();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				// db.deleteContact("Starter Staff");
				db.close();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();

	}

	private void StarterSword(final int position) {
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
		dlgAlert.setTitle("Starter Sword");
		dlgAlert.setMessage("What would you like to do?");
		dlgAlert.setPositiveButton("Equip", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
                ListAdapter adapter = getListAdapter();
                dbPH.open();
				db.open();
				db.deleteContact(adapter.getItemId(position));
				db.close();
				dbPH.insertRecord("Starter Sword");
				dbPH.close();
				Toast msg = Toast.makeText(Inventory.this, "Starter Sword equipped to Primary Hand", Toast.LENGTH_SHORT);
				msg.show();
				Requery();
				dialog.dismiss();
			}
		});
		dlgAlert.setNegativeButton("Destroy", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Inventory.this);
				dlgAlert.setTitle("Attention");
				dlgAlert.setMessage("Are you sure?");
				dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						ListAdapter adapter = getListAdapter();
						db.open();
						db.deleteContact(adapter.getItemId(position));
						db.close();
						Requery();
						dialog.dismiss();
					}
				});
				dlgAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				dlgAlert.setCancelable(true);
				dlgAlert.create().show();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent PlayScreen = new Intent(getApplicationContext(), PlayScreen.class);
		startActivity(PlayScreen);
		finish();
	}
}
