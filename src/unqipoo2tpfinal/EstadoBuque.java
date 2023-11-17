package unqipoo2tpfinal;

public interface EstadoBuque {
	
	void distanciaHasta(Viaje unViaje, Double posicionActual);

	boolean esDeparting();
	
	boolean esOutbound();
	
	boolean esArrived();
	
	boolean esInBound();
	
	boolean esWorking();
}
