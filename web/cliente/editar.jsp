<%-- 
    Document   : editar
    Created on : 21/05/2023, 04:00:46 PM
    Author     : JOSE HUAVIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Cliente</h1>
        <form method="post" action="ControlCliente">
            <input type="hidden" name="codigo" value="${cli.getCodigo()}"><br>
            <label>Nombres</label>
            <input type="text" name="nombre" value="${cli.getNombre()}"><br>
            <label>Apellidos</label>
            <input type="text" name="apellido" value="${cli.getApellido()}"><br>
            <label>Telefono</label>
            <input type="text" name="telefono" value="${cli.getTelefono()}"><br>
            <label>Correo</label>
            <input type="text" name="correo" value="${cli.getCorreo()}"><br>
            <label>Contraseña</label>
            <input type="text" name="password" value="${cli.getPassword()}"><br>
            
            <input type="submit" value="Actualizar" name="accion">
        </form>
    </body>
</html>
