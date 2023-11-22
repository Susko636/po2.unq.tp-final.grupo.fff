package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.servicio.ServicioElectricidad;

class TestCaseServicioElectricidad {

	private ServicioElectricidad unServicioElectricidad;
	private Double cantidadDeConsumo;
	private Double precioEsperado;
		
	@BeforeEach
	public void setUp(){
		cantidadDeConsumo = 10d;
		unServicioElectricidad = new ServicioElectricidad(cantidadDeConsumo);
		precioEsperado = cantidadDeConsumo * 10d;
	}
		
	@Test
	void testPrecioDelServicioElectricidad() {
			
		assertEquals(unServicioElectricidad.precio(),precioEsperado);
		
		assertEquals(unServicioElectricidad.getConsumo(),cantidadDeConsumo);
	}
	

}

