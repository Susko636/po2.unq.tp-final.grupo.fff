package unqipoo2tpfinal;

public interface EstadoBuque {
	
	EstadoBuque getEstado(Buque unBuque);
	
	void distanciaDe(Buque unBuque);

	boolean esDeparting();
}
