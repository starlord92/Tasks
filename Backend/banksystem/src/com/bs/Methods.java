package com.bs;

import java.util.Iterator;

public class Methods extends Bank1{

    void create_account(String user_name,long user_account) {
        num.add(1000);
//        if (check_account(user_name)==true) {
//            System.out.println("account exists");
//        }

            list.add(new Account(user_name,0f,user_account));
            System.out.println(user_account);



    }

    void depositamount(long accNumber,float deposite_amount ,int limit) {
        float ans = 0f;
        if(deposite_amount < 500  ) {
            System.out.println("Minimum deposit is 500");
        } else if(deposite_amount > 50000) {
            System.out.println("Maximum deposit is 50,000");
        } else if(limit >  3 ) {
            System.out.println("Only Three deposits are allowed");
        }

        else {
            for(Account i : list) {
                if(i.acc_Number == accNumber) {
                    i.balance = i.balance + deposite_amount;
                    ans = i.balance ;
                }
            }
            System.out.println(ans);

        }


    }
    void balance(long accNumber) {
        float bal = 0;
        for (Account i : list) {
            if (i.acc_Number == accNumber) {
                bal = i.balance;

            }
        }
        System.out.println(bal);
    }
    void withdrawn_amount(long accNumber, float withdrawn_amount, int limit) {
        float res = 0f;
        if(withdrawn_amount < 1000){
            System.out.println("Minimum withdrawal amount is 1000");
        }
        else if(withdrawn_amount > 25000){
            System.out.println("Maximum withdrawal amount is 25000");
        }else if(limit >  3 ) {
            System.out.println("Only Three withdrawals are allowed");
        }
        else{
            for (Account i:list){
                if(i.acc_Number == accNumber){
                    i.balance = i.balance - withdrawn_amount;
                    res = i.balance;
                }
            }
            System.out.println(res);
        }
    }

    void transfer(long src_account, long trg_account, float amount){
        if(amount < 500){
            System.out.println("Minimum withdrawal amount is 1000 "+ trg_account);
        }
        else if(amount >= 30000){
            System.out.println("Maximum withdrawal amount is 30000 "+ trg_account);
        }else{
            if(isPresent(src_account) && isPresent(trg_account) && src_account != trg_account){
                for(Account i:list){
                    if(i.acc_Number == src_account){
                        i.balance = i.balance - amount;
                    }
                    if(i.acc_Number == trg_account){
                        i.balance = i.balance + amount;
                    }
                }
                System.out.println("Success");
            }else {
                System.out.println("Account does not exist!......Please provide a valid AccountNumber");
            }
        }
    }

    public boolean isPresent(long accountNumber) {
        for (Account i : list){
            if(i.acc_Number == accountNumber){
                return true;
            }
        }
        return false;
    }

    void quit_program() {
        System.exit(0);

    }




}
