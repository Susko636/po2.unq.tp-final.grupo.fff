package unqipoo2tpfinal.buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unqipoo2tpfinal.Viaje;

public class PuertoDestino extends BuscadorSimple {
	
	public PuertoDestino(String nombrePuerto) {
		super();
		this.valorBuscado = nombrePuerto;
	}
	
	@Override
	public List<Viaje> buscar(List<Viaje> viajes) {
		List<Viaje> resultadoDeBusqueda = new ArrayList<Viaje>();
		resultadoDeBusqueda = 
				viajes.stream().filter(v->v.getTerminalDeLlegada().getNombre().equals(this.getValorBuscado()))
				.toList();
		return resultadoDeBusqueda;
	}

}
