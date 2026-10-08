package com.devsstyle.negocio.negocio.ensamblador.impl;

import com.devsstyle.dominio.IndicativoPaisDominio;
import com.devsstyle.entidad.IndicativoPaisEntidad;
import com.devsstyle.negocio.negocio.ensamblador.EnsambladorEntidad;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class IndicativoPaisEnsambladorEntidad
		implements EnsambladorEntidad<IndicativoPaisDominio, IndicativoPaisEntidad> {

	private static final EnsambladorEntidad<IndicativoPaisDominio, IndicativoPaisEntidad> instancia = new IndicativoPaisEnsambladorEntidad();

	private IndicativoPaisEnsambladorEntidad() {
	}

	public static EnsambladorEntidad<IndicativoPaisDominio, IndicativoPaisEntidad> getInstancia() {
		return instancia;
	}

	@Override
	public IndicativoPaisEntidad convertirAEntidad(IndicativoPaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new IndicativoPaisDominio.Builder().build());

		return new IndicativoPaisEntidad(dominioTmp.getId(), dominioTmp.getPais(), dominioTmp.getIndicativo());
	}

	@Override
	public IndicativoPaisDominio convertirADominio(IndicativoPaisEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad,
				new IndicativoPaisEntidad());

		return new IndicativoPaisDominio.Builder().id(entidadTmp.getId()).pais(entidadTmp.getPais())
				.indicativo(entidadTmp.getIndicativo()).build();
	}
}