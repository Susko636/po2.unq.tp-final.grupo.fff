package unqipoo2tpfinal;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseBuque {

	private Buque unBuque;
	private Viaje unViaje;
	private TerminalPortuaria unaTerminal;
	private EstadoBuque estado;
	
	@BeforeEach
	public void setUp() {
		unViaje = mock(Viaje.class);
		unaTerminal = mock(TerminalPortuaria.class);
		unBuque = new Buque(unViaje,unaTerminal.getPosicion());
	}
	
	@Test
	void testEsEstadoDeparting() {
		estado = mock(Departing.class);
		unBuque.setEstadoBuque(estado);
		
		when(estado.esDeparting()).thenReturn(true);
		
		assertTrue(unBuque.getEstadoBuque().esDeparting());
		
		verify(estado).esDeparting();
	}
	
	@Test
	void testEsEstadoOutbound() {
		estado = mock(Outbound.class);

		unBuque.avanzar(1); //kilometro
		unBuque.distanciaA();
		
		assertEquals(unBuque.getEstadoBuque(), estado);
		
	}
	
	
	
	

}
