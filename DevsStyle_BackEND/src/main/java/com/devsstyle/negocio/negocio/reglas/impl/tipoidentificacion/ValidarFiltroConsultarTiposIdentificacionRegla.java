package com.devsstyle.negocio.negocio.reglas.impl.tipoidentificacion;

import com.devsstyle.dominio.TipoIdentificacionDominio;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class ValidarFiltroConsultarTiposIdentificacionRegla implements Regla<TipoIdentificacionDominio> {

	private static final Regla<TipoIdentificacionDominio> instancia = new ValidarFiltroConsultarTiposIdentificacionRegla();

	private ValidarFiltroConsultarTiposIdentificacionRegla() {
	}

	public static final Regla<TipoIdentificacionDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(TipoIdentificacionDominio... datos) {
		var filtro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(datos[0],
				new TipoIdentificacionDominio.Builder().build());

		validarNombre(filtro.getNombre());
	}

	private void validarNombre(String nombre) {
		if (UtilTexto.getUtilTexto().esVacia(nombre)) {
			return;
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(nombre, UtilTexto.SOLO_LETRAS)) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionNegocioImpl.USUARIO_ERROR_FILTRO_NOMBRE_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(nombre, 2, 5, true)) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionNegocioImpl.USUARIO_ERROR_FILTRO_NOMBRE_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
