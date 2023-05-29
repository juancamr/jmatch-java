package com.jmatch.controlador;

import com.jmatch.modelo.Cliente;
import com.jmatch.services.CRUDCliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteControlador {

    static CRUDCliente crudCliente = new CRUDCliente();

    public static void getClientes(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("listaClientes", crudCliente.getClientes());
        String pagina = "WEB-INF/views/clientes.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(pagina);
        rd.forward(req, res);
    }

    public static void deleteCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        crudCliente.eliminarCliente(id);
        res.sendRedirect("/clientes");
    }

    public static void agregarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        crudCliente.agregarCliente(makeCliente(req));
        res.sendRedirect("/clientes");
    }

    public static void editarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        crudCliente.editarCliente(makeCliente(req));
        res.sendRedirect("/clientes");
    }
    
    private static Cliente makeCliente(HttpServletRequest req) { //metodo que se usa en agregar y editar
        Cliente cliente = new Cliente();
        cliente.setCodigo(req.getParameter("codigo"));
        cliente.setNombre(req.getParameter("nombre"));
        cliente.setApellido(req.getParameter("apellido"));
        cliente.setTelefono(Integer.parseInt(req.getParameter("telefono")));
        cliente.setCorreo(req.getParameter("correo"));
        cliente.setPassword(req.getParameter("password"));
        return cliente;
    }
}
