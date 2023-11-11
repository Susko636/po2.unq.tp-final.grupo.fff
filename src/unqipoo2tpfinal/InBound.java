package unqipoo2tpfinal;

public class InBound implements EstadoBuque{

	public EstadoBuque getEstado(Buque unBuque) {
		
		return unBuque.getEstadoBuque();
	}

	public void distanciaDe(Buque unBuque) {
		if (unBuque.getPosicionActual() == unBuque.getViajeAsignado().getTerminalDeLlegada().getPosicion()) {
			unBuque.setEstadoBuque(new Arrived());
		};	
	}

}
