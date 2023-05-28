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
        CRUDCliente crudCliente = new CRUDCliente();
        ArrayList<Proyecto> listaProyecto = new ArrayList<>();
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getString(1));
                proyecto.setCliente(crudCliente.getCliente(rs.getString(2)));
                proyecto.setTitulo(rs.getString(3));
                proyecto.setDescripcion(rs.getString(4));
                proyecto.setFechaPublicacion(rs.getString(5));
                proyecto.setFechaLimite(rs.getString(6));
                proyecto.setPresupuesto(rs.getDouble(7));
                listaProyecto.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaProyecto;
    }

}
