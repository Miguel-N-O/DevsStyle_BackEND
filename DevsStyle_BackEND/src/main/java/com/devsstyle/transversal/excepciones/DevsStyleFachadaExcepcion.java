package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleFachadaExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleFachadaExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleFachadaExcepcion crear(String mensajeUsuario) {
		return new DevsStyleFachadaExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleFachadaExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleFachadaExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleFachadaExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleFachadaExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
