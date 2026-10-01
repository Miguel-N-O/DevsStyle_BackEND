package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class IndicativoPaisDominio {

	private final UUID id;
	private final String pais;
	private final String indicativo;

	private IndicativoPaisDominio(Builder builder) {
		this.id = builder.id;
		this.pais = builder.pais;
		this.indicativo = builder.indicativo;
	}

	public UUID getId() {
		return id;
	}

	public String getPais() {
		return pais;
	}

	public String getIndicativo() {
		return indicativo;
	}

	public static class Builder {

		private UUID id;
		private String pais;
		private String indicativo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			pais = UtilTexto.VACIO;
			indicativo = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder pais(String pais) {
			this.pais = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(pais);
			return this;
		}

		public Builder indicativo(String indicativo) {
			this.indicativo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(indicativo);
			return this;
		}

		public IndicativoPaisDominio build() {
			return new IndicativoPaisDominio(this);
		}
	}
}