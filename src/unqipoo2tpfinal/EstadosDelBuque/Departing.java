package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class Departing implements EstadoBuque{

	@Override
	public void distanciaHasta(Viaje unViaje) {
		Buque buque = unViaje.getBuqueAsignado();
		if (!buque.getPosicionActual().equals(unViaje.getTerminalDeSalida().getPosicion())) {
			buque.informarSalidaBuque(unViaje.getTerminalDeSalida());
			buque.setEstadoBuque(new Outbound());
		}
	}

	

}
