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
		
		if (ultimoTramo.getTerminalDeLlegada() != unTramo.getTerminalDeSalida()) {
			throw new AssertionError();
		}else {
			tramos.add(unTramo);		// en caso de que sea null el ultimo tramo, lo agrega igualmente.
		}
	}
	
	public Tramo buscarUltimoTramo() {
		return this.tramos.stream()
				.reduce((first, second) -> second)
				.orElse(null);
	}
	
	
	public List<Tramo> getTramos() {
		return this.tramos;
	}
	
} 
