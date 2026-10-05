package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleNegocioExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleNegocioExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleNegocioExcepcion crear(String mensajeUsuario) {
		return new DevsStyleNegocioExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleNegocioExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleNegocioExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleNegocioExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleNegocioExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
