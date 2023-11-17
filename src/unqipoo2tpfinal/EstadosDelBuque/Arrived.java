package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;

public class Arrived implements EstadoBuque{


	public EstadoBuque getEstado(Buque unBuque) {
	
		return null;
	}


	public void distanciaDe(Buque unBuque) {
		
		this.irASiguienteEstado(unBuque);
		
	}


	@Override
	public boolean esDeparting() {
		return false;
	}


	@Override
	public void irASiguienteEstado(Buque unBuque) {
		unBuque.setEstadoBuque(new Working());
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
