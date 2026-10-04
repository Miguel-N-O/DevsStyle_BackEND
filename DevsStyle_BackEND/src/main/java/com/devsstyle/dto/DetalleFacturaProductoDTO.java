package com.devsstyle.dto;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaProductoDTO {

	private UUID id;
	private FacturaDTO factura;
	private ProductoDTO producto;
	private int precio;
	private int cantidad;

	public DetalleFacturaProductoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFactura(new FacturaDTO());
		setProducto(new ProductoDTO());
		setPrecio(UtilNumero.CERO);
		setCantidad(1);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaDTO());
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDTO());
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
