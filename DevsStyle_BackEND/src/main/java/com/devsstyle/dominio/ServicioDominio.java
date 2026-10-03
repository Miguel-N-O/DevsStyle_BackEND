package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ServicioDominio {

	private final UUID id;
	private final String nombre;
	private final String descripcion;
	private final int duracionEstimadaMinutos;
	private final boolean activo;

	private ServicioDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.descripcion = builder.descripcion;
		this.duracionEstimadaMinutos = builder.duracionEstimadaMinutos;
		this.activo = builder.activo;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracionEstimadaMinutos() {
		return duracionEstimadaMinutos;
	}

	public boolean isActivo() {
		return activo;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private String descripcion;
		private int duracionEstimadaMinutos;
		private boolean activo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			descripcion = UtilTexto.VACIO;
			duracionEstimadaMinutos = UtilNumero.CERO;
			activo = true;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
			return this;
		}

		public Builder duracionEstimadaMinutos(int duracionEstimadaMinutos) {
			this.duracionEstimadaMinutos = duracionEstimadaMinutos;
			return this;
		}

		public Builder activo(boolean activo) {
			this.activo = activo;
			return this;
		}

		public ServicioDominio build() {
			return new ServicioDominio(this);
		}
	}
}