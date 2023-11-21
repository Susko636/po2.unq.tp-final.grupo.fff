package unqipoo2tpfinal.cliente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenImportacion;

public class Consignee extends Cliente {
	
	private Orden ordenImportacion;
	private List<OrdenImportacion> ordenesRealizadas;
	private LocalDate fechaTurno;
	private LocalTime horaTurno;
	
	public Consignee(String nombre, Carga carga, BuscadorDeMejorCircuito criterioDeMejor) {
		super(nombre, carga, criterioDeMejor);
	}

	public List<OrdenImportacion> getOrdenRealizadas(){
		return this.ordenesRealizadas;
	}
	public void setOrdenesRealizadas(List<OrdenImportacion> ordenesRealizadas) {
		this.ordenesRealizadas = ordenesRealizadas;
	}

	public Orden getOrdenImportacion() {
		return this.ordenImportacion;
	}

	public LocalDate getFechaTurno() {
		return this.fechaTurno;
	}
	
	public void setFechaTurno(LocalDate fecha) {
		this.fechaTurno = fecha;
	}
	
	public void ordenDeImprotacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada) {
		unaTerminal.importar(terminalLlegada,this);
		
	}

	public LocalTime getHoraTurno() {
		return this.horaTurno;
	}

	public void setHoraTurno(LocalTime horaTurno) {
		this.horaTurno = horaTurno;
	}

	public void guardarOrdenImporacion(OrdenImportacion orden) {
		this.ordenesRealizadas.add(orden);
		this.notificarChoferYCamion(orden);
		
	}

	@Override
	public void pagar() {
		// TODO Auto-generated method stub
		
	}

	

	
	

}
