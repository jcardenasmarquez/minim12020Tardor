package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Laboratorio;
import edu.upc.eetac.dsa.models.Muestra;
import edu.upc.eetac.dsa.models.Persona;

import java.util.HashMap;
import java.util.List;

public interface Covid19Manager {
    //Crear persona en el sistema
    int añadirPersona(String id, String nombre, int edad, String salud);
    //Extrae muestra
    int extraeMuestra(Muestra m);
    //Procesa muestra
    int procesaMuestra(Laboratorio lab);
    //Listado de muestras de un usuario procesadas;
    List<Muestra> getMuestras(Persona id);

    //
    public void liberarRecursos();
}
