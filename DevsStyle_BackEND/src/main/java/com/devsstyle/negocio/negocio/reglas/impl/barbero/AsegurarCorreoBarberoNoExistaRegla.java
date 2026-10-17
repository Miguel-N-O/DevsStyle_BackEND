package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.entidad.BarberoEntidad;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;

public final class AsegurarCorreoBarberoNoExistaRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarCorreoBarberoNoExistaRegla();

	private AsegurarCorreoBarberoNoExistaRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var correoElectronico = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var filtro = new BarberoEntidad();
		filtro.setCorreoElectronico(correoElectronico);

		var barberosEncontrados = daoFactory.obtenerBarberoDAO().consultarPorFiltro(filtro);

		if (!barberosEncontrados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_CORREO_ELECTRONICO_YA_EXISTE;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
