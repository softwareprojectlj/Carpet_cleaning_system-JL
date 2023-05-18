package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Product;

import static org.junit.Assert.assertEquals;

public class RecordProduct {
    Product p=new Product();
    @Given("that I Choose add a new product")
    public void that_i_choose_add_a_new_product() {
        p.writeproduct(4242,"jana","5","7.9","3/6/2023",80,"waiting",2384,"No");
        String width="180";
        String hieht="2";
        Integer pricec= p.getprice(width,hieht);
        Integer plast=  p.applyDiscount(pricec);
        Integer exactprice= 380;
        Integer exact= 342;
        assertEquals(pricec,exactprice);
        assertEquals(plast,exact);


    }

    @Then("the product added successfully")
    public void the_product_added_successfully() {
         p.getAllproduct();
    }
}