package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invoiceC {
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {

    }

    @Given("there is a invoice with {string} ,{string} ,{string},{string} ,{string}")
    public void there_is_a_invoice_with(String Customername, String Carpetpname, String address, String price, String Date) {

    }

    @When("the invoice is added in the system")
    public void the_invoice_is_added_in_the_system() {

    }

    @Then("the invoice with {string} ,{string} ,{string},{string} ,{string} is contained in the system")
    public void the_invoice_with_is_contained_in_the_system(String Customername, String Carpetpname, String address, String price, String Date) {

    }
}
