package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchQuery {
    public void Search() throws Exception{
        Connection connection = (Connection) ForConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        Statement st = connection.createStatement();
            System.out.println("Enter Book name");
            String bn = scanner.next();
            String sql = "select * from Books where Book_name = '"+bn+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs == null)
        {
            System.out.println(" Not found");
        }


                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t" + rs.getString("Book_name"));
                }

        rs.close();

        st.close();
        connection.close();
    }

    }

