package com.devsstyle.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsstyle.controlador.AbstractRestController;
import com.devsstyle.controlador.respuesta.RespuestaOk;
import com.devsstyle.dto.IndicativoPaisDTO;
import com.devsstyle.negocio.fachada.IndicativoPaisFachada;
import com.devsstyle.negocio.fachada.impl.IndicativoPaisFachadaImpl;

@RestController
@RequestMapping("/api/v1/indicativos-pais")
public class IndicativoPaisControlador extends AbstractRestController {

	private IndicativoPaisFachada fachada = new IndicativoPaisFachadaImpl();

	@GetMapping("/dummy")
	public IndicativoPaisDTO obtenerDummy() {
		return new IndicativoPaisDTO();
	}

	@GetMapping
	public ResponseEntity<RespuestaOk<IndicativoPaisDTO>> consultarIndicativosPais(IndicativoPaisDTO filtro) {
		var indicativosPais = fachada.consultarIndicativosPais(filtro);

		RespuestaOk<IndicativoPaisDTO> respuesta = RespuestaOk.crear(indicativosPais);

		return ResponseEntity.ok(respuesta);
	}
}
