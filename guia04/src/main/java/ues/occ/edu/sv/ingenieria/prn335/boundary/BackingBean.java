package ues.occ.edu.sv.ingenieria.prn335.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import ues.occ.edu.sv.ingenieria.prn335.control.AbstractFacade;

/**
 *
 * @author ascg
 */

public abstract class BackingBean<T> {
    
    protected T entity;
    protected LazyDataModel<T> lista;
    private boolean seleccion = false;
    private boolean botones = false;
    private boolean botonGuardar = true;
    protected Estados estado;

    protected abstract AbstractFacade<T> getDataAccess();
    protected abstract T newEntity();
    public abstract T datosPorClave(String rowKey);
    public abstract String clavePorDatos(T entity);
    public abstract int contar(Map<String, FilterMeta> filterBy);

    public enum Estados {
        NUEVO, EDITAR, NONE;
    }

    public void nuevoEstado() {
        this.estado = Estados.NUEVO;
        this.entity = newEntity();
        this.botones = false;
        this.botonGuardar = true;
    }

    public void cambiarSeleccion(){
        this.botones = true;
        this.botonGuardar = false;
        this.estado = Estados.EDITAR;
    }

    public void limpiar(){
        this.entity = newEntity();
        this.botones = false;
        this.botonGuardar = true;
    }

    public void crearMensaje(String texto) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    protected void inicializarLazyDataModel() {
        try {
            this.lista = new LazyDataModel<T>() {
                @Override
                public T getRowData(String rowKey) {
                    return datosPorClave(rowKey);
                }
                @Override
                public String getRowKey(T entity) {
                    return clavePorDatos(entity);
                }
                @Override
                public int count(Map<String, FilterMeta> filterBy) {
                    return contar(filterBy);
                }
                @Override
                public List<T> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                    return listar(offset, pageSize, sortBy, filterBy);
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PostConstruct
    protected void inicializar() {
        this.inicializarLazyDataModel();
        this.estado = Estados.NONE;
    }

    public List<T> listar(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        List listaResultado = null;
        try {
            if (getDataAccess() != null) {
                listaResultado = getDataAccess().findRange(first, pageSize);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            if (listaResultado == null) {
                listaResultado = new ArrayList();
            }
        }
        return listaResultado;
    }

    public void crear() {
        if (getDataAccess() != null) {
            try {
                getDataAccess().crear(this.entity);
                crearMensaje("Guardado con exito");
            } catch(Exception e) {
                crearMensaje("Error al guardar");
            }
        }
        limpiar();
    }

    public void modificar() {
        if (getDataAccess() != null) {
            try {
                getDataAccess().modificar(this.entity);
                crearMensaje("Modificado con exito");
            } catch(Exception e) {
                crearMensaje("Error al modificar");
            }
        }
        limpiar();
    }

    public void eliminar() {
        if (getDataAccess() != null) {
            try {
                getDataAccess().eliminar(this.entity);
                crearMensaje("Eliminado con exito");
            } catch(Exception e) {
                crearMensaje("Error al eliminar");
            }
        }
        limpiar();
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public LazyDataModel<T> getLista() {
        return lista;
    }

    public void setLista(LazyDataModel<T> lista) {
        this.lista = lista;
    }

    public boolean getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public boolean getBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public boolean getBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    
}