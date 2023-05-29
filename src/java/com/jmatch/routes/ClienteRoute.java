package com.jmatch.routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jmatch.controlador.ClienteControlador;

@WebServlet(name = "ControlCliente", urlPatterns = {
    "/clientes", "/clientes/agregar", "/clientes/editar", "/clientes/eliminar"
})
public class ClienteRoute extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String url = req.getServletPath();
        if (url.equals("/clientes"))
            ClienteControlador.getClientes(req, res);
        if (url.equals("/clientes/eliminar"))
            ClienteControlador.deleteCliente(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String url = req.getServletPath();
        if (url.equals("/clientes/agregar"))
            ClienteControlador.agregarCliente(req, res);
        if (url.equals("/clientes/editar")) {
            ClienteControlador.editarCliente(req, res);
        }
    }

    @Override
    public String getServletInfo() {
        return "zzzzzzzzz...";
    }

}
