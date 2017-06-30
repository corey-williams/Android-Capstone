package Fragments;

import com.Logik.dawn.of.ages.Equipment;
import com.Logik.dawn.of.ages.Inventory;
import com.Logik.dawn.of.ages.R;
import com.Logik.dawn.of.ages.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Rings extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_rings, container, false);
		setHasOptionsMenu(true);
		return rootView;
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
