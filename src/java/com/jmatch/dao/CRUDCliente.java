package com.jmatch.dao;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import com.jmatch.modelo.Cliente;

public class CRUDCliente extends DBConnection {

    public boolean agregarCliente(Cliente cliente) {
        try {
            String sql = "insert into cliente (id_cliente, nombre, apellido, telefono, correo, password)"
                    + " values(?, ?, ?, ?, ?, ?)";
            ps = connect.prepareStatement(sql);
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean editarCliente(Cliente cliente) {
        try {
            String sql = "update cliente set id_cliente=?, nombre=?, apellido=?, telefono=?, correo=?, password=? "
                    + "where id_cliente = " + cliente.getCodigo();
            ps = connect.prepareStatement(sql);
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean eliminarCliente(String cod) {
        try {
            String sql = "delete from cliente where id_cliente=" + cod;
            st.executeQuery(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Cliente getCliente(String cod) {
        String sql = "select * from cliente where id_cliente=" + cod;
        Cliente cliente = new Cliente();
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                cliente.setCodigo(rs.getString("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setPassword(rs.getString("password"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cliente;
    }

    public ArrayList<Cliente> listarTodos() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getString("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setPassword(rs.getString("password"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaClientes;
    }

}
