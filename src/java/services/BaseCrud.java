package services;

import com.jmatch.config.DBConnection;
import interfaces.Querys;
import java.sql.*;
import modelo.Response;

abstract class BaseCrud<T> extends DBConnection implements Querys {

    Connection connection;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public BaseCrud() throws SQLException {
        connection = DBConnection.getInstance().getConnection();
        st = connection.createStatement();
    }
    
    public abstract Response<T> add(T data);
    public abstract Response<T> get(int id);
    public abstract Response<T> getAll();
    public abstract Response<T> getMany(int id);
    public abstract Response<T> edit(T data);
    public abstract Response<T> delete(int id);
    
    public abstract void makeRequest(T data, String sql) throws SQLException;
    public abstract T makeResponse(ResultSet rs) throws SQLException;
}

