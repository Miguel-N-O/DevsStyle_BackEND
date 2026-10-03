package com.devsstyle.dominio;

import java.util.UUID;

import com.devsstyle.transversal.utilitarios.UtilNumero;
import com.devsstyle.transversal.utilitarios.UtilObjeto;
import com.devsstyle.transversal.utilitarios.UtilTexto;
import com.devsstyle.transversal.utilitarios.UtilUUID;

public final class ClienteDominio {

	private final UUID id;
	private final TipoIdentificacionDominio tipoIdentificacion;
	private final String numeroIdentificacion;
	private final String primerNombre;
	private final String segundoNombre;
	private final String primerApellido;
	private final String segundoApellido;
	private final IndicativoPaisDominio indicativoPais;
	private final String numeroTelefono;
	private final String correoElectronico;
	private final boolean numeroVerificado;
	private final int saldoAFavor;
	private final boolean activo;

	private ClienteDominio(Builder builder) {
		this.id = builder.id;
		this.tipoIdentificacion = builder.tipoIdentificacion;
		this.numeroIdentificacion = builder.numeroIdentificacion;
		this.primerNombre = builder.primerNombre;
		this.segundoNombre = builder.segundoNombre;
		this.primerApellido = builder.primerApellido;
		this.segundoApellido = builder.segundoApellido;
		this.indicativoPais = builder.indicativoPais;
		this.numeroTelefono = builder.numeroTelefono;
		this.correoElectronico = builder.correoElectronico;
		this.numeroVerificado = builder.numeroVerificado;
		this.saldoAFavor = builder.saldoAFavor;
		this.activo = builder.activo;
	}

	public UUID getId() {
		return id;
	}

	public TipoIdentificacionDominio getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public IndicativoPaisDominio getIndicativoPais() {
		return indicativoPais;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public boolean isNumeroVerificado() {
		return numeroVerificado;
	}

	public int getSaldoAFavor() {
		return saldoAFavor;
	}

	public boolean isActivo() {
		return activo;
	}

	public static class Builder {

		private UUID id;
		private TipoIdentificacionDominio tipoIdentificacion;
		private String numeroIdentificacion;
		private String primerNombre;
		private String segundoNombre;
		private String primerApellido;
		private String segundoApellido;
		private IndicativoPaisDominio indicativoPais;
		private String numeroTelefono;
		private String correoElectronico;
		private boolean numeroVerificado;
		private int saldoAFavor;
		private boolean activo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			tipoIdentificacion = new TipoIdentificacionDominio.Builder().build();
			numeroIdentificacion = UtilTexto.VACIO;
			primerNombre = UtilTexto.VACIO;
			segundoNombre = UtilTexto.VACIO;
			primerApellido = UtilTexto.VACIO;
			segundoApellido = UtilTexto.VACIO;
			indicativoPais = new IndicativoPaisDominio.Builder().build();
			numeroTelefono = UtilTexto.VACIO;
			correoElectronico = UtilTexto.VACIO;
			numeroVerificado = false;
			saldoAFavor = UtilNumero.CERO;
			activo = true;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder tipoIdentificacion(TipoIdentificacionDominio tipoIdentificacion) {
			this.tipoIdentificacion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoIdentificacion,
					new TipoIdentificacionDominio.Builder().build());
			return this;
		}

		public Builder numeroIdentificacion(String numeroIdentificacion) {
			this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroIdentificacion);
			return this;
		}

		public Builder primerNombre(String primerNombre) {
			this.primerNombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(primerNombre);
			return this;
		}

		public Builder segundoNombre(String segundoNombre) {
			this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(segundoNombre);
			return this;
		}

		public Builder primerApellido(String primerApellido) {
			this.primerApellido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(primerApellido);
			return this;
		}

		public Builder segundoApellido(String segundoApellido) {
			this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(segundoApellido);
			return this;
		}

		public Builder indicativoPais(IndicativoPaisDominio indicativoPais) {
			this.indicativoPais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(indicativoPais,
					new IndicativoPaisDominio.Builder().build());
			return this;
		}

		public Builder numeroTelefono(String numeroTelefono) {
			this.numeroTelefono = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroTelefono);
			return this;
		}

		public Builder correoElectronico(String correoElectronico) {
			this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(correoElectronico);
			return this;
		}

		public Builder numeroVerificado(boolean numeroVerificado) {
			this.numeroVerificado = numeroVerificado;
			return this;
		}

		public Builder saldoAFavor(int saldoAFavor) {
			this.saldoAFavor = saldoAFavor;
			return this;
		}

		public Builder activo(boolean activo) {
			this.activo = activo;
			return this;
		}

		public ClienteDominio build() {
			return new ClienteDominio(this);
		}
	}
}