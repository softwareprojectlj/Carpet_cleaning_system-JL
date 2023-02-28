package org.example;

import java.text.SimpleDateFormat;

public class Product {

    private String name;
    //private String picture;
    private double height;
    private double width;

    private int dayfinish;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    public Product() {
    }

    public void setdata(String name, double height, double width, int d) {
        this.name=name;
       // this.picture=pic;
        this.height=height;
        this.width=width;
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(d);
        this.dayfinish=d;
        System.out.println("jana");
    }
}
