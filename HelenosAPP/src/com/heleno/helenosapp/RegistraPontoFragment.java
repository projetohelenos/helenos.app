package com.heleno.helenosapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;
import com.heleno.helenosapp.adapter.RegistroPontoAdapter;
import com.heleno.helenosapp.model.Registro;
import com.heleno.helenosapp.utils.BaseFont;
import com.heleno.helenosapp.utils.BaseFragment;

public class RegistraPontoFragment extends BaseFragment {

	private View view;

	private TextView txtDiaDataHora;
	private ButtonFloat btnAdd;

	private ListView lstHorarios;
	private RegistroPontoAdapter registroAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_registra_ponto, container, false);

		configurarFragment();
		configurarAdapter();

		return view;
	}

	@Override
	public void recuperarID() {
		txtDiaDataHora = (TextView) view.findViewById(R.id.txtDiaDataHora);
		lstHorarios = (ListView) view.findViewById(R.id.lstHorarios);
		btnAdd = (ButtonFloat) view.findViewById(R.id.btnAdd);
	}

	@Override
	public void formatarFonte() {
		txtDiaDataHora.setTypeface(BaseFont.light(getActivity()));
		btnAdd.setBackgroundColor(getResources().getColor(R.color.vermelho));
	}

	@Override
	public void definirAcao() {
		lstHorarios.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getActivity(), "position -> "+position, Toast.LENGTH_LONG).show();
			}
		});
	}

	private void configurarAdapter() {
		registroAdapter = new RegistroPontoAdapter(getActivity(), R.layout.custom_listview_horario,Registro.getRegistros());
		lstHorarios.setAdapter(registroAdapter);
	}

}
