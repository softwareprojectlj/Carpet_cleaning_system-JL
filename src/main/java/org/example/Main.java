package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printMenu(){
       System.out.println("welcome to our Cleaning services for carpets and covers");
       System.out.println("if you are admin Click1  but if you are customer Click2");
       System.out.println("enter your choice");
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        printMenu();
        int C= Integer.parseInt(sc.nextLine());
        if(C == 1)
        {
        ArrayList<String> admins = new ArrayList<String>();
        System.out.println("enter the email:");
        String email=sc.nextLine();
        admins.add(email);
        System.out.println("enter the password:");
        String password = sc.nextLine();
        admins.add(password);
        /* admins.checkemail(email);
           Ad.checkpass(password); */
        System.out.println("you are logged in");}
        else if(C == 2){
            System.out.println("Customer");
        }
        else
            System.out.println("software's project!");
    }

}