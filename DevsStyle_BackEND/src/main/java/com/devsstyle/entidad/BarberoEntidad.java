package com.devsstyle.entidad;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class BarberoEntidad {

	private UUID id;
	private TipoIdentificacionEntidad tipoIdentificacion;
	private String numeroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private IndicativoPaisEntidad indicativoPais;
	private String numeroTelefono;
	private String correoElectronico;
	private boolean numeroVerificado;
	private boolean activo;

	public BarberoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoIdentificacion(new TipoIdentificacionEntidad());
		setNumeroIdentificacion(UtilTexto.VACIO);
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
		setIndicativoPais(new IndicativoPaisEntidad());
		setNumeroTelefono(UtilTexto.VACIO);
		setCorreoElectronico(UtilTexto.VACIO);
		setNumeroVerificado(false);
		setActivo(true);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoIdentificacionEntidad getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionEntidad tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoIdentificacion,
				new TipoIdentificacionEntidad());
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroIdentificacion);
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(segundoNombre);
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(primerApellido);
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(segundoApellido);
	}

	public IndicativoPaisEntidad getIndicativoPais() {
		return indicativoPais;
	}

	public void setIndicativoPais(IndicativoPaisEntidad indicativoPais) {
		this.indicativoPais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(indicativoPais,
				new IndicativoPaisEntidad());
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroTelefono);
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(correoElectronico);
	}

	public boolean isNumeroVerificado() {
		return numeroVerificado;
	}

	public void setNumeroVerificado(boolean numeroVerificado) {
		this.numeroVerificado = numeroVerificado;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}