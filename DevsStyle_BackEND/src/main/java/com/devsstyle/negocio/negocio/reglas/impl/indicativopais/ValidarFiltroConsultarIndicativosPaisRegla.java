package com.devsstyle.negocio.negocio.reglas.impl.indicativopais;

import com.devsstyle.dominio.IndicativoPaisDominio;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class ValidarFiltroConsultarIndicativosPaisRegla implements Regla<IndicativoPaisDominio> {

	private static final Regla<IndicativoPaisDominio> instancia = new ValidarFiltroConsultarIndicativosPaisRegla();

	private ValidarFiltroConsultarIndicativosPaisRegla() {
	}

	public static final Regla<IndicativoPaisDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(IndicativoPaisDominio... datos) {
		var filtro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(datos[0],
				new IndicativoPaisDominio.Builder().build());

		validarPais(filtro.getPais());
		validarIndicativo(filtro.getIndicativo());
	}

	private void validarPais(String pais) {
		if (UtilTexto.getUtilTexto().esVacia(pais)) {
			return;
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(pais, UtilTexto.SOLO_LETRAS_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisNegocioImpl.USUARIO_ERROR_FILTRO_PAIS_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(pais, 3, 50, true)) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisNegocioImpl.USUARIO_ERROR_FILTRO_PAIS_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarIndicativo(String indicativo) {
		if (UtilTexto.getUtilTexto().esVacia(indicativo)) {
			return;
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(indicativo, UtilTexto.INDICATIVO_PAIS)) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisNegocioImpl.USUARIO_ERROR_FILTRO_INDICATIVO_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(indicativo, 2, 5, true)) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisNegocioImpl.USUARIO_ERROR_FILTRO_INDICATIVO_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
