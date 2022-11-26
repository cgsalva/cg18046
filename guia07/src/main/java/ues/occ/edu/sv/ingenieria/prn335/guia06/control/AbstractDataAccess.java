package ues.occ.edu.sv.ingenieria.prn335.guia06.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.Collections;

/**
 *
 * @author ascg
 */
public abstract class AbstractDataAccess<T> implements Serializable {
    
    protected final Class clase;

    public AbstractDataAccess (Class clase) {
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
    
    public Query generarConsultaBase(EntityManager em) throws IllegalArgumentException {
        if (em != null) {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clase));
            return em.createQuery(cq);
        }
        throw new IllegalArgumentException(); 
     }

    public List<T> findAll() {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception e) {

        }
        if (em != null) {
            Query q = generarConsultaBase(em);
            List<T> salida = q.getResultList();
            if (salida != null) {
                return salida;
            }
        }
        return Collections.EMPTY_LIST;
    }
        
    public T findById(final Object id) throws IllegalArgumentException, IllegalStateException {
        if (id != null) {
            EntityManager em = null;
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
            return new ArrayList();
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
