package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.invoiceCC;

public class invoiceC {
  invoiceCC invoice1 ;

    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
     Admin  a = new Admin();
      new Adminlogin(a);
    }

  @When("the admin entered  invoice with correct Data")
  public void the_admin_entered_invoice_with_correct_data() {
      //invoice1.setinvoice("jana","carpet1","Tulkarem_barakeh street","30","10/10/2022");
    }

    @Then("the invoice is added in the system")
    public void the_invoice_is_added_in_the_system() {

    }


}
