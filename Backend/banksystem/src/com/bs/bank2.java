package com.bs;
import java.util.*;

public class bank2 {
    String user_name;
    float user_amount;
//   Hashtable<String,Float> data=new Hashtable<String, Float>();
    class  Account {
        String name;
        float balance;
        long acc_Number;

        Account(String name,float balance,long acc_Number) {
            this.name = name;
            this.balance = balance;
            this.acc_Number = acc_Number;
        }
    }
    ArrayList<Account> list = new ArrayList<Account>();
    ArrayList<Integer> num = new ArrayList<Integer>();

    Scanner input=new Scanner(System.in);
//    boolean check_account(String user_name) {
//        boolean checked=false;
//        for( Account i: list) {
//            if (user_name.equals(i)) {
//                checked = true;
//                break;
//            }
//        }
//        return checked;
//    }
    static  long a = 1000;
    static  int limit = 1 ;

}
