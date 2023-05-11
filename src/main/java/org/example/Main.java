package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;


import static org.example.Product.compliteflag;
public class Main {
    private static final Logger LOGGER=Logger.getLogger("org.example.Main");
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    static String fileFinancial = "Financialdata.txt";
    static String entrymsg = "Enter your choice number : ";
    static int count;
    static Scanner in=new Scanner(System.in);
    static String adminUsername;
    static String adminPassword;
   static Customer customer = new Customer();
   static Product product = new Product();


    public static void main(String[] args) {readlogindata();}

    public static void readlogindata() {
        while (true){
        Scanner input1 = new Scanner(System.in);
        LOGGER.log(Level.INFO,"Enter Username :   ");
        adminUsername = input1.next();
        Scanner input2 = new Scanner(System.in);
        LOGGER.log(Level.INFO,"Enter Password :   ");
        adminPassword = input2.next();
        verify(adminUsername,adminPassword);
        }

    }
    public static void mainmenu(){
        LOGGER.log(Level.INFO,"       <MENU>");
        LOGGER.log(Level.INFO,"[1] Customer data .");
        LOGGER.log(Level.INFO,"[2] Product data .");
        LOGGER.log(Level.INFO,"[3] distribute order .");
        LOGGER.log(Level.INFO,"[4] Sent email for complete product .");
        LOGGER.log(Level.INFO,"[5] Financial Statistics .");
        LOGGER.log(Level.INFO,"[6] Print invoice .");
        LOGGER.log(Level.INFO,"[7] Logout .");
        LOGGER.log(Level.INFO,entrymsg);
    }
    public static void mainchoice(int s) throws IOException {

        if (s==1){
            customermenu();
        }
        else if (s==2){
            productmenu();
        }
        else if (s==3){
            Product p=new Product();
            ArrayList<String> worker=new ArrayList<>();
            p.listofworker();
            p.distribute(worker);
        }
        else if (s==4){
            compliteflag();
        }
        else if (s==5){
            Product.writef();
        }
        else if (s==6){
            INVOICECC invoicecc=new INVOICECC();
            invoicecc.readfromuser();
        }
        else if (s==7){
            System.exit(1);
        }}
    public static void customermenu(){
        while (true) {
            LOGGER.log(Level.INFO,"     <Customer MENU>     ");
            LOGGER.log(Level.INFO,"[1] Add Customer .");
            LOGGER.log(Level.INFO,"[2] Update Customer .");
            LOGGER.log(Level.INFO,"[3] Delete Customer .");
            LOGGER.log(Level.INFO,"[4] List The Customer By Name .");
            LOGGER.log(Level.INFO,"[5] Back .");
            LOGGER.log(Level.INFO,entrymsg);
            int x = in.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();
            if (x == 1) {
                customer.getAllcustomer();
                customer.readfromuser();
                customer.getAllcustomer();
            } else if (x == 2) {
                customer.getAllcustomer();
                customer.updateRecord1(arrayList, in);
                customer.getAllcustomer();
            } else if (x == 3) {
                customer.getAllcustomer();
                customer.deleteRecordById(arrayList, in);
                customer.getAllcustomer();
            } else if (x == 4) {
                customer.getUserByname(in);
            } else if (x == 5) {
                break;
            }}}

    public static void productmenu() {
        while (true) {
            LOGGER.log(Level.INFO,"     <Product MENU>     ");
            LOGGER.log(Level.INFO,"[1] Add Product .");
            LOGGER.log(Level.INFO,"[2] Update Product .");
            LOGGER.log(Level.INFO,"[3] Delete Product .");
            LOGGER.log(Level.INFO,"[4] List The Product By Name .");
            LOGGER.log(Level.INFO,"[5] Back .");
            LOGGER.log(Level.INFO,entrymsg);
            int y = in.nextInt();
            ArrayList<String> arrayListP = new ArrayList<String>();
            if (y == 1) {
                product.readfromuserp();
                product.getAllproduct();
            } else if (y == 2) {
                product.getAllproduct();
                product.updateproduct(arrayListP);
                product.getAllproduct();
            } else if (y == 3) {
                product.getAllproduct();
                product.deleteRecordproById(arrayListP, in);
                product.getAllproduct();
            } else if (y == 4) {
                product.findproductbyname();
            } else if (y == 5) {
                break;
            }}}

    public static void verify(String nameuser, String pass){
        String line;
        String [] data;
        String d=",";
        try {

            BufferedReader reader=new BufferedReader(new FileReader("Logindata.txt"));
            while ((line=reader.readLine())!=null){
                data = line.split(d);
                if(data[0].equals(nameuser)&& data[1].equals(pass)) {
                    LOGGER.log(Level.INFO,PURPLE +"   Welcome Mis " + RESET);
                    while (true){
                        mainmenu();
                        int x = in.nextInt();
                        mainchoice(x);
                    }
                }
                else
                {
                    LOGGER.log(Level.INFO,"the pass or username is wrong ,try to log in again !");
                   return;
                }
            }}
            catch (Exception e){
                LOGGER.log(Level.INFO,String.valueOf(e));
            }


        }

public static   void test() {

    final String user = "";
    final String password = "";
    String to = Customer.eemailt;
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.starttls.enable", "true");
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(user, password);
                }

            });
    try {
        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(user));
        message1.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message1.setSubject("Cleaning Serves for carpets and covers !");
        message1.setText("The order is ready, please come to collect it" + "");
        Transport.send(message1);
        LOGGER.log(Level.INFO, "email sent successfully!");
    } catch (Exception ignored) {
        LOGGER.log(Level.INFO, "Theres Problem in Email!");
    }
}}





