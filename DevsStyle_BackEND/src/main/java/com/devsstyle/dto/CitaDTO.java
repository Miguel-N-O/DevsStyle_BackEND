package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class CitaDTO {

	private UUID id;
	private ClienteDTO cliente;
	private ServicioDTO servicio;
	private LocalDateTime fechaHora;
	private EstadoCitaDTO estadoCita;

	public CitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setServicio(new ServicioDTO());
		setFechaHora(UtilFecha.FECHA_HORA_DEFECTO);
		setEstadoCita(new EstadoCitaDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(servicio, new ServicioDTO());
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = UtilFecha.obtenerValorDefecto(fechaHora);
	}

	public EstadoCitaDTO getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(EstadoCitaDTO estadoCita) {
		this.estadoCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoCita, new EstadoCitaDTO());
	}
}
