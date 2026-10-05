package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleDominioExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleDominioExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleDominioExcepcion crear(String mensajeUsuario) {
		return new DevsStyleDominioExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleDominioExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleDominioExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleDominioExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleDominioExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
