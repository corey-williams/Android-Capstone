package Fragments;

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
import android.os.Bundle;
import android.support.v4.app.ListFragment;
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

public class Fragment_Special extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		/*-------------------------------------------------------------------------------*
		 ********************************* View Inflator *********************************
		 *-------------------------------------------------------------------------------*/

		View rootView = inflater.inflate(R.layout.fragment_special, container, false);
		setHasOptionsMenu(true);
		/*-------------------------------------------------------------------------------*
		 ****************************** Variable Declaration *****************************
		 *-------------------------------------------------------------------------------*/

		final DBAdapter db = new DBAdapter(getActivity());
		final DBAdapter_Gold dbGold = new DBAdapter_Gold(getActivity());

		final TextView textViewShopGoldValue1 = (TextView) rootView.findViewById(R.id.textViewShopGoldValue1);
		final ListView SpecialArmourList = (ListView) rootView.findViewById(R.id.specialArmourList);
		final ListView SpecialWeaponsList = (ListView) rootView.findViewById(R.id.specialWeaponsList);
		final RadioButton rdoSpecialArmour = (RadioButton) rootView.findViewById(R.id.radioSpecialArmour);
		final RadioButton rdoSpecialWeapons = (RadioButton) rootView.findViewById(R.id.radioSpecialWeapons);

		listSpecialCheck(rdoSpecialArmour, rdoSpecialWeapons, SpecialArmourList, SpecialWeaponsList);
		
		/*-------------------------------------------------------------------------------*
		 ******************************* In-App Armour List ******************************
		 *-------------------------------------------------------------------------------*/

		String InAppPurchaseArmour;
		List<HashMap<String, String>> SpecialArmourData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "-~- Specialty Armour -~-");
			temp.put("Requirements", "Class: Any");
			SpecialArmourData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(∞) Infinity Armour Set");
			temp1.put("Requirements", "$1");
			SpecialArmourData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(∞) Chaos Armour Set");
			temp2.put("Requirements", "$3");
			SpecialArmourData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(∞) Ultimate Armour Set");
			temp3.put("Requirements", "$5");
			SpecialArmourData.add(temp3);
		}
		SimpleAdapter SpecialArmourAdapter = new SimpleAdapter(getActivity(), SpecialArmourData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		SpecialArmourList.setAdapter(SpecialArmourAdapter);
		
		/*-------------------------------------------------------------------------------*
		 *************************** In-App Armour List Handler **************************
		 *-------------------------------------------------------------------------------*/

		SpecialArmourList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// Infinity Armour (set)

					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
					dlgAlert.setMessage("The Infinity Armour Set is available via $1 in-app purchase.");
					dlgAlert.setTitle("Infinity Armour Set");
					dlgAlert.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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
					// Gravity Armour (set)

					AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(getActivity());
					dlgAlert2.setMessage("The Chaos Armour Set is available via $3 in-app purchase.");
					dlgAlert2.setTitle("Chaos Armour Set");
					dlgAlert2.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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
					// Ultimate Armour (set)

					AlertDialog.Builder dlgAlert3 = new AlertDialog.Builder(getActivity());
					dlgAlert3.setMessage("The Ultimate Armour Set is available via $5 in-app purchase.");
					dlgAlert3.setTitle("Ultimate Armour Set");
					dlgAlert3.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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
				}
			}
		});

		/*-------------------------------------------------------------------------------*
		 ****************************** In-App Weapons List ******************************
		 *-------------------------------------------------------------------------------*/
		
		String InAppPurchaseWeapons;
		List<HashMap<String, String>> SpecialWeaponsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Special Weapons ---");
			temp.put("Requirements", "Class: Any");
			SpecialWeaponsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(∞) Sword of a Thousand Truths");
			temp1.put("Requirements", "$2");
			SpecialWeaponsData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(∞) Scythe of Destiny");
			temp2.put("Requirements", "$1");
			SpecialWeaponsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(∞) Infinity Blade");
			temp3.put("Requirements", "$2");
			SpecialWeaponsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(∞) Dragon Soul Staff");
			temp4.put("Requirements", "$1");
			SpecialWeaponsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(∞) Dark Bow, Light Bow");
			temp5.put("Requirements", "$2");
		}

		SimpleAdapter SpecialWeaponsAdapter = new SimpleAdapter(getActivity(), SpecialWeaponsData, R.layout.custom_row_view, new String[] { "Item",
				"Requirements" }, new int[] { R.id.text1, R.id.text2 });

		SpecialWeaponsList.setAdapter(SpecialWeaponsAdapter);
		
		/*-------------------------------------------------------------------------------*
		 *************************** In-App Weapons List Handler *************************
		 *-------------------------------------------------------------------------------*/

		SpecialWeaponsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// (50G) Novice Hood
					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

					dlgAlert.setMessage("The Sword of a Thousand Truths is available via $2 in-app purchase.");
					dlgAlert.setTitle("Sword of a Thousand Truths");
					dlgAlert.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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

					dlgAlert2.setMessage("The Scythe of Destiny is available via $1 in-app purchase.");
					dlgAlert2.setTitle("Scythe of Destiny");
					dlgAlert2.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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

					dlgAlert3.setMessage("The Infinity Blade is available via $2 in-app purchase.");
					dlgAlert3.setTitle("Infinity Blade");
					dlgAlert3.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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

					dlgAlert4.setMessage("The Dragon-fire Staff is available via $1 in-app purchase.");
					dlgAlert4.setTitle("Shop");
					dlgAlert4.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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

					dlgAlert5.setMessage("The Dark Bow & Light Bow are available via $2 in-app purchase. ");
					dlgAlert5.setTitle("Dark Bow & Lighht Bow");
					dlgAlert5.setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

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
				}
			}
		});

		return rootView;
	}

	private void listSpecialCheck(final RadioButton rdoSpecialArmour, final RadioButton rdoSpecialWeapons, final ListView SpecialArmourList,
			final ListView SpecialWeaponsList) {
		
		rdoSpecialArmour.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoSpecialArmour.isChecked() == true) {
					rdoSpecialWeapons.setChecked(false);
					
					SpecialArmourList.setVisibility(View.VISIBLE);
					SpecialWeaponsList.setVisibility(View.INVISIBLE);
				}
			}
		});
		 
		rdoSpecialWeapons.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoSpecialWeapons.isChecked() == true) {
					rdoSpecialArmour.setChecked(false);
					
					SpecialArmourList.setVisibility(View.INVISIBLE);
					SpecialWeaponsList.setVisibility(View.VISIBLE);
				}
			}
		});
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
