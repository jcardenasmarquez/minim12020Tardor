package edu.upc.eetac.dsa.models;

import java.util.Date;
import java.util.List;
import java.util.*;

public class Persona {

    private String idUsuario;
    private String nombre;
    private int edad;
    private String salud;
    private List<Muestra> listMuestrasProcesadas;

    public Persona(String id, String nom, int anys, String nivel){
        this.idUsuario = id;
        this.nombre = nom;
        this.edad = anys;
        this.salud = nivel;
        this.listMuestrasProcesadas = new LinkedList<Muestra>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public List<Muestra> getListMuestras() {
        return listMuestrasProcesadas;
    }

    public void addMuestras(Muestra m) {
        this.listMuestrasProcesadas.add(m);
    }
}
