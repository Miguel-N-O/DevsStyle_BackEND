package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CancelacionCitaDominio {

	private final UUID id;
	private final CitaDominio cita;
	private final LocalDateTime fechaCancelacion;

	private CancelacionCitaDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.fechaCancelacion = builder.fechaCancelacion;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public LocalDateTime getFechaCancelacion() {
		return fechaCancelacion;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private LocalDateTime fechaCancelacion;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = new CitaDominio.Builder().build();
			fechaCancelacion = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita,
					new CitaDominio.Builder().build());
			return this;
		}

		public Builder fechaCancelacion(LocalDateTime fechaCancelacion) {
			this.fechaCancelacion = UtilFecha.obtenerValorDefecto(fechaCancelacion);
			return this;
		}

		public CancelacionCitaDominio build() {
			return new CancelacionCitaDominio(this);
		}
	}
}
