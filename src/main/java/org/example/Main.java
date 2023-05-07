package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static org.example.Product.compliteflag;
//import com.concepts.email.GEmailSender;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static String filenamecustomer = "customerdata.txt";
    public static String fileFinancial = "Financialdata.txt";
    public static String filenameadmin = "Logindata.txt";
    public static int count;
    public static String id1,name1,phone1,address1,email1;
    public static Scanner in=new Scanner(System.in);
    public static String Username,Password;


    public static void main(String[] args) throws IOException {


        readlogindata();

    }
















































    public static void readlogindata() {

        while (true){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter Username :   ");
        Username = input1.next();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter Password :   ");
        Password = input2.next();
        verify(Username,Password);
        }


    }
    public static void mainmenu(){
        System.out.println("------------------------");
        System.out.println("       <MENU>");
        System.out.println("[1] Customer data .");
        System.out.println("[2] Product data .");
        System.out.println("[3] distribute order .");
        System.out.println("[4] Sent email for complete product .");
        System.out.println("[5] Financial Statistics .");
        System.out.println("[6] Print invoice .");
        System.out.println("[7] Logout .");
        System.out.println("------------------------");
        System.out.println("Enter your choice's number : ");


    }
    public static void mainchoice(int s) throws IOException {

        if (s==1){
            customermenu();
        }
        else if (s==2){
            try {
                productmenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (s==3){
            Product p=new Product();
            ArrayList<String> worker=new ArrayList<>();
            p.listofworker();
            p.Distribute(worker);
        }
        else if (s==4){
            compliteflag();
        }
        else if (s==5){
            Product.writef();

        }
        else if (s==6){
            invoiceCC I=new invoiceCC();
            I.readfromuser();
        }
        else if (s==7){

            System.exit(1);
        }


    }


    public static void customermenu(){
        while (true) {
            System.out.println("-------------------------");
            System.out.println("     <Customer MENU>     ");
            System.out.println("[1] Add Customer .");
            System.out.println("[2] Update Customer .");
            System.out.println("[3] Delete Customer .");
            System.out.println("[4] List The Customer By Name .");
            System.out.println("[5] Back .");
            System.out.println("-------------------------");
            System.out.println("Enter your choice's number : ");
            int x = in.nextInt();
            Customer customer = new Customer();
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
            }

        }
    }

    public static void productmenu() throws IOException {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("     <Customer MENU>     ");
            System.out.println("[1] Add Product .");
            System.out.println("[2] Update Product .");
            System.out.println("[3] Delete Product .");
            System.out.println("[4] List The Product By Name .");
            System.out.println("[5] Back .");
            System.out.println("-------------------------");
            System.out.println("Enter your choice's number : ");
            int y = in.nextInt();
            Product product = new Product();
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
                product.Findproduct();


            } else if (y == 5) {
                break;
            }

        }
    }

    public static void verify(String nameuser, String pass){
        String line;
        String data[];
        String d=",";
        try {

            BufferedReader reader=new BufferedReader(new FileReader("Logindata.txt"));
            while ((line=reader.readLine())!=null){
                data = line.split(d);
                if(data[0].equals(nameuser)&& data[1].equals(pass)) {
                    System.out.println("------------------------");
                    System.out.println(PURPLE
                            + "   Welcome Mis " + nameuser
                            + RESET);
                    while (true){
                        mainmenu();
                        int x = in.nextInt();
                        mainchoice(x);
                    }
                }
                else
                {
                    System.out.println("the pass or username is wrong ,try to log in again !");
                   return;

                }
            }}
            catch (Exception e){
                System.out.println(e);
            }


        }

public static   void test(){

    final String user = "";
    final String password = "";
    String to = Customer.eemailt;;
    String to1="    ";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.starttls.enable", "true");
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                    return new javax.mail.PasswordAuthentication(user,password);
                }

            });
    try {
        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(user));
        message1.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message1.setSubject("Cleaning Serves for carpets and covers !");
        message1.setText("The order is ready, please come to collect it"+"");
        Transport.send(message1);
        System.out.println("email sent successfully!");
    } catch (Exception ignored) {
        //ignored
        System.out.println("No");
    }
}






    //create file code   لما احتاجهه خليه احتياط + بعد فيه عدد أسطر الفايل
    public static void createNewFileWithHeaders() {
        File database = new File(fileFinancial);

        try {

            if (database.createNewFile() == true) {

                try {
                    FileWriter writer = new FileWriter(fileFinancial, true);
                    //writer.append("Customers name" + "," + "Customers phone" + "," + "Customers address"+ "," + "Customers address" );
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
             //   System.out.println(count);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}