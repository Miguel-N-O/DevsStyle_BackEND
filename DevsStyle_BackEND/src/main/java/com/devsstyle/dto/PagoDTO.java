package com.devsstyle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PagoDTO {

	private UUID id;
	private FacturaDTO factura;
	private MetodoPagoDTO metodoPago;
	private int monto;
	private LocalDateTime fecha;

	public PagoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFactura(new FacturaDTO());
		setMetodoPago(new MetodoPagoDTO());
		setMonto(UtilNumero.CERO);
		setFecha(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaDTO());
	}

	public MetodoPagoDTO getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPagoDTO metodoPago) {
		this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(metodoPago, new MetodoPagoDTO());
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = UtilFecha.obtenerValorDefecto(fecha);
	}
}
