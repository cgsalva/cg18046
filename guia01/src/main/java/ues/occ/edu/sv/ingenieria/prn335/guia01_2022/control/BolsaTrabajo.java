package ues.occ.edu.sv.ingenieria.prn335.guia01_2022.control;

import java.util.ArrayList;
import ues.occ.edu.sv.ingenieria.prn335.guia01_2022.entity.Persona;

public class BolsaTrabajo {

    ArrayList<Persona> persona = new ArrayList<>();

    public BolsaTrabajo() {

        persona.add(new Persona(1, "jose", "osorio", "mi casa", "M", "1999/09/06", true, "chepe", "No", "soltero/a"));
        persona.add(new Persona(2, "jose", "clemente", "su casa", "M", "2000/01/03", true, "armando", "No", "soltero/a"));
        persona.add(new Persona(3, "carlos", "roberto", "candelaria", "M", "2001/09/04", true, "carlitos", "No", "soltero/a"));
        persona.add(new Persona(4, "cristiano", "ronaldo", "soyapango", "M", "1985/02/05", true, "el bicho", "No", "casado/a"));
        persona.add(new Persona(5, "leonel", "messi", "apopa", "M", "1987/05/24", true, "la pulga", "No", "casado/a"));
        
    }
    
    public boolean agregarPersona (int id_persona, String nombre, String apellido, String direccion, String genero, String fecha_nacimiento, boolean jubilado, String conocido_por, String capacidades_especiales, String estado_civil) {
        if (id_persona > 0 && !nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty() && !genero.isEmpty() && !fecha_nacimiento.isEmpty() && !conocido_por.isEmpty() && !capacidades_especiales.isEmpty() && !estado_civil.isEmpty()) {
            int edad = 2022 - Integer.parseInt(fecha_nacimiento.substring(0, 4));
            if (jubilado == false && edad >= 18) {
                persona.add(new Persona(id_persona, nombre, apellido, direccion, genero, fecha_nacimiento, jubilado, conocido_por, capacidades_especiales, estado_civil));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public ArrayList<Persona> buscarPersona (String nombre) {
        ArrayList<Persona> lista = new ArrayList<>();
        for (Persona p: persona) {
            if (p.getNombres().equalsIgnoreCase(nombre)) {
                lista.add(p);
            }
        }
        return lista;
    }

    public ArrayList<Persona> getPersona() {
        return persona;
    }

}
