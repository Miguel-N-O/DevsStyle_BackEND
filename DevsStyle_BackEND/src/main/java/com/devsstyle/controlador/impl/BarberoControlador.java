package com.devsstyle.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsstyle.controlador.AbstractRestController;
import com.devsstyle.controlador.respuesta.RespuestaOk;
import com.devsstyle.dto.BarberoDTO;
import com.devsstyle.negocio.fachada.BarberoFachada;
import com.devsstyle.negocio.fachada.impl.BarberoFachadaImpl;
import com.devsstyle.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/barberos")
public class BarberoControlador extends AbstractRestController {

	private BarberoFachada fachada = new BarberoFachadaImpl();

	@GetMapping("/dummy")
	public BarberoDTO obtenerDummy() {
		return new BarberoDTO();
	}

	@GetMapping("/login")
	public ResponseEntity<RespuestaOk<String>> hacerLogin(@AuthenticationPrincipal OidcUser datosUsuario) {
		var mensaje = CatalogoMensajes.BarberoControlador.SESION_INICIADA.formatted(datosUsuario.getFullName(),
				datosUsuario.getEmail());

		RespuestaOk<String> respuesta = RespuestaOk.crear(mensaje);

		return ResponseEntity.ok(respuesta);
	}

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarBarbero(@RequestBody BarberoDTO barbero) {
		fachada.registrarBarbero(barbero);

		RespuestaOk<String> respuesta = RespuestaOk
				.crear(CatalogoMensajes.BarberoControlador.BARBERO_REGISTRADO_EXITOSAMENTE);

		return ResponseEntity.ok(respuesta);
	}
}
