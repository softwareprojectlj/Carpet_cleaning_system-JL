package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Admin;

public class Adminlogin {
    Admin A;
    static boolean loginflag;
    public Adminlogin(Admin j)
    { j= new Admin();}
    @Given("The user is not logged in")
    public void the_user_is_not_logged_in() {
        loginflag = false;
    }

    @Given("the password is {string}")
    public void the_password_is(String pass) {
        A.password=pass;
        if(A.checkpass(pass))
            loginflag=true;
        else if(!A.checkpass(pass))
            loginflag=false;
    }

    @Given("the email is {string}")
    public void the_email_is(String em) {
        A.email=em;
        if(A.checkemail(em))
            loginflag=true;
        else if(!A.checkemail(em))
            loginflag=false;
    }

    @Then("the user login succeeds")
    public void the_user_login_succeeds() {
       loginflag=true;
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
       loginflag=true;
    }
    @Then("the user login fails")
    public void the_user_login_fails() {
        loginflag=false;
    }

    @Then("thw user is not logged in")
    public void thw_user_is_not_logged_in() {
        loginflag=false;
    }


}
