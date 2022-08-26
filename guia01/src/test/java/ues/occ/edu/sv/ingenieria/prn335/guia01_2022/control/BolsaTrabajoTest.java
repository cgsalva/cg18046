package ues.occ.edu.sv.ingenieria.prn335.guia01_2022.control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BolsaTrabajoTest {
    BolsaTrabajo bt = new BolsaTrabajo();
    
    @Test
    public void agregarPersonaTest () {
        Assertions.assertFalse(bt.agregarPersona(1, "jose", "osorio", "mi casa", "M", "1999/09/06", true, "chepe", "No", "soltero/a")); 
    }
    
}
