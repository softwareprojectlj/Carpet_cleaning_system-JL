package org.example;
public class Admin {

    public String password;
    public String email;

    public Admin(){
      password="";
      email="";
    }
    public boolean checkpass(String pass) {
        if(pass.equals(password))
        {return true;}
            return false;
    }

    public boolean checkemail(String em) {
       if(em.equals(email))
       { return  true;}
       return false;

    }

}
