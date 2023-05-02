package co.uniquindio.pg2.CentroImpresionMiguelMira.exceptions;
/**
 * Excepcion utilizada en casos como el ingreso de datos invalidos o la nula seleccion de una impresora
 * @author MIGUEL ANGEL
 *
 */
public class ImpresoraException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImpresoraException(String message) {
		super(message);
		
	}
	
}
