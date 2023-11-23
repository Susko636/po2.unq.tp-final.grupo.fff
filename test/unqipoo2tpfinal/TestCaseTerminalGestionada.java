package unqipoo2tpfinal;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.container.Conteiner;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.naviera.BuscadorPorMenorPrecio;
import unqipoo2tpfinal.naviera.Naviera;
import unqipoo2tpfinal.orden.OrdenExportacion;

class TestCaseTerminalGestionada {

	private String numeroDeTerminal;
	private TerminalGestionada unaTerminal;
	private List<CircuitoMaritimo> circuitos;
	private List<Buque> buques;
	private List<Conteiner> conteiners;
	private List<Naviera> navieras;
	private CircuitoMaritimo unCircuito;
	private Buque unBuque;
	private Conteiner unConteiner;
	private TerminalPortuaria otraTerminal;
	private Shipper unShipper;
	private Naviera unaNaviera;
	private Viaje unViaje;
	private Consignee unConsignee;
	private Chofer unChofer;
	private Camion unCamion;
	private Carga unaCarga;
	private BuscadorDeMejorCircuito buscadorMP;
	
	@BeforeEach
	public void setUp() {
		unChofer = mock(Chofer.class);
		unCamion = mock(Camion.class);
		unConsignee = mock(Consignee.class);
		mock(OrdenExportacion.class);
		unaCarga = Carga.ALIMENTOS;
		unViaje = mock(Viaje.class);
		buscadorMP = mock(BuscadorPorMenorPrecio.class);
		unaNaviera = mock(Naviera.class);
		unShipper = mock(Shipper.class);
		otraTerminal = mock(TerminalPortuaria.class);
		
		circuitos = new ArrayList<CircuitoMaritimo>();
		buques = new ArrayList<Buque>();
		conteiners = new ArrayList<Conteiner>();
		navieras = new ArrayList<Naviera>();
		
		unCircuito = mock(CircuitoMaritimo.class);
		unBuque = mock(Buque.class);
		unConteiner = mock(Conteiner.class);
		
		circuitos.add(unCircuito);
		buques.add(unBuque);
		conteiners.add(unConteiner);
		navieras.add(unaNaviera);
		
		unaTerminal = new TerminalGestionada("10", 200d, conteiners);
	}
	
	@Test
	void testPosicionDeLaTerminal() {
		assertEquals(unaTerminal.getPosicion(), 200d);
	}
	
	@Test
	void testNombreDeLaTerminal() {
		assertEquals(unaTerminal.getNombre(), "10");
	}
	
	@Test
	void testContainersDeLaTerminal() {
		assertEquals(unaTerminal.getContainers(), conteiners);
	}
	
	@Test
	void testUnBuqueComienzaTrabajo() {
		
		
		unaTerminal.comenzarTrabajo(unBuque);
		
		verify(unBuque).empezarTrabajo();
		
	}
	
	@Test
	void testExportar() {
		
		when(unShipper.getCamionAsignado()).thenReturn(unCamion);
		when(unShipper.getChoferAsignado()).thenReturn(unChofer);
		when(unShipper.getCriterioDeMejor()).thenReturn(buscadorMP);
		when(unaNaviera.tieneViajePara(otraTerminal)).thenReturn(true);
		when(unaNaviera.pedirMejorCircuitoHacia(otraTerminal)).thenReturn(unCircuito);
		when(unaNaviera.crearViajeA(otraTerminal, unCircuito, unaTerminal, LocalDate.now())).thenReturn(unViaje);
		when(unShipper.getCarga()).thenReturn(unaCarga);
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
		
		unaTerminal.contratarNaviera(unaNaviera);
		unaTerminal.exportar(otraTerminal, unShipper);
		
		
		verify(unaNaviera).asignarCriterioDeBusqueda(unShipper.getCriterioDeMejor());
		verify(unaNaviera).pedirMejorCircuitoHacia(otraTerminal);
		verify(unaNaviera).crearViajeA(otraTerminal, unCircuito, unaTerminal, LocalDate.now());
		assertEquals(unaTerminal.getOrdenes().size(),1);
		
		
		verify(unShipper).setTurno(LocalDate.now());
		verify(unShipper).guardarOrden(unaTerminal.getOrdenesDeExportacion().get(0));
		
		assertEquals(unaTerminal.getChoferesHabilitados().size(),1);
		assertEquals(unaTerminal.getCamionesHabilitados().size(),1);
		
		unaTerminal.informarSalidaDe(unBuque);
		
		verify(unShipper).recibirMensaje("Tu buque esta en viaje a destino");
		
		//assertTrue(unaTerminal.verificarSiEsChoferOCamionHabilitado(unaTerminal.getOrdenesDeExportacion().get(0)));
	}
	
	@Test
	void testImportar() {
		
		
		when(unConsignee.getCriterioDeMejor()).thenReturn(buscadorMP);
		when(unaNaviera.tieneViajePara(otraTerminal)).thenReturn(true);
		when(unaNaviera.pedirMejorCircuitoHacia(otraTerminal)).thenReturn(unCircuito);
		when(unaNaviera.crearViajeA(otraTerminal, unCircuito, unaTerminal, LocalDate.now())).thenReturn(unViaje);
		when(unConsignee.getCarga()).thenReturn(unaCarga);
		when(unViaje.getBuqueAsignado()).thenReturn(unBuque);
		
		unaTerminal.contratarNaviera(unaNaviera);
		unaTerminal.importar(otraTerminal, unConsignee);
	
		verify(unaNaviera).asignarCriterioDeBusqueda(unConsignee.getCriterioDeMejor());
		verify(unaNaviera).pedirMejorCircuitoHacia(otraTerminal);
		verify(unaNaviera).crearViajeA(otraTerminal, unCircuito, unaTerminal, LocalDate.now());
		verify(unConsignee).setFechaTurno(LocalDate.now());
		verify(unConsignee).setHoraTurno(LocalTime.MIDNIGHT);
		verify(unConsignee).guardarOrdenImportacion(unaTerminal.getOrdenesDeImportacion().get(0));
		
		assertEquals(unaTerminal.getOrdenes().size(),1);
		
		assertEquals(unaTerminal.getChoferesHabilitados().size(),1);
		assertEquals(unaTerminal.getCamionesHabilitados().size(),1);
		
		unaTerminal.informarCercanoArrivoDe(unBuque);
		
		verify(unConsignee).recibirMensaje("Tu buque esta cercano a arrivar");
		
		//testCamionYChoferNoEstanHabilitadosParaElIngreso    
		
		
		
		
		
	}
	 
	@Test
	void testUnaTerminalLeDiceAUnBuqueQueSeVaya() {
		
		unaTerminal.depart(unBuque);
		
		verify(unBuque).cambiarAOutbound();
	}
	
	
}

