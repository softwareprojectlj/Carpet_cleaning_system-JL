package org.example;

public class Admin {

    public String password;
    public String email;
    public Admin(){

    }
    public Admin(Admin admin){
       this.password= admin.password;
       this.email= admin.email;
    }
    public int checkpass(String pass) {
        if(pass.equals("123"))
        {return 1;}
        return 0;
    }

    public int checkemail(String em) {
       if(em.equals("sbarakeh15@gmail.com"))
       {
           return  1;}
       return 0;

    }

}
