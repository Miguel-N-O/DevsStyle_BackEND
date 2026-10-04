package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaProductoDominio {

	private final UUID id;
	private final FacturaDominio factura;
	private final ProductoDominio producto;
	private final int precio;
	private final int cantidad;

	private DetalleFacturaProductoDominio(Builder builder) {
		this.id = builder.id;
		this.factura = builder.factura;
		this.producto = builder.producto;
		this.precio = builder.precio;
		this.cantidad = builder.cantidad;
	}

	public UUID getId() {
		return id;
	}

	public FacturaDominio getFactura() {
		return factura;
	}

	public ProductoDominio getProducto() {
		return producto;
	}

	public int getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public static class Builder {

		private UUID id;
		private FacturaDominio factura;
		private ProductoDominio producto;
		private int precio;
		private int cantidad;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			factura = new FacturaDominio.Builder().build();
			producto = new ProductoDominio.Builder().build();
			precio = UtilNumero.CERO;
			cantidad = 1;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder factura(FacturaDominio factura) {
			this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura,
					new FacturaDominio.Builder().build());
			return this;
		}

		public Builder producto(ProductoDominio producto) {
			this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto,
					new ProductoDominio.Builder().build());
			return this;
		}

		public Builder precio(int precio) {
			this.precio = precio;
			return this;
		}

		public Builder cantidad(int cantidad) {
			this.cantidad = cantidad;
			return this;
		}

		public DetalleFacturaProductoDominio build() {
			return new DetalleFacturaProductoDominio(this);
		}
	}
}
