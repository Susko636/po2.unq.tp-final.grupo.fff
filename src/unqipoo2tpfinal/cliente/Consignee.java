package unqipoo2tpfinal.cliente;

import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.orden.OrdenExportacion;

public class Consignee extends Cliente {
	
	public Consignee(String nombre) {
		super(nombre);
	}

	@Override
	public List<OrdenExportacion> getOrdenesRealizadas() {
		return null;
	}

	@Override
	public void ordenDeExportacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada) {
		// TODO Auto-generated method stub
		
	}

}
