package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.servicio.ServicioPesado;

class TestCaseServicioPesado {

	private ServicioPesado unServicioPesado;
	private Double precioEsperado;
	
	@BeforeEach
	public void setUp(){
		unServicioPesado = new ServicioPesado();
		precioEsperado = 100d;
	}
	
	@Test
	void testPrecioDelServicioPesado() {
		
		assertEquals(unServicioPesado.precio(),precioEsperado);
	}
}
