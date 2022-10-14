package ues.occ.edu.sv.ingenieria.prn335.boundary;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.FilterMeta;
import ues.occ.edu.sv.ingenieria.prn335.control.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.control.PersonaFacade;
import ues.occ.edu.sv.ingenieria.prn335.entity.Persona;

/**
 *
 * @author ascg
 */

@Named
@ViewScoped
public class PersonaBean extends BackingBean<Persona> implements Serializable {
    
    @Inject
    private PersonaFacade personaFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }

    @Override
    public Persona datosPorClave(String rowKey) {
        Long id = null;
        if (rowKey != null) {
            try {
                id = Long.parseLong(rowKey);
            } catch (Exception e) {

            }
            if (id != null) {
                for (Persona persona : lista) {
                    if (persona.getIdPersona() == id) {
                        return persona;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String clavePorDatos(Persona persona) {
        return String.valueOf(persona.getIdPersona());
    }

    @Override
    public int contar(Map<String, FilterMeta> filterBy) {
        return (int) getDataAccess().contar();
    }

    @Override
    public AbstractFacade<Persona> getDataAccess() {
        return this.personaFacade;
    }

    @Override
    public Persona newEntity() {
        return new Persona();
    }
    
}
