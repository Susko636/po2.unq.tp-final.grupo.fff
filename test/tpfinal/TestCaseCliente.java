package tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class TestCaseCliente {
	
	private Cliente shipper; 
	private EmpresaTransportista empresa;
	
	@BeforeEach
	public void setUp() {
		shipper = new Shipper("cliente 1");
		empresa = mock(EmpresaTransportista.class);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
