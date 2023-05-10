package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static org.example.Main.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.Worker.WORKWRFILE;

public class Product {
    //jana barakeh
    public static final String productfile = "product.txt";
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static Logger logger = Logger.getLogger("org.example.Product");
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
    private static String prizstate;
    public static String getPrizstate() {
        return prizstate;
    }

    public static void setPrizstate(String prizstate) {
        Product.prizstate = prizstate;
    }

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
      logger.log(Level.INFO,"Add your product:");
        logger.log(Level.INFO,"product Id :  ");
        int idr = Integer.parseInt(input.nextLine());
        logger.log(Level.INFO,"the name of the product:");
        String namer = input.nextLine();
        logger.log(Level.INFO,"the height of the product:");
        String Hr = input.nextLine();
        logger.log(Level.INFO,"the width of the product:");
        String Wr = input.nextLine();
        logger.log(Level.INFO,"the Delivery time:");
        String dayr = input.nextLine();
        logger.log(Level.INFO,"the id for customer:");
        int idcust = Integer.parseInt(input.nextLine());
        logger.log(Level.INFO,"Paid or not :");
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
            logger.log(Level.INFO,"product added successfully!");
            logger.log(Level.INFO,"the statue of product : \t Waiting");
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static void deleteRecordproById(ArrayList<String> arrayList, Scanner input) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            logger.log(Level.INFO,"Enter An Id To Delete A Product : ");
            String searchKey = input.next();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(searchKey)) {

                    logger.log(Level.INFO,line);
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
           e.printStackTrace();
        } finally {
            logger.log(Level.INFO,YELLOW + "Product Deleted Successfully." + RESET);
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

            logger.log(Level.INFO,"-----Delete Product------\n");
            logger.log(Level.INFO,"enter the ID of the product: ");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

                Delete = line.split(" , ");
                if ((Delete[0].equalsIgnoreCase(String.valueOf(id)))) {
                    logger.log(Level.INFO,line);
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
            e.printStackTrace();
        } finally {
            logger.log(Level.INFO,"done!");
        }
    }


    public static void updateproduct(ArrayList<String> arrayList) throws IOException {
        try {
            String update[] = null;
            BufferedReader reader = new BufferedReader(new FileReader(productfile));
            logger.log(Level.INFO,"-----Update Product------\n");
            logger.log(Level.INFO,"enter the ID of the product:");
            int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

                update = line.split(" , ");
                if (update[0].equalsIgnoreCase(String.valueOf(id))) {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    logger.log(Level.INFO,"Enter the data you want to update : ");
                    String olddata = consoleReader.readLine();
                    logger.log(Level.INFO,"Enter the new data : ");
                    String newdata = consoleReader.readLine();
                    arrayList.add(line.replace(olddata, newdata));
                    logger.log(Level.INFO,"File Update Successfully.");
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
            e.printStackTrace();
        }
    }

    public static void Findproduct() throws IOException {
        logger.log(Level.INFO,"-----Find Product------\n");
        logger.log(Level.INFO,"enter the Name of the product: ");
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
                    break;
                } else {
                    output = "Not found";
                }
            }
            logger.log(Level.INFO,output);
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
                    String p = arr[5];
                    countyes(Integer.parseInt(p));
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO,"lmlm");
            e.printStackTrace();
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
                    String p = arr[5];
                    countno(Integer.parseInt(p));
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO,"lmlm");
            e.printStackTrace();
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
                logger.log(Level.INFO,"open the Financial file to show the state of money ^_^ ");
            } catch (IOException e) {
                e.printStackTrace();
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
                    logger.log(Level.INFO,line);
                    idtest=arr[7];
                    Customer.gettemail();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Distribute(ArrayList<String> workerarray) throws IOException {
            String distributeP[] = null;
            String distributeW[] = null;
        logger.log(Level.INFO,"\tenter the ID of the product:\t ");
            int idproduct =Integer.parseInt(input.nextLine());
            idprodis=idproduct;
            String output = null;
                 String information ;
                StringBuilder sb = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(WORKWRFILE));
                String line2;
                FileInputStream fin = new FileInputStream(productfile);
                Scanner sci = new Scanner(fin);
                while (sci.hasNextLine()) {
                    String Line = sci.nextLine();

                    distributeP = Line.split(" , ");
                    if (distributeP[0].equalsIgnoreCase(String.valueOf(idproduct))) {
                        logger.log(Level.INFO,"\tenter the ID of the Worker:\t ");
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
                                logger.log(Level.INFO,information);
                                logger.log(Level.INFO,"the statue of product : \t in treatment");
                            } else {
                                workerarray.add(line2);
                            }
                        }
                    }
                }
                       try {
                    FileWriter writer = new FileWriter(WORKWRFILE);
                    for (int i = 0; i < workerarray.size(); i++) {
                        writer.append(workerarray.get(i));
                        writer.append("\n");
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
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
            logger.log(Level.INFO,"--------------------the list of product--------------------");

            while ((line = reader.readLine()) != null) {
                logger.log(Level.INFO,line);
            }
            logger.log(Level.INFO,"------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
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
            bufferedInputStream.close();
            fileInputStream.close();
            logger.log(Level.INFO,stringBuilder.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
