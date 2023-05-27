
package com.jmatch.dao;

import com.jmatch.interfaces.DbCredentials;
import java.sql.*;

public class DBConnection implements DbCredentials {
    String port = PORT;
    String dbname = DBNAME;
    String user = USER;
    String passwd = PASSWD;
    
    public static Connection connect;
    public Statement st;
    public PreparedStatement ps;
    public ResultSet rs;
    
    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost:%s/%s", port, dbname);
            connect = DriverManager.getConnection(url, user, passwd);
            st = connect.createStatement();
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void closeConnection() throws SQLException {
        connect.close();
    }
    
}
