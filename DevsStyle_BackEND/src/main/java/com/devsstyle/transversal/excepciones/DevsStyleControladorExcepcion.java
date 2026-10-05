package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleControladorExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleControladorExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleControladorExcepcion crear(String mensajeUsuario) {
		return new DevsStyleControladorExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleControladorExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleControladorExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleControladorExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleControladorExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
