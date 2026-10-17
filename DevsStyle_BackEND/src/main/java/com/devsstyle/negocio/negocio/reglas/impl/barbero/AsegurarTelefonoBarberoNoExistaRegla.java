package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.entidad.BarberoEntidad;
import com.devsstyle.entidad.IndicativoPaisEntidad;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilTexto;

public final class AsegurarTelefonoBarberoNoExistaRegla implements Regla<Object> {

	private static final Regla<Object> instancia = new AsegurarTelefonoBarberoNoExistaRegla();

	private AsegurarTelefonoBarberoNoExistaRegla() {
	}

	public static final Regla<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idIndicativoPais = (UUID) datos[0];
		var numeroTelefono = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var filtro = new BarberoEntidad();
		filtro.setIndicativoPais(new IndicativoPaisEntidad(idIndicativoPais, UtilTexto.VACIO, UtilTexto.VACIO));
		filtro.setNumeroTelefono(numeroTelefono);

		var barberosEncontrados = daoFactory.obtenerBarberoDAO().consultarPorFiltro(filtro);

		if (!barberosEncontrados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_TELEFONO_YA_EXISTE;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
