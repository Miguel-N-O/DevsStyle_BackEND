package com.devsstyle.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devsstyle.dao.factoria.DAOFactory;
import com.devsstyle.dominio.BarberoDominio;
import com.devsstyle.negocio.negocio.BarberoNegocio;
import com.devsstyle.negocio.negocio.ensamblador.impl.BarberoEnsambladorEntidad;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BarberoNegocioImpl implements BarberoNegocio {

	private DAOFactory daoFactory;

	protected BarberoNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public BarberoDominio registrarBarbero(BarberoDominio datos) {
		var barberoEntidad = BarberoEnsambladorEntidad.getInstancia().convertirAEntidad(datos);
		barberoEntidad.setId(generarIdDeBarberoUnico());

		daoFactory.obtenerBarberoDAO().crear(barberoEntidad);

		return BarberoEnsambladorEntidad.getInstancia().convertirADominio(barberoEntidad);
	}

	private UUID generarIdDeBarberoUnico() {
		return UtilUUID.generar();
	}

	@Override
	public BarberoDominio actualizarBarbero(UUID id, BarberoDominio datos) {
		return new BarberoDominio.Builder().build();
	}

	@Override
	public BarberoDominio verificarNumeroTelefonoBarbero(UUID id, String codigo) {
		return new BarberoDominio.Builder().build();
	}

	@Override
	public BarberoDominio reenviarCodigoVerificacionBarbero(UUID id) {
		return new BarberoDominio.Builder().build();
	}

	@Override
	public BarberoDominio consultarBarberoPorId(UUID id) {
		return new BarberoDominio.Builder().build();
	}

	@Override
	public List<BarberoDominio> consultarBarberos(BarberoDominio filtro) {
		return new ArrayList<>();
	}

	@Override
	public List<BarberoDominio> consultarBarberosDisponibles(BarberoDominio filtro) {
		return new ArrayList<>();
	}

	@Override
	public BarberoDominio desactivarBarbero(UUID id) {
		return new BarberoDominio.Builder().build();
	}

	@Override
	public BarberoDominio reactivarBarbero(UUID id) {
		return new BarberoDominio.Builder().build();
	}
}
