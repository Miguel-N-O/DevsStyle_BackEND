package com.devsstyle.entidad;

import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleHorarioEntidad {

	private UUID id;
	private HorarioEntidad horario;
	private DiaSemanaEntidad diaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFin;

	public DetalleHorarioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setHorario(new HorarioEntidad());
		setDiaSemana(new DiaSemanaEntidad());
		setHoraInicio(UtilFecha.HORA_DEFECTO);
		setHoraFin(UtilFecha.HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public HorarioEntidad getHorario() {
		return horario;
	}

	public void setHorario(HorarioEntidad horario) {
		this.horario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(horario, new HorarioEntidad());
	}

	public DiaSemanaEntidad getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemanaEntidad diaSemana) {
		this.diaSemana = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(diaSemana, new DiaSemanaEntidad());
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilFecha.obtenerValorDefecto(horaInicio);
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = UtilFecha.obtenerValorDefecto(horaFin);
	}
}
