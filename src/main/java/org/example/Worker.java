package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker {

    public static final  String workerfile = "Worker.txt";
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static Logger logger = Logger.getLogger("org.example.Worker");
    private static int id;
    private static String name;
    private static String phone;

    private static String Statues;
    private static String productname;

    public Worker() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Worker.id = id;
    }

    public  String getName() {
        return name;
    }

    public static void setName(String name) {
        Worker.name = name;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Worker.phone = phone;
    }

    public static String getProductname() {
        return productname;
    }

    public static void setProductname(String productname) {
        Worker.productname = productname;
    }

    public static String getStatues() {
        return Statues;
    }

    public static void setStatues(String statues) {
        Statues = statues;
    }
    private List<Product> orders = new ArrayList<Product>();

    public Worker(int idW, String nameW, String phoneW, String StatuesW, String productNameW) {
        this.id = idW;
        this.name = nameW;
        this.phone = phoneW;
        this.Statues = StatuesW;
        this.productname = productNameW;
    }

    public static String getUserData() {
        return id + " , " + name + " , " + phone + " , " + Statues + " , " + productname;
    }

    public void readfromuser() {
        logger.log(Level.INFO,"Add The worker:");
        logger.log(Level.INFO,"Worker Id :  ");
        int idW = Integer.parseInt(input.nextLine());
        logger.log(Level.INFO,"the name of the worker:");
        String nameW = input.nextLine();
        logger.log(Level.INFO,"the Phone of the worker:");
        String phoneW = input.nextLine();
        logger.log(Level.INFO,"the Statues:");
        String statuesW = input.nextLine();
        String productNameW = "null";
        writeWorker(idW, nameW, phoneW, statuesW, productNameW);
    }

    public void writeWorker(int id, String name, String Phone, String statues, String productname) {
        Worker W = new Worker(id, name, Phone, statues, productname);

        try {
            FileWriter writer = new FileWriter(workerfile, true);
            writer.append(Worker.getUserData());
            writer.append("\n");
            writer.close();
            logger.log(Level.INFO,"Worker added successfully!");
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

}
