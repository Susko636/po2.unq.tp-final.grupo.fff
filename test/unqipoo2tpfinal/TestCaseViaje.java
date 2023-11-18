package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseViaje {
	
	private Viaje viaje;
	private TerminalGestionada terminalDeSalida;
	private TerminalPortuaria terminalDeLlegada;
	private List<Tramo> tramos;
	private CircuitoMaritimo circuito;
	private Buque buque;
	private LocalDate fechaInicio = LocalDate.of(2023, 11, 18);
	
	@BeforeEach
	public void setUp() {
		viaje = new Viaje(buque, fechaInicio, terminalDeSalida, terminalDeLlegada, circuito);
	}
	
	@Test 
	public void testDeCreacionDeViaje() { 
		
	}
	
}
