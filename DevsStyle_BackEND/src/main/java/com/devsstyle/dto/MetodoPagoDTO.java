package com.devsstyle.dto;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class MetodoPagoDTO {

	private UUID id;
	private String nombre;
	private boolean activo;
	private boolean esSaldoAFavor;

	public MetodoPagoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIO);
		setActivo(true);
		setEsSaldoAFavor(false);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isEsSaldoAFavor() {
		return esSaldoAFavor;
	}

	public void setEsSaldoAFavor(boolean esSaldoAFavor) {
		this.esSaldoAFavor = esSaldoAFavor;
	}
}