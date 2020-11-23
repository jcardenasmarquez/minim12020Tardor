package edu.upc.eetac.dsa.models;

import java.util.Date;


public class Muestra {

    private String idMuestra;
    private String idClinico;
    private String idPersona;
    private String idLab;

    private String resultado = null;
    private String comentario = null;

    public Muestra(String idM, String idC, String idP,String idLab){
        this.idMuestra = idM;
        this.idClinico = idC;
        this.idPersona = idP;
        this .idLab = idLab;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }


    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado() {
        double i = Math.random();
        if(i >0.5) this.resultado = "Positivo";
        else
            this.resultado = "Negativo";
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario() {
        if (this.resultado.equals("Positivo")) this.comentario = "Ve al médico";
        else
            this.comentario = "Todo OK";
    }
}
