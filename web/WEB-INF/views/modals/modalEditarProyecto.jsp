<div class="modal fade" id="modalProyecto${proyecto.getIdProyecto()}" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="proyectos/editar" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">${proyecto.getTitulo()}</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-floating my-3">
                        <input value="${proyecto.getIdProyecto()}" name="codigo" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Codigo</label>
                    </div>
                    <select name="codigo_cliente" required class="form-select form-select-lg mb-3" aria-label="Default select example">
                        
                        <c:forEach var="cliente" items="${listaClientes}">
                            <option <c:if test="${cliente.getCodigo() == proyecto.getCliente().getCodigo()}"> selected </c:if> value="${cliente.getCodigo()}">${cliente.getNombre()}</option>
                        </c:forEach>
                    </select>
                    <div class="form-floating mb-3">
                        <input value="${proyecto.getTitulo()}" name="titulo" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Titulo</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input value="${proyecto.getDescripcion()}" name="descripcion" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Descripcion</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input value="${proyecto.getFechaPublicacion()}" name="fecha_publicacion" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Fecha publicacion</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input value="${proyecto.getFechaLimite()}" name="fecha_limite" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Fecha limite</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input  value="${proyecto.getPresupuesto()}" name="presupuesto" type="text" required class="form-control" id="floatingInput" placeholder="Titulo">
                        <label for="floatingInput">Presupuesto</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
            </form>
        </div>
    </div>
</div>