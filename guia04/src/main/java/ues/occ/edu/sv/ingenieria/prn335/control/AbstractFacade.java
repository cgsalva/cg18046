package ues.occ.edu.sv.ingenieria.prn335.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ascg
 */

public abstract class AbstractFacade<T> implements Serializable {
    
    protected final Class clase;

    public AbstractFacade (Class clase) {
        this.clase = clase;
    }

    abstract EntityManager getEntityManager ();
    
    public void crear (T entity) throws IllegalArgumentException, IllegalStateException {
        if (entity != null) {
            EntityManager em = this.getEntityManager();
            if (em != null) {
                em.persist(entity);
            } else {
                throw new IllegalStateException();
            } 
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void modificar (T entity) throws IllegalArgumentException, IllegalStateException {
        if(entity != null){
            EntityManager em = this.getEntityManager();
            if (em != null) {
                em.merge(entity);
            } else {
                throw new IllegalStateException();
            } 
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void eliminar(T entity) throws IllegalArgumentException, IllegalStateException {
       if(entity != null){
            EntityManager em = this.getEntityManager();
            if (em != null) {
                em.remove(em.merge(entity));
            } else {
                throw new IllegalStateException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    public Query generarConsultaBase (EntityManager em) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        Query q = em.createQuery(cq);
        return q;
     }

    public List<T> findAll () throws IllegalStateException {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        if (em != null) {
            Query q = generarConsultaBase(em);
            return q.getResultList();
        } else {
            return new ArrayList<>();
        }
    }
    
    public T findById(Long id) throws IllegalArgumentException, IllegalStateException {
        EntityManager em = null;
        if (id != null) {
            try {
                em = this.getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException();
            }
            if (em != null) {
                return (T) em.find(clase, id);
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
    
    public List<T> findRange (int first, int pageSize) throws IllegalStateException {
        EntityManager em = null;
         try {
            em = this.getEntityManager();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        if (em != null) {
        	Query q = generarConsultaBase(em);
            q.setMaxResults(pageSize);
            q.setFirstResult(first);
            return q.getResultList();
        } else {
            return new ArrayList<>();
        }
    }
    
    public long contar() throws IllegalStateException{
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        if (em != null) {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<T> rt = cq.from(clase);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return (Long)q.getSingleResult();
       } else {
            throw new IllegalStateException();
        }
    }
    
}
