package ues.occ.edu.sv.ingenieria.prn335.guia06.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Experiencia;

/**
 *
 * @author ascg
 */
@Stateless
@LocalBean
public class ExperienciaBean extends AbstractDataAccess<Experiencia> implements Serializable {

    @PersistenceContext(unitName="bolsaPU")
    EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }
    
    public ExperienciaBean() {
        super(Experiencia.class);
    }
    
}
