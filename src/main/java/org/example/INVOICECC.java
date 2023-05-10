package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.Product.PRODUCTFILE;


public class INVOICECC {
    Integer price;
    private String nameCO;
    private String nameCA;
    private String addressinvoice;
    private String priceinvoice;
    private String dateinvoive;
    public static final String INVOICEFILE = "invoice.txt";
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static Logger logger = Logger.getLogger("org.example.INVOICECC");
    private String width;
    private String height;
    public INVOICECC() {
    }
    public String getCOname() {
        return nameCO;
    }
    public void setCOname(String coname) {
        nameCO = coname;
    }
    public String getCAname() {
        return nameCA;
    }
    public void setCAname(String caname) {
        nameCA = caname;
    }
    public String getAddressinvoice() {
        return addressinvoice;
    }
    public void setAddressinvoice(String addressi) {
        this.addressinvoice = addressi;
    }
    public String getPriceinvoice() {
        return priceinvoice;
    }
    public void setPriceinvoice(String pricei) {
        this.priceinvoice = pricei;
    }
    public String getdateinvoice() {
        return dateinvoive;
    }
    public void setDateinvoice(String datei) {
        this.dateinvoive = datei;
    }
    public INVOICECC(String nameCOO, String nameCAA, String addressi, String pricei, String datei) {
        nameCO = nameCOO;
        nameCA = nameCAA;
       addressinvoice = addressi;
       priceinvoice = pricei;
        dateinvoive = datei;
    }
    public void readfromuser() throws IOException {
        logger.log(Level.INFO,"Enter Your Product Id:");
        int idinvoice = Integer.parseInt(input.nextLine());
        printinvoice(idinvoice);
    }
  public void printinvoice(int id) throws IOException {
      String []data=null;
      while(true) {
          FileWriter writer = new FileWriter(INVOICEFILE, true);
          FileInputStream fin = new FileInputStream(PRODUCTFILE);
          String output = "this product is not available";
          Scanner sci = new Scanner(fin);
          while (sci.hasNextLine()) {
              String line = sci.nextLine();
        data = line.split(" , ");
        if (data[0].startsWith(String.valueOf(id))) {
            String infoemation ;
            if(getprice(data[2], data[3])>=250)
            {
                int pd=getprice(data[2], data[3]);
                 infoemation = "Product Name :\t" + data[1] + "\n" +"Type of product : \t"+data[4]+"\n"+ "day delivered :\t" + data[5] + "\n You have a discount equal 10% because your price > 250 ^-^ :" +applyDiscount(pd)+"\n";
                output = infoemation;
            }
            else {
                 infoemation = "Product Name :\t" + data[1] + "\n" + "Price :\t" + getprice(data[2], data[3]) +"\n"+ "Type of product : \t"+data[4]+"\n" + "day delivered :\t" + data[5] + "\n-------------------------------------------------------------------------------" + "\n";
                output = infoemation;}
        }

    }
                    writer.append(output);
                    writer.append("\n");
                    writer.close();
          logger.log(Level.INFO,output);
          logger.log(Level.INFO,"invoice ready!");
                    break;
}
                }
public Integer getprice(String w,String h)
        {
        this.width=w;
        this.height=h;
        Double area=(Double.valueOf(w) * Double.valueOf(h));
        if(area<25 && area>0 )
        price=200;
         else  if(area<=5 && area>0 )
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
        price=450;
        return price;
        }
public double applyDiscount(Integer pricedis) {
        this.price=pricedis;
        if (pricedis > 250) {
        double discount = pricedis * 0.1;
        return pricedis - discount;
        } else {
        return pricedis;
        }
        }

        }