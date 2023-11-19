package unqipoo2tpfinal;



import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.Buque;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.Viaje;
import unqipoo2tpfinal.EstadosDelBuque.Departing;
import unqipoo2tpfinal.EstadosDelBuque.Outbound;

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
}
