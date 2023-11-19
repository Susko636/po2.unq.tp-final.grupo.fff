package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class InBound implements EstadoBuque{

	public void distanciaHasta(Viaje unViaje) {
		Buque buque = unViaje.getBuqueAsignado();
		if (buque.getPosicionActual() == unViaje.getTerminalDeLlegada().getPosicion()) {
			buque.setEstadoBuque(new Arrived());
			buque.informarCercanoArrivo(unViaje.getTerminalDeLlegada());
		}	
	}
	
	
}
