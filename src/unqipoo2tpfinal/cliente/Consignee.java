package unqipoo2tpfinal.cliente;

import java.util.List;

import unqipoo2tpfinal.OrdenExportacion;
import unqipoo2tpfinal.TerminalGestionada;

public class Consignee extends Cliente {
	
	public Consignee(String nombre) {
		super(nombre);
	}

	@Override
	public List<OrdenExportacion> getOrdenesRealizadas() {
		return null;
	}

	@Override
	public void ordenDeExporacion(TerminalGestionada unaTerminal,TerminalGestionada terminalSalida, TerminalGestionada terminalLlegada) {
		// TODO Auto-generated method stub
		
	}

}
