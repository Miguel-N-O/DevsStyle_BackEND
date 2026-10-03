package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class MetodoPagoDominio {

	private final UUID id;
	private final String nombre;
	private final boolean activo;
	private final boolean esSaldoAFavor;

	private MetodoPagoDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.activo = builder.activo;
		this.esSaldoAFavor = builder.esSaldoAFavor;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public boolean isEsSaldoAFavor() {
		return esSaldoAFavor;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private boolean activo;
		private boolean esSaldoAFavor;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			activo = true;
			esSaldoAFavor = false;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}

		public Builder activo(boolean activo) {
			this.activo = activo;
			return this;
		}

		public Builder esSaldoAFavor(boolean esSaldoAFavor) {
			this.esSaldoAFavor = esSaldoAFavor;
			return this;
		}

		public MetodoPagoDominio build() {
			return new MetodoPagoDominio(this);
		}
	}
}