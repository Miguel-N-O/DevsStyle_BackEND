package com.devsstyle.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.devsstyle.controlador.respuesta.RespuestaError;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;
import com.devsstyle.transversal.excepciones.DevsStyleExcepcion;
import com.devsstyle.transversal.utilitarios.UtilUUID;

@RestControllerAdvice
public abstract class AbstractRestController {

	private static final Logger logger = LoggerFactory.getLogger(AbstractRestController.class);

	@ExceptionHandler(DevsStyleExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarDevsStyleExcepcion(DevsStyleExcepcion excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());

		logger.warn(CatalogoMensajes.AbstractRestController.TECNICO_ADVERTENCIA_EXCEPCION_CONTROLADA,
				excepcion.getCapa(), excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarExcepcion(Exception excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_PROBLEMA_INESPERADO
				.concat(correlationId);
		var respuesta = RespuestaError.crear(mensajeRespuesta);

		logger.error(CatalogoMensajes.AbstractRestController.TECNICO_ERROR_PROBLEMA_INESPERADO, correlationId, excepcion);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarRecursoNoEncontrado(NoResourceFoundException excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_RECURSO_NO_ENCONTRADO
				.concat(correlationId);
		var respuesta = RespuestaError.crear(mensajeRespuesta);

		logger.warn(CatalogoMensajes.AbstractRestController.TECNICO_ADVERTENCIA_RECURSO_NO_ENCONTRADO,
				excepcion.getHttpMethod(), excepcion.getResourcePath(), correlationId);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}
}
