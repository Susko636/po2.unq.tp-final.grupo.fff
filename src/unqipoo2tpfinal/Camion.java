package unqipoo2tpfinal;

public class Camion {
	
	private String patente;
	private String marca;
	
	
	public Camion(String patente, String marca) {
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
