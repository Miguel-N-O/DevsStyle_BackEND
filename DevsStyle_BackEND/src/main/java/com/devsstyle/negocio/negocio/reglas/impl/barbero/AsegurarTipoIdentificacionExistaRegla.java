package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class AsegurarTipoIdentificacionExistaRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarTipoIdentificacionExistaRegla();

	private AsegurarTipoIdentificacionExistaRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idTipoIdentificacion = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var tipoIdentificacion = daoFactory.obtenerTipoIdentificacionDAO().consultarPorId(idTipoIdentificacion);

		if (UtilUUID.obtenerUUIDDefecto().equals(tipoIdentificacion.getId())) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_TIPO_IDENTIFICACION_NO_EXISTE;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
