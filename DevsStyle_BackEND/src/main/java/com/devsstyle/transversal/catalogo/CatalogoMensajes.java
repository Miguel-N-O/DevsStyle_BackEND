package com.devsstyle.transversal.catalogo;

public final class CatalogoMensajes {



	private CatalogoMensajes() {
	}

	public static final class UtilSQL {

		private UtilSQL() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información no se encuentra abierta, ya sea porque está cerrada o porque está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible deshacer los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible finalizar de manera adecuada la operación deseada, debido a que la conexión contra la fuente de información que se intentó cerrar ya se encuentra cerrada o está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de iniciar la operación deseada contra la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de confirmar los cambios de la operación deseada contra la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de deshacer los cambios de la operación deseada contra la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
	}

	public static final class PostgreSqlDAOFactory {

		private PostgreSqlDAOFactory() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_SQL = "Se ha presentado un problema tratando de abrir la conexión contra la fuente de información en la cual se iba a llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
	}

	public static final class TipoIdentificacionPostgreSqlDAO {

		private TipoIdentificacionPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_CONSULTANDO_TIPOS_IDENTIFICACION = "Se ha presentado un problema tratando de consultar los tipos de identificación en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String TECNICO_ERROR_CONSULTANDO_TIPOS_IDENTIFICACION = "Se presentó una SQLException en TipoIdentificacionPostgreSqlDAO.consultarPorFiltro al consultar la tabla TipoIdentificacion: ";
	}
	
	public static final class IndicativoPaisPostgreSqlDAO {
		private IndicativoPaisPostgreSqlDAO() {
	}

		public static final String TECNICO_ERROR_CONSULTANDO_INDICATIVOS_PAIS = "Se presentó una SQLException en IndicativoPaisPostgreSqlDAO.consultarPorFiltro al consultar la tabla IndicativoPais: ";
		public static final String USUARIO_ERROR_CONSULTANDO_INDICATIVOS_PAIS = "Se ha presentado un problema tratando de consultar los indicativos de país en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";

		}
	
	
	public static final class BarberoPostgreSqlDAO {

		private BarberoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_CONSULTANDO_BARBEROS = "Se ha presentado un problema tratando de consultar los barberos en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String TECNICO_ERROR_CONSULTANDO_BARBEROS = "Se presentó una SQLException en BarberoPostgreSqlDAO.consultarPorFiltro al consultar la tabla Barbero: ";
		public static final String USUARIO_ERROR_CREANDO_BARBERO = "Se ha presentado un problema tratando de registrar el barbero en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String TECNICO_ERROR_CREANDO_BARBERO = "Se presentó una SQLException en BarberoPostgreSqlDAO.crear al insertar en la tabla Barbero: ";
	}

	public static final class BarberoNegocioImpl {

		private BarberoNegocioImpl() {
		}

		public static final String USUARIO_ERROR_NUMERO_IDENTIFICACION_OBLIGATORIO = "El número de identificación es obligatorio. Por favor ingréselo e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_IDENTIFICACION_FORMATO_NO_VALIDO = "El número de identificación solo puede tener letras y dígitos, sin espacios ni símbolos. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_IDENTIFICACION_LONGITUD_NO_VALIDA = "El número de identificación debe tener entre 5 y 20 caracteres. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_TIPO_IDENTIFICACION_OBLIGATORIO = "El tipo de identificación es obligatorio. Por favor seleccione uno de la lista e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_NOMBRE_OBLIGATORIO = "El primer nombre es obligatorio. Por favor ingréselo e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_NOMBRE_FORMATO_NO_VALIDO = "El primer nombre solo puede tener letras, sin espacios, números ni símbolos. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_NOMBRE_LONGITUD_NO_VALIDA = "El primer nombre debe tener entre 2 y 30 letras. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_SEGUNDO_NOMBRE_FORMATO_NO_VALIDO = "El segundo nombre solo puede tener letras, sin espacios, números ni símbolos. Si no tiene segundo nombre, deje el campo vacío. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_SEGUNDO_NOMBRE_LONGITUD_NO_VALIDA = "El segundo nombre debe tener entre 2 y 30 letras. Si no tiene segundo nombre, deje el campo vacío. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_APELLIDO_OBLIGATORIO = "El primer apellido es obligatorio. Por favor ingréselo e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_APELLIDO_FORMATO_NO_VALIDO = "El primer apellido solo puede tener letras, sin espacios, números ni símbolos. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_PRIMER_APELLIDO_LONGITUD_NO_VALIDA = "El primer apellido debe tener entre 2 y 30 letras. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_SEGUNDO_APELLIDO_FORMATO_NO_VALIDO = "El segundo apellido solo puede tener letras, sin espacios, números ni símbolos. Si no tiene segundo apellido, deje el campo vacío. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_SEGUNDO_APELLIDO_LONGITUD_NO_VALIDA = "El segundo apellido debe tener entre 2 y 30 letras. Si no tiene segundo apellido, deje el campo vacío. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_INDICATIVO_PAIS_OBLIGATORIO = "El indicativo de país es obligatorio. Por favor seleccione uno de la lista e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_TELEFONO_OBLIGATORIO = "El número de teléfono es obligatorio. Por favor ingréselo e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_TELEFONO_FORMATO_NO_VALIDO = "El número de teléfono solo puede tener dígitos, sin el indicativo, espacios ni símbolos. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_TELEFONO_LONGITUD_NO_VALIDA = "El número de teléfono debe tener entre 7 y 14 dígitos. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_CORREO_ELECTRONICO_OBLIGATORIO = "El correo electrónico es obligatorio. Por favor ingréselo e intente de nuevo.";
		public static final String USUARIO_ERROR_CORREO_ELECTRONICO_FORMATO_NO_VALIDO = "El correo electrónico no tiene un formato válido; debe ser como nombre@dominio.com. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_CORREO_ELECTRONICO_LONGITUD_NO_VALIDA = "El correo electrónico debe tener entre 6 y 100 caracteres. Por favor corríjalo e intente de nuevo.";
		public static final String USUARIO_ERROR_TIPO_IDENTIFICACION_NO_EXISTE = "No fue posible registrar el barbero porque el tipo de identificación seleccionado no existe. Por favor seleccione un tipo de identificación de la lista e intente de nuevo.";
		public static final String USUARIO_ERROR_NUMERO_IDENTIFICACION_NO_CORRESPONDE_AL_TIPO = "El número de identificación solo puede tener dígitos para el tipo de identificación escogido. Solo el pasaporte admite letras. Por favor corríjalo e intente de nuevo.";
	}

}
