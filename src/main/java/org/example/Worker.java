package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Worker {

    public static String workerfile = "Worker.txt";
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    public static int id;
    public static String name;
    public static String phone;
  //  public static String address;
    public static String Statues;
    public static String productname;

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
    //    this.address = addressW;
        this.Statues = StatuesW;
        this.productname = productNameW;
    }

    public static String getUserData() {
        return id + " , " + name + " , " + phone + " , " + Statues + " , " + productname;
    }

    public void readfromuser() {
        System.out.println("Add The worker:");
        System.out.print("Worker Id :  ");
        int idW = Integer.parseInt(input.nextLine());
        System.out.println("the name of the worker:");
        String nameW = input.nextLine();
        System.out.println("the Phone of the worker:");
        String phoneW = input.nextLine();
       /* System.out.println("the address of the worker:");
        String adressW = input.nextLine();*/
        System.out.println("the Statues:");
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
            System.out.println("Worker added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
