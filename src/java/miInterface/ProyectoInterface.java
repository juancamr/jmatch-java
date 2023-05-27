/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miInterface;

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
