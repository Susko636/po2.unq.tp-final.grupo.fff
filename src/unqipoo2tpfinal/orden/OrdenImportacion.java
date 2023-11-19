package unqipoo2tpfinal.orden;

import java.time.LocalDate;


import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLlegada;
	private Double horaLlegada;
	private Chofer chofer;
	private Camion camion;
	private TerminalGestionada terminalDestino;


	public OrdenImportacion(TerminalGestionada terminalDestino) {		
		this.terminalDestino = terminalDestino;
	}
	

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}
	
	protected void setFechaLlegada(LocalDate fecha) {
		this.fechaLlegada = fecha;
	}

	public Double getHoraLlegada() {
		return horaLlegada;
	}
	
	protected void setFechaLlegada(Double hr) {
		this.horaLlegada = hr;
	}

}
