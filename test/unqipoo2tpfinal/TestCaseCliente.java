package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.Orden;

class TestCaseCliente {
	
	private Cliente shipper; 
	private Cliente consignee;
	private EmpresaTransportista empresa;
	private ArrayList<Chofer> choferes;
	private ArrayList<Camion> camiones;
	private Chofer chofer;
	private Camion camion;
	private Orden orden;
	private Carga carga;
	private BuscadorDeMejorCircuito criterio;
	
	@BeforeEach
	public void setUp() {
		
		criterio = mock(BuscadorDeMejorCircuito.class);
		shipper  = new Shipper("cliente 1", carga, criterio);
		consignee  = new Consignee("cliente 2", carga, criterio);
		choferes = new ArrayList<Chofer>();
		camiones = new ArrayList<Camion>();
		orden = mock(Orden.class);
		empresa  = mock(EmpresaTransportista.class);
		chofer   = mock(Chofer.class);
		camion   = mock(Camion.class);
		
		choferes.add(chofer);
		camiones.add(camion);
		
	}
	
	@Test
	void testCreacionDeShipper() {
		
		assertEquals(shipper.getNombre(), "cliente 1");
		
	}
	
	@Test
	void testCreacionDeConsignee() {
		assertEquals(consignee.getNombre(), "cliente 2");
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
		
		verify(empresa).asignarCamion();
		verify(empresa).asignarChofer();
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
		
		verify(empresa).asignarCamion();
		verify(empresa).asignarChofer();
	}

	@Test 
	void testUnClienteNotificaCamionYChofer() {
		
		when(empresa.getChoferes()).thenReturn(choferes);
		when(empresa.getCamiones()).thenReturn(camiones);
		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		
		when(orden.getCamion()).thenReturn(camion);
		when(orden.getChofer()).thenReturn(chofer);
		
		shipper.contratarEmpresa(empresa);
		shipper.notificarChoferYCamion(orden);
		
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getCamion(), camion);
		
	}
	
}
