package unqipoo2tpfinal.empresaTransportista;

public class Camion {
	
	private String patente;
	private String marca;
	
	
	public Camion(String patente, String marca) {
		super();
		this.marca = marca;
		this.patente = patente;
	}


	public String getPatente() {
		return this.patente;
	}


	public String getMarca() {
		return this.marca;
	}
	
	
	
}
