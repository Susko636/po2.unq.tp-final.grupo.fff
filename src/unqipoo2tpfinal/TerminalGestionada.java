package unqipoo2tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.cliente.Shipper;
import unqipoo2tpfinal.container.Container;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.orden.Orden;
import unqipoo2tpfinal.orden.OrdenExportacion;

public class TerminalGestionada {
	
	private int numeroDeTerminal;
	private Double posicion;
	private List<CircuitoMaritimo> circuitos = new ArrayList<CircuitoMaritimo>();
	private List<Buque> buques = new ArrayList<Buque>();
	private List<Container> containers= new ArrayList<Container>();
	private List<Orden> ordenes;
	private List<Naviera> navieras;

	

	public TerminalGestionada(int numeroDeTerminal, Double posicion, List<CircuitoMaritimo> circuitos, List<Buque> buques, List<Container> containers) {
		this.numeroDeTerminal = numeroDeTerminal;
		this.posicion = posicion;
		this.circuitos = circuitos;
		this.buques = buques;
		this.containers = containers;
		this.ordenes = new ArrayList<Orden>();
	}

	public void exportar(TerminalPortuaria terminalLlegada) {
		for (Naviera naviera : this.navieras){
			circuitos.addAll(naviera.pedirCircuitoHacia(terminalLlegada,this));
		}
		CircuitoMaritimo unCircuito = this.elegirCircuito(terminalLlegada);
		/*naviera*/.crearViajeA(terminalLlegada, unCircuito); //la naviera crea el viaje con un buque y la fecha, lo devuelve
		//armar orden con el viaje entero aca.
		
	}	
	
	public Viaje crearViajeA(TerminalPortuaria terminalLlegada) {
		return new Viaje(this.asignarBuque(), LocalDate.now(),this, terminalLlegada,  this.elegirCircuito(terminalLlegada));
	}
	
	public CircuitoMaritimo elegirCircuito(TerminalPortuaria terminalLlegada) {
		return this.getCircuitos().stream().min((CircuitoMaritimo c1, CircuitoMaritimo c2) ->
				c1.cantidadDeTerminalesIntermedias(terminalLlegada).compareTo(c2.cantidadDeTerminalesIntermedias(terminalLlegada))).get();
	}

	public Buque asignarBuque() {
		Buque unBuqueABorrar= this.getBuques().get(0);
		this.getBuques().remove(unBuqueABorrar);
		return unBuqueABorrar;
	}


	public List<Buque> getBuques() {
		return this.buques;
	}



	public List<CircuitoMaritimo> getCircuitos() {
		return this.circuitos;
	}


	public int getNumeroDeTerminal() {
		return this.numeroDeTerminal;
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
		return this.posicion;
	}

	public void comenzarTrabajo(Buque buque) {
		buque.empezarTrabajo();
	}

	public void depart(Buque unBuque) {
		unBuque.cambiarAOutbound();
	}

	public List<Container> getContainers() {
		return this.containers;
	}

	



	
	

}

//mensaje directo exportar un tipo de container



//mejor viaje es el q tiene menos terminal intermedias.