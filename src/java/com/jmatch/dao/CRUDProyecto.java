
package com.jmatch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.jmatch.interfaces.ProyectoInterface;
import com.jmatch.modelo.Cliente;
import com.jmatch.modelo.ProyectoDTO;

/**
 *
 * @author JOSE HUAVIL
 */
public class CRUDProyecto implements ProyectoInterface {

    DBConnection cn = new DBConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ProyectoDTO p;
    ArrayList<ProyectoDTO> lista = new ArrayList<>();
    Cliente e = new Cliente();
    CRUDCliente ed = new CRUDCliente();

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
