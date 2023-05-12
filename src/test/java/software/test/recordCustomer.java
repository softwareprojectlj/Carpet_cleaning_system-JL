package software.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Customer;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class recordCustomer {

    Customer customer1=new Customer();
    private static final Logger LOGGER=Logger.getLogger("org.example.RecordCustomer");
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    Boolean actual;
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
    @Test
    public void testADD(){
        customer1.recordcustomer("1","lemara","059821346","Tulkaarem","jsdfgjsdf");
        Boolean expected=true;

    }


    public  void getsuctomer(){
        try {
            File filenamecustomer=new File("customerdata.txt");
            BufferedReader reader=new BufferedReader(new FileReader(filenamecustomer));
            LOGGER.log(Level.INFO,"Please Enter Name Of Customer To Get Customer Data  :");
            String searchKey="lemara";
            String line;
            while ((line=reader.readLine())!=null){
                if( line.contains(searchKey)){
                   // LOGGER.log(Level.INFO,line);
                    actual=true;
                }
            }
        }catch (Exception e){
            LOGGER.log(Level.INFO,String.valueOf(e));
        }
    }
}
