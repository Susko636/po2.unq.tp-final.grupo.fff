package unqipoo2tpfinal.buscador;

import java.util.List;
import java.util.stream.Stream;

import unqipoo2tpfinal.Viaje;

public class OperadorOR extends BuscadorComplejo {
	
	public OperadorOR(Busqueda busqueda1, Busqueda busqueda2) {
		this.busqueda1 = busqueda1;
		this.busqueda2 = busqueda2;
	}

	@Override
	public List<Viaje> buscar(List<Viaje> viajes) {
		Stream<Viaje> resultado1 = this.getPrimerBusqueda().buscar(viajes).stream();
		Stream<Viaje> resultado2 = this.getSegundaBusqueda().buscar(viajes).stream();
		return Stream.concat(resultado1, resultado2).distinct().toList();
	}
	
}
