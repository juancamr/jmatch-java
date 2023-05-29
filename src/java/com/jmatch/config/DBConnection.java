package com.jmatch.config;

import com.jmatch.interfaces.DbCredentials;
import java.sql.*;

public class DBConnection implements DbCredentials {

    public static Connection connect;
    public Statement st;
    public PreparedStatement ps;
    public ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost:%s/%s", PORT, DBNAME);
            connect = DriverManager.getConnection(url, USER, PASSWD);
            st = connect.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connect.close();
    }

    public static String getStatusConnection() throws SQLException {
        return (connect != null && !connect.isClosed())
                ? "Conexion establecida"
                : "Error en la conexion";
    }

}
