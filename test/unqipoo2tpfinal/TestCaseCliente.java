package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.Cliente;

class TestCaseCliente {
	
	private Cliente shipper; 
	private Cliente consignee;
	private EmpresaTransportista empresa;
	private ArrayList<Chofer> choferes;
	private ArrayList<Camion> camiones;
	private Chofer chofer;
	private Camion camion;
	
	@BeforeEach
	public void setUp() {
		shipper  = new Shipper("cliente 1");
		consignee  = new Consignee("cliente 2");
		empresa  = mock(EmpresaTransportista.class);
		chofer   = mock(Chofer.class);
		camion   = mock(Camion.class);
		choferes = new ArrayList<Chofer>();
		camiones = new ArrayList<Camion>();
		choferes.add(chofer);
		camiones.add(camion);
	}
	
	@Test
	void testContratarEmpresaTransportista() {
		when(empresa.getChoferes()).thenReturn(choferes);
		when(empresa.getCamiones()).thenReturn(camiones);
		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		shipper.contratarEmpresa(empresa);
		assertTrue(empresa.getChoferes().contains(shipper.getChoferAsignado()));
		assertTrue(empresa.getCamiones().contains(shipper.getCamionAsignado()));
		
		verify(empresa).getCamiones();
		verify(empresa).getChoferes();
	}
	
	@Test
	void testContratarEmpresaTransportistaConsignee() {
		when(empresa.getChoferes()).thenReturn(choferes);
		when(empresa.getCamiones()).thenReturn(camiones);
		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		consignee.contratarEmpresa(empresa);
		assertTrue(empresa.getChoferes().contains(consignee.getChoferAsignado()));
		assertTrue(empresa.getCamiones().contains(consignee.getCamionAsignado()));
		
		verify(empresa).getCamiones();
		verify(empresa).getChoferes();
	}
}
