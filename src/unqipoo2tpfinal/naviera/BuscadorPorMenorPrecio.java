package unqipoo2tpfinal.naviera;

import java.util.List;

import unqipoo2tpfinal.CircuitoMaritimo;
import unqipoo2tpfinal.TerminalPortuaria;

public class BuscadorPorMenorPrecio implements BuscadorDeMejorCircuito {
	
	public BuscadorPorMenorPrecio() {
		super();
	}

	@Override
	public CircuitoMaritimo elegirMejorCircuito(List<CircuitoMaritimo> circuitos, TerminalPortuaria terminalDeLlegada) {
		CircuitoMaritimo mejorCircuito = circuitos.stream().
				min((CircuitoMaritimo c1, CircuitoMaritimo c2)
					->c1.precioHasta(terminalDeLlegada).
					compareTo(c2.precioHasta(terminalDeLlegada))).get();
		return mejorCircuito;
	}

}
