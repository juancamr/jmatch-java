
package com.jmatch.interfaces;

import java.util.ArrayList;
import com.jmatch.modelo.Cliente;

public interface ClienteInterface {
    public boolean agregar(Cliente c);  
    public boolean modificar(Cliente c);
    public boolean eliminar(String cod);
    public Cliente listarUno(String cod);
    public ArrayList<Cliente> listarTodos();
}
