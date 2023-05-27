
package com.jmatch.interfaces;

import java.util.ArrayList;
import com.jmatch.modelo.ProyectoDTO;


/**
 *
 * @author JOSE HUAVIL
 */
public interface ProyectoInterface {
    public boolean agregar(ProyectoDTO p);  
    public boolean modificar(ProyectoDTO p);
    public boolean eliminar(String cod);
    public ProyectoDTO listarUno(String cod);
    public ArrayList<ProyectoDTO> listarTodos();
}
