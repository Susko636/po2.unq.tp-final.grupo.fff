package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.orden.OrdenImportacion;

class TestCaseOrdenImportacion {
	
	private OrdenImportacion orden;
	private TerminalGestionada terminalDestino;
	private Viaje unViaje;
	private LocalDate fecha;
	private LocalTime hora;
	private Consignee consignee;
	private Camion camion;
	private Chofer chofer;
	
	@BeforeEach
	void setUp() {
		unViaje = mock(Viaje.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		terminalDestino = mock(TerminalGestionada.class);
		consignee =mock(Consignee.class);
		fecha = LocalDate.now();
		hora= LocalTime.now();
		orden = new OrdenImportacion(unViaje, terminalDestino, fecha, hora, consignee);
	}
	
	@Test
	void TestCracionOrdenImportacion() {
		
		assertEquals(orden.getFechaLlegada(), fecha);
		assertEquals(orden.getHoraLlegada(), hora);
	}
	
	@Test
	void TestAgregarChoferCamionYTerminal() {
		
		orden.setCamion(camion);
		orden.setChofer(chofer);
		
		assertEquals(orden.getCamion(), camion);
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getTerminalDestino(), terminalDestino);
	}
	
	@Test
	void TestNoEsDeExportacion() {
		assertFalse(orden.esDeExportacion());
	}
	
	@Test
	void TestEsDeImportacion() {
		assertTrue(orden.esDeImportacion());
	}

}
