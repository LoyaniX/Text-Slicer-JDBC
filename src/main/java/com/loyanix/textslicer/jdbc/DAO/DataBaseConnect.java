package com.loyanix.textslicer.jdbc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnect {

    public static Connection connection(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            String url = "jdbc:h2:~/FilesInfo";
            String user = "sa";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            System.out.println("Error to connect to DB");
            e.printStackTrace();
        }
        return connection;
    }
}
