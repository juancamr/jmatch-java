<%-- 
    Document   : agregar
    Created on : 21/05/2023, 03:59:55 PM
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
        <h1>Agregar Cliente</h1>
        <form method="post" action="ControlCliente">
            <label>ID_Cliente</label>
            <input type="text" name="codigo"><br>
            <label>Nombres</label>
            <input type="text" name="nombre"><br>
            <label>Apellidos</label>
            <input type="text" name="apellido"><br>
            <label>Telefono</label>
            <input type="text" name="telefono"><br>
            <label>Correo</label>
            <input type="text" name="correo"><br>
            <label>Contraseña</label>
            <input type="text" name="password"><br>
            
            <input type="submit" value="Agregar" name="accion">
        </form>
    </body>
</html>
