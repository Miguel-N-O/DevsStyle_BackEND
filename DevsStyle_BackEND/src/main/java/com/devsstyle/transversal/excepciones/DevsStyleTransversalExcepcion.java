package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleTransversalExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleTransversalExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleTransversalExcepcion crear(String mensajeUsuario) {
		return new DevsStyleTransversalExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleTransversalExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleTransversalExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleTransversalExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleTransversalExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
