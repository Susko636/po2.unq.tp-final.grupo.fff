package unqipoo2tpfinal.buscador;

import java.util.List;

import unqipoo2tpfinal.Viaje;

public abstract class BuscadorSimple extends Buscador{
	
	protected String valorBuscado;

	@Override
	public abstract List<Viaje> buscar(List<Viaje> viajes);
	
	public String getValorBuscado() {
		return this.valorBuscado;
	}

}
