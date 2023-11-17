package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;

public class InBound implements EstadoBuque{

	public EstadoBuque getEstado(Buque unBuque) {
		
		return unBuque.getEstadoBuque();
	}

	public void distanciaDe(Buque unBuque) {
		if (unBuque.getPosicionActual() == unBuque.getViajeAsignado().getTerminalDeLlegada().getPosicion()) {
			this.irASiguienteEstado(unBuque);
		};	
	}

	
	public boolean esDeparting() {
		return false;
	}

	@Override
	public void irASiguienteEstado(Buque unBuque) {
		unBuque.setEstadoBuque(new Arrived());
		
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
