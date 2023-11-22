package unqipoo2tpfinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

<<<<<<< HEAD
=======
import org.junit.After;
>>>>>>> 79812837d783381c17a51d5e29b0c12965e22284
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
	//******************* mockear estados.***********************

	@Test
	void testEsEstadoDeparting() {
<<<<<<< HEAD
		
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
=======
		when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
>>>>>>> 79812837d783381c17a51d5e29b0c12965e22284
		when(unaTerminal.getPosicion()).thenReturn(100d);
		
		unBuque.distanciaATerminalDeLlegada();
		
<<<<<<< HEAD
		System.out.println(unBuque.getEstadoBuque());
=======
		System.out.println(unBuque.getEstadoBuque() + " 1");
>>>>>>> 79812837d783381c17a51d5e29b0c12965e22284

	}
	/*
	@Test
    void testEsEstadoOutbound() {

        unBuque.avanzar(5d);

        when(unViaje.getTerminalDeSalida()).thenReturn(unaTerminal);
        when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
        when(unaTerminal.getPosicion()).thenReturn(100d);
        
        unBuque.distanciaATerminalDeLlegada();
        //unBuque.getEstadoBuque().distanciaHasta(unViaje);;

        System.out.println(unBuque.getEstadoBuque()+ " 2");

<<<<<<< HEAD
    }	
=======
    }
	@After
	void tearDown() {
		unBuque.avanzar(5d);
	}
>>>>>>> 79812837d783381c17a51d5e29b0c12965e22284

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
<<<<<<< HEAD
        System.out.println(unBuque.getEstadoBuque());
	}
=======
        System.out.println(unBuque.getEstadoBuque() + " 3");
}	


>>>>>>> 79812837d783381c17a51d5e29b0c12965e22284

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
	*/
}
