package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.*;
import static org.example.Worker.workerfile;

public class Product {
    public static final String productfile = "product.txt";
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
     private static int idp;
     private static int idcus ;
     private static int idprodis ;
    private static String name;
    static String idtest;
     static String height = " ";
    private static String width;
    private static String dayfinish;
    private static int price;
    private static String state;
    private static int priceyes ;
    private static int priceno;

    public static String getPrizstate() {
        return prizstate;
    }

    public static void setPrizstate(String prizstate) {
        Product.prizstate = prizstate;
    }

    public static String prizstate;

    public static int getIdp() {
        return idp;
    }

    public static int getIdcus() {
        return idcus;
    }

    public static void setIdcus(int idcus) {
        Product.idcus = idcus;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Product.price = price;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        Product.state = state;
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

    public Product(int id, String namep, String H, String W, String D, int p, String s, int idcu, String pstate) {
        this.idp = id;
        this.name = namep;
        this.height = H;
        this.width = W;
        this.dayfinish = D;
        this.price = p;
        this.state = s;
        this.idcus = idcu;
        this.prizstate = pstate;
    }

    public static String getUserData() {
        return idp + " , " + name + " , " + height + " , " + width + " , " + dayfinish + " , " + price + " , " + state + " , " + idcus+ " , " + prizstate;
    }

    public void readfromuserp() {
        //Scanner input = new Scanner(System.in).useDelimiter("\n");
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
        System.out.println("the id for customer:");
        int idcust = Integer.parseInt(input.nextLine());
        System.out.println("Paid or not :");
        String pstate = input.nextLine();
        String statep = "waiting";

        int pp=getprice(Wr, Hr);
        int priced= applyDiscount(pp);
        writeproduct(idr, namer, Hr, Wr, dayr, priced, statep, idcust ,pstate);
    }

    public Product() {
    }

    public void writeproduct(int id, String name, String height, String width, String dayfinish, int price, String statep, int idcust, String pstate) {
        Product p = new Product(id, name, height, width, dayfinish, price, statep, idcust , pstate);

        try {
            FileWriter writer = new FileWriter(productfile, true);
            writer.append(p.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println("product added successfully!");
            System.out.println("the statue of product : \t Waiting");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteRecordproById(ArrayList<String> arrayList, Scanner input) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            System.out.println("Enter An Id To Delete A Product : ");
            String searchKey = input.next();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(searchKey)) {

                    System.out.println(line);
                    continue;
                } else {
                    arrayList.add(line);

                }
            }

        } catch (Exception e) {
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
        } finally {
            System.out.println(YELLOW + "Product Deleted Successfully." + RESET);
        }
    }

    public void Deleteproduct(ArrayList<String> arrayList) {
        String filePath = "product.txt";
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String Delete[] = null;

            System.out.println("-----Delete Product------\n");
            System.out.println("enter the ID of the product: ");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

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
            System.out.println("enter the ID of the product:");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

                update = line.split(" , ");
                if (update[0].equalsIgnoreCase(String.valueOf(id))) {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Enter the data you want to update : ");
                    String olddata = consoleReader.readLine();
                    System.out.print("Enter the new data : ");
                    String newdata = consoleReader.readLine();
                    arrayList.add(line.replace(olddata, newdata));
                    System.out.println("File Update Successfully.");
                } else {

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

    public static void Findproduct() throws IOException {
        System.out.println("-----Find Product------\n");
        System.out.println("enter the Name of the product: ");
        String Namefind = input.nextLine();
        String[] FindP = null;
        String output = null;
        while (true) {
            FileInputStream fin = new FileInputStream(productfile);
            Scanner sci = new Scanner(fin);
            while (sci.hasNextLine()) {
                String Line = sci.nextLine();

                FindP = Line.split(" , ");
                if (FindP[1].equalsIgnoreCase(Namefind)) {
                    String information = "Product id :\t" + FindP[0] + "    Product Name :\t" + FindP[1] + "     Product Heigh:\t" + FindP[2] + "    Product Width :\t" + FindP[3] + "     delivery date :\t" + FindP[4];
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
    public static void countyes(int r){

        priceyes=priceyes+r;
    }

    public static void stateprizeyes(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            String sprizeflag="yes";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[8].contains(sprizeflag)) {
                   // System.out.println(line);
                    String p = arr[5];
                    countyes(Integer.parseInt(p));
                    //System.out.println(price1);
                    continue;
                }


            }


        } catch (Exception e) {
            System.out.println("lmlm");
            System.out.println(e);
        }


    }
    public static void countno(int r){

        priceno=priceno+r;
    }

    public static void stateprizeno(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            String sprizeflag="no";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[8].contains(sprizeflag)) {
                    //System.out.println(line);
                    String p = arr[5];
                    countno(Integer.parseInt(p));
                    //System.out.println(price1);
                    continue;
                }


            }


        } catch (Exception e) {
            System.out.println("lmlm");
            System.out.println(e);
        }


    }

