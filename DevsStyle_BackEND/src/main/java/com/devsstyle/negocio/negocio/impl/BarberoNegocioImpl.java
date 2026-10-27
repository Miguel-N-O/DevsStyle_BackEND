	package com.devsstyle.negocio.negocio.impl;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.UUID;
	
	import com.devsstyle.dao.factoria.DAOFactory;
	import com.devsstyle.dominio.BarberoDominio;
	import com.devsstyle.negocio.negocio.BarberoNegocio;
	import com.devsstyle.negocio.negocio.ensamblador.impl.BarberoEnsambladorEntidad;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarCorreoBarberoNoExistaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarIdentificacionBarberoNoExistaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarIndicativoPaisExistaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarLongitudTelefonoConIndicativoValidaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarNumeroIdentificacionCorrespondaTipoRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarTelefonoBarberoNoExistaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.AsegurarTipoIdentificacionExistaRegla;
	import com.devsstyle.negocio.negocio.reglas.impl.barbero.ValidarDatosRegistrarBarberoRegla;
	import com.devsstyle.transversal.utilitarios.UtilTexto;
	import com.devsstyle.transversal.utilitarios.UtilUUID;
	
	public final class BarberoNegocioImpl implements BarberoNegocio {
	
		private DAOFactory daoFactory;
	
		public BarberoNegocioImpl(DAOFactory daoFactory) {
			this.daoFactory = daoFactory;
		}
	
		@Override
		public BarberoDominio registrarBarbero(BarberoDominio datos) {
			ValidarDatosRegistrarBarberoRegla.obtenerInstancia().ejecutar(datos);
	
			var idTipoIdentificacion = datos.getTipoIdentificacion().getId();
			var numeroIdentificacion = datos.getNumeroIdentificacion().toUpperCase();
			var idIndicativoPais = datos.getIndicativoPais().getId();
			var numeroTelefono = datos.getNumeroTelefono();
			var correoElectronico = datos.getCorreoElectronico().toLowerCase();
	
			AsegurarTipoIdentificacionExistaRegla.obtenerInstancia().ejecutar(idTipoIdentificacion, daoFactory);
			AsegurarNumeroIdentificacionCorrespondaTipoRegla.obtenerInstancia().ejecutar(idTipoIdentificacion, numeroIdentificacion, daoFactory);
			AsegurarIndicativoPaisExistaRegla.obtenerInstancia().ejecutar(idIndicativoPais, daoFactory);
			AsegurarLongitudTelefonoConIndicativoValidaRegla.obtenerInstancia().ejecutar(idIndicativoPais, numeroTelefono, daoFactory);
			AsegurarIdentificacionBarberoNoExistaRegla.obtenerInstancia().ejecutar(idTipoIdentificacion, numeroIdentificacion, daoFactory);
			AsegurarTelefonoBarberoNoExistaRegla.obtenerInstancia().ejecutar(idIndicativoPais, numeroTelefono, daoFactory);
			AsegurarCorreoBarberoNoExistaRegla.obtenerInstancia().ejecutar(correoElectronico, daoFactory);
	
			var barberoEntidad = BarberoEnsambladorEntidad.getInstancia().convertirAEntidad(datos);
			barberoEntidad.setId(generarIdDeBarberoUnico());
			barberoEntidad.setNumeroIdentificacion(numeroIdentificacion);
			barberoEntidad.setCorreoElectronico(correoElectronico);
			barberoEntidad.setPrimerNombre(UtilTexto.getUtilTexto().aplicarMayusculaInicial(datos.getPrimerNombre()));
			barberoEntidad.setSegundoNombre(UtilTexto.getUtilTexto().aplicarMayusculaInicial(datos.getSegundoNombre()));
			barberoEntidad.setPrimerApellido(UtilTexto.getUtilTexto().aplicarMayusculaInicial(datos.getPrimerApellido()));
			barberoEntidad.setSegundoApellido(UtilTexto.getUtilTexto().aplicarMayusculaInicial(datos.getSegundoApellido()));
			barberoEntidad.setNumeroVerificado(false);
			barberoEntidad.setActivo(true);
	
			daoFactory.obtenerBarberoDAO().crear(barberoEntidad);
	
			return BarberoEnsambladorEntidad.getInstancia().convertirADominio(barberoEntidad);
		}
	
		private UUID generarIdDeBarberoUnico() {
			var id = UtilUUID.generar();
			var barberoExistente = daoFactory.obtenerBarberoDAO().consultarPorId(id);
	
			while (!UtilUUID.obtenerUUIDDefecto().equals(barberoExistente.getId())) {
				id = UtilUUID.generar();
				barberoExistente = daoFactory.obtenerBarberoDAO().consultarPorId(id);
			}
	
			return id;
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
