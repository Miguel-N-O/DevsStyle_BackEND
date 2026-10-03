package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DiaSemanaDominio {

	private final UUID id;
	private final String nombre;
	private final int orden;

	private DiaSemanaDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.orden = builder.orden;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getOrden() {
		return orden;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private int orden;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			orden = UtilNumero.CERO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}

		public Builder orden(int orden) {
			this.orden = orden;
			return this;
		}

		public DiaSemanaDominio build() {
			return new DiaSemanaDominio(this);
		}
	}
}