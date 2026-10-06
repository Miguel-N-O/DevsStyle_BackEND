package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.dao.datos.entidad.TipoIdentificacionDAO;
import com.devsstyle.entidad.TipoIdentificacionEntidad;

public final class TipoIdentificacionPostgreSqlDAO extends SqlDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoIdentificacionEntidad consultarPorId(UUID id) {
		return new TipoIdentificacionEntidad();
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarPorFiltro(TipoIdentificacionEntidad filtro) {
		return new ArrayList<>();
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarTodos() {
		return new ArrayList<>();
	}
}
