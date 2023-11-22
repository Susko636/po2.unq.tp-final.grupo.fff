package unqipoo2tpfinal.container;

public class Conteiner {
	
	private Double ancho;
	private Double altura;
	private Double largo;
	private Double pesoTotal;
	protected Double consumo;
	
	public Conteiner(Double ancho, Double altura,Double largo, Double pesoTotal) {
		super();
		this.ancho = ancho;
		this.altura = altura;
		this.largo = largo;
		this.pesoTotal = pesoTotal;
		this.consumo = 0d;
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
	
	public Double getConsumo() {
		return consumo;
	}
	
}
