package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class AsegurarNumeroIdentificacionCorrespondaTipoRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarNumeroIdentificacionCorrespondaTipoRegla();
	private static final String NOMBRE_TIPO_PASAPORTE = "PA";

	private AsegurarNumeroIdentificacionCorrespondaTipoRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idTipoIdentificacion = (UUID) datos[0];
		var numeroIdentificacion = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var tipoIdentificacion = daoFactory.obtenerTipoIdentificacionDAO().consultarPorId(idTipoIdentificacion);

		if (!NOMBRE_TIPO_PASAPORTE.equals(tipoIdentificacion.getNombre())
				&& !UtilTexto.getUtilTexto().formatoEsValido(numeroIdentificacion, UtilTexto.SOLO_DIGITOS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_IDENTIFICACION_NO_CORRESPONDE_AL_TIPO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
