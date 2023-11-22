package unqipoo2tpfinal.naviera;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private List<Viaje> viajesDisponible;

	public Naviera(List<Buque> buques, List<CircuitoMaritimo> circuitos) {

		this.buques = buques;
	    this.circuitos = circuitos;
	    this.viajesDisponible = new ArrayList<Viaje>();
	    
	}
	
	public void setBuscador(BuscadorDeMejorCircuito criterioDeMejor) {
		this.buscador = criterioDeMejor;
	}
	
	public BuscadorDeMejorCircuito getBuscador() {
		return this.buscador;
	}
	
	public void agregarViajeACronograma(Viaje unViaje) {
		this.cronograma().add(unViaje);
	}

	public List<CircuitoMaritimo> getCircuitos() {
		return this.circuitos;
	}

	public List<Buque> getBuques() {
		return this.buques;
	}

	public List<Viaje> cronograma() {
		return this.viajesDisponible;
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
		Viaje unViaje = new Viaje(this.asignarBuque(), fechaInicio, terminalGestionada, terminalLlegada, unCircuito);
		this.agregarViajeACronograma(unViaje);
		return unViaje;
	}

	public void asignarCriterioDeBusqueda(BuscadorDeMejorCircuito criterioDeMejor) {
		this.setBuscador(criterioDeMejor);
	}
	
}
