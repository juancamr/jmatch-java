/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miInterface;

import java.util.ArrayList;
import com.jmatch.modelo.Cliente;

/**
 *
 * @author JOSE HUAVIL
 */
public interface ClienteInterface {
    public boolean agregar(Cliente c);  
    public boolean modificar(Cliente c);
    public boolean eliminar(String cod);
    public Cliente listarUno(String cod);
    public ArrayList<Cliente> listarTodos();
}
