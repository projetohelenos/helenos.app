package com.heleno.helenosapp.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heleno.helenosapp.R;
import com.heleno.helenosapp.model.Registro;
import com.heleno.helenosapp.model.TipoRegistro;
import com.heleno.helenosapp.utils.BaseFont;

public class RegistroPontoAdapter extends ArrayAdapter<Registro>{

	private Context context;
	private int resource;
	private ArrayList<Registro> registros;
	private ViewHolder holder;
	private Registro registro;
	
	public RegistroPontoAdapter(Context context, int resource, ArrayList<Registro> registros) {
		super(context, resource, registros);
		
		this.context = context;
		this.resource = resource;
		this.registros = registros;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
	
		if(view == null){
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			holder = new ViewHolder();
			view = inflater.inflate(resource, parent, false);
			holder.txtHorario = (TextView) view.findViewById(R.id.txtHorario);
			holder.txtTipo = (TextView) view.findViewById(R.id.txtTipo);
			holder.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		
		registro = (Registro) this.registros.get(position);
		holder.imgIcon.setImageDrawable(getIcon(registro.getTipo()));
		holder.txtTipo.setText(getTipo(registro.getTipo()));
		holder.txtHorario.setText(registro.getHorario().concat(" - ").concat(registro.getDescricao()));
		holder.txtHorario.setTypeface(BaseFont.light(context));
		holder.txtTipo.setTypeface(BaseFont.light(context));
		
		return view;
	}
	
	private static class ViewHolder {
		TextView txtHorario;
		TextView txtTipo;
		ImageView imgIcon;
	}
	
	private Drawable getIcon(int tipo){
				
		Drawable drawable=null;
		
		if(TipoRegistro.ENTRADA == tipo){
			drawable = context.getResources().getDrawable(R.drawable.ic_entrada);
		}
		
		if(TipoRegistro.SAIDA == tipo){
			drawable = context.getResources().getDrawable(R.drawable.ic_saida);
		}
		
		if(TipoRegistro.EVENTUAL == tipo){
			drawable = context.getResources().getDrawable(R.drawable.ic_saida);
		}
		
		return drawable;
		
	}
	
	private String getTipo(int tipo){
		
		String tipoR = null;
		
		if(TipoRegistro.ENTRADA == tipo){
			tipoR = "Entrada";
		}
		
		if(TipoRegistro.SAIDA == tipo){
			tipoR = "Saída";
		}
		
		if(TipoRegistro.EVENTUAL == tipo){
			tipoR = "Eventual";
		}
		
		return tipoR;
	}

}
