package com.devsstyle.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.devsstyle.dominio.TipoIdentificacionDominio;

public interface TipoIdentificacionNegocio {

	TipoIdentificacionDominio registrarTipoIdentificacion(TipoIdentificacionDominio datos);

	TipoIdentificacionDominio actualizarTipoIdentificacion(UUID id, TipoIdentificacionDominio datos);

	void eliminarTipoIdentificacion(UUID id);

	TipoIdentificacionDominio consultarTipoIdentificacionPorId(UUID id);

	List<TipoIdentificacionDominio> consultarTiposIdentificacion(TipoIdentificacionDominio filtro);
}
