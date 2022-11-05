package ues.occ.edu.sv.ingenieria.prn335.boundary.service.cliente;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import ues.occ.edu.sv.ingenieria.prn335.entity.Persona;

/**
 *
 * @author ascg
 */
@Named
@ViewScoped
public class FrmClientePersona implements Serializable {
    
    private static final String BASE_URI = "http://localhost:8080/guia05-server/api/";
    private final Client cliente;
    private WebTarget target;
    LazyDataModel<Persona> model;
    Persona registro;
    Estados estado;
    
    public FrmClientePersona() {
        this.cliente = ClientBuilder.newClient();
        this.target = this.cliente.target(this.BASE_URI);
    }

    @PostConstruct
    public void inicializar() {
        inicializarLazyDataModel();
        this.estado = Estados.NINGUNO;
    }
    
    public enum Estados {
        NUEVO, MODIFICAR, NINGUNO;
    }
    
    public void btnNuevoHandler() {
        this.estado = Estados.NUEVO;
        this.registro = new Persona();
    }
    
    public void btnCancelar() {
        this.estado = Estados.NINGUNO;
        this.registro = null;
    }

    public void crear() {
        if(this.registro != null) {
            try {
                this.target.path("persona")
                            .request(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(this.registro, MediaType.APPLICATION_JSON), Persona.class);
            } catch (Exception e){
            }
        }
        this.estado = Estados.NINGUNO;
        this.registro = null;
    }

    public List<Persona> buscarRegistros(int first, int pageSize) {
        try {
            List<Persona> salida = this.target.path("persona")
                                                            .queryParam("first", first)
                                                            .queryParam("pagesize", pageSize)
                                                            .request(MediaType.APPLICATION_JSON)
                                                            .get(new GenericType<List<Persona>>(){});
            return salida;
        } catch(Exception e){
        }
        return Collections.EMPTY_LIST;
    }

    public int contarRegistros() {
        try{
            int salida = this.target.path("persona/contar")
                                            .request(MediaType.APPLICATION_JSON)
                                            .get(new GenericType<Integer>(){});
            return salida;
        } catch(Exception e){
        }
        return 0;
    }

    protected void inicializarLazyDataModel() {
        try {
            this.model = new LazyDataModel<Persona>() {
                @Override
                public Persona getRowData(String rowKey) {
                    return null;
                }
                @Override
                public String getRowKey(Persona entity) {
                    return null;
                }
                @Override
                public int count(Map<String, FilterMeta> filterBy) {
                    return contarRegistros();
                }
                @Override
                public List<Persona> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                    return buscarRegistros(offset, pageSize);
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public LazyDataModel<Persona> getModel() {
        return model;
    }
     
    public Persona getRegistro() {
        return registro;
    }

    public void setRegistro(Persona registro) {
        this.registro = registro;
    }

    public Estados getEstado() {
        return estado;
    }

}