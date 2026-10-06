package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
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

	private static final String SELECT = """
			SELECT id, nombre, descripcion
			FROM TipoIdentificacion
			""";

	public TipoIdentificacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoIdentificacionEntidad consultarPorId(UUID id) {
		var filtro = new TipoIdentificacionEntidad();
		filtro.setId(id);
		var tiposIdentificacion = consultarPorFiltro(filtro);
		return tiposIdentificacion.isEmpty() ? new TipoIdentificacionEntidad() : tiposIdentificacion.get(0);
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarTodos() {
		return consultarPorFiltro(new TipoIdentificacionEntidad());
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarPorFiltro(TipoIdentificacionEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new TipoIdentificacionEntidad());
		var condiciones = new ArrayList<String>();
		var parametros = new ArrayList<Object>();

		agregarCondicionesDelFiltro(filtroTmp, condiciones, parametros);
		var sentenciaSql = armarSentenciaSql(condiciones);

		return ejecutarConsulta(sentenciaSql, parametros);
	}

	private void agregarCondicionesDelFiltro(TipoIdentificacionEntidad filtroTmp, List<String> condiciones,
			List<Object> parametros) {
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			condiciones.add("id = ?");
			parametros.add(filtroTmp.getId());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNombre())) {
			condiciones.add("nombre = ?");
			parametros.add(filtroTmp.getNombre());
		}
	}

	private String armarSentenciaSql(List<String> condiciones) {
		var sentenciaSql = new StringBuilder(SELECT);
		if (!condiciones.isEmpty()) {
			sentenciaSql.append(" WHERE ").append(String.join(" AND ", condiciones));
		}
		return sentenciaSql.toString();
	}

	private List<TipoIdentificacionEntidad> ejecutarConsulta(String sentenciaSql, List<Object> parametros) {
		var tiposIdentificacion = new ArrayList<TipoIdentificacionEntidad>();
		try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
			for (var posicion = 0; posicion < parametros.size(); posicion++) {
				sentencia.setObject(posicion + 1, parametros.get(posicion));
			}
			try (var filas = sentencia.executeQuery()) {
				while (filas.next()) {
					tiposIdentificacion.add(convertirFilaAEntidad(filas));
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

	private TipoIdentificacionEntidad convertirFilaAEntidad(ResultSet fila) throws SQLException {
		var tipoIdentificacion = new TipoIdentificacionEntidad();
		tipoIdentificacion.setId(fila.getObject("id", UUID.class));
		tipoIdentificacion.setNombre(fila.getString("nombre"));
		tipoIdentificacion.setDescripcion(fila.getString("descripcion"));
		return tipoIdentificacion;
	}
}
