package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class Arrived implements EstadoBuque{
	
	@Override
	public void distanciaHasta(Viaje unViaje, Double posicionActual) {
		//queda a la espera de que la terminal le diga que pase a working
	}

	@Override
	public boolean esDeparting() {
		return false;
	}

	@Override
	public boolean esOutbound() {
		return false;
	}


	@Override
	public boolean esArrived() {
		return true;
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
