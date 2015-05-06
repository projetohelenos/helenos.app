package com.heleno.helenosapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonRectangle;
import com.heleno.helenosapp.R;
import com.heleno.helenosapp.utils.BaseActivity;
import com.heleno.helenosapp.utils.BaseFont;

public class LoginActivity extends BaseActivity {

	private EditText edtLogin;
	private EditText edtSenha;
	private ButtonRectangle btnAcessar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		esconderActionBar();
		configurarActivity();
		
		//Teste
		
		
	}

	@Override
	public void recuperarID() {
		edtLogin = (EditText) findViewById(R.id.edtLogin);
		edtSenha = (EditText) findViewById(R.id.edtSenha);
		btnAcessar = (ButtonRectangle) findViewById(R.id.btnAcessar);
	}

	@Override
	public void formatarFonte() {
		edtLogin.setTypeface(BaseFont.light(this));
		edtSenha.setTypeface(BaseFont.light(this));
		btnAcessar.setTypeface(BaseFont.light(this));		
	
		//edtLogin.setBackgroundResource(R.drawable.helenotheme_edit_text_holo_light);
		//edtSenha.setBackgroundResource(R.drawable.helenotheme_edit_text_holo_light);
	}

	@Override
	public void definirAcao() {
		btnAcessar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, ManagerActivity.class));
			}
		});
	}
		

}
