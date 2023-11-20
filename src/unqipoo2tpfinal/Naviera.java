package unqipoo2tpfinal;

import java.util.ArrayList;
import java.util.List;

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
}
