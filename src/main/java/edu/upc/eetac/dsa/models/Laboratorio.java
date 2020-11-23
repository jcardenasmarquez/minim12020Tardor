package edu.upc.eetac.dsa.models;

import java.util.Queue;

public class Laboratorio {

    private String idLab;
    private String nombre;
    private Queue<Muestra> muestrasPendientes;

    public Laboratorio(String id, String nom){
        this.idLab = id;
        this.nombre = nom;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirMuestra(Muestra m){
        this.muestrasPendientes.add(m);
    }

    public Muestra generaInforme(){
        Muestra m = this.muestrasPendientes.poll();
        m.setResultado();
        m.setComentario();
        return m;
    }
}
