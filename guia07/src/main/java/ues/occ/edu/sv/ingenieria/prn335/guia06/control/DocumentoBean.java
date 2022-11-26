package ues.occ.edu.sv.ingenieria.prn335.guia06.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Documento;

/**
 *
 * @author ascg
 */
@Stateless
@LocalBean
public class DocumentoBean extends AbstractDataAccess<Documento> implements Serializable {

    @PersistenceContext(unitName = "bolsaPU")
    EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }

    public DocumentoBean() {
        super(Documento.class);
    }

    public List<Documento> findByIdPersona(Long idPersona, int first, int pageSize) {
        if (idPersona != null && em != null) {
            Query q = em.createNamedQuery("Documento.findByIdPersona");
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            q.setParameter("idPersona", idPersona);
            return q.getResultList();
        }
        return Collections.EMPTY_LIST;
    }

    public int contarByIdPersona(Long idPersona) {
        if (idPersona != null && em != null) {
            Query q = em.createNamedQuery("Documento.countByIdPersona");
            q.setParameter("idPersona", idPersona);
            return ((Long) q.getSingleResult()).intValue();
        }
        return 0;
    }

}