package unqipoo2tpfinal;

public class Container {
	
	private Double ancho;
	private Double altura;
	private Double largo;
	private Double pesoTotal;
	
	public Container(Double ancho, Double altura,Double largo, Double pesoTotal) {
		this.ancho = ancho;
		this.altura = altura;
		this.largo = largo;
		this.pesoTotal = pesoTotal;
	}

	public Double getAncho() {
		return ancho;
	}

	public Double getAltura() {
		return altura;
	}

	public Double getLargo() {
		return largo;
	}

	public Double getPesoTotal() {
		return pesoTotal;
	}
	
	
}
