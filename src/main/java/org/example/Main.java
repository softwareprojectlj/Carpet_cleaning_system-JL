package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printMenu(){
       System.out.println("***************welcome to our Cleaning services for carpets and covers***************");
       System.out.println("\t\tif you are admin Click 1  but if you are customer Click 2\t\t");
       System.out.println("\t\tif you went to exit click 3\t\t");
       System.out.println("\t\tplease enter your choice >-< :");
    }
    public static void invoiceP(){
        System.out.println("|\tCustomer name\t|\tProduct name\t|\tAddress\t|\tPrice\t|\tDate\t|");

    }
    public static void main(String[] args) {
      ArrayList<Admin> admins = new ArrayList<Admin>();
      ArrayList<Product> productarray = new ArrayList<Product>();
        Admin a = new Admin();
        Product p = new Product();
        Scanner sc= new Scanner(System.in);
        printMenu();
        int C= Integer.parseInt(sc.nextLine());

        switch (C) {
            case 1:
                System.out.println("enter the email:");
                String email = sc.nextLine();
                a.email = email;
                System.out.println("enter the password:");
                String password = sc.nextLine();
                a.password = password;
                if (a.checkemail(email) && a.checkpass(password) )
                     {
                         admins.add(a);
                         System.out.println("you are logged in");
                         System.out.println(admins);
                         System.out.println(a);
                     }
               else{System.out.println("Wrong password or long email");}
                break;
            case 2:
                System.out.println("Customer");
                System.out.println("1-add carpet               2-add covers         ");
                System.out.println("please enter your choice:");
                int pc = Integer.parseInt(sc.nextLine());
                if (pc == 1) {
                    p.setData(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
                } else if (pc == 2) {
                    System.out.println("covers");
                }
                System.out.println("your invoice ^-^ :");
                invoiceP();
                System.out.print("|\t");
                System.out.print("Jana Barakeh");
                System.out.print("\t|");
                System.out.print("\t");
                System.out.print(p.name);
                System.out.print("\t|");
                System.out.print("\t");
                System.out.print("Tulkarem");
                System.out.print("\t|");
                System.out.print("\t");
                System.out.print(p.getprice(p.width, p.height));
                System.out.print("\t|");
                System.out.print("\t");
                System.out.print(p.dayfinish);
                System.out.print("\t|");
                break;
            case 3:
                System.out.println("we are so glad to use our system ");
                System.out.println(" ^-^ Thank You ^-^ ");
                break;
            }
        }
    }
