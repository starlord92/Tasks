package demo;
import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void insert() throws Exception{
            Statement stmt = null;
            Scanner scanner = new Scanner(System.in);
            int Book_id =scanner.nextInt();
            String Book_name = scanner.next();
            String Book_Author = scanner.next();
            Connection connection = (Connection) ForConnection.getConnection();
            stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books" + "(Book_id,Book_name,Book_Author)" + "VALUES (?,?,?)");
            preparedStatement.setInt(1,Book_id);
            preparedStatement.setString(2,Book_name);
            preparedStatement.setString(3,Book_Author);
            preparedStatement.execute();


        }
    }


