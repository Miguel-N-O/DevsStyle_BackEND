package com.devsstyle.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class UtilFecha {

	public static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);
	public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(1900, 1, 1, 0, 0);
	public static final LocalTime HORA_DEFECTO = LocalTime.of(0, 0);
	public static final LocalDate FECHA_SIN_FIN = LocalDate.of(9999, 12, 31);

	private UtilFecha() {
	}

	public static boolean esNula(final LocalDate fecha) {
		return UtilObjeto.esNulo(fecha);
	}

	public static LocalDate obtenerValorDefecto(final LocalDate fecha, final LocalDate valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fecha, valorDefecto);
	}

	public static LocalDate obtenerValorDefecto(final LocalDate fecha) {
		return obtenerValorDefecto(fecha, FECHA_DEFECTO);
	}

	public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaHora, FECHA_HORA_DEFECTO);
	}

	public static LocalTime obtenerValorDefecto(final LocalTime hora) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(hora, HORA_DEFECTO);
	}

	public static LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}
}