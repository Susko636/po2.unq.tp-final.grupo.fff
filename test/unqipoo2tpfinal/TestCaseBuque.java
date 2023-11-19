package unqipoo2tpfinal;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	private TerminalGestionada unaTerminal;
	private EstadoBuque estado;
	private Double posicionDeTerminal;
	
	@BeforeEach
	public void setUp() {
		unViaje = mock(Viaje.class);
		unaTerminal = mock(TerminalGestionada.class);
		unBuque = new Buque(unViaje,100d);
	}
	
	
	@Test
	void testEsEstadoDeparting() {
		EstadoBuque unEstado = unBuque.getEstadoBuque();
		
		assertEquals(unBuque.getEstadoBuque(), unEstado);
		 System.out.println(unBuque.getEstadoBuque());
		
	}
	
	@Test
    void testEsEstadoOutbound() {

        estado = mock(Outbound.class);

        unBuque.avanzar(5d);

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);


        posicionDeTerminal = unaTerminal.getPosicion();

        unBuque.getEstadoBuque().distanciaHasta(unViaje);;

        estado = unBuque.getEstadoBuque();

        //assertEquals(unBuque.getEstadoBuque(), estado);
        System.out.println(unBuque.getEstadoBuque());

    }
	
	

}


