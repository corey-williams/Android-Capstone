package com.Logik.dawn.of.ages;

import com.Logik.dawn.of.ages.R.drawable;

import Fragments.Fragment_Amulets;
import Fragments.Fragment_Melee;
import Fragments.Fragment_Potions;
import Fragments.Fragment_Ranged;
import Fragments.Fragment_Rings;
import Fragments.Fragment_Special;
import Fragments.Fragment_Spellcaster;
import TabPagerAdapter.TabsPagerAdapter;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class Shop extends FragmentActivity {

	private ViewPager pager;
	private TabsPagerAdapter mTabsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		pager = new ViewPager(this);
		pager.setId(R.id.pager);
		setContentView(pager);

		final ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
		bar.setLogo(drawable.shop_logo);

		mTabsAdapter = new TabsPagerAdapter(this, pager);
		mTabsAdapter.addTab(bar.newTab().setText("Melee"), Fragment_Melee.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Spellcaster"), Fragment_Spellcaster.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Ranged"), Fragment_Ranged.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Potions"), Fragment_Potions.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Amulets"), Fragment_Amulets.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Rings"), Fragment_Rings.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("∞"), Fragment_Special.class, null);
	}

	@Override
	public void onBackPressed() {
		Intent Equipment = new Intent(getApplicationContext(), PlayScreen.class);
		startActivity(Equipment);
		finish();
		super.onBackPressed();
	}
	
	
}
