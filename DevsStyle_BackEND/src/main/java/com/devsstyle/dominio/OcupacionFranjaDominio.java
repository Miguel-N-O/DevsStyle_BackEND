package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class OcupacionFranjaDominio {

	private final UUID id;
	private final FranjaCitaDominio franjaCita;
	private final CitaDominio cita;

	private OcupacionFranjaDominio(Builder builder) {
		this.id = builder.id;
		this.franjaCita = builder.franjaCita;
		this.cita = builder.cita;
	}

	public UUID getId() {
		return id;
	}

	public FranjaCitaDominio getFranjaCita() {
		return franjaCita;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public static class Builder {

		private UUID id;
		private FranjaCitaDominio franjaCita;
		private CitaDominio cita;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			franjaCita = new FranjaCitaDominio.Builder().build();
			cita = new CitaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder franjaCita(FranjaCitaDominio franjaCita) {
			this.franjaCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(franjaCita,
					new FranjaCitaDominio.Builder().build());
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita,
					new CitaDominio.Builder().build());
			return this;
		}

		public OcupacionFranjaDominio build() {
			return new OcupacionFranjaDominio(this);
		}
	}
}
