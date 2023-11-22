package unqipoo2tpfinal.servicio;


public class ServicioElectricidad implements Servicio {

	private Double consumo;
	
	public ServicioElectricidad(Double consumo) {
		this.consumo = consumo;
	}

	@Override
	public double precio() {
		return this.getConsumo() * 10d;
	}

	public double getConsumo() {
		return this.consumo;
	}


}
