
package com.jmatch.controlador;

import com.jmatch.dao.CRUDProyecto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProyectoControlador", urlPatterns = {
    "/proyectos", "proyectos/agregar", "proyectos/editar", "proyectos/eliminar"
})
public class ProyectoControlador extends HttpServlet {
    
    CRUDProyecto crudProyecto = new CRUDProyecto();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/proyectos")) {
            request.setAttribute("listaProyectos", crudProyecto);
            String pagina = "WEB-INF/views/proyectos.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
