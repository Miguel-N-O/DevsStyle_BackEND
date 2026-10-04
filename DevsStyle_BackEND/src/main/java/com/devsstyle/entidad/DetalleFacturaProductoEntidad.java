package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaProductoEntidad {

	private UUID id;
	private FacturaEntidad factura;
	private ProductoEntidad producto;
	private int precio;
	private int cantidad;

	public DetalleFacturaProductoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFactura(new FacturaEntidad());
		setProducto(new ProductoEntidad());
		setPrecio(UtilNumero.CERO);
		setCantidad(1);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FacturaEntidad getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntidad factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaEntidad());
	}

	public ProductoEntidad getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntidad producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoEntidad());
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
