const SOLO_LETRAS = /^[a-zA-ZñÑáÁéÉíÍóÓúÚüÜ]+$/;
const SOLO_DIGITOS = /^[0-9]+$/;
const LETRAS_DIGITOS = /^[a-zA-Z0-9]+$/;
const CORREO = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const CARACTERES_NO_LETRAS = /[^a-zA-ZñÑáÁéÉíÍóÓúÚüÜ]/g;
const CARACTERES_NO_DIGITOS = /[^0-9]/g;
const CARACTERES_NO_LETRAS_DIGITOS = /[^a-zA-Z0-9]/g;
const NOMBRE_TIPO_PASAPORTE = "PA";
const INDICATIVO_POR_DEFECTO = "+57";
const LONGITUD_MAXIMA_TELEFONO_CON_INDICATIVO = 15;
const MENSAJE_REGISTRO_EXITOSO = "El barbero se registró de forma exitosa.";
const MENSAJE_PROBLEMA_INESPERADO = "Se ha presentado un problema inesperado tratando de registrar el barbero. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación.";
const MENSAJE_PROBLEMA_CARGANDO_LISTAS = "No fue posible cargar los tipos de identificación y los indicativos de país. Por favor recargue la página y si el problema persiste contacte al administrador de la aplicación.";

const formulario = document.getElementById("formularioBarbero");
const mensaje = document.getElementById("mensaje");
const botonRegistrar = document.getElementById("botonRegistrar");

let tiposIdentificacion = [];
let indicativosPais = [];

function mostrarMensaje(tipo, texto) {
	mensaje.className = "alert alert-" + tipo;
	mensaje.textContent = texto;
	mensaje.scrollIntoView({ behavior: "smooth", block: "center" });
}

function ocultarMensaje() {
	mensaje.className = "alert d-none";
	mensaje.textContent = "";
}

function obtenerValor(id) {
	return document.getElementById(id).value.trim();
}

function marcarCampo(id, error) {
	const campo = document.getElementById(id);
	const textoError = document.getElementById(id + "Error");

	textoError.textContent = error;

	if (error === "") {
		campo.classList.remove("is-invalid");
		return true;
	}

	campo.classList.add("is-invalid");
	return false;
}

function limpiarMarcas() {
	for (const campo of formulario.querySelectorAll(".is-invalid")) {
		campo.classList.remove("is-invalid");
	}
	for (const textoError of formulario.querySelectorAll(".invalid-feedback")) {
		textoError.textContent = "";
	}
}

function longitudEsValida(valor, minimo, maximo) {
	return valor.length >= minimo && valor.length <= maximo;
}

function buscarTipoIdentificacion(id) {
	for (const tipoIdentificacion of tiposIdentificacion) {
		if (tipoIdentificacion.id === id) {
			return tipoIdentificacion;
		}
	}
	return null;
}

function buscarIndicativoPais(id) {
	for (const indicativoPais of indicativosPais) {
		if (indicativoPais.id === id) {
			return indicativoPais;
		}
	}
	return null;
}

function validarTipoIdentificacion() {
	if (buscarTipoIdentificacion(obtenerValor("tipoIdentificacion")) === null) {
		return marcarCampo("tipoIdentificacion", "El tipo de identificación es obligatorio. Por favor seleccione uno de la lista.");
	}
	return marcarCampo("tipoIdentificacion", "");
}

function validarNumeroIdentificacion() {
	const numeroIdentificacion = obtenerValor("numeroIdentificacion");
	const tipoIdentificacion = buscarTipoIdentificacion(obtenerValor("tipoIdentificacion"));

	if (numeroIdentificacion === "") {
		return marcarCampo("numeroIdentificacion", "El número de identificación es obligatorio.");
	}
	if (!LETRAS_DIGITOS.test(numeroIdentificacion)) {
		return marcarCampo("numeroIdentificacion", "El número de identificación solo puede tener letras y dígitos, sin espacios ni símbolos.");
	}
	if (!longitudEsValida(numeroIdentificacion, 5, 20)) {
		return marcarCampo("numeroIdentificacion", "El número de identificación debe tener entre 5 y 20 caracteres.");
	}
	if (tipoIdentificacion !== null && tipoIdentificacion.nombre !== NOMBRE_TIPO_PASAPORTE && !SOLO_DIGITOS.test(numeroIdentificacion)) {
		return marcarCampo("numeroIdentificacion", "Para el tipo de identificación escogido el número solo puede tener dígitos. Solo el pasaporte admite letras.");
	}
	return marcarCampo("numeroIdentificacion", "");
}

function validarNombreOApellido(id, nombreCampo, obligatorio) {
	const valor = obtenerValor(id);

	if (valor === "") {
		if (obligatorio) {
			return marcarCampo(id, "El " + nombreCampo + " es obligatorio.");
		}
		return marcarCampo(id, "");
	}
	if (!SOLO_LETRAS.test(valor)) {
		return marcarCampo(id, "El " + nombreCampo + " solo puede tener letras, sin espacios, números ni símbolos.");
	}
	if (!longitudEsValida(valor, 2, 30)) {
		return marcarCampo(id, "El " + nombreCampo + " debe tener entre 2 y 30 letras.");
	}
	return marcarCampo(id, "");
}

