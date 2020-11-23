import edu.upc.eetac.dsa.*;

import edu.upc.eetac.dsa.models.Laboratorio;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestCovid {
    //Log4j Logger initialization
    private static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    //Product Manager
    public Covid19ManagerImpl gestor = null;



    @Before
    public void setUp() {
        //Configuring Log4j
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.debug("Debug Test Message!");
        logger.info("Info Test Message!");
        logger.warn("Warning Test Message!");
        logger.error("Error Test Message!");

        //Instancing  implementation
        gestor = Covid19ManagerImpl.getInstance();

        //Estructura de datos

        gestor.añadirPersona("1312","Juan",21,"A");
        gestor.addMuestra("dsa6","6dsa","1312", "001");

        Laboratorio lab = new Laboratorio("001","UPCLab");
        gestor.addLab(lab, 0);
    }

    @After
    public void tearDown(){
        gestor.liberarRecursos();
    }

    @Test
    public void addUserTest(){
        //Initial test --> espera que Juan esté en el sistema
        Assert.assertEquals(1,gestor.numUsers());

        //Añadimos otro usuario
        gestor.añadirPersona("1714", "Pep", 35, "B");
        Assert.assertEquals(2, gestor.numUsers());
        Assert.assertEquals("Pep", gestor.consultarNombre("1714"));
    }

    @Test
    public void procesaMuestraTest(){
        //Añadimos la muestra de Juan al laboratorio 001
        Laboratorio labPrueba = gestor.getLab(0);
        labPrueba.añadirMuestra(gestor.getMuestra(0));

        int res = gestor.procesaMuestra(labPrueba);
    }

}
