package unqipoo2tpfinal.empresaTransportista;

import java.util.ArrayList;

public class EmpresaTransportista {
	
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Camion> camiones = new ArrayList<Camion>();

	public EmpresaTransportista(ArrayList<Chofer> choferes, ArrayList<Camion> camiones) {
		super();
		this.choferes = choferes;
		this.camiones = camiones;
	}
	
	public ArrayList<Chofer> getChoferes() {
		return this.choferes;
	}
	

	public ArrayList<Camion> getCamiones() {
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
