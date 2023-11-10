package unqipoo2tpfinal;

public class Buque {
	
	private Viaje viajeAsignado;
	private TerminalPortuaria proximaTerminal;
	private EstadoBuque estadoBuque;
	private int posicionInicial;
	private int posicionActual;
	
	public Buque(Viaje viajeAsignado, int posicionActual ) {
		this.posicionInicial = posicionActual;
		this.viajeAsignado = viajeAsignado;
		this.posicionActual = posicionActual;
	}
	
	public Viaje getViajeAsignado() {
		return this.viajeAsignado;
	}
	
	public void setViajeAsignado(Viaje viajeAsignado) {
		this.viajeAsignado = viajeAsignado;
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
	
	
	
	
	
}
