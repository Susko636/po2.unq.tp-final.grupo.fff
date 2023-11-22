package unqipoo2tpfinal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.naviera.Naviera;

class TestCaseNaviera {
	
	private Naviera naviera;
	private List<Buque> buques;
	private List<CircuitoMaritimo> circuitos;
	private Buque buque1;
	private Buque buque2;
	private Buque buque3;
	private CircuitoMaritimo circuito1;
	private CircuitoMaritimo circuito2;
	private List<Tramo> tramos1;
	private List<Tramo> tramos2;
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	private Tramo tramo4;
	private Tramo tramo5;
	private TerminalGestionada terminal;
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	private TerminalPortuaria terminal4;
	private TerminalPortuaria terminal5;
	private Viaje unViaje;
	private List<Viaje> viajesEsperados;
	private BuscadorDeMejorCircuito criterio;
	private LocalDate hoy;
	
	@BeforeEach
	void setUp() {
		buques = new ArrayList<Buque>();
		circuitos = new ArrayList<CircuitoMaritimo>();
		tramos1 = new ArrayList<Tramo>();
		tramos2 = new ArrayList<Tramo>();
		hoy = LocalDate.of(2023, 11, 21);
		viajesEsperados = new ArrayList<Viaje>();
		criterio = mock(BuscadorDeMejorCircuito.class);
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		tramo4 = mock(Tramo.class);
		tramo5 = mock(Tramo.class);
		terminal = mock(TerminalGestionada.class);
		terminal1 = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		terminal3 = mock(TerminalPortuaria.class);
		terminal4 = mock(TerminalPortuaria.class);
		terminal5 = mock(TerminalPortuaria.class);
		circuito1 = mock(CircuitoMaritimo.class);
		circuito2 = mock(CircuitoMaritimo.class);
		unViaje = mock(Viaje.class);
		viajesEsperados.add(unViaje);
		tramos1.add(tramo1); tramos1.add(tramo2); tramos1.add(tramo3);
		tramos2.add(tramo4); tramos2.add(tramo5);
		circuitos.add(circuito1); circuitos.add(circuito2);
		buques.add(buque1); buques.add(buque2); buques.add(buque3);
		naviera = new Naviera(buques, circuitos);
	}

	@Test
	void testCreacionDeNaviera() {
		
		assertEquals(naviera.getCircuitos(), circuitos);
		assertEquals(naviera.getBuques(), buques);		
		
	}
	
	@Test
	void testUnaNavieraAgregaViajesASuCronograma() {
		naviera.agregarViajeACronograma(unViaje);
		
		assertEquals(naviera.cronograma(), viajesEsperados);	
	}
	
	@Test 
	void testUnaNavieraPuedeAsignarUnBuqueParaUnViaje() {
		
		when(unViaje.getBuqueAsignado()).thenReturn(buque1);
		
		naviera.asignarBuque();
		
		assertEquals(unViaje.getBuqueAsignado(), buque1);
		
	}
	
	@Test 
	void testUnaNavieraTieneCriteriosDeBusquedaParaSusViajes() {
		
		naviera.asignarCriterioDeBusqueda(criterio);
		
		assertEquals(naviera.getBuscador(), criterio);
		
	}
	
	@Test 
	void testUnaNavieraSabeSiTieneUnViajeParaLaTerminal() {
		
		when(circuito1.existeAlgunTramoCon(terminal2)).thenReturn(true);
		
		assertFalse(naviera.tieneViajePara(terminal1));
		assertTrue(naviera.tieneViajePara(terminal2));
		
	}
	
	@Test 
	void testUnaNavieraSabeCualEsElMejorCircuitoParaDeterminadoViaje() {
		
		when(criterio.elegirMejorCircuito(circuitos,terminal1)).thenReturn(circuito1);
		
		naviera.asignarCriterioDeBusqueda(criterio);
		naviera.pedirMejorCircuitoHacia(terminal1);
		
		assertEquals(naviera.pedirMejorCircuitoHacia(terminal1), circuito1);
		
	}
	
	@Test 
	void testUnaNavieraPuedeCrearUnViajeHaciaUnaTerminal() {
		
		naviera.crearViajeA(terminal1, circuito1, terminal, hoy);
		
		assertEquals(naviera.cronograma().size(), 1);
		
	}
	
}
