package com.devsstyle.negocio.negocio.ensamblador.impl;

import com.devsstyle.dominio.TipoIdentificacionDominio;
import com.devsstyle.entidad.TipoIdentificacionEntidad;
import com.devsstyle.negocio.negocio.ensamblador.EnsambladorEntidad;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class TipoIdentificacionEnsambladorEntidad
		implements EnsambladorEntidad<TipoIdentificacionDominio, TipoIdentificacionEntidad> {

	private static final EnsambladorEntidad<TipoIdentificacionDominio, TipoIdentificacionEntidad> instancia = new TipoIdentificacionEnsambladorEntidad();

	private TipoIdentificacionEnsambladorEntidad() {
	}

	public static EnsambladorEntidad<TipoIdentificacionDominio, TipoIdentificacionEntidad> getInstancia() {
		return instancia;
	}

	@Override
	public TipoIdentificacionEntidad convertirAEntidad(TipoIdentificacionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new TipoIdentificacionDominio.Builder().build());

		return new TipoIdentificacionEntidad(dominioTmp.getId(), dominioTmp.getNombre(),
				dominioTmp.getDescripcion());
	}

	@Override
	public TipoIdentificacionDominio convertirADominio(TipoIdentificacionEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad,
				new TipoIdentificacionEntidad());

		return new TipoIdentificacionDominio.Builder().id(entidadTmp.getId()).nombre(entidadTmp.getNombre())
				.descripcion(entidadTmp.getDescripcion()).build();
	}
}