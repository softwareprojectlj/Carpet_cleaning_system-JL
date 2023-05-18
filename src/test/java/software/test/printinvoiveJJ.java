package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.INVOICECC;
import org.junit.Test;
import java.io.*;
import static org.example.Product.writef;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class printinvoiveJJ {
    INVOICECC invoice = new INVOICECC();
    @Given("i entered id of product")
    public void i_entered_id_of_product()  {

    }
    @Test
    @Then("Calculate the price")
    public void calculate_the_price() {
        String width="180";
        String hieht="2";
      Integer pricec=  invoice.getprice(width,hieht);
      Integer plast= (int) invoice.applyDiscount(pricec);
      Integer exactprice= 380;
        Integer exact= 342;
      assertEquals(pricec,exactprice);
      assertEquals(plast,exact);
    }
    @Test
    @Then("print the invoice")
    public void print_the_invoice() throws IOException {
        invoice.printinvoice(2432);
    }
    @Test
    @Given("print total paid")
    public void print_total_paid() {

        writef();
        assertTrue(true);
    }

}
