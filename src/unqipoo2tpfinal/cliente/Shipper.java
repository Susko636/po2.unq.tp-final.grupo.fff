package unqipoo2tpfinal.cliente;

import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.Orden;
import unqipoo2tpfinal.OrdenExportacion;
import unqipoo2tpfinal.Servicio;
import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

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

	
	
	

	
>>>>>>> 1cabacac435757865345faee500ea7b933ee3b80
	
}

