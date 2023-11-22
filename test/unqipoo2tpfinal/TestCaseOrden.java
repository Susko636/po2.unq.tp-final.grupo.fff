package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.container.Conteiner;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.servicio.Servicio;

class TestCaseOrden {
	
	private Chofer choferAsignado;
	private Camion camionAsignado;
	private List<Servicio> servicios;	
	private Viaje viaje;
	private Cliente duenio;
	private Orden orden;
	private Servicio servicio;
	private Servicio servicio1;
	private Servicio servicio2;
	private Conteiner container;
	
	@BeforeEach
	void setUp() {
		viaje = mock(Viaje.class);
		duenio = mock(Consignee.class);
		choferAsignado = mock(Chofer.class);
		camionAsignado = mock(Camion.class);		
		servicio = mock(Servicio.class);
		servicio1 = mock(Servicio.class);
		servicio2 = mock(Servicio.class);
		container = mock(Conteiner.class);
		orden = new Orden(viaje, duenio);
		servicios = new ArrayList<Servicio>();
		servicios.add(servicio);
		servicios.add(servicio1);
		servicios.add(servicio2);
	}
	
	@Test
	void TestDeCreacion() {
		orden.setCamion(camionAsignado);
		orden.setChofer(choferAsignado);
		
		assertEquals(orden.getCamion(), camionAsignado);
		assertEquals(orden.getChofer(), choferAsignado);
		assertEquals(orden.getDuenio(), duenio);
		assertEquals(orden.getViaje(), viaje);		
	}
	
	@Test
	void TestAgregarServicios() {
		
		orden.registrarServicio(servicio); 
		orden.registrarServicio(servicio1); 
		orden.registrarServicio(servicio2);
		
		assertEquals(orden.getServicios(), servicios);
	}
	
	@Test
	void TestRealizarServiciosParaConteiner() {
		when(container.getConsumo()).thenReturn(10d);
		
		orden.serviciosPara(container);
		
		assertEquals(orden.getServicios().size(), 3);
		
	}
	
	@Test 
	void testCalcularCostoPorServicios() {

		when(servicio.precio()).thenReturn(20d);
		when(servicio1.precio()).thenReturn(30d);
		when(servicio2.precio()).thenReturn(800d);
		
		orden.registrarServicio(servicio);
		orden.registrarServicio(servicio1);
		orden.registrarServicio(servicio2);
		
		assertEquals(orden.calcularPrecioPorServicios(), 850d);	
	}
	
	@Test
	void testDeEnvioDeEmail() {
		orden.enviarMail("Prueba de envio", duenio);
		
		verify(duenio).recibirMensaje("Prueba de envio");
	}
	
}
