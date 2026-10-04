package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoTemporalDominio {

	private final UUID id;
	private final BarberoDominio barbero;
	private final MotivoBloqueoDominio motivoBloqueo;
	private final LocalDateTime fechaHoraInicio;
	private final LocalDateTime fechaHoraFin;
	private final LocalDateTime fechaRegistro;

	private BloqueoTemporalDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.motivoBloqueo = builder.motivoBloqueo;
		this.fechaHoraInicio = builder.fechaHoraInicio;
		this.fechaHoraFin = builder.fechaHoraFin;
		this.fechaRegistro = builder.fechaRegistro;
	}

	public UUID getId() {
		return id;
	}

	public BarberoDominio getBarbero() {
		return barbero;
	}

	public MotivoBloqueoDominio getMotivoBloqueo() {
		return motivoBloqueo;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private MotivoBloqueoDominio motivoBloqueo;
		private LocalDateTime fechaHoraInicio;
		private LocalDateTime fechaHoraFin;
		private LocalDateTime fechaRegistro;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = new BarberoDominio.Builder().build();
			motivoBloqueo = new MotivoBloqueoDominio.Builder().build();
			fechaHoraInicio = UtilFecha.FECHA_HORA_DEFECTO;
			fechaHoraFin = UtilFecha.FECHA_HORA_DEFECTO;
			fechaRegistro = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder barbero(BarberoDominio barbero) {
			this.barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero,
					new BarberoDominio.Builder().build());
			return this;
		}

		public Builder motivoBloqueo(MotivoBloqueoDominio motivoBloqueo) {
			this.motivoBloqueo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(motivoBloqueo,
					new MotivoBloqueoDominio.Builder().build());
			return this;
		}

		public Builder fechaHoraInicio(LocalDateTime fechaHoraInicio) {
			this.fechaHoraInicio = UtilFecha.obtenerValorDefecto(fechaHoraInicio);
			return this;
		}

		public Builder fechaHoraFin(LocalDateTime fechaHoraFin) {
			this.fechaHoraFin = UtilFecha.obtenerValorDefecto(fechaHoraFin);
			return this;
		}

		public Builder fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
			return this;
		}

		public BloqueoTemporalDominio build() {
			return new BloqueoTemporalDominio(this);
		}
	}
}
