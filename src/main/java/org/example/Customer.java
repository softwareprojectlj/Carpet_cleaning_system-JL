package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.*;

public class Customer {
    public static String filenamecustomer = "customerdata.txt";
    Scanner input = new Scanner(System.in).useDelimiter("\n");


    public static String getIdc() {
        return idc;
    }

    public static void setIdc(String idc) {
        Customer.idc = idc;
    }

    public static String idc;
    public static String namec;
    public static String phonec;
    public static String addressc;





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

    public Customer(String id,String name, String phone, String address){
        this.idc=id;
        this.namec=name;
        this.phonec=phone;
        this.addressc=address;
    }
    public  String getUserData(){
        return  idc+","+ namec+"," + phonec +"," +addressc;
    }
    public void read_customer_data(){
        readfromuser();
        idc=id1;
        namec=name1;
        phonec=phone1;
        addressc=address1;
    }
    public void readfromuser(){

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Customer's Id :  ");
        id1= input.nextLine();
        System.out.println(id1);
        System.out.print("Enter Customer's Name :  ");
        name1=input.nextLine();
        System.out.print("Enter Customer's Phone :  ");
        phone1=input.next();
        System.out.print("Enter Customer's address :  ");
        address1=input.next();
        record(id1,name1,phone1,address1);
    }

    public Customer() {

    }

    public void record(String id,String name, String phone, String address){

        Customer customer= new Customer(id,name,phone,address);
        try {
            FileWriter writer=new FileWriter(filenamecustomer,true);
            writer.append(customer.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println("customer added succefully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void updateRecord(ArrayList<String> arrayList, Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            System.out.println("please enter any key to update the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println("enter the text you want to change");
                    String oldValue=input.next();
                    System.out.println("enter the new text you want to change");
                    String newValue=input.next();
                    arrayList.add(line.replace(oldValue,newValue));

                    break;

                }else {
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
        System.out.println("enter any id or word to delete a record");
        String searchKey=input.next();
        String line;
        try {

            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            while ((line=reader.readLine())!=null){
                if(line.contains(searchKey)){
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
            System.out.println("done!");
        }}

    public static void getUserById(Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            System.out.println("please enter any key to get the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println(line);

                }

            }


        }catch (Exception e){
            System.out.println(e);
        }


    }

}




