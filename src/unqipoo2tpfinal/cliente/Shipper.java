package unqipoo2tpfinal.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.OrdenExportacion;

public class Shipper extends Cliente {
	
	private OrdenExportacion ordenActual;
	private List<OrdenExportacion> ordenesRealizadas;
	private LocalDate turno;
	
	
	
	public Shipper(String nombre, Carga carga, BuscadorDeMejorCircuito criterioDeMejor) {
		super(nombre,carga,criterioDeMejor);
		this.ordenesRealizadas = new ArrayList<OrdenExportacion>();
	}

	public OrdenExportacion getOrdenDeExportacion() {
		return this.ordenActual;
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
		this.setOrdenExportacion(unaOrden);
		this.notificarChoferYCamion(unaOrden);
	}


	private void setOrdenExportacion(OrdenExportacion unaOrden) {
		this.ordenActual = unaOrden;
		
	}

	public Carga getCarga() {
		return this.carga;
	}

	@Override
	public void pagar() {
		this.getOrdenDeExportacion().getViaje().precio(); 
		this.getOrdenDeExportacion().calcularPrecioPorServicios();
	}


	public void ingresarCarga(TerminalGestionada unaTerminal) {
		unaTerminal.verificarSiEsChoferOCamionHabilitado(this.ordenActual);
	}
}

