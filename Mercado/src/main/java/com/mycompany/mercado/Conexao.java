package com.mycompany.mercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://root:Vlat1huPICHWWWNlFxGI@containers-us-west-196.railway.app:5583/mercado";
        String u = "root";
        String p = "Vlat1huPICHWWWNlFxGI";
        Connection conexao = DriverManager.getConnection(url, u, p);
        return conexao;
    }
    
}
