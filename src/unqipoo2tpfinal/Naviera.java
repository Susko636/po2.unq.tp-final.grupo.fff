package unqipoo2tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.empresaTransportista.Chofer;

public class Naviera {

	private List<Buque> buques;
	private List<CircuitoMaritimo> circuitos;

	public Naviera(List<Buque> buques, List<CircuitoMaritimo> circuitos) {

		this.buques = buques;
	    this.circuitos = circuitos;
	}

	public void cronograma() {

	}

	public List<CircuitoMaritimo> getCircuitos() {
		return this.circuitos;
	}

	public List<Buque> getBuques() {
		return this.buques;
	}
	public Buque asignarBuque() {
		Buque buqueABorrar = this.getBuques().get(0);
		this.getBuques().remove(buqueABorrar);
		return buqueABorrar;
	}

	public boolean tieneViajePara(TerminalPortuaria terminalLlegada) {
		
		return this.getCircuitos().stream().anyMatch(c-> c.existeAlgunTramoCon(terminalLlegada));
	}

	public CircuitoMaritimo pedirCircuitoHacia(TerminalPortuaria terminalLlegada) {
		return this.getCircuitos().stream().filter(c-> c.existeAlgunTramoCon(terminalLlegada)).findFirst().get();
	}

	public Viaje crearViajeA(TerminalPortuaria terminalLlegada, CircuitoMaritimo unCircuito, TerminalGestionada terminalGestionada, LocalDate fechaInicio) {
		
		return new Viaje(this.asignarBuque(), fechaInicio, terminalGestionada, terminalLlegada, unCircuito);
	}
}
