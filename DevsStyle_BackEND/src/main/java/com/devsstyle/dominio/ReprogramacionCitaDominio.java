package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ReprogramacionCitaDominio {

	private final UUID id;
	private final CitaDominio cita;
	private final LocalDateTime fechaHoraAnterior;
	private final LocalDateTime fechaRegistro;

	private ReprogramacionCitaDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.fechaHoraAnterior = builder.fechaHoraAnterior;
		this.fechaRegistro = builder.fechaRegistro;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public LocalDateTime getFechaHoraAnterior() {
		return fechaHoraAnterior;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private LocalDateTime fechaHoraAnterior;
		private LocalDateTime fechaRegistro;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = new CitaDominio.Builder().build();
			fechaHoraAnterior = UtilFecha.FECHA_HORA_DEFECTO;
			fechaRegistro = UtilFecha.FECHA_HORA_DEFECTO;
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

		public Builder fechaHoraAnterior(LocalDateTime fechaHoraAnterior) {
			this.fechaHoraAnterior = UtilFecha.obtenerValorDefecto(fechaHoraAnterior);
			return this;
		}

		public Builder fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
			return this;
		}

		public ReprogramacionCitaDominio build() {
			return new ReprogramacionCitaDominio(this);
		}
	}
}
