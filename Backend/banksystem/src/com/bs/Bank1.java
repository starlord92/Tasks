package com.bs;
import java.util.Scanner;
public class Bank1 extends bank2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Methods obj2 = new Methods();
        menu  obj=new menu();
        String Case="";
        while(Case!="E") {
            Case = input.next().toLowerCase();
            obj.switchCase(Case);
        }

    }
}

