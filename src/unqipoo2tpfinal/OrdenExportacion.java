package unqipoo2tpfinal;

import java.time.LocalDate;

import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

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
		//hacer.
	}

	public Chofer getChofer() {
		return this.chofer;
	}

	public Camion getCamion() {
		return this.camion;
	}

	public TerminalPortuaria getTerminalLlegada() {
		return this.terminalLlegada;
	}

	public LocalDate getFechaLlegada() {
		return this.fechaLlegada;
	}

	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}

}
