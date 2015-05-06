package com.heleno.helenosapp.model;

import java.util.ArrayList;

import android.content.Context;

import com.heleno.helenosapp.R;

public class Menu {

	private int icon;
	private String nome;
	
	public Menu(int icon, String nome){
		this.icon = icon;
		this.nome = nome;
	}
	
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static ArrayList<Menu> getMenus(Context context){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu(R.drawable.ic_launcher, "Registrar ponto"));
		return menus;
	}
	
	public static ArrayList<Menu> getMenus2(Context context){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu(R.drawable.ic_entrada, "07:30 - Esqueci de bater o ponto."));
		menus.add(new Menu(R.drawable.ic_saida, "07:30 - Esqueci de bater o ponto."));
		menus.add(new Menu(R.drawable.ic_entrada, "07:30 - Esqueci de bater o ponto."));
		menus.add(new Menu(R.drawable.ic_saida, "07:30 - Esqueci de bater o ponto."));
		return menus;
	}
}