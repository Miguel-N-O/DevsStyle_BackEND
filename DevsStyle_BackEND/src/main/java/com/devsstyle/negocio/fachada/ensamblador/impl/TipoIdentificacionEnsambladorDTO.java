package com.devsstyle.negocio.fachada.ensamblador.impl;

import java.util.ArrayList;
import java.util.List;

import com.devsstyle.dominio.TipoIdentificacionDominio;
import com.devsstyle.dto.TipoIdentificacionDTO;
import com.devsstyle.negocio.fachada.ensamblador.EnsambladorDTO;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class TipoIdentificacionEnsambladorDTO implements EnsambladorDTO<TipoIdentificacionDominio, TipoIdentificacionDTO> {

	private static final EnsambladorDTO<TipoIdentificacionDominio, TipoIdentificacionDTO> instancia = new TipoIdentificacionEnsambladorDTO();

	private TipoIdentificacionEnsambladorDTO() {
	}

	public static EnsambladorDTO<TipoIdentificacionDominio, TipoIdentificacionDTO> getInstancia() {
		return instancia;
	}

	@Override
	public TipoIdentificacionDTO convertirADTO(TipoIdentificacionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new TipoIdentificacionDominio.Builder().build());

		var dto = new TipoIdentificacionDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setDescripcion(dominioTmp.getDescripcion());

		return dto;
	}

	@Override
	public TipoIdentificacionDominio convertirADominio(TipoIdentificacionDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new TipoIdentificacionDTO());

		return new TipoIdentificacionDominio.Builder().id(dtoTmp.getId()).nombre(dtoTmp.getNombre())
				.descripcion(dtoTmp.getDescripcion()).build();
	}

	@Override
	public List<TipoIdentificacionDTO> convertirADTO(List<TipoIdentificacionDominio> listaDominios) {
		var listaTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<TipoIdentificacionDominio>());

		return listaTmp.stream().map(this::convertirADTO).toList();
	}
}
