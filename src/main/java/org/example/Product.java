package org.example;

import java.text.SimpleDateFormat;

public class Product {

     public String id;
     public String name;
    //private String picture;
    public String height;
    public String width;

    public String dayfinish;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    public Product() {
    }

    public int checkid(String idp) {
        if(idp.equals("123"))
        {return 1;}
        return 0;
    }


    public void setdata(String id, String namep, String H , String W, String day, String s4) {
        this.id=id;
        this.name=namep;
        this.height=H;
        this.width=W;
        this.dayfinish=day;
    }
}