function validarIndicativoPais() {
	if (buscarIndicativoPais(obtenerValor("indicativoPais")) === null) {
		return marcarCampo("indicativoPais", "El indicativo de país es obligatorio. Por favor seleccione uno de la lista.");
	}
	return marcarCampo("indicativoPais", "");
}

function validarNumeroTelefono() {
	const numeroTelefono = obtenerValor("numeroTelefono");
	const indicativoPais = buscarIndicativoPais(obtenerValor("indicativoPais"));

	if (numeroTelefono === "") {
		return marcarCampo("numeroTelefono", "El número de teléfono es obligatorio.");
	}
	if (!SOLO_DIGITOS.test(numeroTelefono)) {
		return marcarCampo("numeroTelefono", "El número de teléfono solo puede tener dígitos, sin el indicativo, espacios ni símbolos.");
	}
	if (!longitudEsValida(numeroTelefono, 7, 14)) {
		return marcarCampo("numeroTelefono", "El número de teléfono debe tener entre 7 y 14 dígitos.");
	}
	if (indicativoPais !== null) {
		const digitosIndicativo = indicativoPais.indicativo.replace("+", "");
		if (digitosIndicativo.length + numeroTelefono.length > LONGITUD_MAXIMA_TELEFONO_CON_INDICATIVO) {
			return marcarCampo("numeroTelefono", "El número de teléfono es demasiado largo para el indicativo escogido: entre los dos no pueden pasar de 15 dígitos.");
		}
	}
	return marcarCampo("numeroTelefono", "");
}

function validarCorreoElectronico() {
	const correoElectronico = obtenerValor("correoElectronico");

	if (correoElectronico === "") {
		return marcarCampo("correoElectronico", "El correo electrónico es obligatorio.");
	}
	if (!CORREO.test(correoElectronico)) {
		return marcarCampo("correoElectronico", "El correo electrónico no tiene un formato válido; debe ser como nombre@dominio.com.");
	}
	if (!longitudEsValida(correoElectronico, 6, 100)) {
		return marcarCampo("correoElectronico", "El correo electrónico debe tener entre 6 y 100 caracteres.");
	}
	return marcarCampo("correoElectronico", "");
}

function validarFormulario() {
	const resultados = [
		validarTipoIdentificacion(),
		validarNumeroIdentificacion(),
		validarNombreOApellido("primerNombre", "primer nombre", true),
		validarNombreOApellido("segundoNombre", "segundo nombre", false),
		validarNombreOApellido("primerApellido", "primer apellido", true),
		validarNombreOApellido("segundoApellido", "segundo apellido", false),
		validarIndicativoPais(),
		validarNumeroTelefono(),
		validarCorreoElectronico()
	];

	for (const resultado of resultados) {
		if (!resultado) {
			formulario.querySelector(".is-invalid").focus();
			return false;
		}
	}
	return true;
}

function construirBarbero() {
	return {
		tipoIdentificacion: { id: obtenerValor("tipoIdentificacion") },
		numeroIdentificacion: obtenerValor("numeroIdentificacion"),
		primerNombre: obtenerValor("primerNombre"),
		segundoNombre: obtenerValor("segundoNombre"),
		primerApellido: obtenerValor("primerApellido"),
		segundoApellido: obtenerValor("segundoApellido"),
		indicativoPais: { id: obtenerValor("indicativoPais") },
		numeroTelefono: obtenerValor("numeroTelefono"),
		correoElectronico: obtenerValor("correoElectronico")
	};
}

async function leerCuerpo(respuesta) {
	try {
		return await respuesta.json();
	} catch (error) {
		return null;
	}
}

function obtenerPrimerMensaje(cuerpo, mensajePorDefecto) {
	if (cuerpo !== null && Array.isArray(cuerpo.mensajes) && cuerpo.mensajes.length > 0) {
		return String(cuerpo.mensajes[0]);
	}
	return mensajePorDefecto;
}

async function registrarBarbero(evento) {
	evento.preventDefault();
	ocultarMensaje();

	if (botonRegistrar.disabled || !validarFormulario()) {
		return;
	}

	botonRegistrar.disabled = true;

	try {
		const respuesta = await fetch("/api/v1/barberos", {
			method: "POST",
			headers: obtenerEncabezadosEnvio(),
			body: JSON.stringify(construirBarbero())
		});
		const cuerpo = await leerCuerpo(respuesta);

		if (respuesta.ok) {
			formulario.reset();
			mostrarMensaje("success", obtenerPrimerMensaje(cuerpo, MENSAJE_REGISTRO_EXITOSO));
		} else {
			mostrarMensaje("danger", obtenerPrimerMensaje(cuerpo, MENSAJE_PROBLEMA_INESPERADO));
		}
	} catch (error) {
		mostrarMensaje("danger", MENSAJE_PROBLEMA_INESPERADO);
	} finally {
		botonRegistrar.disabled = false;
	}
}

