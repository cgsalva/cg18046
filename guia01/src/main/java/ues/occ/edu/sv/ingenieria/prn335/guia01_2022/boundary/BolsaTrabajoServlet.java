package ues.occ.edu.sv.ingenieria.prn335.guia01_2022.boundary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.ingenieria.prn335.guia01_2022.control.BolsaTrabajo;

public class BolsaTrabajoServlet extends HttpServlet {
    
    BolsaTrabajo bolsaTrabajo = new BolsaTrabajo();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* PETICIONES POR EL METODO GET */
        
        String accion = request.getParameter("accion");
        
        /* Listar persona */
        if (accion.equalsIgnoreCase("listar")) {
            request.setAttribute("listaPersonas", bolsaTrabajo.getPersona());
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }
        
        /* Buscar persona por nombre */
        if (accion.equalsIgnoreCase("buscar")) {
            String nombre = request.getParameter("nombre");
            request.setAttribute("listaPersonas", bolsaTrabajo.buscarPersona(nombre));
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* PETICIONES POR EL METODO POST */
        
        /* Recepcion de parametros */
        int id_persona = Integer.parseInt(request.getParameter("id_persona"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String genero = request.getParameter("genero");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String capacidades_especiales = request.getParameter("capacidades_especiales");
        String estado_civil = request.getParameter("estado_civil");
        String direccion = request.getParameter("direccion");
        boolean jubilado = Integer.parseInt(request.getParameter("jubilado")) > 0;
        String conocido_por = request.getParameter("conocido_por");
        
        /* Agregar persona a la lista */
        boolean agregado = bolsaTrabajo.agregarPersona(id_persona, nombre, apellido, direccion, genero, fecha_nacimiento, jubilado, conocido_por, capacidades_especiales, estado_civil);
        if (agregado) {
            request.setAttribute("listaPersonas", bolsaTrabajo.getPersona());
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        } else {
            response.sendRedirect("/guia01_2022/");
        }
    }

}
