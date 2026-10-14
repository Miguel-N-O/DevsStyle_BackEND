package com.devsstyle.negocio.negocio.reglas.impl.barbero;

import java.util.UUID;

import com.devsstyle.dominio.BarberoDominio;
import com.devsstyle.negocio.negocio.reglas.Regla;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleNegocioExcepcion;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ValidarDatosRegistrarBarberoRegla implements Regla<BarberoDominio> {

	private static final Regla<BarberoDominio> instancia = new ValidarDatosRegistrarBarberoRegla();

	private ValidarDatosRegistrarBarberoRegla() {
	}

	public static final Regla<BarberoDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(BarberoDominio... datos) {
		var barbero = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(datos[0], new BarberoDominio.Builder().build());

		validarTipoIdentificacion(barbero.getTipoIdentificacion().getId());
		validarNumeroIdentificacion(barbero.getNumeroIdentificacion());
		validarPrimerNombre(barbero.getPrimerNombre());
		validarSegundoNombre(barbero.getSegundoNombre());
		validarPrimerApellido(barbero.getPrimerApellido());
		validarSegundoApellido(barbero.getSegundoApellido());
		validarIndicativoPais(barbero.getIndicativoPais().getId());
		validarNumeroTelefono(barbero.getNumeroTelefono());
		validarCorreoElectronico(barbero.getCorreoElectronico());
	}

	private void validarTipoIdentificacion(UUID idTipoIdentificacion) {
		if (UtilUUID.obtenerUUIDDefecto().equals(idTipoIdentificacion)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_TIPO_IDENTIFICACION_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarNumeroIdentificacion(String numeroIdentificacion) {
		if (UtilTexto.getUtilTexto().esVacia(numeroIdentificacion)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_IDENTIFICACION_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(numeroIdentificacion, UtilTexto.LETRAS_DIGITOS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_IDENTIFICACION_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(numeroIdentificacion, 5, 20, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_IDENTIFICACION_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarPrimerNombre(String primerNombre) {
		if (UtilTexto.getUtilTexto().esVacia(primerNombre)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_NOMBRE_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(primerNombre, UtilTexto.SOLO_LETRAS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_NOMBRE_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(primerNombre, 2, 30, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_NOMBRE_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarSegundoNombre(String segundoNombre) {
		if (UtilTexto.getUtilTexto().esVacia(segundoNombre)) {
			return;
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(segundoNombre, UtilTexto.SOLO_LETRAS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_SEGUNDO_NOMBRE_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(segundoNombre, 2, 30, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_SEGUNDO_NOMBRE_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarPrimerApellido(String primerApellido) {
		if (UtilTexto.getUtilTexto().esVacia(primerApellido)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_APELLIDO_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(primerApellido, UtilTexto.SOLO_LETRAS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_APELLIDO_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(primerApellido, 2, 30, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_PRIMER_APELLIDO_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarSegundoApellido(String segundoApellido) {
		if (UtilTexto.getUtilTexto().esVacia(segundoApellido)) {
			return;
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(segundoApellido, UtilTexto.SOLO_LETRAS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_SEGUNDO_APELLIDO_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(segundoApellido, 2, 30, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_SEGUNDO_APELLIDO_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarIndicativoPais(UUID idIndicativoPais) {
		if (UtilUUID.obtenerUUIDDefecto().equals(idIndicativoPais)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_INDICATIVO_PAIS_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarNumeroTelefono(String numeroTelefono) {
		if (UtilTexto.getUtilTexto().esVacia(numeroTelefono)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_TELEFONO_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(numeroTelefono, UtilTexto.SOLO_DIGITOS)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_TELEFONO_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(numeroTelefono, 7, 14, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_NUMERO_TELEFONO_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarCorreoElectronico(String correoElectronico) {
		if (UtilTexto.getUtilTexto().esVacia(correoElectronico)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_CORREO_ELECTRONICO_OBLIGATORIO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().formatoEsValido(correoElectronico, UtilTexto.CORREO)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_CORREO_ELECTRONICO_FORMATO_NO_VALIDO;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(correoElectronico, 6, 100, true)) {
			var mensajeUsuario = CatalogoMensajes.BarberoNegocioImpl.USUARIO_ERROR_CORREO_ELECTRONICO_LONGITUD_NO_VALIDA;
			throw DevsStyleNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
