package org.example;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.Main.*;

public class Customer {
    private static final Logger LOGGER=Logger.getLogger("org.example.Customer");
    static String filenamecustomer = "customerdata.txt";

     private String customerId;
     private String customerName;
     private String customerPhone;

    private String customerAddress;
     private String customerEmail;

    static String eemailt;

    public  Customer(String id,String name, String phone, String address,String email){
        customerId=id;
        customerName=name;
        customerPhone=phone;
        customerAddress=address;
        customerEmail=email;
    }
    public  String getUserData(){
        return  customerId+" , "+customerName+" , "+ customerPhone +" , " +customerAddress+" , "+customerEmail;
    }

    public void readfromuser(){

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        LOGGER.log(Level.INFO,"Customers Id :  ");
        customerId= input.nextLine();
        LOGGER.log(Level.INFO,"Enter Customer Name :  ");
        customerName=input.nextLine();
        LOGGER.log(Level.INFO,"Enter Customer Phone :  ");
        customerPhone=input.next();
        LOGGER.log(Level.INFO,"Enter Customer address :  ");
        customerAddress=input.next();
        LOGGER.log(Level.INFO,"Enter Customer email :  ");
        customerEmail=input.next();
        recordcustomer(customerId,customerName,customerPhone,customerAddress,customerEmail);
    }

    public Customer() {

    }

    public void recordcustomer(String id,String name, String phone, String address,String email){

        Customer customer= new Customer(id,name,phone,address,email);
        try {
            FileWriter writer=new FileWriter(filenamecustomer,true);
            writer.append(customer.getUserData());
            writer.append("\n");
            writer.close();
            LOGGER.log(Level.INFO,YELLOW+"Customer Recorded Successfully."+RESET);
        } catch (IOException e) {
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
    }



    public  void updateRecord1(List<String> arrayList, Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            LOGGER.log(Level.INFO,"please enter any key to update the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null) {
                String[] arr = line.split(",");
                    if (arr[0].contains(searchKey)) {
                        LOGGER.log(Level.INFO,"enter the text you want to change");
                        String oldValue = input.next();
                        LOGGER.log(Level.INFO,"enter the new text you want to change");
                        String newValue = input.next();
                        arrayList.add(line.replace(oldValue, newValue));
                        LOGGER.log(Level.INFO,YELLOW+"Customer Updated Successfully."+RESET);
                    } else {
                        arrayList.add(line);
                    }
                }
        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
        try {
            FileWriter writer=new FileWriter(filenamecustomer);
            for(var item : arrayList){
                writer.append(item);
                writer.append("\n");
            }
            writer.close();
        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }

    }


    public  void  deleteRecordById(List<String> arrayList,Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            LOGGER.log(Level.INFO,"Enter An Id To Delete A Customer : ");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(searchKey)) {
                    LOGGER.log(Level.INFO,line);
                }else {
                    arrayList.add(line);

                }
            }

        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
        try {
            FileWriter writer=new FileWriter(filenamecustomer);
            for(var item : arrayList){
                writer.append(item);
                writer.append("\n");
            }

            writer.close();

        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }finally {
            LOGGER.log(Level.INFO,YELLOW+"Customer Deleted Successfully."+RESET);
        }}

    public void gettemail() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filenamecustomer));
            String idstatec= Product.idtest;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(idstatec)) {
                    LOGGER.log(Level.INFO,line);
                    LOGGER.log(Level.INFO,eemailt);
                    test();
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
    }
    public void getUserByname(Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            LOGGER.log(Level.INFO,"Please Enter Name Of Customer To Get Customer Data  :");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if( line.contains(searchKey)){
                    LOGGER.log(Level.INFO,line);
                }
            }
        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
    }
    public  void getAllcustomer(){

        try {
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            String line;
            LOGGER.log(Level.INFO,"--------------------the list of customer--------------------");
            while ((line=reader.readLine())!=null){
                LOGGER.log(Level.INFO,line);

            }
            LOGGER.log(Level.INFO,"------------------------------------------------------------");
        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
    }
}




