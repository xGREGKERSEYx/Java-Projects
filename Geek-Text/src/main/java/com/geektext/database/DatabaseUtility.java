// This class provides a utility for obtaining a connection to a MySQL database
// It follows a singleton pattern to reuse an existing connection if available
// The connection details are hardcoded for demonstration purposes

package com.geektext.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseUtility {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if(connection != null){//If the connection exists return the connection
            return connection;
        }else{ //If the connection is null, create a new connection
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/geek_text?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "Group21";
            
            try {//Load the MySQL JDBC driver
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
                // Create a new connection with the specified URL, user, and password
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return connection;// Return the obtained connection
    }
}
