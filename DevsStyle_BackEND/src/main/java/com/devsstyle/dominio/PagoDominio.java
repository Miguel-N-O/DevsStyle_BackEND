package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PagoDominio {

	private final UUID id;
	private final FacturaDominio factura;
	private final MetodoPagoDominio metodoPago;
	private final int monto;
	private final LocalDateTime fecha;

	private PagoDominio(Builder builder) {
		this.id = builder.id;
		this.factura = builder.factura;
		this.metodoPago = builder.metodoPago;
		this.monto = builder.monto;
		this.fecha = builder.fecha;
	}

	public UUID getId() {
		return id;
	}

	public FacturaDominio getFactura() {
		return factura;
	}

	public MetodoPagoDominio getMetodoPago() {
		return metodoPago;
	}

	public int getMonto() {
		return monto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public static class Builder {

		private UUID id;
		private FacturaDominio factura;
		private MetodoPagoDominio metodoPago;
		private int monto;
		private LocalDateTime fecha;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			factura = new FacturaDominio.Builder().build();
			metodoPago = new MetodoPagoDominio.Builder().build();
			monto = UtilNumero.CERO;
			fecha = UtilFecha.FECHA_HORA_DEFECTO;
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

		public Builder metodoPago(MetodoPagoDominio metodoPago) {
			this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(metodoPago,
					new MetodoPagoDominio.Builder().build());
			return this;
		}

		public Builder monto(int monto) {
			this.monto = monto;
			return this;
		}

		public Builder fecha(LocalDateTime fecha) {
			this.fecha = UtilFecha.obtenerValorDefecto(fecha);
			return this;
		}

		public PagoDominio build() {
			return new PagoDominio(this);
		}
	}
}
