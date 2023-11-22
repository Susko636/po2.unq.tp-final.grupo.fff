package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseTerminalPortuaria {

	private TerminalPortuaria terminal;
	private String nombre;
	private Double posicion;
	
	@BeforeEach
	void setUp() {
	
		terminal = new TerminalPortuaria("Terminal1",10d); 
	}
	
	@Test
	void TestCreacionTerminalPortuaria() {
		assertEquals(terminal.getNombre(), "Terminal1");
		assertEquals(terminal.getPosicion(), 10d);
	}
}
