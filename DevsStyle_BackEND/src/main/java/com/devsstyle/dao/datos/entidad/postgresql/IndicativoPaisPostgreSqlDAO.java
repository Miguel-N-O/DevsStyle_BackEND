package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.IndicativoPaisDAO;
import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.entidad.IndicativoPaisEntidad;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleDatosExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class IndicativoPaisPostgreSqlDAO extends SqlDAO implements IndicativoPaisDAO {

	public IndicativoPaisPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(IndicativoPaisEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("INSERT INTO IndicativoPais (id, pais, indicativo) ");
		sentenciaSql.append("VALUES (?, ?, ?)");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getPais());
			sentencia.setString(3, entidad.getIndicativo());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.USUARIO_ERROR_CREANDO_INDICATIVO_PAIS;
			var mensajeTecnico = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.TECNICO_ERROR_CREANDO_INDICATIVO_PAIS
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public IndicativoPaisEntidad consultarPorId(UUID id) {
		if (UtilUUID.obtenerUUIDDefecto().equals(UtilUUID.obtenerValorDefecto(id))) {
			return new IndicativoPaisEntidad();
		}

		var filtro = new IndicativoPaisEntidad();
		filtro.setId(id);

		var indicativosPais = consultarPorFiltro(filtro);

		if (indicativosPais.isEmpty()) {
			return new IndicativoPaisEntidad();
		}

		return indicativosPais.get(0);
	}

	@Override
	public List<IndicativoPaisEntidad> consultarPorFiltro(IndicativoPaisEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new IndicativoPaisEntidad());
		var parametros = new ArrayList<Object>();

		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT id, pais, indicativo ");
		sentenciaSql.append("FROM IndicativoPais ");

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			sentenciaSql.append(parametros.isEmpty() ? "WHERE " : "AND ");
			sentenciaSql.append("id = ? ");
			parametros.add(filtroTmp.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getPais())) {
			sentenciaSql.append(parametros.isEmpty() ? "WHERE " : "AND ");
			sentenciaSql.append("pais = ? ");
			parametros.add(filtroTmp.getPais());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getIndicativo())) {
			sentenciaSql.append(parametros.isEmpty() ? "WHERE " : "AND ");
			sentenciaSql.append("indicativo = ? ");
			parametros.add(filtroTmp.getIndicativo());
		}

		return consultar(sentenciaSql.toString(), parametros);
	}

	@Override
	public List<IndicativoPaisEntidad> consultarTodos() {
		return consultarPorFiltro(new IndicativoPaisEntidad());
	}

	@Override
	public void actualizar(UUID id, IndicativoPaisEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("UPDATE IndicativoPais ");
		sentenciaSql.append("SET pais = ?, indicativo = ? ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setString(1, entidad.getPais());
			sentencia.setString(2, entidad.getIndicativo());
			sentencia.setObject(3, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.USUARIO_ERROR_ACTUALIZANDO_INDICATIVO_PAIS;
			var mensajeTecnico = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.TECNICO_ERROR_ACTUALIZANDO_INDICATIVO_PAIS
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public void eliminar(UUID id) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("DELETE FROM IndicativoPais ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.USUARIO_ERROR_ELIMINANDO_INDICATIVO_PAIS;
			var mensajeTecnico = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.TECNICO_ERROR_ELIMINANDO_INDICATIVO_PAIS
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	private List<IndicativoPaisEntidad> consultar(String sentenciaSql, List<Object> parametros) {
		var indicativosPais = new ArrayList<IndicativoPaisEntidad>();

		try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
			for (int posicion = 0; posicion < parametros.size(); posicion++) {
				sentencia.setObject(posicion + 1, parametros.get(posicion));
			}

			try (var filas = sentencia.executeQuery()) {
				while (filas.next()) {
					var indicativoPais = new IndicativoPaisEntidad();
					indicativoPais.setId(filas.getObject("id", UUID.class));
					indicativoPais.setPais(filas.getString("pais"));
					indicativoPais.setIndicativo(filas.getString("indicativo"));
					indicativosPais.add(indicativoPais);
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_INDICATIVOS_PAIS;
			var mensajeTecnico = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.TECNICO_ERROR_CONSULTANDO_INDICATIVOS_PAIS
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return indicativosPais;
	}
}
