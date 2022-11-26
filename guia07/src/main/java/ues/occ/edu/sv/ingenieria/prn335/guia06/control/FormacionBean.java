package ues.occ.edu.sv.ingenieria.prn335.guia06.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Formacion;

/**
 *
 * @author ascg
 */
@Stateless
@LocalBean
public class FormacionBean extends AbstractDataAccess<Formacion> implements Serializable {

    @PersistenceContext(unitName = "bolsaPU")
    EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }
    
    public FormacionBean() {
        super(Formacion.class);
    }
    
}
