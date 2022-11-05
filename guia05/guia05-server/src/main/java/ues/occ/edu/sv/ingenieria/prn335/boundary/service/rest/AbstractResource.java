package ues.occ.edu.sv.ingenieria.prn335.boundary.service.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ues.occ.edu.sv.ingenieria.prn335.control.AbstractFacade;

/**
 *
 * @author ascg
 */
public abstract class AbstractResource<T> implements Serializable {
    
    protected abstract AbstractFacade<T> getFacade();
        
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(T registro) {
        if (registro != null) {
            try {
                if (getFacade() != null) {
                    getFacade().crear(registro);
                    return Response.status(Response.Status.CREATED).entity(registro).build();
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo crear ", registro).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByRange(@QueryParam("first") @DefaultValue("0") int first, @QueryParam("pagesize") @DefaultValue("10") int pagesize) {
        try {
            List<T> lista = getFacade().findRange(first, pagesize);
            if (lista != null) {
                return Response.ok(lista).header("Total-Registros", getFacade().contar()).build();
            }
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        if (getFacade() != null) {
            try {
                List<T> lista = getFacade().findAll();
                if (lista != null) {
                    return Response.ok(lista).header("Total-Registros", getFacade().contar()).build();
                }
            } catch(Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }

    @GET
    @Path("contar")
    @Produces({MediaType.APPLICATION_JSON})
    public Response contar() {
        if (getFacade() != null) {
            return Response.ok(getFacade().contar()).header("Total-Registros", getFacade().contar()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }

}
    