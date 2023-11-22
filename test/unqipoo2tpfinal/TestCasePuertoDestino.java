package unqipoo2tpfinal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import unqipoo2tpfinal.buscador.PuertoDestino;

class TestCasePuertoDestino {

    private PuertoDestino unPuertoDestino;
    private String nombreEsperado;
    private List<Viaje> listaABuscar;
    private Viaje unViaje;
    private TerminalPortuaria unaTerminal;

    @BeforeEach
    public void setUp() {
        unViaje = mock(Viaje.class);
        unPuertoDestino = new PuertoDestino("puertoPrueba1");
        nombreEsperado = "puertoPrueba1";
        listaABuscar = new ArrayList<Viaje>();
        listaABuscar.add(unViaje);
        unaTerminal = mock(TerminalPortuaria.class);
    }

    @Test
    void testSeBuscaLaFechaDeLlegada() {

        when(unViaje.getTerminalDeLlegada()).thenReturn(unaTerminal);
        when(unaTerminal.getNombre()).thenReturn(nombreEsperado);


        unPuertoDestino.buscar(listaABuscar);
        assertEquals(unPuertoDestino.buscar(listaABuscar),listaABuscar);
    }


}