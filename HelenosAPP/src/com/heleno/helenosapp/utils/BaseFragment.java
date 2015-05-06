package com.heleno.helenosapp.utils;

import android.app.Fragment;

public abstract class BaseFragment extends Fragment {

	public void configurarFragment(){
		recuperarID();
		formatarFonte();
		definirAcao();
	}
	
	public abstract void recuperarID();
	
	public abstract void formatarFonte();
	
	public abstract void definirAcao();

}
