package unqipoo2tpfinal.orden;

import java.util.ArrayList;
import java.util.List;

import unqipoo2tpfinal.Viaje;
import unqipoo2tpfinal.cliente.Cliente;
import unqipoo2tpfinal.container.Conteiner;
import unqipoo2tpfinal.empresaTransportista.Camion;
import unqipoo2tpfinal.empresaTransportista.Chofer;
import unqipoo2tpfinal.servicio.Servicio;
import unqipoo2tpfinal.servicio.ServicioElectricidad;
import unqipoo2tpfinal.servicio.ServicioLavado;
import unqipoo2tpfinal.servicio.ServicioPesado;

public class Orden {
	
	private Chofer choferAsignado;
	private Camion camionAsignado;
	private List<Servicio> servicios;	
	//private TerminalPortuaria unaTerminal;
	private Viaje viaje;
	private Cliente duenio;

	public Orden( Viaje viaje, Cliente duenio) {
		super();
		this.viaje = viaje;
		this.duenio = duenio;
		this.servicios = new ArrayList<Servicio>();
	}

	public void setChofer(Chofer chofer) {
		this.choferAsignado = chofer;
	}

	public void setCamion(Camion camion) {
		this.camionAsignado = camion;
	}
	
	public Camion getCamion() {
		return this.camionAsignado;
	}
	
	public Chofer getChofer() {
		return this.choferAsignado;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	/*public TerminalPortuaria getUnaTerminal() {
		return this.unaTerminal;
	}*/
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public void serviciosPara(Conteiner container) {
		this.registrarServicio(new ServicioLavado());
		this.registrarServicio(new ServicioPesado());
		this.registrarServicio(new ServicioElectricidad(container.getConsumo()));
	}

	public Double calcularPrecioPorServicios() {
		return this.getServicios().stream().mapToDouble(s->s.precio()).sum();
	}
	
	
	public void registrarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}

	public Cliente getDuenio() {
		return this.duenio;
	}

	public void enviarMail(String string, Cliente duenio2) {
		this.duenio.recibirMensaje(string);
	}
	
	public  boolean esDeExportacion() {
		return false;
	}

	public boolean esDeImportacion() {
		return false;
	}
	
	
}
