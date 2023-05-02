package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que representa a una Impresora de impacto
 * @author MIGUEL ANGEL
 *
 */
public class ImpresoraImpacto extends Impresora implements Imprimir, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxCopiasSimultaneas;//Cantida de copias que puede realizar a la vez
	
	/**
	 * Constructor
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipoImpresora
	 * @param maxCopiasSimultaneas
	 */
	public ImpresoraImpacto(Estado estado, String nombre, String marca, TipoImpresora tipoImpresora, int maxCopiasSimultaneas) {
		super(estado, nombre, marca, tipoImpresora);
		this.maxCopiasSimultaneas=maxCopiasSimultaneas;
	}
	

	public int getMaxCopiasSimultaneas() {
		return maxCopiasSimultaneas;
	}
	public void setMaxCopiasSimultaneas(int maxCopiasSimultaneas) {
		this.maxCopiasSimultaneas = maxCopiasSimultaneas;
	}

	/**
	 * Metodo para imprimir con una impresora de impacto
	 */
	@Override
	public void imprimirDocumento(String documento) {
		JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(documento);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Contenido a imprimir con la impresora de impacto", JOptionPane.INFORMATION_MESSAGE);	}


}
