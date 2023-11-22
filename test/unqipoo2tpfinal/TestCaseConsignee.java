package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.naviera.BuscadorPorMenorPrecio;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenImportacion;

class TestCaseConsignee {

	private OrdenImportacion orden;
	private List<OrdenImportacion> ordenesRealizadas;
	private LocalDate fechaTurno;
	private LocalTime horaTurno;
	private Consignee consignee;
	private Carga carga;
	private BuscadorDeMejorCircuito criterio;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria terminalLlegada;
	private Viaje viaje;
	
	@BeforeEach
	void setUp() {
		carga= Carga.LIQUIDOS;
		fechaTurno = LocalDate.now();
		horaTurno= LocalTime.now();
		ordenesRealizadas = new ArrayList<OrdenImportacion>();
		ordenesRealizadas.add(orden);
		viaje = mock(Viaje.class);
		unaTerminal = mock(TerminalGestionada.class);
		terminalLlegada = mock(TerminalPortuaria.class);
		orden = mock(OrdenImportacion.class);
		criterio = new BuscadorPorMenorPrecio();
		consignee = new Consignee ("FacuPuto", carga, criterio);
	}
	
	@Test
	void testConsigneeRealizaUnaOrdenDeImportacion() {
		
		consignee.ordenDeImportacion(unaTerminal, terminalLlegada);
		consignee.guardarOrdenImportacion(orden);
		
		verify(unaTerminal).importar(terminalLlegada, consignee);
		assertEquals(consignee.getOrdenImportacion(), orden);
		assertTrue(consignee.getOrdenRealizadas().contains(orden));
	}
	
	@Test
	void testTieneUnTurnoAsignado() {
		consignee.setFechaTurno(fechaTurno);
		consignee.setHoraTurno(horaTurno);
		
		assertEquals(consignee.getFechaTurno(), fechaTurno);
		assertEquals(consignee.getHoraTurno(), horaTurno);
	}
	
	
	@Test
	void testConsigneePagaUnaOrden() {
		when(orden.getViaje()).thenReturn(viaje);
		when(viaje.precio()).thenReturn(20d);
		
		
		consignee.ordenDeImportacion(unaTerminal, terminalLlegada);
		consignee.guardarOrdenImportacion(orden);
		
		consignee.pagar();
		
		verify(orden).getViaje();
		verify(orden).calcularPrecioPorServicios();
		
	}
	

	
	
}


