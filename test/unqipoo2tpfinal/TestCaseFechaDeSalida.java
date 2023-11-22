package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.buscador.FechaDeSalida;

class TestCaseFechaDeSalida {

	private FechaDeSalida buscadorFecha;
	private List<Viaje> listaABuscar;
	private List<Viaje> listaEsperada;
	private Viaje unViaje;
	private Viaje otroViaje;

	@BeforeEach
	public void setUp() {
		
		unViaje = mock(Viaje.class);
		otroViaje = mock(Viaje.class);
		
		buscadorFecha = new FechaDeSalida(LocalDate.now().toString());
		
		
		listaABuscar = new ArrayList<Viaje>();
		listaABuscar.add(unViaje);
		listaABuscar.add(otroViaje);
		
		
		listaEsperada = new ArrayList<Viaje>();
		listaEsperada.add(unViaje);
	}
	
	@Test
	void testSeBuscaLaFechaDeSalida() {
		
		when(unViaje.getFechaSalida()).thenReturn(LocalDate.now());
		when(otroViaje.getFechaSalida()).thenReturn(LocalDate.now().plusDays(1));
		
		buscadorFecha.buscar(listaABuscar);
		assertEquals((buscadorFecha.buscar(listaABuscar)),listaEsperada);
		
	}

}
