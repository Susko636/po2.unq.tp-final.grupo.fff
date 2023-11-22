package unqipoo2tpfinal;

import unqipoo2tpfinal.EstadosDelBuque.Arrived;
import unqipoo2tpfinal.EstadosDelBuque.Departing;
import unqipoo2tpfinal.EstadosDelBuque.InBound;
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

	public Double getPosicionActual() {
		return this.posicionActual;
	}
	
	public void setEstadoBuque(EstadoBuque estadoBuque) {
		this.estadoBuque = estadoBuque;
	}
	
	public void cambiarAWorking() {
		this.setEstadoBuque(new Working());
	}

	public void cambiarAOutbound() {
		this.setEstadoBuque(new Outbound());
	}
	
	public void cambiarAInbound() {
		this.setEstadoBuque(new InBound());
	}
	
	public void cambiarADeparting() {
		this.setEstadoBuque(new Departing());
	}
	
	public void cambiarAArrived() {
		this.setEstadoBuque(new Arrived());
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
	
	public void terminarTrabajo() {
		this.cambiarADeparting();
	}
	
}
