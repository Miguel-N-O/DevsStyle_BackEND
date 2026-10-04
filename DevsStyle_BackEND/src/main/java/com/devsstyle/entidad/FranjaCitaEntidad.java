package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FranjaCitaEntidad {

	private UUID id;
	private DetalleHorarioEntidad detalleHorario;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private EstadoFranjaEntidad estadoFranja;

	public FranjaCitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDetalleHorario(new DetalleHorarioEntidad());
		setFechaHoraInicio(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaHoraFin(UtilFecha.FECHA_HORA_DEFECTO);
		setEstadoFranja(new EstadoFranjaEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DetalleHorarioEntidad getDetalleHorario() {
		return detalleHorario;
	}

	public void setDetalleHorario(DetalleHorarioEntidad detalleHorario) {
		this.detalleHorario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(detalleHorario,
				new DetalleHorarioEntidad());
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = UtilFecha.obtenerValorDefecto(fechaHoraInicio);
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = UtilFecha.obtenerValorDefecto(fechaHoraFin);
	}

	public EstadoFranjaEntidad getEstadoFranja() {
		return estadoFranja;
	}

	public void setEstadoFranja(EstadoFranjaEntidad estadoFranja) {
		this.estadoFranja = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoFranja,
				new EstadoFranjaEntidad());
	}
}
