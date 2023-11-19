package unqipoo2tpfinal;

import java.util.Date;

public class OrdenImportacion extends Orden{
	
	private Date fechaYHoraDeLlegada;
	
	
	
	public void registrarRetiro() {
		
	}



	public Date getFechaYHoraDeLlegada() {
		return this.fechaYHoraDeLlegada;
	}



	protected void setFechaYHoraDeLlegada(Date fechaYHoraDeLlegada) {
		this.fechaYHoraDeLlegada = fechaYHoraDeLlegada;
	}

}
