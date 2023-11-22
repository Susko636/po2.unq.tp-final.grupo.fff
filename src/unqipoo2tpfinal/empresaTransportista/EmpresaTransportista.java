package unqipoo2tpfinal.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
	
	private List<Chofer> choferes = new ArrayList<Chofer>();
	private List<Camion> camiones = new ArrayList<Camion>();

	public EmpresaTransportista(List<Chofer> choferes, List<Camion> camiones) {
		super();
		this.choferes = choferes;
		this.camiones = camiones;
	}
	
	public List<Chofer> getChoferes() {
		return this.choferes;
	}
	

	public List<Camion> getCamiones() {
		return this.camiones;
	}

	public Chofer asignarChofer() {
		Chofer choferABorrar = getChoferes().get(0);
		this.getChoferes().remove(choferABorrar);
		return choferABorrar;
	}
	
	public Camion asignarCamion() {
		Camion camionABorrar = getCamiones().get(0);
		this.getCamiones().remove(camionABorrar);
		return camionABorrar;
	}

}
