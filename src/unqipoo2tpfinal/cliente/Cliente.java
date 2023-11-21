package unqipoo2tpfinal.cliente;


import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;
import unqipoo2tpfinal.orden.Orden;

public abstract class Cliente {

	protected String nombre;
	protected Camion camionAsignado;
	protected Chofer choferAsignado;
	protected Carga carga;
	
	public Cliente(String nombre, Carga carga) {
		super();
		this.nombre = nombre;
		this.carga = carga;
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


	public void notificarChoferYCamion(Orden orden) {
		orden.setChofer(this.getChoferAsignado());
		orden.setCamion(this.getCamionAsignado());
	}
	
	public abstract void pagar(); 
	
	
	
	public Carga getCarga() {
		return this.carga;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Chofer informarChofer() {
		return this.getChoferAsignado();
	}

	public Camion informarCamion() {
		return this.getCamionAsignado();
	}
}
