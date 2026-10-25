package com.devsstyle.negocio.fachada.impl;

import java.util.List;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dto.IndicativoPaisDTO;
import com.devsstyle.negocio.fachada.IndicativoPaisFachada;
import com.devsstyle.negocio.fachada.ensamblador.impl.IndicativoPaisEnsambladorDTO;
import com.devsstyle.negocio.negocio.impl.IndicativoPaisNegocioImpl;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleExcepcion;
import com.devsstyle.transversal.excepciones.DevsStyleFachadaExcepcion;

public final class IndicativoPaisFachadaImpl implements IndicativoPaisFachada {

	@Override
	public List<IndicativoPaisDTO> consultarIndicativosPais(IndicativoPaisDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var indicativoPaisNegocio = new IndicativoPaisNegocioImpl(daoFactory);

		try {
			var filtroDominio = IndicativoPaisEnsambladorDTO.getInstancia().convertirADominio(filtro);
			var indicativosPais = indicativoPaisNegocio.consultarIndicativosPais(filtroDominio);

			return IndicativoPaisEnsambladorDTO.getInstancia().convertirADTO(indicativosPais);
		} catch (DevsStyleExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INDICATIVOS_PAIS;
			throw DevsStyleFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
