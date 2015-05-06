package com.heleno.helenosapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.heleno.helenosapp.adapter.DrawerAdapter;
import com.heleno.helenosapp.model.Menu;
import com.heleno.helenosapp.utils.BaseActivity;

public class ManagerActivity extends BaseActivity {
	
	private DrawerLayout drawerLayout;
	private DrawerAdapter drawerAdapter;
	private ActionBarDrawerToggle drawerToggle;
	private ListView listViewMenu;
	
	private Fragment fragment;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager);
		
		configurarActivity();
		configurarActionBar();
		configurarDrawer();
		configurarAdapter();
		
	}

	@Override
	public void recuperarID() {
		listViewMenu = (ListView) findViewById(R.id.left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	}

	@Override
	public void formatarFonte() {
		
	}

	@Override
	public void definirAcao() {
		listViewMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					drawerLayout.closeDrawer(listViewMenu);
					selecionaFragment(position);
			}
		});
	}
	
	private void configurarActionBar(){
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_launcher);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);		
	}
	
	private void configurarAdapter() {
		drawerAdapter = new DrawerAdapter(this,	R.layout.custom_listview_menu, Menu.getMenus(this));
		listViewMenu.setAdapter(drawerAdapter);
	}
	
	private void configurarDrawer() {
		drawerToggle = new ActionBarDrawerToggle(this,drawerLayout, 0,0);
		drawerLayout.setDrawerListener(drawerToggle);
	}	

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}		
		return false;
	}

	private void selecionaFragment(final int position){
		
		switch (position) {
			case 0:
				fragment = new RegistraPontoFragment();
				break;	
	
			default:
				break;
		}

		if (fragment != null) {
			
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					inflaFragment(position);
				}
			}, 250);

		} else {
			
		}
	}	
	private void inflaFragment(int position) {
		drawerLayout.closeDrawer(listViewMenu);
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		listViewMenu.setItemChecked(position, true);
		listViewMenu.setSelection(position);
	}
}
