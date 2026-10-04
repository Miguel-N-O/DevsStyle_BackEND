package com.devsstyle.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class PagoEntidad {

	private UUID id;
	private FacturaEntidad factura;
	private MetodoPagoEntidad metodoPago;
	private int monto;
	private LocalDateTime fecha;

	public PagoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFactura(new FacturaEntidad());
		setMetodoPago(new MetodoPagoEntidad());
		setMonto(UtilNumero.CERO);
		setFecha(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FacturaEntidad getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntidad factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(factura, new FacturaEntidad());
	}

	public MetodoPagoEntidad getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPagoEntidad metodoPago) {
		this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(metodoPago, new MetodoPagoEntidad());
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
