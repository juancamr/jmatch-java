<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<h1>Clientes</h1>
<h3>Agregar Cliente</h3>
<form method="post" action="clientes/agregar">
    <label>ID_Cliente</label>
    <input type="text" name="codigo" required>
    <br>
    <label>Nombres</label>
    <input type="text" name="nombre" required><br>
    <label>Apellidos</label>
    <input type="text" name="apellido" required><br>
    <label>Telefono</label>
    <input type="text" name="telefono" required><br>
    <label>Correo</label>
    <input type="text" name="correo" required><br>
    <label>Contraseña</label>
    <input type="text" name="password" required><br>

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
            <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal${cliente.getCodigo()}">
                    Editar
                </button></td>
            <td><a href="clientes/eliminar?id=${cliente.getCodigo()}">Eliminar</a></td>
        </tr>
        <%@ include file="/WEB-INF/views/modals/modalEditarCliente.jsp" %>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
