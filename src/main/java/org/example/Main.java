package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static String filenamecustomer = "customerdata.txt";
    public static String filenameadmin = "Logindata.txt";
    public static int count;
    public static String id1,name1,phone1,address1;
    public static Scanner in=new Scanner(System.in);
    public static String Username,Password;

    public static void main(String[] args) {

        createNewFileWithHeaders();
        readlogindata();
        verify(Username,Password);

    }


    public static void readlogindata() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter Username :   ");
        Username = input1.next();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter Password :   ");
        Password = input2.next();

    }

    public static void verify(String nameuser, String pass){
        String line;
        String data[];
        String d=",";
        try {

            BufferedReader reader=new BufferedReader(new FileReader("Logindata.txt"));

            while ((line=reader.readLine())!=null){
                data = line.split(d);
                if(data[0].equals(nameuser)&& data[1].equals(pass)){

                        System.out.println("------------------------");
                        System.out.println(PURPLE
                            + "   Welcome Mis " +nameuser
                            + RESET);
                        System.out.println("------------------------");
                        System.out.println("<MENU>");
                        System.out.println("[1] Add Customer .");
                        System.out.println("[2] Update Customer .");
                        System.out.println("[3] Delete Customer .");
                        System.out.println("[4] List The Customer By Name .");
                        System.out.println("[5] Exit .");
                        int x=in.nextInt();
                        Customer customer=new Customer();
                        ArrayList<String> arrayList=new ArrayList<String>();
                        if(x==1){

                            customer.readfromuser();
                        } else if (x==2) {

                            customer.updateRecord(arrayList,in);

                        }
                        else if (x==3) {

                            customer.deleteRecordById(arrayList,in);

                        }
                        else if (x==4) {

                            customer.getUserById(in);

                        }

                        else if (x==5) {
                            System.exit(0);
                        }

                }


            }}
            catch (Exception e){
                System.out.println(e);
            }


        }

    //create file code   لما احتاجهه خليه احتياط + بعد فيه عدد أسطر الفايل
    public static void createNewFileWithHeaders() {
        File database = new File(filenamecustomer);

        try {

            if (database.createNewFile() == true) {

                try {
                    FileWriter writer = new FileWriter(filenamecustomer, true);
                    //writer.append("Customers name" + "," + "Customers phone" + "," + "Customers address" );
                   // writer.append("\n");
                    writer.close();
                    System.out.println("file created succefully!");
                } catch (IOException e) {
                    System.out.println(e);
                }

            } else {
                Scanner sc = new Scanner(database);
                while(sc.hasNextLine()) {
                    sc.nextLine();
                    count++;
                }
                System.out.println(count);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}