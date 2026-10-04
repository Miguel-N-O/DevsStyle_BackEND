package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoTemporalDTO {

	private UUID id;
	private BarberoDTO barbero;
	private MotivoBloqueoDTO motivoBloqueo;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private LocalDateTime fechaRegistro;

	public BloqueoTemporalDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoDTO());
		setMotivoBloqueo(new MotivoBloqueoDTO());
		setFechaHoraInicio(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaHoraFin(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaRegistro(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoDTO getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoDTO barbero) {
		this.barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero, new BarberoDTO());
	}

	public MotivoBloqueoDTO getMotivoBloqueo() {
		return motivoBloqueo;
	}

	public void setMotivoBloqueo(MotivoBloqueoDTO motivoBloqueo) {
		this.motivoBloqueo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(motivoBloqueo,
				new MotivoBloqueoDTO());
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

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
	}
}
