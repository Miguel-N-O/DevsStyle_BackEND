package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class EntregaEntidad {

	private UUID id;
	private DetalleFacturaProductoEntidad detalleFacturaProducto;
	private EstadoEntregaEntidad estadoEntrega;

	public EntregaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDetalleFacturaProducto(new DetalleFacturaProductoEntidad());
		setEstadoEntrega(new EstadoEntregaEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DetalleFacturaProductoEntidad getDetalleFacturaProducto() {
		return detalleFacturaProducto;
	}

	public void setDetalleFacturaProducto(DetalleFacturaProductoEntidad detalleFacturaProducto) {
		this.detalleFacturaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
				detalleFacturaProducto, new DetalleFacturaProductoEntidad());
	}

	public EstadoEntregaEntidad getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(EstadoEntregaEntidad estadoEntrega) {
		this.estadoEntrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoEntrega,
				new EstadoEntregaEntidad());
	}
}
