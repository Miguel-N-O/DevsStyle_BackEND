package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CancelacionCitaDTO {

	private UUID id;
	private CitaDTO cita;
	private LocalDateTime fechaCancelacion;

	public CancelacionCitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaDTO());
		setFechaCancelacion(UtilFecha.FECHA_HORA_DEFECTO);
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

	public LocalDateTime getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
		this.fechaCancelacion = UtilFecha.obtenerValorDefecto(fechaCancelacion);
	}
}
