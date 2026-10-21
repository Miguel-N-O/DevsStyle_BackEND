package com.devsstyle.negocio.fachada.impl;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dto.BarberoDTO;
import com.devsstyle.negocio.fachada.BarberoFachada;
import com.devsstyle.negocio.fachada.ensamblador.impl.BarberoEnsambladorDTO;
import com.devsstyle.negocio.negocio.impl.BarberoNegocioImpl;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleExcepcion;
import com.devsstyle.transversal.excepciones.DevsStyleFachadaExcepcion;

public final class BarberoFachadaImpl implements BarberoFachada {

	@Override
	public BarberoDTO registrarBarbero(BarberoDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var barberoNegocio = new BarberoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var barberoDominio = BarberoEnsambladorDTO.getInstancia().convertirADominio(datos);
			var barberoRegistrado = barberoNegocio.registrarBarbero(barberoDominio);
			var respuesta = BarberoEnsambladorDTO.getInstancia().convertirADTO(barberoRegistrado);
			daoFactory.confirmarTransaccion();

			return respuesta;
		} catch (DevsStyleExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = CatalogoMensajes.BarberoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_BARBERO;
			throw DevsStyleFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
