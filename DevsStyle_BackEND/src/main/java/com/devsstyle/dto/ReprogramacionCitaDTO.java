package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ReprogramacionCitaDTO {

	private UUID id;
	private CitaDTO cita;
	private LocalDateTime fechaHoraAnterior;
	private LocalDateTime fechaRegistro;

	public ReprogramacionCitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaDTO());
		setFechaHoraAnterior(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaRegistro(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaDTO getCita() {
		return cita;
	}

	public void setCita(CitaDTO cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaDTO());
	}

	public LocalDateTime getFechaHoraAnterior() {
		return fechaHoraAnterior;
	}

	public void setFechaHoraAnterior(LocalDateTime fechaHoraAnterior) {
		this.fechaHoraAnterior = UtilFecha.obtenerValorDefecto(fechaHoraAnterior);
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = UtilFecha.obtenerValorDefecto(fechaRegistro);
	}
}
