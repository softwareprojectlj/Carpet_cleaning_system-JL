package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Product;
import java.util.ArrayList;


public class testMain {
    Product pmaiN=new Product();
    ArrayList<String> arraymain = new ArrayList<String>();
    @Given("show product menu")
    public void show_product_menu() {
       pmaiN.getAllproduct();
    }
    @Then("enter update")
    public void enter_update() {
        String old= String.valueOf(5);
        String newd = String.valueOf(8);
     pmaiN.updateproduct(arraymain,8424,old,newd);
    }
    @Then("enter add")
    public void enter_add() {
pmaiN.readfromuserp(1234,"lemaratest","7.8","2","30/5/2023",7654,"Yes");
    }
    @Then("enter delete")
    public void enter_delete() {
        String iddeletej="3324";
       pmaiN.deleteRecordproById(arraymain,iddeletej);
    }
    @Then("enter Find")
    public void enter_find() {
        String namefind="carpet2";
    pmaiN.findproductbyname(namefind);
    }
}
