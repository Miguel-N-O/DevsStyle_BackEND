package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.IndicativoPaisDAO;
import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.entidad.IndicativoPaisEntidad;

public final class IndicativoPaisPostgreSqlDAO extends SqlDAO implements IndicativoPaisDAO {

	public IndicativoPaisPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public IndicativoPaisEntidad consultarPorId(UUID id) {
		return new IndicativoPaisEntidad();
	}

	@Override
	public List<IndicativoPaisEntidad> consultarPorFiltro(IndicativoPaisEntidad filtro) {
		return new ArrayList<>();
	}

	@Override
	public List<IndicativoPaisEntidad> consultarTodos() {
		return new ArrayList<>();
	}
}
