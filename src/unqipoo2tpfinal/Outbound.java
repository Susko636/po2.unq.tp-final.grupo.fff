package unqipoo2tpfinal;

public class Outbound implements EstadoBuque{


	public EstadoBuque getEstado(Buque unBuque) {
		
		return unBuque.getEstadoBuque();
	}


	public void distanciaDe(Buque unBuque) {
		
		if (50 == Math.abs(unBuque.getPosicionActual() - unBuque.getViajeAsignado().getTerminalDeLlegada().getPosicion())) {
			unBuque.setEstadoBuque(new InBound());
			unBuque.getViajeAsignado().getTerminalDeSalida().informarCercanoArribo();
		};		
	}


	@Override
	public boolean esDeparting() {
		return false;
	}

	
}
