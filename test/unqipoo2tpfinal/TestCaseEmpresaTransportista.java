package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;

class TestCaseEmpresaTransportista {
	
	private EmpresaTransportista empresaTransportista;
	private ArrayList<Chofer> choferes;
	private ArrayList<Camion> camiones;
	private Cliente consignee;
	private Chofer chofer;
	private Camion camion;
	
	@BeforeEach
	public void setUp() {
		choferes = new ArrayList<Chofer>();
		camiones = new ArrayList<Camion>();
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		consignee = mock(Consignee.class);
		choferes.add(chofer);
		camiones.add(camion);
		empresaTransportista = new EmpresaTransportista(choferes, camiones);
	}
	
	@Test
	public void testUnChoferEsAsignadoAUnaEmpresa() {
		assertEquals(empresaTransportista.asignarChofer(), chofer);
	}
	
	@Test
	public void testUnCamionEsAsignadoAUnaEmpresa() {
		assertEquals(empresaTransportista.asignarCamion(), camion);
	}
	
	@Test
	public void testCreacionDeEmpresaTransportista() {
		assertEquals(empresaTransportista.getChoferes(), choferes);
		assertEquals(empresaTransportista.getCamiones(), camiones);
		//System.out.println(empresaTransportista.getCamiones());
	}
	
	@Test
	public void testUnaEmpresaPuedeAsignarUnCamionAUnCliente() {
		when(consignee.getCamionAsignado()).thenReturn(camion);
		consignee.contratarEmpresa(empresaTransportista);
		assertEquals(consignee.getCamionAsignado(),camion);
	}
	
	@Test
	public void testUnaEmpresaPuedeAsignarUnChoferAUnCliente() {
		when(consignee.getChoferAsignado()).thenReturn(chofer);
		consignee.contratarEmpresa(empresaTransportista);
		assertEquals(consignee.getChoferAsignado(),chofer);
	}

}
