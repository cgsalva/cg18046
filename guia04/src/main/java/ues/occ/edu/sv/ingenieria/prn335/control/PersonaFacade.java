package ues.occ.edu.sv.ingenieria.prn335.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.ingenieria.prn335.entity.Persona;

/**
 *
 * @author ascg
 */

@Stateless
@LocalBean
public class PersonaFacade extends AbstractFacade<Persona> implements Serializable {
    
    @PersistenceContext(unitName = "bolsaPU")
    EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }
    
    public PersonaFacade () {
        super(Persona.class);
    }
    
}
