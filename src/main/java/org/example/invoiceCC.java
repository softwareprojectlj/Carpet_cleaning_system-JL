package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.example.Product.productfile;


public class invoiceCC {
    public String Coname;
    public String Caname;
    public String addressi;
    public String pricei;
    public String datei;
    public static String invoicefile = "invoice.txt";
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private String width;
    private String height;

    public invoiceCC() {
    }

    public String getConame() {
        return Coname;
    }

    public void setConame(String coname) {
        Coname = coname;
    }

    public String getCaname() {
        return Caname;
    }

    public void setCaname(String caname) {
        Caname = caname;
    }

    public String getAddressi() {
        return addressi;
    }

    public void setAddressi(String addressi) {
        this.addressi = addressi;
    }

    public String getPricei() {
        return pricei;
    }

    public void setPricei(String pricei) {
        this.pricei = pricei;
    }

    public String getDatei() {
        return datei;
    }
    public void setDatei(String datei) {
        this.datei = datei;
    }
    public invoiceCC(String Coname, String Caname, String addressi, String pricei, String datei) {
        this.Coname = Coname;
        this.Caname = Caname;
        this.addressi = addressi;
        this.pricei = pricei;
        this.datei = datei;
    }
    public void readfromuser() throws IOException {
        System.out.println("Enter Your Product Id:");
        int idinvoice = Integer.parseInt(input.nextLine());
        printinvoice(idinvoice);
    }
    public void printinvoice(int id) throws IOException {
        String []data=null;
                while(true) {
                    FileWriter writer = new FileWriter(invoicefile, true);
                    FileInputStream fin = new FileInputStream(productfile);
                    String output = "this product is not available";
                    Scanner sci = new Scanner(fin);

                    while (sci.hasNextLine()) {
                        String Line = sci.nextLine();
                        Line.trim();
                        data = Line.split(" , ");
                        if (data[0].startsWith(String.valueOf(id))) {
                            String infoemation = "Product Name :\t" + data[1] + "\n" + "Price :\t" + getprice(data[2], data[3]) + "\n" + "day delivered :\t" + data[4] + "\n-------------------------------------------------------------------------------" + "\n";
                            output = infoemation;
                        }
                        }
                    writer.append(output);
                    writer.append("\n");
                    writer.close();
                    System.out.println("invoice ready!");
                    break;
                    }
                }
    public Integer getprice(String w,String h)
    {
        Integer price;
        this.width=w;
        this.height=h;
        Double area=(Double.valueOf(w) * Double.valueOf(h));
        if(area<25 && area>0 )
            price=200;
        else
            price=450;
        return price;
    }

}
