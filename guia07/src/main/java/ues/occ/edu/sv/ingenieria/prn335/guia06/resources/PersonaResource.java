package ues.occ.edu.sv.ingenieria.prn335.guia06.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import ues.occ.edu.sv.ingenieria.prn335.guia06.control.AbstractDataAccess;
import ues.occ.edu.sv.ingenieria.prn335.guia06.control.PersonaBean;
import ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Persona;

/**
 *
 * @author ascg
 */
@Path("/persona")
public class PersonaResource extends AbstractResource<Persona> implements Serializable {
    
    @Inject
    private PersonaBean personaBean;
    
    @Override
    protected AbstractDataAccess<Persona> getDataAccessBean() {
        return this.personaBean;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        if (id != null) {
            try {
                Persona salida = this.getDataAccessBean().findById(id);
                if (salida != null) {
                    return Response.status(Response.Status.OK).entity(salida).build();
                } else {
                    
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }

}


