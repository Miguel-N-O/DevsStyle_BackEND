package com.devsstyle.negocio.negocio.ensamblador.impl;

import com.devsstyle.dominio.BarberoDominio;
import com.devsstyle.entidad.BarberoEntidad;
import com.devsstyle.negocio.negocio.ensamblador.EnsambladorEntidad;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class BarberoEnsambladorEntidad implements EnsambladorEntidad<BarberoDominio, BarberoEntidad> {

	private static final EnsambladorEntidad<BarberoDominio, BarberoEntidad> instancia = new BarberoEnsambladorEntidad();

	private BarberoEnsambladorEntidad() {
	}

	public static EnsambladorEntidad<BarberoDominio, BarberoEntidad> getInstancia() {
		return instancia;
	}

	@Override
	public BarberoEntidad convertirAEntidad(BarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new BarberoDominio.Builder().build());

		var tipoIdentificacionEntidad = TipoIdentificacionEnsambladorEntidad.getInstancia()
				.convertirAEntidad(dominioTmp.getTipoIdentificacion());
		var indicativoPaisEntidad = IndicativoPaisEnsambladorEntidad.getInstancia()
				.convertirAEntidad(dominioTmp.getIndicativoPais());

		return new BarberoEntidad(dominioTmp.getId(), tipoIdentificacionEntidad,
				dominioTmp.getNumeroIdentificacion(), dominioTmp.getPrimerNombre(), dominioTmp.getSegundoNombre(),
				dominioTmp.getPrimerApellido(), dominioTmp.getSegundoApellido(), indicativoPaisEntidad,
				dominioTmp.getNumeroTelefono(), dominioTmp.getCorreoElectronico(), dominioTmp.isNumeroVerificado(),
				dominioTmp.isActivo());
	}

	@Override
	public BarberoDominio convertirADominio(BarberoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new BarberoEntidad());

		var tipoIdentificacionDominio = TipoIdentificacionEnsambladorEntidad.getInstancia()
				.convertirADominio(entidadTmp.getTipoIdentificacion());
		var indicativoPaisDominio = IndicativoPaisEnsambladorEntidad.getInstancia()
				.convertirADominio(entidadTmp.getIndicativoPais());

		return new BarberoDominio.Builder().id(entidadTmp.getId()).tipoIdentificacion(tipoIdentificacionDominio)
				.numeroIdentificacion(entidadTmp.getNumeroIdentificacion())
				.primerNombre(entidadTmp.getPrimerNombre()).segundoNombre(entidadTmp.getSegundoNombre())
				.primerApellido(entidadTmp.getPrimerApellido()).segundoApellido(entidadTmp.getSegundoApellido())
				.indicativoPais(indicativoPaisDominio).numeroTelefono(entidadTmp.getNumeroTelefono())
				.correoElectronico(entidadTmp.getCorreoElectronico())
				.numeroVerificado(entidadTmp.isNumeroVerificado()).activo(entidadTmp.isActivo()).build();
	}
}