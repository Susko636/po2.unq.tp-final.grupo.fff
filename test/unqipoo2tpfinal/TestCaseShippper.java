package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.OrdenExportacion;

class TestCaseShippper {
	
	private Shipper shipper;
	private TerminalGestionada unaTerminal;
	private TerminalPortuaria terminalLlegada;
	private Carga carga;
	private BuscadorDeMejorCircuito criterio;
		
	
	@BeforeEach
	void setUp() {
		criterio = mock(BuscadorDeMejorCircuito.class);
		carga = Carga.BASICO;
		shipper = new Shipper("sho", carga, criterio);
		unaTerminal = mock(TerminalGestionada.class);
		terminalLlegada = mock(TerminalPortuaria.class);
	}
	
	@Test
	void testUnShipperPuedeRealizarUnaOrdenDeExportacion() {
		
		shipper.ordenDeExportacion(unaTerminal, terminalLlegada);
		verify(unaTerminal).exportar(terminalLlegada, shipper);
		
	}

	

}
