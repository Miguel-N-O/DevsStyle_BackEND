package com.devsstyle.negocio.fachada.ensamblador.impl;

import java.util.ArrayList;
import java.util.List;

import com.devsstyle.dominio.BarberoDominio;
import com.devsstyle.dto.BarberoDTO;
import com.devsstyle.negocio.fachada.ensamblador.EnsambladorDTO;
import com.devsstyle.transversal.utilitarios.UtilObjeto;

public final class BarberoEnsambladorDTO implements EnsambladorDTO<BarberoDominio, BarberoDTO> {

	private static final EnsambladorDTO<BarberoDominio, BarberoDTO> instancia = new BarberoEnsambladorDTO();

	private BarberoEnsambladorDTO() {
	}

	public static EnsambladorDTO<BarberoDominio, BarberoDTO> getInstancia() {
		return instancia;
	}

	@Override
	public BarberoDTO convertirADTO(BarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new BarberoDominio.Builder().build());

		var tipoIdentificacionDTO = TipoIdentificacionEnsambladorDTO.getInstancia()
				.convertirADTO(dominioTmp.getTipoIdentificacion());
		var indicativoPaisDTO = IndicativoPaisEnsambladorDTO.getInstancia()
				.convertirADTO(dominioTmp.getIndicativoPais());

		var dto = new BarberoDTO();
		dto.setId(dominioTmp.getId());
		dto.setTipoIdentificacion(tipoIdentificacionDTO);
		dto.setNumeroIdentificacion(dominioTmp.getNumeroIdentificacion());
		dto.setPrimerNombre(dominioTmp.getPrimerNombre());
		dto.setSegundoNombre(dominioTmp.getSegundoNombre());
		dto.setPrimerApellido(dominioTmp.getPrimerApellido());
		dto.setSegundoApellido(dominioTmp.getSegundoApellido());
		dto.setIndicativoPais(indicativoPaisDTO);
		dto.setNumeroTelefono(dominioTmp.getNumeroTelefono());
		dto.setCorreoElectronico(dominioTmp.getCorreoElectronico());
		dto.setNumeroVerificado(dominioTmp.isNumeroVerificado());
		dto.setActivo(dominioTmp.isActivo());

		return dto;
	}

	@Override
	public BarberoDominio convertirADominio(BarberoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new BarberoDTO());

		var tipoIdentificacionDominio = TipoIdentificacionEnsambladorDTO.getInstancia()
				.convertirADominio(dtoTmp.getTipoIdentificacion());
		var indicativoPaisDominio = IndicativoPaisEnsambladorDTO.getInstancia()
				.convertirADominio(dtoTmp.getIndicativoPais());

		return new BarberoDominio.Builder().id(dtoTmp.getId()).tipoIdentificacion(tipoIdentificacionDominio)
				.numeroIdentificacion(dtoTmp.getNumeroIdentificacion())
				.primerNombre(dtoTmp.getPrimerNombre()).segundoNombre(dtoTmp.getSegundoNombre())
				.primerApellido(dtoTmp.getPrimerApellido()).segundoApellido(dtoTmp.getSegundoApellido())
				.indicativoPais(indicativoPaisDominio).numeroTelefono(dtoTmp.getNumeroTelefono())
				.correoElectronico(dtoTmp.getCorreoElectronico())
				.numeroVerificado(dtoTmp.isNumeroVerificado()).activo(dtoTmp.isActivo()).build();
	}

	@Override
	public List<BarberoDTO> convertirADTO(List<BarberoDominio> listaDominios) {
		var listaTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<BarberoDominio>());

		return listaTmp.stream().map(this::convertirADTO).toList();
	}
}
