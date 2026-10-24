package com.devsstyle.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dominio.IndicativoPaisDominio;
import com.devsstyle.entidad.IndicativoPaisEntidad;
import com.devsstyle.negocio.negocio.IndicativoPaisNegocio;
import com.devsstyle.negocio.negocio.ensamblador.impl.IndicativoPaisEnsambladorEntidad;
import com.devsstyle.negocio.negocio.reglas.impl.indicativopais.ValidarFiltroConsultarIndicativosPaisRegla;

public final class IndicativoPaisNegocioImpl implements IndicativoPaisNegocio {

	private DAOFactory daoFactory;

	public IndicativoPaisNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public IndicativoPaisDominio registrarIndicativoPais(IndicativoPaisDominio datos) {
		return new IndicativoPaisDominio.Builder().build();
	}

	@Override
	public IndicativoPaisDominio actualizarIndicativoPais(UUID id, IndicativoPaisDominio datos) {
		return new IndicativoPaisDominio.Builder().build();
	}

	@Override
	public void eliminarIndicativoPais(UUID id) {
	}

	@Override
	public IndicativoPaisDominio consultarIndicativoPaisPorId(UUID id) {
		return new IndicativoPaisDominio.Builder().build();
	}

	@Override
	public List<IndicativoPaisDominio> consultarIndicativosPais(IndicativoPaisDominio filtro) {
		ValidarFiltroConsultarIndicativosPaisRegla.obtenerInstancia().ejecutar(filtro);

		var filtroEntidad = IndicativoPaisEnsambladorEntidad.getInstancia().convertirAEntidad(filtro);
		var listaEntidades = daoFactory.obtenerIndicativoPaisDAO().consultarPorFiltro(filtroEntidad);

		return convertirListaADominio(listaEntidades);
	}

	private List<IndicativoPaisDominio> convertirListaADominio(List<IndicativoPaisEntidad> listaEntidades) {
		var resultados = new ArrayList<IndicativoPaisDominio>();

		for (IndicativoPaisEntidad indicativoPaisEntidad : listaEntidades) {
			resultados.add(IndicativoPaisEnsambladorEntidad.getInstancia().convertirADominio(indicativoPaisEntidad));
		}

		return resultados;
	}
}
