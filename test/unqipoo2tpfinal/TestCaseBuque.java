package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseBuque {
	private Buque unBuque;
	private Viaje unViaje;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria otraTerminal;

	@BeforeEach
	public void setUp() {
		unViaje = mock(Viaje.class);
		unaTerminal = mock(TerminalGestionada.class);
		unBuque = new Buque(unViaje,100d);
		otraTerminal = mock(TerminalPortuaria.class);
	}
	//******************* mockear estados.***********************

	@Test
	void testEsEstadoDeparting() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
		when(unaTerminal.getPosicion()).thenReturn(100d);
		
		unBuque.distanciaATerminalDeLlegada();
		
		System.out.println(unBuque.getEstadoBuque() + " 1");

	}

	@Test
    void testEsEstadoOutbound() {

        unBuque.avanzar(5d);

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        
        unBuque.distanciaATerminalDeLlegada();
        //unBuque.getEstadoBuque().distanciaHasta(unViaje);;

        System.out.println(unBuque.getEstadoBuque()+ " 2");

    }
	@After
	void tearDown() {
		unBuque.avanzar(5d);
	}

	@Test
    void testEsEstadoInbound() {

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
        unBuque.distanciaATerminalDeLlegada();
        //unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.distanciaATerminalDeLlegada();
        //unBuque.getEstadoBuque().distanciaHasta(unViaje);

        //assertEquals(unBuque.getEstadoBuque(), estado);
        System.out.println(unBuque.getEstadoBuque() + " 3");
}	



	@Test
	void testEsEstadoArrived() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.distanciaATerminalDeLlegada(); 
// unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
        unBuque.distanciaATerminalDeLlegada();	
//unBuque.getEstadoBuque().distanciaHasta(unViaje);

		System.out.println(unBuque.getEstadoBuque() + " 4");
	}

	@Test
    void testEsEstadoWorking() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.distanciaATerminalDeLlegada();
// unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado Arrived :P

		//unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.distanciaATerminalDeLlegada();
		unBuque.empezarTrabajo();
		//unaTerminal.comenzarTrabajo(unBuque);

        System.out.println(unBuque.getEstadoBuque()+ " 5");

    }


	@Test
    void testEsEstadoDeWorkingADeparting() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
        unBuque.distanciaATerminalDeLlegada();
//unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado Arrived :P

		//unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.distanciaATerminalDeLlegada();
		unBuque.empezarTrabajo();							// Pasa a estado Working :D
		//unaTerminal.comenzarTrabajo(unBuque);

		//unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.distanciaATerminalDeLlegada();
		unBuque.terminarTrabajo();
		//unaTerminal.depart(unBuque)						//Termina en estado Departing :*

       System.out.println(unBuque.getEstadoBuque()+  " 6");

    }

}
