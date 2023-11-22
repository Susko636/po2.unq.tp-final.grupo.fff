package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import unqipoo2tpfinal.empresaTransportista.Camion;


class TestCaseCamion {

	
	private Camion camion;
	private String patentePrueba;
	private String marcaPrueba;
	
	@BeforeEach
	public void setUp() {
		patentePrueba = "123abc";
		marcaPrueba = "Ford";
		camion = new Camion(patentePrueba,marcaPrueba);
	}
	
	@Test
	void testUnCamionEsMarcaFord() {
		assertEquals(camion.getMarca(), marcaPrueba);
	}
	
	@Test
	void testUnCamionTienePatente123abc() {
		assertEquals(camion.getPatente(), patentePrueba);
	}


}