function quitarCaracteresNoPermitidos(id, caracteresNoPermitidos) {
	const campo = document.getElementById(id);
	const valorLimpio = campo.value.replace(caracteresNoPermitidos, "");

	if (valorLimpio === campo.value) {
		return;
	}

	const posicion = Math.max(0, campo.selectionStart - (campo.value.length - valorLimpio.length));
	campo.value = valorLimpio;
	campo.setSelectionRange(posicion, posicion);
}

function obtenerEncabezadosEnvio() {
	const encabezados = { "Content-Type": "application/json" };
	const token = document.querySelector('meta[name="_csrf"]');
	const nombreEncabezado = document.querySelector('meta[name="_csrf_header"]');

	if (token && nombreEncabezado) {
		encabezados[nombreEncabezado.content] = token.content;
	}

	return encabezados;
}

async function consultarLista(url) {
	const respuesta = await fetch(url);

	if (!respuesta.ok) {
		throw new Error(MENSAJE_PROBLEMA_CARGANDO_LISTAS);
	}

	const cuerpo = await respuesta.json();

	if (!Array.isArray(cuerpo.datos)) {
		throw new Error(MENSAJE_PROBLEMA_CARGANDO_LISTAS);
	}
	return cuerpo.datos;
}

function llenarLista(id, elementos, obtenerTexto) {
	const lista = document.getElementById(id);

	for (const elemento of elementos) {
		const opcion = document.createElement("option");
		opcion.value = elemento.id;
		opcion.textContent = obtenerTexto(elemento);
		lista.appendChild(opcion);
	}
}

function seleccionarIndicativoPorDefecto() {
	for (const indicativoPais of indicativosPais) {
		if (indicativoPais.indicativo === INDICATIVO_POR_DEFECTO) {
			document.getElementById("indicativoPais").value = indicativoPais.id;
			return;
		}
	}
}

async function cargarListas() {
	botonRegistrar.disabled = true;

	try {
		tiposIdentificacion = await consultarLista("/api/v1/tipos-identificacion");
		indicativosPais = await consultarLista("/api/v1/indicativos-pais");

		tiposIdentificacion.sort((a, b) => a.nombre.localeCompare(b.nombre));
		indicativosPais.sort((a, b) => a.pais.localeCompare(b.pais));

		llenarLista("tipoIdentificacion", tiposIdentificacion, (tipo) => tipo.nombre + " · " + tipo.descripcion);
		llenarLista("indicativoPais", indicativosPais, (indicativo) => indicativo.indicativo + " " + indicativo.pais);
		seleccionarIndicativoPorDefecto();

		botonRegistrar.disabled = false;
	} catch (error) {
		mostrarMensaje("danger", MENSAJE_PROBLEMA_CARGANDO_LISTAS);
	}
}

formulario.addEventListener("submit", registrarBarbero);

formulario.addEventListener("reset", () => {
	ocultarMensaje();
	limpiarMarcas();
	setTimeout(seleccionarIndicativoPorDefecto, 0);
});

document.getElementById("tipoIdentificacion").addEventListener("change", () => {
	validarTipoIdentificacion();
	if (obtenerValor("numeroIdentificacion") !== "") {
		validarNumeroIdentificacion();
	}
});

document.getElementById("indicativoPais").addEventListener("change", () => {
	validarIndicativoPais();
	if (obtenerValor("numeroTelefono") !== "") {
		validarNumeroTelefono();
	}
});

document.getElementById("numeroIdentificacion").addEventListener("blur", validarNumeroIdentificacion);
document.getElementById("primerNombre").addEventListener("blur", () => validarNombreOApellido("primerNombre", "primer nombre", true));
document.getElementById("segundoNombre").addEventListener("blur", () => validarNombreOApellido("segundoNombre", "segundo nombre", false));
document.getElementById("primerApellido").addEventListener("blur", () => validarNombreOApellido("primerApellido", "primer apellido", true));
document.getElementById("segundoApellido").addEventListener("blur", () => validarNombreOApellido("segundoApellido", "segundo apellido", false));
document.getElementById("numeroTelefono").addEventListener("blur", validarNumeroTelefono);
document.getElementById("correoElectronico").addEventListener("blur", validarCorreoElectronico);

document.getElementById("numeroIdentificacion").addEventListener("input", () => quitarCaracteresNoPermitidos("numeroIdentificacion", CARACTERES_NO_LETRAS_DIGITOS));
document.getElementById("primerNombre").addEventListener("input", () => quitarCaracteresNoPermitidos("primerNombre", CARACTERES_NO_LETRAS));
document.getElementById("segundoNombre").addEventListener("input", () => quitarCaracteresNoPermitidos("segundoNombre", CARACTERES_NO_LETRAS));
document.getElementById("primerApellido").addEventListener("input", () => quitarCaracteresNoPermitidos("primerApellido", CARACTERES_NO_LETRAS));
document.getElementById("segundoApellido").addEventListener("input", () => quitarCaracteresNoPermitidos("segundoApellido", CARACTERES_NO_LETRAS));
document.getElementById("numeroTelefono").addEventListener("input", () => quitarCaracteresNoPermitidos("numeroTelefono", CARACTERES_NO_DIGITOS));

cargarListas();
