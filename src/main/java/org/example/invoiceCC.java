package org.example;

public class invoiceCC {
    public String Coname;
    public String Caname;
    public String addressi;
    public String pricei;
    public String datei;
    public invoiceCC(){

    }
    public void setinvoice(String customername, String carpetpname, String address, String price, String date) {
        this.Coname=customername;
        this.Caname=carpetpname;
        this.addressi=address;
        this.pricei=price;
        this.datei=date;
    }
}
