package com.devsstyle.negocio.fachada.impl;

import java.util.List;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dto.TipoIdentificacionDTO;
import com.devsstyle.negocio.fachada.TipoIdentificacionFachada;
import com.devsstyle.negocio.fachada.ensamblador.impl.TipoIdentificacionEnsambladorDTO;
import com.devsstyle.negocio.negocio.impl.TipoIdentificacionNegocioImpl;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleExcepcion;
import com.devsstyle.transversal.excepciones.DevsStyleFachadaExcepcion;

public final class TipoIdentificacionFachadaImpl implements TipoIdentificacionFachada {

	@Override
	public List<TipoIdentificacionDTO> consultarTiposIdentificacion(TipoIdentificacionDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var tipoIdentificacionNegocio = new TipoIdentificacionNegocioImpl(daoFactory);

		try {
			var filtroDominio = TipoIdentificacionEnsambladorDTO.getInstancia().convertirADominio(filtro);
			var tiposIdentificacion = tipoIdentificacionNegocio.consultarTiposIdentificacion(filtroDominio);

			return TipoIdentificacionEnsambladorDTO.getInstancia().convertirADTO(tiposIdentificacion);
		} catch (DevsStyleExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_IDENTIFICACION;
			throw DevsStyleFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
