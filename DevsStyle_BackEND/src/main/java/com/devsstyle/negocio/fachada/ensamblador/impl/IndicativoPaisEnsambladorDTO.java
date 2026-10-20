package com.devsstyle.negocio.fachada.ensamblador.impl;

import java.util.ArrayList;
import java.util.List;

import com.devsstyle.dominio.IndicativoPaisDominio;
import com.devsstyle.dto.IndicativoPaisDTO;
import com.devsstyle.negocio.fachada.ensamblador.EnsambladorDTO;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class IndicativoPaisEnsambladorDTO implements EnsambladorDTO<IndicativoPaisDominio, IndicativoPaisDTO> {

	private static final EnsambladorDTO<IndicativoPaisDominio, IndicativoPaisDTO> instancia = new IndicativoPaisEnsambladorDTO();

	private IndicativoPaisEnsambladorDTO() {
	}

	public static EnsambladorDTO<IndicativoPaisDominio, IndicativoPaisDTO> getInstancia() {
		return instancia;
	}

	@Override
	public IndicativoPaisDTO convertirADTO(IndicativoPaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new IndicativoPaisDominio.Builder().build());

		var dto = new IndicativoPaisDTO();
		dto.setId(dominioTmp.getId());
		dto.setPais(dominioTmp.getPais());
		dto.setIndicativo(dominioTmp.getIndicativo());

		return dto;
	}

	@Override
	public IndicativoPaisDominio convertirADominio(IndicativoPaisDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new IndicativoPaisDTO());

		return new IndicativoPaisDominio.Builder().id(dtoTmp.getId()).pais(dtoTmp.getPais())
				.indicativo(dtoTmp.getIndicativo()).build();
	}

	@Override
	public List<IndicativoPaisDTO> convertirADTO(List<IndicativoPaisDominio> listaDominios) {
		var listaTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<IndicativoPaisDominio>());

		return listaTmp.stream().map(this::convertirADTO).toList();
	}
}
