package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Admin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Adminlogin {
    private Admin A = new Admin();
    private String passwordA;
    private String emailA;
    static boolean loginflag;

    @Given("The user is not logged in")
    public void the_user_is_not_logged_in() {
        assertFalse(A.adminloggedin());
        loginflag = false;
    }

    @Given("the password is {string}")
    public void the_password_is(String pass) {
        this.passwordA=pass;
        A.password=pass;
        if(A.checkpass(pass))
            loginflag=true;
        else if(!A.checkpass(pass))
            loginflag=false;
    }

    @Given("the email is {string}")
    public void the_email_is(String em) {
        this.emailA=em;
        A.email=em;
        if(A.checkemail(em))
            loginflag=true;
        else if(!A.checkemail(em))
            loginflag=false;
    }

    @Then("the user login succeeds")
    public void the_user_login_succeeds() {
        assertTrue(A.adminloginp(passwordA));
        assertTrue(A.adminlogine(emailA));
        loginflag=true;
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assertTrue(A.adminloggedin());
        loginflag=true;
    }
    @Then("the user login fails")
    public void the_user_login_fails() {
        loginflag=false;
    }

    @Then("the user is not logged in")
    public void thw_user_is_not_logged_in() {
        loginflag=false;
    }


}
