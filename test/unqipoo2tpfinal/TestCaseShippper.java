package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;

class TestCaseShippper {
	
	private Cliente shipper;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria terminalLlegada;
	private EmpresaTransportista empresa;
		
	
	@BeforeEach
	void setUp() {
		shipper = new Shipper("sho");
		unaTerminal = mock(TerminalGestionada.class);
		terminalLlegada = mock(TerminalPortuaria.class);
		empresa = mock(EmpresaTransportista.class);
	}
	
	@Test
	void test() {
		
		shipper.contratarEmpresa(empresa);		
		shipper.ordenDeExportacion(unaTerminal, terminalLlegada);
		assertTrue(shipper.getOrdenesRealizadas().size() == 1);
	}

	

}
