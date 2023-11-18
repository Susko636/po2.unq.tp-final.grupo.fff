package unqipoo2tpfinal;

import java.util.ArrayList;

public class CircuitoMaritimo {
	
	private ArrayList<Tramo> tramos = new ArrayList<Tramo>();
	
	public CircuitoMaritimo(ArrayList<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	
	/*public Tramo avanzarASiguienteTramo(Tramo unTramo) {
		return this.tramos.stream().filter(t-> t.getTerminalDeLlegada() == unTramo.getTerminalDeSalida()).findFirst();
	}*/
	
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
	
	
	public ArrayList<Tramo> getTramos() {
		return this.tramos;
	}
	
} 
