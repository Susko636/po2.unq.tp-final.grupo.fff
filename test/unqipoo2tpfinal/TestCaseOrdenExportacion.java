package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

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
		fechaS
		orden = new OrdenExportacion()
	}
}
