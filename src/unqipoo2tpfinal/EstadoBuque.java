package unqipoo2tpfinal;

public interface EstadoBuque {
	
	EstadoBuque getEstado(Buque unBuque);
	
	void distanciaDe(Buque unBuque);

	void irASiguienteEstado(Buque unBuque);

	boolean esDeparting();
	
	boolean esOutbound();
	
	boolean esArrived();
	
	boolean esInBound();
	
	boolean esWorking();
}
