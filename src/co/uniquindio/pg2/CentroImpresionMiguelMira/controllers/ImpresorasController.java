package co.uniquindio.pg2.CentroImpresionMiguelMira.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

import co.uniquindio.pg2.CentroImpresionMiguelMira.Aplicacion;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.util.MetodosImpresora;
/**
 * Controlador de la ventana en que se muestran todas las impresoras disponibles, sus caracteristicas, y las
 * opciones principales del centro de impresion
 * @author MIGUEL ANGEL
 *
 */
public class ImpresorasController {
	
	@FXML
	private TableView<Impresora> tablaImpresora;
	@FXML
	private TableColumn<Impresora,String> ColumnaNombre;
	@FXML
	private TableColumn<Impresora,Estado> ColumnaActividad;
	@FXML
	private Label actividad;
	@FXML
	private Label nombre;
	@FXML
	private Label marca;
	@FXML
	private Label tipoImpresora;
	@FXML
	private Label atributo;
	@FXML
	private Label atributoExtra;
	private Aplicacion mainApp;
	
	private CentroImpresion miCentro;
	
	/**
	 * Metodo constructor
	 */
	public ImpresorasController() {
		
	}
	
	
	
	public CentroImpresion getMiCentro() {
		return miCentro;
	}
	public void setMiCentro(CentroImpresion miCentro) {
		this.miCentro = miCentro;
	}



	/**
	 * inicializador de la clase
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
			ColumnaNombre.setCellValueFactory(
						cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
			ColumnaActividad.setCellValueFactory(
						cellData -> new ReadOnlyObjectWrapper<Estado>(cellData.getValue().getEstado()));
				// Clear person details.
				mostrarDetallesImpresora(null);
				// Listen for selection changes and show the person details when changed.
				tablaImpresora.getSelectionModel().selectedItemProperty().addListener(
						(observable, valorViejo, nuevoValor) -> mostrarDetallesImpresora(nuevoValor));
	}
	
	/**
	 * Metodo que abre la ventana de impresion si se selecciona una impresora activa
	 */
	@FXML
	private void imprimirDocumento() {
		int selectedIndex = tablaImpresora.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Impresora impresoraSeleccionada=tablaImpresora.getSelectionModel().getSelectedItem();
			if (MetodosImpresora.isActiva(impresoraSeleccionada)) {
				mainApp.mostrarImpresion(impresoraSeleccionada);
			} else {
				JOptionPane.showMessageDialog(null,"Seleccione una impresora activa","Impresora inactiva",JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,"Seleccione una impresora","Impresora no seleccionada",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Metodo que abre la ventana de edicion de las caracteristicas de la impresora para agregar una nueva impresora
	 */
	@FXML
	private void agregar() {
		Impresora tempPerson = new Impresora(null, null, null, null);
		mainApp.mostrarEditorCaracteristicasImpresora(tempPerson, 0);
	}
	
	/**
	 * Metodo que abre la ventana de edicion para editar las caracteristicas de la impresora seleccionada
	 */
	@FXML
	private void editar() {
		Impresora impresoraSeleccionada = tablaImpresora.getSelectionModel().getSelectedItem();
		if (impresoraSeleccionada != null) {
			mainApp.mostrarEditorCaracteristicasImpresora(impresoraSeleccionada, 1);
			
		} else {
			JOptionPane.showMessageDialog(null,"Seleccione una impresora","Impresora no seleccionada",JOptionPane.INFORMATION_MESSAGE);
		} 
	}
	
	/**
	 * Metodo que elimina la impresora seleccionada
	 */
	@FXML
	private void eliminar() {
		int selectedIndex = tablaImpresora.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Impresora imp=tablaImpresora.getItems().get(selectedIndex);
			miCentro.removerImpresora(imp);
			actualizarTabla();
		} else {
			JOptionPane.showMessageDialog(null,"Seleccione una impresora","Impresora no seleccionda",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Metodo que obtiene la aplicacion principal
	 * @param mainApp Aplicacion principal
	 */
	public void setMainApp(Aplicacion mainApp) {
	    this.mainApp = mainApp;
	    tablaImpresora.setItems(mainApp.getlistaImpresoras());
	}
	
	/**
	 * Metodo que muestra las caracteristicas de la impresora seleccionada
	 * @param impresora Impresora que se desea obtener sus metodos
	 */
	private void mostrarDetallesImpresora(Impresora impresora) {
		    if (impresora != null) {
		        actividad.setText(MetodosImpresora.obtenerEstadoImpresora(impresora.getEstado()));
		        nombre.setText(impresora.getNombre());
		        marca.setText(impresora.getMarca());
		        tipoImpresora.setText(MetodosImpresora.obtenerTipoImpresora(impresora));

		        if (impresora instanceof ImpresoraImpacto) {
		            ImpresoraImpacto impresoraImpacto = (ImpresoraImpacto) impresora;
		            atributo.setText("Cant. Max. Copias Simultaneas");
		            atributoExtra.setText(String.valueOf(impresoraImpacto.getMaxCopiasSimultaneas()));
		        } else if (impresora instanceof ImpresoraLaser) {
		            ImpresoraLaser impresoraLaser = (ImpresoraLaser) impresora;
		            atributo.setText("TipoPapel");
		            atributoExtra.setText(MetodosImpresora.obtenerStringTipoPapel(impresoraLaser.getTipoPapel()));
		        } else if (impresora instanceof ImpresoraTinta) {
		            ImpresoraTinta impresoraTinta = (ImpresoraTinta) impresora;
		            atributo.setText("Velocidad Impresion");
		            atributoExtra.setText(String.valueOf(impresoraTinta.getVelocidadImpresion()));
		        }
		        tablaImpresora.refresh();
		    } else {
		        actividad.setText("");
		        nombre.setText("");
		        marca.setText("");
		        tipoImpresora.setText("");
		    }
		
	}
	
	/**
	 * Actualiza la tabla en caso de borrado, editado o agregado de nuevas impresoras
	 */
	public void actualizarTabla() {
		tablaImpresora.setItems(mainApp.getlistaImpresoras());
		tablaImpresora.refresh();
		 
	}
	
	



}
