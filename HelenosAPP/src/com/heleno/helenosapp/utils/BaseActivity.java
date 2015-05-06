package com.heleno.helenosapp.utils;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.heleno.helenosapp.R;

public abstract class BaseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		configurarActionBar();
	}

	public void configurarActivity() {
		recuperarID();
		formatarFonte();
		definirAcao();
	}

	public void esconderActionBar() {
		getSupportActionBar().hide();
	}

	public void tituloActionBar(String title) {
		getSupportActionBar().setTitle(title);
	}

	private void configurarActionBar() {
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.vermelho)));
	}
	
	public abstract void recuperarID();
	
	public abstract void formatarFonte();
	
	public abstract void definirAcao();

}
