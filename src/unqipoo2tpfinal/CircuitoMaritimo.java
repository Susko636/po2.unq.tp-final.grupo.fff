package unqipoo2tpfinal;

import java.util.ArrayList;

public class CircuitoMaritimo {
	
	private ArrayList<Tramo> tramos = new ArrayList<Tramo>();
	
	public void agregarTramo(Tramo unTramo) {
		
		tramos.add(unTramo);
		
	}
	
	public ArrayList<Tramo> getTramos() {
		return tramos;
	}
	
}
