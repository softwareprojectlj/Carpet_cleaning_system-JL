package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.Product;



public class RecordProduct {
    Product product;
    boolean productflag;

    @Given("the product not record")
    public void the_product_not_record() {
       productflag = false;
        product = new Product();

    }
    @When("I entered the correct data")
    public void i_entered_the_correct_data() {
        System.out.println("add new product");
    product.setData("1","carpet1","2.2","3","10/10/2002");

    }
    @Then("the product added Successfully")
    public void the_product_added_successfully() {
        System.out.println("product added");
        productflag = true;
    }



}
