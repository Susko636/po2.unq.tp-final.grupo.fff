package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.servicio.ServicioLavado;

class TestCaseServicioLavado {

	private ServicioLavado unServicioLavado;
	private Double precioEsperado;
	
	@BeforeEach
	public void setUp(){
		unServicioLavado = new ServicioLavado();
		precioEsperado = 40d;
	}
	
	@Test
	void testPrecioDelServicioLavado() {
		
		assertEquals(unServicioLavado.precio(),precioEsperado);
	}
}