package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Product;

public class RecordProduct {
    Product p=new Product();
    @Given("that I Choose add a new product")
    public void that_i_choose_add_a_new_product() {
p.writeproduct(4242,"jana","5","7.9","3/6/2023",80,"waiting",2384,"No");
    }

    @Then("the product added successfully")
    public void the_product_added_successfully() {

    }
}