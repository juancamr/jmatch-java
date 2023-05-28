package com.jmatch.controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jmatch.modelo.Cliente;
import com.jmatch.dao.CRUDCliente;
import com.jmatch.dao.DBConnection;
import java.sql.SQLException;

@WebServlet(name = "ControlCliente", urlPatterns = {
    "/clientes", "/clientes/agregar", "/clientes/editar", "/clientes/eliminar"
})
public class ClienteControlador extends HttpServlet {

    CRUDCliente crudCliente = new CRUDCliente();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/clientes")) {
            request.setAttribute("listaClientes", crudCliente.getClientes());
            String pagina = "WEB-INF/views/clientes.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }

        if (url.equals("/clientes/eliminar")) {
            String id = request.getParameter("id");
            System.out.println(id);
            crudCliente.eliminarCliente(id);
            response.sendRedirect("/clientes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();

        if (url.equals("/clientes/agregar")) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(request.getParameter("codigo"));
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            cliente.setCorreo(request.getParameter("correo"));
            cliente.setPassword(request.getParameter("password"));
            crudCliente.agregarCliente(cliente);
            response.sendRedirect("/clientes");
        }
        
        if (url.equals("/clientes/editar")) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(request.getParameter("codigo"));
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            cliente.setCorreo(request.getParameter("correo"));
            cliente.setPassword(request.getParameter("password"));
            crudCliente.editarCliente(cliente);
            response.sendRedirect("/clientes");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
