package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.INVOICECC;
import org.junit.Test;
import java.io.*;
import static org.example.INVOICECC.*;
import static org.example.Product.PRODUCTFILE;
import static org.junit.Assert.assertEquals;
public class printinvoivejj {

    INVOICECC invoice =new INVOICECC();
    @Given("i entered id of product")
    public void i_entered_id_of_product() throws IOException {
        testADD();
    }
    @Then("Calculate the price")
    public void calculate_the_price() {
        Integer a=180;
        Integer e;


    }
    @Then("print the invoice")
    public void print_the_invoice() {


    }
    @Test
    public void testADD() {
        int id = 2432;
        Boolean actual = null;
        Boolean expected =true;
        String[] findid ;
        while (true) {
            try {
                BufferedReader reader=new BufferedReader(new FileReader(PRODUCTFILE));
                String linetest;
                while ((linetest=reader.readLine())!=null) {
                    findid = linetest.split(" , ");
                    if (findid[0].startsWith(String.valueOf(id)))
                        actual = true;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            assertEquals(expected,actual);
        }
    }
}
