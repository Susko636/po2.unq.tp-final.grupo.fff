package unqipoo2tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.buscador.Busqueda;
import unqipoo2tpfinal.cliente.Carga;
import unqipoo2tpfinal.cliente.Consignee;
import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.container.Conteiner;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.naviera.Naviera;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenExportacion;
import unqipoo2tpfinal.orden.OrdenImportacion;

public class TerminalGestionada {
	
	private String nombreDeTerminal;
	private Double posicion;
	//private List<CircuitoMaritimo> circuitos = new ArrayList<CircuitoMaritimo>();
	private List<Buque> buques = new ArrayList<Buque>();
	private List<Conteiner> containers= new ArrayList<Conteiner>();
	private List<Orden> ordenes;
	private List<Naviera> navieras;
	private List<Chofer> choferHabilitado;
	private List<Camion> camionHabilitado;
	private Busqueda buscador;
	
	

	public TerminalGestionada(String numeroDeTerminal, Double posicion, List<CircuitoMaritimo> circuitos, List<Buque> buques, List<Conteiner> containers) {
		this.nombreDeTerminal = numeroDeTerminal;
		this.posicion = posicion;
		//this.circuitos = circuitos;
		this.buques = buques;
		this.containers = containers;
		this.ordenes = new ArrayList<Orden>();
		this.choferHabilitado = new ArrayList<Chofer>();
		this.camionHabilitado = new ArrayList<Camion>();
	}

	public void exportar(TerminalPortuaria terminalLlegada, Shipper unShipper) {
		Naviera unaNaviera = this.navieraQueTieneViaje(terminalLlegada);
		unaNaviera.asignarCriterioDeBusqueda(unShipper.getCriterioDeMejor());
		CircuitoMaritimo unCircuito = unaNaviera.pedirMejorCircuitoHacia(terminalLlegada);
		//this.agregarCircuito(unCircuito);
		
		Viaje unViaje = unaNaviera.crearViajeA(terminalLlegada, unCircuito,this, LocalDate.now()); //la naviera crea el viaje con un buque y la fecha, lo devuelve
		OrdenExportacion unaOrden = new OrdenExportacion(terminalLlegada, LocalDate.now(), unViaje.getFechaLlegada(), unViaje, unShipper);
		this.serviciosPara(unShipper.getCarga(), unaOrden);
		
		this.getOrdenes().add(unaOrden);
		this.asignarTurno(unShipper, LocalDate.now(), unaOrden);
		this.agregarChoferHabilitado(unaOrden);
		this.agregarCamionHabilitado(unaOrden);
				
	}	
	
	public void importar(TerminalPortuaria terminalSalida, Consignee consignee) {
		Naviera unaNaviera = this.navieraQueTieneViaje(terminalSalida);
		unaNaviera.asignarCriterioDeBusqueda(consignee.getCriterioDeMejor());
		CircuitoMaritimo unCircuito = unaNaviera.pedirMejorCircuitoHacia(terminalSalida);
		//this.agregarCircuito(unCircuito);
		
		Viaje unViaje = unaNaviera.crearViajeA(terminalSalida, unCircuito,this, LocalDate.now());
		OrdenImportacion unaOrden = new OrdenImportacion(unViaje,this,LocalDate.now(), LocalTime.now(), consignee);
		
		this.informarFechaYHoraDeLlegada(consignee, LocalDate.now(), LocalTime.now(), unaOrden);
		this.getOrdenes().add(unaOrden);
		this.serviciosPara(consignee.getCarga(), unaOrden);
		this.agregarChoferHabilitado(unaOrden);
		this.agregarCamionHabilitado(unaOrden);		
		
		//revisar posible template en orden.
	}
	
	private void serviciosPara(Carga carga, Orden unaOrden) {
		this.aplicarServicios(carga.getContainer(), unaOrden);
	}
	
	private void aplicarServicios(Conteiner container, Orden unaOrden) {
		unaOrden.serviciosPara(container);
	}

	public void informarFechaYHoraDeLlegada(Consignee consignee, LocalDate fecha, LocalTime hora, OrdenImportacion orden) {
		consignee.setFechaTurno(fecha);
		consignee.setHoraTurno(hora);
		consignee.guardarOrdenImportacion(orden);
	}

	public void agregarCamionHabilitado(Orden unaOrden) {
		this.getCamionesHabilitados().add(unaOrden.getCamion());
	}
	
	public void agregarChoferHabilitado(Orden unaOrden) {
		this.getChoferesHabilitados().add(unaOrden.getChofer());
	}
	
	
	public Naviera navieraQueTieneViaje(TerminalPortuaria terminalLlegada) {
		return getNavieras().stream().filter(n->n.tieneViajePara(terminalLlegada)).toList().get(0);
	}

	/*public void agregarCircuito(CircuitoMaritimo unCircuito) {
		this.getCircuitos().add(unCircuito);
		
	}*/

	public void asignarTurno(Shipper unShipper, LocalDate turno, OrdenExportacion unaOrden) {
		unShipper.setTurno(turno);
		unShipper.guardarOrden(unaOrden);
	}

	public List<Orden> getOrdenes() {
		
		return this.ordenes;
	}

	public List<Naviera> getNavieras() {
		return this.navieras;
	}

	public Buque asignarBuque() {
		Buque unBuqueABorrar= this.getBuques().get(0);
		this.getBuques().remove(unBuqueABorrar);
		return unBuqueABorrar;
	}


	public List<Buque> getBuques() {
		return this.buques;
	}


	/*public List<CircuitoMaritimo> getCircuitos() {
		return this.circuitos;
	}*/


	public String getNombre() {
		return this.nombreDeTerminal;
	}
	
	public List<Chofer> getChoferesHabilitados(){
		return this.choferHabilitado;
	}
	
	public List<Camion> getCamionesHabilitados(){
		return this.camionHabilitado;
	}

	
	public void informarSalidaDe(Buque unBuque) {
		//precond siempre existe un buque asignado.
		List<Orden> ordenes = this.getOrdenes().stream().filter(o-> o.getViaje().getBuqueAsignado().equals(unBuque)).toList();
		ordenes.stream().forEach(o->o.enviarMail("Tu buque esta en viaje a destino", o.getDuenio()));

	}
	public void informarCercanoArrivoDe(Buque unBuque) {
		List<Orden> ordenes = this.getOrdenes().stream().filter(o-> o.getViaje().getBuqueAsignado().equals(unBuque)).toList();
		ordenes.stream().forEach(o->o.enviarMail("Tu buque esta cercano a arrivar", o.getDuenio()));
	}
	
	public Double getPosicion() {
		return this.posicion;
	}

	public void comenzarTrabajo(Buque buque) {
		buque.empezarTrabajo();
	}

	public void depart(Buque unBuque) {
		unBuque.cambiarAOutbound();
	}

	public List<Conteiner> getContainers() {
		return this.containers;
	}

	public Busqueda getBuscador() {
		return this.buscador;
	}

	

	



	
	

}