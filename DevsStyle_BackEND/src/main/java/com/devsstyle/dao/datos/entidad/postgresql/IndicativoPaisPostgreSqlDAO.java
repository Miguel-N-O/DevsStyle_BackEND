package com.devsstyle.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
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

	private static final String SELECT = """
			SELECT id,  pais, indicativo
			FROM IndicativoPais
			""";

	public IndicativoPaisPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}


	@Override
	public List<IndicativoPaisEntidad> consultarTodos() {
		return consultarPorFiltro(new IndicativoPaisEntidad());
	}

	@Override
	public IndicativoPaisEntidad consultarPorId(UUID id) {
		var filtro = new IndicativoPaisEntidad();
		filtro.setId(id);
		var indicativosPais = consultarPorFiltro(filtro);
		return indicativosPais.isEmpty() ? new IndicativoPaisEntidad() : indicativosPais.get(0);
	}

	@Override
	public List<IndicativoPaisEntidad> consultarPorFiltro(IndicativoPaisEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new IndicativoPaisEntidad());
		var condiciones = new ArrayList<String>();
		var parametros = new ArrayList<Object>();
		agregarCondicionesDelFiltro(filtroTmp, condiciones, parametros);
		var sentenciaSql = armarSentenciaSql(condiciones);

		return ejecutarConsulta(sentenciaSql, parametros);

	}

	private String armarSentenciaSql(List<String> condiciones) {
		var sentenciaSql = new StringBuilder (SELECT);
		if (!condiciones.isEmpty()) {
			sentenciaSql.append(" WHERE ").append(String.join(" AND ", condiciones));
		}
		return sentenciaSql.toString();
	}

	private void agregarCondicionesDelFiltro (IndicativoPaisEntidad filtroTmp, List<String> condiciones, List<Object> parametros ) {

		if(!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())){
			condiciones.add("id = ?");
			parametros.add(filtroTmp.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getPais())) {
			condiciones.add("pais = ?");
			parametros.add(filtroTmp.getPais());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getIndicativo())) {
			condiciones.add("indicativo = ?");
			parametros.add(filtroTmp.getIndicativo());
		}

	}
private List <IndicativoPaisEntidad> ejecutarConsulta(String sentenciaSql, List<Object> parametros){
	var indicativosPais = new ArrayList<IndicativoPaisEntidad>();
	try (var sentencia = getConexion().prepareStatement(sentenciaSql)) {
		for (var posicion = 0; posicion < parametros.size(); posicion++) {
			sentencia.setObject(posicion + 1, parametros.get(posicion));
		}
		try (var filas = sentencia.executeQuery()) {
			while (filas.next()) {
				indicativosPais.add(convertirFilaAEntidad(filas));
			}
		}

}catch (SQLException excepcion) {
	var mensajeUsuario = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_INDICATIVOS_PAIS;
	var mensajeTecnico = CatalogoMensajes.IndicativoPaisPostgreSqlDAO.TECNICO_ERROR_CONSULTANDO_INDICATIVOS_PAIS
			+ excepcion.getMessage();
	throw DevsStyleDatosExcepcion.crear(mensajeUsuario, mensajeTecnico, excepcion);
}
return indicativosPais;
}



private IndicativoPaisEntidad convertirFilaAEntidad(ResultSet fila) throws SQLException {
	var indicativoPais = new IndicativoPaisEntidad();
	indicativoPais.setId(fila.getObject("id", UUID.class));
	indicativoPais.setPais(fila.getString("pais"));
	indicativoPais.setIndicativo(fila.getString("indicativo"));
	return indicativoPais;

}


}
