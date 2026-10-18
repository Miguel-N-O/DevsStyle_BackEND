package com.devsstyle.dao.datos.entidad;

import java.util.UUID;

import com.devsstyle.dao.datos.ActualizarDAO;
import com.devsstyle.dao.datos.ConsultarDAO;
import com.devsstyle.dao.datos.CrearDAO;
import com.devsstyle.dao.datos.EliminarDAO;
import com.devsstyle.entidad.TipoIdentificacionEntidad;

public interface TipoIdentificacionDAO extends CrearDAO<TipoIdentificacionEntidad>, ConsultarDAO<TipoIdentificacionEntidad, UUID>,
		ActualizarDAO<TipoIdentificacionEntidad, UUID>, EliminarDAO<UUID> {
}
