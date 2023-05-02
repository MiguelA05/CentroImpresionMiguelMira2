package co.uniquindio.pg2.CentroImpresionMiguelMira.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import co.uniquindio.pg2.CentroImpresionMiguelMira.Aplicacion;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.util.*;
/**
 * Controlador de la ventana en que se selecciona el documento TXT a imprimir
 * @author MIGUEL ANGEL
 *
 */
public class ImpresionController {
	
	@FXML
	private Label nombre;
	@FXML
	private Label marca;
	@FXML
	private Label tipoImpresora;
	@FXML
	private TextArea contenidoImpresion; //Contenido del archivo txt que se quiere imprimir
	private Stage ventana;
	private Impresora impresoraImprimir; //Impresora con la que se quiere imprimir el documento
	private Aplicacion mainApp;
	private CentroImpresion miCentro;
	
	
	
	public CentroImpresion getMiCentro() {
		return miCentro;
	}
	public void setMiCentro(CentroImpresion miCentro) {
		this.miCentro = miCentro;
	}
	public Aplicacion getMainApp() {
		return mainApp;
	}
	public void setMainApp(Aplicacion mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Metodo constructor
	 */
	public ImpresionController() {
		
	}
	
	/**
	 * Inicializador de la clase
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Metodo que permite imprimir el documento si este el válido
	 */
	@FXML
	private void imprimir() {
		if (contenidoImpresion.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Seleccione un documento","Contenido vacío",JOptionPane.INFORMATION_MESSAGE);
		} else {
			String tipImpresora=tipoImpresora.getText();
			miCentro.definirFormaImprimir(tipImpresora, contenidoImpresion.getText());
			ventana.close();
		}
	}
	
	/**
	 * Metodo que cierra la ventana de impresion
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Metodo que selecciona el archivo y muestra su informacion
	 */
	@FXML
	private void seleccionarArchivo() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));
        File archivo = fileChooser.showOpenDialog(ventana);
        if (archivo != null) {
        	leerArchivo(archivo,contenidoImpresion);
        }

	}
	
	/**
	 * Metodo que lee el archivo y muestra su contenido
	 * @param archivo Archivo seleccionado
	 * @param contenido Espacio donde se va a mostrar el contenido a imprimir
	 */
	private void leerArchivo(File archivo, TextArea contenido) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(archivo));
	        String linea;
	        contenido.clear();
	        while ((linea = br.readLine()) != null) {
	        	contenido.appendText(linea + "\n");
	        }
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	/**
	 * Metodo que mustra los detalles de la impresora seleccionada para imprimir
	 * @param impresora Impresora seleccionada
	 */
	public void setImpresoraImprimir(Impresora impresora) {
		impresoraImprimir=impresora;
		nombre.setText(impresoraImprimir.getNombre());
		marca.setText(impresoraImprimir.getMarca());
		tipoImpresora.setText(MetodosImpresora.obtenerTipoImpresora(impresoraImprimir));

	}

	/**
	 * Metodo que obtiene la direccion de la ventana de impresion
	 * @param dialogStage Direccion de la ventana de impresion
	 */
	public void setDialogStage(Stage dialogStage) {
		this.ventana=dialogStage;
		
	}



}
