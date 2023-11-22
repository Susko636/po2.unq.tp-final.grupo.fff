package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.servicio.ServicioAlmacenamiento;

class TestCaseServicioAlmacenamiento {

	private ServicioAlmacenamiento unServicioAlmacenamiento;
	private Double precioEsperado;
		
	@BeforeEach
	public void setUp(){
		unServicioAlmacenamiento = new ServicioAlmacenamiento();
		precioEsperado = 10000d;
	}
		
	@Test
	void testPrecioDelServicioAlmacenamiento() {
			
		assertEquals(unServicioAlmacenamiento.precio(),precioEsperado);
	}
	

}
