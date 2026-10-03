package com.devsstyle.entidad;

import java.time.LocalDate;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class HorarioEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int antelacionMinimaReservaHoras;
	private int antelacionMinimaReprogramacionHoras;
	private int duracionFranjaMinutos;

	public HorarioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setFechaInicio(UtilFecha.FECHA_DEFECTO);
		setFechaFin(UtilFecha.FECHA_DEFECTO);
		setAntelacionMinimaReservaHoras(UtilNumero.CERO);
		setAntelacionMinimaReprogramacionHoras(UtilNumero.CERO);
		setDuracionFranjaMinutos(UtilNumero.CERO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoEntidad getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoEntidad barbero) {
		this.barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero, new BarberoEntidad());
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin);
	}

	public int getAntelacionMinimaReservaHoras() {
		return antelacionMinimaReservaHoras;
	}

	public void setAntelacionMinimaReservaHoras(int antelacionMinimaReservaHoras) {
		this.antelacionMinimaReservaHoras = antelacionMinimaReservaHoras;
	}

	public int getAntelacionMinimaReprogramacionHoras() {
		return antelacionMinimaReprogramacionHoras;
	}

	public void setAntelacionMinimaReprogramacionHoras(int antelacionMinimaReprogramacionHoras) {
		this.antelacionMinimaReprogramacionHoras = antelacionMinimaReprogramacionHoras;
	}

	public int getDuracionFranjaMinutos() {
		return duracionFranjaMinutos;
	}

	public void setDuracionFranjaMinutos(int duracionFranjaMinutos) {
		this.duracionFranjaMinutos = duracionFranjaMinutos;
	}
}