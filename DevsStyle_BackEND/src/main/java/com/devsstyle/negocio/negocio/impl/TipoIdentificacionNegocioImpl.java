package com.devsstyle.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dominio.TipoIdentificacionDominio;
import com.devsstyle.entidad.TipoIdentificacionEntidad;
import com.devsstyle.negocio.negocio.TipoIdentificacionNegocio;
import com.devsstyle.negocio.negocio.ensamblador.impl.TipoIdentificacionEnsambladorEntidad;
import com.devsstyle.negocio.negocio.reglas.impl.tipoidentificacion.ValidarFiltroConsultarTiposIdentificacionRegla;

public final class TipoIdentificacionNegocioImpl implements TipoIdentificacionNegocio {

	private DAOFactory daoFactory;

	public TipoIdentificacionNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public TipoIdentificacionDominio registrarTipoIdentificacion(TipoIdentificacionDominio datos) {
		return new TipoIdentificacionDominio.Builder().build();
	}

	@Override
	public TipoIdentificacionDominio actualizarTipoIdentificacion(UUID id, TipoIdentificacionDominio datos) {
		return new TipoIdentificacionDominio.Builder().build();
	}

	@Override
	public void eliminarTipoIdentificacion(UUID id) {
	}

	@Override
	public TipoIdentificacionDominio consultarTipoIdentificacionPorId(UUID id) {
		return new TipoIdentificacionDominio.Builder().build();
	}

	@Override
	public List<TipoIdentificacionDominio> consultarTiposIdentificacion(TipoIdentificacionDominio filtro) {
		ValidarFiltroConsultarTiposIdentificacionRegla.obtenerInstancia().ejecutar(filtro);

		var filtroEntidad = TipoIdentificacionEnsambladorEntidad.getInstancia().convertirAEntidad(filtro);
		var listaEntidades = daoFactory.obtenerTipoIdentificacionDAO().consultarPorFiltro(filtroEntidad);

		return convertirListaADominio(listaEntidades);
	}

	private List<TipoIdentificacionDominio> convertirListaADominio(List<TipoIdentificacionEntidad> listaEntidades) {
		var resultados = new ArrayList<TipoIdentificacionDominio>();

		for (TipoIdentificacionEntidad tipoIdentificacionEntidad : listaEntidades) {
			resultados.add(TipoIdentificacionEnsambladorEntidad.getInstancia().convertirADominio(tipoIdentificacionEntidad));
		}

		return resultados;
	}
}
