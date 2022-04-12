<<<<<<< HEAD
package com.connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.sql.*;

public class  ForConnection{
    private  static Logger logger= LoggerFactory.getLogger(ForConnection.class);
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi"
                    , "root", "admin");
            logger.info("Connection Object "+con.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


}
=======
package com.connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.sql.*;

public class  ForConnection{
    private  static Logger logger= LoggerFactory.getLogger(ForConnection.class);
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi"
                    , "root", "admin");
            logger.info("Connection Object "+con.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


}
>>>>>>> 462d7d809c697d99b10f64ea1c43cc46231c114d
