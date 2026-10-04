package com.devsstyle.dto;

import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleHorarioDTO {

	private UUID id;
	private HorarioDTO horario;
	private DiaSemanaDTO diaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFin;

	public DetalleHorarioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setHorario(new HorarioDTO());
		setDiaSemana(new DiaSemanaDTO());
		setHoraInicio(UtilFecha.HORA_DEFECTO);
		setHoraFin(UtilFecha.HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public HorarioDTO getHorario() {
		return horario;
	}

	public void setHorario(HorarioDTO horario) {
		this.horario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(horario, new HorarioDTO());
	}

	public DiaSemanaDTO getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemanaDTO diaSemana) {
		this.diaSemana = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(diaSemana, new DiaSemanaDTO());
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
