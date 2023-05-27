<%-- 
    Document   : listar
    Created on : 21/05/2023, 04:00:32 PM
    Author     : JOSE HUAVIL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar Clientes</h1>
        <table border="1">
            <tr>
                <th>ID_Cliente</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Correo</th>
                <th>Contraseña</th>
                <th colspan="2">Acciones</th>
            </tr>
            <c:forEach var="lis" items="${lisCli}">
                <tr>
                    <td>${lis.getCodigo()}</td>
                    <td>${lis.getNombre()}</td>
                    <td>${lis.getApellido()}</td>
                    <td>${lis.getTelefono()}</td>
                    <td>${lis.getCorreo()}</td>
                    <td>${lis.getPassword()}</td>
                    <td><a href="ControlCliente?accion=Eliminar&codigo=${lis.getCodigo()}">Eliminar</a></td>
                    <td><a href="ControlCliente?accion=Modificar&codigo=${lis.getCodigo()}">Modificar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
