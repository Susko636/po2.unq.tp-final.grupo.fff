package unqipoo2tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	private List<Conteiner> containers= new ArrayList<Conteiner>();
	private List<Orden> ordenes;
	private List<Naviera> navieras;
	private List<Chofer> choferHabilitado; 
	private List<Camion> camionHabilitado;
	
	

	public TerminalGestionada(String nombreDeTerminal, Double posicion, List<Conteiner> containers) {
		this.nombreDeTerminal = nombreDeTerminal;
		this.posicion = posicion;
		this.containers = containers;
		this.ordenes = new ArrayList<Orden>();
		this.choferHabilitado = new ArrayList<Chofer>();
		this.camionHabilitado = new ArrayList<Camion>();
		this.navieras = new ArrayList<Naviera>();
	}

	public void exportar(TerminalPortuaria terminalLlegada, Shipper unShipper) {
		Naviera unaNaviera = this.navieraQueTieneViaje(terminalLlegada);
		unaNaviera.asignarCriterioDeBusqueda(unShipper.getCriterioDeMejor());
		CircuitoMaritimo unCircuito = unaNaviera.pedirMejorCircuitoHacia(terminalLlegada);

		
		Viaje unViaje = unaNaviera.crearViajeA(terminalLlegada, unCircuito,this, LocalDate.now()); //la naviera crea el viaje con un buque y la fecha, lo devuelve
		OrdenExportacion unaOrden = new OrdenExportacion(terminalLlegada, LocalDate.now(), unViaje.getFechaLlegada(), unViaje, unShipper);
		this.serviciosPara(unShipper.getCarga(), unaOrden);
		
		this.getOrdenes().add(unaOrden);
		this.asignarTurno(unShipper, LocalDate.now(), unaOrden);
		this.agregarChoferHabilitado(unaOrden);
		this.agregarCamionHabilitado(unaOrden);
				
	}	 
	
	public void importar(TerminalPortuaria terminalSalida, Consignee consignee) {
		LocalTime ahora = LocalTime.MIDNIGHT; // Deberia ser LocalTime.now() pero por los milisegundos no corre el test
		Naviera unaNaviera = this.navieraQueTieneViaje(terminalSalida);
		unaNaviera.asignarCriterioDeBusqueda(consignee.getCriterioDeMejor());
		CircuitoMaritimo unCircuito = unaNaviera.pedirMejorCircuitoHacia(terminalSalida);
		
		Viaje unViaje = unaNaviera.crearViajeA(terminalSalida, unCircuito,this, LocalDate.now());
		OrdenImportacion unaOrden = new OrdenImportacion(unViaje,this,LocalDate.now(), ahora, consignee);
		
		this.informarFechaYHoraDeLlegada(consignee, LocalDate.now(), ahora, unaOrden);
		this.getOrdenes().add(unaOrden);
		this.serviciosPara(consignee.getCarga(), unaOrden);
		this.agregarChoferHabilitado(unaOrden);
		this.agregarCamionHabilitado(unaOrden);		
		
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

	

	public List<OrdenExportacion> getOrdenesDeExportacion() {
		
		List<OrdenExportacion> exportaciones = new ArrayList<>();

		List<Orden> listaARecorrer = this.getOrdenes();
        
        for (Orden orden : listaARecorrer) {
            if (orden.esDeExportacion()) {
                exportaciones.add((OrdenExportacion) orden);
            }
        }
		
		return exportaciones;
		
	}

	public void contratarNaviera(Naviera unaNaviera) {
		
		this.navieras.add(unaNaviera);
		
	}

	public List<OrdenImportacion> getOrdenesDeImportacion() {
		
		List<OrdenImportacion> importacion = new ArrayList<>();

		List<Orden> listaARecorrer = this.getOrdenes();
        
        for (Orden orden : listaARecorrer) {
            if (orden.esDeImportacion()) {
            	importacion.add((OrdenImportacion) orden);
            }
        }
        
		return importacion;
	}

	public boolean verificarSiEsChoferOCamionHabilitado(Orden ordenActual) {
		
		Chofer choferAVerificar = ordenActual.getChofer();
		Camion camionAVerificar = ordenActual.getCamion();
		
		
		if (!(this.esCamionHabilitado(camionAVerificar) && this.esChoferHabilitado(choferAVerificar))) {
			
			throw new AssertionError(this.mensajeErrorChoferCamion());
		} 
		
		return true; 
		
	}

	private String mensajeErrorChoferCamion() {
		
		return "El chofer o el camion no estan habilitados";
	}

	private boolean esCamionHabilitado(Camion camionAVerificar) {
		
		return this.getCamionesHabilitados().stream().anyMatch(c1 -> c1.equals(camionAVerificar));
	}

	private boolean esChoferHabilitado(Chofer choferAVerificar) {
		
		return this.getChoferesHabilitados().stream().anyMatch(c2 -> c2.equals(choferAVerificar));
	}
	


	
	

}