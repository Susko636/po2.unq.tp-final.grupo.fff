package unqipoo2tpfinal;

import java.util.ArrayList;

public class CircuitoMaritimo {
	
	private ArrayList<Tramo> tramos = new ArrayList<Tramo>();
	
	public CircuitoMaritimo(ArrayList<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	public void agregarTramo(Tramo unTramo) {
		
		this.verificarSiEsTramoSiguiente(unTramo);
		
		tramos.add(unTramo);
		
	}
	
	public ArrayList<Tramo> getTramos() {
		return tramos;
	}
	
	public boolean verificarSiEsTramoSiguiente(Tramo unTramo) {
		
		Tramo ultimoTramo =   tramos.stream()
									.reduce((first, second) -> second)
									.orElse(null);
		
		if (ultimoTramo.getTerminalDeLlegada() == unTramo.getTerminalDeSalida()) {
			
			return true;
					
		}
		
		throw new AssertionError();
		
	}
	
} 
