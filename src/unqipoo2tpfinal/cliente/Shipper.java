package unqipoo2tpfinal.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.orden.OrdenExportacion;

public class Shipper extends Cliente {
	
	private OrdenExportacion ordenDeExportacion;
	private List<OrdenExportacion> ordenesRealizadas;
	private LocalDate turno;
	
	
	
	public Shipper(String nombre, Carga carga) {
		super(nombre,carga);
		this.ordenesRealizadas = new ArrayList<OrdenExportacion>();
	}

	public OrdenExportacion getOrdenDeExportacion() {
		return this.ordenDeExportacion;
	}

	public List<OrdenExportacion> getOrdenesRealizadas() {
		return this.ordenesRealizadas;
	}

	
	public void ordenDeExportacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada) {
		unaTerminal.exportar(terminalLlegada,this);		
	}


	public LocalDate getTurno() {
		return this.turno;
	}

	public void setTurno(LocalDate turno) {
		this.turno = turno;
	}

	public void guardarOrden(OrdenExportacion unaOrden) {
		this.ordenesRealizadas.add(unaOrden);
		this.notificarChoferYCamion(unaOrden);
		
	}

	public Carga getCarga() {
		return this.carga;
	}

	@Override
	public void pagar() {
		this.getOrdenDeExportacion().getViaje().precio(); 
		this.getOrdenDeExportacion().calcularPrecioPorServicios();
	}


	


	

	

}

