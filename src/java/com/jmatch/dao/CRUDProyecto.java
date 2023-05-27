
package com.jmatch.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.jmatch.modelo.Cliente;
import com.jmatch.modelo.ProyectoDTO;

public class CRUDProyecto {

    public boolean agregar(ProyectoDTO c) {
        return true;
    }

    public boolean modificar(ProyectoDTO c) {
        return true;
    }

    public boolean eliminar(String cod) {
        return true;
    }

    public ProyectoDTO listarUno(String cod) {
        return new ProyectoDTO();
    }

    public ArrayList<ProyectoDTO> listarTodos() {
        return new ArrayList<ProyectoDTO>();
    }

}
