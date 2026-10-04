package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FacturaDominio {

	private final UUID id;
	private final String numeroConsecutivo;
	private final ClienteDominio cliente;
	private final int total;
	private final LocalDateTime fechaEmision;

	private FacturaDominio(Builder builder) {
		this.id = builder.id;
		this.numeroConsecutivo = builder.numeroConsecutivo;
		this.cliente = builder.cliente;
		this.total = builder.total;
		this.fechaEmision = builder.fechaEmision;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroConsecutivo() {
		return numeroConsecutivo;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public int getTotal() {
		return total;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public static class Builder {

		private UUID id;
		private String numeroConsecutivo;
		private ClienteDominio cliente;
		private int total;
		private LocalDateTime fechaEmision;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			numeroConsecutivo = UtilTexto.VACIO;
			cliente = new ClienteDominio.Builder().build();
			total = UtilNumero.CERO;
			fechaEmision = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroConsecutivo(String numeroConsecutivo) {
			this.numeroConsecutivo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroConsecutivo);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
					new ClienteDominio.Builder().build());
			return this;
		}

		public Builder total(int total) {
			this.total = total;
			return this;
		}

		public Builder fechaEmision(LocalDateTime fechaEmision) {
			this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
			return this;
		}

		public FacturaDominio build() {
			return new FacturaDominio(this);
		}
	}
}
