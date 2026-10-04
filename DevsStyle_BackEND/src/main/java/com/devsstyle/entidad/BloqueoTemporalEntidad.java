package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoTemporalEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private MotivoBloqueoEntidad motivoBloqueo;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private LocalDateTime fechaRegistro;

	public BloqueoTemporalEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setMotivoBloqueo(new MotivoBloqueoEntidad());
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

	public BarberoEntidad getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoEntidad barbero) {
		this.barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero, new BarberoEntidad());
	}

	public MotivoBloqueoEntidad getMotivoBloqueo() {
		return motivoBloqueo;
	}

	public void setMotivoBloqueo(MotivoBloqueoEntidad motivoBloqueo) {
		this.motivoBloqueo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(motivoBloqueo,
				new MotivoBloqueoEntidad());
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
