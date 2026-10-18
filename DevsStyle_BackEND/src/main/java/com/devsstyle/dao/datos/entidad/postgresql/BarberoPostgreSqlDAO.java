package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
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

	public BarberoPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(BarberoEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("INSERT INTO Barbero (id, tipo_identificacion_id, numero_identificacion, primer_nombre, ");
		sentenciaSql.append("segundo_nombre, primer_apellido, segundo_apellido, indicativo_pais_id, ");
		sentenciaSql.append("numero_telefono, correo_electronico, numero_verificado, activo) ");
		sentenciaSql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
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

		if (barberos.isEmpty()) {
			return new BarberoEntidad();
		}

		return barberos.get(0);
	}

	@Override
	public List<BarberoEntidad> consultarPorFiltro(BarberoEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BarberoEntidad());
		var parametros = new ArrayList<Object>();

		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT id, tipo_identificacion_id, numero_identificacion, primer_nombre, ");
		sentenciaSql.append("segundo_nombre, primer_apellido, segundo_apellido, indicativo_pais_id, ");
		sentenciaSql.append("numero_telefono, correo_electronico, numero_verificado, activo ");
		sentenciaSql.append("FROM Barbero ");
		sentenciaSql.append("WHERE 1 = 1 ");

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			sentenciaSql.append("AND id = ? ");
			parametros.add(filtroTmp.getId());
		}

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getTipoIdentificacion().getId())) {
			sentenciaSql.append("AND tipo_identificacion_id = ? ");
			parametros.add(filtroTmp.getTipoIdentificacion().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNumeroIdentificacion())) {
			sentenciaSql.append("AND numero_identificacion = ? ");
			parametros.add(filtroTmp.getNumeroIdentificacion());
		}

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getIndicativoPais().getId())) {
			sentenciaSql.append("AND indicativo_pais_id = ? ");
			parametros.add(filtroTmp.getIndicativoPais().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNumeroTelefono())) {
			sentenciaSql.append("AND numero_telefono = ? ");
			parametros.add(filtroTmp.getNumeroTelefono());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getCorreoElectronico())) {
			sentenciaSql.append("AND correo_electronico = ? ");
			parametros.add(filtroTmp.getCorreoElectronico());
		}

		return consultar(sentenciaSql.toString(), parametros);
	}

	@Override
	public List<BarberoEntidad> consultarTodos() {
		return consultarPorFiltro(new BarberoEntidad());
	}

	@Override
	public void actualizar(UUID id, BarberoEntidad entidad) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("UPDATE Barbero ");
		sentenciaSql.append("SET tipo_identificacion_id = ?, numero_identificacion = ?, ");
		sentenciaSql.append("primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, ");
		sentenciaSql.append("indicativo_pais_id = ?, numero_telefono = ?, correo_electronico = ?, ");
		sentenciaSql.append("numero_verificado = ?, activo = ? ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, entidad.getTipoIdentificacion().getId());
			sentencia.setString(2, entidad.getNumeroIdentificacion());
			sentencia.setString(3, entidad.getPrimerNombre());
			sentencia.setString(4, entidad.getSegundoNombre());
			sentencia.setString(5, entidad.getPrimerApellido());
			sentencia.setString(6, entidad.getSegundoApellido());
			sentencia.setObject(7, entidad.getIndicativoPais().getId());
			sentencia.setString(8, entidad.getNumeroTelefono());
			sentencia.setString(9, entidad.getCorreoElectronico());
			sentencia.setBoolean(10, entidad.isNumeroVerificado());
			sentencia.setBoolean(11, entidad.isActivo());
			sentencia.setObject(12, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.BarberoPostgreSqlDAO.USUARIO_ERROR_ACTUALIZANDO_BARBERO;
			var mensajeTecnico = CatalogoMensajes.BarberoPostgreSqlDAO.TECNICO_ERROR_ACTUALIZANDO_BARBERO
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public void eliminar(UUID id) {
		var sentenciaSql = new StringBuilder();
		sentenciaSql.append("DELETE FROM Barbero ");
		sentenciaSql.append("WHERE id = ?");

		try (var sentencia = getConexion().prepareStatement(sentenciaSql.toString())) {
			sentencia.setObject(1, id);
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.BarberoPostgreSqlDAO.USUARIO_ERROR_ELIMINANDO_BARBERO;
			var mensajeTecnico = CatalogoMensajes.BarberoPostgreSqlDAO.TECNICO_ERROR_ELIMINANDO_BARBERO
					+ excepcion.getMessage();
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	private List<BarberoEntidad> consultar(String sentenciaSql, List<Object> parametros) {
		var barberos = new ArrayList<BarberoEntidad>();

		try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
			for (int posicion = 0; posicion < parametros.size(); posicion++) {
				sentencia.setObject(posicion + 1, parametros.get(posicion));
			}

			try (var filas = sentencia.executeQuery()) {
				while (filas.next()) {
					var barbero = new BarberoEntidad();
					barbero.setId(filas.getObject("id", UUID.class));
					barbero.getTipoIdentificacion().setId(filas.getObject("tipo_identificacion_id", UUID.class));
					barbero.setNumeroIdentificacion(filas.getString("numero_identificacion"));
					barbero.setPrimerNombre(filas.getString("primer_nombre"));
					barbero.setSegundoNombre(filas.getString("segundo_nombre"));
					barbero.setPrimerApellido(filas.getString("primer_apellido"));
					barbero.setSegundoApellido(filas.getString("segundo_apellido"));
					barbero.getIndicativoPais().setId(filas.getObject("indicativo_pais_id", UUID.class));
					barbero.setNumeroTelefono(filas.getString("numero_telefono"));
					barbero.setCorreoElectronico(filas.getString("correo_electronico"));
					barbero.setNumeroVerificado(filas.getBoolean("numero_verificado"));
					barbero.setActivo(filas.getBoolean("activo"));
					barberos.add(barbero);
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
}
