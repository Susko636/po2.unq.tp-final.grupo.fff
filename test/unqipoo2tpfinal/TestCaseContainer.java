package unqipoo2tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unqipoo2tpfinal.container.Container;
import unqipoo2tpfinal.container.Dry;
import unqipoo2tpfinal.container.Reefer;
import unqipoo2tpfinal.container.Tank;

class TestCaseContainer {

	private Container containerSeco;
	private Container containerTanque;
	private Container containerRefrigerado;
	
	@BeforeEach
	public void setUp() {
		containerSeco = new Dry(40d, 200d, 500d, 1000d);
		containerTanque = new Tank(40d, 200d, 500d, 1000d);
		containerRefrigerado = new Reefer(40d, 200d, 500d, 1000d, 15.5d);
	}
	

	@Test
	public void testCreacionContainerDry() {
		assertEquals(containerSeco.getAncho(), 40d);
		assertEquals(containerSeco.getAltura(), 200d);
		assertEquals(containerSeco.getLargo(), 500d);
		assertEquals(containerSeco.getPesoTotal(), 1000d);
		assertEquals(containerSeco.getConsumo(), 0d);
	}
	
	@Test
	public void testCreacionContainerTank() {
		assertEquals(containerTanque.getAncho(), 40d);
		assertEquals(containerTanque.getAltura(), 200d);
		assertEquals(containerTanque.getLargo(), 500d);
		assertEquals(containerTanque.getPesoTotal(), 1000d);
		assertEquals(containerTanque.getConsumo(), 0d);
	}
	
	@Test
	public void testCreacionContainerReefer() {
		assertEquals(containerRefrigerado.getAncho(), 40d);
		assertEquals(containerRefrigerado.getAltura(), 200d);
		assertEquals(containerRefrigerado.getLargo(), 500d);
		assertEquals(containerRefrigerado.getPesoTotal(), 1000d);
		assertEquals(containerRefrigerado.getConsumo(), 15.5d);
	}

}
