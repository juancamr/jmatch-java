<div class="modal fade" id="modal${cliente.getCodigo()}" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="clientes/editar" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">${cliente.getNombre()}</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label>ID_Cliente</label>
                    <input type="text" name="codigo" disabled value="${cliente.getCodigo()}">
                    <br>
                    <label>Nombres</label>
                    <input type="text" name="nombre" value="${cliente.getNombre()}"><br>
                    <label>Apellidos</label>
                    <input type="text" name="apellido" value="${cliente.getApellido()}"><br>
                    <label>Telefono</label>
                    <input type="text" name="telefono" value="${cliente.getTelefono()}"><br>
                    <label>Correo</label>
                    <input type="text" name="correo" value="${cliente.getCorreo()}"><br>
                    <label>Contraseña</label>
                    <input type="text" name="password" value="${cliente.getPassword()}"><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
            </form>
        </div>
    </div>
</div>