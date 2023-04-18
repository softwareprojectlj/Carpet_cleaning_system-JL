package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void printMenu() {

        System.out.println("************ >-< welcome to our Cleaning services for carpets and covers >-< **************");
        System.out.println("\t\t\t\t\t\t\tif you are admin Click 1\t\t");
        System.out.println("\t\t\t\t\t\t\tif you are want to add Product Click 2\t\t");
        System.out.println("\t\t\t\t\t\t\tif you are want to Find a Product Click 6\t\t");
        System.out.println("\t\t\t\t\t\t\tif you are want to see your invoice click 3\t\t");
        System.out.println("\t\t\t\t\t\t\tif you want to see the list of Worker click 4\t\t");
        System.out.println("\t\t\t\t\t\t\tif you want to exit click 5\t\t");
        System.out.println("\t\t\t\t\t\t\tplease enter your choice >-< :\t\t");
    }
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        printMenu();
        ArrayList<String> product=new ArrayList<String>();
        int C= Integer.parseInt(sc.nextLine());
        if(C==2) {
            Product p1= new Product();
            p1.readfromuser();
        }
        else if(C==3) {
            invoiceCC i1=new invoiceCC();
            i1.readfromuser();
        }
        else if(C==4){
            Worker W2=new Worker();
            W2.readfromuser();
        }
        else if(C==5){
            System.out.println("we are so glad to use our system ");
            System.out.println(" ^-^ Thank You ^-^ ");
        }
        else if(C==6){
            Product p2= new Product();
            p2.Findproduct();
        }
        else if(C==7){
            Product p3= new Product();
         /*   System.out.println("enter the id of the product : \t");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("enter the id of the product : \t");*/
            p3.Distribute();
        }
        else if(C==8)
        {
            Product p4=new Product();
            p4.Deleteproduct(product,sc);
        }
        else if(C==9)
        {
            Product p5=new Product();
            p5. updateproduct(product,sc);
        }
        /*
        pdfinvoice i = new pdfinvoice();
        i.getdata();
        i.WriteInvoice();
        System.out.println("Invoice Generated!");*/
    }
}
