package unqipoo2tpfinal;


import static org.junit.Assert.assertEquals;
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

		unBuque.setEstadoBuque(new Departing());
		estado = mock(Departing.class);
		when(estado.getEstado(unBuque)).thenReturn(unBuque.getEstadoBuque());
		
			assertEquals(unBuque.getEstadoBuque(), estado.getEstado(unBuque));
		
			verify(estado).getEstado(unBuque);
	}
	
	
	//void testEsEstadoOutbound() {
	//	estado = mock(Outbound.class);
	//	unBuque.setPosicionActual(10);
	//	assertEquals(unBuque.getEstadoBuque(), estado);
		
	//}
	
	
	
	

}
