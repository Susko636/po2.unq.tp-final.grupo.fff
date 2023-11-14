package unqipoo2tpfinal.cliente;

import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;

public abstract class Cliente {

	protected String nombre;
	protected Camion camionAsignado;
	protected Chofer choferAsignado;
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Camion getCamionAsignado() {
		return this.camionAsignado;
	}

	public void setCamionAsignado(Camion camionAsignado) {
		this.camionAsignado = camionAsignado;
	}

	public Chofer getChoferAsignado() {
		return this.choferAsignado;
	}

	public void setChoferAsignado(Chofer choferAsignado) {
		this.choferAsignado = choferAsignado;
	}

	public void contratarEmpresa(EmpresaTransportista empresa) {
		this.setChoferAsignado(empresa.asignarChofer());
		this.setCamionAsignado(empresa.asignarCamion());
	}
	
}