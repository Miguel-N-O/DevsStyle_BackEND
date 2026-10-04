package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FranjaCitaDTO {

	private UUID id;
	private DetalleHorarioDTO detalleHorario;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private EstadoFranjaDTO estadoFranja;

	public FranjaCitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDetalleHorario(new DetalleHorarioDTO());
		setFechaHoraInicio(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaHoraFin(UtilFecha.FECHA_HORA_DEFECTO);
		setEstadoFranja(new EstadoFranjaDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DetalleHorarioDTO getDetalleHorario() {
		return detalleHorario;
	}

	public void setDetalleHorario(DetalleHorarioDTO detalleHorario) {
		this.detalleHorario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(detalleHorario,
				new DetalleHorarioDTO());
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

	public EstadoFranjaDTO getEstadoFranja() {
		return estadoFranja;
	}

	public void setEstadoFranja(EstadoFranjaDTO estadoFranja) {
		this.estadoFranja = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoFranja,
				new EstadoFranjaDTO());
	}
}
