package ues.occ.edu.sv.ingenieria.prn335.control;

import java.io.Serializable;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        return this.em;
    }
    
    public PersonaFacade() {
        super(Persona.class);
    }
    
}
