package com.heleno.helenosapp.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heleno.helenosapp.R;
import com.heleno.helenosapp.model.Menu;
import com.heleno.helenosapp.utils.BaseFont;

public class DrawerAdapter extends ArrayAdapter<Menu>{

	private Context context;
	private int resource;
	private ArrayList<Menu> menus;
	private ViewHolder holder;
	private Menu menu;
	
	public DrawerAdapter(Context context, int resource, ArrayList<Menu> menus) {
		super(context, resource, menus);
		
		this.context = context;
		this.resource = resource;
		this.menus = menus;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
	
		if(view == null){
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			holder = new ViewHolder();
			view = inflater.inflate(resource, parent, false);
			holder.nome = (TextView) view.findViewById(R.id.txtNomeMenu);
			holder.icon = (ImageView) view.findViewById(R.id.imageViewIcon);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		
		menu = (Menu) this.menus.get(position);
		holder.icon.setImageDrawable(context.getResources().getDrawable(menu.getIcon()));
		holder.nome.setText(menu.getNome());
		holder.nome.setTypeface(BaseFont.light(context));
		
		return view;
	}
	
	private static class ViewHolder {
		TextView nome;
		ImageView icon;
	}

}
