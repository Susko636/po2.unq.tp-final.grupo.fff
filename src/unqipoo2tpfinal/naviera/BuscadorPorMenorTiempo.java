package unqipoo2tpfinal.naviera;

import java.util.List;

import unqipoo2tpfinal.CircuitoMaritimo;
import unqipoo2tpfinal.TerminalPortuaria;

public class BuscadorPorMenorTiempo implements BuscadorDeMejorCircuito {

	@Override
	public CircuitoMaritimo elegirMejorCircuito(List<CircuitoMaritimo> circuitos, TerminalPortuaria terminalDeLlegada) {
		CircuitoMaritimo mejorCircuito = circuitos.stream().
				min((CircuitoMaritimo c1, CircuitoMaritimo c2)
					->c1.tiempoHasta(terminalDeLlegada).
					compareTo(c2.tiempoHasta(terminalDeLlegada))).get();
		return mejorCircuito;
	}

}
