package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleFacturaCitaEntidad {

	private UUID id;
	private CitaEntidad cita;
	private FacturaEntidad factura;
	private int precio;

	public DetalleFacturaCitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaEntidad());
		setFactura(new FacturaEntidad());
		setPrecio(UtilNumero.CERO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaEntidad getCita() {
		return cita;
	}

	public void setCita(CitaEntidad cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaEntidad());
	}

	public FacturaEntidad getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntidad factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaEntidad());
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
