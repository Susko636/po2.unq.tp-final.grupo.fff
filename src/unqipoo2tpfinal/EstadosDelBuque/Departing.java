package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class Departing implements EstadoBuque{

	@Override
	public void distanciaHasta(Viaje unViaje, Double posicionActual) {
		Buque buque = unViaje.getBuqueAsignado();
		if (posicionActual > unViaje.getTerminalDeSalida().getPosicion()) {
			buque.informarSalidaBuque(unViaje.getTerminalDeSalida());
			buque.setEstadoBuque(new Outbound());
		}
	}

	@Override
	public boolean esDeparting() {
		return true;
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
