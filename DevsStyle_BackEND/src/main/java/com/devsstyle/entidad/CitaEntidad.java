package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CitaEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private ServicioEntidad servicio;
	private LocalDateTime fechaHora;
	private EstadoCitaEntidad estadoCita;

	public CitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setServicio(new ServicioEntidad());
		setFechaHora(UtilFecha.FECHA_HORA_DEFECTO);
		setEstadoCita(new EstadoCitaEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntidad cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteEntidad());
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(servicio, new ServicioEntidad());
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = UtilFecha.obtenerValorDefecto(fechaHora);
	}

	public EstadoCitaEntidad getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(EstadoCitaEntidad estadoCita) {
		this.estadoCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoCita,
				new EstadoCitaEntidad());
	}
}
