package com.devsstyle.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.devsstyle.dominio.IndicativoPaisDominio;

public interface IndicativoPaisNegocio {

	IndicativoPaisDominio registrarIndicativoPais(IndicativoPaisDominio datos);

	IndicativoPaisDominio actualizarIndicativoPais(UUID id, IndicativoPaisDominio datos);

	void eliminarIndicativoPais(UUID id);

	IndicativoPaisDominio consultarIndicativoPaisPorId(UUID id);

	List<IndicativoPaisDominio> consultarIndicativosPais(IndicativoPaisDominio filtro);
}
