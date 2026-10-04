package com.devsstyle.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoFijoEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private MotivoBloqueoEntidad motivoBloqueo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private LocalDateTime fechaRegistro;

	public BloqueoFijoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setMotivoBloqueo(new MotivoBloqueoEntidad());
		setFechaInicio(UtilFecha.FECHA_DEFECTO);
		setFechaFin(UtilFecha.FECHA_SIN_FIN);
		setHoraInicio(UtilFecha.HORA_DEFECTO);
		setHoraFin(UtilFecha.HORA_DEFECTO);
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin, UtilFecha.FECHA_SIN_FIN);
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilFecha.obtenerValorDefecto(horaInicio);
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = UtilFecha.obtenerValorDefecto(horaFin);
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
	}
}
