package EstadoBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;

public class Working implements EstadoBuque{


	public EstadoBuque getEstado(Buque unBuque) {

		return null;
	}


	public void distanciaDe(Buque unBuque) {
		//Simplemente espera la orden de la terminal para partir
	}


	@Override
	public boolean esDeparting() {
		return false;
	}


	@Override
	public void irASiguienteEstado(Buque unBuque) {
		unBuque.setEstadoBuque(new Departing());
		
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
