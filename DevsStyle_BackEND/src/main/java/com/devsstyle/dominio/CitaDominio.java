package com.devsstyle.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CitaDominio {

	private final UUID id;
	private final ClienteDominio cliente;
	private final ServicioDominio servicio;
	private final LocalDateTime fechaHora;
	private final EstadoCitaDominio estadoCita;

	private CitaDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.servicio = builder.servicio;
		this.fechaHora = builder.fechaHora;
		this.estadoCita = builder.estadoCita;
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public EstadoCitaDominio getEstadoCita() {
		return estadoCita;
	}

	public static class Builder {

		private UUID id;
		private ClienteDominio cliente;
		private ServicioDominio servicio;
		private LocalDateTime fechaHora;
		private EstadoCitaDominio estadoCita;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
			servicio = new ServicioDominio.Builder().build();
			fechaHora = UtilFecha.FECHA_HORA_DEFECTO;
			estadoCita = new EstadoCitaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
					new ClienteDominio.Builder().build());
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(servicio,
					new ServicioDominio.Builder().build());
			return this;
		}

		public Builder fechaHora(LocalDateTime fechaHora) {
			this.fechaHora = UtilFecha.obtenerValorDefecto(fechaHora);
			return this;
		}

		public Builder estadoCita(EstadoCitaDominio estadoCita) {
			this.estadoCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoCita,
					new EstadoCitaDominio.Builder().build());
			return this;
		}

		public CitaDominio build() {
			return new CitaDominio(this);
		}
	}
}
