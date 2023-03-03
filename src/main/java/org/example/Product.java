package org.example;


public class Product {

     public String id;
     public String name;
    public String height;
    public String width;
    public String dayfinish;
   //  boolean productflag;
    //String pattern = "yyyy-MM-dd";
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    public Product() {
    }

    public void setData(String id, String namep, String H, String W, String D) {
        this.id=id;
        this.name=namep;
        this.height=H;
        this.width=W;
        this.dayfinish=D;
    }

    /*public int checkid(String idp) {
        if(idp.equals("123"))
        {return 1;}
        return 0;
    }*/

}
