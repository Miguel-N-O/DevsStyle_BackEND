package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FinalizacionEntregaDominio {

	private final UUID id;
	private final EntregaDominio entrega;
	private final LocalDateTime fechaFinalizacion;

	private FinalizacionEntregaDominio(Builder builder) {
		this.id = builder.id;
		this.entrega = builder.entrega;
		this.fechaFinalizacion = builder.fechaFinalizacion;
	}

	public UUID getId() {
		return id;
	}

	public EntregaDominio getEntrega() {
		return entrega;
	}

	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public static class Builder {

		private UUID id;
		private EntregaDominio entrega;
		private LocalDateTime fechaFinalizacion;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			entrega = new EntregaDominio.Builder().build();
			fechaFinalizacion = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder entrega(EntregaDominio entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entrega,
					new EntregaDominio.Builder().build());
			return this;
		}

		public Builder fechaFinalizacion(LocalDateTime fechaFinalizacion) {
			this.fechaFinalizacion = UtilFecha.obtenerValorDefecto(fechaFinalizacion);
			return this;
		}

		public FinalizacionEntregaDominio build() {
			return new FinalizacionEntregaDominio(this);
		}
	}
}
