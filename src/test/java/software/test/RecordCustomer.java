package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Customer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecordCustomer {

Customer customer;
String name,address,phone;
boolean added;
    @Given("the customer not recorded")
    public void the_customer_not_recorded() {
        customer=new Customer();
        added=false;
    }

    @When("I entered the correct data")
    public void i_entered_the_correct_data() {
        customer.setData(name,address,phone);
    }

    @Then("the customer added successfully")


    public void the_customer_added_successfully() {
        assertTrue(customer.isValid());
        customer.record();
        System.out.println("Done");

    }

}
