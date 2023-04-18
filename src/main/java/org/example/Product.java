package org.example;


import java.io.*;
import java.util.ArrayList;
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
    public static String statusP;

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

    public Product(int id, String namep, String H, String W, String D) {
        this.idp = id;
        this.name = namep;
        this.height = H;
        this.width = W;
        this.dayfinish = D;
    }

    public static String getUserData() {
        return idp + " , " + name + " , " + height + " , " + width + " , " + dayfinish;
    }

    public void readproductdata() {
        readfromuser();
    }

    public void readfromuser() {
        System.out.println("Add your product:");
        System.out.print("product Id :  ");
        int idr = Integer.parseInt(input.nextLine());
        System.out.println("the name of the product:");
        String namer = input.nextLine();
        System.out.println("the height of the product:");
        String Hr = input.nextLine();
        System.out.println("the width of the product:");
        String Wr = input.nextLine();
        System.out.println("the Delivery time:");
        String dayr = input.nextLine();
        writeproduct(idr, namer, Hr, Wr, dayr);
    }

    public void writeproduct(int id, String name, String height, String width, String dayfinish) {
        Product p = new Product(id, name, height, width, dayfinish);

        try {
            FileWriter writer = new FileWriter(productfile, true);
            writer.append(Product.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println("product added successfully!");
            System.out.println(" the statue of product : \t Waiting");
            // Distribute();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean checkid(String idpp) {
        if (idpp.equals(idp)) {
            return true;
        }
        return false;
    }

    public void Distribute() throws IOException {
        String[] worker = null;
        String output = null;
        while (true) {
            FileInputStream fin = new FileInputStream(workerfile);
            FileWriter writerworker = new FileWriter(workerfile, true);
            Scanner sci = new Scanner(fin);
            while (sci.hasNextLine()) {
                String Line = sci.nextLine();
                Line.trim();
                worker = Line.split(" , ");
                if (worker[4].equalsIgnoreCase("available")) {
                    int id = Integer.parseInt(worker[0]);
                    String infoemation = "Worker Name :\t" + worker[1] + "\n";
                    String nameW = worker[1];
                    String phoneW = worker[2];
                    String locationW = worker[3];
                    UpdateWorker(id, "Not avalible", nameW, phoneW, locationW, name);
                    output = infoemation + "\n the statue of product : \t in treatment";
                    break;
                } else {
                    output = "waiting";
                }
            }
            System.out.println(output);
            break;
        }
    }

    public void Deleteproduct(ArrayList<String> arrayList, Scanner input) {
        System.out.println("enter any id or word to delete a record");
        String searchKey = input.next();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchKey)) {
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

    public static void updateproduct(ArrayList<String> arrayList, Scanner input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(productfile));
        System.out.println("-----Update Product------\n");
        System.out.println("\tenter the ID of the product:\t ");
        int id = Integer.parseInt(input.nextLine());
        String[] UpdateP = null;
        String Line;
        while ((Line = reader.readLine()) != null) {
            if (UpdateP[0].equalsIgnoreCase(String.valueOf(id))) {
                Line.trim();
                UpdateP = Line.split(" , ");
                System.out.println("enter the text you want to change");
                String oldValue = input.next();
                System.out.println("enter the new text you want to change");
                String newValue = input.next();
                arrayList.add(Line.replace(oldValue, newValue));
            } else {
                arrayList.add(Line);
            }
        }
    try {
        FileWriter writer = new FileWriter(productfile);
        for (int i = 0; i < arrayList.size(); i++) {
            writer.append(arrayList.get(i));
            writer.append("\n");
        }
        writer.close();
    }catch(Exception e) {
        System.out.println(e);
    }
}
    public void Findproduct() throws IOException {
        System.out.println("-----Find Product------\n");
        System.out.println("\tenter the Name of the product:\t ");
        String Namefind=input.nextLine();
        String[] FindP = null;
        String output=null;
        while (true) {
            FileInputStream fin = new FileInputStream(productfile);
            Scanner sci = new Scanner(fin);
            while (sci.hasNextLine()) {
                String Line = sci.nextLine();
                Line.trim();
                FindP = Line.split(" , ");
                if (FindP[1].equalsIgnoreCase(Namefind)) {
                    String information = "Product id :\t" + FindP[0] +"    Product Name :\t"+FindP[1]+"     Product Heigh:\t"+FindP[2]+"    Product Width :\t"+FindP[3]+"     delivery date :\t"+FindP[4];
                    output=information;
            //        fin.close();
                    break;
                } else{
                   output="Not found";}
            }
            System.out.println(output);
            break;
        }

    }
    public void UpdateWorker(int id,String newstate,String name,String phone,String location,String productname) throws IOException {
        String tempfile= "temp.txt";
        String filepath="Worker.txt";
        File oldfile=new File(filepath);
        File newfile=new File(tempfile);
      //  int idu ;
        String[] w = null;
        try
        {
            FileWriter fW = new FileWriter(tempfile,true);
            BufferedWriter bW=new BufferedWriter(fW);
            PrintWriter pW=new PrintWriter(bW);
            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while (x.hasNextLine())
            {
                String Line = x.nextLine();
                Line.trim();
                w = Line.split(" , ");
              //  idu= Integer.parseInt(x.next());
                if(w[0].equals(id))
                {
                    pW.println(id+" , "+name+" , "+phone+" , "+location+" , "+newstate+" , "+productname);}

            }
            x.close();
            pW.flush();
            pW.close();
        //    oldfile.delete();
          //  File dump =new File(filepath);
         //   newfile.renameTo(dump);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changestatue(String st){
        Statues=st;
    }

}
