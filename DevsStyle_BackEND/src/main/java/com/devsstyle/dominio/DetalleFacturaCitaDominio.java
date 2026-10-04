package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaCitaDominio {

	private final UUID id;
	private final CitaDominio cita;
	private final FacturaDominio factura;
	private final int precio;

	private DetalleFacturaCitaDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.factura = builder.factura;
		this.precio = builder.precio;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public FacturaDominio getFactura() {
		return factura;
	}

	public int getPrecio() {
		return precio;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private FacturaDominio factura;
		private int precio;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = new CitaDominio.Builder().build();
			factura = new FacturaDominio.Builder().build();
			precio = UtilNumero.CERO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita,
					new CitaDominio.Builder().build());
			return this;
		}

		public Builder factura(FacturaDominio factura) {
			this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura,
					new FacturaDominio.Builder().build());
			return this;
		}

		public Builder precio(int precio) {
			this.precio = precio;
			return this;
		}

		public DetalleFacturaCitaDominio build() {
			return new DetalleFacturaCitaDominio(this);
		}
	}
}
