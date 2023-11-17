package unqipoo2tpfinal;

import unqipoo2tpfinal.EstadosDelBuque.Departing;
import unqipoo2tpfinal.EstadosDelBuque.Outbound;

public class TerminalPortuaria {
	
	private int numeroDeTerminal;
	private int posicion;
	
	public TerminalPortuaria(int numeroDeTerminal, int posicion) {
		
		this.numeroDeTerminal = numeroDeTerminal;
		this.posicion = posicion;
	}

	public int getNumeroDeTerminal() {
		return numeroDeTerminal;
	}

	public int getPosicion() {
		return posicion;
	}

	public void informarSalidaBuque(Buque unBuque) {
		unBuque.getEstadoBuque().irASiguienteEstado(unBuque);
		
	}

	public void informarSalidaBuque() {
		//Envia E-Mail a todos los Shippers cuyas órdenes de exportacion esten asociadas al viaje, diciendo que su carga salio de la terminal
	}

	public void informarCercanoArribo(Buque unBuque) {
		//Envia E-Mail a todos los consignee que esten esperando este buque
	}
	
	public void depart(Buque unBuque) {
		unBuque.getEstadoBuque().irASiguienteEstado(unBuque);
	}
	
	
}
