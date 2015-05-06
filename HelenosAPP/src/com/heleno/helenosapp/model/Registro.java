package com.heleno.helenosapp.model;

import java.util.ArrayList;
import java.util.List;

public class Registro {

	private int tipo;
	private String horario;
	private String descricao;

	public Registro(int tipo, String horario, String descricao){
		this.tipo = tipo;
		this.horario = horario;
		this.descricao = descricao;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static ArrayList<Registro> getRegistros(){
		ArrayList<Registro> registros = new ArrayList<Registro>();
		registros.add(new Registro(TipoRegistro.ENTRADA, "07:30", "Hoje o bixo vai pegar!"));
		registros.add(new Registro(TipoRegistro.SAIDA, "11:30", "Partiu pegar um rango!"));
		registros.add(new Registro(TipoRegistro.ENTRADA, "12:30", "Buxo ta cheio!"));
		registros.add(new Registro(TipoRegistro.SAIDA, "17:30", "Partiu casa!"));
		return registros;
	}
	

}
