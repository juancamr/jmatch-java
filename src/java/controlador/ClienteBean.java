
package controlador;

import javax.faces.bean.ManagedBean;
import modelo.Cliente;
import services.CRUDCliente;

@ManagedBean
public class ClienteBean {
    
    private Cliente cliente;
    
    public ClienteBean() {
        cliente = new Cliente();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void guardar() {
        CRUDCliente.getInstance().add(cliente);
    }
    
    public void editar() {
        CRUDCliente.getInstance().edit(cliente);
    }
}
