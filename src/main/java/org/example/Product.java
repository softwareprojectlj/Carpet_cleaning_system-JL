package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Worker.*;

public class Product {
    public static String productfile = "product.txt";
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    public static int idp;
    public static String name;
    public static String height;
    public static String width;
    public static String dayfinish;
    public static  String type;

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Product.type = type;
    }

    public Product() {
    }

    public static int getId() {
        return idp;
    }

    public static void setIdp(int idp) {
        Product.idp = idp;
    }

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        Product.name = name;
    }

    public static String getHeight() {
        return height;
    }

    public static void setHeight(String height) {
        Product.height = height;
    }

    public static String getWidth() {
        return width;
    }

    public static void setWidth(String width) {
        Product.width = width;
    }

    public static String getDayfinish() {
        return dayfinish;
    }

    public static void setDayfinish(String dayfinish) {
        Product.dayfinish = dayfinish;
    }

    public Product(int id, String namep, String H, String W, String D,String T) {
        this.idp = id;
        this.name = namep;
        this.height = H;
        this.width = W;
        this.dayfinish = D;
        this.type=T;
    }

    public static String getUserData() {
        return idp + " , " + name + " , " + height + " , " + width + " , " + type+ " , " + dayfinish;
    }

    public void readfromuser() {

        System.out.println("\tAdd your product\t");
            System.out.print("product Id :  ");
            int idr = Integer.parseInt(input.nextLine());
            System.out.println("the name of the product:");
            String namer = input.nextLine();
            System.out.println("the Type of the product (carpets Or covers) : ");
            String typer = input.nextLine();
            System.out.println("the height of the product:");
            String Hr = input.nextLine();
            System.out.println("the width of the product:");
            String Wr = input.nextLine();
            System.out.println("the Delivery time:");
            String dayr = input.nextLine();
            writeproduct(idr, namer, Hr, Wr, dayr,typer);

    }

    public void writeproduct(int id, String name, String height, String width, String dayfinish,String Typee) {
            Product p = new Product(id, name, height, width, dayfinish,Typee);
            try {
                FileWriter writer = new FileWriter(productfile, true);
                writer.append(Product.getUserData());
                writer.append("\n");
                writer.close();
                System.out.println("product added successfully!");
                System.out.println(" the statue of product : \t Waiting");
            } catch (IOException e) {
                System.out.println(e);
            }
    }

    public void Distribute(ArrayList<String> workerarray) throws IOException {
        String distributeP[] = null;
        String distributeW[] = null;
        System.out.println("\tenter the ID of the product:\t ");
        int idproduct =Integer.parseInt(input.nextLine());
        String output = null;
        String information ;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(workerfile));
        String line2;
            FileInputStream fin = new FileInputStream(productfile);
            Scanner sci = new Scanner(fin);
            while (sci.hasNextLine()) {
                String Line = sci.nextLine();
                Line.trim();
                distributeP = Line.split(" , ");
                if (distributeP[0].equalsIgnoreCase(String.valueOf(idproduct))) {
                    System.out.println("\tenter the ID of the Worker:\t ");
                    int idworker = Integer.parseInt(input.nextLine());
                    while ((line2 = reader.readLine()) != null) {
                        sb.append(line2).append("\n");
                        line2.trim();
                        distributeW = line2.split(" , ");
                            if (distributeW[0].equalsIgnoreCase(String.valueOf(idworker))) {
                                    String[] parts = line2.split(" , ");
                                    parts[3] = "Not available";
                                    parts[4] = distributeP[1];
                                    String newLine = String.join(" , ", parts);
                                    workerarray.add(newLine);
                                    information = "Product id :\t" + distributeP[0] + "    Product Name :\t" + distributeP[1] + "     delivery date :\t" + distributeP[5] + "\n" + "   Worker name :\t" + distributeW[1] + "   Worker Phone :\t" + distributeW[2];
                                    System.out.println(information);
                                    System.out.println(" the statue of product : \t in treatment");
                            } else {
                                workerarray.add(line2);
                            }
                    }
                } /*else {
                    output = "Not found\n all the workers are Not Available Now >-< \n the statue of product : \t waiting ";
                }*/
            }
           // System.out.println(output);
        try {
            FileWriter writer = new FileWriter(workerfile);
            for (int i = 0; i < workerarray.size(); i++) {
                writer.append(workerarray.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Deleteproduct(ArrayList<String> arrayList) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("product.txt"));
            String Delete[] = null;

            System.out.println("-----Delete Product------\n");
            System.out.println("\tenter the ID of the product:\t ");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                line.trim();
                Delete = line.split(" , ");
                if ((Delete[0].equalsIgnoreCase(String.valueOf(id)))) {
                    System.out.println(line);
                    continue;
                } else {
                    arrayList.add(line);
                }
            }
        } catch (Exception e) {
        }
        try {
            FileWriter writer = new FileWriter(productfile);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("done!");
        }
    }

    public static void updateproduct(ArrayList<String> arrayList) throws IOException {
        try {
            String update[] = null;
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            System.out.println("-----Update Product------\n");
            System.out.println("\tenter the ID of the product:\t ");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                line.trim();
                update = line.split(" , ");
                if (update[0].equalsIgnoreCase(String.valueOf(id))) {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Enter the data you want to update : ");
                    String olddata = consoleReader.readLine();
                    System.out.print("Enter the new data : ");
                    String newdata = consoleReader.readLine();
                    arrayList.add(line.replace(olddata, newdata));
                    System.out.println(" File Update Successfully.");
                } else {
               //     System.out.println(" An error occurred while updating the file.");
                    arrayList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(productfile);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Findproduct() throws IOException {
        System.out.println("-----Find Product------\n");
        System.out.println("\tenter the Name of the product:\t ");
        String Namefind = input.nextLine();
        String[] FindP = null;
        String output = null;
        while (true) {
            FileInputStream fin = new FileInputStream(productfile);
            Scanner sci = new Scanner(fin);
            while (sci.hasNextLine()) {
                String Line = sci.nextLine();
                Line.trim();
                FindP = Line.split(" , ");
                if (FindP[1].equalsIgnoreCase(Namefind)) {
                    String information = "Product id :\t" + FindP[0] + "    Product Name :\t" + FindP[1] + "     Product Heigh:\t" + FindP[2] + "    Product Width :\t" + FindP[3] + "     Type of product :\t" + FindP[4]+"     delivery date :\t" + FindP[5];
                    output = information;
                    //        fin.close();
                    break;
                } else {
                    output = "Not found";
                }
            }
            System.out.println(output);
            break;
        }

    }

    public void listofworker() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("Worker.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder stringBuilder = new StringBuilder();
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, bytesRead));
            }
            // Close the streams
            bufferedInputStream.close();
            fileInputStream.close();
            System.out.println(stringBuilder.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
