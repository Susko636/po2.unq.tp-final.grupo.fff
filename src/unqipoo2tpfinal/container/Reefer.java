package unqipoo2tpfinal.container;

public class Reefer extends Conteiner{
	
	private Double consumo;

	public Reefer(Double ancho, Double altura, Double largo, Double pesoTotal, Double consumo) {
		super(ancho, altura, largo, pesoTotal);
		this.consumo = consumo;
	}

	public Double getConsumo() {
		return this.consumo;
	}
	
	

}
