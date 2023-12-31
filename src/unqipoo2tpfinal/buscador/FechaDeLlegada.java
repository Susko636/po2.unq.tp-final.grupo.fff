package unqipoo2tpfinal.buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unqipoo2tpfinal.Viaje;

public class FechaDeLlegada extends BuscadorSimple {
	
	public FechaDeLlegada(String fechaDeLlegada) {
		super();
		this.valorBuscado = fechaDeLlegada;
	}
 
	@Override
	public List<Viaje> buscar(List<Viaje> viajes) {
		List<Viaje> resultadoDeBusqueda = new ArrayList<Viaje>();
		resultadoDeBusqueda = 
				viajes.stream().filter(v->v.getFechaLlegada().toString().equals(this.getValorBuscado()))
				.toList();
		return resultadoDeBusqueda;
	}

}
