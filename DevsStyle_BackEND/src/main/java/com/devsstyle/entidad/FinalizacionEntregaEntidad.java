package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FinalizacionEntregaEntidad {

	private UUID id;
	private EntregaEntidad entrega;
	private LocalDateTime fechaFinalizacion;

	public FinalizacionEntregaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEntrega(new EntregaEntidad());
		setFechaFinalizacion(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaEntidad entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entrega, new EntregaEntidad());
	}

	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
		this.fechaFinalizacion = UtilFecha.obtenerValorDefecto(fechaFinalizacion);
	}
}
