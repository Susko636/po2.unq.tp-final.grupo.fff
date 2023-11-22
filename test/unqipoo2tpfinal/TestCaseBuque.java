package unqipoo2tpfinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
		otraTerminal = mock(TerminalPortuaria.class);
		unBuque = new Buque(unViaje,100d);
	}


	@Test
	void testEsEstadoDeparting() {
		
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
		when(unaTerminal.getPosicion()).thenReturn(100d);
		
		unBuque.distanciaATerminalDeLlegada();
		
		System.out.println(unBuque.getEstadoBuque());

	}
	/*
	@Test
    void testEsEstadoOutbound() {

        unBuque.avanzar(5d);

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);

        unBuque.getEstadoBuque().distanciaHasta(unViaje);;

        System.out.println(unBuque.getEstadoBuque());

    }	

	@Test
    void testEsEstadoInbound() {

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.getEstadoBuque().distanciaHasta(unViaje);

        //assertEquals(unBuque.getEstadoBuque(), estado);
        System.out.println(unBuque.getEstadoBuque());
	}

	@Test
	void testEsEstadoArrived() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje);

		System.out.println(unBuque.getEstadoBuque());
	}

	@Test
    void testEsEstadoWorking() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado Arrived :P

		unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.empezarTrabajo();
		//unaTerminal.comenzarTrabajo(unBuque);

        System.out.println(unBuque.getEstadoBuque());

	}

	@Test
    void testEsEstadoDeWorkingADeparting() {
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getTerminalDeLlegada()).thenReturn(otraTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        when(otraTerminal.getPosicion()).thenReturn(300d);

        unBuque.avanzar(5d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje); //Pasa a estado OutBound :)

        unBuque.avanzar(155d);
        unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado InBound ;)

        unBuque.avanzar(40d);
		unBuque.getEstadoBuque().distanciaHasta(unViaje);   // Pasa a estado Arrived :P

		unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.empezarTrabajo();							// Pasa a estado Working :D
		//unaTerminal.comenzarTrabajo(unBuque);

		unBuque.getEstadoBuque().distanciaHasta(unViaje);
		unBuque.terminarTrabajo();
		//unaTerminal.depart(unBuque)						//Termina en estado Departing :*

        System.out.println(unBuque.getEstadoBuque());

    }
	*/
}
