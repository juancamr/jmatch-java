<%-- 
    Document   : index
    Created on : 21/05/2023, 03:57:06 PM
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
        <h1>Mantenimiento de Cliente</h1>
        <a href="ControlCliente?accion=AgregarCliente">Agregar Cliente</a><br>
        <a href="ControlCliente?accion=ListarCliente">Listar Cliente</a><br>
        
        <h1>Mantenimiento de Proyecto</h1>
        <a href="ControlProyecto?accion=AgregarProyecto">Agregar Proyecto</a><br>
        <a href="ControlProyecto?accion=ListarProyecto">Listar Proyecto</a><br>
    </body>
</html>
