package unqipoo2tpfinal;

import unqipoo2tpfinal.EstadosDelBuque.Departing;

public class Buque {
	
	private Viaje viajeAsignado;
	private TerminalPortuaria proximaTerminal;
	private EstadoBuque estadoBuque;
	private int posicionActual;
	
	public Buque(Viaje viajeAsignado, int posicionActual ) {
		this.viajeAsignado = viajeAsignado;
		this.posicionActual = posicionActual;
		this.estadoBuque = new Departing();
		this.proximaTerminal = viajeAsignado.getTerminalDeLlegada();
	}
	
	public void distanciaA() {
		this.estadoBuque.distanciaDe(this);
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
	
	public TerminalPortuaria getProximaTerminal() {
		return this.proximaTerminal;
	}
	
	public void setProximaTerminal(TerminalPortuaria proximaTerminal) {
		this.proximaTerminal = proximaTerminal;
	}

	public int getPosicionActual() {
		return posicionActual;
	}

	public void avanzar(int i) {
		this.posicionActual += i;
	}
	
	
	
	
	
}
