/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmatch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jmatch.interfaces.ClienteInterface;
import com.jmatch.modelo.Cliente;

/**
 *
 * @author JOSE HUAVIL
 */
public class CRUDCliente implements ClienteInterface{
    
    DBConnection cn=new DBConnection();
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c;
    ArrayList<Cliente> lista = new ArrayList<>();

    @Override
    public boolean agregar(Cliente c) {
        try {
            String sql="insert into cliente (id_cliente, nombre, apellido, telefono, correo, password) values(?, ?, ?, ?, ?, ?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setInt(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    @Override
    public boolean modificar(Cliente c) {
        try {
            String sql="update cliente set id_cliente=?, nombre=?, apellido=?, telefono=?, correo=?, password=? where id_cliente = "+c.getCodigo();
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setInt(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }

    @Override
    public boolean eliminar(String cod) {
        try {
            String sql="delete from cliente where id_cliente="+cod;
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    @Override
    public Cliente listarUno(String cod) {
        try {
            String sql="select * from cliente where id_cliente="+cod;
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getInt("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        try {
            String sql="select * from cliente";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getInt("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setPassword(rs.getString("password"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;  
    }
    
}
