package unqipoo2tpfinal.buscador;

import java.util.List;

import unqipoo2tpfinal.Viaje;

public abstract class BuscadorComplejo extends Buscador{
	
	protected Busqueda busqueda1;
	protected Busqueda busqueda2;

	@Override
	public abstract List<Viaje> buscar(List<Viaje> viajes);

	public Busqueda getPrimerBusqueda() {
		return this.busqueda1;
	}
	
	public Busqueda getSegundaBusqueda() {
		return this.busqueda2;
	}

}
