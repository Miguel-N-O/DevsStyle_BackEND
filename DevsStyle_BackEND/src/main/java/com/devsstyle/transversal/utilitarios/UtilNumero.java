package com.devsstyle.transversal.utilitarios;

public final class UtilNumero {

	public static final int CERO = 0;

	private UtilNumero() {
	}

	public static <N extends Number> N obtenerValorDefecto(N valor, N valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static <N extends Number> Number obtenerValorDefecto(N valor) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, CERO);
	}

	public static <N extends Number> boolean mayorQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() > obtenerValorDefecto(numeroDos).doubleValue();
	}
}