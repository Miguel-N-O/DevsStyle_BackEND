package com.devsstyle.transversal.utilitarios;

public final class UtilTexto {

	private static UtilTexto instancia;
	public static final String VACIO = "";

	private UtilTexto() {
	}

	public static UtilTexto getUtilTexto() {
		if (UtilObjeto.esNulo(instancia)) {
			synchronized (UtilTexto.class) {
				if (UtilObjeto.esNulo(instancia)) {
					instancia = new UtilTexto();
				}
			}
		}
		return instancia;
	}
	

	public boolean esNula(String cadena) {
		return UtilObjeto.esNulo(cadena);
	}
	

	public boolean esVacia(String cadena) {
		return VACIO.equals(obtenerValorDefecto(cadena));
	}
	

	public String obtenerValorDefecto(String valor, String valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	

	public String obtenerValorDefecto(String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	

	public String quitarEspacioEnBlanco(String valor) {
		return obtenerValorDefecto(valor).trim();
	}

	public int obtenerLongitudCadena(String valor) {
		return obtenerValorDefecto(valor).length();
	}

	
	public int obtenerLongitudCadena(String valor, boolean quitarEspaciosBlanco) {
		return quitarEspaciosBlanco
				? obtenerLongitudCadena(quitarEspacioEnBlanco(valor))
				: obtenerLongitudCadena(valor);
	}
	

	public boolean obtenerLongitudCadenaEsValida(String valor, int longitudInicial, int longitudFinal,
			boolean quitarEspaciosBlanco) {
		var longitud = obtenerLongitudCadena(valor, quitarEspaciosBlanco);
		return longitud >= longitudInicial && longitud <= longitudFinal;
	}
}