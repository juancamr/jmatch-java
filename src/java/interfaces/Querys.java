/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author jcmro
 */
public interface Querys {
    
    //cliente
    String ADD_CLIENTE = "insert into cliente (id_cliente, nombre, apellido, telefono, correo, password)"
                    + " values(?, ?, ?, ?, ?, ?)";
    String EDIT_CLIENTE = "update cliente set nombre=?, apellido=?, telefono=?, correo=?, password=? "
                    + "where id_cliente = \"";
    String GET_CLIENTE = "select * from cliente where id_cliente=\"";
    String GET_ALL_CLIENTES = "select * from cliente";

    
    String ADD_PROYECTO = "INSERT INTO proyecto(id_proyecto,id_cliente, Titulo_Proyecto, Descripcion_Proyecto, Fecha_Publicacion, Fecha_Limite, Presupuesto_Proyecto)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    String EDIT_PROYECTO = "";
    String GET_PROYECTO = "select * from proyecto where id_proyecto=\"";
    String GET_ALL_PROYECTOS = "";
    String DELETE_PROYECTO = "";
}