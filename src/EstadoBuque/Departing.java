package unqipoo2tpfinal;

public class Departing implements EstadoBuque{


	public EstadoBuque getEstado(Buque unBuque) {

		return unBuque.getEstadoBuque();
	}


	public void distanciaDe(Buque unBuque) {
		if (unBuque.getPosicionActual() > unBuque.getViajeAsignado().getTerminalDeSalida().getPosicion()) {
			unBuque.setEstadoBuque(new Outbound());
			unBuque.getViajeAsignado().getTerminalDeSalida().informarSalidaBuque();
		}
	}


	@Override
	public boolean esDeparting() {
		return true;
	}

}
