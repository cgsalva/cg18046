package ues.occ.edu.sv.ingenieria.prn335.guia02_2022;

import java.util.ArrayList;
import java.util.List;
import ues.occ.edu.sv.ingenieria.prn335.controller.TipoDocumentoBean;
import ues.occ.edu.sv.ingenieria.prn335.entity.TipoDocumento;

/**
 *
 * @author ascg
 * Carnet: CG18046
 */
public class Guia02_2022 {

    public static void main(String[] args) {
        
        TipoDocumentoBean tdBean = new TipoDocumentoBean();
        TipoDocumento tdEntity = new TipoDocumento(5, "Licencia para conducir", ".", false);
        
        //tdBean.modificar(tdEntity); // MODIFICAR
        //tdBean.eliminar(1); // ELIMINAR
        
        List<TipoDocumento> lista = tdBean.Leer(); // LEER
        //List<TipoDocumento> lista = tdBean.Leer(3); LEER UNO
        
        System.out.println("\n-- LISTA DE DOCUMENTOS");
        
        for (TipoDocumento td: lista) {
            System.out.println(td.getIdTipoDocumento()+ " " + td.getNombre() + " " + td.getExpresionRegular() + " " + td.getActivo());
        }
        
        // DUIS A VALIDAR
        String duis = "2023213311-1 2930183241-1 100000A02-1 19230121-3 1936128321-1 192831193129-1 109201946-9 182930182931-2 182039182 1820381921-1 182039185-1 63091345-1 123i12341-2 74012831123-1 75839230-5 01467329-1 1273485-21 742880121";
        
        // LISTA DE DUIS VALIDADOS
        ArrayList<String> duisValidados = tdBean.validarDUI(duis);
        
        System.out.println("\n-- LISTA DE DUIS VALIDADOS");
        
        // MOSTRAR LA LISTA DE DUIS VALIDADOS
        for (String dui: duisValidados) {
	System.out.println(dui);
        }
        
    }
    
}
