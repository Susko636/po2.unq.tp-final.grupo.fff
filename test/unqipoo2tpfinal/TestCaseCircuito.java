package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseCircuito {

	private CircuitoMaritimo unCircuito;
	private ArrayList<Tramo> tramos = new ArrayList<Tramo>();
	private Tramo unTramo;
	private ArrayList<Tramo> tramosAgregados = tramos;
	
	
	@BeforeEach
	public void setUp() {
		unTramo = mock(Tramo.class);
		tramos.add(unTramo);
		unCircuito = new CircuitoMaritimo(tramos); //Creo un circuito con una lista de 1 tramo
		tramosAgregados.add(unTramo);	//Agrego otro tramo a la lista de 1 tramo con la que cree el circuito
	}
	
	@Test
	void testUnCircuitoTieneTramos() {
		
		ArrayList<Tramo> tramosEsperados = unCircuito.getTramos();
		
		assertEquals(tramosEsperados, tramos);
	}
	
	@Test
	void testUnCircuitoAgregaUnTramo() {
		
		unCircuito.agregarTramo(unTramo);
		
		ArrayList<Tramo> tramosEsperados = unCircuito.getTramos();
		
		assertEquals(this.tramosAgregados,tramosEsperados );

	}
	

}
