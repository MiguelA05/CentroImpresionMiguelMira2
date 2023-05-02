package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

/**
 * Clase que representa una impresora y sus características mas esenciales
 * @author MIGUEL ANGEL
 *
 */
public class Impresora {
	
	private Estado estado; //Estado funcional en que se puede encontrar la impresora
	private String nombre; //nombre o modelo de la impresora
	private String marca; //marca de la impresora
	private TipoImpresora tipoImpresora; //Tipo al cual pertenerce la impresora


	

	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre o modelo de la impresora
	 * @param marca Marca de la impresora
	 * @param tipoImpresora Tipo de impresora
	 * @param resolucionHorizontal Resolucion horizontal en puntos por pulgada
	 * @param resolucionVertical Resolucion vertical en puntos por pulgada
	 */
	public Impresora(Estado estado, String nombre, String marca, TipoImpresora tipoImpresora) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.marca = marca;
		this.tipoImpresora = tipoImpresora;
		
	}

	/**
	 * Metodo que obtiene el estado de la impresora
	 * @return Estado de la impresora
	 */
	public Estado getEstado() {
		return estado;
	}
	

	/**
	 * Metodo que reemplaza el estado de la impresora
	 * @param estado Nuevo estado de la impresora
	 */
	public void setEstado(Estado estado) {
		this.estado=estado;
	}

	/**
	 * Metodo que obtiene el nombre de la impresora
	 * @return Nombre de la impresora
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * Metodo que reemplaza el nombre de la impresora
	 * @param nombre Nuevo nombre de la impresora
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	/**
	 * Metodo que obtiene la marca de la impresora
	 * @return Marca de la impresora
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Metodo que reemplaza la marca de la impresora
	 * @param marca Nueva marca de la impresora
	 */
	public void setMarca(String marca) {
		this.marca=marca;
	}

	/**
	 * Metodo que obtiene el tipo de la impresora
	 * @return Tipo de la impresora
	 */
	public TipoImpresora getTipoImpresora() {
		return tipoImpresora;
	}

	/**
	 * Metodo que reemplaza el tipo de la impresora
	 * @param tipoImpresora Nuevo tipo de la impresora
	 */
	public void setTipoImpresora(TipoImpresora tipoImpresora) {
		this.tipoImpresora=tipoImpresora;
	}

	@Override
	public String toString() {
		return "Impresora [nombre=" + nombre + ", marca=" + marca + "]";
	}
	/**
	 * Metodo para imprimir con una impresora de impacto
	 * @param Documento
	 */
	public void imprimirImpresoraImpacto(String Documento) {
		Imprimir impresoraImpacto = new ImpresoraImpacto(null, null, null, null, 0);
        impresoraImpacto.imprimirDocumento(Documento);
	}
	
	/**
	 * Metodo para imprimir con una impersora laser
	 * @param Documento
	 */
	public void imprimirImpresoraLaser(String Documento) {
		Imprimir impresoraLaser = new ImpresoraLaser(null, null, null, null, null);
        impresoraLaser.imprimirDocumento(Documento);
	}
	
	/**
	 * Metodo para imprimir con una impresora de tinta
	 * @param Documento
	 */
	public void imprimirImpresoraTinta(String Documento) {
		Imprimir impresoraTinta = new ImpresoraTinta(null, null, null, null, 0);
        impresoraTinta.imprimirDocumento(Documento);
	}
	
	
	
	


}
