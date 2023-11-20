package unqipoo2tpfinal.buscador;

import java.util.List;

import unqipoo2tpfinal.Viaje;

public abstract class Buscador implements Busqueda {
	
	protected List<Viaje> resultadosDeBusqueda;

	@Override
	public abstract List<Viaje> buscar(List<Viaje> viajes);

	public List<Viaje> getResultadosDeBusqueda() {
		return this.resultadosDeBusqueda;
	}

}

