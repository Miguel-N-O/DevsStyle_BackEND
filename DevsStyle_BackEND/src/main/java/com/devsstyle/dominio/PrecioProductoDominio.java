package com.devsstyle.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PrecioProductoDominio {

	private final UUID id;
	private final ProductoDominio producto;
	private final int valor;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;

	private PrecioProductoDominio(Builder builder) {
		this.id = builder.id;
		this.producto = builder.producto;
		this.valor = builder.valor;
		this.fechaInicio = builder.fechaInicio;
		this.fechaFin = builder.fechaFin;
	}

	public UUID getId() {
		return id;
	}

	public ProductoDominio getProducto() {
		return producto;
	}

	public int getValor() {
		return valor;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public static class Builder {

		private UUID id;
		private ProductoDominio producto;
		private int valor;
		private LocalDate fechaInicio;
		private LocalDate fechaFin;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			producto = new ProductoDominio.Builder().build();
			valor = UtilNumero.CERO;
			fechaInicio = UtilFecha.FECHA_DEFECTO;
			fechaFin = UtilFecha.FECHA_SIN_FIN;
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

		public Builder valor(int valor) {
			this.valor = valor;
			return this;
		}

		public Builder fechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
			return this;
		}

		public Builder fechaFin(LocalDate fechaFin) {
			this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin, UtilFecha.FECHA_SIN_FIN);
			return this;
		}

		public PrecioProductoDominio build() {
			return new PrecioProductoDominio(this);
		}
	}
}
