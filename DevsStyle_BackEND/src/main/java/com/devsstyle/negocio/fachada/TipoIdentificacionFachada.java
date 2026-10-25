package com.devsstyle.negocio.fachada;

import java.util.List;

import com.devsstyle.dto.TipoIdentificacionDTO;

public interface TipoIdentificacionFachada {

	List<TipoIdentificacionDTO> consultarTiposIdentificacion(TipoIdentificacionDTO filtro);
}
