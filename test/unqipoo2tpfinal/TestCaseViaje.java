package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseViaje {
	
	private Viaje viaje;
	private TerminalGestionada terminalDeSalida;
	private TerminalPortuaria terminalDeLlegadaViaje;
	private TerminalPortuaria terminalDeLlegadaTramo1;
	private TerminalPortuaria terminalDeLlegadaTramo2;
	private List<Tramo> tramos;
	private CircuitoMaritimo circuito;
	private Buque buque;
	private LocalDate fechaInicio = LocalDate.of(2023, 11, 30);
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	
	@BeforeEach
	public void setUp() {
		tramos = new ArrayList<Tramo>();
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		terminalDeSalida = mock(TerminalGestionada.class);
		terminalDeLlegadaViaje = mock(TerminalPortuaria.class);
		terminalDeLlegadaTramo1 = mock(TerminalPortuaria.class);
		terminalDeLlegadaTramo2 = mock(TerminalPortuaria.class);
		buque = mock(Buque.class);
		tramos.add(tramo1); tramos.add(tramo2); tramos.add(tramo3);
		circuito = mock(CircuitoMaritimo.class);
		viaje = new Viaje(buque, fechaInicio, terminalDeSalida, terminalDeLlegadaViaje, circuito);
	}
	
	@Test 
	public void testDeCreacionDeViaje() { 
		
		assertEquals(viaje.getBuqueAsignado(), buque);
		assertEquals(viaje.getTerminalDeSalida(), terminalDeSalida);
		assertEquals(viaje.getTerminalDeLlegada(), terminalDeLlegadaViaje);
		assertEquals(viaje.getCircuito(), circuito);
		assertEquals(viaje.getFechaSalida(), fechaInicio);
		
	}
	
	@Test 
	public void testUnViajeInformaDeSuLlegada() {
		
		viaje.informar();
		
		verify(terminalDeLlegadaViaje).recibirFechaDeLlegadaDeViaje(viaje.getFechaLlegada());
		
	}
	
	@Test
	public void testDeUnViajeSeSabeSuPrecio() {
		
		when(tramo1.precioPorTramo()).thenReturn(100d);
		when(tramo2.precioPorTramo()).thenReturn(150d);
		when(tramo3.precioPorTramo()).thenReturn(90d);
		
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaTramo1);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaTramo2);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaViaje);
		
		when(circuito.getTramos()).thenReturn(tramos);
		
		assertEquals(viaje.precio(), 340d);
		
	}
	
	@Test
	public void testUnViajeCalculaSuFechaDeLlegada() {
		
		when(tramo1.getTiempoDeRecorrido()).thenReturn(8d);
		when(tramo2.getTiempoDeRecorrido()).thenReturn(6d);
		when(tramo3.getTiempoDeRecorrido()).thenReturn(12d);
		when(tramo1.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaTramo1);
		when(tramo2.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaTramo2);
		when(tramo3.getTerminalDeLlegada()).thenReturn(terminalDeLlegadaViaje);
		
		when(circuito.getTramos()).thenReturn(tramos);
		
		viaje.setFechaDeLlegada();
		
		assertEquals(viaje.getFechaLlegada(), fechaInicio.plusDays(1));
		System.out.println(viaje.getFechaLlegada().toString());
	}
	
}
