package unqipoo2tpfinal.cliente;

import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenExportacion;
import unqipoo2tpfinal.servicio.Servicio;

public class Shipper extends Cliente {
	
	private Orden ordenDeExportacion;
	private List<OrdenExportacion> ordenesRealizadas;
	
	
	
	public Shipper(String nombre) {
		super(nombre);
		this.ordenesRealizadas = new ArrayList<OrdenExportacion>();
	}

	public Orden getOrdenDeExportacion() {
		return this.ordenDeExportacion;
	}

	public List<OrdenExportacion> getOrdenesRealizadas() {
		return this.ordenesRealizadas;
	}


	@Override
	public void ordenDeExporacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada) {
		unaTerminal.ordenDeExportacion(terminalLlegada,this);		
	}

	

}

