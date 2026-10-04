package com.devsstyle.dominio;

import java.time.LocalTime;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class DetalleHorarioDominio {

	private final UUID id;
	private final HorarioDominio horario;
	private final DiaSemanaDominio diaSemana;
	private final LocalTime horaInicio;
	private final LocalTime horaFin;

	private DetalleHorarioDominio(Builder builder) {
		this.id = builder.id;
		this.horario = builder.horario;
		this.diaSemana = builder.diaSemana;
		this.horaInicio = builder.horaInicio;
		this.horaFin = builder.horaFin;
	}

	public UUID getId() {
		return id;
	}

	public HorarioDominio getHorario() {
		return horario;
	}

	public DiaSemanaDominio getDiaSemana() {
		return diaSemana;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public static class Builder {

		private UUID id;
		private HorarioDominio horario;
		private DiaSemanaDominio diaSemana;
		private LocalTime horaInicio;
		private LocalTime horaFin;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			horario = new HorarioDominio.Builder().build();
			diaSemana = new DiaSemanaDominio.Builder().build();
			horaInicio = UtilFecha.HORA_DEFECTO;
			horaFin = UtilFecha.HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder horario(HorarioDominio horario) {
			this.horario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(horario,
					new HorarioDominio.Builder().build());
			return this;
		}

		public Builder diaSemana(DiaSemanaDominio diaSemana) {
			this.diaSemana = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(diaSemana,
					new DiaSemanaDominio.Builder().build());
			return this;
		}

		public Builder horaInicio(LocalTime horaInicio) {
			this.horaInicio = UtilFecha.obtenerValorDefecto(horaInicio);
			return this;
		}

		public Builder horaFin(LocalTime horaFin) {
			this.horaFin = UtilFecha.obtenerValorDefecto(horaFin);
			return this;
		}

		public DetalleHorarioDominio build() {
			return new DetalleHorarioDominio(this);
		}
	}
}
