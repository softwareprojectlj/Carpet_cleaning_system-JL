package org.example;


public class Product {

     public String id;
     public String name;
    public String height;
    public String width;
    public String dayfinish;
    public Product() {
        id="";
        name="";
        height="";
        width="";
        dayfinish="";
    }

    public void setData(String id, String namep, String H, String W, String D) {
        this.id=id;
        this.name=namep;
        this.height=H;
        this.width=W;
        this.dayfinish=D;
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

    /*public int checkid(String idp) {
        if(idp.equals("123"))
        {return 1;}
        return 0;
    }*/

}
