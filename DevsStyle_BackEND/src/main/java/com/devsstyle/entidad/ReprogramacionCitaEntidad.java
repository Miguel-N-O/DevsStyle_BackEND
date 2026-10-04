package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ReprogramacionCitaEntidad {

	private UUID id;
	private CitaEntidad cita;
	private LocalDateTime fechaHoraAnterior;
	private LocalDateTime fechaRegistro;

	public ReprogramacionCitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaEntidad());
		setFechaHoraAnterior(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaRegistro(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaEntidad getCita() {
		return cita;
	}

	public void setCita(CitaEntidad cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaEntidad());
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
