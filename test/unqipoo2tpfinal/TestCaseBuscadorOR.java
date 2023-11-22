package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.buscador.BuscadorComplejo;
import unqipoo2tpfinal.buscador.Busqueda;
import unqipoo2tpfinal.buscador.OperadorOR;

class TestCaseBuscadorOR {

	private Busqueda busqueda1;
	private Busqueda busqueda2;
	private BuscadorComplejo buscadorOR;
	private List<Viaje> listaABuscar;
	private Viaje unViaje;

	@BeforeEach
	public void setUp() {
		busqueda1 = mock(Busqueda.class);
		busqueda2 = mock(Busqueda.class);
		unViaje = mock(Viaje.class);
		buscadorOR = new OperadorOR(busqueda1,busqueda2);
		listaABuscar = new ArrayList<Viaje>();
		listaABuscar.add(unViaje);
	}
	
	@Test
	void testBuscarOR() {
		when(busqueda1.buscar(listaABuscar)).thenReturn(listaABuscar);
		when(busqueda2.buscar(listaABuscar)).thenReturn(listaABuscar);
		assertEquals(buscadorOR.buscar(listaABuscar),listaABuscar);
	}

}
