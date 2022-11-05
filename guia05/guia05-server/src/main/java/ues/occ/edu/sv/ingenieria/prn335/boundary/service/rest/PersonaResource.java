package ues.occ.edu.sv.ingenieria.prn335.boundary.service.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import ues.occ.edu.sv.ingenieria.prn335.control.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.control.PersonaFacade;
import ues.occ.edu.sv.ingenieria.prn335.entity.Persona;

/**
 *
 * @author ascg
 */
@Path("/persona")
public class PersonaResource extends AbstractResource<Persona> implements Serializable {
    
    @Inject
    private PersonaFacade personaFacade;

    @Override
    protected AbstractFacade<Persona> getFacade() {
        return this.personaFacade;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        if (id != null) {
            try {
                Persona salida = getFacade().findById(id);
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
