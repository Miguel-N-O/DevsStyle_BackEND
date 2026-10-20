package com.devsstyle.dao.factoria;

import java.sql.Connection;

import com.devsstyle.dao.datos.entidad.BarberoDAO;
import com.devsstyle.dao.datos.entidad.IndicativoPaisDAO;
import com.devsstyle.dao.datos.entidad.TipoIdentificacionDAO;
import com.devsstyle.dao.factoria.enums.FactoriaEnum;
import com.devsstyle.dao.factoria.impl.PostgreSqlDAOFactory;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleDatosExcepcion;
import com.devsstyle.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

	private Connection conexion;

	private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;

	public static DAOFactory obtenerFactoria() {
		switch (factoria) {
		case POSTGRESQL:
			return new PostgreSqlDAOFactory();

		default:
			var mensajeUsuario = CatalogoMensajes.DAOFactory.USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
			throw DevsStyleDatosExcepcion.crear(mensajeUsuario);
		}
	}

	protected DAOFactory() {
		abrirConexion();
	}

	public Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
	}

	protected abstract void abrirConexion();

	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	public abstract BarberoDAO obtenerBarberoDAO();

	public abstract IndicativoPaisDAO obtenerIndicativoPaisDAO();

	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
}
