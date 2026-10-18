package com.devsstyle.dao.datos.entidad;

import java.util.UUID;

import com.devsstyle.dao.datos.ActualizarDAO;
import com.devsstyle.dao.datos.ConsultarDAO;
import com.devsstyle.dao.datos.CrearDAO;
import com.devsstyle.dao.datos.EliminarDAO;
import com.devsstyle.entidad.BarberoEntidad;

public interface BarberoDAO extends CrearDAO<BarberoEntidad>, ConsultarDAO<BarberoEntidad, UUID>,
		ActualizarDAO<BarberoEntidad, UUID>, EliminarDAO<UUID> {
}
