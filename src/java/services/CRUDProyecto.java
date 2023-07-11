package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proyecto;
import modelo.Response;

public class CRUDProyecto extends BaseCrud<Proyecto> {

    @Override
    public Response<Proyecto> add(Proyecto data) {
        try {
            makeRequest(data, ADD_PROYECTO);
            return new Response(true);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Proyecto> get(int id) {
        try {
            rs = st.executeQuery(GET_PROYECTO);
            Proyecto proyecto = new Proyecto();
            if (rs.next()) {
                proyecto = makeResponse(rs);
            }
            return new Response(true, proyecto);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Proyecto> getAll() {
        try {
            List<Proyecto> listaProyectos = new ArrayList<>();
            rs = st.executeQuery(GET_ALL_PROYECTOS);
            while (rs.next()) {
                Proyecto proyecto = makeResponse(rs);
                listaProyectos.add(proyecto);
            }
            return new Response(true, listaProyectos);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Proyecto> getMany(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<Proyecto> edit(Proyecto proyecto) {
        try {
            makeRequest(proyecto, EDIT_PROYECTO);
            return new Response(true);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Proyecto> delete(int id) {
        try {
            ps = connection.prepareStatement(DELETE_PROYECTO + id);
            ps.executeUpdate();
            return new Response(true);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public void makeRequest(Proyecto proyecto, String sql) throws SQLException {

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
    }

    @Override
    public Proyecto makeResponse(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
