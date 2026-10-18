package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.dao.datos.entidad.TipoIdentificacionDAO;
import com.devsstyle.entidad.TipoIdentificacionEntidad;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleDatosExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class TipoIdentificacionPostgreSqlDAO extends SqlDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(TipoIdentificacionEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("INSERT INTO TipoIdentificacion (id, nombre, descripcion) ");
		sentenciaSql.append("VALUES (?, ?, ?)");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNombre());
			sentencia.setString(3, entidad.getDescripcion());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_CREANDO_TIPO_IDENTIFICACION;
			var mensajeTecnico = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.TECNICO_ERROR_CREANDO_TIPO_IDENTIFICACION
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public TipoIdentificacionEntidad consultarPorId(UUID id) {
		if (UtilUUID.obtenerUUIDDefecto().equals(UtilUUID.obtenerValorDefecto(id))) {
			return new TipoIdentificacionEntidad();
		}

		var filtro = new TipoIdentificacionEntidad();
		filtro.setId(id);

		var tiposIdentificacion = consultarPorFiltro(filtro);

		if (tiposIdentificacion.isEmpty()) {
			return new TipoIdentificacionEntidad();
		}

		return tiposIdentificacion.get(0);
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarPorFiltro(TipoIdentificacionEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new TipoIdentificacionEntidad());
		var parametros = new ArrayList<Object>();

		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT id, nombre, descripcion ");
		sentenciaSql.append("FROM TipoIdentificacion ");
		sentenciaSql.append("WHERE 1 = 1 ");

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			sentenciaSql.append("AND id = ? ");
			parametros.add(filtroTmp.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNombre())) {
			sentenciaSql.append("AND nombre = ? ");
			parametros.add(filtroTmp.getNombre());
		}

		return consultar(sentenciaSql.toString(), parametros);
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarTodos() {
		return consultarPorFiltro(new TipoIdentificacionEntidad());
	}

	@Override
	public void actualizar(UUID id, TipoIdentificacionEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("UPDATE TipoIdentificacion ");
		sentenciaSql.append("SET nombre = ?, descripcion = ? ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setString(1, entidad.getNombre());
			sentencia.setString(2, entidad.getDescripcion());
			sentencia.setObject(3, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_ACTUALIZANDO_TIPO_IDENTIFICACION;
			var mensajeTecnico = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.TECNICO_ERROR_ACTUALIZANDO_TIPO_IDENTIFICACION
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public void eliminar(UUID id) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("DELETE FROM TipoIdentificacion ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_ELIMINANDO_TIPO_IDENTIFICACION;
			var mensajeTecnico = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.TECNICO_ERROR_ELIMINANDO_TIPO_IDENTIFICACION
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	private List<TipoIdentificacionEntidad> consultar(String sentenciaSql, List<Object> parametros) {
		var tiposIdentificacion = new ArrayList<TipoIdentificacionEntidad>();

		try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
			for (int posicion = 0; posicion < parametros.size(); posicion++) {
				sentencia.setObject(posicion + 1, parametros.get(posicion));
			}

			try (var filas = sentencia.executeQuery()) {
				while (filas.next()) {
					var tipoIdentificacion = new TipoIdentificacionEntidad();
					tipoIdentificacion.setId(filas.getObject("id", UUID.class));
					tipoIdentificacion.setNombre(filas.getString("nombre"));
					tipoIdentificacion.setDescripcion(filas.getString("descripcion"));
					tiposIdentificacion.add(tipoIdentificacion);
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_TIPOS_IDENTIFICACION;
			var mensajeTecnico = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.TECNICO_ERROR_CONSULTANDO_TIPOS_IDENTIFICACION
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return tiposIdentificacion;
	}
}
