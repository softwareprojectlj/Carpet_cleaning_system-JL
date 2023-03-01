package software.test;

import io.cucumber.core.cli.Main;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Product;

public class RecordProduct {
    Product product;
    static boolean productflag;
    static boolean  userflag;
    @Given("that the user is logged in")
    public void that_the_user_is_logged_in() {
         userflag=true;
    }

    @Given("their is a product with id {string} ,name {string},height\"{double}\",width\"{int}\",recevdata \"{int}\\/{int}\\/{int}\",picture\"{int}\"")
    public void their_is_a_product_with_id_name_height_width_recevdata_picture(String string, String string2, String double1, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
     product.setdata("123","janacarpet","1.2","2","15/10/2022","1");
    }

    @When("the product with id {string} register")
    public void the_product_with_id_register(String idp) {
        product.id=idp;
        if(product.checkid(idp) == 1)
           productflag=true;
        else if(product.checkid(idp) == 0)
            productflag=false;
    }

    @Then("the product with id {string} ,name {string},height\"{double}\",width\"{int}\",recevdata \"{int}\\/{int}\\/{int}\",picture\"{int}\" is registered in the system")
    public void the_product_with_id_name_height_width_recevdata_picture_is_registered_in_the_system(String string, String string2, Double double1, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
    productflag=true;
    }


}
