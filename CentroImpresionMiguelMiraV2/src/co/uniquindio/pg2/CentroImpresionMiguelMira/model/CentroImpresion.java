package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.uniquindio.pg2.CentroImpresionMiguelMira.util.MetodosImpresora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CentroImpresion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;//Codigo identificador del centro de impresion
	private List<Impresora> listaImpresoras;// Lista de impresoras disponibles 
	private List<Documento> listaDocumentos;// Lista de documentos 
	
	
	
	/**
	 * Constructor
	 * @param codigo 
	 */
	public CentroImpresion(String codigo ){
		super();
		this.codigo = codigo;
		this.listaImpresoras = new ArrayList<Impresora>();
		this.listaDocumentos = new ArrayList<Documento>();
	}
	
	

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Impresora> getListaImpresoras() {
		return listaImpresoras;
	}
	public void setListaImpresoras(List<Impresora> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}
	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	public void setListaDocumentos(List<Documento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}
	public ObservableList<Impresora> getObservableListaImpresoras() {
	    return FXCollections.observableList(listaImpresoras);
	}


	/**
	 * Establece que tipo de impresion realizara la impresora seleccionada dependiendo de su tipo
	 * @param tipoImpresora
	 * @param Documento
	 */
	public void definirFormaImprimir(String tipoImpresora, String Documento) {
		Impresora tempPerson=new Impresora(null, null, null, null);
		switch (tipoImpresora) {
		case "Impacto":
			tempPerson.imprimirImpresoraImpacto(Documento);
			break;
		case "Inyeccion de tinta":
			tempPerson.imprimirImpresoraTinta(Documento);
			break;
		case "Laser":
			tempPerson.imprimirImpresoraLaser(Documento);
		}
	}
	
	
	/**
	 * Crea una nueva impresora
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipoImpresora
	 */
	public void crearImpresora(Estado estado, String nombre, String marca,
			TipoImpresora tipoImpresora, int maxCopiasSimultaneas, TipoPapel tipoPapel, int velocidadImpresion) {
		switch (MetodosImpresora.obtenerStringTipoImpresora(tipoImpresora)) {
		case "Inyeccion de tinta":
			Impresora impresoraTinta= new ImpresoraTinta(estado, nombre, marca, tipoImpresora, velocidadImpresion);
			listaImpresoras.add(impresoraTinta);
			break;
		case "Impacto":
			Impresora impresoraImpacto= new ImpresoraImpacto(estado, nombre, marca, tipoImpresora, maxCopiasSimultaneas);
			listaImpresoras.add(impresoraImpacto);
			break;
		case "Laser":
			Impresora impresoraLaser= new ImpresoraLaser(estado, nombre, marca, tipoImpresora, tipoPapel);
			listaImpresoras.add(impresoraLaser);
		}
	
		
	}
	
	/**
	 * Remueve una impresora de la lista de impresoras
	 * @param imp
	 */
	public void removerImpresora(Impresora imp) {
		for(int i=0; i<listaImpresoras.size(); i++) {
			if(listaImpresoras.get(i).equals(imp)) {
				listaImpresoras.remove(i);
				break;
			}
		}
		
	}
	
	/**
	 * Reemplaza una impresora por una copia de la misma con su atributos modificados
	 * @param newImpresora
	 */
	public void reemplazarImpresora(Impresora newImpresora) {
		for(int i=0; i<listaImpresoras.size(); i++) {
			if(listaImpresoras.get(i).equals(newImpresora)) {
				listaImpresoras.set(i, newImpresora);;
				break;
			}
		}
		
		
	}





}
