package unqipoo2tpfinal;

import java.util.ArrayList;

public class EmpresaTransportista {
	
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Camion> camiones = new ArrayList<Camion>();

	public ArrayList<Chofer> getChoferes() {
		return this.choferes;
	}
	
	public ArrayList<Camion> getCamiones() {
		return this.camiones;
	}

	public Chofer asignarChofer() {
		return this.getChoferes().get(0);
	}
	
	public Camion asignarCamion() {
		return this.getCamiones().get(0);
	}

}
