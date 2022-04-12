package demo;

import java.sql.DriverManager;
import java.sql.*;

public class ForConnection {


    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/book"
                    , "root", "admin"
            );
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }}

