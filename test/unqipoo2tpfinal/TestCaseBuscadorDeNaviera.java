package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.naviera.BuscadorPorMenorPrecio;
import unqipoo2tpfinal.naviera.BuscadorPorMenorTiempo;
import unqipoo2tpfinal.naviera.BuscadorPorMenosTerminalesIntermedias;

class TestCaseBuscadorDeNaviera {
	
	private BuscadorDeMejorCircuito buscadorPorMenorPrecio;
	private BuscadorDeMejorCircuito buscadorPorMenorTiempo;
	private BuscadorDeMejorCircuito buscadorPorMenosTerminales;
	private List<CircuitoMaritimo> circuitos;
	private CircuitoMaritimo circuito1;
	private CircuitoMaritimo circuito2;
	private TerminalPortuaria terminal1;
	
	@BeforeEach
	void setUp() {
		buscadorPorMenorPrecio = new BuscadorPorMenorPrecio();
		buscadorPorMenorTiempo = new BuscadorPorMenorTiempo();
		buscadorPorMenosTerminales = new BuscadorPorMenosTerminalesIntermedias();
		circuitos = new ArrayList<CircuitoMaritimo>();
		terminal1 = mock(TerminalPortuaria.class);
		circuito1 = mock(CircuitoMaritimo.class);
		circuito2 = mock(CircuitoMaritimo.class);
		circuitos.add(circuito1); circuitos.add(circuito2);
	}

	@Test
	void testSeBuscaElCircuitoMasBarato() {
		
		when(circuito1.precioHasta(terminal1)).thenReturn(1500d);
		when(circuito2.precioHasta(terminal1)).thenReturn(2000d);
		
		
		assertEquals(buscadorPorMenorPrecio.elegirMejorCircuito(circuitos, terminal1), circuito1);
		
	}
	
	@Test
	void testSeBuscaElCircuitoMasRapido() {
		
		when(circuito1.tiempoHasta(terminal1)).thenReturn(10d);
		when(circuito2.tiempoHasta(terminal1)).thenReturn(20d);
		
		assertEquals(buscadorPorMenorTiempo.elegirMejorCircuito(circuitos, terminal1), circuito1);
		
	}
	
	@Test
	void testSeBuscaElCircuitoMasCorto() {
		
		when(circuito1.cantidadDeTerminalesIntermedias(terminal1)).thenReturn(6d);
		when(circuito2.cantidadDeTerminalesIntermedias(terminal1)).thenReturn(4d);
		
		assertEquals(buscadorPorMenosTerminales.elegirMejorCircuito(circuitos, terminal1), circuito2);
		
	}

}
