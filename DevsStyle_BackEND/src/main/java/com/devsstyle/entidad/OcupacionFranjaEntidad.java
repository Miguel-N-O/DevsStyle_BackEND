package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class OcupacionFranjaEntidad {

	private UUID id;
	private FranjaCitaEntidad franjaCita;
	private CitaEntidad cita;

	public OcupacionFranjaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFranjaCita(new FranjaCitaEntidad());
		setCita(new CitaEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public FranjaCitaEntidad getFranjaCita() {
		return franjaCita;
	}

	public void setFranjaCita(FranjaCitaEntidad franjaCita) {
		this.franjaCita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(franjaCita,
				new FranjaCitaEntidad());
	}

	public CitaEntidad getCita() {
		return cita;
	}

	public void setCita(CitaEntidad cita) {
		this.cita = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new CitaEntidad());
	}
}
