package ues.occ.edu.sv.ingenieria.prn335.guia03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Persona;

/**
 *
 * @author ascg
 */

// Servlet para probar el metodo
// Ejecutar proyecto para ver los resultados

@Named
public class pruebaMetodoServlet extends HttpServlet {

    @Inject
    private UtilitiesFacade uf;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Persona> listaPersonasDui = uf.findPersonaTipoDocumento(""); // Metodo para listar todas las personas que poseen DUI
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Personas con dui</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LISTA DE PERSONAS QUE POSEEN DUI</h1>");
            out.println("<ul>");
            for (Persona p : listaPersonasDui) { // Listar personas
                out.println("<li>" + p.getIdPersona() + " - " + p.getNombres() + " " + p.getApellidos() + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

}
