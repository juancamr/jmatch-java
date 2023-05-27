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

@WebServlet(name = "ControlCliente", urlPatterns = {"/ControlCliente"})
public class ClienteControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String data, pagina = "", cod, nom, ape, mail, pass;
        int tlf, listado = 0;
        Cliente c;
        CRUDCliente cd = new CRUDCliente();
        ArrayList<Cliente> lis = new ArrayList<>();
        try {
            System.out.println(DBConnection.getStatusConnection());
        } catch (SQLException e) {
            System.out.println(e);
        }

        data = request.getParameter("accion");

        if (data.equalsIgnoreCase("AgregarCliente")) {
            pagina = "cliente/agregar.jsp";
        }

        if (data.equalsIgnoreCase("Agregar")) {
            cod = request.getParameter("codigo");
            nom = request.getParameter("nombre");
            ape = request.getParameter("apellido");
            tlf = Integer.parseInt(request.getParameter("telefono"));
            mail = request.getParameter("correo");
            pass = request.getParameter("password");
            c = new Cliente(cod, nom, ape, tlf, mail, pass);
            cd.agregarCliente(c);
            listado = 1;
        }

        if (data.equalsIgnoreCase("ListarCliente")) {
            listado = 1;
        }

        if (data.equalsIgnoreCase("Eliminar")) {
            cod = request.getParameter("codigo");
            cd.eliminarCliente(cod);
            listado = 1;
        }

        if (data.equalsIgnoreCase("Modificar")) {
            cod = request.getParameter("codigo");
            c = cd.getCliente(cod);
            request.setAttribute("cli", c);
            pagina = "cliente/editar.jsp";
        }

        if (data.equalsIgnoreCase("Actualizar")) {
            cod = request.getParameter("codigo");
            nom = request.getParameter("nombre");
            ape = request.getParameter("apellido");
            tlf = Integer.parseInt(request.getParameter("telefono"));
            mail = request.getParameter("correo");
            pass = request.getParameter("password");
            c = new Cliente(cod, nom, ape, tlf, mail, pass);
            cd.editarCliente(c);
            listado = 1;
        }

        if (listado == 1) {
            lis = cd.listarTodos();
            request.setAttribute("lisCli", lis);
            pagina = "cliente/listar.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
