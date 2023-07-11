package services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;
import modelo.Response;

public class CRUDCliente extends BaseCrud<Cliente> {

    public static CRUDCliente crudCliente;

    @Override
    public Response<Cliente> add(Cliente cliente) {
        try {
            makeRequest(cliente, ADD_CLIENTE);
            return new Response(true, "Cliente agregado con exito");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Cliente> get(int cod) {
        try {
            rs = st.executeQuery(GET_CLIENTE + cod);
            Cliente cliente = new Cliente();
            if (rs.next()) {
                cliente = makeResponse(rs);
            }
            rs.close();
            return new Response(true, cliente);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Cliente> getAll() {
        try {
            List<Cliente> listaClientes = new ArrayList<>();
            rs = st.executeQuery(GET_ALL_CLIENTES);
            while (rs.next()) {
                Cliente cliente = makeResponse(rs);
                listaClientes.add(cliente);
            }
            return new Response(true, listaClientes);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Cliente> getMany(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<Cliente> edit(Cliente cliente) {
        try {
            String sql = EDIT_CLIENTE + cliente.getCodigo();
            makeRequest(cliente, sql);
            return new Response(true);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public Response<Cliente> delete(int cod) {

        try {
            String sql = "delete from cliente where id_cliente=\"" + cod + "\"";
            st.executeUpdate(sql);
            return new Response(true);
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(false);
        }
    }

    @Override
    public void makeRequest(Cliente cliente, String sql) throws SQLException {
        ps = connect.prepareStatement(sql);
        ps.setString(1, cliente.getCodigo());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getApellido());
        ps.setString(4, cliente.getTelefono());
        ps.setString(5, cliente.getCorreo());
        ps.setString(6, cliente.getPassword());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Cliente makeResponse(ResultSet rs) throws SQLException {
        return new Cliente.Builder()
                .codigo(rs.getString(1))
                .nombre(rs.getString(2))
                .apellido(rs.getString(3))
                .telefono(rs.getString(4))
                .correo(rs.getString(5))
                .password(rs.getString(6))
                .build();
    }

    public static CRUDCliente getInstance() {
        if (crudCliente == null) {
            crudCliente = new CRUDCliente();
        }
        return crudCliente;
    }

}
