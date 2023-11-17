package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class InBound implements EstadoBuque{

	public void distanciaHasta(Viaje unViaje, Double posicionActual) {
		Buque buque = unViaje.getBuqueAsignado();
		if (buque.getPosicionActual() == unViaje.getTerminalDeLlegada().getPosicion()) {
			buque.setEstadoBuque(new Arrived());
			buque.informarCercanoArrivo(unViaje.getTerminalDeLlegada());
		}	
	}
	
	public boolean esDeparting() {
		return false;
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
		return true;
	}

	@Override
	public boolean esWorking() {
		return false;
	}
	
}
