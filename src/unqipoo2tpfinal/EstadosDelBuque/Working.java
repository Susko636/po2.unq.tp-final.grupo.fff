package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.EstadoBuque;
import unqipoo2tpfinal.Viaje;

public class Working implements EstadoBuque{
	
	@Override
	public void distanciaHasta(Viaje unViaje, Double posicionActual) {
		// se queda a la espera de que terminen los trabajos de carga o descarga.
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
		return false;
	}


	@Override
	public boolean esInBound() {
		return false;
	}


	@Override
	public boolean esWorking() {
		return true;
	}

}
