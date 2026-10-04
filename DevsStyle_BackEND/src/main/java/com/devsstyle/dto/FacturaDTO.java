package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class FacturaDTO {

	private UUID id;
	private String numeroConsecutivo;
	private ClienteDTO cliente;
	private int total;
	private LocalDateTime fechaEmision;

	public FacturaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNumeroConsecutivo(UtilTexto.VACIO);
		setCliente(new ClienteDTO());
		setTotal(UtilNumero.CERO);
		setFechaEmision(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroConsecutivo() {
		return numeroConsecutivo;
	}

	public void setNumeroConsecutivo(String numeroConsecutivo) {
		this.numeroConsecutivo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroConsecutivo);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
	}
}
