package com.bs;
import java.util.*;
public class menu extends Methods{
    void switchCase(String Case) {

        switch (Case){
            case "create":
                String user_name = input.next();
                a = a+1;
                create_account(user_name,a);
                break;
            case "deposit":
                long accNumber =input.nextLong();
                user_amount = input.nextFloat();
                depositamount(accNumber,user_amount,limit);
                limit = limit+1;
                break;
            case "balance":
                accNumber = input.nextLong();
                balance(accNumber);
                break;
            case "withdraw":
                accNumber = input.nextLong();
                user_amount=input.nextFloat();
                withdrawn_amount(accNumber,user_amount,limit);
                limit = limit+1;
                break;
            case "transfer":
                long src_account = input.nextLong();
                long trg_account = input.nextLong();;
                float amount = input.nextFloat();;
                transfer(src_account,trg_account,amount);
                break;
                case "E":
                    quit_program();
                break;
            default:

        }
}}
