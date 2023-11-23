package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.OrdenExportacion;

class TestCaseShippper {
	
	private Shipper shipper;
	private Camion camion;
	private Chofer chofer;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria terminalLlegada;
	private Carga carga;
	private BuscadorDeMejorCircuito criterio;
	private OrdenExportacion unaOrden;
	private LocalDate turno;
	private Viaje unViaje;
	
	@BeforeEach
	void setUp() {
		criterio = mock(BuscadorDeMejorCircuito.class);
		unaOrden = mock(OrdenExportacion.class);
		carga = Carga.BASICO;
		shipper = new Shipper("sho", carga, criterio);
		unaTerminal = mock(TerminalGestionada.class);
		terminalLlegada = mock(TerminalPortuaria.class);
		turno = LocalDate.now();
		unViaje = mock(Viaje.class);
	}
	
	@Test
	void TestUnShipperGuardaSuOrdenYNotificaChoferYCamion(){
		
		shipper.guardarOrden(unaOrden);
		
		verify(unaOrden).setCamion(camion);
		verify(unaOrden).setChofer(chofer);
		assertEquals(shipper.getOrdenDeExportacion(), unaOrden);
		assertTrue(shipper.getOrdenesRealizadas().contains(unaOrden));
	}
	
	
	@Test
	void testUnShipperPuedeRealizarUnaOrdenDeExportacion() {
		
		shipper.ordenDeExportacion(unaTerminal, terminalLlegada);
		verify(unaTerminal).exportar(terminalLlegada, shipper);
	}
	
	@Test
	void testTurnoActualYCargaActual() {
		
		shipper.setTurno(turno);
		
		assertEquals(shipper.getTurno(), turno);
		assertEquals(shipper.getCarga(), Carga.BASICO);
	}

	@Test
	void TestPagarUnaOrdenDeExportacion() {
		
		when(unaOrden.getViaje()).thenReturn(unViaje);
		when(unViaje.precio()).thenReturn(10d);
		
		shipper.guardarOrden(unaOrden);
		shipper.pagar();
		
		verify(unaOrden).getViaje();
		verify(unaOrden).calcularPrecioPorServicios();
	}

	
	@Test
	void testIngresarCarga() {
		when(unaOrden.getChofer()).thenReturn(chofer);
		when(unaOrden.getCamion()).thenReturn(camion);
		
		shipper.guardarOrden(unaOrden);
		
		shipper.ingresarCarga(unaTerminal);
		
		verify(unaTerminal).verificarSiEsChoferOCamionHabilitado(unaOrden);
	}
}
