package Fragments;

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

public class Fragment_Potions extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		/*-------------------------------------------------------------------------------*
		 ********************************* View Inflator *********************************
		 *-------------------------------------------------------------------------------*/

		View rootView = inflater.inflate(R.layout.fragment_potions, container, false);
		setHasOptionsMenu(true);
		/*-------------------------------------------------------------------------------
		 ****************************** Variable Declaration *****************************
		 *-------------------------------------------------------------------------------*/

		final DBAdapter db = new DBAdapter(getActivity());
		final DBAdapter_Gold dbGold = new DBAdapter_Gold(getActivity());

		final TextView textViewShopGoldValue1 = (TextView) rootView.findViewById(R.id.textViewShopGoldValue1);
		final ListView HealthPotionsList = (ListView) rootView.findViewById(R.id.healthPotionsList);
		final ListView MagicPotionsList = (ListView) rootView.findViewById(R.id.magicPotionsList);
		final RadioButton rdoHealth = (RadioButton) rootView.findViewById(R.id.radioHealth);
		final RadioButton rdoMana = (RadioButton) rootView.findViewById(R.id.radioMana);

		listPotionsCheck(rdoHealth, rdoMana, HealthPotionsList, MagicPotionsList);

		String HealthPotions;
		List<HashMap<String, String>> HealthPotionsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Health Potions ---");
			temp.put("Info", "Class: Any");
			HealthPotionsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(50G) Minor Health Potion");
			temp1.put("Info", "Health +10");
			HealthPotionsData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(150G) Major Health Potion");
			temp2.put("Info", "Health +50");
			HealthPotionsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(100G) Fortify Health Potion");
			temp3.put("Info", "Health +75%");
			HealthPotionsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(50G) Extreme Health Potion");
			temp4.put("Info", "Health +100");
			HealthPotionsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(1.5K) Ultimate Health Potion");
			temp5.put("Info", "Health +500");
			HealthPotionsData.add(temp5);
		}

		SimpleAdapter HealthPotionsAdapter = new SimpleAdapter(getActivity(), HealthPotionsData, R.layout.custom_row_view, new String[] { "Item",
				"Info" }, new int[] { R.id.text1, R.id.text2 });

		HealthPotionsList.setAdapter(HealthPotionsAdapter);

		HealthPotionsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
					dlgAlert.setMessage("Purchase Minor Health Potion?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 10) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 10;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(getActivity());
					dlgAlert2.setMessage("Purchase Major Health Potion?");
					dlgAlert2.setTitle("Shop");
					dlgAlert2.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert3 = new AlertDialog.Builder(getActivity());
					dlgAlert3.setMessage("Purchase Fortify Health Potion?");
					dlgAlert3.setTitle("Shop");
					dlgAlert3.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 100) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert4 = new AlertDialog.Builder(getActivity());
					dlgAlert4.setMessage("Purchase Extreme Health Potion?");
					dlgAlert4.setTitle("Shop");
					dlgAlert4.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert5 = new AlertDialog.Builder(getActivity());
					dlgAlert5.setMessage("Purchase Ultimate Health Potion?");
					dlgAlert5.setTitle("Shop");
					dlgAlert5.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 500;
								textViewShopGoldValue1.setText("" + gold1);
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
				}
			}
		});

		String ManaPotions;
		List<HashMap<String, String>> ManaPotionsData = new ArrayList<HashMap<String, String>>();
		{
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("Item", "--- Mana Potions ---");
			temp.put("Info", "Class: Any");
			ManaPotionsData.add(temp);
			HashMap<String, String> temp1 = new HashMap<String, String>();
			temp1.put("Item", "(50G) Minor Mana Potion");
			temp1.put("Info", "Mana +10");
			ManaPotionsData.add(temp1);
			HashMap<String, String> temp2 = new HashMap<String, String>();
			temp2.put("Item", "(150G) Major Mana Potion");
			temp2.put("Info", "Mana +50");
			ManaPotionsData.add(temp2);
			HashMap<String, String> temp3 = new HashMap<String, String>();
			temp3.put("Item", "(100G) Fortify Mana Potion");
			temp3.put("Info", "Mana +75%");
			ManaPotionsData.add(temp3);
			HashMap<String, String> temp4 = new HashMap<String, String>();
			temp4.put("Item", "(50G) Extreme Mana Potion");
			temp4.put("Info", "Mana +100");
			ManaPotionsData.add(temp4);
			HashMap<String, String> temp5 = new HashMap<String, String>();
			temp5.put("Item", "(1.5K) Ultimate Mana Potion");
			temp5.put("Info", "Mana +500");
			ManaPotionsData.add(temp5);
		}

		SimpleAdapter ManaPotionsAdapter = new SimpleAdapter(getActivity(), ManaPotionsData, R.layout.custom_row_view,
				new String[] { "Item", "Info" }, new int[] { R.id.text1, R.id.text2 });

		MagicPotionsList.setAdapter(ManaPotionsAdapter);

		MagicPotionsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				switch (position) {
				case 1:
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
					dlgAlert.setMessage("Purchase Minor Mana Potion?");
					dlgAlert.setTitle("Shop");
					dlgAlert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 10) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 10;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(getActivity());
					dlgAlert2.setMessage("Purchase Major Mana Potion?");
					dlgAlert2.setTitle("Shop");
					dlgAlert2.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 50) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 50;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert3 = new AlertDialog.Builder(getActivity());
					dlgAlert3.setMessage("Purchase Fortify Mana Potion?");
					dlgAlert3.setTitle("Shop");
					dlgAlert3.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 100) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 100;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert4 = new AlertDialog.Builder(getActivity());
					dlgAlert4.setMessage("Purchase Extreme Mana Potion?");
					dlgAlert4.setTitle("Shop");
					dlgAlert4.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 250) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 250;
								textViewShopGoldValue1.setText("" + gold1);
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
					// (100G) Bronze Helmet

					AlertDialog.Builder dlgAlert5 = new AlertDialog.Builder(getActivity());
					dlgAlert5.setMessage("Purchase Ultimate Mana Potion?");
					dlgAlert5.setTitle("Shop");
					dlgAlert5.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							removeInt();
							if (Integer.parseInt(textViewShopGoldValue1.getText().toString()) >= 500) {
								int gold1 = Integer.parseInt(textViewShopGoldValue1.getText().toString()) - 500;
								textViewShopGoldValue1.setText("" + gold1);
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
				}
			}
		});

		return rootView;
	}

	private void listPotionsCheck(final RadioButton rdoHealth, final RadioButton rdoMana, final ListView HealthPotionsList,
			final ListView MagicPotionsList) {

		rdoHealth.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoHealth.isChecked() == true) {
					rdoMana.setChecked(false);

					HealthPotionsList.setVisibility(View.VISIBLE);
					MagicPotionsList.setVisibility(View.INVISIBLE);
				}
			}
		});

		rdoMana.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdoMana.isChecked() == true) {
					rdoHealth.setChecked(false);

					HealthPotionsList.setVisibility(View.INVISIBLE);
					MagicPotionsList.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private void removeInt() {

	}

	private void replaceInt() {

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

	public void DisplayRecordGold(Cursor c) {
		TextView textViewShopGoldValue1 = (TextView) getView().findViewById(R.id.textViewShopGoldValue1);
		textViewShopGoldValue1.setText(c.getString(1).toString());
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
