package unqipoo2tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CircuitoMaritimo {
	
	private List<Tramo> tramos;
	
	public CircuitoMaritimo() {
		this.tramos = new ArrayList<Tramo>();
	}
	
	
	public void agregarTramo(Tramo unTramo) {
		
		Tramo ultimoTramo = this.buscarUltimoTramo();
		
		if (ultimoTramo != null && !ultimoTramo.getTerminalDeLlegada().equals(unTramo.getTerminalDeSalida())) {
				throw new AssertionError(this.getMessage());
		}
		this.getTramos().add(unTramo);
	}
	
	public Tramo buscarUltimoTramo() {
		return this.tramos.stream()
				.reduce((first, second) -> second)
				.orElse(null);
	}
	
	
	public List<Tramo> getTramos() {
		return this.tramos;
	}


	public String getMessage() {
		return "No coinciden las terminales";
	}


	public Double cantidadDeTerminalesIntermedias(TerminalPortuaria terminalLlegada) {
		List<Tramo> tramosARecorrer = this.getTramos();
		Double cantTerminal = 0d;
		int i = 0;
		while(tramosARecorrer.get(i).getTerminalDeLlegada() != terminalLlegada) {
			cantTerminal ++;
			i++;
		}
		return cantTerminal;
	}


	public boolean existeAlgunTramoCon(TerminalPortuaria terminalLlegada) {
		return this.getTramos().stream().anyMatch(t->t.getTerminalDeLlegada().equals(terminalLlegada));
	}
	
} 
