package unqipoo2tpfinal;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Viaje {
	
	private CircuitoMaritimo circuito;
	private LocalDate fechaLlegada;
	private LocalDate fechaSalida;
	private TerminalGestionada terminalDeSalida;
	private TerminalPortuaria terminalDeLlegada;
	private Buque buqueAsignado;
	
	public Viaje(Buque unBuque,LocalDate fechaInicio,TerminalGestionada ts,TerminalPortuaria tl, CircuitoMaritimo circuitoElegido ) {
		this.buqueAsignado = unBuque;
		this.fechaSalida = fechaInicio;
		this.terminalDeSalida = ts;
		this.terminalDeLlegada = tl;
		this.circuito = circuitoElegido;
	}
	
	public void informar() {
		this.terminalDeLlegada.recibirFechaDeLlegadaDeViaje(this.fechaLlegada);
	}
	
	public void pagar() {
		
	}
	
	public List<Tramo> recorridoDelViaje() {
		int i = 0;
		List<Tramo> newTramos = new ArrayList<Tramo>();  
		ArrayList<Tramo> tramos = this.circuito.getTramos();
		while(tramos.get(i).getTerminalDeLlegada() != this.terminalDeLlegada) {
			i++;
			newTramos.add(tramos.get(i));
		}
		newTramos.add(tramos.get(i));
		return newTramos;
	}
	
	public int calcularFechaDeLlegada() {
		//se asume que el tiempo de recorrido esta divido en horas y la parte fraccionaria en minutos.
		Double horas =this.recorridoDelViaje().stream().mapToDouble(t-> t.getTiempoDeRecorrido()).sum();
		return horas.intValue(); 
	}
	
	public void setFechaDeLlegada() {
		this.fechaLlegada = this.fechaLlegada.plusDays(this.calcularFechaDeLlegada());
	}
	
	
	public CircuitoMaritimo getCircuito() {
		return this.circuito;
	}

	public LocalDate getFechaLlegada() {
		return this.fechaLlegada;
	}

	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}

	public TerminalGestionada getTerminalDeSalida() {
		return this.terminalDeSalida;
	}
 
	public TerminalPortuaria getTerminalDeLlegada() { 
		return this.terminalDeLlegada;
	}

	public Buque getBuqueAsignado() {
		return this.buqueAsignado;
	}
}
