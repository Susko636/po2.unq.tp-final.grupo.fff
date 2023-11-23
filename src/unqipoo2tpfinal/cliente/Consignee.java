package unqipoo2tpfinal.cliente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.TerminalGestionada;
import unqipoo2tpfinal.TerminalPortuaria;
import unqipoo2tpfinal.naviera.BuscadorDeMejorCircuito;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenImportacion;

public class Consignee extends Cliente {
	
	private Orden ordenActual;
	private List<OrdenImportacion> ordenesRealizadas;
	private LocalDate fechaTurno;
	private LocalTime horaTurno;
	
	public Consignee(String nombre, Carga carga, BuscadorDeMejorCircuito criterioDeMejor) {
		super(nombre, carga, criterioDeMejor);
		this.ordenesRealizadas = new ArrayList<OrdenImportacion>();
	}

	public List<OrdenImportacion> getOrdenRealizadas(){
		return this.ordenesRealizadas;
	}
	public void agregarOrden(OrdenImportacion orden) {
		this.ordenesRealizadas.add(orden);
	}

	public Orden getOrdenImportacion() {
		return this.ordenActual;
	}

	public LocalDate getFechaTurno() {
		return this.fechaTurno;
	}
	
	public void setFechaTurno(LocalDate fecha) {
		this.fechaTurno = fecha;
	}
	
	public void ordenDeImportacion(TerminalGestionada unaTerminal, TerminalPortuaria terminalLlegada) {
		unaTerminal.importar(terminalLlegada,this);
		
	}

	public LocalTime getHoraTurno() {
		return this.horaTurno;
	}

	public void setHoraTurno(LocalTime horaTurno) {
		this.horaTurno = horaTurno;
	}

	public void guardarOrdenImportacion(OrdenImportacion orden) {
		this.agregarOrden(orden);
		this.setOrdenImportacionActual(orden);
		this.notificarChoferYCamion(orden);
		
	}

	private void setOrdenImportacionActual(OrdenImportacion orden) {
		this.ordenActual = orden;
	}

	@Override
	public void pagar() {
		this.getOrdenImportacion().getViaje().precio();
		this.getOrdenImportacion().calcularPrecioPorServicios();
	}
	
	public void retirarCarga(TerminalGestionada unaTerminal) {
		unaTerminal.verificarSiEsChoferOCamionHabilitado(this.ordenActual);
	}
	

	
	

}
