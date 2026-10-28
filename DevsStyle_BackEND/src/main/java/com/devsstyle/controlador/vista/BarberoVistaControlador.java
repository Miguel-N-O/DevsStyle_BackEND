package com.devsstyle.controlador.vista;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarberoVistaControlador {

	@GetMapping("/")
	public String mostrarInicio() {
		return "redirect:/barberos/registrar";
	}

	@GetMapping("/barberos/registrar")
	public String mostrarRegistrarBarbero(@AuthenticationPrincipal OidcUser datosUsuario, Model modelo) {
		modelo.addAttribute("nombreUsuario", datosUsuario.getFullName());
		return "barbero/registrar";
	}
}