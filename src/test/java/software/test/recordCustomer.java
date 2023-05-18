package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Customer;
public class recordCustomer {
    Customer customer1=new Customer();

    @Given("that I Choose the new customer registration option")
    public void that_i_choose_the_new_customer_registration_option() {
        customer1.recordcustomer("1","lemara","059821346","Tulkaarem","jsdfgjsdf");
    }


    @When("I entered the correct information")
    public void i_entered_the_correct_information() {


    }


    @Then("the customer added successfully")
    public void the_customer_added_successfully() {

    }

    @Then("Send an acceptance email to the customer")
    public void send_an_acceptance_email_to_the_customer() {
    }
}
