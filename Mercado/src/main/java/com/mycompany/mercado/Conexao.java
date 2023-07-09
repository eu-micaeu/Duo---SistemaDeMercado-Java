package com.mycompany.mercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://192.168.0.20:3306/mercado";
        String u = "micael";
        String p = "12345678";
        Connection conexao = DriverManager.getConnection(url, u, p);
        return conexao;
    }
    
}
