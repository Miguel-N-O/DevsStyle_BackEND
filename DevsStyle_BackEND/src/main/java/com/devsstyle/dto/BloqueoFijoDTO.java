package com.devsstyle.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BloqueoFijoDTO {

	private UUID id;
	private BarberoDTO barbero;
	private MotivoBloqueoDTO motivoBloqueo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private LocalDateTime fechaRegistro;

	public BloqueoFijoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoDTO());
		setMotivoBloqueo(new MotivoBloqueoDTO());
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
