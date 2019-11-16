package com.petshop.model.controller;

import com.petshop.model.entity.TipoMascota;
import com.petshop.model.controller.util.JsfUtil;
import com.petshop.model.controller.util.JsfUtil.PersistAction;
import com.petshop.model.dao.TipoMascotaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tipoMascotaController")
@SessionScoped
public class TipoMascotaController implements Serializable {

    @EJB
    private com.petshop.model.dao.TipoMascotaFacade ejbFacade;
    private List<TipoMascota> items = null;
    private TipoMascota selected;

    public TipoMascotaController() {
    }

    public TipoMascota getSelected() {
        return selected;
    }

    public void setSelected(TipoMascota selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoMascotaFacade getFacade() {
        return ejbFacade;
    }

    public TipoMascota prepareCreate() {
        selected = new TipoMascota();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Vista").getString("TipoMascotaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Vista").getString("TipoMascotaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Vista").getString("TipoMascotaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoMascota> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TipoMascota getTipoMascota(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TipoMascota> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoMascota> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TipoMascota.class)
    public static class TipoMascotaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoMascotaController controller = (TipoMascotaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoMascotaController");
            return controller.getTipoMascota(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TipoMascota) {
                TipoMascota o = (TipoMascota) object;
                return getStringKey(o.getIdTipoMascota());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoMascota.class.getName()});
                return null;
            }
        }

    }

}
