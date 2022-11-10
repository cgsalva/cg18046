package ues.occ.edu.sv.ingenieria.prn335.guia06.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ues.occ.edu.sv.ingenieria.prn335.guia06.control.AbstractDataAccess;

/**
 *
 * @author ascg
 */
public abstract class AbstractResource<T> implements Serializable {
    
    protected abstract AbstractDataAccess<T> getDataAccessBean();
        
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(T registro) {
        if (registro != null) {
            try {
                if (this.getDataAccessBean() != null) {
                    this.getDataAccessBean().crear(registro);
                    return Response.status(Response.Status.CREATED).entity(registro).build();
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo crear ", registro).build();
    }
        
    @GET
    @Path("contar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response contar() {
        if (this.getDataAccessBean() != null) {
            return Response.ok(this.getDataAccessBean().contar()).header("Total-Registros", getDataAccessBean().contar()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByRange(@QueryParam("first") @DefaultValue("0") int first, @QueryParam("pagesize") @DefaultValue("10") int pagesize) {
        if (first >= 0 && first < pagesize) {
            try {
                List<T> lista = this.getDataAccessBean().findRange(first, pagesize);
                if (lista != null) {
                    return Response.ok(lista).header("Total-Registros", getDataAccessBean().contar()).build();
                }
            } catch(Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        if (this.getDataAccessBean() != null) {
            try {
                List<T> lista = this.getDataAccessBean().findAll();
                if (lista != null) {
                    return Response.ok(lista).header("Total-Registros", getDataAccessBean().contar()).build();
                }
            } catch(Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }
    
}
