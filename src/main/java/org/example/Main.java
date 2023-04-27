package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void printMenu() {

        System.out.println("\t\t\t\t\t\t\t welcome to our Cleaning services for carpets and covers \t\t");
        System.out.println("\t\t\t\t\t\t\t Admin login\t\t");
        System.out.println("\t\t\t\t\t\t\t [1] Product  \t\t");
        System.out.println("\t\t\t\t\t\t\t [2] Distribute the product \t\t");
        System.out.println("\t\t\t\t\t\t\t [3] print invoice  \t\t");
       // System.out.println("\t\t\t\t\t\t\t [3] if you want to see the list of Worker click \t\t");
        System.out.println("\t\t\t\t\t\t\t [4] Exit \t\t");
    }
    public static void productMenu() {
        System.out.println("\t\t\t\t\t\t\t[1] Add product\t\t");
        System.out.println("\t\t\t\t\t\t\t[2] Update product\t\t");
        System.out.println("\t\t\t\t\t\t\t[3] Delete product\t\t");
        System.out.println("\t\t\t\t\t\t\t[4] Find Product\t\t");
    }

    public static void main(String[] args) throws IOException {
        printMenu();
        ArrayList<String> product=new ArrayList<String>();
        ArrayList<String> worker=new ArrayList<String>();
        Product p= new Product();
        invoiceCC I=new invoiceCC();
        Worker W=new Worker();
        Scanner input = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter your choice: ");
                    int choice = Integer.parseInt(input.nextLine());

                    switch (choice) {
                        case 1:
                            productMenu();
                            int pchoice= Integer.parseInt(input.nextLine());
                            if(pchoice==1)
                            {
                         /*       System.out.println("the number of product you want to add : ");
                                int nump= Integer.parseInt(input.nextLine());
                                int num=0;
                              do {*/
                                    p.readfromuser();
                         /*           num++;
                                    System.out.println("num = "+num);
                                    System.out.println("nump = "+nump);
                               }while(num==nump);{break;}*/
                            }
                            else if(pchoice==2)
                            { p.updateproduct(product);}
                            else if(pchoice==3)
                            {   p.Deleteproduct(product);}
                            else if(pchoice==4)
                            { p.Findproduct();}
                            break;
                        case 2:
                            p.listofworker();
                            p.Distribute(worker);
                            break;
                        case 3:
                            I.readfromuser();
                         //   W.readfromuser();
                            break;
                        case 4:
                            System.out.println("\t we are so glad to use our system \t");
                            System.out.println("\t ^-^ Thank You ^-^ \t");
                            return;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
                }
            }
        }
