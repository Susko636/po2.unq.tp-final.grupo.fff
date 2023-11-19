package unqipoo2tpfinal;

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
	
} 
