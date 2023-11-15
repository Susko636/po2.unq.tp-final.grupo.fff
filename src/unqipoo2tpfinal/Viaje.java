package unqipoo2tpfinal;

import java.sql.Date;
import java.util.stream.Collectors;

public class Viaje {
	
	private CircuitoMaritimo circuito;
	private Date fechaLlegada;
	private Date fechaSalida;
	private TerminalPortuaria terminalDeSalida;
	private TerminalPortuaria terminalDeLlegada;
	private Buque buqueAsignado;
	
	public Viaje(Buque unBuque,Date fechaInicio) {
		this.buqueAsignado = unBuque;
		this.fechaSalida = fechaInicio;
	}
	
	public void informar() {
		
	}
	
	public void pagar() {
		
	}

	public CircuitoMaritimo getCircuito() {
		return this.circuito;
	}

	public Date getFechaLlegada() {
		return this.fechaLlegada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public TerminalPortuaria getTerminalDeSalida() {
		return this.terminalDeSalida;
	}
 
	public TerminalPortuaria getTerminalDeLlegada() {
		//this.terminalDeLlegada = (TerminalPortuaria)circuito.getTramos()
		//													.stream()
		//													.filter(tramo -> tramo.getTerminalDeSalida()
		//													.equals(this.terminalDeSalida));
		 this.terminalDeLlegada =   circuito.getTramos()
		            						.stream()
		            						.filter(tramo -> tramo.getTerminalDeSalida().equals(this.terminalDeSalida))
		            						.map(Tramo::getTerminalDeLlegada)  
		            						.findFirst() 
		            						.orElse(null);  
		 
		return this.terminalDeLlegada;
	}

	public Buque getBuqueAsignado() {
		return buqueAsignado;
	}
}
