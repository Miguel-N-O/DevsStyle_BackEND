package com.devsstyle.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.devsstyle.dominio.BarberoDominio;

public interface BarberoNegocio {

	BarberoDominio registrarBarbero(BarberoDominio datos);

	BarberoDominio actualizarBarbero(UUID id, BarberoDominio datos);

	BarberoDominio verificarNumeroTelefonoBarbero(UUID id, String codigo);

	BarberoDominio reenviarCodigoVerificacionBarbero(UUID id);

	BarberoDominio consultarBarberoPorId(UUID id);

	List<BarberoDominio> consultarBarberos(BarberoDominio filtro);

	List<BarberoDominio> consultarBarberosDisponibles(BarberoDominio filtro);

	BarberoDominio desactivarBarbero(UUID id);

	BarberoDominio reactivarBarbero(UUID id);
}
