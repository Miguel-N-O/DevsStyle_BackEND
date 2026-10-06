package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.BarberoDAO;
import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.entidad.BarberoEntidad;

public final class BarberoPostgreSqlDAO extends SqlDAO implements BarberoDAO {

	public BarberoPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(BarberoEntidad entidad) {
	}

	@Override
	public BarberoEntidad consultarPorId(UUID id) {
		return new BarberoEntidad();
	}

	@Override
	public List<BarberoEntidad> consultarPorFiltro(BarberoEntidad filtro) {
		return new ArrayList<>();
	}

	@Override
	public List<BarberoEntidad> consultarTodos() {
		return new ArrayList<>();
	}
}
