package com.jmatch.routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jmatch.controlador.ProyectoControlador;

@WebServlet(name = "ProyectoControlador", urlPatterns = {
    "/proyectos", "/proyectos/agregar"
})
public class ProyectoRoute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String url = req.getServletPath();
        if (url.equals("/proyectos"))
            ProyectoControlador.getProyectos(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String url = req.getServletPath();
        if (url.equals("/proyectos/agregar"))
            ProyectoControlador.agregarProyecto(req, res);
    }

    @Override
    public String getServletInfo() {
        return "zzzzzzzzz...";
    }

}
