package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FinalizacionEntregaDTO {

	private UUID id;
	private EntregaDTO entrega;
	private LocalDateTime fechaFinalizacion;

	public FinalizacionEntregaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEntrega(new EntregaDTO());
		setFechaFinalizacion(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EntregaDTO getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaDTO entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entrega, new EntregaDTO());
	}

	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
		this.fechaFinalizacion = UtilFecha.obtenerValorDefecto(fechaFinalizacion);
	}
}