    public static void writef(){

        stateprizeyes();
        stateprizeno();

            try {
                FileWriter writer = new FileWriter(fileFinancial, true);
                writer.write("total cash :" + priceyes +"\n"+
                        "total paid :" + priceyes +"\n");
                writer.close();
                System.out.println("open the Financial file to show the state of money ^_^ ");
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    public static void compliteflag() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            String stateflag="complete";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[6].contains(stateflag)) {
                    System.out.println(line);
                    idtest=arr[7];
                    Customer.gettemail();

                    continue;
                }

            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void Distribute(ArrayList<String> workerarray) throws IOException {
            String distributeP[] = null;
            String distributeW[] = null;
            System.out.println("\tenter the ID of the product:\t ");
            int idproduct =Integer.parseInt(input.nextLine());
            idprodis=idproduct;
            String output = null;
                 String information ;
                StringBuilder sb = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(workerfile));
                String line2;
                FileInputStream fin = new FileInputStream(productfile);
                Scanner sci = new Scanner(fin);
                while (sci.hasNextLine()) {
                    String Line = sci.nextLine();

                    distributeP = Line.split(" , ");
                    if (distributeP[0].equalsIgnoreCase(String.valueOf(idproduct))) {
                        System.out.println("\tenter the ID of the Worker:\t ");
                        int idworker = Integer.parseInt(input.nextLine());
                        while ((line2 = reader.readLine()) != null) {
                            sb.append(line2).append("\n");

                            distributeW = line2.split(" , ");
                            if (distributeW[0].equalsIgnoreCase(String.valueOf(idworker))) {
                                String[] parts = line2.split(" , ");
                                parts[3] = "Not available";
                                parts[4] = distributeP[1];
                                raya(idproduct);
                                String newLine = String.join(" , ", parts);
                                workerarray.add(newLine);
                                information = "Product id :\t" + distributeP[0] + "    Product Name :\t" + distributeP[1] + "     delivery date :\t" + distributeP[5] + "\n" + "   Worker name :\t" + distributeW[1] + "   Worker Phone :\t" + distributeW[2];
                                System.out.println(information);
                                System.out.println("the statue of product : \t in treatment");
                            } else {
                                workerarray.add(line2);
                            }
                        }
                    } /*else {
                    output = "Not found\n all the workers are Not Available Now >-< \n the statue of product : \t waiting ";
                }*/
                }
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

    public static void raya(Integer idupdd){
        ArrayList<String> productpp=new ArrayList<>();
        try {
            FileReader fr=new FileReader(productfile);
            BufferedReader br =new BufferedReader(fr);
            String updatestate[] = null;
           String line;
           while((line= br.readLine())!= null)
           {

               updatestate=line.split(" , ");
               if(updatestate[0].equalsIgnoreCase(String.valueOf(idupdd)))
               {
                   String[]parts=line.split(" , ");
                   parts[6]="in treatment";
                   String newline =String.join(" , ",parts);
                   productpp.add(newline);
               }
               else {
                   productpp.add(line);}
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            FileWriter writer=new FileWriter(productfile);
            for(int i=0;i<productpp.size();i++){
                writer.append(productpp.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Integer getprice(String w,String h)
    {
        this.width=w;
        this.height=h;
        Double area=(Double.valueOf(w) * Double.valueOf(h));
        if(area<=5 && area>0 )
            price=40;
        else if(area<=15 && area>5 )
            price=80;
        else if(area<=25 && area>15 )
            price=130;
        else if(area<=45 && area>25 )
            price=180;
        else if(area<=65 && area>45 )
            price=230;
        else if(area<=85 && area>65 )
            price=270;
        else if(area<=110 && area>85 )
            price=320;
        else
            price=380;
        return price;
    }
    public Integer applyDiscount(Integer pricedis) {
        this.price=pricedis;
        if (pricedis > 250) {
            double discount = pricedis * 0.1;
            return (int) (pricedis - discount);
        } else {
            return pricedis;
        }
    }

    public static void getAllproduct() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            String line;
            System.out.println("--------------------the list of product--------------------");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
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
