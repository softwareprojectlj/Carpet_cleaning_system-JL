package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.example.Main.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Product {
    int price;
    public static final  String WORKWRFILE = "Worker.txt";
    public static final String PRODUCTFILE = "product.txt";
    private static final Logger logger = Logger.getLogger("org.example.Product");
    private int productID;

    private String productNAME;
    static String idtest;
    private String productHEIGHT;
    private String productWIDTH;
    private String prodcutDFINISH;
    private int productPRICE;
    private String productSTATE;
    private static int priceyes;
    private static int priceno;
    private String prizstate;
    private int custmorID;

    public Product(int id, String namep, String hP, String wP, String dP, int p, String s, int idcu, String pstate) {
        productID = id;
        productNAME = namep;
        productHEIGHT = hP;
        productWIDTH = wP;
        prodcutDFINISH = dP;
        productPRICE = p;
        productSTATE = s;
        custmorID = idcu;
        prizstate = pstate;
    }

    public String getUserData() {
        return productID + " , " + productNAME + " , " + productHEIGHT + " , " + productWIDTH + " , " + prodcutDFINISH + " , " + productPRICE + " , " + productSTATE + " , " + custmorID + " , " + prizstate;
    }

    public void readfromuserp(int idr,String namer,String hR,String wR,String dayr, int idcust,String pstate) {
        String statep = "waiting";
        int pp = getprice(wR, hR);
        int priced = applyDiscount(pp);
        writeproduct(idr, namer, hR, wR, dayr, priced, statep, idcust, pstate);
    }

    public Product() {
    }

    public void writeproduct(int id, String name, String height, String width, String dayfinish, int price, String statep, int idcust, String pstate) {
        Product p = new Product(id, name, height, width, dayfinish, price, statep, idcust, pstate);

        try {
            FileWriter writer = new FileWriter(PRODUCTFILE, true);
            writer.append(p.getUserData());
            writer.append("\n");
            writer.close();
            logger.log(Level.INFO, "product added successfully!");
            logger.log(Level.INFO, "the statue of product : \t Waiting");
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public void deleteRecordproById(List<String> arrayList,String searchKey) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[0].contains(searchKey)) {
                    logger.log(Level.INFO, line);
                } else {
                    arrayList.add(line);
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
        try {
            FileWriter writer = new FileWriter(PRODUCTFILE);
            for (var item : arrayList) {
                writer.append(item);
                writer.append("\n");
            }
            writer.close();

        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        } finally {
            logger.log(Level.INFO, YELLOW + "Product Deleted Successfully." + RESET);
        }
    }


    public void updateproduct(List<String> arrayList,int idjana,String olddata,String newdata) {
        try {
            String[] update;
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            logger.log(Level.INFO, "-----Update Product------\n");
            logger.log(Level.INFO, "enter the ID of the product:");
          //  int id = input.nextInt();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

                update = line.split(" , ");
                if (update[0].equalsIgnoreCase(String.valueOf(idjana))) {
                    arrayList.add(line.replace(olddata, newdata));
                    logger.log(Level.INFO, "File Update Successfully.");
                } else {

                    arrayList.add(line);
                }
            }
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
        try {
            FileWriter writer = new FileWriter(PRODUCTFILE);
            for (var item : arrayList) {
                writer.append(item);
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public void findproductbyname(String searchKey) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchKey)) {
                    logger.log(Level.INFO, line);
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }

    }

    public static void countyes(int r) {

        priceyes = priceyes + r;
    }

    public static void stateprizeyes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String sprizeflag = "yes";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[8].contains(sprizeflag)) {
                    String p = arr[5];
                    countyes(Integer.parseInt(p));
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "lmlm");
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public static void countno(int r) {
        priceno = priceno + r;
    }

    public static void stateprizeno() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String sprizeflag = "no";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[8].contains(sprizeflag)) {
                    String p = arr[5];
                    countno(Integer.parseInt(p));
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "lmlm");
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public static void writef() {

        stateprizeyes();
        stateprizeno();

        try {
            FileWriter writer = new FileWriter(fileFinancial, true);
            writer.write("total cash :" + priceyes + "\n" +
                    "total paid :" + priceyes + "\n");
            writer.close();
            logger.log(Level.INFO, "open the Financial file to show the state of money ^_^ ");
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public static void compliteflag() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String stateflag = "complete";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" , ");
                if (arr[6].contains(stateflag)) {
                    logger.log(Level.INFO, line);
                    idtest = arr[7];
                    customer.gettemail();
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public void distribute(List<String> workerarray, int idproduct,int idworker) throws IOException {
        String[] distributeP;
        String[] distributeW;
        String information;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(WORKWRFILE));
        String line2;
        FileInputStream fin = new FileInputStream(PRODUCTFILE);
        Scanner sci = new Scanner(fin);
        while (sci.hasNextLine()) {
            String line = sci.nextLine();
            distributeP = line.split(" , ");
            if (distributeP[0].equalsIgnoreCase(String.valueOf(idproduct))) {
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
                        logger.log(Level.INFO, information);
                        logger.log(Level.INFO, "the statue of product : \t in treatment");
                    } else {
                        workerarray.add(line2);
                    }
                }
            }
        }
        try {
            FileWriter writer = new FileWriter(WORKWRFILE);
            for (var item : workerarray) {
                writer.append(item);
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public void raya(Integer idupdd) {
        ArrayList<String> productpp = new ArrayList<>();
        try {
            FileReader fr = new FileReader(PRODUCTFILE);
            BufferedReader br = new BufferedReader(fr);
            String[] updatestate;
            String line;
            while ((line = br.readLine()) != null) {

                updatestate = line.split(" , ");
                if (updatestate[0].equalsIgnoreCase(String.valueOf(idupdd))) {
                    String[] parts = line.split(" , ");
                    parts[6] = "in treatment";
                    String newline = String.join(" , ", parts);
                    productpp.add(newline);
                } else {
                    productpp.add(line);
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
        try {
            FileWriter writer = new FileWriter(PRODUCTFILE);
            for (var item : productpp) {
                writer.append(item);
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public Integer getprice(String w, String h) {
        productWIDTH = w;
        productHEIGHT = h;
        Double area = (Double.parseDouble(productHEIGHT) * Double.parseDouble(productWIDTH));
        if (area <= 5 && area > 0)
            price = 40;
        else if (area <= 15 && area > 5)
            price = 80;
        else if (area <= 25 && area > 15)
            price = 130;
        else if (area <= 45 && area > 25)
            price = 180;
        else if (area <= 65 && area > 45)
            price = 230;
        else if (area <= 85 && area > 65)
            price = 270;
        else if (area <= 110 && area > 85)
            price = 320;
        else
            price = 380;
        return price;
    }

    public Integer applyDiscount(Integer pricedis) {
        this.price = pricedis;
        if (pricedis > 250) {
            double discount = pricedis * 0.1;
            return (int) (pricedis - discount);
        } else {
            return pricedis;
        }
    }

    public void getAllproduct() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRODUCTFILE));
            String line;
            logger.log(Level.INFO, "--------------------the list of product--------------------");

            while ((line = reader.readLine()) != null) {
                logger.log(Level.INFO, line);
            }
            logger.log(Level.INFO, "------------------------------------------------------------");
        } catch (Exception e) {
            logger.log(Level.INFO, String.valueOf(e));
        }

    }

    public void listofworker() {
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
            String valueOF = String.valueOf(stringBuilder);
            logger.log(Level.INFO, valueOF);
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
    }

    public Boolean check(Integer idupdd) {
        Boolean checkp = true;
        try {
            FileReader fr = new FileReader(PRODUCTFILE);
            BufferedReader br = new BufferedReader(fr);
            String[] updatestate;
            String line;
            while ((line = br.readLine()) != null) {

                updatestate = line.split(" , ");
                if (updatestate[0].equalsIgnoreCase(String.valueOf(idupdd))) {
                    if (updatestate[6].equals("in treatment"))
                        checkp= true;
                }
            }
        } catch (IOException e) {
            logger.log(Level.INFO, String.valueOf(e));
        }
       return  checkp;
    }

}
