package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class Outbound implements EstadoBuque{


	@Override
	public void distanciaHasta(Viaje unViaje) {
		Buque buque = unViaje.getBuqueAsignado();
		if (50 >= Math.abs(buque.getPosicionActual() - unViaje.getTerminalDeLlegada().getPosicion())) {
			buque.cambiarAInbound();
		}	
	}
}
