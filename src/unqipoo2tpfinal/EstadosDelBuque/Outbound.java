package unqipoo2tpfinal.EstadosDelBuque;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.EstadoBuque;

public class Outbound implements EstadoBuque{


	public EstadoBuque getEstado(Buque unBuque) {
		
		return unBuque.getEstadoBuque();
	}


	public void distanciaDe(Buque unBuque) {
		
		if (50 >= Math.abs(unBuque.getPosicionActual() - unBuque.getViajeAsignado().getTerminalDeLlegada().getPosicion())) {
			unBuque.setEstadoBuque(new InBound());
			unBuque.getViajeAsignado().getTerminalDeSalida().informarCercanoArribo(unBuque);
		};		
	}


	@Override
	public boolean esDeparting() {
		return false;
	}


	@Override
	public void irASiguienteEstado(Buque unBuque) {
		unBuque.setEstadoBuque(new InBound());
		
	}
	
	@Override
	public boolean esOutbound() {
		return true;
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
