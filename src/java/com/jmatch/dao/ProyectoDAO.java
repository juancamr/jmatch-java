/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmatch.dao;

import com.jmatch.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import miInterface.ProyectoInterface;
import com.jmatch.modelo.Cliente;
import com.jmatch.modelo.ProyectoDTO;

/**
 *
 * @author JOSE HUAVIL
 */
public class ProyectoDAO implements ProyectoInterface{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ProyectoDTO p;
    ArrayList<ProyectoDTO> lista = new ArrayList<>();
    Cliente e = new Cliente();
    ClienteDAO ed = new ClienteDAO();
    

    @Override
    public boolean agregar(ProyectoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ProyectoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoDTO listarUno(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProyectoDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
