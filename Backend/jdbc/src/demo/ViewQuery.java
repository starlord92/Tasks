package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ViewQuery {
    public static void view() throws Exception{
        Connection connection = (Connection) ForConnection.getConnection();
        Statement st = connection.createStatement();
        String sql = "select * from Books";
        st.executeQuery(sql);
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
    }
}
