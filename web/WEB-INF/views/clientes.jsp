<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Clientes</h1>
<h3>Agregar Cliente</h3>
<form method="post" action="clientes/agregar">
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

    <button type="submit">Agregar</button>
</form>
<table border="1" class="mt-3">
    <tr>
        <th>ID_Cliente</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Telefono</th>
        <th>Correo</th>
        <th>Contraseña</th>
        <th colspan="2">Acciones</th>
    </tr>

    <c:forEach var="cliente" items="${listaClientes}">
        <tr>
            <td>${cliente.getCodigo()}</td>
            <td>${cliente.getNombre()}</td>
            <td>${cliente.getApellido()}</td>
            <td>${cliente.getTelefono()}</td>
            <td>${cliente.getCorreo()}</td>
            <td>${cliente.getPassword()}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
