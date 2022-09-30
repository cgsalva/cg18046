package ues.occ.edu.sv.ingenieria.prn335.guia03.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Documento;
import ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Persona;

/**
 *
 * @author ascg
 */
@Stateless
@LocalBean
public class UtilitiesFacade implements Serializable {
    
    @PersistenceContext(unitName = "bolsaPU")
    EntityManager em;
    
    EntityManager getEntityManager() {
        return em;
    }
    
    public List<Persona> findPersonaTipoDocumento (String idPersona) {
        List<Persona> listaPersonasDui = new ArrayList(); // Lista en la que se guardaran las personas que poseen dui.
        EntityManager em = null;
        try {
            em = getEntityManager();
            if (em != null) { // Validar que el EntityManager sea diferente de nulo.
                Query consulta = em.createQuery("SELECT p FROM Persona p"); // Consulta que trae a las personas
                List<Persona> listaPersonas = consulta.getResultList(); // Lista de personas
                for (Persona p : listaPersonas) { // Iteracion de la lista de personas.
                    for (Documento td : p.getDocumentoList()) { // Iteracion de los documentos que posee.
                        if ("dui".equalsIgnoreCase(td.getTipoDocumento().getNombre())) { // Validar que posee un documento con el nombre de "dui"
                            listaPersonasDui.add(p); // Agregamos a la lista.
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return listaPersonasDui; // Retorno de la lista de personas que poseen duis, en caso de que nadie poseea dui se retorna un array vacio.
    }
    
}
