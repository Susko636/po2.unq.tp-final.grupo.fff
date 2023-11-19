package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseCircuito {

	private CircuitoMaritimo unCircuito;
	private Tramo unTramo;
	private Tramo otroTramo;
	private List<Tramo> tramosEsperados;
	private TerminalPortuaria terminal;
	private TerminalPortuaria terminal1;
	
	
	@BeforeEach
	public void setUp() {
		
		terminal = mock(TerminalPortuaria.class);
		terminal1 = mock(TerminalPortuaria.class);
		unTramo = mock(Tramo.class);
		otroTramo = mock(Tramo.class);
		tramosEsperados = new ArrayList<Tramo>();	
		tramosEsperados.add(unTramo); 				//Agrego un tramo a la lista de tramosEsperados
		unCircuito = new CircuitoMaritimo(); 
		
	}
	
	@Test
	void testUnCircuitoTieneTramos() {
		
		unCircuito.agregarTramo(unTramo);
		
		assertEquals(unCircuito.getTramos(), tramosEsperados);
	}
	
	@Test
	void testUnCircuitoAgregaUnTramo() {
		
		when(unTramo.getTerminalDeLlegada()).thenReturn(terminal);
		when(otroTramo.getTerminalDeSalida()).thenReturn(terminal);
		
		tramosEsperados.add(otroTramo); 	//Agrego otro tramo a la lista de tramosEsperados
		unCircuito.agregarTramo(unTramo);
		unCircuito.agregarTramo(otroTramo);
		
		assertEquals(unCircuito.getTramos(),tramosEsperados);

	}
	
	/*
	@Test
	void testUnCircuitoNoPuedeAgregaUnTramoSiNoCoincidenLasTerminales() {
		
		String expectedMessage = "No coinciden las terminales";
	    String actualMessage = unCircuito.getMessage();
		
		when(unTramo.getTerminalDeLlegada()).thenReturn(terminal);
		when(otroTramo.getTerminalDeSalida()).thenReturn(terminal1);
		
		unCircuito.agregarTramo(unTramo);
		unCircuito.agregarTramo(otroTramo);
		
		assertTrue(actualMessage.contains(expectedMessage));

	} */
	
	
}
