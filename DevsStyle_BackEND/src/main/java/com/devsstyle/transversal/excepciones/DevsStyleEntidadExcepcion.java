package com.devsstyle.transversal.excepciones;

import com.devsstyle.transversal.excepciones.enums.Capa;

public final class DevsStyleEntidadExcepcion extends DevsStyleExcepcion {

	private static final long serialVersionUID = 1L;

	private DevsStyleEntidadExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static DevsStyleEntidadExcepcion crear(String mensajeUsuario) {
		return new DevsStyleEntidadExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static DevsStyleEntidadExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new DevsStyleEntidadExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static DevsStyleEntidadExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new DevsStyleEntidadExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
