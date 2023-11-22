package unqipoo2tpfinal;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseCircuito {

	private CircuitoMaritimo unCircuito;
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	private Tramo tramo4;
	private List<Tramo> tramos;
	private TerminalPortuaria terminal;
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	private TerminalPortuaria terminal4;
	
	
	@BeforeEach
	public void setUp() {
		
		terminal = mock(TerminalPortuaria.class);
		terminal1 = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		terminal3 = mock(TerminalPortuaria.class);
		terminal4 = mock(TerminalPortuaria.class);
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		tramo4 = mock(Tramo.class);
		tramos = new ArrayList<Tramo>();	
		tramos.add(tramo1); 				//Agrego un tramo a la lista de tramosEsperados
		unCircuito = new CircuitoMaritimo(); 
		
	}
	//Falta probar la excepcion
	@Test
	void testUnCircuitoTieneTramos() {
		
		unCircuito.agregarTramo(tramo1);
		
		assertEquals(unCircuito.getTramos(), tramos);
	}
	
	@Test
	void testUnCircuitoAgregaUnTramo() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal);
		
		tramos.add(tramo2); 	//Agrego otro tramo a la lista de tramosEsperados
		unCircuito.agregarTramo(tramo1);
		unCircuito.agregarTramo(tramo2);
		
		assertEquals(unCircuito.getTramos(),tramos);

	}
	
	@Test
	void testUnCircuitoSabeElPrecioDeUnRecorridoHastaCiertaTerminal() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminal1);
		when(tramo3.getTerminalDeSalida()).thenReturn(terminal1);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminal2);
		when(tramo4.getTerminalDeSalida()).thenReturn(terminal2);
		when(tramo4.getTerminalDeLlegada()).thenReturn(terminal3);
		
		when(tramo1.precioPorTramo()).thenReturn(500d);
		when(tramo2.precioPorTramo()).thenReturn(1500d);
		when(tramo3.precioPorTramo()).thenReturn(700d);
		when(tramo4.precioPorTramo()).thenReturn(300d);
		
		tramos.add(tramo2); 	
		tramos.add(tramo3); 	
		tramos.add(tramo4); 	
		
		unCircuito.agregarTramo(tramo1);
		unCircuito.agregarTramo(tramo2);
		unCircuito.agregarTramo(tramo3);
		unCircuito.agregarTramo(tramo4);
		
		assertEquals(unCircuito.precioHasta(terminal2),2700d);

	}
	
	@Test
	void testUnCircuitoSabeElTiempoDeUnRecorridoHastaCiertaTerminal() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminal1);
		when(tramo3.getTerminalDeSalida()).thenReturn(terminal1);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminal2);
		when(tramo4.getTerminalDeSalida()).thenReturn(terminal2);
		when(tramo4.getTerminalDeLlegada()).thenReturn(terminal3);
		
		when(tramo1.getTiempoDeRecorrido()).thenReturn(10d);
		when(tramo2.getTiempoDeRecorrido()).thenReturn(5d);
		when(tramo3.getTiempoDeRecorrido()).thenReturn(6d);
		when(tramo4.getTiempoDeRecorrido()).thenReturn(12d);
		
		tramos.add(tramo2); 	
		tramos.add(tramo3); 	
		tramos.add(tramo4); 	
		
		unCircuito.agregarTramo(tramo1);
		unCircuito.agregarTramo(tramo2);
		unCircuito.agregarTramo(tramo3);
		unCircuito.agregarTramo(tramo4);
		
		assertEquals(unCircuito.tiempoHasta(terminal3),33d);

	}
	
	@Test
	void testUnCircuitoSabeLaCantidadDeTerminalesHastaCiertaTerminal() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminal1);
		when(tramo3.getTerminalDeSalida()).thenReturn(terminal1);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminal2);
		when(tramo4.getTerminalDeSalida()).thenReturn(terminal2);
		when(tramo4.getTerminalDeLlegada()).thenReturn(terminal3);
		
		tramos.add(tramo2); 	
		tramos.add(tramo3); 	
		tramos.add(tramo4); 	
		
		unCircuito.agregarTramo(tramo1);
		unCircuito.agregarTramo(tramo2);
		unCircuito.agregarTramo(tramo3);
		unCircuito.agregarTramo(tramo4);
		
		assertEquals(unCircuito.cantidadDeTerminalesIntermedias(terminal2),2d);

	}
	
	@Test
	void testUnCircuitoSabeTieneCiertaTerminalEnAlgunoDeSusTramos() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminal1);
		when(tramo3.getTerminalDeSalida()).thenReturn(terminal1);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminal2);
		when(tramo4.getTerminalDeSalida()).thenReturn(terminal2);
		when(tramo4.getTerminalDeLlegada()).thenReturn(terminal3);
		
		tramos.add(tramo2); 	
		tramos.add(tramo3); 	
		tramos.add(tramo4); 	
		
		unCircuito.agregarTramo(tramo1);
		unCircuito.agregarTramo(tramo2);
		unCircuito.agregarTramo(tramo3);
		unCircuito.agregarTramo(tramo4);
		
		assertTrue(unCircuito.existeAlgunTramoCon(terminal3));
		assertFalse(unCircuito.existeAlgunTramoCon(terminal4));

	}

	@Test
	void testNoSePuedeAgregarUnTramoAUnCircuitoNulo() {
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminal1);
		when(tramo2.getTerminalDeSalida()).thenReturn(terminal2);
		
		unCircuito.agregarTramo(tramo1);
		
		assertThrows( AssertionError.class, () -> unCircuito.agregarTramo(tramo2));
		
	}
	
	
}
