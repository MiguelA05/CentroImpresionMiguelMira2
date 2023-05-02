 package co.uniquindio.pg2.CentroImpresionMiguelMira;
import java.io.IOException;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import co.uniquindio.pg2.CentroImpresionMiguelMira.controllers.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.util.SerializacionUtil;
import java.io.*;
/**
 * 
 * @author MIGUEL ANGEL
 *
 */
public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private CentroImpresion miCentro=new CentroImpresion("123");
	private ObservableList<Impresora> listaImpresoras=miCentro.getObservableListaImpresoras();
	private ImpresorasController impresorasController;
	private DetallesImpresoraController detallesImpresoraController;
	private ImpresionController impresionController;
	/**
	 * Metodo constructor;
	 */
	public Aplicacion() {
		
		
	}
	
	
	
	
	public ImpresionController getImpresionController() {
		return impresionController;
	}
	public void setImpresionController(ImpresionController impresionController) {
		this.impresionController = impresionController;
	}
	public DetallesImpresoraController getDetallesImpresoraController() {
		return detallesImpresoraController;
	}
	public void setDetallesImpresoraController(DetallesImpresoraController detallesImpresoraController) {
		this.detallesImpresoraController = detallesImpresoraController;
	}
	public void setListaImpresoras(ObservableList<Impresora> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}
	public void setImpresorasController(ImpresorasController impresorasController) {
	    this.impresorasController = impresorasController;
	}

	/**
	 * Metodo que obtiene la lista de impresoras del centro de impresion
	 * @return Lista de impresoras
	 */
	public ObservableList<Impresora> getlistaImpresoras() {
	    return miCentro.getObservableListaImpresoras();
	}
	
	/**
	 * Metodo que inicia la ejecucion la aplicacion
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Impresoras del centro de impresion");
	    try {
	        FileOutputStream fileOut = new FileOutputStream("centroImpresion.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(miCentro);
	        out.close();
	        fileOut.close();

			initRootLayout();
	        System.out.println("Objeto CentroImpresion serializado correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
	}
	
	/**
	 * Inicia la ventana principal
	 */
	public void initRootLayout() {
		try {
			FileInputStream fileIn = new FileInputStream("centroImpresion.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        try {
				miCentro = (CentroImpresion) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        in.close();
	        fileIn.close();
	        System.out.println("Objeto CentroImpresion deserializado correctamente.");

			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/VistaImpresoras.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			ImpresorasController controller = loader.getController();
			controller.setMainApp(this);
			controller.setMiCentro(miCentro);
			setImpresorasController(controller);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
	        
	        FileInputStream fileIn = new FileInputStream("centroImpresion.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        miCentro = (CentroImpresion) in.readObject();
	        in.close();
	        fileIn.close();
	        System.out.println("Objeto CentroImpresion deserializado correctamente.");

	        // ...
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Metodo que abre la ventana de editor de los detalles de una impresora
	 * @param impresora Impresora la cual se va a editar sus detalles
	 */
	public void mostrarEditorCaracteristicasImpresora(Impresora impresora, int caso) {
		try {
			   FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Aplicacion.class.getResource("view/DetallesImpresoras.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Editor de detalles de la impresora");
		        dialogStage.initModality(Modality.WINDOW_MODAL);
		        dialogStage.initOwner(primaryStage);
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);
		        
		        DetallesImpresoraController controller = loader.getController();
		        controller.setDialogStage(dialogStage);
		        controller.setImpresoraGuardar(impresora);
		        controller.setMiCentro(miCentro);
		        controller.setMainApp(this);
		        controller.setImpresorasController(impresorasController);
		        controller.setCaso(caso);
		        setDetallesImpresoraController(controller);
		        dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		
		} 
	}
	
	/**
	 * Metodo que abre la ventana donde se elige el archivo a imprimir
	 * @param impresora Impresora que va a imprimir
	 */
	public void mostrarImpresion(Impresora impresora) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/Impresiones.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Impresion de documento");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			ImpresionController controller = loader.getController();
			controller.setMainApp(this);
			controller.setDialogStage(dialogStage);
			controller.setImpresoraImprimir(impresora);
			controller.setMiCentro(miCentro);
			setImpresionController(controller);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Metodo que obtiene la ventana principal
	 * @return Ventana principal
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Metodo principal que lanza la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}






	
	
}