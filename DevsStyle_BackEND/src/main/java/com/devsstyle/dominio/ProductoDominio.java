package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ProductoDominio {

	private final UUID id;
	private final String nombre;
	private final int unidadesDisponibles;
	private final String descripcion;
	private final int cantidadMinima;
	private final boolean activo;

	private ProductoDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.unidadesDisponibles = builder.unidadesDisponibles;
		this.descripcion = builder.descripcion;
		this.cantidadMinima = builder.cantidadMinima;
		this.activo = builder.activo;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	public boolean isActivo() {
		return activo;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private int unidadesDisponibles;
		private String descripcion;
		private int cantidadMinima;
		private boolean activo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			unidadesDisponibles = UtilNumero.CERO;
			descripcion = UtilTexto.VACIO;
			cantidadMinima = 10;
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

		public Builder unidadesDisponibles(int unidadesDisponibles) {
			this.unidadesDisponibles = unidadesDisponibles;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
			return this;
		}

		public Builder cantidadMinima(int cantidadMinima) {
			this.cantidadMinima = cantidadMinima;
			return this;
		}

		public Builder activo(boolean activo) {
			this.activo = activo;
			return this;
		}

		public ProductoDominio build() {
			return new ProductoDominio(this);
		}
	}
}