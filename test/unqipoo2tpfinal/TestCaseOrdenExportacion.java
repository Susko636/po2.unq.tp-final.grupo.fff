package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.orden.OrdenExportacion;

class TestCaseOrdenExportacion {

	private Chofer chofer;
	private Camion camion;
	private TerminalPortuaria terminalLlegada;
	private LocalDate fechaLlegada;
	private LocalDate fechaSalida;
	private Viaje viaje;
	private Shipper shipper;
	private OrdenExportacion orden;
	
	
	@BeforeEach
	void setUp() {
		terminalLlegada = mock(TerminalPortuaria.class);
		viaje = mock(Viaje.class);
		shipper = mock(Shipper.class);
		fechaLlegada = LocalDate.now();
		fechaSalida = LocalDate.now();
		orden = new OrdenExportacion(terminalLlegada, fechaLlegada, fechaSalida, viaje, shipper);
	}
	
	@Test
	void TestDeCreacion() {
		
		orden.setCamion(camion);
		orden.setChofer(chofer);
		
		assertEquals(orden.getCamion(), camion);
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getFechaLlegada(),fechaLlegada);
		assertEquals(orden.getFechaSalida(),fechaSalida);
		assertEquals(orden.getDuenio(),shipper);
		assertEquals(orden.getViaje(),viaje);
		assertEquals(orden.getTerminalLlegada(),terminalLlegada);
	}
}
