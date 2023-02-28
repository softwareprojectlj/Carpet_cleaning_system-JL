package software.test;

import io.cucumber.core.cli.Main;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.Product;

public class RecordProduct {
    Product product;
    @Given("i choose add carpet")
    public void i_choose_add_carpet() {
        // Write code here that turns the phrase above into concrete actions

        throw new io.cucumber.java.PendingException();
    }

    @When("customer record all information")
    public void customer_record_all_information() {
        product.setdata("jana",2.13,1.12,6/11/2002);
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
