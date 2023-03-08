package org.example;

public class Customer {
    private String name;
    private String address;
    private String phone;


    public void setData(String name, String address,String phone) {
        this.name=name;
        this.address=address;

        this.phone=phone;
    }

    public boolean isValid() {
        return true;
    }

    public void record() {



    }
}



