package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que representa a una impresora de tinta;
 * @author MIGUEL ANGEL
 *
 */
public class ImpresoraTinta extends Impresora implements Imprimir, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int velocidadImpresion;//Velocidad de impresion medida en ppm(paginas por minuto) con la que cuenta la impresora
	/**
	 * Constructor
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipoImpresora
	 * @param velocidadImpresion
	 */
	public ImpresoraTinta(Estado estado, String nombre, String marca, TipoImpresora tipoImpresora, int velocidadImpresion) {
		super(estado, nombre, marca, tipoImpresora);
		this.velocidadImpresion=velocidadImpresion;
	}
	
	

	public int getVelocidadImpresion() {
		return velocidadImpresion;
	}
	public void setVelocidadImpresion(int velocidadImpresion) {
		this.velocidadImpresion = velocidadImpresion;
	}


	/**
	 * Metodo para imprimir con una impresora de tinta
	 */
	@Override
	public void imprimirDocumento(String documento) {
		JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(documento);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Contenido a imprimir con la impresora de tinta", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
