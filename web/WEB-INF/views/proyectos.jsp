<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container mt-5">
    <h2 class="mb-3">Agregar Proyecto</h2>
    <form action="proyectos/agregar">
        <div class="form-floating mb-3">
            <input name="codigo" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Codigo</label>
        </div>
        <select class="form-select form-select-lg mb-3" aria-label="Default select example">
            <option selected>Selecciona un cliente</option>
            <c:forEach var="cliente" items="${listaClientes}">
                <option value="${cliente.getCodigo()}">${cliente.getNombre()}</option>
            </c:forEach>
        </select>
        <div class="form-floating mb-3">
            <input name="titulo" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Titulo</label>
        </div>
        <div class="form-floating mb-3">
            <input name="descripcion" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Descripcion</label>
        </div>
        <div class="form-floating mb-3">
            <input name="fecha_publicacion" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Fecha publicacion</label>
        </div>
        <div class="form-floating mb-3">
            <input name="fecha_limite" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Fecha limite</label>
        </div>
        <div class="form-floating mb-3">
            <input name="presupuesto" type="text" class="form-control" id="floatingInput" placeholder="Titulo">
            <label for="floatingInput">Presupuesto</label>
        </div>
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
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>