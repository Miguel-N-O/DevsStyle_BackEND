package com.devsstyle.negocio.fachada;

import java.util.List;

import com.devsstyle.dto.IndicativoPaisDTO;

public interface IndicativoPaisFachada {

	List<IndicativoPaisDTO> consultarIndicativosPais(IndicativoPaisDTO filtro);
}
