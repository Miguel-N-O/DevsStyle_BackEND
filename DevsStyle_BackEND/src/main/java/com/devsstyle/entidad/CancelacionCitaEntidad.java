package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CancelacionCitaEntidad {

	private UUID id;
	private CitaEntidad cita;
	private LocalDateTime fechaCancelacion;

	public CancelacionCitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaEntidad());
		setFechaCancelacion(UtilFecha.FECHA_HORA_DEFECTO);
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

	public LocalDateTime getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
		this.fechaCancelacion = UtilFecha.obtenerValorDefecto(fechaCancelacion);
	}
}
