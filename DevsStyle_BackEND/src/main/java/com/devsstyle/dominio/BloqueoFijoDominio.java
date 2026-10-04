package com.devsstyle.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoFijoDominio {

	private final UUID id;
	private final BarberoDominio barbero;
	private final MotivoBloqueoDominio motivoBloqueo;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	private final LocalTime horaInicio;
	private final LocalTime horaFin;
	private final LocalDateTime fechaRegistro;

	private BloqueoFijoDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.motivoBloqueo = builder.motivoBloqueo;
		this.fechaInicio = builder.fechaInicio;
		this.fechaFin = builder.fechaFin;
		this.horaInicio = builder.horaInicio;
		this.horaFin = builder.horaFin;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private MotivoBloqueoDominio motivoBloqueo;
		private LocalDate fechaInicio;
		private LocalDate fechaFin;
		private LocalTime horaInicio;
		private LocalTime horaFin;
		private LocalDateTime fechaRegistro;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = new BarberoDominio.Builder().build();
			motivoBloqueo = new MotivoBloqueoDominio.Builder().build();
			fechaInicio = UtilFecha.FECHA_DEFECTO;
			fechaFin = UtilFecha.FECHA_SIN_FIN;
			horaInicio = UtilFecha.HORA_DEFECTO;
			horaFin = UtilFecha.HORA_DEFECTO;
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

		public Builder fechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
			return this;
		}

		public Builder fechaFin(LocalDate fechaFin) {
			this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin, UtilFecha.FECHA_SIN_FIN);
			return this;
		}

		public Builder horaInicio(LocalTime horaInicio) {
			this.horaInicio = UtilFecha.obtenerValorDefecto(horaInicio);
			return this;
		}

		public Builder horaFin(LocalTime horaFin) {
			this.horaFin = UtilFecha.obtenerValorDefecto(horaFin);
			return this;
		}

		public Builder fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
			return this;
		}

		public BloqueoFijoDominio build() {
			return new BloqueoFijoDominio(this);
		}
	}
}
