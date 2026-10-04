package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ReabastecimientoDominio {

	private final UUID id;
	private final ProductoDominio producto;
	private final int cantidad;
	private final LocalDateTime fecha;

	private ReabastecimientoDominio(Builder builder) {
		this.id = builder.id;
		this.producto = builder.producto;
		this.cantidad = builder.cantidad;
		this.fecha = builder.fecha;
	}

	public UUID getId() {
		return id;
	}

	public ProductoDominio getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public static class Builder {

		private UUID id;
		private ProductoDominio producto;
		private int cantidad;
		private LocalDateTime fecha;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			producto = new ProductoDominio.Builder().build();
			cantidad = UtilNumero.CERO;
			fecha = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder producto(ProductoDominio producto) {
			this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto,
					new ProductoDominio.Builder().build());
			return this;
		}

		public Builder cantidad(int cantidad) {
			this.cantidad = cantidad;
			return this;
		}

		public Builder fecha(LocalDateTime fecha) {
			this.fecha = UtilFecha.obtenerValorDefecto(fecha);
			return this;
		}

		public ReabastecimientoDominio build() {
			return new ReabastecimientoDominio(this);
		}
	}
}
