package demo;
import java.sql.Connection;
import java.util.*;

public class Class {


        public static void main(String[] args) throws Exception{

            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);

            ViewQuery vq = new ViewQuery();
            Insert iq = new Insert();
            SearchQuery sq = new SearchQuery();
            Delete dq = new Delete();
            Connection connection = (Connection) ForConnection.getConnection();

            String con = "y";

            while(con.equalsIgnoreCase("y"))
            {
                System.out.println("Enter Choice:\n1.ViewData\n2.Insert Data\n3.Delete Data\n4.Search Data\n");
                int choice = scan.nextInt();

                switch(String.valueOf(choice))
                {

                    case "1":{vq.view();}       break;
                    case "2":{iq.insert();}     break;
                    case "3":{dq.delete();}     break;
                    case "4":{sq.Search();}     break;
                    default :{System.out.println("Wrong Choice");}  break;

                }
                System.out.println("\n\nContinue? (Y/N): ");
                con = scan2.nextLine();
            }


        }

    }


