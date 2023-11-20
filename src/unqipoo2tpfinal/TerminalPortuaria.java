package unqipoo2tpfinal;

import java.time.LocalDate;

public class TerminalPortuaria {
	
	private String nombreTerminal;
	private Double posicion;
	
	public TerminalPortuaria(String nombreDeTerminal, Double posicion) {
		
		this.nombreTerminal = nombreDeTerminal;
		this.posicion = posicion;
	}

	public Double getPosicion() {
		return posicion;
	}

	public void informarSalidaDe(Buque unBuque) {
		//Envia E-Mail a todos los Shippers cuyas órdenes de exportacion esten asociadas al viaje, diciendo que su carga salio de la terminal
	}

	public void informarCercanoArrivoDe(Buque unBuque) {
		//Envia E-Mail a todos los consignee que esten esperando este buque
	}

	public void recibirFechaDeLlegadaDeViaje(LocalDate fechaLlegada) {
		//informar a shipper o consignee la fecha de llegada de su carga.
	}

	public String getNombre() {
		return this.nombreTerminal;
	}
	
	
}
