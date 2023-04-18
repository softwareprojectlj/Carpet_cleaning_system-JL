package org.example;
public class Admin {

    public String password;
    public String email;
    private boolean logadmin=false;
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

    public boolean adminloggedin() {
        return logadmin;
    }
    public boolean adminloginp(String passwordA) {
        logadmin=true;
        return true;
    }

    public boolean adminlogine(String emailA) {
        logadmin=true;
        return true;
    }
}
