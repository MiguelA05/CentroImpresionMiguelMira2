package co.uniquindio.pg2.CentroImpresionMiguelMira.util;

import co.uniquindio.pg2.CentroImpresionMiguelMira.model.*;
/**
 * Metodos generales para el funcionamiento de la aplicacion
 * @author MIGUEL ANGEL
 *
 */
public class MetodosImpresora {
	
	
	
	
	
	/**
	 * Metodo que obtiene el estado de la impresora a partir de una cadena
	 * @param estado Estado en forma de cadena
	 * @return Estado en forma de la clase EStado
	 */
	public static Estado obtenerEstadoImpresora(String estado) {
		Estado estadoImpresora=null;
		switch(estado) {
			case "Activo": estadoImpresora=Estado.ACTIVA; break;
			case "Inactivo": estadoImpresora=Estado.INACTIVA; break;
		}
		return estadoImpresora;
	}
	
	/**
	 * Metodo que convierte el estado de la impresora a una cadena
	 * @param impresora Impresora de la cual se quiere obtener su estado
	 * @return Estado de la impresora en forma de cadena
	 */
	public static String obtenerEstadoImpresora(Estado estado) {
		String estadoImpresora="";
		if (estado==null) {
			return "";
		}
		switch(estado) {
			case ACTIVA: estadoImpresora="Activo"; break;
			case INACTIVA: estadoImpresora="Inactivo"; break;
		}
		return estadoImpresora;
	}
	
	/**
	 * Metodo que  obtiene el tipo de la impresora a partir de una cadena
	 * @param tipo Tipo de la impresora en forma de cadena
	 * @return Tipo de la impresora en forma de la clase TipoImpresora
	 */
	public static TipoImpresora obtenerEnumTipoImpresora(String tipo) {
		TipoImpresora tipoImpresora=null;
		switch(tipo) {
			case "Impacto": tipoImpresora=TipoImpresora.IMPRESIONIMPACTO; break;
			case "Inyeccion de tinta": tipoImpresora=TipoImpresora.INYECCION_TINTA; break;
			case "Laser": tipoImpresora=TipoImpresora.LASER; break;
		}
		return tipoImpresora;
	}
	
	
	/**
	 * Metodo que convierte el tipo de impresora en String
	 * @param impresora Impresora de la cual se quiere obtener su tipo
	 * @return Tipo de la impresora en String
	 */
	public static String obtenerTipoImpresora(Impresora impresora) {
		String tipoImpresoraCadena="";
		if (impresora.getTipoImpresora()==null) {
			return "";
		}
		switch(impresora.getTipoImpresora()) {
			case IMPRESIONIMPACTO: tipoImpresoraCadena="Impacto"; break;
			case LASER: tipoImpresoraCadena="Laser"; break;
			case INYECCION_TINTA: tipoImpresoraCadena="Inyeccion de tinta";
		}
		return tipoImpresoraCadena;
	}
	
	
	/**
	 * Metodo que convierte el tipo de impresora en String
	 * @param impresora Impresora de la cual se quiere obtener su tipo
	 * @return Tipo de la impresora en String
	 */
	public static String obtenerStringTipoImpresora(TipoImpresora tipoImpresora) {
		String tipoImpresoraCadena="";
		if (tipoImpresora==null) {
			return "";
		}
		switch(tipoImpresora) {
			case IMPRESIONIMPACTO: tipoImpresoraCadena="Impacto"; break;
			case LASER: tipoImpresoraCadena="Laser"; break;
			case INYECCION_TINTA: tipoImpresoraCadena="Inyeccion de tinta";
		}
		return tipoImpresoraCadena;
	}
	
	/**
	 * Metodo determina si una impresora esta activa
	 * @param impresora Impresora de la cual se quiere obtener su estado
	 * @return True si esta activa o false en caso contrario
	 */
	public static boolean isActiva(Impresora impresora) {
		boolean isActiva=false;
		if (impresora.getEstado().equals(Estado.ACTIVA)) {
			isActiva=true;
		}
		return isActiva;
	}
	
	/**
	 * Obtiene la enumeracion del tipo de papel a partir de una cadena
	 * @param tipo
	 * @return
	 */
	public static TipoPapel obtenerEnumTipoPapel(String tipo) {
		TipoPapel tipoPapel=null;
		switch(tipo) {
			case "Adhesivo": tipoPapel=TipoPapel.ADHESIVO; break;
			case "Brillante": tipoPapel=TipoPapel.BRILLANTE; break;
			case "Fotografico": tipoPapel=TipoPapel.FOTOGRAFICO; break;
			case "Transparente": tipoPapel= TipoPapel.TRANSPARENTE;
		}
		return tipoPapel;
	}
	
	/**
	 * Obtiene en string de una enumeracion de tipoPapel
	 * @param tipoPapel
	 * @return
	 */
	public static String obtenerStringTipoPapel(TipoPapel tipoPapel) {
		String tipoPapelCadena="";
		if (tipoPapel==null) {
			return "";
		}
		switch(tipoPapel) {
			case ADHESIVO: tipoPapelCadena="Adhesivo"; break;
			case BRILLANTE: tipoPapelCadena="Brillante"; break;
			case FOTOGRAFICO: tipoPapelCadena="Fotografico";break;
			case TRANSPARENTE: tipoPapelCadena="Transparente";
		}
		return tipoPapelCadena;
	}
	
	
	
	/**
	 * Verfica si un string es un numero
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
	        try {
	            // Intenta analizar el String como número y verifica si no lanza una excepción
	            Integer.parseInt(str); // O utiliza Double.parseDouble(str) para números decimales
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

}
