package com.devsstyle.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilFecha;
import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class HorarioDominio {

	private final UUID id;
	private final BarberoDominio barbero;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	private final int antelacionMinimaReservaHoras;
	private final int antelacionMinimaReprogramacionHoras;
	private final int duracionFranjaMinutos;

	private HorarioDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.fechaInicio = builder.fechaInicio;
		this.fechaFin = builder.fechaFin;
		this.antelacionMinimaReservaHoras = builder.antelacionMinimaReservaHoras;
		this.antelacionMinimaReprogramacionHoras = builder.antelacionMinimaReprogramacionHoras;
		this.duracionFranjaMinutos = builder.duracionFranjaMinutos;
	}

	public UUID getId() {
		return id;
	}

	public BarberoDominio getBarbero() {
		return barbero;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public int getAntelacionMinimaReservaHoras() {
		return antelacionMinimaReservaHoras;
	}

	public int getAntelacionMinimaReprogramacionHoras() {
		return antelacionMinimaReprogramacionHoras;
	}

	public int getDuracionFranjaMinutos() {
		return duracionFranjaMinutos;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private LocalDate fechaInicio;
		private LocalDate fechaFin;
		private int antelacionMinimaReservaHoras;
		private int antelacionMinimaReprogramacionHoras;
		private int duracionFranjaMinutos;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = new BarberoDominio.Builder().build();
			fechaInicio = UtilFecha.FECHA_DEFECTO;
			fechaFin = UtilFecha.FECHA_DEFECTO;
			antelacionMinimaReservaHoras = UtilNumero.CERO;
			antelacionMinimaReprogramacionHoras = UtilNumero.CERO;
			duracionFranjaMinutos = UtilNumero.CERO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder barbero(BarberoDominio barbero) {
			this.barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero,
					new BarberoDominio.Builder().build());
			return this;
		}

		public Builder fechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
			return this;
		}

		public Builder fechaFin(LocalDate fechaFin) {
			this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin);
			return this;
		}

		public Builder antelacionMinimaReservaHoras(int antelacionMinimaReservaHoras) {
			this.antelacionMinimaReservaHoras = antelacionMinimaReservaHoras;
			return this;
		}

		public Builder antelacionMinimaReprogramacionHoras(int antelacionMinimaReprogramacionHoras) {
			this.antelacionMinimaReprogramacionHoras = antelacionMinimaReprogramacionHoras;
			return this;
		}

		public Builder duracionFranjaMinutos(int duracionFranjaMinutos) {
			this.duracionFranjaMinutos = duracionFranjaMinutos;
			return this;
		}

		public HorarioDominio build() {
			return new HorarioDominio(this);
		}
	}
}