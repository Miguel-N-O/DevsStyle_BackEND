package com.devsstyle.entidad;

import java.time.LocalDate;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PrecioProductoEntidad {

	private UUID id;
	private ProductoEntidad producto;
	private int valor;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public PrecioProductoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProducto(new ProductoEntidad());
		setValor(UtilNumero.CERO);
		setFechaInicio(UtilFecha.FECHA_DEFECTO);
		setFechaFin(UtilFecha.FECHA_SIN_FIN);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProductoEntidad getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntidad producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoEntidad());
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin, UtilFecha.FECHA_SIN_FIN);
	}
}
