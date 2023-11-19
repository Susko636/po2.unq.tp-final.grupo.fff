package unqipoo2tpfinal;

import java.time.LocalDate;

import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenExportacion;

public class TerminalGestionada {
	
	private int numeroDeTerminal;
	private Double posicion;

	public void ordenDeExportacion(TerminalPortuaria terminalLlegada, Shipper cliente) {
		this.crearViajeA(terminalLlegada);
		this.agregarOrden(
						new OrdenExportacion(terminalLlegada, this.viaje.getFechaLlegada(), this.viaje.getFechaSalida())
						);
		cliente.asignarTurno(this.viaje.getFechaLlegada(), this.viaje.getFechaSalida());
		
	}
	
	
	
	private void crearViajeA(TerminalPortuaria terminalLlegada) {
		this.viajes.add(new CircuitoMaritimo(terminalLlegada, this);	
	}



	public void agregarOrden(Orden unaOrden) {
		this.ordenesDeExportacion.add(unaOrden);
	}



	public void ordenDeImportacion(TerminalPortuaria terminalLlegada, Shipper shipper) {
		// TODO Auto-generated method stub
	}
	
	public void informarSalidaDe(Buque unBuque) {
		//Envia E-Mail a todos los Shippers cuyas órdenes de exportacion esten asociadas al viaje, diciendo que su carga salio de la terminal
	}
	public void informarCercanoArrivoDe(Buque unBuque) {
		//Envia E-Mail a todos los consignee que esten esperando este buque
	}
	
	public Double getPosicion() {
		return posicion;
	}

	public void comenzarTrabajo(Buque buque) {
		buque.empezarTrabajo();
	}

	public void depart(Buque unBuque) {
		unBuque.cambiarAOutbound();
	}
	

}

//mensaje directo exportar un tipo de container



//mejor viaje es el q tiene menos terminal intermedias.