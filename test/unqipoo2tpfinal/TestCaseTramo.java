package unqipoo2tpfinal;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.EstadosDelBuque.Departing;

class TestCaseTramo {
	private Tramo unTramo;
	private TerminalPortuaria terminalDeSalida;
	private TerminalPortuaria terminalDeLlegada;
	private Double tiempoDeRecorrido;
	
	
	@BeforeEach
	public void setUp() {
		terminalDeSalida = mock(TerminalPortuaria.class);
		terminalDeLlegada = mock(TerminalPortuaria.class);
		tiempoDeRecorrido = 2d;
		unTramo = new Tramo(terminalDeSalida, terminalDeLlegada, tiempoDeRecorrido);
	}
	
	@Test
	void testTieneTiempoDeRecorridos() {
		
		Double tiempoTramo = unTramo.getTiempoDeRecorrido();
		
		assertEquals(tiempoTramo, this.tiempoDeRecorrido);

	}
	
	@Test
	void testTienePrecioPorRecorridos() {
		
		Double precioTramo = unTramo.precioPorTramo();
		
		assertEquals(precioTramo, this.tiempoDeRecorrido);

	}
	
	@Test
	void testTermianlSalidaSonIguales() {
		
		TerminalPortuaria terminalEsperada = unTramo.getTerminalDeSalida();
		
		assertEquals(terminalEsperada, this.terminalDeSalida);

	}
	
	@Test
	void testTermianlLlegadaSonIguales() {
		
		TerminalPortuaria terminalEsperada = unTramo.getTerminalDeLlegada();
		
		assertEquals(terminalEsperada, this.terminalDeLlegada);

	}
	
}
