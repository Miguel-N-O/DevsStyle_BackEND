package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class EntregaDominio {

	private final UUID id;
	private final DetalleFacturaProductoDominio detalleFacturaProducto;
	private final EstadoEntregaDominio estadoEntrega;

	private EntregaDominio(Builder builder) {
		this.id = builder.id;
		this.detalleFacturaProducto = builder.detalleFacturaProducto;
		this.estadoEntrega = builder.estadoEntrega;
	}

	public UUID getId() {
		return id;
	}

	public DetalleFacturaProductoDominio getDetalleFacturaProducto() {
		return detalleFacturaProducto;
	}

	public EstadoEntregaDominio getEstadoEntrega() {
		return estadoEntrega;
	}

	public static class Builder {

		private UUID id;
		private DetalleFacturaProductoDominio detalleFacturaProducto;
		private EstadoEntregaDominio estadoEntrega;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			detalleFacturaProducto = new DetalleFacturaProductoDominio.Builder().build();
			estadoEntrega = new EstadoEntregaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder detalleFacturaProducto(DetalleFacturaProductoDominio detalleFacturaProducto) {
			this.detalleFacturaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					detalleFacturaProducto, new DetalleFacturaProductoDominio.Builder().build());
			return this;
		}

		public Builder estadoEntrega(EstadoEntregaDominio estadoEntrega) {
			this.estadoEntrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoEntrega,
					new EstadoEntregaDominio.Builder().build());
			return this;
		}

		public EntregaDominio build() {
			return new EntregaDominio(this);
		}
	}
}
