package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("software's project!");
        Admin Ad =new Admin();
        System.out.println("enter the email:");
        String email=sc.nextLine();
        Ad.email=email;
        System.out.println("enter the password:");
        String password = sc.nextLine();
        Ad.password=password;
        Ad.checkemail(email);
        Ad.checkpass(password);
        System.out.println("you are logged in");
    }

}