package unqipoo2tpfinal.naviera;

import java.time.LocalDate;
import java.util.List;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.CircuitoMaritimo;
import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.Viaje;


public class Naviera {

	private List<Buque> buques;
	private List<CircuitoMaritimo> circuitos;
	private BuscadorDeMejorCircuito buscador;

	public Naviera(List<Buque> buques, List<CircuitoMaritimo> circuitos) {

		this.buques = buques;
	    this.circuitos = circuitos;
	}
	
	public void setBuscador(BuscadorDeMejorCircuito criterioDeMejor) {
		this.buscador = criterioDeMejor;
	}
	
	public BuscadorDeMejorCircuito getBuscador() {
		return this.buscador;
	}
	

	public List<CircuitoMaritimo> getCircuitos() {
		return this.circuitos;
	}

	public List<Buque> getBuques() {
		return this.buques;
	}

	public void cronograma() {
		//hacer;
	}
	
	public Buque asignarBuque() {
		Buque buqueABorrar = this.getBuques().get(0);
		this.getBuques().remove(buqueABorrar);
		return buqueABorrar;
	}

	public boolean tieneViajePara(TerminalPortuaria terminalLlegada) {
		return this.getCircuitos().stream().anyMatch(c-> c.existeAlgunTramoCon(terminalLlegada));
	}

	public CircuitoMaritimo pedirMejorCircuitoHacia(TerminalPortuaria terminalLlegada) {
		return this.getBuscador().elegirMejorCircuito(this.getCircuitos(),terminalLlegada);
	}

	public Viaje crearViajeA(TerminalPortuaria terminalLlegada, CircuitoMaritimo unCircuito, TerminalGestionada terminalGestionada, LocalDate fechaInicio) {
		return new Viaje(this.asignarBuque(), fechaInicio, terminalGestionada, terminalLlegada, unCircuito);
	}

	public void asignarCriterioDeBusqueda(BuscadorDeMejorCircuito criterioDeMejor) {
		this.setBuscador(criterioDeMejor);
	}
	
}
