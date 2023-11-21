package unqipoo2tpfinal.orden;



import java.time.LocalDate;
import java.time.LocalTime;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLlegada;
	private LocalTime horaLlegada;
	private Chofer chofer;
	private Camion camion;
	private TerminalGestionada terminalDestino;
	private Consignee duenio;

	public OrdenImportacion(TerminalGestionada terminalDestino, LocalDate fecha, LocalTime hora, Consignee consignee) {		
		this.terminalDestino = terminalDestino;
		this.fechaLlegada = fecha;
		this.horaLlegada = hora;
		this.duenio = consignee;
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


	public Consignee getDuenio() {
		return this.duenio;
	}
	
	

}
