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

	private double getConsumo() {
		return this.consumo;
	}

	@Override
	public void realizarServicio(Servicio unServicio) {
		// TODO Auto-generated method stub
		
	}

}
