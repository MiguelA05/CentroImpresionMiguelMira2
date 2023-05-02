package co.uniquindio.pg2.CentroImpresionMiguelMira.controllers;

import javafx.collections.FXCollections;




import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import co.uniquindio.pg2.CentroImpresionMiguelMira.Aplicacion;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.CentroImpresion;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.Impresora;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.util.*;
/**
 * Controlador de la ventana en que se muestran los detalles individuales de cada impresora
 * @author MIGUEL ANGEL
 *
 */
public class DetallesImpresoraController {
	
	@FXML
	private ComboBox<String> estado;
	@FXML
	private TextField nombre;
	@FXML
	private TextField marca;
	@FXML
	private ComboBox<String> tipoImpresora;
	@FXML
	private ComboBox<String> tipoPapel;
	@FXML
	private TextField atributoExtra;
	@FXML
	private Label atributo;
	private Stage ventana;
	private Impresora newImpresora;
	private CentroImpresion miCentro;
	private Aplicacion mainApp;
	private ImpresorasController impresorasController;
	private int caso;
	
	/**
	 * Metodo constructor
	 */
	public DetallesImpresoraController() {
		
	}
	
	public void setImpresorasController(ImpresorasController impresorasController) {
	    this.impresorasController = impresorasController;
	}
	public Aplicacion getMainApp() {
		return mainApp;
	}
	public void setMainApp(Aplicacion mainApp) {
		this.mainApp = mainApp;
	}
	public CentroImpresion getMiCentro() {
		return miCentro;
	}
	public void setMiCentro(CentroImpresion miCentro) {
		this.miCentro = miCentro;
	}
	public int getCaso() {
		return caso;
	}
	public void setCaso(int caso) {
		this.caso = caso;
	}

	/**
	 * incializador de la clase
	 */
	@FXML
	private void initialize() {
		ObservableList<String> estados=FXCollections.observableArrayList();
		estados.add("Activo");
		estados.add("Inactivo");
		ObservableList<String> tipoImpresoras=FXCollections.observableArrayList();
		tipoImpresoras.add("Impacto");
		tipoImpresoras.add("Inyeccion de tinta");
		tipoImpresoras.add("Laser");
		ObservableList<String> tipoPapelList=FXCollections.observableArrayList();
		tipoPapelList.add("Adhesivo");
		tipoPapelList.add("Brillante");
		tipoPapelList.add("Fotografico");
		tipoPapelList.add("Tranparente");
		atributo.setVisible(false);
		tipoPapel.setVisible(false);
		atributoExtra.setVisible(false);
		estado.setItems(estados);
		tipoImpresora.setItems(tipoImpresoras);
		tipoPapel.setItems(tipoPapelList);
		
		
		
		tipoImpresora.valueProperty().addListener((observable, oldValue, newValue) -> {
		        if (newValue.equals("Impacto")) {
		            atributo.setVisible(true);
		            atributo.setText("Cantidad Max. Impresiones Simultáneas");
		            atributoExtra.setVisible(true);
		            tipoPapel.setVisible(false);
		        } else if (newValue.equals("Inyeccion de tinta")) {
		            atributo.setVisible(true);
		            atributo.setText("Velocidad de impresión");
		            atributoExtra.setVisible(true);
		            tipoPapel.setVisible(false);
		        } else if (newValue.equals("Laser")) {
		            atributo.setVisible(true);
		            atributo.setText("Tipo de papel");
		            atributoExtra.setVisible(false);
		            tipoPapel.setVisible(true);
		        }
		    });
	}
	
	/**
	 * Metodo que verifica si los datos ingresados son validos
	 * @return true si los datos ingresados son validos, false en caso contrario
	 */
	public boolean sonEntradasValidas() {
		boolean sonValidas=false;
		String msj="";
		if (estado.getValue()==null || ((String) estado.getValue()).trim().equals("")) {
			msj+="Seleccione un estado";
		}
		if (nombre.getText()==null || ((String) nombre.getText()).trim().equals("")) {
			msj+="\n\nIngrese un nombre";
		}
		if (marca.getText()== null || ((String) marca.getText()).trim().equals("")) {
			msj+="\n\nIngrese una marca";
		}
		if (tipoImpresora.getValue()==null || ((String) tipoImpresora.getValue()).trim().equals("")) {
			msj+="\n\nSeleccione un tipo de impresora";
		}
		if(!MetodosImpresora.isNumeric(atributoExtra.getText()) || ((String) atributoExtra.getText()).trim().equals("") ) {
			if(tipoImpresora.getSelectionModel().getSelectedItem()=="Laser"){
				if( tipoPapel.getValue()==null || tipoImpresora.getValue().trim().equals(""))
				{
					msj+="\n\nSeleccione un tipo de papel";
				}
			}else {
				msj+="\n\nIngrese el atributo extra correspondiente al tipo de impresora seleccionado";
			}
			
		}
		if (msj.equals("")) {
			sonValidas=true;
		} else {
			JOptionPane.showMessageDialog(null, msj,"Datos no validos",JOptionPane.INFORMATION_MESSAGE);
		}
		return sonValidas;
	}
	
