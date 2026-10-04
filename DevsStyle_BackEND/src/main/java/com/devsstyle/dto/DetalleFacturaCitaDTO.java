package com.devsstyle.dto;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaCitaDTO {

	private UUID id;
	private CitaDTO cita;
	private FacturaDTO factura;
	private int precio;

	public DetalleFacturaCitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaDTO());
		setFactura(new FacturaDTO());
		setPrecio(UtilNumero.CERO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaDTO getCita() {
		return cita;
	}

	public void setCita(CitaDTO cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaDTO());
	}

	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaDTO());
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
