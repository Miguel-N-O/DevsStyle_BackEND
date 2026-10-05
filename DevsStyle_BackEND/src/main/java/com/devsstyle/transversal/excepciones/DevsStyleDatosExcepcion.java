package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleDatosExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleDatosExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleDatosExcepcion crear(String mensajeUsuario) {
		return new DevsStyleDatosExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleDatosExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleDatosExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleDatosExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleDatosExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
