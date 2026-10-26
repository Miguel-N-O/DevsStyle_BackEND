package com.devsstyle.controlador.vista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarberoVistaControlador {

	@GetMapping("/barberos/registrar")
	public String mostrarRegistrarBarbero() {
		return "barbero/registrar";
	}
}