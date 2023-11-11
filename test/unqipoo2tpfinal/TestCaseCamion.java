package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.empresaTransportista.Camion;

class TestCaseCamion {
	
	private Camion camion;
	
	@BeforeEach
	public void setUp() {
		camion = new Camion("ABC 123", "Ford");
	}

	@Test
	void testCreacionCamion() {
		assertEquals(camion.getPatente(), "ABC 123");
		assertEquals(camion.getMarca(), "Ford");
	}

}
