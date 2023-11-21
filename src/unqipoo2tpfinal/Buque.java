package unqipoo2tpfinal;

import unqipoo2tpfinal.EstadosDelBuque.Departing;
import unqipoo2tpfinal.EstadosDelBuque.Outbound;
import unqipoo2tpfinal.EstadosDelBuque.Working;

public class Buque {
	
	private Viaje viajeAsignado;
	private EstadoBuque estadoBuque;
	private Double posicionActual;
	
	public Buque(Viaje viajeAsignado, Double posicionActual ) {
		this.viajeAsignado = viajeAsignado;
		this.posicionActual = posicionActual;
		this.estadoBuque = new Departing();
	}
	
	public void distanciaATerminalDeLlegada() {
		this.estadoBuque.distanciaHasta(this.getViajeAsignado());
	}
	
	public Viaje getViajeAsignado() {
		return this.viajeAsignado;
	}
	
	public EstadoBuque getEstadoBuque() {
		return this.estadoBuque;
	}
	
	public void setEstadoBuque(EstadoBuque estadoBuque) {
		this.estadoBuque = estadoBuque;
	}
	

	public Double getPosicionActual() {
		return this.posicionActual;
	}

	public void avanzar(Double i) {
		this.posicionActual += i;
	}

	public void informarCercanoArrivo(TerminalGestionada terminalDeLlegada) {
		terminalDeLlegada.informarCercanoArrivoDe(this);
	}

	public void informarSalidaBuque(TerminalGestionada terminalDeSalida) {
		terminalDeSalida.informarSalidaDe(this);
	}

	public void empezarTrabajo() {
		this.cambiarAWorking();
		
	}
	
	public void cambiarAWorking() {
		this.setEstadoBuque(new Working());
	}
	
	public void terminarTrabajo() {
		this.setEstadoBuque(new Departing());
	}

	public void cambiarAOutbound() {
		this.setEstadoBuque(new Outbound());
	}
	
}
