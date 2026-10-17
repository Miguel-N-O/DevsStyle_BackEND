package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.entidad.BarberoEntidad;
import com.devsstyle.entidad.TipoIdentificacionEntidad;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class AsegurarIdentificacionBarberoNoExistaRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarIdentificacionBarberoNoExistaRegla();

	private AsegurarIdentificacionBarberoNoExistaRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idTipoIdentificacion = (UUID) datos[0];
		var numeroIdentificacion = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var filtro = new BarberoEntidad();
		filtro.setTipoIdentificacion(new TipoIdentificacionEntidad(idTipoIdentificacion, UtilTexto.VACIO, UtilTexto.VACIO));
		filtro.setNumeroIdentificacion(numeroIdentificacion);

		var barberosEncontrados = daoFactory.obtenerBarberoDAO().consultarPorFiltro(filtro);

		if (!barberosEncontrados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_IDENTIFICACION_YA_EXISTE;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
