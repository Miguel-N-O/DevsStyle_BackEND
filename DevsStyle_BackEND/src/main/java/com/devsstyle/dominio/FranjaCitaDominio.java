package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FranjaCitaDominio {

	private final UUID id;
	private final DetalleHorarioDominio detalleHorario;
	private final LocalDateTime fechaHoraInicio;
	private final LocalDateTime fechaHoraFin;
	private final EstadoFranjaDominio estadoFranja;

	private FranjaCitaDominio(Builder builder) {
		this.id = builder.id;
		this.detalleHorario = builder.detalleHorario;
		this.fechaHoraInicio = builder.fechaHoraInicio;
		this.fechaHoraFin = builder.fechaHoraFin;
		this.estadoFranja = builder.estadoFranja;
	}

	public UUID getId() {
		return id;
	}

	public DetalleHorarioDominio getDetalleHorario() {
		return detalleHorario;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public EstadoFranjaDominio getEstadoFranja() {
		return estadoFranja;
	}

	public static class Builder {

		private UUID id;
		private DetalleHorarioDominio detalleHorario;
		private LocalDateTime fechaHoraInicio;
		private LocalDateTime fechaHoraFin;
		private EstadoFranjaDominio estadoFranja;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			detalleHorario = new DetalleHorarioDominio.Builder().build();
			fechaHoraInicio = UtilFecha.FECHA_HORA_DEFECTO;
			fechaHoraFin = UtilFecha.FECHA_HORA_DEFECTO;
			estadoFranja = new EstadoFranjaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder detalleHorario(DetalleHorarioDominio detalleHorario) {
			this.detalleHorario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(detalleHorario,
					new DetalleHorarioDominio.Builder().build());
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

		public Builder estadoFranja(EstadoFranjaDominio estadoFranja) {
			this.estadoFranja = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoFranja,
					new EstadoFranjaDominio.Builder().build());
			return this;
		}

		public FranjaCitaDominio build() {
			return new FranjaCitaDominio(this);
		}
	}
}
