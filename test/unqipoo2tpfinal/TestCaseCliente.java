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
	
	private Cliente cliente1; 
	private Cliente cliente2;
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
		
		carga = Carga.ALIMENTOS;
		criterio = mock(BuscadorDeMejorCircuito.class);
		cliente1  = new Shipper("cliente 1", carga, criterio);
		cliente2  = new Consignee("cliente 2", carga, criterio);
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
	void testCreacionDeCliente1() {
		
		assertEquals(cliente1.getCriterioDeMejor(), criterio);
		assertEquals(cliente1.getNombre(), "cliente 1");
		assertEquals(cliente1.getCarga(), Carga.ALIMENTOS);
		
	}
	
	
	@Test
	void testContratarEmpresaTransportista() {
		
		when(empresa.getChoferes()).thenReturn(choferes);
		when(empresa.getCamiones()).thenReturn(camiones);
		
		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		
		cliente1.contratarEmpresa(empresa);
		
		assertTrue(empresa.getChoferes().contains(cliente1.getChoferAsignado()));
		assertTrue(empresa.getCamiones().contains(cliente1.getCamionAsignado()));
		
		verify(empresa).asignarCamion();
		verify(empresa).asignarChofer();
	}
	
	@Test
	void testContratarEmpresaTransportistaConsignee() {
		
		when(empresa.getChoferes()).thenReturn(choferes);
		when(empresa.getCamiones()).thenReturn(camiones);
		
		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		
		cliente2.contratarEmpresa(empresa);
		
		assertTrue(empresa.getChoferes().contains(cliente2.getChoferAsignado()));
		assertTrue(empresa.getCamiones().contains(cliente2.getCamionAsignado()));
		
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
		
		cliente1.contratarEmpresa(empresa);
		cliente1.notificarChoferYCamion(orden);
		
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getCamion(), camion);
		
	}
	
	@Test
	void testComprobacionQueElChoferYElCamionSeanLosAsignados() {
		

		when(empresa.asignarChofer()).thenReturn(chofer);
		when(empresa.asignarCamion()).thenReturn(camion);
		
		cliente2.contratarEmpresa(empresa);
		
		assertEquals(cliente2.informarCamion(), camion);
		assertEquals(cliente2.informarChofer(), chofer);
	}
	
	@Test
	void TestUnClienteRecibeUnMensaje() {
		
		cliente2.recibirMensaje("Mensaje de Prueba");
		assertEquals(cliente2.getBuzon(), "Mensaje de Prueba");
	}
	
}
