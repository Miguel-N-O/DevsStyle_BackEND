package com.devsstyle.dao.factoria.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.devsstyle.dao.datos.entidad.BarberoDAO;
import com.devsstyle.dao.datos.entidad.IndicativoPaisDAO;
import com.devsstyle.dao.datos.entidad.TipoIdentificacionDAO;
import com.devsstyle.dao.datos.entidad.postgresql.BarberoPostgreSqlDAO;
import com.devsstyle.dao.datos.entidad.postgresql.IndicativoPaisPostgreSqlDAO;
import com.devsstyle.dao.datos.entidad.postgresql.TipoIdentificacionPostgreSqlDAO;
import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleDatosExcepcion;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class PostgreSqlDAOFactory extends DAOFactory {

	@Override
	protected void abrirConexion() {
		var url = UtilTexto.getUtilTexto().obtenerValorDefecto(System.getenv("DEVSSTYLE_DB_URL"));
		var usuario = UtilTexto.getUtilTexto().obtenerValorDefecto(System.getenv("DEVSSTYLE_DB_USUARIO"));
		var clave = UtilTexto.getUtilTexto().obtenerValorDefecto(System.getenv("DEVSSTYLE_DB_CLAVE"));
		try {
			setConexion(DriverManager.getConnection(url, usuario, clave));
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDAOFactory.USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_SQL;
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public BarberoDAO obtenerBarberoDAO() {
		return new BarberoPostgreSqlDAO(getConexion());
	}

	@Override
	public IndicativoPaisDAO obtenerIndicativoPaisDAO() {
		return new IndicativoPaisPostgreSqlDAO(getConexion());
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgreSqlDAO(getConexion());
	}
}
