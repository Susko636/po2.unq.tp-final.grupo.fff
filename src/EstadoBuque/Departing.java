package EstadoBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;

public class Departing implements EstadoBuque{
	

	public EstadoBuque getEstado(Buque unBuque) {

		return unBuque.getEstadoBuque();
	}


	public void distanciaDe(Buque unBuque) {
		if (unBuque.getPosicionActual() > unBuque.getViajeAsignado().getTerminalDeSalida().getPosicion()) {
			unBuque.setEstadoBuque(new Outbound());
			unBuque.getViajeAsignado().getTerminalDeSalida().informarSalidaBuque(unBuque);
		}
	}


	@Override
	public boolean esDeparting() {
		return true;
	}


	@Override
	public void irASiguienteEstado(Buque unBuque) {
		
		unBuque.setEstadoBuque(new Outbound());
		
	}


	@Override
	public boolean esOutbound() {
		return false;
	}


	@Override
	public boolean esArrived() {
		return false;
	}


	@Override
	public boolean esInBound() {
		return false;
	}


	@Override
	public boolean esWorking() {
		return false;
	}

}
