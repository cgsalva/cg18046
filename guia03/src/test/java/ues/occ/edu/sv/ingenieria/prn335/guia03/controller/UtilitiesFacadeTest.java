package ues.occ.edu.sv.ingenieria.prn335.guia03.controller;

import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Persona;

/**
 *
 * @author ascg
 */
public class UtilitiesFacadeTest {
    
    @Test
    public void testFindPersonaTipoDocumento() throws Exception {
        UtilitiesFacade uf = new UtilitiesFacade();
        uf.em = Mockito.mock(EntityManager.class);
        List<Persona> resultado = uf.findPersonaTipoDocumento("");
        assertTrue(resultado.isEmpty());
    }
    
}
