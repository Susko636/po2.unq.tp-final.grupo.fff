package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.cliente.Shipper;

class TestCaseShippper {
	
	private Cliente shipper;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria terminalLlegada;
		
	
	@BeforeEach
	void setUp() {
		shipper = new Shipper("sho");
		unaTerminal = mock(TerminalGestionada.class);
		terminalLlegada = mock(TerminalPortuaria.class);
	}
	
	@Test
	void test() {
		
		shipper.contratarEmpresa(null);		
		shipper.ordenDeExportacion(unaTerminal, terminalLlegada);
		assertTrue(shipper.getOrdenesRealizadas().size() == 1);
	}

}
