package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.empresaTransportista.Chofer;

class TestCaseChofer {
	
	private Chofer chofer;
	
	@BeforeEach
	public void setUp() {
		chofer = new Chofer(31222444);
	}

	@Test
	void testCreacionChofer() {
		assertEquals(chofer.getDni(), 31222444);
	}

}
