package unqipoo2tpfinal.orden;

import java.time.LocalDate;

import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.Viaje;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

public class OrdenExportacion extends Orden{

	private Chofer chofer;
	private Camion camion;
	private TerminalPortuaria terminalLlegada;
	private LocalDate fechaLlegada;
	private LocalDate fechaSalida;
	

	public OrdenExportacion(TerminalPortuaria terminalLlegada, LocalDate fechaLlegada, LocalDate fechaSalida, Viaje unViaje, Shipper unShipper) {		
		super(unViaje,unShipper);
		this.terminalLlegada = terminalLlegada;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
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
