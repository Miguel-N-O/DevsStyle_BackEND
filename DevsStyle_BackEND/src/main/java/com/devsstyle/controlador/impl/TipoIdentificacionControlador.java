package com.devsstyle.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsstyle.controlador.AbstractRestController;
import com.devsstyle.controlador.respuesta.RespuestaOk;
import com.devsstyle.dto.TipoIdentificacionDTO;
import com.devsstyle.negocio.fachada.TipoIdentificacionFachada;
import com.devsstyle.negocio.fachada.impl.TipoIdentificacionFachadaImpl;

@RestController
@RequestMapping("/api/v1/tipos-identificacion")
public class TipoIdentificacionControlador extends AbstractRestController {

	private TipoIdentificacionFachada fachada = new TipoIdentificacionFachadaImpl();

	@GetMapping("/dummy")
	public TipoIdentificacionDTO obtenerDummy() {
		return new TipoIdentificacionDTO();
	}

	@GetMapping
	public ResponseEntity<RespuestaOk<TipoIdentificacionDTO>> consultarTiposIdentificacion(TipoIdentificacionDTO filtro) {
		var tiposIdentificacion = fachada.consultarTiposIdentificacion(filtro);

		RespuestaOk<TipoIdentificacionDTO> respuesta = RespuestaOk.crear(tiposIdentificacion);

		return ResponseEntity.ok(respuesta);
	}
}
