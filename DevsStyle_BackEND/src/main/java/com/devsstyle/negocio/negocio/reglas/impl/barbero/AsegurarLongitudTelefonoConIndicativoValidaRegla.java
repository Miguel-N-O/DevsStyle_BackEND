package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class AsegurarLongitudTelefonoConIndicativoValidaRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarLongitudTelefonoConIndicativoValidaRegla();
	private static final int LONGITUD_MAXIMA_DIGITOS = 15;

	private AsegurarLongitudTelefonoConIndicativoValidaRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idIndicativoPais = (UUID) datos[0];
		var numeroTelefono = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var indicativoPais = daoFactory.obtenerIndicativoPaisDAO().consultarPorId(idIndicativoPais);
		var digitosIndicativo = indicativoPais.getIndicativo().replace("+", UtilTexto.VACIO);
		var cantidadDigitos = UtilTexto.getUtilTexto().obtenerLongitudCadena(digitosIndicativo)
				+ UtilTexto.getUtilTexto().obtenerLongitudCadena(numeroTelefono);

		if (cantidadDigitos > LONGITUD_MAXIMA_DIGITOS) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_TELEFONO_DEMASIADO_LARGO_PARA_INDICATIVO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
