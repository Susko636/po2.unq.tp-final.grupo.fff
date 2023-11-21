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

	

	public void recibirFechaDeLlegadaDeViaje(LocalDate fechaLlegada) {
		//informar a shipper o consignee la fecha de llegada de su carga.
	}

	public String getNombre() {
		return this.nombreTerminal;
	}
	
	
}
