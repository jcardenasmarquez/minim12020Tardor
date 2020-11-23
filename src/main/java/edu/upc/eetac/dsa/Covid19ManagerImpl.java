package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.*;

import java.util.*;

import edu.upc.eetac.dsa.models.Laboratorio;
import edu.upc.eetac.dsa.models.Muestra;
import edu.upc.eetac.dsa.models.Persona;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class Covid19ManagerImpl implements Covid19Manager {
    //--Singleton: Referencia privada estatica a la unica instancia de la clase--//
    private static Covid19ManagerImpl instancia;

    private static Logger log = LogManager.getLogger(Covid19ManagerImpl.class);

    //---Estructuras de datos (atributos) del gestor---//
    private HashMap<String, Persona> tablaUsuarios = null;
    private List<Muestra> listaMuestras = null;
    private Laboratorio[] laboratorios;

    //----------Singleton: constructor privado----------//
    private Covid19ManagerImpl() {
        this.tablaUsuarios = new HashMap<>();
        this.listaMuestras = new LinkedList<Muestra>();
        this.laboratorios = new Laboratorio[5];
    }

    //---Singleton: metodo de acceso estático que devuelve una referencia a la (unica) instancia---//
    public static Covid19ManagerImpl getInstance() {
        if (instancia == null) instancia = new Covid19ManagerImpl();
        return instancia;
    }

    //Métodos no estáticos del gestor

    @Override
    public int añadirPersona(String id, String nombre, int edad, String salud) {
        Persona usuario = new Persona(id, nombre, edad, salud);
        try {
            tablaUsuarios.put(id, usuario);
            log.info("Usuario añadido " + usuario.getNombre());
            return 201; //Ok created
        } catch (IndexOutOfBoundsException e) {
            log.error("tablaUsuarios Full Error");
            return 507; //INSUFFICIENT STORAGE
        } catch (IllegalArgumentException e) {
            log.error("Incorrect format exception");
            return 400; //BAD REQUEST
        }
    }

    @Override
    public int extraeMuestra(Muestra m) {
        boolean found = false;
        for (Laboratorio laboratorio : laboratorios) {
            if (m.getIdLab().equals(laboratorio.getIdLab())) {
                laboratorio.añadirMuestra(m);
                log.info("Muestra enviada correctamente a laboratorio:" + laboratorio.getNombre());
                found = true;
            }
        }
        if (!found) return 404; //lab not found
        else
            return 201; //Ok created
    }


    @Override
    public int procesaMuestra(Laboratorio lab) {
        try {
            Muestra procesada = lab.generaInforme();
            log.info("Informe generado ");
            log.info(procesada.getResultado() + "----" + procesada.getComentario());
            Persona usuario = this.tablaUsuarios.get(procesada.getIdPersona());
            usuario.addMuestras(procesada);
            return 201; //Ok processed
        } catch (Error e) {
            log.error("Error al procesar muestra");
            return 400; //Error
        }
    }

    @Override
    public List<Muestra> getMuestras(Persona id) {
        return this.tablaUsuarios.get(id.getIdUsuario()).getListMuestras();
    }

    // otras funciones

    public void addMuestra(String idM, String idC, String idP, String idLab){
        Muestra m = new Muestra(idM,idC,idP,idLab);
        try{
            this.listaMuestras.add(m);
            log.info("Muestra añadida al sistema: " + m.getIdMuestra());
        }
        catch(IndexOutOfBoundsException e){
            log.error("Error al añadir muestra");
        }
    }

    public Muestra getMuestra(int i){
        return this.listaMuestras.get(i);
    }

    public  void addLab(Laboratorio lab, int i){
        this.laboratorios[i] = lab;
    }

    public Laboratorio getLab(int i){
        return this.laboratorios[i];
    }

    public int numUsers(){
        return this.tablaUsuarios.size();
    }

    public String consultarNombre(String id){
        return this.tablaUsuarios.get(id).getNombre();
    }

    @Override
    public void liberarRecursos() {
        this.tablaUsuarios.clear();
        this.listaMuestras.clear();

    }
}
