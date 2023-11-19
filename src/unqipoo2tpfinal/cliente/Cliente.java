package unqipoo2tpfinal.cliente;

import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.empresaTransportista.EmpresaTransportista;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenExportacion;

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

	public abstract List<OrdenExportacion> getOrdenesRealizadas();

	public void notificarChoferYCamion(Orden orden) {
		orden.setChofer(this.getChoferAsignado());
		orden.setCamion(this.getCamionAsignado());
	}
	
	public void pagar() {
		//HACER
	}


	public abstract void ordenDeExportacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada);

	public String getNombre() {
		return this.nombre;
	}
	
}
