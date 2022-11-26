package ues.occ.edu.sv.ingenieria.prn335.guia06.control;

import java.io.Serializable;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Persona;

/**
 *
 * @author ascg
 */
@Stateless
@LocalBean
public class PersonaBean extends AbstractDataAccess<Persona> implements Serializable {

    @PersistenceContext(unitName = "bolsaPU")
    EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }
    
    public PersonaBean () {
        super(Persona.class);
    }
    
}
