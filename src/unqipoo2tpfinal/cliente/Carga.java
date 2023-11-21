package unqipoo2tpfinal.cliente;

import unqipoo2tpfinal.container.Container;
import unqipoo2tpfinal.container.Dry;
import unqipoo2tpfinal.container.Reefer;
import unqipoo2tpfinal.container.Tank;

public enum Carga {
	
	GASES(new Tank(30d,40d,200d,80d)), LIQUIDOS (new Tank(30d,40d,200d,80d)), MEDICAMENTOS(new Reefer(30d,40d,200d,80d,300d)), ALIMENTOS(new Reefer(30d,40d,200d,80d,200d)), BASICO(new Dry(30d,40d,200d,80d));
	
	private Container container;
	
	Carga(Container container) {
		this.container = container;
	}

	public Container getContainer() {
		return this.container;
	}
	
}
