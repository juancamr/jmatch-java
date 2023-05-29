package com.jmatch.controlador;

import com.jmatch.modelo.Proyecto;
import com.jmatch.services.CRUDCliente;
import com.jmatch.services.CRUDProyecto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProyectoControlador {

    static CRUDProyecto crudProyecto = new CRUDProyecto();
    static CRUDCliente crudCliente = new CRUDCliente();

    public static void getProyectos(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("listaProyectos", crudProyecto.getProyectos());
        req.setAttribute("listaClientes", crudCliente.getClientes());
        String pagina = "WEB-INF/views/proyectos.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(pagina);
        rd.forward(req, res);
    }
    
    public static void agregarProyecto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        crudProyecto.agregarProyecto(makeProyecto(req));
        res.sendRedirect("/proyectos");
    }

    private static Proyecto makeProyecto(HttpServletRequest req) { //metodo que se usara para agregar y editar
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(req.getParameter("codigo"));
        proyecto.setCliente(crudCliente.getCliente(req.getParameter("codigo_cliente")));
        proyecto.setTitulo(req.getParameter("titulo"));
        proyecto.setDescripcion(req.getParameter("descripcion"));
        proyecto.setFechaPublicacion(req.getParameter("fecha_publicacion"));
        proyecto.setFechaLimite(req.getParameter("fecha_limite"));
        proyecto.setPresupuesto(Double.parseDouble(req.getParameter("presupuesto")));
        return proyecto;
    }
}
