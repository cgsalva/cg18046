package ues.occ.edu.sv.ingenieria.prn335.boundary;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author ascg
 */

@Named
@SessionScoped
public class idiomaBean implements Serializable {
    
        private String idioma="es";

        private static Map<String,Object>idiomas; 
        static{
            idiomas = new LinkedHashMap<>();
            idiomas.put("Español", Locale.forLanguageTag("es"));
            idiomas.put("English", Locale.US);
        }
        
        public String getIdioma() {
            return idioma;
        }
    
        public void setIdioma(String idioma) {
            this.idioma = idioma;
        } 
        
        public Map<String, Object> getIdiomas() {
            return idiomas;
        }
        
        public void cambioDeIdioma(ValueChangeEvent vce){
            if(vce.getNewValue()!=null){
                try {
                    String nuevoCodigo=vce.getNewValue().toString();
                    for(Map.Entry<String,Object> entrySet: idiomas.entrySet()){
                        Locale value=(Locale) entrySet.getValue();
                        if(value.toString().compareTo(nuevoCodigo)==0){
                            FacesContext.getCurrentInstance().getViewRoot().setLocale(value);
                            return;
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(),ex);
                }
            }
    
        }
        
}