	/**
	 * Metodo que valida y guarda los datos ingresados de la impresora
	 */
	@FXML
	private void guardarDatos() {
	    if (sonEntradasValidas()) {
	        if (caso == 0) { // Caso de agregar una nueva impresora
	        	switch (tipoImpresora.getSelectionModel().getSelectedItem()) {
				case "Inyeccion de tinta":
					 miCentro.crearImpresora(MetodosImpresora.obtenerEstadoImpresora("" + estado.getValue()),
			                    nombre.getText(), marca.getText(), MetodosImpresora.obtenerEnumTipoImpresora("" + tipoImpresora.getValue()),0,null,Integer.parseInt(atributoExtra.getText()));
					break;
				case "Laser":
					miCentro.crearImpresora(MetodosImpresora.obtenerEstadoImpresora("" + estado.getValue()),
		                    nombre.getText(), marca.getText(), MetodosImpresora.obtenerEnumTipoImpresora("" + tipoImpresora.getValue()),0,MetodosImpresora.obtenerEnumTipoPapel(tipoPapel.getSelectionModel().getSelectedItem()),0);
					break;
				case "Impacto":
					miCentro.crearImpresora(MetodosImpresora.obtenerEstadoImpresora("" + estado.getValue()),
		                    nombre.getText(), marca.getText(), MetodosImpresora.obtenerEnumTipoImpresora("" + tipoImpresora.getValue()),Integer.parseInt(atributoExtra.getText()),null,0);
				}
	            
	        } else if (caso == 1) { // Caso de editar una impresora existente
	            newImpresora.setEstado(MetodosImpresora.obtenerEstadoImpresora("" + estado.getValue()));
	            newImpresora.setNombre(nombre.getText());
	            newImpresora.setMarca(marca.getText());
	            newImpresora.setTipoImpresora(MetodosImpresora.obtenerEnumTipoImpresora("" + tipoImpresora.getValue()));
	            miCentro.reemplazarImpresora(newImpresora);
	        }
	        
	        impresorasController.actualizarTabla();
	        ventana.close();
	    }
		
	}
	
	/**
	 * Metodo que cierra la ventana de edicion
	 */
	@FXML
	private void volver() {
		ventana.close();
	}

	/**
	 * Metodo que abre la ventana de edicion
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.ventana = dialogStage;
	}

	/**
	 * Metodo que pone los detalles de la impresora que se desea editar sus detalles en los campos
	 * @param impresora Impresora que se desea cambiar sus detalles
	 */
	public void setImpresoraGuardar(Impresora impresora) {
		this.newImpresora = impresora;
		estado.setValue(MetodosImpresora.obtenerEstadoImpresora(impresora.getEstado()));
		nombre.setText(impresora.getNombre());
		marca.setText(impresora.getMarca());
		tipoImpresora.setValue(MetodosImpresora.obtenerTipoImpresora(impresora));
		if(MetodosImpresora.obtenerTipoImpresora(impresora)=="Impacto") {
			ImpresoraImpacto impresoraImp=(ImpresoraImpacto) impresora;
			atributoExtra.setText(""+impresoraImp.getMaxCopiasSimultaneas());
		}else if(MetodosImpresora.obtenerTipoImpresora(impresora)=="Inyeccion de tinta") {
			ImpresoraTinta impresoraTin=(ImpresoraTinta) impresora;
			atributoExtra.setText(""+impresoraTin.getVelocidadImpresion());
		}else if(MetodosImpresora.obtenerTipoImpresora(impresora)=="Laser") {
			ImpresoraLaser impresoraLa=(ImpresoraLaser) impresora;
			atributoExtra.setText(""+MetodosImpresora.obtenerStringTipoPapel(impresoraLa.getTipoPapel()));
		}
		
	}
	
	

	

}
