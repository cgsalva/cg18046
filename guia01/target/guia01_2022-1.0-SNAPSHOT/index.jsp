<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <title>Inicio</title>
</head>
<body>
    <h1 class="titulo">Bolsa de Trabajo</h1>
    <form action="BolsaTrabajoServlet" method="post" class="formulario">
        <div class="contenedor-inputs">
            <div>
                <label for="id_persona">Id Persona:</label>
                <input type="number" name="id_persona" id="id_persona">
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" id="nombre">
                <label for="apellido">Apellido:</label>
                <input type="text" name="apellido" id="apellido">
                <label for="genero">Genero:</label>
                <input type="text" name="genero" id="genero">
                <label for="fecha_nacimiento">Fecha</label>
                <input type="text" name="fecha_nacimiento" id="fecha_nacimiento" value="YYYY/MM/DD">
            </div>
            <div>
                <label for="capacidades_especiales">Capacidades especiales:</label>
                <input type="text" name="capacidades_especiales" id="capacidades_especiales">
                <label for="estado_civil">Estado civil:</label>
                <input type="text" name="estado_civil" id="estado_civil">
                <label for="direccion">Direccion:</label>
                <input type="text" name="direccion" id="direccion">
                <legend>Jubilado</legend>
                Si<input type="radio" name="jubilado" value="1">
                No<input type="radio" name="jubilado" value="0" checked="">
                <label for="conocido_por">Conocido Por:</label>
                <input type="text" name="conocido_por" id="conocido_por">
            </div>
        </div>
        <div class="botones">
            <button class="boton">Agregar</button>
            <a href="BolsaTrabajoServlet?accion=listar" class="boton">Ver tabla</a>
        </div>
    </form>
</body>
</html>