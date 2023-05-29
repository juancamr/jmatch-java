package com.jmatch.services;

import com.jmatch.config.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jmatch.modelo.Cliente;
import com.jmatch.modelo.Proyecto;

public class CRUDProyecto extends DBConnection {

    public boolean agregarProyecto(Proyecto proyecto) {
String sql = "INSERT INTO proyecto(id_proyecto,id_cliente, Titulo_Proyecto, Descripcion_Proyecto, Fecha_Publicacion, Fecha_Limite, Presupuesto_Proyecto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connect.prepareStatement(sql);
            ps.setString(1, proyecto.getIdProyecto());
            ps.setString(2, proyecto.getCliente().getCodigo());
            ps.setString(3, proyecto.getTitulo());
            ps.setString(4, proyecto.getDescripcion());
            ps.setString(5, proyecto.getFechaPublicacion());
            ps.setString(6, proyecto.getFechaLimite());
            ps.setDouble(7, proyecto.getPresupuesto());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean editarProyecto(Proyecto proyecto) {
        try {
            String sql = "update proyecto set id_proyecto=?, id_cliente=?, Titulo_Proyecto=?, Descripcion_Proyecto=?, Fecha_Publicacion=?, Fecha_Limite=?, Presupuesto_Proyecto=? "
                    + "where id_proyecto = \"" + proyecto.getIdProyecto()+ "\"";
            ps = connect.prepareStatement(sql);
            ps.setString(1, proyecto.getIdProyecto());
            ps.setString(2, proyecto.getCliente().getCodigo());
            ps.setString(3, proyecto.getTitulo());
            ps.setString(4, proyecto.getDescripcion());
            ps.setString(5, proyecto.getFechaPublicacion());
            ps.setString(6, proyecto.getFechaLimite());
            ps.setDouble(7, proyecto.getPresupuesto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean eliminarProyecto(String codigo) {
        try {
            String sql = "delete from proyecto where id_proyecto=\"" + codigo + "\"";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public Proyecto getProyecto(String codigo) {
        String sql = "select * from proyecto where id_proyecto=\"" + codigo + "\"";
        Proyecto proyecto = new Proyecto();
        try {
            rs = st.executeQuery(sql);  
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getString("id_proyecto"));
                //proyecto.setCliente(rs.get("id_cliente"));
                proyecto.setTitulo(rs.getString("Titulo_Proyecto"));
                proyecto.setDescripcion(rs.getString("Descripcion_Proyecto"));
                proyecto.setFechaPublicacion(rs.getString("Fecha_Publicacion"));
                proyecto.setFechaLimite(rs.getString("Fecha_Limite"));
                proyecto.setPresupuesto(rs.getInt("Presupuesto_Proyecto"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
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
