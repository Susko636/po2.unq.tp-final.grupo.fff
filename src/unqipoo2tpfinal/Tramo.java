package unqipoo2tpfinal;

public class Tramo {

	private Double tiempoDeRecorrido;
	private TerminalPortuaria terminalDeSalida;
	private TerminalPortuaria terminalDeLlegada;
	
	public Tramo(TerminalPortuaria terminalSalida,TerminalPortuaria terminalLlegada,Double tiempo) {
		this.tiempoDeRecorrido = tiempo;
		this.terminalDeSalida = terminalSalida;
		this.terminalDeLlegada = terminalLlegada;
	}
 
	public Double getTiempoDeRecorrido() {
		return this.tiempoDeRecorrido;
	}

	public TerminalPortuaria getTerminalDeSalida() {
		return this.terminalDeSalida;
	}

	public TerminalPortuaria getTerminalDeLlegada() {
		return this.terminalDeLlegada;
	}
	
	public Double precioPorTramo() {
		Double ubicacion1 = this.terminalDeSalida.getPosicion();
		Double ubicacion2 = this.terminalDeLlegada.getPosicion();
		return Math.abs(ubicacion2 - ubicacion1) * 100d;
	}	

}
