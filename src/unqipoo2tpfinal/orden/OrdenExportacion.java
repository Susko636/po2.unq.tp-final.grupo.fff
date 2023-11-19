package unqipoo2tpfinal.orden;

import java.time.LocalDate;

import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.servicio.Servicio;

public class OrdenExportacion extends Orden{

	private Chofer chofer;
	private Camion camion;
	private TerminalPortuaria terminalLlegada;
	private LocalDate fechaLlegada;
	private LocalDate fechaSalida;

	public OrdenExportacion(TerminalPortuaria terminalLlegada, LocalDate fechaLlegada, LocalDate fechaSalida) {		
		this.terminalLlegada = terminalLlegada;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
	}
	
	public void contratarServicios(Servicio unServicio) {
		
	}

}
