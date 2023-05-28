<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<form action="proyectos/agregar">
    
</form>

<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Cliente</th>
            <th scope="col">Titulo</th>
            <th scope="col">Descripcion</th>
            <th scope="col">Fecha publicacion</th>
            <th scope="col">Fecha limite</th>
            <th scope="col">Prespuesto</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="proyecto" items="${listaProyectos}" >
            <tr>
                <th scope="row">${proyecto.getIdProyecto}</th>
                <td>${proyecto.getCliente().getNombre()}</td>
                <td>${proyecto.getTitulo()}</td>
                <td>${proyecto.getDescripcion()}</td>
                <td>${proyecto.getFechaPublicacion}</td>
                <td>${proyecto.getFechaLimite}</td>
                <td>${proyecto.getPresupuesto}</td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>