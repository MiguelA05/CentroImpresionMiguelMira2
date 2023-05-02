package co.uniquindio.pg2.CentroImpresionMiguelMira.model;

public class Documento {
	private String titulo;
	private String estado;
	private String texto;
	private Integer prioridad;
	
	
	public Documento(String titulo, String estado, String texto, Integer prioridad) {
		super();
		this.titulo = titulo;
		this.estado = estado;
		this.texto = texto;
		this.prioridad = prioridad;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
	

}
