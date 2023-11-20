package unqipoo2tpfinal.buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unqipoo2tpfinal.Viaje;

public class PuertoDestino extends BuscadorSimple {
	
	public PuertoDestino(String nombrePuerto) {
		super();
		this.valorBuscado = nombrePuerto;
		this.resultadosDeBusqueda = new ArrayList<Viaje>();
	}
	
	@Override
	public List<Viaje> buscar(List<Viaje> viajes) {
		List<Viaje> resultadoDeBusqueda = this.getResultadosDeBusqueda();
		resultadoDeBusqueda = 
				viajes.stream().filter(v->v.getTerminalDeLlegada().getNombre().equals(this.getValorBuscado()))
				.toList();
		return resultadoDeBusqueda;
	}

}
