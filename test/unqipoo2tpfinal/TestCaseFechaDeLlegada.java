package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.buscador.BuscadorComplejo;
import unqipoo2tpfinal.buscador.Busqueda;
import unqipoo2tpfinal.buscador.FechaDeLlegada;
import unqipoo2tpfinal.buscador.OperadorOR;

class TestCaseFechaDeLlegada {

	private FechaDeLlegada fecha;
	private List<Viaje> listaABuscar;
	private Viaje unViaje;

	@BeforeEach
	public void setUp() {
		unViaje = mock(Viaje.class);
		fecha = new FechaDeLlegada("2023-11-21");
		listaABuscar = new ArrayList<Viaje>();
		listaABuscar.add(unViaje);
	}
	
	@Test
	void testSeBuscaLaFechaDeLlegada() {
		
		when(unViaje.getFechaLlegada()).thenReturn(LocalDate.now());
		
		fecha.buscar(listaABuscar);
		assertEquals(fecha.buscar(listaABuscar).toString(),LocalDate.now().toString());
		//verify(unViaje).getTerminalDeLlegada();
	}

}
