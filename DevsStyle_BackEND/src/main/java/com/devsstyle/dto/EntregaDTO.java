package com.devsstyle.dto;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class EntregaDTO {

	private UUID id;
	private DetalleFacturaProductoDTO detalleFacturaProducto;
	private EstadoEntregaDTO estadoEntrega;

	public EntregaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDetalleFacturaProducto(new DetalleFacturaProductoDTO());
		setEstadoEntrega(new EstadoEntregaDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DetalleFacturaProductoDTO getDetalleFacturaProducto() {
		return detalleFacturaProducto;
	}

	public void setDetalleFacturaProducto(DetalleFacturaProductoDTO detalleFacturaProducto) {
		this.detalleFacturaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
				detalleFacturaProducto, new DetalleFacturaProductoDTO());
	}

	public EstadoEntregaDTO getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(EstadoEntregaDTO estadoEntrega) {
		this.estadoEntrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoEntrega,
				new EstadoEntregaDTO());
	}
}
