package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.datos.entidad.BarberoDAO;
import com.devsstyle.dao.datos.entidad.SqlDAO;
import com.devsstyle.entidad.BarberoEntidad;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleDatosExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BarberoPostgreSqlDAO extends SqlDAO implements BarberoDAO {

	private static final String SELECT = """
			SELECT id, tipo_identificacion_id, numero_identificacion, primer_nombre,
				segundo_nombre, primer_apellido, segundo_apellido, indicativo_pais_id,
				numero_telefono, correo_electronico, numero_verificado, activo
			FROM Barbero
			""";

	private static final String INSERT = """
			INSERT INTO Barbero (id, tipo_identificacion_id, numero_identificacion, primer_nombre,
				segundo_nombre, primer_apellido, segundo_apellido, indicativo_pais_id,
				numero_telefono, correo_electronico, numero_verificado, activo)
			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";

	public BarberoPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(BarberoEntidad entidad) {
		try (var sentencia = getConexion().prepareStatement(INSERT)) {
			sentencia.setObject(1, entidad.getId());
			sentencia.setObject(2, entidad.getTipoIdentificacion().getId());
			sentencia.setString(3, entidad.getNumeroIdentificacion());
			sentencia.setString(4, entidad.getPrimerNombre());
			sentencia.setString(5, entidad.getSegundoNombre());
			sentencia.setString(6, entidad.getPrimerApellido());
			sentencia.setString(7, entidad.getSegundoApellido());
			sentencia.setObject(8, entidad.getIndicativoPais().getId());
			sentencia.setString(9, entidad.getNumeroTelefono());
			sentencia.setString(10, entidad.getCorreoElectronico());
			sentencia.setBoolean(11, entidad.isNumeroVerificado());
			sentencia.setBoolean(12, entidad.isActivo());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.BarberoPostgreSqlDAO.USUARIO_ERROR_CREANDO_BARBERO;
			var mensajeTecnico = CatalogoMensajes.BarberoPostgreSqlDAO.TECNICO_ERROR_CREANDO_BARBERO
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public BarberoEntidad consultarPorId(UUID id) {
		if (UtilUUID.obtenerUUIDDefecto().equals(UtilUUID.obtenerValorDefecto(id))) {
			return new BarberoEntidad();
		}
		var filtro = new BarberoEntidad();
		filtro.setId(id);
		var barberos = consultarPorFiltro(filtro);
		return barberos.isEmpty() ? new BarberoEntidad() : barberos.get(0);
	}

	@Override
	public List<BarberoEntidad> consultarTodos() {
		return consultarPorFiltro(new BarberoEntidad());
	}

	@Override
	public List<BarberoEntidad> consultarPorFiltro(BarberoEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BarberoEntidad());
		var condiciones = new ArrayList<String>();
		var parametros = new ArrayList<Object>();

		agregarCondicionesDelFiltro(filtroTmp, condiciones, parametros);
		var sentenciaSql = armarSentenciaSql(condiciones);

		return ejecutarConsulta(sentenciaSql, parametros);
	}

	private void agregarCondicionesDelFiltro(BarberoEntidad filtroTmp, List<String> condiciones,
			List<Object> parametros) {
		agregarCondicionDeId(filtroTmp.getId(), "id", condiciones, parametros);
		agregarCondicionDeId(filtroTmp.getTipoIdentificacion().getId(), "tipo_identificacion_id", condiciones,
				parametros);
		agregarCondicionDeTexto(filtroTmp.getNumeroIdentificacion(), "numero_identificacion", condiciones,
				parametros);
		agregarCondicionDeId(filtroTmp.getIndicativoPais().getId(), "indicativo_pais_id", condiciones, parametros);
		agregarCondicionDeTexto(filtroTmp.getNumeroTelefono(), "numero_telefono", condiciones, parametros);
		agregarCondicionDeTexto(filtroTmp.getCorreoElectronico(), "correo_electronico", condiciones, parametros);
	}

	private void agregarCondicionDeId(UUID valor, String columna, List<String> condiciones,
			List<Object> parametros) {
		if (!UtilUUID.obtenerUUIDDefecto().equals(valor)) {
			condiciones.add(columna + " = ?");
			parametros.add(valor);
		}
	}

	private void agregarCondicionDeTexto(String valor, String columna, List<String> condiciones,
			List<Object> parametros) {
		if (!UtilTexto.getUtilTexto().esVacia(valor)) {
			condiciones.add(columna + " = ?");
			parametros.add(valor);
		}
	}

	private String armarSentenciaSql(List<String> condiciones) {
		var sentenciaSql = new StringBuilder(SELECT);
		if (!condiciones.isEmpty()) {
			sentenciaSql.append(" WHERE ").append(String.join(" AND ", condiciones));
		}
		return sentenciaSql.toString();
	}

	private List<BarberoEntidad> ejecutarConsulta(String sentenciaSql, List<Object> parametros) {
		var barberos = new ArrayList<BarberoEntidad>();
		try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
			for (var posicion = 0; posicion < parametros.size(); posicion++) {
				sentencia.setObject(posicion + 1, parametros.get(posicion));
			}
			try (var filas = sentencia.executeQuery()) {
				while (filas.next()) {
					barberos.add(convertirFilaAEntidad(filas));
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.BarberoPostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_BARBEROS;
			var mensajeTecnico = CatalogoMensajes.BarberoPostgreSqlDAO.TECNICO_ERROR_CONSULTANDO_BARBEROS
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
		return barberos;
	}

	private BarberoEntidad convertirFilaAEntidad(ResultSet fila) throws SQLException {
		var barbero = new BarberoEntidad();
		barbero.setId(fila.getObject("id", UUID.class));
		barbero.getTipoIdentificacion().setId(fila.getObject("tipo_identificacion_id", UUID.class));
		barbero.setNumeroIdentificacion(fila.getString("numero_identificacion"));
		barbero.setPrimerNombre(fila.getString("primer_nombre"));
		barbero.setSegundoNombre(fila.getString("segundo_nombre"));
		barbero.setPrimerApellido(fila.getString("primer_apellido"));
		barbero.setSegundoApellido(fila.getString("segundo_apellido"));
		barbero.getIndicativoPais().setId(fila.getObject("indicativo_pais_id", UUID.class));
		barbero.setNumeroTelefono(fila.getString("numero_telefono"));
		barbero.setCorreoElectronico(fila.getString("correo_electronico"));
		barbero.setNumeroVerificado(fila.getBoolean("numero_verificado"));
		barbero.setActivo(fila.getBoolean("activo"));
		return barbero;
	}
}