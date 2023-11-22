package unqipoo2tpfinal.buscador;

import java.util.List;
import java.util.stream.Stream;

import unqipoo2tpfinal.Viaje;

public class OperadorAND extends BuscadorComplejo {

	public OperadorAND(Busqueda busqueda1, Busqueda busqueda2) {
		this.busqueda1 = busqueda1;
		this.busqueda2 = busqueda2;
	}

	@Override
	public List<Viaje> buscar(List<Viaje> viajes) {
		Stream<Viaje> resultado1 = this.getPrimerBusqueda().buscar(viajes).stream();
		List<Viaje> resultado2 = this.getSegundaBusqueda().buscar(viajes).stream().toList();
		return resultado1.filter(resultado2::contains).distinct().toList();
	}

}
