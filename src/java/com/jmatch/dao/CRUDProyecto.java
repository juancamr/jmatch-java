package com.jmatch.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.jmatch.modelo.Cliente;
import com.jmatch.modelo.Proyecto;

public class CRUDProyecto extends DBConnection {

    public boolean agregarProyecto(Proyecto proyecto) {
        return true;
    }

    public boolean editarProyecto(Proyecto proyecto) {
        return true;
    }

    public boolean eliminarProyecto(String codigo) {
        return true;
    }

    public Proyecto getProyecto(String codigo) {
        return new Proyecto();
    }

    public ArrayList<Proyecto> getProyectos() {
        String sql = "SELECT * FROM proyecto";
        ArrayList<Proyecto> listaProyecto = new ArrayList<>();
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setId_proyecto(PORT);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new ArrayList<Proyecto>();
    }

}
