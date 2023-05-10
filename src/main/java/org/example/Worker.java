package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.logging.Logger;

public class Worker {

    public static final  String WORKWRFILE = "Worker.txt";

    private static Logger logger = Logger.getLogger("org.example.Worker");
   static int id;
     static String name;
    static String phone;

     static String statues;
    static String productname;


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
        return statues;
    }

    public static void setStatues(String statues) {
        Worker.statues = statues;
    }
    private List<Product> orders = new ArrayList<Product>();

    public static String getUserData() {
        return id + " , " + name + " , " + phone + " , " + statues + " , " + productname;
    }

}
