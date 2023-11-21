package unqipoo2tpfinal.orden;



import java.time.LocalDate;
import java.time.LocalTime;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.Viaje;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLlegada;
	private LocalTime horaLlegada;
	private Chofer chofer;
	private Camion camion;
	private TerminalGestionada terminalDestino;

	public OrdenImportacion(Viaje unViaje, TerminalGestionada terminalDestino, LocalDate fecha, LocalTime hora, Consignee consignee) {	
		super(unViaje,consignee);
		this.terminalDestino = terminalDestino;
		this.fechaLlegada = fecha;
		this.horaLlegada = hora;
	}
	

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}
	
	public Chofer getChofer() {
		return this.chofer;
	}
	
	public void setChofer(Chofer chofer) {
		this.chofer=chofer;
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
	public void setCamion(Camion camion) {
		this.camion=camion;
	}
	
	public TerminalGestionada getTerminalDestino() {
		return this.terminalDestino;
	}

	public LocalTime getHoraLlegada() {
		return this.horaLlegada;
	}


	

}
