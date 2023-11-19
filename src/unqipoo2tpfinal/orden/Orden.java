package unqipoo2tpfinal.orden;

import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.servicio.Servicio;

public class Orden {
	
	private Chofer choferAsignado;
	private Camion camionAsignado;
	private List<Servicio> servicios;	

	public void setChofer(Chofer chofer) {
		this.choferAsignado = chofer;
	}

	public void setCamion(Camion camion) {
		this.camionAsignado = camion;
	}
	
	public Camion getCamion() {
		return this.camionAsignado;
	}
	
	public Chofer getChofer() {
		return this.choferAsignado;
	}
	
}
