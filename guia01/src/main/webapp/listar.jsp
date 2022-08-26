<%@page import="java.util.ArrayList"%>
<%@page import="ues.occ.edu.sv.ingenieria.prn335.guia01_2022.entity.Persona"%>
<%
    ArrayList<Persona> listaPersonas = (ArrayList<Persona>)request.getAttribute("listaPersonas");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <title>Lista</title>
</head>
<body>
    <h1>Lista de personas</h1>
    <div class="busqueda">
        <form action="BolsaTrabajoServlet" method="get">
            <input type="hidden" name="accion" value="buscar">
            <label for="buscar">Buscar por nombre: </label>
            <input type="text" name="nombre" id="buscar">
            <button type="submit" class="boton" style="padding: 6px;">Buscar</button>
        </form>
    </div>
    <table class="tabla">
        <thead>
            <tr>
                <th width="35px">Id</th>
                <th width="150px">Nombre</th>
                <th width="150px">Apellido</th>
                <th width="200px">Capacidades Especiales</th>
                <th width="120px">Estado Civil</th>
                <th width="120px">Genero</th>
                <th width="80px">Jubilado</th>
                <th>Direccion</th>
                <th width="150px">Conocido por</th>
            </tr>
        </thead>
        <tbody>
            <% for(Persona p: listaPersonas) {%>
            <tr>
                <td><%= p.getId_persona() %></td>
                <td><%= p.getNombres() %></td>
                <td><%= p.getApellidos()%></td>
                <td><%= p.getCapacidadesEspeciales() %></td>
                <td><%= p.getEstadoCivil() %></td>
                <td><%= p.getGenero() %></td>
                <td>No</td>
                <td><%= p.getDireccion() %></td>
                <td><%= p.getConocido_por() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <a class="boton" href="/guia01/">Regresar</a>
</body>
</html>