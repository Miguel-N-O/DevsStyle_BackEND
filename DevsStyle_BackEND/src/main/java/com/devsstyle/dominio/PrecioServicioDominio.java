package com.devsstyle.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PrecioServicioDominio {

	private final UUID id;
	private final ServicioDominio servicio;
	private final int valor;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;

	private PrecioServicioDominio(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.valor = builder.valor;
		this.fechaInicio = builder.fechaInicio;
		this.fechaFin = builder.fechaFin;
	}

	public UUID getId() {
		return id;
	}

	public ServicioDominio getServicio() {
		return servicio;
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
		private ServicioDominio servicio;
		private int valor;
		private LocalDate fechaInicio;
		private LocalDate fechaFin;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			servicio = new ServicioDominio.Builder().build();
			valor = UtilNumero.CERO;
			fechaInicio = UtilFecha.FECHA_DEFECTO;
			fechaFin = UtilFecha.FECHA_SIN_FIN;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(servicio,
					new ServicioDominio.Builder().build());
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

		public PrecioServicioDominio build() {
			return new PrecioServicioDominio(this);
		}
	}
}
