package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * Clase que representa una impresora laser
 * @author MIGUEL ANGEL
 *
 */
public class ImpresoraLaser extends Impresora implements Imprimir, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoPapel tipoPapel;
	/**
	 * Contructor
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipoImpresora
	 * @param tipoPapel
	 */
	public ImpresoraLaser(Estado estado, String nombre, String marca, TipoImpresora tipoImpresora, TipoPapel tipoPapel) {
		super(estado, nombre, marca, tipoImpresora);
		this.tipoPapel=tipoPapel;
	}
	
	

	public TipoPapel getTipoPapel() {
		return tipoPapel;
	}
	public void setTipoPapel(TipoPapel tipoPapel) {
		this.tipoPapel = tipoPapel;
	}


	/**
	 * Metodo para imprimir con una impresora laser
	 */
	@Override
	public void imprimirDocumento(String documento) {
		JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(documento);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Contenido a imprimir con la impresora laser", JOptionPane.INFORMATION_MESSAGE);
	}

}
