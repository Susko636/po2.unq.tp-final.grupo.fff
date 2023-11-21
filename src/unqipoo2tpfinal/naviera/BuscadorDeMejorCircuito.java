package unqipoo2tpfinal.naviera;

import java.util.List;

import unqipoo2tpfinal.CircuitoMaritimo;
import unqipoo2tpfinal.TerminalPortuaria;

public interface BuscadorDeMejorCircuito {
	
	public CircuitoMaritimo elegirMejorCircuito(List<CircuitoMaritimo> circuitos, TerminalPortuaria terminalDeLlegada);
	
}
