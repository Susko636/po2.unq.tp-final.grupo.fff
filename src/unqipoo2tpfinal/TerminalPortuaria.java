package unqipoo2tpfinal;

import unqipoo2tpfinal.EstadosDelBuque.Departing;
import unqipoo2tpfinal.EstadosDelBuque.Outbound;

public class TerminalPortuaria {
	
	private int numeroDeTerminal;
	private Double posicion;
	
	public TerminalPortuaria(int numeroDeTerminal, Double posicion) {
		
		this.numeroDeTerminal = numeroDeTerminal;
		this.posicion = posicion;
	}

	public int getNumeroDeTerminal() {
		return numeroDeTerminal;
	}

	public Double getPosicion() {
		return posicion;
	}

	public void informarSalidaDe(Buque unBuque) {
		//Envia E-Mail a todos los Shippers cuyas órdenes de exportacion esten asociadas al viaje, diciendo que su carga salio de la terminal
	}

	public void informarCercanoArrivoDe(Buque unBuque) {
		//Envia E-Mail a todos los consignee que esten esperando este buque
	}
	
	public void depart(Buque unBuque) {
		unBuque.cambiarAOutbound();
	}

	public void comenzarTrabajo(Buque buque) {
		buque.empezarTrabajo();
	}
	
	
}
