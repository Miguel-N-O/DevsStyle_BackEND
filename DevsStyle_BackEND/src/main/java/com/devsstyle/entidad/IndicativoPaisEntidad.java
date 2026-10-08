package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class IndicativoPaisEntidad {

	private UUID id;
	private String pais;
	private String indicativo;

	public IndicativoPaisEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPais(UtilTexto.VACIO);
		setIndicativo(UtilTexto.VACIO);
	}
	
	public IndicativoPaisEntidad(UUID id, String pais, String indicativo) {
		setId(id);
		setPais(pais);
		setIndicativo(indicativo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(pais);
	}

	public String getIndicativo() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(indicativo);
	}
}