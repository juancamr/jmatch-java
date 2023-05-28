package com.jmatch.controlador;

import com.jmatch.dao.CRUDCliente;
import com.jmatch.dao.CRUDProyecto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jmatch.modelo.Proyecto;

@WebServlet(name = "ProyectoControlador", urlPatterns = {
    "/proyectos", "/proyectos/agregar"
})
public class ProyectoControlador extends HttpServlet {

    CRUDProyecto crudProyecto = new CRUDProyecto();
    CRUDCliente crudCliente = new CRUDCliente();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        
        if (url.equals("/proyectos")) {
            request.setAttribute("listaProyectos", crudProyecto.getProyectos());
            request.setAttribute("listaClientes", crudCliente.getClientes());
            String pagina = "WEB-INF/views/proyectos.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        
        if (url.equals("/proyectos/agregar")) {
            Proyecto proyecto = new Proyecto();
            proyecto.setIdProyecto(request.getParameter("codigo"));
            proyecto.setCliente(crudCliente.getCliente(request.getParameter("codigo_cliente")));
            proyecto.setTitulo(request.getParameter("titulo"));
            proyecto.setDescripcion(request.getParameter("descripcion"));
            proyecto.setFechaPublicacion(request.getParameter("fecha_publicacion"));
            proyecto.setFechaLimite(request.getParameter("fecha_limite"));
            proyecto.setPresupuesto(Double.parseDouble(request.getParameter("presupuesto")));
            crudProyecto.agregarProyecto(proyecto);
            response.sendRedirect("/proyectos");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
