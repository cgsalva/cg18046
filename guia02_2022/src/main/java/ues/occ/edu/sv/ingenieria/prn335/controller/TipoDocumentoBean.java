package ues.occ.edu.sv.ingenieria.prn335.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ues.occ.edu.sv.ingenieria.prn335.entity.TipoDocumento;

/**
 *
 * @author ascg 
 * Carnet: CG18046
 */
public class TipoDocumentoBean {
    
    private EntityManagerFactory emf;

    public TipoDocumentoBean() {
            this.emf = Persistence.createEntityManagerFactory("bolsaPU");
    }

    public EntityManager getEntityManager() {
            return emf.createEntityManager();
    }

    public void modificar(TipoDocumento td) { // MODIFICAR
        // VALIDACION
        if (td.getIdTipoDocumento() > 0 && !td.getNombre().isEmpty() && !td.getExpresionRegular().isEmpty() && (td.getActivo() == true || td.getActivo() == false)) {
           EntityManager em = getEntityManager();
            try {
                // TRANSACCION
                em.getTransaction().begin();
                em.merge(td);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.err.println("¡Hay datos invalidos o vacios!");
        }
        
    }

    public void eliminar(Integer id) { // ELIMINAR
        // VALIDACION
        if (id > 0) {
            EntityManager em = getEntityManager();
            try {
                // TRANSACCION
                em.getTransaction().begin();
                TipoDocumento tipoDocumento = em.getReference(TipoDocumento.class, id);
                em.remove(tipoDocumento);
                em.getTransaction().commit();
            } catch (Exception e) {
                 System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.err.println("¡Id invalido!");
        }
    }

    // LEER
    
    public List<TipoDocumento> Leer() {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("SELECT td FROM TipoDocumento td");
        return consulta.getResultList();
    }

    public List<TipoDocumento> Leer(Integer id) {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("SELECT td FROM TipoDocumento td WHERE td.idTipoDocumento=" + id);
        return consulta.getResultList();
    }
    
    // METODO PARA VALIDAR DUIS
    public ArrayList validarDUI(String duis) {       
        ArrayList<String> listaDuis = new ArrayList();
        String arrayDuis[] = duis.trim().split("\\s+");
        for (String dui: arrayDuis) {
            if (dui.matches("^[0-9]{8}[-]{1}[0-9]{1}$")) {
                listaDuis.add(dui);
            }
        }
        return listaDuis;
    }
    
}
