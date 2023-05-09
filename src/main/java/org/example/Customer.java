package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.*;

public class Customer {
    static String filenamecustomer = "customerdata.txt";
    static Scanner input = new Scanner(System.in).useDelimiter("\n");


    public static String getIdc() {
        return idc;
    }

    public static void setIdc(String idc) {
        Customer.idc = idc;
    }

     static String idc;
     static String namec;
     static String phonec;

     static String addressc;
     static String emailc,eemailt;


    public static String getEmailc() {
        return emailc;
    }

    public static void setEmailc(String emailc) {
        Customer.emailc = emailc;
    }





    public static String getNamec() {
        return namec;
    }

    public static void setNamec(String namec) {
        Customer.namec = namec;
    }

    public static String getPhonec() {
        return phonec;
    }

    public static void setPhonec(String phonec) {
        Customer.phonec = phonec;
    }

    public static String getAddressc() {
        return addressc;
    }

    public static void setAddressc(String addressc) {
        Customer.addressc = addressc;
    }

    public Customer(String id,String name, String phone, String address,String email){
        this.idc=id;
        this.namec=name;
        this.phonec=phone;
        this.addressc=address;
        this.emailc=email;
    }
    public  String getUserData(){
        return  idc+" , "+ namec+" , " + phonec +" , " +addressc+" , " +emailc;
    }
    public void read_customer_data(){
        readfromuser();
        idc=id1;
        namec=name1;
        phonec=phone1;
        addressc=address1;
        emailc=email1;
    }

    public void readfromuser(){

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Customer's Id :  ");
        id1= input.nextLine();
        System.out.print("Enter Customer's Name :  ");
        name1=input.nextLine();
        System.out.print("Enter Customer's Phone :  ");
        phone1=input.next();
        System.out.print("Enter Customer's address :  ");
        address1=input.next();
        System.out.print("Enter Customer's email :  ");
        email1=input.next();
        record(id1,name1,phone1,address1,email1);
    }

    public Customer() {

    }

    public void record(String id,String name, String phone, String address,String email){

        Customer customer= new Customer(id,name,phone,address,email);
        try {
            FileWriter writer=new FileWriter(filenamecustomer,true);
            writer.append(customer.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println(YELLOW+"Customer Recorded Successfully."+RESET);


        } catch (IOException e) {
            System.out.println(e);
        }
    }



    public static void updateRecord1(ArrayList<String> arrayList, Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            System.out.println("please enter any key to update the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null) {
                String[] arr = line.split(",");
                    if (arr[0].contains(searchKey)) {
                        System.out.println("enter the text you want to change");
                        String oldValue = input.next();
                        System.out.println("enter the new text you want to change");
                        String newValue = input.next();
                        arrayList.add(line.replace(oldValue, newValue));
                        System.out.println(YELLOW+"Customer Updated Successfully."+RESET);
                    } else {
                        arrayList.add(line);
                    }

                }


        }catch (Exception e){
            System.out.println(e);
        }

        try {
            FileWriter writer=new FileWriter(filenamecustomer);
            for(int i=0;i<arrayList.size();i++){
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void  deleteRecordById(ArrayList<String> arrayList,Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            System.out.println("Enter An Id To Delete A Customer : ");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null) {
                String[] arr = line.split(",");
                if (arr[0].contains(searchKey)) {

                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);

                }
            }

        }catch (Exception e){

        }
        try {
            FileWriter writer=new FileWriter(filenamecustomer);
            for (int i=0;i<arrayList.size();i++){
                writer.append( arrayList.get(i));
                writer.append("\n");


            }
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println(YELLOW+"Customer Deleted Successfully."+RESET);
        }}

    public static void gettemail() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filenamecustomer));
            String idstatec= Product.idtest;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(idstatec)) {
                    System.out.println(line);
                    eemailt=arr[4];
                    System.out.println(eemailt);
                    test();
                    continue;
                }

            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }




    public static void getUserByname(Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            System.out.println("Please Enter Name Of Customer To Get Customer Data  :");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if( line.contains(searchKey)){
                    System.out.println(line);

                }

            }


        }catch (Exception e){
            System.out.println(e);
        }


    }
    public static void getAllcustomer(){

        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            String line;
            System.out.println("--------------------the list of customer--------------------");

            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }





    }


}




