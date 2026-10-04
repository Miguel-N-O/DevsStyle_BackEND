package com.devsstyle.dto;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class OcupacionFranjaDTO {

	private UUID id;
	private FranjaCitaDTO franjaCita;
	private CitaDTO cita;

	public OcupacionFranjaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFranjaCita(new FranjaCitaDTO());
		setCita(new CitaDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FranjaCitaDTO getFranjaCita() {
		return franjaCita;
	}

	public void setFranjaCita(FranjaCitaDTO franjaCita) {
		this.franjaCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(franjaCita, new FranjaCitaDTO());
	}

	public CitaDTO getCita() {
		return cita;
	}

	public void setCita(CitaDTO cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaDTO());
	}
}
