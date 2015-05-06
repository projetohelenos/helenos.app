package com.heleno.helenosapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.heleno.helenosapp.R;
import com.heleno.helenosapp.utils.BaseActivity;
import com.heleno.helenosapp.utils.BaseFont;

public class SplashActivity extends BaseActivity {

	private TextView txtAppName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);	
		
		configurarActivity();
		esconderActionBar();
		handlerSplash();
	}
	
	@Override
	public void recuperarID() {
		txtAppName = (TextView) findViewById(R.id.txtAppName);
	}	

	@Override
	public void formatarFonte() {
		txtAppName.setTypeface(BaseFont.light(this));
	}
	
	@Override
	public void definirAcao() {

	}
	
	private void handlerSplash(){
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				finish();
			}
		}, 2000);
	}




}
